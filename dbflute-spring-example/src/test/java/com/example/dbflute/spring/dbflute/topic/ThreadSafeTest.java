package com.example.dbflute.spring.dbflute.topic;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import org.seasar.dbflute.cbean.ListResultBean;
import org.seasar.dbflute.exception.EntityAlreadyUpdatedException;
import org.seasar.dbflute.unit.core.thread.ThreadFireExecution;
import org.seasar.dbflute.unit.core.thread.ThreadFireOption;
import org.seasar.dbflute.unit.core.thread.ThreadFireResource;
import org.seasar.dbflute.util.DfCollectionUtil;

import com.example.dbflute.spring.dbflute.cbean.MemberCB;
import com.example.dbflute.spring.dbflute.exbhv.MemberBhv;
import com.example.dbflute.spring.dbflute.exbhv.PurchaseBhv;
import com.example.dbflute.spring.dbflute.exbhv.pmbean.SimpleMemberPmb;
import com.example.dbflute.spring.dbflute.exentity.Member;
import com.example.dbflute.spring.dbflute.exentity.Purchase;
import com.example.dbflute.spring.dbflute.exentity.customize.SimpleMember;
import com.example.dbflute.spring.unit.UnitContainerTestCase;

/**
 * @author jflute
 * @since 0.9.5.1 (2009/06/20 Saturday)
 */
public class ThreadSafeTest extends UnitContainerTestCase {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private MemberBhv memberBhv;
    private PurchaseBhv purchaseBhv;

    // ===================================================================================
    //                                                                       ConditionBean
    //                                                                       =============
    public void test_ThreadSafe_conditionBean_sameExecution() {
        threadFire(new ThreadFireExecution<List<Member>>() {
            public List<Member> execute(ThreadFireResource resource) {
                // ## Arrange ##
                MemberCB cb = new MemberCB();
                cb.setupSelect_MemberStatus();
                cb.query().setMemberName_PrefixSearch("S");
                cb.query().addOrderBy_Birthdate_Desc().addOrderBy_MemberId_Asc();

                // ## Act ##
                ListResultBean<Member> memberList = memberBhv.selectList(cb);

                // ## Assert ##
                assertFalse(memberList.isEmpty());
                for (Member member : memberList) {
                    assertTrue(member.getMemberName().startsWith("S"));
                }
                return memberList;
            }
        }, new ThreadFireOption().expectSameResult());
    }

    // ===================================================================================
    //                                                                          OutsideSql
    //                                                                          ==========
    public void test_ThreadSafe_outsideSql_sameExecution() {
        threadFire(new ThreadFireExecution<List<SimpleMember>>() {
            public List<SimpleMember> execute(ThreadFireResource resource) {
                // ## Arrange ##
                String path = MemberBhv.PATH_selectSimpleMember;

                SimpleMemberPmb pmb = new SimpleMemberPmb();
                pmb.setMemberName_PrefixSearch("S");

                Class<SimpleMember> entityType = SimpleMember.class;

                // ## Act ##
                List<SimpleMember> memberList = memberBhv.outsideSql().selectList(path, pmb, entityType);

                // ## Assert ##
                assertNotSame(0, memberList.size());
                log("{SimpleMember}");
                for (SimpleMember entity : memberList) {
                    Integer memberId = entity.getMemberId();
                    String memberName = entity.getMemberName();
                    String memberStatusName = entity.getMemberStatusName();
                    log("    " + memberId + ", " + memberName + ", " + memberStatusName);
                    assertNotNull(memberId);
                    assertNotNull(memberName);
                    assertNotNull(memberStatusName);
                    assertTrue(memberName.startsWith("S"));
                }
                return memberList;
            }
        }, new ThreadFireOption().expectSameResult());
    }

    // ===================================================================================
    //                                                                              Update
    //                                                                              ======
    public void test_ThreadSafe_update_sameExecution() { // uses original transactions
        final int memberId = 3;
        final Member before = memberBhv.selectByPKValue(memberId);
        final Long versionNo = before.getVersionNo();
        final Set<String> markSet = DfCollectionUtil.newHashSet();

        threadFire(new ThreadFireExecution<Void>() {
            public Void execute(ThreadFireResource resource) {
                Member member = new Member();
                member.setMemberId(memberId);
                member.setVersionNo(versionNo);
                memberBhv.update(member);
                final long threadId = Thread.currentThread().getId();
                for (int i = 0; i < 30; i++) {
                    Purchase purchase = new Purchase();
                    purchase.setMemberId(3);
                    long currentMillis = currentTimestamp().getTime();
                    long keyMillis = currentMillis - (threadId * 10000) - (i * 10000);
                    purchase.setPurchaseDatetime(new Timestamp(keyMillis));
                    purchase.setPurchaseCount(1234 + i);
                    purchase.setPurchasePrice(1234 + i);
                    purchase.setPaymentCompleteFlg_True();
                    purchase.setProductId(3);
                    purchaseBhv.insert(purchase);
                }
                markSet.add("success: " + threadId);
                return null;
            }
        }, new ThreadFireOption().commitTx().expectExceptionAny(EntityAlreadyUpdatedException.class));
        log(markSet);
    }

    public void test_ThreadSafe_update_Deadlock() { // uses original transactions
        final int memberId = 3;
        final Member before = memberBhv.selectByPKValue(memberId);
        final Long versionNo = before.getVersionNo();
        final Set<String> markSet = DfCollectionUtil.newHashSet();

        threadFire(new ThreadFireExecution<Void>() {
            public Void execute(ThreadFireResource resource) {
                long threadId = resource.getThreadId();
                Purchase purchase = new Purchase();
                purchase.setMemberId(threadId % 2 == 1 ? 3 : 4);
                purchase.setProductId(threadId % 3 == 1 ? 3 : (threadId % 3 == 2 ? 4 : 5));
                long keyMillis = currentTimestamp().getTime() - (threadId * 1000);
                purchase.setPurchaseDatetime(new Timestamp(keyMillis));
                purchase.setPurchaseCount(1234);
                purchase.setPurchasePrice(1234);
                purchase.setPaymentCompleteFlg_True();
                purchaseBhv.insert(purchase);

                // H2 has no deadlock by this pattern
                Member member = new Member();
                member.setMemberId(memberId);
                member.setVersionNo(versionNo);
                memberBhv.update(member);
                markSet.add("success: " + threadId);
                return null;
            }
        }, new ThreadFireOption().commitTx().expectExceptionAny(EntityAlreadyUpdatedException.class));
        log(markSet);
    }
}
