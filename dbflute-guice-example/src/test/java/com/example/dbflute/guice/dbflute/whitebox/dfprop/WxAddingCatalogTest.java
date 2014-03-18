package com.example.dbflute.guice.dbflute.whitebox.dfprop;

import org.seasar.dbflute.unit.core.PlainTestCase;

import com.example.dbflute.guice.dbflute.bsentity.dbmeta.MemberDbm;
import com.example.dbflute.guice.dbflute.bsentity.dbmeta.PurchaseDbm;

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
