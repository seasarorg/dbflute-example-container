package com.example.dbflute.guice.dbflute.whitebox.dfprop;

import org.seasar.dbflute.unit.core.PlainTestCase;

import com.example.dbflute.guice.dbflute.allcommon.DBFluteConfig;

/**
 * @author jflute
 * @since 0.9.9.4A (2012/04/07 Saturday)
 */
public class WxCursorSelectFetchSizeTest extends PlainTestCase {

    // ===================================================================================
    //                                                                               Basic
    //                                                                               =====
    public void test_dbmeta() {
        assertEquals(17, DBFluteConfig.getInstance().getCursorSelectFetchSize());
    }
}
