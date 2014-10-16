package com.example.dbflute.guice.dbflute.whitebox.dfprop;

import org.seasar.dbflute.cbean.ListResultBean;
import org.seasar.dbflute.cbean.SubQuery;
import org.seasar.dbflute.cbean.coption.ColumnConversionOption;

import com.example.dbflute.guice.dbflute.cbean.MemberCB;
import com.example.dbflute.guice.dbflute.cbean.PurchaseCB;
import com.example.dbflute.guice.dbflute.exbhv.MemberBhv;
import com.example.dbflute.guice.dbflute.exentity.Member;
import com.example.dbflute.guice.unit.UnitContainerTestCase;

/**
 * @author jflute
 * @since 1.0.5K (2014/07/27 Sunday)
 */
public class WxCBJodaTimeDreamCruiseTest extends UnitContainerTestCase {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private MemberBhv memberBhv;

    // ===================================================================================
    //                                                                  SpecifyCalculation
    //                                                                  ==================
    public void test_SpecifyDerivedReferrer_SpecifyCalculation_DreamCruise_basic() throws Exception {
        MemberCB cb = new MemberCB();
        cb.specify().derivedPurchase().max(new SubQuery<PurchaseCB>() {
            public void query(PurchaseCB subCB) {
                subCB.specify().columnPurchaseDatetime().convert(new ColumnConversionOption().truncTime().addDay(1))
                        .convert(new ColumnConversionOption().addMonth(2));
            }
        }, Member.PROP_latestLoginDatetime);
        cb.setupSelect_MemberWithdrawalAsOne().withWithdrawalReason();
        cb.query().addOrderBy_Birthdate_Desc();

        // ## Act ##
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        assertHasAnyElement(memberList);
        for (Member member : memberList) {
            log(member.getMemberName(), member.getLatestLoginDatetime());
        }
        String sql = cb.toDisplaySql();
        // , (select max(dateadd(month, 2, (dateadd(day, 1, cast(substring(sub1loc.PURCHASE_DATETIME, 1, 10) as date)))))
        assertContains(sql, ", (select max(dateadd(month, 2, (dateadd(day, 1, cast(substring");
        assertContains(sql, "day, 1, cast(substring(sub1loc.PURCHASE_DATETIME, 1, 10) as date)))))");
    }
}
