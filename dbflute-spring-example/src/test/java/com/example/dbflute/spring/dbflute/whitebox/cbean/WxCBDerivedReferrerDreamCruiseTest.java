package com.example.dbflute.spring.dbflute.whitebox.cbean;

import org.seasar.dbflute.cbean.ListResultBean;
import org.seasar.dbflute.cbean.SubQuery;
import org.seasar.dbflute.cbean.UnionQuery;
import org.seasar.dbflute.cbean.coption.DerivedReferrerOption;

import com.example.dbflute.spring.dbflute.cbean.MemberCB;
import com.example.dbflute.spring.dbflute.cbean.PurchaseCB;
import com.example.dbflute.spring.dbflute.cbean.PurchasePaymentCB;
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

    public void test_SpecifyDerivedReferrer_SpecifyCalculation_DreamCruise_union() throws Exception {
        MemberCB cb = new MemberCB();
        cb.specify().derivedPurchaseList().max(new SubQuery<PurchaseCB>() {
            public void query(PurchaseCB subCB) {
                subCB.specify().columnPurchasePrice().plus(3);
                subCB.union(new UnionQuery<PurchaseCB>() {
                    public void query(PurchaseCB unionCB) {
                    }
                });
            }
        }, Member.ALIAS_highestPurchasePrice);
        cb.specify().derivedPurchaseList().max(new SubQuery<PurchaseCB>() {
            public void query(PurchaseCB subCB) {
                PurchaseCB dreamCruiseCB = subCB.dreamCruiseCB();
                subCB.specify().columnPurchasePrice().plus(dreamCruiseCB.specify().specifyMember().columnMemberId());
                subCB.union(new UnionQuery<PurchaseCB>() {
                    public void query(PurchaseCB unionCB) {
                    }
                });
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
        assertTrue(sql.contains("from (select sub1loc.PURCHASE_ID, sub1loc.MEMBER_ID, sub1loc."));
        assertTrue(sql.contains("sub1loc.MEMBER_ID, sub1loc.PURCHASE_PRICE + 3 as PURCHASE_PRICE"));
        assertTrue(sql.contains("from (select sub1loc.PURCHASE_ID, sub1loc.MEMBER_ID, sub1loc."));
        assertTrue(sql.contains(", sub1loc.PURCHASE_PRICE + sub1rel_0.MEMBER_ID as PURCHASE_PRICE"));
        /*
        select ...
             , (select max(sub1main.PURCHASE_PRICE)
                  from (select sub1loc.PURCHASE_ID, sub1loc.MEMBER_ID, sub1loc.PURCHASE_PRICE + 3 as PURCHASE_PRICE
                          from PURCHASE sub1loc
                         union 
                        select sub1loc.PURCHASE_ID, sub1loc.MEMBER_ID, sub1loc.PURCHASE_PRICE + 3 as PURCHASE_PRICE 
                          from PURCHASE sub1loc 
                       ) sub1main
                 where sub1main.MEMBER_ID = dfloc.MEMBER_ID
               ) as HIGHEST_PURCHASE_PRICE
             , (select max(sub1main.PURCHASE_PRICE)
                  from (select sub1loc.PURCHASE_ID, sub1loc.MEMBER_ID, sub1loc.PURCHASE_PRICE + sub1rel_0.MEMBER_ID as PURCHASE_PRICE
                          from PURCHASE sub1loc
                            inner join MEMBER sub1rel_0 on sub1loc.MEMBER_ID = sub1rel_0.MEMBER_ID
                         union 
                        select sub1loc.PURCHASE_ID, sub1loc.MEMBER_ID, sub1loc.PURCHASE_PRICE + sub1rel_0.MEMBER_ID as PURCHASE_PRICE 
                          from PURCHASE sub1loc
                            inner join MEMBER sub1rel_0 on sub1loc.MEMBER_ID = sub1rel_0.MEMBER_ID 
                       ) sub1main
                 where sub1main.MEMBER_ID = dfloc.MEMBER_ID
               ) as LOGIN_COUNT
          from MEMBER dfloc
            left outer join MEMBER_WITHDRAWAL dfrel_5 on dfloc.MEMBER_ID = dfrel_5.MEMBER_ID
            left outer join WITHDRAWAL_REASON dfrel_5_1 on dfrel_5.WITHDRAWAL_REASON_CODE = dfrel_5_1.WITHDRAWAL_REASON_CODE 
         order by dfloc.BIRTHDATE desc
         */
    }

    public void test_SpecifyDerivedReferrer_SpecifyCalculation_DreamCruise_nested() throws Exception {
        MemberCB cb = new MemberCB();
        cb.specify().derivedPurchaseList().max(new SubQuery<PurchaseCB>() {
            public void query(PurchaseCB subCB) {
                subCB.specify().derivedPurchasePaymentList().max(new SubQuery<PurchasePaymentCB>() {
                    public void query(PurchasePaymentCB subCB) {
                        PurchasePaymentCB dreamCruiseCB = subCB.dreamCruiseCB();
                        subCB.specify().columnPaymentAmount().plus(dreamCruiseCB.specify().columnPurchasePaymentId());
                    }
                }, null, new DerivedReferrerOption().coalesce(3).plus(4));
            }
        }, Member.ALIAS_highestPurchasePrice);
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
        assertTrue(sql.contains("(select max((select coalesce(max(sub2loc.PAYMENT_AMOUNT"));
        assertTrue(sql.contains("sub2loc.PAYMENT_AMOUNT + sub2loc.PURCHASE_PAYMENT_ID), 3) + 4"));
        assertTrue(sql.contains("where sub2loc.PURCHASE_ID = sub1loc.PURCHASE_ID"));
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public void test_QueryDerivedReferrer_SpecifyCalculation_DreamCruise_basic() throws Exception {
        MemberCB cb = new MemberCB();
        cb.query().derivedPurchaseList().max(new SubQuery<PurchaseCB>() {
            public void query(PurchaseCB subCB) {
                subCB.specify().columnPurchasePrice().plus(3);
            }
        }).greaterEqual(100);
        cb.query().derivedPurchaseList().max(new SubQuery<PurchaseCB>() {
            public void query(PurchaseCB subCB) {
                PurchaseCB dreamCruiseCB = subCB.dreamCruiseCB();
                subCB.specify().columnPurchasePrice().plus(dreamCruiseCB.specify().specifyMember().columnMemberId());
            }
        }).greaterEqual(2000);
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
        assertTrue(sql.contains("where (select max(sub1loc.PURCHASE_PRICE + 3)"));
        assertTrue(sql.contains(") >= 100"));
        assertTrue(sql.contains("  and (select max(sub1loc.PURCHASE_PRICE + sub1rel_0.MEMBER_ID)"));
        assertTrue(sql.contains(") >= 2000"));
    }
}
