/*
 * Copyright(c) DBFlute TestCo.,TestLtd. All Rights Reserved.
 */
package com.example.dbflute.cdi.dbflute.cbean.nss;

import com.example.dbflute.cdi.dbflute.cbean.cq.RegionCQ;

/**
 * The nest select set-upper of REGION.
 * @author DBFlute(AutoGenerator)
 */
public class RegionNss {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected RegionCQ _query;
    public RegionNss(RegionCQ query) { _query = query; }
    public boolean hasConditionQuery() { return _query != null; }

    // ===================================================================================
    //                                                                     Nested Relation
    //                                                                     ===============

}
