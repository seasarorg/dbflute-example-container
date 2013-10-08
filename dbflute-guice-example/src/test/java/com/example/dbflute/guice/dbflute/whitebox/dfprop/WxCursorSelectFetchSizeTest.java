package com.example.dbflute.guice.dbflute.whitebox.dfprop;

import com.example.dbflute.guice.dbflute.allcommon.DBFluteConfig;
import com.example.dbflute.guice.unit.PlainTestCase;

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
