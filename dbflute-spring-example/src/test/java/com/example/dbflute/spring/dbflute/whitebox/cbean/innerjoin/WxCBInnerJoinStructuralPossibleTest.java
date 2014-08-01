package com.example.dbflute.spring.dbflute.whitebox.cbean.innerjoin;

import org.seasar.dbflute.cbean.ListResultBean;

import com.example.dbflute.spring.dbflute.bsentity.dbmeta.MemberAddressDbm;
import com.example.dbflute.spring.dbflute.bsentity.dbmeta.MemberDbm;
import com.example.dbflute.spring.dbflute.bsentity.dbmeta.MemberServiceDbm;
import com.example.dbflute.spring.dbflute.bsentity.dbmeta.MemberStatusDbm;
import com.example.dbflute.spring.dbflute.bsentity.dbmeta.MemberWithdrawalDbm;
import com.example.dbflute.spring.dbflute.bsentity.dbmeta.ProductDbm;
import com.example.dbflute.spring.dbflute.bsentity.dbmeta.ProductStatusDbm;
import com.example.dbflute.spring.dbflute.bsentity.dbmeta.ServiceRankDbm;
import com.example.dbflute.spring.dbflute.bsentity.dbmeta.SummaryProductDbm;
import com.example.dbflute.spring.dbflute.bsentity.dbmeta.WithdrawalReasonDbm;
import com.example.dbflute.spring.dbflute.cbean.PurchaseCB;
import com.example.dbflute.spring.dbflute.exbhv.PurchaseBhv;
import com.example.dbflute.spring.dbflute.exentity.Member;
import com.example.dbflute.spring.dbflute.exentity.MemberWithdrawal;
import com.example.dbflute.spring.dbflute.exentity.Product;
import com.example.dbflute.spring.dbflute.exentity.ProductStatus;
import com.example.dbflute.spring.dbflute.exentity.Purchase;
import com.example.dbflute.spring.dbflute.exentity.WithdrawalReason;
import com.example.dbflute.spring.unit.UnitContainerTestCase;

/**
 * @author jflute
 * @since 0.6.0 (2008/01/16 Wednesday)
 */
public class WxCBInnerJoinStructuralPossibleTest extends UnitContainerTestCase {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private PurchaseBhv purchaseBhv;

    // ===================================================================================
    //                                                                               Basic
    //                                                                               =====
    public void test_StructuralPossible_without_Query() {
        // ## Arrange ##
        PurchaseCB cb = new PurchaseCB();
        cb.allowInnerJoinAutoDetect();
        cb.setupSelect_Member().withMemberStatus();
        cb.setupSelect_Member().withMemberAddressAsValid(currentDate());
        cb.setupSelect_Member().withMemberServiceAsOne().withServiceRank();
        cb.setupSelect_Member().withMemberWithdrawalAsOne().withWithdrawalReason();
        cb.setupSelect_Product().withProductStatus();
        cb.setupSelect_SummaryProduct();
        cb.query().addOrderBy_MemberId_Asc().addOrderBy_PurchaseDatetime_Desc();

        // ## Act ##
        ListResultBean<Purchase> purchaseList = purchaseBhv.selectList(cb);

        // ## Assert ##
        assertNotSame(0, purchaseList.size());
        boolean existsWithdrawal = false;
        for (Purchase purchase : purchaseList) {
            Product product = purchase.getProduct();
            ProductStatus productStatus = product.getProductStatus();
            assertNotNull(product);
            assertNotNull(productStatus);
            log("[PURCHASE]: " + purchase.getPurchaseId() + ", " + product.getProductName() + ", " + productStatus);
            Member member = purchase.getMember();
            assertNotNull(member);
            assertNotNull(member.getMemberStatus());

            MemberWithdrawal memberWithdrawalAsOne = member.getMemberWithdrawalAsOne();
            if (memberWithdrawalAsOne != null) {
                WithdrawalReason withdrawalReason = memberWithdrawalAsOne.getWithdrawalReason();
                if (withdrawalReason != null) {
                    String reasonText = withdrawalReason.getWithdrawalReasonText();
                    log("    [WDL-MEMBER]: " + member.getMemberId() + ", " + member.getMemberName() + ", " + reasonText);
                    assertNotNull(reasonText);
                    existsWithdrawal = true;
                }
            }
        }
        String sql = cb.toDisplaySql();
        assertTrue(sql.contains("inner join " + MemberDbm.getInstance().getTableDbName()));
        assertTrue(sql.contains("inner join " + MemberStatusDbm.getInstance().getTableDbName()));
        assertTrue(sql.contains("left outer join " + MemberAddressDbm.getInstance().getTableDbName()));
        assertTrue(sql.contains("left outer join " + MemberServiceDbm.getInstance().getTableDbName()));
        assertTrue(sql.contains("left outer join " + ServiceRankDbm.getInstance().getTableDbName()));
        assertTrue(sql.contains("left outer join " + MemberWithdrawalDbm.getInstance().getTableDbName()));
        assertTrue(sql.contains("left outer join " + WithdrawalReasonDbm.getInstance().getTableDbName()));
        assertTrue(sql.contains("inner join " + ProductDbm.getInstance().getTableDbName()));
        assertTrue(sql.contains("inner join " + ProductStatusDbm.getInstance().getTableDbName()));
        assertTrue(sql.contains("left outer join " + SummaryProductDbm.getInstance().getTableDbName()));
        assertTrue(existsWithdrawal);
    }

    public void test_StructuralPossible_trace_is_ManualInnerJoin() {
        // ## Arrange ##
        PurchaseCB cb = new PurchaseCB();
        cb.allowInnerJoinAutoDetect();
        cb.setupSelect_Member().withMemberStatus();
        cb.setupSelect_Member().withMemberAddressAsValid(currentDate());
        cb.setupSelect_Member().withMemberServiceAsOne().withServiceRank();
        cb.setupSelect_Member().withMemberWithdrawalAsOne().withWithdrawalReason();
        cb.setupSelect_Product().withProductStatus();
        cb.setupSelect_SummaryProduct();
        cb.query().queryMember().queryMemberServiceAsOne().innerJoin();
        cb.query().addOrderBy_MemberId_Asc().addOrderBy_PurchaseDatetime_Desc();

        // ## Act ##
        ListResultBean<Purchase> purchaseList = purchaseBhv.selectList(cb);

        // ## Assert ##
        assertNotSame(0, purchaseList.size());
        boolean existsWithdrawal = false;
        for (Purchase purchase : purchaseList) {
            Product product = purchase.getProduct();
            ProductStatus productStatus = product.getProductStatus();
            assertNotNull(product);
            assertNotNull(productStatus);
            log("[PURCHASE]: " + purchase.getPurchaseId() + ", " + product.getProductName() + ", " + productStatus);
            Member member = purchase.getMember();
            assertNotNull(member);
            assertNotNull(member.getMemberStatus());

            MemberWithdrawal memberWithdrawalAsOne = member.getMemberWithdrawalAsOne();
            if (memberWithdrawalAsOne != null) {
                WithdrawalReason withdrawalReason = memberWithdrawalAsOne.getWithdrawalReason();
                if (withdrawalReason != null) {
                    String reasonText = withdrawalReason.getWithdrawalReasonText();
                    log("    [WDL-MEMBER]: " + member.getMemberId() + ", " + member.getMemberName() + ", " + reasonText);
                    assertNotNull(reasonText);
                    existsWithdrawal = true;
                }
            }
        }
        String sql = cb.toDisplaySql();
        assertTrue(sql.contains("inner join " + MemberDbm.getInstance().getTableDbName()));
        assertTrue(sql.contains("inner join " + MemberStatusDbm.getInstance().getTableDbName()));
        assertTrue(sql.contains("left outer join " + MemberAddressDbm.getInstance().getTableDbName()));
        assertTrue(sql.contains("inner join " + MemberServiceDbm.getInstance().getTableDbName()));
        assertTrue(sql.contains("inner join " + ServiceRankDbm.getInstance().getTableDbName())); // point
        assertTrue(sql.contains("left outer join " + MemberWithdrawalDbm.getInstance().getTableDbName()));
        assertTrue(sql.contains("left outer join " + WithdrawalReasonDbm.getInstance().getTableDbName()));
        assertTrue(sql.contains("inner join " + ProductDbm.getInstance().getTableDbName()));
        assertTrue(sql.contains("inner join " + ProductStatusDbm.getInstance().getTableDbName()));
        assertTrue(sql.contains("left outer join " + SummaryProductDbm.getInstance().getTableDbName()));
        assertTrue(existsWithdrawal);
    }

    public void test_StructuralPossible_trace_is_WhereUsedInnerJoin() {
        // ## Arrange ##
        PurchaseCB cb = new PurchaseCB();
        cb.allowInnerJoinAutoDetect();
        cb.setupSelect_Member().withMemberStatus();
        cb.setupSelect_Member().withMemberAddressAsValid(currentDate());
        cb.setupSelect_Member().withMemberServiceAsOne().withServiceRank();
        cb.setupSelect_Member().withMemberWithdrawalAsOne().withWithdrawalReason();
        cb.setupSelect_Product().withProductStatus();
        cb.setupSelect_SummaryProduct();
        cb.query().queryMember().queryMemberServiceAsOne().setServiceRankCode_Equal_Gold();
        cb.query().addOrderBy_MemberId_Asc().addOrderBy_PurchaseDatetime_Desc();

        // ## Act ##
        ListResultBean<Purchase> purchaseList = purchaseBhv.selectList(cb);

        // ## Assert ##
        assertNotSame(0, purchaseList.size());
        boolean existsWithdrawal = false;
        for (Purchase purchase : purchaseList) {
            Product product = purchase.getProduct();
            ProductStatus productStatus = product.getProductStatus();
            assertNotNull(product);
            assertNotNull(productStatus);
            log("[PURCHASE]: " + purchase.getPurchaseId() + ", " + product.getProductName() + ", " + productStatus);
            Member member = purchase.getMember();
            assertNotNull(member);
            assertNotNull(member.getMemberStatus());

            MemberWithdrawal memberWithdrawalAsOne = member.getMemberWithdrawalAsOne();
            if (memberWithdrawalAsOne != null) {
                WithdrawalReason withdrawalReason = memberWithdrawalAsOne.getWithdrawalReason();
                if (withdrawalReason != null) {
                    String reasonText = withdrawalReason.getWithdrawalReasonText();
                    log("    [WDL-MEMBER]: " + member.getMemberId() + ", " + member.getMemberName() + ", " + reasonText);
                    assertNotNull(reasonText);
                    existsWithdrawal = true;
                }
            }
        }
        String sql = cb.toDisplaySql();
        assertTrue(sql.contains("inner join " + MemberDbm.getInstance().getTableDbName()));
        assertTrue(sql.contains("inner join " + MemberStatusDbm.getInstance().getTableDbName()));
        assertTrue(sql.contains("left outer join " + MemberAddressDbm.getInstance().getTableDbName()));
        assertTrue(sql.contains("inner join " + MemberServiceDbm.getInstance().getTableDbName()));
        assertTrue(sql.contains("inner join " + ServiceRankDbm.getInstance().getTableDbName())); // point
        assertTrue(sql.contains("left outer join " + MemberWithdrawalDbm.getInstance().getTableDbName()));
        assertTrue(sql.contains("left outer join " + WithdrawalReasonDbm.getInstance().getTableDbName()));
        assertTrue(sql.contains("inner join " + ProductDbm.getInstance().getTableDbName()));
        assertTrue(sql.contains("inner join " + ProductStatusDbm.getInstance().getTableDbName()));
        assertTrue(sql.contains("left outer join " + SummaryProductDbm.getInstance().getTableDbName()));
        assertTrue(existsWithdrawal);
    }
}
