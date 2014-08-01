package com.example.dbflute.spring.dbflute.whitebox.cbean.existsreferrer;

import java.util.List;

import org.seasar.dbflute.CallbackContext;
import org.seasar.dbflute.cbean.ListResultBean;
import org.seasar.dbflute.cbean.SpecifyQuery;
import org.seasar.dbflute.cbean.SubQuery;
import org.seasar.dbflute.cbean.chelper.HpSpecifiedColumn;
import org.seasar.dbflute.jdbc.SqlLogHandler;
import org.seasar.dbflute.jdbc.SqlLogInfo;

import com.example.dbflute.spring.dbflute.cbean.MemberCB;
import com.example.dbflute.spring.dbflute.cbean.PurchaseCB;
import com.example.dbflute.spring.dbflute.exbhv.MemberBhv;
import com.example.dbflute.spring.dbflute.exentity.Member;
import com.example.dbflute.spring.unit.UnitContainerTestCase;

/**
 * @author jflute
 * @since 1.0.5K (2014/08/01 Friday)
 */
public class WxCBExistsReferrerDreamCruiseTest extends UnitContainerTestCase {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private MemberBhv memberBhv;

    // ===================================================================================
    //                                                                      CountLeastJoin
    //                                                                      ==============
    public void test_ExsitsReferrer_DreamCruise_OverTheWaves_CountLeastJoin() throws Exception {
        MemberCB cb = new MemberCB();
        MemberCB dreamCruiseCB = cb.dreamCruiseCB();
        final HpSpecifiedColumn servicePointCount = dreamCruiseCB.specify().specifyMemberServiceAsOne()
                .columnServicePointCount();
        cb.query().existsPurchaseList(new SubQuery<PurchaseCB>() {
            public void query(PurchaseCB subCB) {
                subCB.columnQuery(new SpecifyQuery<PurchaseCB>() {
                    public void specify(PurchaseCB cb) {
                        cb.specify().columnMemberId();
                    }
                }).lessThan(new SpecifyQuery<PurchaseCB>() {
                    public void specify(PurchaseCB cb) {
                        cb.overTheWaves(servicePointCount);
                    }
                });
            }
        });
        cb.query().addOrderBy_Birthdate_Desc();
        cb.paging(3, 1);

        final List<SqlLogInfo> infoList = newArrayList();
        CallbackContext.setSqlLogHandlerOnThread(new SqlLogHandler() {
            public void handle(SqlLogInfo info) {
                infoList.add(info);
            }
        });
        try {
            // ## Act ##
            ListResultBean<Member> memberList = memberBhv.selectPage(cb); // expect no exception

            // ## Assert ##
            assertHasAnyElement(memberList);
            for (Member member : memberList) {
                log(member.getMemberName(), member.getHighestPurchasePrice(), member.getLoginCount());
            }
            SqlLogInfo firstInfo = infoList.get(0);
            String sql = firstInfo.getDisplaySql();
            assertContains(sql, "left outer join MEMBER_SERVICE dfrel_4 on dfloc.MEMBER_ID = dfrel_4.MEMBER_ID");
            assertContains(sql, "and sub1loc.MEMBER_ID > sub1loc.PRODUCT_ID + dfrel_4.SERVICE_POINT_COUNT");
            SqlLogInfo secondInfo = infoList.get(1);
            assertTrue(secondInfo.getDisplaySql().contains("select count(*)"));
            assertTrue(secondInfo.getDisplaySql().contains("join"));
        } finally {
            CallbackContext.clearSqlLogHandlerOnThread();
        }
    }

    public void test_ExsitsReferrer_DreamCruise_OptionCalculation_CountLeastJoin() throws Exception {
        MemberCB cb = new MemberCB();
        MemberCB dreamCruiseCB = cb.dreamCruiseCB();
        final HpSpecifiedColumn servicePointCount = dreamCruiseCB.specify().specifyMemberServiceAsOne()
                .columnServicePointCount();
        cb.query().existsPurchaseList(new SubQuery<PurchaseCB>() {
            public void query(PurchaseCB subCB) {
                subCB.columnQuery(new SpecifyQuery<PurchaseCB>() {
                    public void specify(PurchaseCB cb) {
                        cb.specify().columnMemberId();
                    }
                }).lessThan(new SpecifyQuery<PurchaseCB>() {
                    public void specify(PurchaseCB cb) {
                        cb.specify().columnProductId();
                    }
                }).plus(servicePointCount);
            }
        });
        cb.query().addOrderBy_Birthdate_Desc();
        cb.paging(3, 1);

        final List<SqlLogInfo> infoList = newArrayList();
        CallbackContext.setSqlLogHandlerOnThread(new SqlLogHandler() {
            public void handle(SqlLogInfo info) {
                infoList.add(info);
            }
        });
        try {
            // ## Act ##
            ListResultBean<Member> memberList = memberBhv.selectPage(cb); // expect no exception

            // ## Assert ##
            assertHasAnyElement(memberList);
            for (Member member : memberList) {
                log(member.getMemberName(), member.getHighestPurchasePrice(), member.getLoginCount());
            }
            SqlLogInfo firstInfo = infoList.get(0);
            String sql = firstInfo.getDisplaySql();
            assertContains(sql, "left outer join MEMBER_SERVICE dfrel_4 on dfloc.MEMBER_ID = dfrel_4.MEMBER_ID");
            assertContains(sql, "and sub1loc.MEMBER_ID > sub1loc.PRODUCT_ID + dfrel_4.SERVICE_POINT_COUNT");
            SqlLogInfo secondInfo = infoList.get(1);
            assertTrue(secondInfo.getDisplaySql().contains("select count(*)"));
            assertTrue(secondInfo.getDisplaySql().contains("join"));
        } finally {
            CallbackContext.clearSqlLogHandlerOnThread();
        }
    }
}
