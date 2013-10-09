/*
 * Copyright(c) DBFlute TestCo.,TestLtd. All Rights Reserved.
 */
package com.example.dbflute.cdi.dbflute.cbean.nss;

import org.seasar.dbflute.cbean.ConditionQuery;
import com.example.dbflute.cdi.dbflute.cbean.cq.PurchaseCQ;

/**
 * The nest select set-upper of PURCHASE.
 * @author DBFlute(AutoGenerator)
 */
public class PurchaseNss {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected PurchaseCQ _query;
    public PurchaseNss(PurchaseCQ query) { _query = query; }
    public boolean hasConditionQuery() { return _query != null; }

    // ===================================================================================
    //                                                                     Nested Relation
    //                                                                     ===============
    /**
     * With nested relation columns to select clause. <br />
     * (会員)MEMBER by my MEMBER_ID, named 'member'.
     * @return The set-upper of more nested relation. {...with[nested-relation].with[more-nested-relation]} (NotNull)
     */
    public MemberNss withMember() {
        _query.doNss(new PurchaseCQ.NssCall() { public ConditionQuery qf() { return _query.queryMember(); }});
        return new MemberNss(_query.queryMember());
    }
    /**
     * With nested relation columns to select clause. <br />
     * (商品)PRODUCT by my PRODUCT_ID, named 'product'.
     * @return The set-upper of more nested relation. {...with[nested-relation].with[more-nested-relation]} (NotNull)
     */
    public ProductNss withProduct() {
        _query.doNss(new PurchaseCQ.NssCall() { public ConditionQuery qf() { return _query.queryProduct(); }});
        return new ProductNss(_query.queryProduct());
    }
    /**
     * With nested relation columns to select clause. <br />
     * SUMMARY_PRODUCT by my PRODUCT_ID, named 'summaryProduct'.
     * @return The set-upper of more nested relation. {...with[nested-relation].with[more-nested-relation]} (NotNull)
     */
    public SummaryProductNss withSummaryProduct() {
        _query.doNss(new PurchaseCQ.NssCall() { public ConditionQuery qf() { return _query.querySummaryProduct(); }});
        return new SummaryProductNss(_query.querySummaryProduct());
    }

}
