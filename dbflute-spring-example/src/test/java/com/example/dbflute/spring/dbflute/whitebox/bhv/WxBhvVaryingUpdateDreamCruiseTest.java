package com.example.dbflute.spring.dbflute.whitebox.bhv;

import org.seasar.dbflute.bhv.UpdateOption;
import org.seasar.dbflute.cbean.SpecifyQuery;
import org.seasar.dbflute.exception.IllegalConditionBeanOperationException;

import com.example.dbflute.spring.dbflute.cbean.PurchaseCB;
import com.example.dbflute.spring.dbflute.exbhv.PurchaseBhv;
import com.example.dbflute.spring.dbflute.exentity.Purchase;
import com.example.dbflute.spring.unit.UnitContainerTestCase;

/**
 * @author jflute
 * @since 1.0.5K (2014/07/29 Tuesday)
 */
public class WxBhvVaryingUpdateDreamCruiseTest extends UnitContainerTestCase {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private PurchaseBhv purchaseBhv;

    // ===================================================================================
    //                                                                  Option Calculation
    //                                                                  ==================
    public void test_varyingUpdateNonstrict_DreamCruise_OptionCalculation_basic() throws Exception {
        // ## Arrange ##
        Purchase before = purchaseBhv.selectByPKValueWithDeletedCheck(3L);
        Integer purchaseCount = before.getPurchaseCount();
        Purchase purchase = new Purchase();
        purchase.setPurchaseId(3L);
        purchase.setPaymentCompleteFlg_True();
        UpdateOption<PurchaseCB> option = new UpdateOption<PurchaseCB>();
        final PurchaseCB purchaseCB = new PurchaseCB();
        option.self(new SpecifyQuery<PurchaseCB>() {
            public void specify(PurchaseCB cb) {
                cb.specify().columnPurchaseCount(); // calculation unsupported here
            }
        }).plus(purchaseCB.dreamCruiseCB().specify().columnPurchasePrice());

        // ## Act ##
        purchaseBhv.varyingUpdateNonstrict(purchase, option);

        // ## Assert ##
        Purchase actual = purchaseBhv.selectByPKValueWithDeletedCheck(3L);
        assertEquals(Integer.valueOf(purchaseCount + actual.getPurchasePrice()), actual.getPurchaseCount());
    }

    public void test_varyingUpdateNonstrict_DreamCruise_OptionCalculation_chain() throws Exception {
        // ## Arrange ##
        Purchase before = purchaseBhv.selectByPKValueWithDeletedCheck(3L);
        Integer purchaseCount = before.getPurchaseCount();
        Purchase purchase = new Purchase();
        purchase.setPurchaseId(3L);
        purchase.setPaymentCompleteFlg_True();
        UpdateOption<PurchaseCB> option = new UpdateOption<PurchaseCB>();
        final PurchaseCB purchaseCB = new PurchaseCB();
        option.self(new SpecifyQuery<PurchaseCB>() {
            public void specify(PurchaseCB cb) {
                cb.specify().columnPurchaseCount(); // calculation unsupported here
            }
        }).multiply(3).plus(purchaseCB.dreamCruiseCB().specify().columnPurchasePrice());

        // ## Act ##
        purchaseBhv.varyingUpdateNonstrict(purchase, option);

        // ## Assert ##
        Purchase actual = purchaseBhv.selectByPKValueWithDeletedCheck(3L);
        assertEquals(Integer.valueOf((purchaseCount * 3) + actual.getPurchasePrice()), actual.getPurchaseCount());
    }

    // ===================================================================================
    //                                                                 Specify Calculation
    //                                                                 ===================
    public void test_varyingUpdateNonstrict_DreamCruise_SpecifyCalculation() throws Exception {
        // ## Arrange ##
        Purchase purchase = new Purchase();
        purchase.setPurchaseId(3L);
        purchase.setPaymentCompleteFlg_True();
        UpdateOption<PurchaseCB> option = new UpdateOption<PurchaseCB>();
        final PurchaseCB purchaseCB = new PurchaseCB();
        option.self(new SpecifyQuery<PurchaseCB>() {
            public void specify(PurchaseCB cb) {
                cb.specify().columnPurchaseCount().plus(purchaseCB.dreamCruiseCB().specify().columnPurchasePrice());
            }
        }).plus(3);

        // ## Act ##
        try {
            purchaseBhv.varyingUpdateNonstrict(purchase, option);
            // ## Assert ##
            fail();
        } catch (IllegalConditionBeanOperationException e) {
            log(e.getMessage());
        }
    }
}
