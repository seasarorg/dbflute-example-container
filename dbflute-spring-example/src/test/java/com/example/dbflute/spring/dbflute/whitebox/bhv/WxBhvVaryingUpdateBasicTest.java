package com.example.dbflute.spring.dbflute.whitebox.bhv;

import java.sql.Timestamp;
import java.util.Date;

import org.seasar.dbflute.bhv.UpdateOption;
import org.seasar.dbflute.cbean.SpecifyQuery;
import org.seasar.dbflute.cbean.coption.ColumnConversionOption;
import org.seasar.dbflute.exception.QueryIllegalPurposeException;
import org.seasar.dbflute.exception.SpecifyRelationIllegalPurposeException;
import org.seasar.dbflute.exception.VaryingUpdateNotFoundCalculationException;
import org.seasar.dbflute.helper.HandyDate;

import com.example.dbflute.spring.dbflute.cbean.MemberCB;
import com.example.dbflute.spring.dbflute.cbean.PurchaseCB;
import com.example.dbflute.spring.dbflute.exbhv.MemberBhv;
import com.example.dbflute.spring.dbflute.exbhv.PurchaseBhv;
import com.example.dbflute.spring.dbflute.exentity.Member;
import com.example.dbflute.spring.dbflute.exentity.Purchase;
import com.example.dbflute.spring.unit.UnitContainerTestCase;

/**
 * @author jflute
 * @since 0.9.7.2 (2010/06/20 Sunday)
 */
public class WxBhvVaryingUpdateBasicTest extends UnitContainerTestCase {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private PurchaseBhv purchaseBhv;
    private MemberBhv memberBhv;

    // ===================================================================================
    //                                                                                Self
    //                                                                                ====
    public void test_varyingUpdate_self_basic() throws Exception {
        // ## Arrange ##
        Purchase before = purchaseBhv.selectByPKValueWithDeletedCheck(3L);
        Integer purchaseCount = before.getPurchaseCount();
        Purchase purchase = new Purchase();
        purchase.setPurchaseId(3L);
        purchase.setPaymentCompleteFlg_True();
        purchase.setVersionNo(before.getVersionNo());
        UpdateOption<PurchaseCB> option = new UpdateOption<PurchaseCB>();
        option.self(new SpecifyQuery<PurchaseCB>() {
            public void specify(PurchaseCB cb) {
                cb.specify().columnPurchaseCount();
            }
        }).plus(1);

        // ## Act ##
        purchaseBhv.varyingUpdate(purchase, option);

        // ## Assert ##
        Purchase actual = purchaseBhv.selectByPKValueWithDeletedCheck(3L);
        assertEquals(Integer.valueOf(purchaseCount + 1), actual.getPurchaseCount());
        assertEquals(purchase.getVersionNo(), actual.getVersionNo());
        assertEquals(before.getRegisterDatetime(), actual.getRegisterDatetime());
        assertNotSame(before.getUpdateDatetime(), actual.getUpdateDatetime());
    }

    public void test_varyingUpdate_self_callTwice() throws Exception {
        // ## Arrange ##
        Purchase before = purchaseBhv.selectByPKValueWithDeletedCheck(3L);
        Integer purchaseCount = before.getPurchaseCount();
        Integer purchasePrice = before.getPurchasePrice();
        Purchase purchase = new Purchase();
        purchase.setPurchaseId(3L);
        purchase.setPaymentCompleteFlg_True();
        purchase.setVersionNo(before.getVersionNo());
        UpdateOption<PurchaseCB> option = new UpdateOption<PurchaseCB>();
        option.self(new SpecifyQuery<PurchaseCB>() {
            public void specify(PurchaseCB cb) {
                cb.specify().columnPurchaseCount();
            }
        }).plus(1);
        option.self(new SpecifyQuery<PurchaseCB>() {
            public void specify(PurchaseCB cb) {
                cb.specify().columnPurchasePrice();
            }
        }).plus(3);

        // ## Act ##
        purchaseBhv.varyingUpdate(purchase, option);

        // ## Assert ##
        Purchase actual = purchaseBhv.selectByPKValueWithDeletedCheck(3L);
        assertEquals(Integer.valueOf(purchaseCount + 1), actual.getPurchaseCount());
        assertEquals(Integer.valueOf(purchasePrice + 3), actual.getPurchasePrice());
        assertEquals(purchase.getVersionNo(), actual.getVersionNo());
        assertEquals(before.getRegisterDatetime(), actual.getRegisterDatetime());
        assertNotSame(before.getUpdateDatetime(), actual.getUpdateDatetime());
    }

    public void test_varyingUpdate_self_entityValueIgnored() throws Exception {
        // ## Arrange ##
        Purchase before = purchaseBhv.selectByPKValueWithDeletedCheck(3L);
        Integer purchaseCount = before.getPurchaseCount();
        Purchase purchase = new Purchase();
        purchase.setPurchaseId(3L);
        purchase.setPurchaseCount(12345);
        purchase.setPaymentCompleteFlg_True();
        purchase.setVersionNo(before.getVersionNo());
        UpdateOption<PurchaseCB> option = new UpdateOption<PurchaseCB>();
        option.self(new SpecifyQuery<PurchaseCB>() {
            public void specify(PurchaseCB cb) {
                cb.specify().columnPurchaseCount();
            }
        }).plus(1);

        // ## Act ##
        purchaseBhv.varyingUpdate(purchase, option);

        // ## Assert ##
        Purchase actual = purchaseBhv.selectByPKValueWithDeletedCheck(3L);
        assertEquals(Integer.valueOf(purchaseCount + 1), actual.getPurchaseCount());
        assertEquals(purchase.getVersionNo(), actual.getVersionNo());
        assertEquals(before.getRegisterDatetime(), actual.getRegisterDatetime());
        assertNotSame(before.getUpdateDatetime(), actual.getUpdateDatetime());
    }

    public void test_varyingUpdate_self_notAllowedQuery() throws Exception {
        // ## Arrange ##
        Purchase purchase = new Purchase();
        purchase.setPurchaseId(3L);
        purchase.setPurchaseCount(12345);

        UpdateOption<PurchaseCB> option = new UpdateOption<PurchaseCB>();
        option.self(new SpecifyQuery<PurchaseCB>() {
            public void specify(PurchaseCB cb) {
                cb.specify().columnPurchaseCount();
                cb.query();
            }
        }).plus(1);

        // ## Act ##
        try {
            purchaseBhv.varyingUpdate(purchase, option);

            // ## Assert ##
            fail();
        } catch (QueryIllegalPurposeException e) {
            // OK
            log(e.getMessage());
        }
    }

    public void test_varyingUpdate_self_notAllowedRelation() throws Exception {
        // ## Arrange ##
        Purchase purchase = new Purchase();
        purchase.setPurchaseId(3L);
        purchase.setPurchaseCount(12345);

        UpdateOption<PurchaseCB> option = new UpdateOption<PurchaseCB>();
        option.self(new SpecifyQuery<PurchaseCB>() {
            public void specify(PurchaseCB cb) {
                cb.specify().specifyProduct();
            }
        }).plus(1);

        // ## Act ##
        try {
            purchaseBhv.varyingUpdate(purchase, option);

            // ## Assert ##
            fail();
        } catch (SpecifyRelationIllegalPurposeException e) {
            // OK
            log(e.getMessage());
        }
    }

    public void test_varyingUpdate_self_nonCalculation() throws Exception {
        // ## Arrange ##
        Purchase purchase = new Purchase();
        purchase.setPurchaseId(3L);
        purchase.setPaymentCompleteFlg_True();
        UpdateOption<PurchaseCB> option = new UpdateOption<PurchaseCB>();
        option.self(new SpecifyQuery<PurchaseCB>() {
            public void specify(PurchaseCB cb) {
                cb.specify().columnPurchaseCount();
            }
        });

        // ## Act ##
        try {
            purchaseBhv.varyingUpdateNonstrict(purchase, option);

            // ## Assert ##
            fail();
        } catch (VaryingUpdateNotFoundCalculationException e) {
            // OK
            log(e.getMessage());
        }
    }

    // ===================================================================================
    //                                                                             Specify
    //                                                                             =======
    public void test_varyingUpdate_specify_basic() {
        // ## Arrange ##
        Member member = memberBhv.selectByPKValueWithDeletedCheck(3);
        member.setMemberName("foo");
        String preAccount = member.getMemberAccount();
        member.setMemberAccount("bar");
        UpdateOption<MemberCB> option = new UpdateOption<MemberCB>();
        option.specify(new SpecifyQuery<MemberCB>() {
            public void specify(MemberCB cb) {
                cb.specify().columnMemberName();
            }
        });

        // ## Act ##
        memberBhv.varyingUpdate(member, option);

        // ## Assert ##
        Member actual = memberBhv.selectByPKValueWithDeletedCheck(member.getMemberId());
        assertEquals("foo", actual.getMemberName());
        assertEquals(preAccount, actual.getMemberAccount());
    }

    public void test_varyingUpdate_self_left_illegal() throws Exception {
        // ## Arrange ##
        Purchase before = purchaseBhv.selectByPKValueWithDeletedCheck(3L);
        Purchase purchase = new Purchase();
        purchase.setPurchaseId(3L);
        purchase.setPaymentCompleteFlg_True();
        purchase.setVersionNo(before.getVersionNo());
        UpdateOption<PurchaseCB> option = new UpdateOption<PurchaseCB>();
        // ## Act ##
        try {
            option.self(new SpecifyQuery<PurchaseCB>() {
                public void specify(PurchaseCB cb) {
                    cb.specify().columnPurchaseCount();
                }
            }).left().plus(1);

            // ## Assert ##
            fail();
        } catch (IllegalStateException e) {
            // OK
            log(e.getMessage());
        }
    }

    // ===================================================================================
    //                                                                             Convert
    //                                                                             =======
    public void test_varyingUpdate_convert_basic() throws Exception {
        // ## Arrange ##
        Purchase before = purchaseBhv.selectByPKValueWithDeletedCheck(3L);
        Timestamp purchaseDatetime = before.getPurchaseDatetime();
        Purchase purchase = new Purchase();
        purchase.setPurchaseId(3L);
        purchase.setPaymentCompleteFlg_True();
        purchase.setVersionNo(before.getVersionNo());
        UpdateOption<PurchaseCB> option = new UpdateOption<PurchaseCB>();
        option.self(new SpecifyQuery<PurchaseCB>() {
            public void specify(PurchaseCB cb) {
                cb.specify().columnPurchaseDatetime();
            }
        }).convert(new ColumnConversionOption().addDay(12).addMinute(4));

        // ## Act ##
        purchaseBhv.varyingUpdate(purchase, option);

        // ## Assert ##
        Purchase actual = purchaseBhv.selectByPKValueWithDeletedCheck(3L);
        Date expectedDate = new HandyDate(purchaseDatetime).addDay(12).addMinute(4).getDate();
        assertEquals(expectedDate.getTime(), actual.getPurchaseDatetime().getTime());
    }

    // ===================================================================================
    //                                                                           Nonstrict
    //                                                                           =========
    public void test_varyingUpdateNonstrict_plus() throws Exception {
        // ## Arrange ##
        Purchase before = purchaseBhv.selectByPKValueWithDeletedCheck(3L);
        Integer purchaseCount = before.getPurchaseCount();
        Purchase purchase = new Purchase();
        purchase.setPurchaseId(3L);
        purchase.setPaymentCompleteFlg_True();
        UpdateOption<PurchaseCB> option = new UpdateOption<PurchaseCB>();
        option.self(new SpecifyQuery<PurchaseCB>() {
            public void specify(PurchaseCB cb) {
                cb.specify().columnPurchaseCount();
            }
        }).plus(1);

        // ## Act ##
        purchaseBhv.varyingUpdateNonstrict(purchase, option);

        // ## Assert ##
        Purchase actual = purchaseBhv.selectByPKValueWithDeletedCheck(3L);
        assertEquals(Integer.valueOf(purchaseCount + 1), actual.getPurchaseCount());
    }

    public void test_varyingUpdateNonstrict_minus() throws Exception {
        // ## Arrange ##
        Purchase before = purchaseBhv.selectByPKValueWithDeletedCheck(3L);
        Integer purchaseCount = before.getPurchaseCount();
        Purchase purchase = new Purchase();
        purchase.setPurchaseId(3L);
        purchase.setPaymentCompleteFlg_True();
        UpdateOption<PurchaseCB> option = new UpdateOption<PurchaseCB>();
        option.self(new SpecifyQuery<PurchaseCB>() {
            public void specify(PurchaseCB cb) {
                cb.specify().columnPurchaseCount();
            }
        }).minus(1);

        // ## Act ##
        purchaseBhv.varyingUpdateNonstrict(purchase, option);

        // ## Assert ##
        Purchase actual = purchaseBhv.selectByPKValueWithDeletedCheck(3L);
        assertEquals(Integer.valueOf(purchaseCount - 1), actual.getPurchaseCount());
    }

    public void test_varyingUpdateNonstrict_multiply_plus() throws Exception {
        // ## Arrange ##
        Purchase before = purchaseBhv.selectByPKValueWithDeletedCheck(3L);
        before.setPurchaseCount(8);
        purchaseBhv.updateNonstrict(before);
        Integer purchaseCount = before.getPurchaseCount();
        Purchase purchase = new Purchase();
        purchase.setPurchaseId(3L);
        purchase.setPaymentCompleteFlg_True();
        UpdateOption<PurchaseCB> option = new UpdateOption<PurchaseCB>();
        option.self(new SpecifyQuery<PurchaseCB>() {
            public void specify(PurchaseCB cb) {
                cb.specify().columnPurchaseCount();
            }
        }).multiply(2).plus(1);

        // ## Act ##
        purchaseBhv.varyingUpdateNonstrict(purchase, option);

        // ## Assert ##
        Purchase actual = purchaseBhv.selectByPKValueWithDeletedCheck(3L);
        log("actual=" + actual.getPurchaseCount());
        assertEquals(Integer.valueOf((purchaseCount * 2) + 1), actual.getPurchaseCount());
    }

    public void test_varyingUpdateNonstrict_divide() throws Exception {
        // ## Arrange ##
        Purchase before = purchaseBhv.selectByPKValueWithDeletedCheck(3L);
        before.setPurchaseCount(8);
        purchaseBhv.updateNonstrict(before);
        Integer purchaseCount = before.getPurchaseCount();
        Purchase purchase = new Purchase();
        purchase.setPurchaseId(3L);
        purchase.setPaymentCompleteFlg_True();
        UpdateOption<PurchaseCB> option = new UpdateOption<PurchaseCB>();
        option.self(new SpecifyQuery<PurchaseCB>() {
            public void specify(PurchaseCB cb) {
                cb.specify().columnPurchaseCount();
            }
        }).divide(2);

        // ## Act ##
        purchaseBhv.varyingUpdateNonstrict(purchase, option);

        // ## Assert ##
        Purchase actual = purchaseBhv.selectByPKValueWithDeletedCheck(3L);
        log("actual=" + actual.getPurchaseCount());
        assertEquals(Integer.valueOf((purchaseCount / 2)), actual.getPurchaseCount());
    }
}
