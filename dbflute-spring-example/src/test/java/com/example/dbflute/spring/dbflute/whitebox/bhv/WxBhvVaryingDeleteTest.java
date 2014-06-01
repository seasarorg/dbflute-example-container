package com.example.dbflute.spring.dbflute.whitebox.bhv;

import java.util.List;

import org.seasar.dbflute.bhv.DeleteOption;
import org.seasar.dbflute.exception.OptimisticLockColumnValueNullException;
import org.seasar.dbflute.util.DfCollectionUtil;

import com.example.dbflute.spring.dbflute.cbean.PurchaseCB;
import com.example.dbflute.spring.dbflute.cbean.PurchasePaymentCB;
import com.example.dbflute.spring.dbflute.exbhv.PurchaseBhv;
import com.example.dbflute.spring.dbflute.exbhv.PurchasePaymentBhv;
import com.example.dbflute.spring.dbflute.exentity.Purchase;
import com.example.dbflute.spring.unit.UnitContainerTestCase;

/**
 * @author jflute
 * @since 0.9.7.2 (2010/06/20 Sunday)
 */
public class WxBhvVaryingDeleteTest extends UnitContainerTestCase {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private PurchaseBhv purchaseBhv;
    private PurchasePaymentBhv purchasePaymentBhv;

    // ===================================================================================
    //                                                                               Basic
    //                                                                               =====
    public void test_varyingDelete_basic() throws Exception {
        // ## Arrange ##
        purchasePaymentBhv.varyingQueryDelete(new PurchasePaymentCB(),
                new DeleteOption<PurchasePaymentCB>().allowNonQueryDelete());
        PurchaseCB cb = new PurchaseCB();
        cb.query().setMemberId_InScope(DfCollectionUtil.newArrayList(1, 3, 7));
        List<Purchase> purchaseList = purchaseBhv.selectList(cb);
        DeleteOption<PurchaseCB> option = new DeleteOption<PurchaseCB>();

        // ## Act ##
        purchaseBhv.varyingBatchDelete(purchaseList, option);

        // ## Assert ##
        List<Purchase> actualList = purchaseBhv.selectList(cb);
        assertEquals(0, actualList.size());
    }

    public void test_varyingDelete_noOptimistickLockValue() throws Exception {
        // ## Arrange ##
        PurchaseCB cb = new PurchaseCB();
        cb.query().setMemberId_InScope(DfCollectionUtil.newArrayList(1, 3, 7));
        List<Purchase> purchaseList = purchaseBhv.selectList(cb);
        DeleteOption<PurchaseCB> option = new DeleteOption<PurchaseCB>();
        for (Purchase purchase : purchaseList) {
            purchase.setVersionNo(null);
        }

        // ## Act ##
        try {
            purchaseBhv.varyingBatchDelete(purchaseList, option);

            // ## Assert ##
            fail();
        } catch (OptimisticLockColumnValueNullException e) {
            // OK
            log(e.getMessage());
        }
    }

    // ===================================================================================
    //                                                                           Nonstrict
    //                                                                           =========
    public void test_varyingDeleteNonstrict_basic() throws Exception {
        // ## Arrange ##
        purchasePaymentBhv.varyingQueryDelete(new PurchasePaymentCB(),
                new DeleteOption<PurchasePaymentCB>().allowNonQueryDelete());

        PurchaseCB cb = new PurchaseCB();
        cb.query().setMemberId_InScope(DfCollectionUtil.newArrayList(1, 3, 7));
        List<Purchase> purchaseList = purchaseBhv.selectList(cb);
        DeleteOption<PurchaseCB> option = new DeleteOption<PurchaseCB>();
        for (Purchase purchase : purchaseList) {
            purchase.setVersionNo(null);
        }

        // ## Act ##
        purchaseBhv.varyingBatchDeleteNonstrict(purchaseList, option);

        // ## Assert ##
        List<Purchase> actualList = purchaseBhv.selectList(cb);
        assertEquals(0, actualList.size());
    }
}
