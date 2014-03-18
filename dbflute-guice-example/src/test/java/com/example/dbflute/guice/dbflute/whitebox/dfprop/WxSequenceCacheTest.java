package com.example.dbflute.guice.dbflute.whitebox.dfprop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.example.dbflute.guice.dbflute.bsentity.dbmeta.MemberDbm;
import com.example.dbflute.guice.dbflute.bsentity.dbmeta.PurchaseDbm;
import com.example.dbflute.guice.dbflute.exbhv.MemberBhv;
import com.example.dbflute.guice.dbflute.exbhv.MemberLoginBhv;
import com.example.dbflute.guice.dbflute.exbhv.ProductBhv;
import com.example.dbflute.guice.dbflute.exbhv.PurchaseBhv;
import com.example.dbflute.guice.dbflute.exentity.Member;
import com.example.dbflute.guice.unit.UnitContainerTestCase;

/**
 * @author jflute
 * @since 0.9.6.1 (2009/11/17 Tuesday)
 */
public class WxSequenceCacheTest extends UnitContainerTestCase {

    private MemberBhv memberBhv;
    private PurchaseBhv purchaseBhv;
    private MemberLoginBhv memberLoginBhv;
    private ProductBhv productBhv;

    // ===================================================================================
    //                                                                              DBMeta
    //                                                                              ======
    public void test_dbmeta() {
        assertTrue(MemberDbm.getInstance().hasSequence());
        assertEquals(Integer.valueOf(10), MemberDbm.getInstance().getSequenceCacheSize());
        assertTrue(PurchaseDbm.getInstance().hasSequence());
        assertEquals(Integer.valueOf(8), PurchaseDbm.getInstance().getSequenceCacheSize());
    }

    // ===================================================================================
    //                                                                      Select NextVal
    //                                                                      ==============
    public void test_selectNextVal_loop_incrementWay() {
        Set<Long> resultSet = new TreeSet<Long>();
        List<Long> resultList = new ArrayList<Long>();
        for (int i = 0; i < 40; i++) {
            Long nextVal = purchaseBhv.selectNextVal();
            resultSet.add(nextVal);
            resultList.add(nextVal);
        }
        log(resultSet);
        assertEquals(40, resultSet.size());
        assertEquals(40, resultList.size());
        assertEquals(Long.valueOf(resultList.get(0) + 39L), resultList.get(39));
    }

    public void test_selectNextVal_loop_batchWay() {
        Set<Integer> resultSet = new TreeSet<Integer>();
        List<Integer> resultList = new ArrayList<Integer>();
        for (int i = 0; i < 40; i++) {
            Integer nextVal = memberBhv.selectNextVal();
            resultSet.add(nextVal);
            resultList.add(nextVal);
        }
        log(resultSet);
        assertEquals(40, resultSet.size());
        assertEquals(40, resultList.size());
        assertEquals(Integer.valueOf(resultList.get(0) + 39), resultList.get(39));
    }

    public void test_selectNextVal_loop_batchWay_divided() {
        Set<Long> resultSet = new TreeSet<Long>();
        List<Long> resultList = new ArrayList<Long>();
        for (int i = 0; i < 40; i++) {
            Long nextVal = memberLoginBhv.selectNextVal();
            resultSet.add(nextVal);
            resultList.add(nextVal);
        }
        log(resultSet);
        assertEquals(40, resultSet.size());
        assertEquals(40, resultList.size());
        assertEquals(Long.valueOf(resultList.get(0) + 39), resultList.get(39));
    }

    public void test_selectNextVal_threadSafe_incrementWay() {
        ExecutionCreator<List<Long>> creator = new ExecutionCreator<List<Long>>() {
            public Execution<List<Long>> create() {
                return new Execution<List<Long>>() {
                    public List<Long> execute() {
                        List<Long> ls = new ArrayList<Long>();
                        for (int i = 0; i < 30; i++) {
                            ls.add(purchaseBhv.selectNextVal());
                        }
                        return ls;
                    }
                };
            }
        };
        StringBuilder sb = new StringBuilder();
        Set<Long> resultAllSet = new TreeSet<Long>();
        for (int i = 0; i < 10; i++) {
            List<List<Long>> resultListList = fireSameExecution(creator);
            for (List<Long> resultList : resultListList) {
                for (Long result : resultList) {
                    if (resultAllSet.contains(result)) {
                        fail("result: " + result);
                    }
                    resultAllSet.add(result);
                }
                sb.append(ln()).append(resultList);
            }
        }
        List<Long> resultAllList = new ArrayList<Long>(resultAllSet);
        Long min = resultAllList.get(0);
        Long max = Long.valueOf(resultAllList.get(resultAllList.size() - 1));
        log("min = " + min + ", max = " + max);
        log(sb.toString());
        assertEquals(3000, resultAllSet.size());
        assertEquals(Long.valueOf(min + (resultAllList.size() - 1)), max);
    }

    public void test_selectNextVal_threadSafe_batchWay() {
        ExecutionCreator<List<Integer>> creator = new ExecutionCreator<List<Integer>>() {
            public Execution<List<Integer>> create() {
                return new Execution<List<Integer>>() {
                    public List<Integer> execute() {
                        List<Integer> ls = new ArrayList<Integer>();
                        for (int i = 0; i < 30; i++) {
                            ls.add(memberBhv.selectNextVal());
                        }
                        return ls;
                    }
                };
            }
        };
        StringBuilder sb = new StringBuilder();
        Set<Integer> resultAllSet = new TreeSet<Integer>();
        for (int i = 0; i < 10; i++) {
            List<List<Integer>> resultListList = fireSameExecution(creator);
            for (List<Integer> resultList : resultListList) {
                for (Integer result : resultList) {
                    if (resultAllSet.contains(result)) {
                        fail("result: " + result);
                    }
                    resultAllSet.add(result);
                }
                sb.append(ln()).append(resultList);
            }
        }
        List<Integer> resultAllList = new ArrayList<Integer>(resultAllSet);
        Integer min = resultAllList.get(0);
        Integer max = Integer.valueOf(resultAllList.get(resultAllList.size() - 1));
        log(sb.toString());
        log("min = " + min + ", max = " + max);
        assertEquals(3000, resultAllSet.size());
        assertEquals(Integer.valueOf(min + (resultAllList.size() - 1)), max);
    }

    public void test_selectNextVal_threadSafe_diffTable_sameSequence_batchWay() {
        ExecutionCreator<Map<String, List<Long>>> creator = new ExecutionCreator<Map<String, List<Long>>>() {
            public Execution<Map<String, List<Long>>> create() {
                return new Execution<Map<String, List<Long>>>() {
                    public Map<String, List<Long>> execute() {
                        Map<String, List<Long>> map = new HashMap<String, List<Long>>();
                        List<Long> loginList = new ArrayList<Long>();
                        List<Long> productList = new ArrayList<Long>();
                        for (int i = 0; i < 30; i++) {
                            loginList.add(memberLoginBhv.selectNextVal().longValue());
                            productList.add(productBhv.selectNextVal().longValue());
                        }
                        map.put("login", loginList);
                        map.put("product", productList);
                        return map;
                    }
                };
            }
        };
        StringBuilder sb = new StringBuilder();
        Set<Long> resultAllSet = new TreeSet<Long>();
        for (int i = 0; i < 10; i++) {
            List<Map<String, List<Long>>> resultListList = fireSameExecution(creator);
            for (Map<String, List<Long>> resultMap : resultListList) {
                List<Long> loginList = resultMap.get("login");
                for (Long result : loginList) {
                    if (resultAllSet.contains(result)) {
                        fail("result: " + result);
                    }
                    resultAllSet.add(result);
                }
                sb.append(ln()).append(loginList);
                List<Long> productList = resultMap.get("product");
                for (Long result : productList) {
                    if (resultAllSet.contains(result)) {
                        fail("result: " + result);
                    }
                    resultAllSet.add(result);
                }
                sb.append(ln()).append(productList);
            }
        }
        List<Long> resultAllList = new ArrayList<Long>(resultAllSet);
        Long min = resultAllList.get(0);
        Long max = Long.valueOf(resultAllList.get(resultAllList.size() - 1));
        log(sb.toString());
        log("min = " + min + ", max = " + max);
        assertEquals(6000, resultAllSet.size());
        assertEquals(Long.valueOf(min + (resultAllList.size() - 1)), max);
    }

    // ===================================================================================
    //                                                                              Insert
    //                                                                              ======
    public void test_insert_basic() {
        {
            // ## Arrange ##
            Member member = new Member();
            member.setMemberName("FOO");
            member.setMemberAccount("FOO");
            member.setMemberStatusCode_Provisional();

            // ## Act ##
            memberBhv.insert(member);

            // ## Assert ##
            log(member);
            Integer memberId = member.getMemberId();
            assertNotNull(memberId);
        }
        {
            // ## Arrange ##
            Member member = new Member();
            member.setMemberName("BAR");
            member.setMemberAccount("BAR");
            member.setMemberStatusCode_Provisional();

            // ## Act ##
            memberBhv.insert(member);

            // ## Assert ##
            log(member);
            Integer memberId = member.getMemberId();
            assertNotNull(memberId);
        }
    }

    public void test_batchInsert_basic() {
        // ## Arrange ##
        List<Member> memberList = new ArrayList<Member>();
        {
            Member member = new Member();
            member.setMemberName("FOO");
            member.setMemberAccount("FOO");
            member.setMemberStatusCode_Provisional();
            memberList.add(member);
        }
        {
            Member member = new Member();
            member.setMemberName("BAR");
            member.setMemberAccount("BAR");
            member.setMemberStatusCode_Provisional();
            memberList.add(member);
        }

        // ## Act ##
        memberBhv.batchInsert(memberList);

        // ## Assert ##
        for (Member member : memberList) {
            log(member);
            Integer memberId = member.getMemberId();
            assertNotNull(memberId);
        }
    }

    // ===================================================================================
    //                                                                       Assist Helper
    //                                                                       =============
    private <RESULT> List<RESULT> fireSameExecution(ExecutionCreator<RESULT> creator) {
        // ## Arrange ##
        ExecutorService service = Executors.newCachedThreadPool();
        int threadCount = 10;
        CountDownLatch ready = new CountDownLatch(threadCount);
        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch goal = new CountDownLatch(threadCount);
        Execution<RESULT> execution = creator.create();
        List<Future<RESULT>> futureList = new ArrayList<Future<RESULT>>();
        for (int i = 0; i < threadCount; i++) {
            Future<RESULT> future = service.submit(createCallable(execution, ready, start, goal));
            futureList.add(future);
        }

        // ## Act ##
        // Start!
        start.countDown();
        try {
            // Wait until all threads are finished!
            goal.await();
        } catch (InterruptedException e) {
            String msg = "goal.await() was interrupted!";
            throw new IllegalStateException(msg, e);
        }
        log("All threads are finished!");

        // ## Assert ##
        List<RESULT> resultList = new ArrayList<RESULT>();
        for (Future<RESULT> future : futureList) {
            try {
                RESULT result = future.get();
                assertNotNull(result);
                resultList.add(result);
            } catch (InterruptedException e) {
                String msg = "future.get() was interrupted!";
                throw new IllegalStateException(msg, e);
            } catch (ExecutionException e) {
                String msg = "Failed to execute!";
                throw new IllegalStateException(msg, e.getCause());
            }
        }
        return resultList;
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
                    } catch (InterruptedException e) {
                        String msg = "start.await() was interrupted!";
                        throw new IllegalStateException(msg, e);
                    }
                    RESULT result = execution.execute();
                    return result;
                } finally {
                    goal.countDown();
                }
            }
        };
    }
}
