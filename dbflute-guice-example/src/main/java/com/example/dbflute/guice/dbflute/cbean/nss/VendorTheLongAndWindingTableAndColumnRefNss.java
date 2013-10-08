package com.example.dbflute.guice.dbflute.cbean.nss;

import org.seasar.dbflute.cbean.ConditionQuery;
import com.example.dbflute.guice.dbflute.cbean.cq.VendorTheLongAndWindingTableAndColumnRefCQ;

/**
 * The nest select set-upper of VENDOR_THE_LONG_AND_WINDING_TABLE_AND_COLUMN_REF.
 * @author DBFlute(AutoGenerator)
 */
public class VendorTheLongAndWindingTableAndColumnRefNss {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected VendorTheLongAndWindingTableAndColumnRefCQ _query;
    public VendorTheLongAndWindingTableAndColumnRefNss(VendorTheLongAndWindingTableAndColumnRefCQ query) { _query = query; }
    public boolean hasConditionQuery() { return _query != null; }

    // ===================================================================================
    //                                                                     Nested Relation
    //                                                                     ===============
    /**
     * With nested relation columns to select clause. <br />
     * VENDOR_THE_LONG_AND_WINDING_TABLE_AND_COLUMN by my THE_LONG_AND_WINDING_TABLE_AND_COLUMN_ID, named 'vendorTheLongAndWindingTableAndColumn'.
     * @return The set-upper of more nested relation. {...with[nested-relation].with[more-nested-relation]} (NotNull)
     */
    public VendorTheLongAndWindingTableAndColumnNss withVendorTheLongAndWindingTableAndColumn() {
        _query.doNss(new VendorTheLongAndWindingTableAndColumnRefCQ.NssCall() { public ConditionQuery qf() { return _query.queryVendorTheLongAndWindingTableAndColumn(); }});
        return new VendorTheLongAndWindingTableAndColumnNss(_query.queryVendorTheLongAndWindingTableAndColumn());
    }

}
