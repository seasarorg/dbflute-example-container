package com.example.dbflute.guice.dbflute.whitebox.dfprop;

import org.seasar.dbflute.exception.IllegalClassificationCodeException;

import com.example.dbflute.guice.dbflute.bsentity.dbmeta.PurchaseDbm;
import com.example.dbflute.guice.dbflute.exentity.Purchase;
import com.example.dbflute.guice.unit.PlainTestCase;

/**
 * @author jflute
 * @since 0.9.9.1B (2011/10/17 Monday)
 */
public class WxCheckImplicitSetClassificationTest extends PlainTestCase {

    public void test_select_correct_classification() throws Exception {
        // ## Arrange ##
        Purchase purchase = new Purchase();

        // ## Act ##
        try {
            PurchaseDbm.getInstance().columnPaymentCompleteFlg().write(purchase, 99999);

            // ## Assert ##
            fail();
        } catch (IllegalClassificationCodeException e) {
            log(e.getMessage());
        }
    }
}
