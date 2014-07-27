package com.example.dbflute.spring.dbflute.whitebox.cbean;

import org.seasar.dbflute.cbean.ListResultBean;
import org.seasar.dbflute.cbean.SubQuery;
import org.seasar.dbflute.cbean.coption.DerivedReferrerOption;

import com.example.dbflute.spring.dbflute.cbean.MemberCB;
import com.example.dbflute.spring.dbflute.cbean.PurchaseCB;
import com.example.dbflute.spring.dbflute.exbhv.MemberBhv;
import com.example.dbflute.spring.dbflute.exentity.Member;
import com.example.dbflute.spring.unit.UnitContainerTestCase;

/**
 * @author jflute
 * @since 1.0.5K (2014/07/27 Sunday)
 */
public class WxCBDerivedReferrerDreamCruiseTest extends UnitContainerTestCase {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private MemberBhv memberBhv;

    // ===================================================================================
    //                                                               DerivedReferrerOption
    //                                                               =====================
    public void test_SepcifyDerivedReferrer_option_DreamCruise_basic() throws Exception {
        MemberCB cb = new MemberCB();
        cb.specify().derivedPurchaseList().max(new SubQuery<PurchaseCB>() {
            public void query(PurchaseCB subCB) {
                subCB.specify().columnPurchasePrice();
            }
        }, Member.ALIAS_highestPurchasePrice, new DerivedReferrerOption().plus(3));
        MemberCB dreamCruiseCB = cb.dreamCruiseCB();
        cb.specify().derivedPurchaseList().max(new SubQuery<PurchaseCB>() {
            public void query(PurchaseCB subCB) {
                subCB.specify().columnPurchasePrice();
            }
        }, Member.ALIAS_loginCount, new DerivedReferrerOption().plus(dreamCruiseCB.specify().columnMemberId()));
        cb.setupSelect_MemberWithdrawalAsOne().withWithdrawalReason();
        cb.query().addOrderBy_Birthdate_Desc();

        // ## Act ##
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        assertHasAnyElement(memberList);
        for (Member member : memberList) {
            log(member.getMemberName(), member.getHighestPurchasePrice(), member.getLoginCount());
        }
        String sql = cb.toDisplaySql();
        assertTrue(sql.contains("(select max(sub1loc.PURCHASE_PRICE) + 3"));
        assertTrue(sql.contains("(select max(sub1loc.PURCHASE_PRICE) + dfloc.MEMBER_ID"));
    }

    // ===================================================================================
    //                                                                  SpecifyCalculation
    //                                                                  ==================
    public void test_SpecifyDerivedReferrer_SpecifyCalculation_DreamCruise_basic() throws Exception {
        MemberCB cb = new MemberCB();
        cb.specify().derivedPurchaseList().max(new SubQuery<PurchaseCB>() {
            public void query(PurchaseCB subCB) {
                subCB.specify().columnPurchasePrice().plus(3);
            }
        }, Member.ALIAS_highestPurchasePrice);
        cb.specify().derivedPurchaseList().max(new SubQuery<PurchaseCB>() {
            public void query(PurchaseCB subCB) {
                PurchaseCB dreamCruiseCB = subCB.dreamCruiseCB();
                subCB.specify().columnPurchasePrice().plus(dreamCruiseCB.specify().specifyMember().columnMemberId());
            }
        }, Member.ALIAS_loginCount);
        cb.setupSelect_MemberWithdrawalAsOne().withWithdrawalReason();
        cb.query().addOrderBy_Birthdate_Desc();

        // ## Act ##
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        assertHasAnyElement(memberList);
        for (Member member : memberList) {
            log(member.getMemberName(), member.getHighestPurchasePrice(), member.getLoginCount());
        }
        String sql = cb.toDisplaySql();
        assertTrue(sql.contains("(select max(sub1loc.PURCHASE_PRICE + 3)"));
        assertTrue(sql.contains("(select max(sub1loc.PURCHASE_PRICE + sub1rel_0.MEMBER_ID)"));
    }
}
