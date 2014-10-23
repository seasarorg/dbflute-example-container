package com.example.dbflute.spring.dbflute.whitebox.outsidesql;

import org.seasar.dbflute.unit.core.PlainTestCase;

import com.example.dbflute.spring.dbflute.exentity.customize.UndetectableClassificationHint;

/**
 * @author jflute
 * @since 1.1.0 (2014/10/22 Wednesday)
 */
public class WxSql2EntityCustomizeEntityBasicTest extends PlainTestCase {

    // ===================================================================================
    //                                                                           Empty Set
    //                                                                           =========
    public void test_UndetectableClassificationHint_basic() {
        // ## Arrange ##
        UndetectableClassificationHint hint = new UndetectableClassificationHint();

        // ## Act ##
        hint.setMemberStatusCode_Formalized(); // expects generated

        // ## Assert ##
        assertTrue(hint.isMemberStatusCodeFormalized());
    }
}
