package com.example.dbflute.spring.dbflute.whitebox.cbean.innerjoin;

import org.seasar.dbflute.cbean.ConditionBean;
import org.seasar.dbflute.cbean.ListResultBean;
import org.seasar.dbflute.cbean.OrQuery;
import org.seasar.dbflute.cbean.UnionQuery;
import org.seasar.dbflute.util.Srl;

import com.example.dbflute.spring.dbflute.cbean.MemberCB;
import com.example.dbflute.spring.dbflute.exbhv.MemberBhv;
import com.example.dbflute.spring.dbflute.exentity.Member;
import com.example.dbflute.spring.unit.UnitContainerTestCase;

/**
 * @author jflute
 * @since 0.6.0 (2008/01/16 Wednesday)
 */
public class WxCBInnerJoinWhereUsedBasicTest extends UnitContainerTestCase {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private MemberBhv memberBhv;

    // ===================================================================================
    //                                                                               Basic
    //                                                                               =====
    public void test_innerJoin_query() {
        // ## Arrange ##
        int countAll = memberBhv.selectCount(new MemberCB());

        MemberCB cb = new MemberCB();
        enableWhereUsedInnerJoinOnly(cb);
        cb.query().queryMemberStatus().setDisplayOrder_Equal(1);

        // ## Act ##
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        assertTrue(cb.toDisplaySql().contains("inner join"));
        assertFalse(cb.toDisplaySql().contains("left outer join"));
        assertFalse(memberList.isEmpty());
        assertNotSame(countAll, memberList.size());
        assertTrue(countAll > memberList.size());
        for (Member member : memberList) {
            log(ln() + member.toString());
        }
    }

    public void test_innerJoin_setupSelect() {
        // ## Arrange ##
        int countAll = memberBhv.selectCount(new MemberCB());

        MemberCB cb = new MemberCB();
        enableWhereUsedInnerJoinOnly(cb);
        cb.setupSelect_MemberStatus();
        cb.setupSelect_MemberWithdrawalAsOne();

        // ## Act ##
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        assertFalse(cb.toDisplaySql().contains("inner join"));
        assertTrue(cb.toDisplaySql().contains("left outer join"));
        assertFalse(memberList.isEmpty());
        assertEquals(countAll, memberList.size());
        for (Member member : memberList) {
            log(ln() + member.toStringWithRelation());
        }
    }

    public void test_innerJoin_inline_query() {
        // ## Arrange ##
        int countAll = memberBhv.selectCount(new MemberCB());

        MemberCB cb = new MemberCB();
        enableWhereUsedInnerJoinOnly(cb);
        cb.query().queryMemberStatus().inline().setDisplayOrder_Equal(1);

        // ## Act ##
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        assertFalse(cb.toDisplaySql().contains("inner join"));
        assertTrue(cb.toDisplaySql().contains("left outer join"));
        assertFalse(memberList.isEmpty());
        assertEquals(countAll, memberList.size());
        for (Member member : memberList) {
            log(member.toStringWithRelation());
        }
    }

    // ===================================================================================
    //                                                                              Nested
    //                                                                              ======
    public void test_innerJoin_nested_basic() {
        // ## Arrange ##
        int countAll;
        {
            MemberCB cb = new MemberCB();
            cb.getSqlClause().disableInnerJoinAutoDetect();
            cb.query().setMemberStatusCode_Equal_Withdrawal();
            cb.query().queryMemberWithdrawalAsOne().setWithdrawalReasonCode_IsNotNull();
            countAll = memberBhv.selectCount(cb);
        }

        MemberCB cb = new MemberCB();
        enableWhereUsedInnerJoinOnly(cb);
        cb.query().queryMemberWithdrawalAsOne().queryWithdrawalReason().setDisplayOrder_Equal(1);

        // ## Act ##
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        assertTrue(cb.toDisplaySql().contains("inner join"));
        assertFalse(cb.toDisplaySql().contains("left outer join"));
        assertFalse(memberList.isEmpty());
        assertNotSame(countAll, memberList.size());
        assertTrue(countAll > memberList.size());
        for (Member member : memberList) {
            log(member.toStringWithRelation());
        }
    }

    // ===================================================================================
    //                                                                      (Normal) Query
    //                                                                      ==============
    public void test_innerJoin_query_IsNull_basic() {
        // ## Arrange ##
        int countAll;
        {
            MemberCB cb = new MemberCB();
            cb.getSqlClause().disableInnerJoinAutoDetect();
            cb.query().setMemberStatusCode_NotEqual_Withdrawal();
            countAll = memberBhv.selectCount(cb);
        }

        MemberCB cb = new MemberCB();
        enableWhereUsedInnerJoinOnly(cb);
        cb.query().queryMemberWithdrawalAsOne().setMemberId_IsNull();

        // ## Act ##
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        assertFalse(cb.toDisplaySql().contains("inner join"));
        assertTrue(cb.toDisplaySql().contains("left outer join"));
        assertFalse(memberList.isEmpty());
        assertEquals(countAll, memberList.size());
        for (Member member : memberList) {
            log(member);
        }
    }

    public void test_innerJoin_query_IsNull_nested() {
        // ## Arrange ##
        int countAll;
        {
            MemberCB cb = new MemberCB();
            cb.getSqlClause().disableInnerJoinAutoDetect();
            cb.orScopeQuery(new OrQuery<MemberCB>() {
                public void query(MemberCB orCB) {
                    orCB.query().setMemberStatusCode_NotEqual_Withdrawal();
                    orCB.query().queryMemberWithdrawalAsOne().setWithdrawalReasonCode_IsNull();
                }
            });
            countAll = memberBhv.selectCount(cb);
        }

        MemberCB cb = new MemberCB();
        enableWhereUsedInnerJoinOnly(cb);
        cb.query().queryMemberWithdrawalAsOne().queryWithdrawalReason().setWithdrawalReasonCode_IsNull();

        // ## Act ##
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        assertFalse(cb.toDisplaySql().contains("inner join"));
        assertTrue(cb.toDisplaySql().contains("left outer join"));
        assertFalse(memberList.isEmpty());
        assertEquals(countAll, memberList.size());
        for (Member member : memberList) {
            log(member);
        }
    }

    public void test_innerJoin_query_IsNullOrEmpty_basic() {
        // ## Arrange ##
        int countAll;
        {
            MemberCB cb = new MemberCB();
            cb.getSqlClause().disableInnerJoinAutoDetect();
            cb.orScopeQuery(new OrQuery<MemberCB>() {
                public void query(MemberCB orCB) {
                    orCB.query().queryMemberWithdrawalAsOne().setWithdrawalReasonInputText_IsNullOrEmpty();
                }
            });
            countAll = memberBhv.selectCount(cb);
        }

        MemberCB cb = new MemberCB();
        enableWhereUsedInnerJoinOnly(cb);
        cb.query().queryMemberWithdrawalAsOne().setWithdrawalReasonInputText_IsNullOrEmpty();

        // ## Act ##
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        assertFalse(cb.toDisplaySql().contains("inner join"));
        assertTrue(cb.toDisplaySql().contains("left outer join"));
        assertFalse(memberList.isEmpty());
        assertEquals(countAll, memberList.size());
        for (Member member : memberList) {
            log(member);
        }
    }

    public void test_innerJoin_query_IsNotNull_basic() {
        // ## Arrange ##
        int countAll;
        {
            MemberCB cb = new MemberCB();
            cb.getSqlClause().disableInnerJoinAutoDetect();
            cb.query().setMemberStatusCode_Equal_Withdrawal();
            countAll = memberBhv.selectCount(cb);
        }

        MemberCB cb = new MemberCB();
        enableWhereUsedInnerJoinOnly(cb);
        cb.query().queryMemberWithdrawalAsOne().setMemberId_IsNotNull();

        // ## Act ##
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        assertTrue(cb.toDisplaySql().contains("inner join"));
        assertFalse(cb.toDisplaySql().contains("left outer join"));
        assertFalse(memberList.isEmpty());
        assertEquals(countAll, memberList.size());
        for (Member member : memberList) {
            log(member);
        }
    }

    public void test_innerJoin_query_IsNotNull_nested() {
        // ## Arrange ##
        int countAll;
        {
            MemberCB cb = new MemberCB();
            cb.getSqlClause().disableInnerJoinAutoDetect();
            cb.query().setMemberStatusCode_Equal_Withdrawal();
            cb.query().queryMemberWithdrawalAsOne().setWithdrawalReasonCode_IsNotNull();
            countAll = memberBhv.selectCount(cb);
        }

        MemberCB cb = new MemberCB();
        enableWhereUsedInnerJoinOnly(cb);
        cb.query().queryMemberWithdrawalAsOne().queryWithdrawalReason().setWithdrawalReasonCode_IsNotNull();

        // ## Act ##
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        assertTrue(cb.toDisplaySql().contains("inner join"));
        assertFalse(cb.toDisplaySql().contains("left outer join"));
        assertFalse(memberList.isEmpty());
        assertEquals(countAll, memberList.size());
        for (Member member : memberList) {
            log(member);
        }
    }

    // ===================================================================================
    //                                                                               Union
    //                                                                               =====
    public void test_innerJoin_union_basic() {
        // ## Arrange ##
        int countAll = memberBhv.selectCount(new MemberCB());

        MemberCB cb = new MemberCB();
        enableWhereUsedInnerJoinOnly(cb);
        cb.query().queryMemberStatus().setDisplayOrder_Equal(1);
        cb.union(new UnionQuery<MemberCB>() {
            public void query(MemberCB unionCB) {
                unionCB.query().queryMemberStatus().setDisplayOrder_Equal(2);
            }
        });

        // ## Act ##
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        String sql = cb.toDisplaySql();
        assertTrue(sql.contains("inner join"));
        assertFalse(sql.contains("left outer join")); // inherited
        assertEquals(2, Srl.count(sql, "inner join"));
        assertFalse(memberList.isEmpty());
        assertNotSame(countAll, memberList.size());
        assertTrue(countAll > memberList.size());
        for (Member member : memberList) {
            log(member.toStringWithRelation());
        }
    }

    // ===================================================================================
    //                                                                        OrScopeQuery
    //                                                                        ============
    public void test_innerJoin_OrScopeQuery_basic() {
        // ## Arrange ##
        int countAll;
        {
            MemberCB cb = new MemberCB();
            cb.query().queryMemberWithdrawalAsOne().queryWithdrawalReason().setWithdrawalReasonCode_Equal_Prd();
            countAll = memberBhv.selectCount(cb);
        }

        MemberCB cb = new MemberCB();
        enableWhereUsedInnerJoinOnly(cb);
        cb.orScopeQuery(new OrQuery<MemberCB>() {
            public void query(MemberCB orCB) {
                orCB.query().queryMemberWithdrawalAsOne().queryWithdrawalReason().setWithdrawalReasonCode_Equal_Prd();
            }
        });

        // ## Act ##
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        assertFalse(cb.toDisplaySql().contains("inner join"));
        assertTrue(cb.toDisplaySql().contains("left outer join"));
        assertFalse(memberList.isEmpty());
        assertEquals(countAll, memberList.size());
        for (Member member : memberList) {
            log(member);
        }
    }

    public void test_innerJoin_OrScopeQuery_with_IsNull() {
        // ## Arrange ##
        int countAll;
        {
            MemberCB cb = new MemberCB();
            cb.orScopeQuery(new OrQuery<MemberCB>() {
                public void query(MemberCB orCB) {
                    orCB.query().setMemberStatusCode_NotEqual_Withdrawal();
                    orCB.query().queryMemberWithdrawalAsOne().setWithdrawalReasonCode_IsNull();
                }
            });
            countAll = memberBhv.selectCount(cb);
        }

        MemberCB cb = new MemberCB();
        enableWhereUsedInnerJoinOnly(cb);
        cb.orScopeQuery(new OrQuery<MemberCB>() {
            public void query(MemberCB orCB) {
                orCB.query().queryMemberWithdrawalAsOne().queryWithdrawalReason().setWithdrawalReasonCode_IsNull();
                orCB.query().queryMemberWithdrawalAsOne().queryWithdrawalReason().setWithdrawalReasonCode_Equal_Frt();
            }
        });

        // ## Act ##
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        assertFalse(cb.toDisplaySql().contains("inner join"));
        assertTrue(cb.toDisplaySql().contains("left outer join"));
        assertFalse(memberList.isEmpty());
        assertEquals(countAll, memberList.size());
        for (Member member : memberList) {
            log(member);
        }
    }

    protected void enableWhereUsedInnerJoinOnly(ConditionBean cb) {
        cb.disableInnerJoinAutoDetect();
        cb.getSqlClause().enableWhereUsedInnerJoin();
    }
}
