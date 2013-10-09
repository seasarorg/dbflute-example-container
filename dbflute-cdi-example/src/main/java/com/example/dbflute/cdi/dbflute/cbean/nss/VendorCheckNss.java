/*
 * Copyright(c) DBFlute TestCo.,TestLtd. All Rights Reserved.
 */
package com.example.dbflute.cdi.dbflute.cbean.nss;

import com.example.dbflute.cdi.dbflute.cbean.cq.VendorCheckCQ;

/**
 * The nest select set-upper of VENDOR_CHECK.
 * @author DBFlute(AutoGenerator)
 */
public class VendorCheckNss {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected VendorCheckCQ _query;
    public VendorCheckNss(VendorCheckCQ query) { _query = query; }
    public boolean hasConditionQuery() { return _query != null; }

    // ===================================================================================
    //                                                                     Nested Relation
    //                                                                     ===============

}
