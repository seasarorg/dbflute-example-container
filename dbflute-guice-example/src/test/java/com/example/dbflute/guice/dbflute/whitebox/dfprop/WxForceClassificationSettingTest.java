package com.example.dbflute.guice.dbflute.whitebox.dfprop;

import java.lang.reflect.Field;

import org.seasar.dbflute.dbmeta.info.ColumnInfo;
import org.seasar.dbflute.exception.IllegalClassificationCodeException;
import org.seasar.dbflute.optional.OptionalObjectConsumer;
import org.seasar.dbflute.util.DfReflectionUtil;

import com.example.dbflute.guice.dbflute.bsentity.dbmeta.PurchaseDbm;
import com.example.dbflute.guice.dbflute.cbean.PurchaseCB;
import com.example.dbflute.guice.dbflute.exbhv.PurchaseBhv;
import com.example.dbflute.guice.dbflute.exentity.Member;
import com.example.dbflute.guice.dbflute.exentity.Purchase;
import com.example.dbflute.guice.unit.UnitContainerTestCase;

/**
 * @author jflute
 * @since 0.9.6.7 (2010/04/01 Thursday)
 */
public class WxForceClassificationSettingTest extends UnitContainerTestCase {

    private PurchaseBhv purchaseBhv;

    public void test_select_correct_classification() throws Exception {
        // ## Arrange ##
        Purchase purchase = new Purchase();
        purchase.setPurchaseId(3L);
        purchase.setPaymentCompleteFlg_True();
        purchaseBhv.updateNonstrict(purchase);

        // ## Act ##
        Purchase actual = purchaseBhv.selectByPK(3L).get();

        // ## Assert ##
        assertNotNull(actual.getPaymentCompleteFlg());
        assertTrue(actual.isPaymentCompleteFlgTrue());
    }

    public void test_select_correct_classification_relation() throws Exception {
        // ## Arrange ##
        PurchaseCB cb = new PurchaseCB();
        cb.setupSelect_Member();
        cb.query().setPurchaseId_Equal(3L);

        // ## Act ##
        Purchase actual = purchaseBhv.selectEntityWithDeletedCheck(cb);

        // ## Assert ##
        assertNotNull(actual.getPaymentCompleteFlg());
        assertTrue(actual.isPaymentCompleteFlgTrue());
        actual.getMember().required(new OptionalObjectConsumer<Member>() {
            public void accept(Member obj) {
                assertNotNull(obj.getMemberStatusCode());
                assertNotNull(obj.getMemberStatusCodeAsMemberStatus());
            }
        });
    }

    public void test_select_illegal_classification() throws Exception {
        // ## Arrange ##
        Purchase purchase = new Purchase();
        purchase.setPurchaseId(3L);
        // because of CheckImplicitSet
        ColumnInfo paymentCompleteFlg = PurchaseDbm.getInstance().columnPaymentCompleteFlg();
        String propertyName = paymentCompleteFlg.getPropertyName();
        Field field = DfReflectionUtil.getWholeField(purchase.getClass(), "_" + propertyName);
        DfReflectionUtil.setValueForcedly(field, purchase, 99999);
        purchase.modifiedProperties().add(propertyName);
        purchaseBhv.updateNonstrict(purchase);

        // ## Act ##
        try {
            purchaseBhv.selectByPK(3L).get();

            // ## Assert ##
            fail();
        } catch (IllegalClassificationCodeException e) {
            // OK
            log(e.getMessage());
        }
    }
}
