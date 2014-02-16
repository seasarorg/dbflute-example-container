package com.example.dbflute.guice.dbflute.bsentity.dbmeta;

import java.util.List;
import java.util.Map;

import org.seasar.dbflute.DBDef;
import org.seasar.dbflute.Entity;
import org.seasar.dbflute.dbmeta.AbstractDBMeta;
import org.seasar.dbflute.dbmeta.PropertyGateway;
import org.seasar.dbflute.dbmeta.info.*;
import org.seasar.dbflute.dbmeta.name.*;
import com.example.dbflute.guice.dbflute.allcommon.*;
import com.example.dbflute.guice.dbflute.exentity.*;

/**
 * The DB meta of VENDOR_THE_LONG_AND_WINDING_TABLE_AND_COLUMN_REF. (Singleton)
 * @author DBFlute(AutoGenerator)
 */
public class VendorTheLongAndWindingTableAndColumnRefDbm extends AbstractDBMeta {

    // ===================================================================================
    //                                                                           Singleton
    //                                                                           =========
    private static final VendorTheLongAndWindingTableAndColumnRefDbm _instance = new VendorTheLongAndWindingTableAndColumnRefDbm();
    private VendorTheLongAndWindingTableAndColumnRefDbm() {}
    public static VendorTheLongAndWindingTableAndColumnRefDbm getInstance() { return _instance; }

    // ===================================================================================
    //                                                                       Current DBDef
    //                                                                       =============
    public DBDef getCurrentDBDef() { return DBCurrent.getInstance().currentDBDef(); }

    // ===================================================================================
    //                                                                    Property Gateway
    //                                                                    ================
    protected final Map<String, PropertyGateway> _epgMap = newHashMap();
    {
        setupEpg(_epgMap, new EpgTheLongAndWindingTableAndColumnRefId(), "theLongAndWindingTableAndColumnRefId");
        setupEpg(_epgMap, new EpgTheLongAndWindingTableAndColumnId(), "theLongAndWindingTableAndColumnId");
        setupEpg(_epgMap, new EpgTheLongAndWindingTableAndColumnRefDate(), "theLongAndWindingTableAndColumnRefDate");
        setupEpg(_epgMap, new EpgShortDate(), "shortDate");
    }
    public PropertyGateway findPropertyGateway(String propertyName)
    { return doFindEpg(_epgMap, propertyName); }
    public static class EpgTheLongAndWindingTableAndColumnRefId implements PropertyGateway {
        public Object read(Entity et) { return ((VendorTheLongAndWindingTableAndColumnRef)et).getTheLongAndWindingTableAndColumnRefId(); }
        public void write(Entity et, Object vl) { ((VendorTheLongAndWindingTableAndColumnRef)et).setTheLongAndWindingTableAndColumnRefId(ctl(vl)); }
    }
    public static class EpgTheLongAndWindingTableAndColumnId implements PropertyGateway {
        public Object read(Entity et) { return ((VendorTheLongAndWindingTableAndColumnRef)et).getTheLongAndWindingTableAndColumnId(); }
        public void write(Entity et, Object vl) { ((VendorTheLongAndWindingTableAndColumnRef)et).setTheLongAndWindingTableAndColumnId(ctl(vl)); }
    }
    public static class EpgTheLongAndWindingTableAndColumnRefDate implements PropertyGateway {
        public Object read(Entity et) { return ((VendorTheLongAndWindingTableAndColumnRef)et).getTheLongAndWindingTableAndColumnRefDate(); }
        public void write(Entity et, Object vl) { ((VendorTheLongAndWindingTableAndColumnRef)et).setTheLongAndWindingTableAndColumnRefDate((java.util.Date)vl); }
    }
    public static class EpgShortDate implements PropertyGateway {
        public Object read(Entity et) { return ((VendorTheLongAndWindingTableAndColumnRef)et).getShortDate(); }
        public void write(Entity et, Object vl) { ((VendorTheLongAndWindingTableAndColumnRef)et).setShortDate((java.util.Date)vl); }
    }

    // ===================================================================================
    //                                                                          Table Info
    //                                                                          ==========
    protected final String _tableDbName = "VENDOR_THE_LONG_AND_WINDING_TABLE_AND_COLUMN_REF";
    protected final String _tablePropertyName = "vendorTheLongAndWindingTableAndColumnRef";
    protected final TableSqlName _tableSqlName = new TableSqlName("EXAMPLEDB.PUBLIC.VENDOR_THE_LONG_AND_WINDING_TABLE_AND_COLUMN_REF", _tableDbName);
    { _tableSqlName.xacceptFilter(DBFluteConfig.getInstance().getTableSqlNameFilter()); }
    public String getTableDbName() { return _tableDbName; }
    public String getTablePropertyName() { return _tablePropertyName; }
    public TableSqlName getTableSqlName() { return _tableSqlName; }

    // ===================================================================================
    //                                                                         Column Info
    //                                                                         ===========
    protected final ColumnInfo _columnTheLongAndWindingTableAndColumnRefId = cci("THE_LONG_AND_WINDING_TABLE_AND_COLUMN_REF_ID", "THE_LONG_AND_WINDING_TABLE_AND_COLUMN_REF_ID", null, null, true, "theLongAndWindingTableAndColumnRefId", Long.class, true, false, "BIGINT", 19, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnTheLongAndWindingTableAndColumnId = cci("THE_LONG_AND_WINDING_TABLE_AND_COLUMN_ID", "THE_LONG_AND_WINDING_TABLE_AND_COLUMN_ID", null, null, true, "theLongAndWindingTableAndColumnId", Long.class, false, false, "BIGINT", 19, 0, null, false, null, null, "vendorTheLongAndWindingTableAndColumn", null, null);
    protected final ColumnInfo _columnTheLongAndWindingTableAndColumnRefDate = cci("THE_LONG_AND_WINDING_TABLE_AND_COLUMN_REF_DATE", "THE_LONG_AND_WINDING_TABLE_AND_COLUMN_REF_DATE", null, null, true, "theLongAndWindingTableAndColumnRefDate", java.util.Date.class, false, false, "DATE", 8, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnShortDate = cci("SHORT_DATE", "SHORT_DATE", null, null, true, "shortDate", java.util.Date.class, false, false, "DATE", 8, 0, null, false, null, null, null, null, null);

    public ColumnInfo columnTheLongAndWindingTableAndColumnRefId() { return _columnTheLongAndWindingTableAndColumnRefId; }
    public ColumnInfo columnTheLongAndWindingTableAndColumnId() { return _columnTheLongAndWindingTableAndColumnId; }
    public ColumnInfo columnTheLongAndWindingTableAndColumnRefDate() { return _columnTheLongAndWindingTableAndColumnRefDate; }
    public ColumnInfo columnShortDate() { return _columnShortDate; }

    protected List<ColumnInfo> ccil() {
        List<ColumnInfo> ls = newArrayList();
        ls.add(columnTheLongAndWindingTableAndColumnRefId());
        ls.add(columnTheLongAndWindingTableAndColumnId());
        ls.add(columnTheLongAndWindingTableAndColumnRefDate());
        ls.add(columnShortDate());
        return ls;
    }

    { initializeInformationResource(); }

    // ===================================================================================
    //                                                                         Unique Info
    //                                                                         ===========
    // -----------------------------------------------------
    //                                       Primary Element
    //                                       ---------------
    protected UniqueInfo cpui() { return hpcpui(columnTheLongAndWindingTableAndColumnRefId()); }
    public boolean hasPrimaryKey() { return true; }
    public boolean hasCompoundPrimaryKey() { return false; }

    // ===================================================================================
    //                                                                       Relation Info
    //                                                                       =============
    // -----------------------------------------------------
    //                                      Foreign Property
    //                                      ----------------
    public ForeignInfo foreignVendorTheLongAndWindingTableAndColumn() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnTheLongAndWindingTableAndColumnId(), VendorTheLongAndWindingTableAndColumnDbm.getInstance().columnTheLongAndWindingTableAndColumnId());
        return cfi("FK_VENDOR_THE_LONG_AND_WINDING_TABLE_AND_COLUMN_REF", "vendorTheLongAndWindingTableAndColumn", this, VendorTheLongAndWindingTableAndColumnDbm.getInstance(), mp, 0, false, false, false, false, null, null, false, "vendorTheLongAndWindingTableAndColumnRefList");
    }

    // -----------------------------------------------------
    //                                     Referrer Property
    //                                     -----------------

    // ===================================================================================
    //                                                                        Various Info
    //                                                                        ============

    // ===================================================================================
    //                                                                           Type Name
    //                                                                           =========
    public String getEntityTypeName() { return "com.example.dbflute.guice.dbflute.exentity.VendorTheLongAndWindingTableAndColumnRef"; }
    public String getConditionBeanTypeName() { return "com.example.dbflute.guice.dbflute.cbean.VendorTheLongAndWindingTableAndColumnRefCB"; }
    public String getBehaviorTypeName() { return "com.example.dbflute.guice.dbflute.exbhv.VendorTheLongAndWindingTableAndColumnRefBhv"; }

    // ===================================================================================
    //                                                                         Object Type
    //                                                                         ===========
    public Class<VendorTheLongAndWindingTableAndColumnRef> getEntityType() { return VendorTheLongAndWindingTableAndColumnRef.class; }

    // ===================================================================================
    //                                                                     Object Instance
    //                                                                     ===============
    public Entity newEntity() { return newMyEntity(); }
    public VendorTheLongAndWindingTableAndColumnRef newMyEntity() { return new VendorTheLongAndWindingTableAndColumnRef(); }

    // ===================================================================================
    //                                                                   Map Communication
    //                                                                   =================
    public void acceptPrimaryKeyMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptPrimaryKeyMap((VendorTheLongAndWindingTableAndColumnRef)et, mp); }
    public void acceptAllColumnMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptAllColumnMap((VendorTheLongAndWindingTableAndColumnRef)et, mp); }
    public Map<String, Object> extractPrimaryKeyMap(Entity et) { return doExtractPrimaryKeyMap(et); }
    public Map<String, Object> extractAllColumnMap(Entity et) { return doExtractAllColumnMap(et); }
}
