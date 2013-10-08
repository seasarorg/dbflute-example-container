package com.example.dbflute.guice.dbflute.whitebox.dfprop;

import com.example.dbflute.guice.dbflute.bsentity.dbmeta.MemberDbm;
import com.example.dbflute.guice.dbflute.bsentity.dbmeta.PurchaseDbm;
import com.example.dbflute.guice.unit.PlainTestCase;

/**
 * @author jflute
 */
public class WxAddingCatalogTest extends PlainTestCase {

    public void test_DBMeta_tableSqlName_with_catalog_schema() {
        // ## Arrange ##
        String prefix = "EXAMPLEDB.PUBLIC.";
        MemberDbm memberDbm = MemberDbm.getInstance();
        PurchaseDbm purchaseDbm = PurchaseDbm.getInstance();

        // ## Act & Assert ##
        assertEquals(prefix + memberDbm.getTableDbName(), memberDbm.getTableSqlName().toString());
        assertEquals(prefix + purchaseDbm.getTableDbName(), purchaseDbm.getTableSqlName().toString());
    }
}
