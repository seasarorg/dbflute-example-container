package com.example.dbflute.spring.dbflute.whitebox.bhv;

import java.util.ArrayList;
import java.util.List;

import org.seasar.dbflute.CallbackContext;
import org.seasar.dbflute.bhv.UpdateOption;
import org.seasar.dbflute.cbean.SpecifyQuery;
import org.seasar.dbflute.exception.IllegalConditionBeanOperationException;
import org.seasar.dbflute.jdbc.SqlLogHandler;
import org.seasar.dbflute.jdbc.SqlLogInfo;

import com.example.dbflute.spring.dbflute.cbean.PurchaseCB;
import com.example.dbflute.spring.dbflute.exbhv.PurchaseBhv;
import com.example.dbflute.spring.dbflute.exentity.Purchase;
import com.example.dbflute.spring.unit.UnitContainerTestCase;

/**
 * @author jflute
 * @since 1.0.1 (2012/12/15 Saturday)
 */
public class WxBhvDreamCruiseUpdateBasicTest extends UnitContainerTestCase {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private PurchaseBhv purchaseBhv;

    // ===================================================================================
    //                                                                       Entity Update
    //                                                                       =============
    public void test_varyingUpdate_SelfCalculation_DreamCruise_plain() {
        // ## Arrange ##
        Purchase purchase = new Purchase();
        purchase.setPurchaseId(3L);
        purchase.setPaymentCompleteFlg_True();

        try {
            final List<SqlLogInfo> infoList = new ArrayList<SqlLogInfo>();
            CallbackContext.setSqlLogHandlerOnThread(new SqlLogHandler() {
                public void handle(SqlLogInfo info) {
                    infoList.add(info);
                }
            });

            // ## Act ##
            PurchaseCB cb = new PurchaseCB();
            PurchaseCB dreamCruiseCB = cb.dreamCruiseCB();
            UpdateOption<PurchaseCB> option = new UpdateOption<PurchaseCB>();
            option.self(new SpecifyQuery<PurchaseCB>() {
                public void specify(PurchaseCB cb) {
                    cb.specify().columnPurchasePrice();
                }
            }).multiply(dreamCruiseCB.specify().columnPurchaseCount());
            purchaseBhv.varyingUpdateNonstrict(purchase, option);

            // ## Assert ##
            assertHasOnlyOneElement(infoList);
            SqlLogInfo info = infoList.get(0);
            String sql = info.getDisplaySql();
            assertTrue(sql.contains("set PURCHASE_PRICE = PURCHASE_PRICE * PURCHASE_COUNT"));
            assertTrue(sql.contains(", VERSION_NO = VERSION_NO + 1"));
        } finally {
            CallbackContext.clearSqlLogHandlerOnThread();
        }
    }

    // ===================================================================================
    //                                                                        Query Update
    //                                                                        ============
    public void test_varyingQueryUpdate_SelfCalculation_DreamCruise_plain() {
        // ## Arrange ##
        Purchase purchase = new Purchase();
        purchase.setPaymentCompleteFlg_True();

        PurchaseCB cb = new PurchaseCB();
        cb.query().setPaymentCompleteFlg_Equal_True();

        try {
            final List<SqlLogInfo> infoList = new ArrayList<SqlLogInfo>();
            CallbackContext.setSqlLogHandlerOnThread(new SqlLogHandler() {
                public void handle(SqlLogInfo info) {
                    infoList.add(info);
                }
            });
            // ## Act ##
            PurchaseCB dreamCruiseCB = cb.dreamCruiseCB();
            UpdateOption<PurchaseCB> option = new UpdateOption<PurchaseCB>();
            option.self(new SpecifyQuery<PurchaseCB>() {
                public void specify(PurchaseCB cb) {
                    cb.specify().columnPurchasePrice();
                }
            }).multiply(dreamCruiseCB.specify().columnPurchaseCount());
            int updatedCount = purchaseBhv.varyingQueryUpdate(purchase, cb, option);

            // ## Assert ##
            assertNotSame(0, updatedCount);
            assertHasOnlyOneElement(infoList);
            SqlLogInfo info = infoList.get(0);
            String sql = info.getDisplaySql();
            assertTrue(sql.contains("set PURCHASE_PRICE = PURCHASE_PRICE * PURCHASE_COUNT"));
            assertTrue(sql.contains(", VERSION_NO = VERSION_NO + 1"));
        } finally {
            CallbackContext.clearSqlLogHandlerOnThread();
        }
    }

    public void test_varyingQueryUpdate_SelfCalculation_DreamCruise_joined() {
        // ## Arrange ##
        Purchase purchase = new Purchase();
        purchase.setPaymentCompleteFlg_True();

        PurchaseCB cb = new PurchaseCB();
        cb.query().queryMember().setMemberStatusCode_Equal_Formalized();
        cb.query().setPaymentCompleteFlg_Equal_True();

        try {
            // ## Act ##
            PurchaseCB dreamCruiseCB = cb.dreamCruiseCB();
            UpdateOption<PurchaseCB> option = new UpdateOption<PurchaseCB>();
            option.self(new SpecifyQuery<PurchaseCB>() {
                public void specify(PurchaseCB cb) {
                    cb.specify().columnPurchasePrice();
                }
            }).multiply(dreamCruiseCB.specify().columnPurchaseCount())
                    .divide(dreamCruiseCB.specify().specifyMember().columnMemberId());
            purchaseBhv.varyingQueryUpdate(purchase, cb, option);

            // ## Assert ##
            fail();
        } catch (IllegalConditionBeanOperationException e) {
            // OK
            log(e.getMessage());
        }
    }
}
