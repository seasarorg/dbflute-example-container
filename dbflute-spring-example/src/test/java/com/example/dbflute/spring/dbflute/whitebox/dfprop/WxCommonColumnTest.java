package com.example.dbflute.spring.dbflute.whitebox.dfprop;

import java.util.List;

import org.seasar.dbflute.dbmeta.info.ColumnInfo;

import com.example.dbflute.spring.dbflute.bsentity.dbmeta.MemberDbm;
import com.example.dbflute.spring.dbflute.bsentity.dbmeta.PurchaseDbm;
import com.example.dbflute.spring.unit.UnitContainerTestCase;

/**
 * @author jflute
 * @since 0.9.7.7 (2010/12/12 Sunday)
 */
public class WxCommonColumnTest extends UnitContainerTestCase {

    // ===================================================================================
    //                                                                          ColumnInfo
    //                                                                          ==========
    public void test_CommonColumn_DBMeta() {
        // ## Arrange ##
        MemberDbm dbm = MemberDbm.getInstance();

        // ## Act ##
        List<ColumnInfo> commonColumnList = dbm.getCommonColumnInfoList();
        List<ColumnInfo> beforeInsertList = dbm.getCommonColumnInfoBeforeInsertList();
        List<ColumnInfo> beforeUpdateList = dbm.getCommonColumnInfoBeforeUpdateList();

        // ## Assert ##
        assertNotSame(0, commonColumnList.size());
        assertEquals(dbm.columnRegisterDatetime(), commonColumnList.get(0));
        assertEquals(dbm.columnRegisterUser(), commonColumnList.get(1));
        assertEquals(dbm.columnUpdateDatetime(), commonColumnList.get(2));
        assertEquals(dbm.columnUpdateUser(), commonColumnList.get(3));
        assertEquals(PurchaseDbm.getInstance().getCommonColumnInfoList().size(), commonColumnList.size());
        assertNotSame(0, beforeInsertList.size());
        assertNotSame(0, beforeUpdateList.size());
        assertTrue(beforeInsertList.size() > beforeUpdateList.size());
    }
}