package com.example.dbflute.spring.dbflute.whitebox.runtime;

import java.util.List;

import org.seasar.dbflute.CallbackContext;
import org.seasar.dbflute.cbean.ListResultBean;
import org.seasar.dbflute.cbean.PagingResultBean;
import org.seasar.dbflute.jdbc.SqlLogHandler;
import org.seasar.dbflute.jdbc.SqlLogInfo;
import org.seasar.dbflute.util.DfCollectionUtil;
import org.seasar.dbflute.util.Srl;

import com.example.dbflute.spring.dbflute.cbean.MemberCB;
import com.example.dbflute.spring.dbflute.exbhv.MemberBhv;
import com.example.dbflute.spring.dbflute.exbhv.pmbean.MemberChangedToWithdrawalForcedlyPmb;
import com.example.dbflute.spring.dbflute.exbhv.pmbean.PurchaseMaxPriceMemberPmb;
import com.example.dbflute.spring.dbflute.exentity.Member;
import com.example.dbflute.spring.dbflute.exentity.customize.PurchaseMaxPriceMember;
import com.example.dbflute.spring.unit.UnitContainerTestCase;

/**
 * @author jflute
 * @since 0.9.8.7 (2011/07/02 Saturday)
 */
public class WxSqlLogHandlerTest extends UnitContainerTestCase {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private MemberBhv memberBhv;

    // ===================================================================================
    //                                                                          After Care
    //                                                                          ==========
    @Override
    public void tearDown() throws Exception {
        super.tearDown();
        clearSqlLogHandler();
    }

    protected void clearSqlLogHandler() {
        CallbackContext.clearSqlLogHandlerOnThread();
        assertFalse(CallbackContext.isExistCallbackContextOnThread());
        assertFalse(CallbackContext.isExistBehaviorCommandHookOnThread());
        assertFalse(CallbackContext.isExistSqlFireHookOnThread());
        assertFalse(CallbackContext.isExistSqlLogHandlerOnThread());
        assertFalse(CallbackContext.isExistSqlResultHandlerOnThread());
        assertFalse(CallbackContext.isExistSqlStringFilterOnThread());
    }

    // ===================================================================================
    //                                                                       ConditionBean
    //                                                                       =============
    public void test_ConditionBean_selectList() {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.query().setMemberName_PrefixSearch("S");
        final List<String> displaySqlList = newArrayList();
        CallbackContext.setSqlLogHandlerOnThread(new SqlLogHandler() {
            public void handle(SqlLogInfo info) {
                assertTrue(info.getMeta().isConditionBean());
                assertFalse(info.getMeta().isOutsideSql());
                assertFalse(info.getMeta().isProcedure());
                assertTrue(info.getMeta().isSelect());
                assertFalse(info.getMeta().isSelectCount());
                assertTrue(info.getExecutedSql().contains("?"));
                assertEquals(1, info.getBindArgs().length);
                assertEquals(1, info.getBindArgTypes().length);
                assertEquals(String.class, info.getBindArgTypes()[0]);
                displaySqlList.add(info.getDisplaySql());
            }
        });

        // ## Act ##
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        assertHasAnyElement(memberList);
        showDisplaySqlList(displaySqlList);
        assertEquals(1, displaySqlList.size());
        assertTrue(displaySqlList.iterator().next().contains("'S%'"));
    }

    // ===================================================================================
    //                                                                       Entity Update
    //                                                                       =============
    public void test_EntityUpdate_insert() {
        // ## Arrange ##
        Member member = new Member();
        member.setMemberName("$name");
        member.setMemberAccount("$account");
        member.setMemberStatusCode_Formalized();
        final List<String> displaySqlList = newArrayList();
        CallbackContext.setSqlLogHandlerOnThread(new SqlLogHandler() {
            public void handle(SqlLogInfo info) {
                assertFalse(info.getMeta().isConditionBean());
                assertFalse(info.getMeta().isOutsideSql());
                assertFalse(info.getMeta().isProcedure());
                assertFalse(info.getMeta().isSelect());
                assertFalse(info.getMeta().isSelectCount());
                displaySqlList.add(info.getDisplaySql());
            }
        });

        // ## Act ##
        memberBhv.insert(member);

        // ## Assert ##
        showDisplaySqlList(displaySqlList);
        assertEquals(2, displaySqlList.size()); // contains identity selecting
        String firstSql = displaySqlList.iterator().next();
        String msg = "firstSql: " + firstSql + ln() + "displaySqlList: " + displaySqlList;
        assertTrue(msg, Srl.containsAll(firstSql, "$name", "$account"));
    }

    public void test_EntityUpdate_insertOrUpdate_insertOnly() {
        // ## Arrange ##
        Member member = new Member();
        member.setMemberName("$name");
        member.setMemberAccount("$account");
        member.setMemberStatusCode_Formalized();
        final List<String> displaySqlList = newArrayList();
        CallbackContext.setSqlLogHandlerOnThread(new SqlLogHandler() {
            public void handle(SqlLogInfo info) {
                assertFalse(info.getMeta().isConditionBean());
                assertFalse(info.getMeta().isOutsideSql());
                assertFalse(info.getMeta().isProcedure());
                assertFalse(info.getMeta().isSelect());
                assertFalse(info.getMeta().isSelectCount());
                displaySqlList.add(info.getDisplaySql());
            }
        });

        // ## Act ##
        memberBhv.insertOrUpdate(member);

        // ## Assert ##
        showDisplaySqlList(displaySqlList);
        assertEquals(2, displaySqlList.size()); // contains identity selecting
        String firstSql = displaySqlList.iterator().next();
        String msg = "firstSql: " + firstSql + ln() + "displaySqlList: " + displaySqlList;
        assertTrue(msg, Srl.containsAll(firstSql, "$name", "$account"));
    }

    public void test_EntityUpdate_insertOrUpdate_updateOnly() {
        // ## Arrange ##
        Member before = memberBhv.selectByPKValueWithDeletedCheck(3);
        Member member = new Member();
        member.setMemberId(before.getMemberId());
        member.setMemberName("$name");
        member.setMemberAccount("$account");
        member.setMemberStatusCode_Formalized();
        member.setVersionNo(before.getVersionNo());
        final List<String> displaySqlList = newArrayList();
        CallbackContext.setSqlLogHandlerOnThread(new SqlLogHandler() {
            public void handle(SqlLogInfo info) {
                assertFalse(info.getMeta().isConditionBean());
                assertFalse(info.getMeta().isOutsideSql());
                assertFalse(info.getMeta().isProcedure());
                assertFalse(info.getMeta().isSelect());
                assertFalse(info.getMeta().isSelectCount());
                displaySqlList.add(info.getDisplaySql());
            }
        });

        // ## Act ##
        memberBhv.insertOrUpdate(member);

        // ## Assert ##
        showDisplaySqlList(displaySqlList);
        assertEquals(1, displaySqlList.size()); // contains identity selecting
        String firstSql = displaySqlList.iterator().next();
        String msg = "firstSql: " + firstSql + ln() + "displaySqlList: " + displaySqlList;
        assertTrue(msg, Srl.containsAll(firstSql, "$name", "$account"));
    }

    public void test_EntityUpdate_insertOrUpdate_onParade() {
        // ## Arrange ##
        Member before = memberBhv.selectByPKValueWithDeletedCheck(3);
        Member member = new Member();
        member.setMemberId(99999);
        member.setMemberName("$name");
        member.setMemberAccount("$account");
        member.setMemberStatusCode_Formalized();
        member.setVersionNo(before.getVersionNo());
        final List<String> displaySqlList = newArrayList();
        CallbackContext.setSqlLogHandlerOnThread(new SqlLogHandler() {
            public void handle(SqlLogInfo info) {
                displaySqlList.add(info.getDisplaySql());
            }
        });

        // ## Act ##
        memberBhv.insertOrUpdate(member);

        // ## Assert ##
        showDisplaySqlList(displaySqlList);
        assertEquals(4, displaySqlList.size()); // contains identity selecting
    }

    // ===================================================================================
    //                                                                          OutsideSql
    //                                                                          ==========
    public void test_OutsideSql_selectPage() {
        // ## Arrange ##
        PurchaseMaxPriceMemberPmb pmb = new PurchaseMaxPriceMemberPmb();
        pmb.setMemberNameList_PrefixSearch(DfCollectionUtil.newArrayList("S", "M"));
        int pageSize = 3;
        pmb.paging(pageSize, 1); // 1st page
        final List<String> displaySqlList = newArrayList();
        CallbackContext.setSqlLogHandlerOnThread(new SqlLogHandler() {
            public void handle(SqlLogInfo info) {
                assertFalse(info.getMeta().isConditionBean());
                assertTrue(info.getMeta().isOutsideSql());
                assertFalse(info.getMeta().isProcedure());
                assertTrue(info.getMeta().isSelect());
                // false also when select-count in paging
                assertFalse(info.getMeta().isSelectCount());
                displaySqlList.add(info.getDisplaySql());
            }
        });

        // ## Act ##
        PagingResultBean<PurchaseMaxPriceMember> page1 = memberBhv.outsideSql().manualPaging().selectPage(pmb);

        // ## Assert ##
        showDisplaySqlList(displaySqlList);
        assertFalse(page1.isEmpty());
        assertEquals(2, displaySqlList.size());
        for (String displaySql : displaySqlList) {
            assertTrue(Srl.containsAll(displaySql, "'S%'", "'M%'"));
        }
    }

    // ===================================================================================
    //                                                                          OutsideSql
    //                                                                          ==========
    public void test_OutsideSql_execute() {
        // ## Arrange ##
        MemberChangedToWithdrawalForcedlyPmb pmb = new MemberChangedToWithdrawalForcedlyPmb();
        pmb.setMemberName_PrefixSearch("$name");

        final List<String> displaySqlList = newArrayList();
        CallbackContext.setSqlLogHandlerOnThread(new SqlLogHandler() {
            public void handle(SqlLogInfo info) {
                assertFalse(info.getMeta().isConditionBean());
                assertTrue(info.getMeta().isOutsideSql());
                assertFalse(info.getMeta().isProcedure());
                assertFalse(info.getMeta().isSelect());
                assertFalse(info.getMeta().isSelectCount());
                displaySqlList.add(info.getDisplaySql());
            }
        });

        // ## Act ##
        memberBhv.outsideSql().execute(pmb);

        // ## Assert ##
        showDisplaySqlList(displaySqlList);
        assertEquals(1, displaySqlList.size());
        assertTrue(Srl.containsAll(displaySqlList.iterator().next(), "$name"));
    }

    // ===================================================================================
    //                                                                       Assist Helper
    //                                                                       =============
    protected void showDisplaySqlList(List<String> displaySqlList) {
        StringBuilder sb = new StringBuilder();
        for (String displaySql : displaySqlList) {
            sb.append(ln()).append(displaySql);
        }
        log(sb.toString());
    }
}
