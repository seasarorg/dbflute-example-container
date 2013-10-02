package com.example.dbflute.spring.dbflute.whitebox.cbean;

import org.seasar.dbflute.unit.core.PlainTestCase;

import com.example.dbflute.spring.dbflute.cbean.MemberCB;

/**
 * @author jflute
 */
public class WxCBPrimaryKeyTest extends PlainTestCase {

    // ===================================================================================
    //                                                                  acceptPrimaryKey()
    //                                                                  ==================
    public void test_acceptPrimaryKey() {
        // ## Arrange ##
        MemberCB cb = new MemberCB();

        // ## Act ##
        cb.acceptPrimaryKey(3);

        // ## Assert ##
        assertEquals(3, cb.query().getMemberId().getFixedQuery().get("equal"));
    }
}
