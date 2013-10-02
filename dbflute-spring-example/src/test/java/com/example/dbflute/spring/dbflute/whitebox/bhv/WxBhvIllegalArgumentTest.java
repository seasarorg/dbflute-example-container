package com.example.dbflute.spring.dbflute.whitebox.bhv;

import org.seasar.dbflute.exception.IllegalConditionBeanOperationException;

import com.example.dbflute.spring.dbflute.cbean.MemberCB;
import com.example.dbflute.spring.dbflute.exbhv.MemberBhv;
import com.example.dbflute.spring.unit.UnitContainerTestCase;

/**
 * @author jflute
 * @since 0.6.0 (2008/01/16 Wednesday)
 */
public class WxBhvIllegalArgumentTest extends UnitContainerTestCase {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private MemberBhv memberBhv;

    // ===================================================================================
    //                                                                       Entity Select
    //                                                                       =============
    public void test_selectEntity_null() {
        // ## Arrange ##
        // ## Act ##
        try {
            memberBhv.selectEntity(null);

            // ## Assert ##
            fail();
        } catch (IllegalArgumentException e) {
            // OK
            log(e.getMessage());
        }
    }

    public void test_selectEntity_invalidCB() {
        // ## Arrange ##
        // ## Act ##
        try {
            memberBhv.selectEntity(new MemberCB().dreamCruiseCB());

            // ## Assert ##
            fail();
        } catch (IllegalConditionBeanOperationException e) {
            // OK
            log(e.getMessage());
        }
    }

    public void test_selectEntityWithDeletedCheck_null() {
        // ## Arrange ##
        // ## Act ##
        try {
            memberBhv.selectEntityWithDeletedCheck(null);

            // ## Assert ##
            fail();
        } catch (IllegalArgumentException e) {
            // OK
            log(e.getMessage());
        }
    }

    public void test_selectEntityWithDeletedCheck_invalidCB() {
        // ## Arrange ##
        // ## Act ##
        try {
            memberBhv.selectEntityWithDeletedCheck(new MemberCB().dreamCruiseCB());

            // ## Assert ##
            fail();
        } catch (IllegalConditionBeanOperationException e) {
            // OK
            log(e.getMessage());
        }
    }
}
