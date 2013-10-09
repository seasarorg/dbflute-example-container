package com.example.dbflute.cdi.dbflute.topic;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.inject.Inject;

import org.junit.Test;
import org.seasar.dbflute.cbean.ListResultBean;
import org.seasar.dbflute.exception.EntityAlreadyUpdatedException;
import org.seasar.dbflute.util.DfCollectionUtil;
import org.seasar.junitcdi.jta.Transactional;

import com.example.dbflute.cdi.dbflute.cbean.MemberCB;
import com.example.dbflute.cdi.dbflute.exbhv.MemberBhv;
import com.example.dbflute.cdi.dbflute.exbhv.PurchaseBhv;
import com.example.dbflute.cdi.dbflute.exbhv.pmbean.SimpleMemberPmb;
import com.example.dbflute.cdi.dbflute.exentity.Member;
import com.example.dbflute.cdi.dbflute.exentity.Purchase;
import com.example.dbflute.cdi.dbflute.exentity.customize.SimpleMember;
import com.example.dbflute.cdi.unit.ContainerTestCase;

/**
 * @author jflute
 * @since 0.9.5.1 (2009/06/20 Saturday)
 */
public class ThreadSafeTest extends ContainerTestCase {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    @Inject
    private MemberBhv memberBhv;
    @Inject
    private PurchaseBhv purchaseBhv;

    // ===================================================================================
    //                                                                       ConditionBean
    //                                                                       =============
    @Test
    @Transactional
    public void test_conditionBean_threadSafe_sameExecution_Tx() {
        final ExecutionCreator<List<Member>> creator = new ExecutionCreator<List<Member>>() {
            public Execution<List<Member>> create() {
                return new Execution<List<Member>>() {
                    public List<Member> execute() {
                        // ## Arrange ##
                        final MemberCB cb = new MemberCB();
                        cb.setupSelect_MemberStatus();
                        cb.query().setMemberName_PrefixSearch("S");
                        cb.query().addOrderBy_Birthdate_Desc().addOrderBy_MemberId_Asc();

                        // ## Act ##
                        final ListResultBean<Member> memberList = ThreadSafeTest.this.memberBhv.selectList(cb);

                        // ## Assert ##
                        assertFalse(memberList.isEmpty());
                        for (final Member member : memberList) {
                            assertTrue(member.getMemberName().startsWith("S"));
                        }
                        return memberList;
                    }
                };
            }
        };
        for (int i = 0; i < 5; i++) {
            this.fireSameExecution(creator);
        }
    }

    // ===================================================================================
    //                                                                          OutsideSql
    //                                                                          ==========
    @Test
    @Transactional
    public void test_outsideSql_threadSafe_sameExecution_Tx() {
        final ExecutionCreator<List<SimpleMember>> creator = new ExecutionCreator<List<SimpleMember>>() {
            public Execution<List<SimpleMember>> create() {
                return new Execution<List<SimpleMember>>() {
                    public List<SimpleMember> execute() {
                        // ## Arrange ##
                        final String path = MemberBhv.PATH_selectSimpleMember;

                        final SimpleMemberPmb pmb = new SimpleMemberPmb();
                        pmb.setMemberName_PrefixSearch("S");

                        final Class<SimpleMember> entityType = SimpleMember.class;

                        // ## Act ##
                        final List<SimpleMember> memberList = ThreadSafeTest.this.memberBhv.outsideSql().selectList(
                                path, pmb, entityType);

                        // ## Assert ##
                        assertFalse(memberList.isEmpty());
                        ThreadSafeTest.this.log("{SimpleMember}");
                        for (final SimpleMember entity : memberList) {
                            final Integer memberId = entity.getMemberId();
                            final String memberName = entity.getMemberName();
                            final String memberStatusName = entity.getMemberStatusName();
                            ThreadSafeTest.this.log("    " + memberId + ", " + memberName + ", " + memberStatusName);
                            assertNotNull(memberId);
                            assertNotNull(memberName);
                            assertNotNull(memberStatusName);
                            assertTrue(memberName.startsWith("S"));
                        }
                        return memberList;
                    }
                };
            }
        };
        for (int i = 0; i < 5; i++) {
            this.fireSameExecution(creator);
        }
    }

    // ===================================================================================
    //                                                                              Update
    //                                                                              ======
    @Test
    @Transactional
    public void test_update_threadSafe_sameExecution() { // uses original transactions
        final int memberId = 3;
        final Member before = this.memberBhv.selectByPKValue(memberId);
        final Long versionNo = before.getVersionNo();
        final Set<String> markSet = DfCollectionUtil.newHashSet();
        final ExecutionCreator<List<Member>> creator = new ExecutionCreator<List<Member>>() {
            public Execution<List<Member>> create() {
                return new Execution<List<Member>>() {
                    public List<Member> execute() {
                        ThreadSafeTest.this.prepareAccessContextOnThread();
                        final TransactionResource transaction = ThreadSafeTest.this.beginNewTransaction();
                        try {
                            final long threadId = Thread.currentThread().getId();
                            final Purchase purchase = new Purchase();
                            purchase.setMemberId(3);
                            final long currentMillis = ThreadSafeTest.this.currentTimestamp().getTime();
                            final long keyMillis = currentMillis - (threadId * 10000000);
                            purchase.setPurchaseDatetime(new Timestamp(keyMillis));
                            purchase.setPurchaseCount(1234);
                            purchase.setPurchasePrice(1234);
                            purchase.setPaymentCompleteFlg_True();
                            purchase.setProductId(3);
                            ThreadSafeTest.this.purchaseBhv.insert(purchase);
                            // deadlock does not occur on H2
                            final Member member = new Member();
                            member.setMemberId(memberId);
                            member.setVersionNo(versionNo);
                            ThreadSafeTest.this.memberBhv.update(member);
                            markSet.add("success: " + threadId);
                        } finally {
                            transaction.commit();
                        }
                        return DfCollectionUtil.emptyList();
                    }
                };
            }
        };
        try {
            for (int i = 0; i < 5; i++) {
                try {
                    this.fireSameExecution(creator);
                } catch (final ThreadFireException e) {
                    final Throwable cause = e.getCause();
                    this.log(cause.getMessage());
                    if (cause instanceof EntityAlreadyUpdatedException) {
                        // OK
                        return;
                    }
                    throw e;
                }
            }
            fail();
        } finally {
            this.log(markSet);
        }
    }

    // ===================================================================================
    //                                                                       Assist Helper
    //                                                                       =============
    private <RESULT> void fireSameExecution(final ExecutionCreator<RESULT> creator) {
        // ## Arrange ##
        final ExecutorService service = Executors.newCachedThreadPool();
        final int threadCount = 10;
        final CountDownLatch ready = new CountDownLatch(threadCount);
        final CountDownLatch start = new CountDownLatch(1);
        final CountDownLatch goal = new CountDownLatch(threadCount);
        final Execution<RESULT> execution = creator.create();
        final List<Future<RESULT>> futureList = new ArrayList<Future<RESULT>>();
        for (int i = 0; i < threadCount; i++) {
            final Future<RESULT> future = service.submit(this.createCallable(execution, ready, start, goal));
            futureList.add(future);
        }

        // ## Act ##
        // Start!
        start.countDown();
        try {
            // Wait until all threads are finished!
            goal.await();
        } catch (final InterruptedException e) {
            final String msg = "goal.await() was interrupted!";
            throw new IllegalStateException(msg, e);
        }
        this.log("All threads are finished!");

        // ## Assert ##
        final List<RESULT> resultList = new ArrayList<RESULT>();
        for (final Future<RESULT> future : futureList) {
            try {
                final RESULT result = future.get();
                assertNotNull(result);
                resultList.add(result);
            } catch (final InterruptedException e) {
                final String msg = "future.get() was interrupted!";
                throw new IllegalStateException(msg, e);
            } catch (final ExecutionException e) {
                final String msg = "Failed to execute!";
                throw new ThreadFireException(msg, e.getCause());
            }
        }
        RESULT preResult = null;
        for (final RESULT result : resultList) {
            this.log(result);
            if (preResult == null) {
                preResult = result;
                continue;
            }
            assertEquals(preResult, result);
        }
    }

    protected static class ThreadFireException extends RuntimeException {
        private static final long serialVersionUID = 1L;

        public ThreadFireException(final String msg, final Throwable e) {
            super(msg, e);
        }
    }

    private static interface ExecutionCreator<RESULT> {
        Execution<RESULT> create();
    }

    private static interface Execution<RESULT> {
        RESULT execute();
    }

    private <RESULT> Callable<RESULT> createCallable(final Execution<RESULT> execution, final CountDownLatch ready,
            final CountDownLatch start, final CountDownLatch goal) {
        return new Callable<RESULT>() {
            public RESULT call() {
                try {
                    ready.countDown();
                    try {
                        start.await();
                    } catch (final InterruptedException e) {
                        final String msg = "start.await() was interrupted!";
                        throw new IllegalStateException(msg, e);
                    }
                    final RESULT result = execution.execute();
                    return result;
                } finally {
                    goal.countDown();
                }
            }
        };
    }
}
