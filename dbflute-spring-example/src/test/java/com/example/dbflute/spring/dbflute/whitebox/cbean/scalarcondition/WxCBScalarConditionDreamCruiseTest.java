package com.example.dbflute.spring.dbflute.whitebox.cbean.scalarcondition;

import org.seasar.dbflute.cbean.SubQuery;
import org.seasar.dbflute.cbean.UnionQuery;

import com.example.dbflute.spring.dbflute.cbean.MemberCB;
import com.example.dbflute.spring.dbflute.exbhv.MemberBhv;
import com.example.dbflute.spring.unit.UnitContainerTestCase;

/**
 * @author jflute
 * @since 1.0.5K (2014/07/29 Tuesday)
 */
public class WxCBScalarConditionDreamCruiseTest extends UnitContainerTestCase {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private MemberBhv memberBhv;

    // ===================================================================================
    //                                                                               Basic
    //                                                                               =====
    public void test_ScalarCondition_DreamCruise_basic() {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.query().scalar_Equal().max(new SubQuery<MemberCB>() {
            public void query(MemberCB subCB) {
                MemberCB dreamCruiseCB = subCB.dreamCruiseCB();
                subCB.specify().columnMemberId().plus(dreamCruiseCB.specify().columnVersionNo());
            }
        });

        // ## Act ##
        memberBhv.selectList(cb); // expect no exception

        // ## Assert ##
        String sql = cb.toDisplaySql();
        assertTrue(sql.contains("where dfloc.MEMBER_ID = (select max(sub1loc.MEMBER_ID + sub1loc.VERSION_NO)"));
    }

    public void test_ScalarCondition_DreamCruise_Union() {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.query().scalar_Equal().max(new SubQuery<MemberCB>() {
            public void query(MemberCB subCB) {
                MemberCB dreamCruiseCB = subCB.dreamCruiseCB();
                subCB.specify().columnMemberId().plus(dreamCruiseCB.specify().columnVersionNo());
                subCB.union(new UnionQuery<MemberCB>() {
                    public void query(MemberCB unionCB) {
                    }
                });
            }
        });

        // ## Act ##
        memberBhv.selectList(cb); // expect no exception

        // ## Assert ##
        String sql = cb.toDisplaySql();
        assertTrue(sql.contains("where dfloc.MEMBER_ID = (select max(sub1main.MEMBER_ID)"));
        assertTrue(sql.contains("from (select MEMBER_ID, sub1loc.MEMBER_ID + sub1loc.VERSION_NO"));
    }
}
