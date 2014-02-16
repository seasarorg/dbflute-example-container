/*
 * Copyright(c) DBFlute TestCo.,TestLtd. All Rights Reserved.
 */
package com.example.dbflute.cdi.dbflute.bsentity.customize.dbmeta;

import java.util.List;
import java.util.Map;

import org.seasar.dbflute.DBDef;
import org.seasar.dbflute.Entity;
import org.seasar.dbflute.dbmeta.AbstractDBMeta;
import org.seasar.dbflute.dbmeta.PropertyGateway;
import org.seasar.dbflute.dbmeta.info.*;
import org.seasar.dbflute.dbmeta.name.*;
import com.example.dbflute.cdi.dbflute.allcommon.*;
import com.example.dbflute.cdi.dbflute.exentity.customize.*;

/**
 * The DB meta of VendorCheckDecimalSum. (Singleton)
 * @author DBFlute(AutoGenerator)
 */
public class VendorCheckDecimalSumDbm extends AbstractDBMeta {

    // ===================================================================================
    //                                                                           Singleton
    //                                                                           =========
    private static final VendorCheckDecimalSumDbm _instance = new VendorCheckDecimalSumDbm();
    private VendorCheckDecimalSumDbm() {}
    public static VendorCheckDecimalSumDbm getInstance() { return _instance; }

    // ===================================================================================
    //                                                                       Current DBDef
    //                                                                       =============
    public DBDef getCurrentDBDef() { return DBCurrent.getInstance().currentDBDef(); }

    // ===================================================================================
    //                                                                    Property Gateway
    //                                                                    ================
    protected final Map<String, PropertyGateway> _epgMap = newHashMap();
    {
        setupEpg(_epgMap, new EpgDecimalDigitSum(), "decimalDigitSum");
    }
    public PropertyGateway findPropertyGateway(String propertyName)
    { return doFindEpg(_epgMap, propertyName); }
    public static class EpgDecimalDigitSum implements PropertyGateway {
        public Object read(Entity et) { return ((VendorCheckDecimalSum)et).getDecimalDigitSum(); }
        public void write(Entity et, Object vl) { ((VendorCheckDecimalSum)et).setDecimalDigitSum(ctb(vl)); }
    }

    // ===================================================================================
    //                                                                          Table Info
    //                                                                          ==========
    protected final String _tableDbName = "VendorCheckDecimalSum";
    protected final String _tablePropertyName = "vendorCheckDecimalSum";
    protected final TableSqlName _tableSqlName = new TableSqlName("VendorCheckDecimalSum", _tableDbName);
    { _tableSqlName.xacceptFilter(DBFluteConfig.getInstance().getTableSqlNameFilter()); }
    public String getTableDbName() { return _tableDbName; }
    public String getTablePropertyName() { return _tablePropertyName; }
    public TableSqlName getTableSqlName() { return _tableSqlName; }

    // ===================================================================================
    //                                                                         Column Info
    //                                                                         ===========
    protected final ColumnInfo _columnDecimalDigitSum = cci("DECIMAL_DIGIT_SUM", "DECIMAL_DIGIT_SUM", null, null, false, "decimalDigitSum", java.math.BigDecimal.class, false, false, "DECIMAL", 5, 3, null, false, null, null, null, null, null);

    public ColumnInfo columnDecimalDigitSum() { return _columnDecimalDigitSum; }

    protected List<ColumnInfo> ccil() {
        List<ColumnInfo> ls = newArrayList();
        ls.add(columnDecimalDigitSum());
        return ls;
    }

    { initializeInformationResource(); }

    // ===================================================================================
    //                                                                         Unique Info
    //                                                                         ===========
    // -----------------------------------------------------
    //                                       Primary Element
    //                                       ---------------
    protected UniqueInfo cpui() {
        throw new UnsupportedOperationException("The table does not have primary key: " + getTableDbName());
    }
    public boolean hasPrimaryKey() { return false; }
    public boolean hasCompoundPrimaryKey() { return false; }

    // ===================================================================================
    //                                                                       Relation Info
    //                                                                       =============
    // -----------------------------------------------------
    //                                      Foreign Property
    //                                      ----------------

    // -----------------------------------------------------
    //                                     Referrer Property
    //                                     -----------------

    // ===================================================================================
    //                                                                        Various Info
    //                                                                        ============

    // ===================================================================================
    //                                                                           Type Name
    //                                                                           =========
    public String getEntityTypeName() { return "com.example.dbflute.cdi.dbflute.exentity.customize.VendorCheckDecimalSum"; }
    public String getConditionBeanTypeName() { return null; }
    public String getBehaviorTypeName() { return null; }

    // ===================================================================================
    //                                                                         Object Type
    //                                                                         ===========
    public Class<VendorCheckDecimalSum> getEntityType() { return VendorCheckDecimalSum.class; }

    // ===================================================================================
    //                                                                     Object Instance
    //                                                                     ===============
    public Entity newEntity() { return newMyEntity(); }
    public VendorCheckDecimalSum newMyEntity() { return new VendorCheckDecimalSum(); }

    // ===================================================================================
    //                                                                   Map Communication
    //                                                                   =================
    public void acceptPrimaryKeyMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptPrimaryKeyMap((VendorCheckDecimalSum)et, mp); }
    public void acceptAllColumnMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptAllColumnMap((VendorCheckDecimalSum)et, mp); }
    public Map<String, Object> extractPrimaryKeyMap(Entity et) { return doExtractPrimaryKeyMap(et); }
    public Map<String, Object> extractAllColumnMap(Entity et) { return doExtractAllColumnMap(et); }
}
