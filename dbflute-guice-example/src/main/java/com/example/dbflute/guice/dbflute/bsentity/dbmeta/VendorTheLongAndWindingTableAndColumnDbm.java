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
 * The DB meta of VENDOR_THE_LONG_AND_WINDING_TABLE_AND_COLUMN. (Singleton)
 * @author DBFlute(AutoGenerator)
 */
public class VendorTheLongAndWindingTableAndColumnDbm extends AbstractDBMeta {

    // ===================================================================================
    //                                                                           Singleton
    //                                                                           =========
    private static final VendorTheLongAndWindingTableAndColumnDbm _instance = new VendorTheLongAndWindingTableAndColumnDbm();
    private VendorTheLongAndWindingTableAndColumnDbm() {}
    public static VendorTheLongAndWindingTableAndColumnDbm getInstance() { return _instance; }

    // ===================================================================================
    //                                                                       Current DBDef
    //                                                                       =============
    public DBDef getCurrentDBDef() { return DBCurrent.getInstance().currentDBDef(); }

    // ===================================================================================
    //                                                                    Property Gateway
    //                                                                    ================
    protected final Map<String, PropertyGateway> _epgMap = newHashMap();
    {
        setupEpg(_epgMap, new EpgTheLongAndWindingTableAndColumnId(), "theLongAndWindingTableAndColumnId");
        setupEpg(_epgMap, new EpgTheLongAndWindingTableAndColumnName(), "theLongAndWindingTableAndColumnName");
        setupEpg(_epgMap, new EpgShortName(), "shortName");
        setupEpg(_epgMap, new EpgShortSize(), "shortSize");
    }
    public PropertyGateway findPropertyGateway(String propertyName)
    { return doFindEpg(_epgMap, propertyName); }
    public static class EpgTheLongAndWindingTableAndColumnId implements PropertyGateway {
        public Object read(Entity et) { return ((VendorTheLongAndWindingTableAndColumn)et).getTheLongAndWindingTableAndColumnId(); }
        public void write(Entity et, Object vl) { ((VendorTheLongAndWindingTableAndColumn)et).setTheLongAndWindingTableAndColumnId(ctl(vl)); }
    }
    public static class EpgTheLongAndWindingTableAndColumnName implements PropertyGateway {
        public Object read(Entity et) { return ((VendorTheLongAndWindingTableAndColumn)et).getTheLongAndWindingTableAndColumnName(); }
        public void write(Entity et, Object vl) { ((VendorTheLongAndWindingTableAndColumn)et).setTheLongAndWindingTableAndColumnName((String)vl); }
    }
    public static class EpgShortName implements PropertyGateway {
        public Object read(Entity et) { return ((VendorTheLongAndWindingTableAndColumn)et).getShortName(); }
        public void write(Entity et, Object vl) { ((VendorTheLongAndWindingTableAndColumn)et).setShortName((String)vl); }
    }
    public static class EpgShortSize implements PropertyGateway {
        public Object read(Entity et) { return ((VendorTheLongAndWindingTableAndColumn)et).getShortSize(); }
        public void write(Entity et, Object vl) { ((VendorTheLongAndWindingTableAndColumn)et).setShortSize(cti(vl)); }
    }

    // ===================================================================================
    //                                                                          Table Info
    //                                                                          ==========
    protected final String _tableDbName = "VENDOR_THE_LONG_AND_WINDING_TABLE_AND_COLUMN";
    protected final String _tablePropertyName = "vendorTheLongAndWindingTableAndColumn";
    protected final TableSqlName _tableSqlName = new TableSqlName("EXAMPLEDB.PUBLIC.VENDOR_THE_LONG_AND_WINDING_TABLE_AND_COLUMN", _tableDbName);
    { _tableSqlName.xacceptFilter(DBFluteConfig.getInstance().getTableSqlNameFilter()); }
    public String getTableDbName() { return _tableDbName; }
    public String getTablePropertyName() { return _tablePropertyName; }
    public TableSqlName getTableSqlName() { return _tableSqlName; }

    // ===================================================================================
    //                                                                         Column Info
    //                                                                         ===========
    protected final ColumnInfo _columnTheLongAndWindingTableAndColumnId = cci("THE_LONG_AND_WINDING_TABLE_AND_COLUMN_ID", "THE_LONG_AND_WINDING_TABLE_AND_COLUMN_ID", null, null, true, "theLongAndWindingTableAndColumnId", Long.class, true, false, "BIGINT", 19, 0, null, false, null, null, null, "vendorTheLongAndWindingTableAndColumnRefList", null);
    protected final ColumnInfo _columnTheLongAndWindingTableAndColumnName = cci("THE_LONG_AND_WINDING_TABLE_AND_COLUMN_NAME", "THE_LONG_AND_WINDING_TABLE_AND_COLUMN_NAME", null, null, true, "theLongAndWindingTableAndColumnName", String.class, false, false, "VARCHAR", 200, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnShortName = cci("SHORT_NAME", "SHORT_NAME", null, null, true, "shortName", String.class, false, false, "VARCHAR", 200, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnShortSize = cci("SHORT_SIZE", "SHORT_SIZE", null, null, true, "shortSize", Integer.class, false, false, "INTEGER", 10, 0, null, false, null, null, null, null, null);

    public ColumnInfo columnTheLongAndWindingTableAndColumnId() { return _columnTheLongAndWindingTableAndColumnId; }
    public ColumnInfo columnTheLongAndWindingTableAndColumnName() { return _columnTheLongAndWindingTableAndColumnName; }
    public ColumnInfo columnShortName() { return _columnShortName; }
    public ColumnInfo columnShortSize() { return _columnShortSize; }

    protected List<ColumnInfo> ccil() {
        List<ColumnInfo> ls = newArrayList();
        ls.add(columnTheLongAndWindingTableAndColumnId());
        ls.add(columnTheLongAndWindingTableAndColumnName());
        ls.add(columnShortName());
        ls.add(columnShortSize());
        return ls;
    }

    { initializeInformationResource(); }

    // ===================================================================================
    //                                                                         Unique Info
    //                                                                         ===========
    // -----------------------------------------------------
    //                                       Primary Element
    //                                       ---------------
    protected UniqueInfo cpui() { return hpcpui(columnTheLongAndWindingTableAndColumnId()); }
    public boolean hasPrimaryKey() { return true; }
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
    public ReferrerInfo referrerVendorTheLongAndWindingTableAndColumnRefList() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnTheLongAndWindingTableAndColumnId(), VendorTheLongAndWindingTableAndColumnRefDbm.getInstance().columnTheLongAndWindingTableAndColumnId());
        return cri("FK_VENDOR_THE_LONG_AND_WINDING_TABLE_AND_COLUMN_REF", "vendorTheLongAndWindingTableAndColumnRefList", this, VendorTheLongAndWindingTableAndColumnRefDbm.getInstance(), mp, false, "vendorTheLongAndWindingTableAndColumn");
    }

    // ===================================================================================
    //                                                                        Various Info
    //                                                                        ============

    // ===================================================================================
    //                                                                           Type Name
    //                                                                           =========
    public String getEntityTypeName() { return "com.example.dbflute.guice.dbflute.exentity.VendorTheLongAndWindingTableAndColumn"; }
    public String getConditionBeanTypeName() { return "com.example.dbflute.guice.dbflute.cbean.VendorTheLongAndWindingTableAndColumnCB"; }
    public String getBehaviorTypeName() { return "com.example.dbflute.guice.dbflute.exbhv.VendorTheLongAndWindingTableAndColumnBhv"; }

    // ===================================================================================
    //                                                                         Object Type
    //                                                                         ===========
    public Class<VendorTheLongAndWindingTableAndColumn> getEntityType() { return VendorTheLongAndWindingTableAndColumn.class; }

    // ===================================================================================
    //                                                                     Object Instance
    //                                                                     ===============
    public Entity newEntity() { return newMyEntity(); }
    public VendorTheLongAndWindingTableAndColumn newMyEntity() { return new VendorTheLongAndWindingTableAndColumn(); }

    // ===================================================================================
    //                                                                   Map Communication
    //                                                                   =================
    public void acceptPrimaryKeyMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptPrimaryKeyMap((VendorTheLongAndWindingTableAndColumn)et, mp); }
    public void acceptAllColumnMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptAllColumnMap((VendorTheLongAndWindingTableAndColumn)et, mp); }
    public Map<String, Object> extractPrimaryKeyMap(Entity et) { return doExtractPrimaryKeyMap(et); }
    public Map<String, Object> extractAllColumnMap(Entity et) { return doExtractAllColumnMap(et); }
}
