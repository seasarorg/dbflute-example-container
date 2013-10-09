/*
 * Copyright(c) DBFlute TestCo.,TestLtd. All Rights Reserved.
 */
package com.example.dbflute.cdi.dbflute.cbean.nss;

import com.example.dbflute.cdi.dbflute.cbean.cq.MemberStatusCQ;

/**
 * The nest select set-upper of MEMBER_STATUS.
 * @author DBFlute(AutoGenerator)
 */
public class MemberStatusNss {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected MemberStatusCQ _query;
    public MemberStatusNss(MemberStatusCQ query) { _query = query; }
    public boolean hasConditionQuery() { return _query != null; }

    // ===================================================================================
    //                                                                     Nested Relation
    //                                                                     ===============

}
