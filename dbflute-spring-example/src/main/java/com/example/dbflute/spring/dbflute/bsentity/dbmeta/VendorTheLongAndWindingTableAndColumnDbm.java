/*
 * Copyright 2004-2014 the Seasar Foundation and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package com.example.dbflute.spring.dbflute.bsentity.dbmeta;

import java.util.List;
import java.util.Map;

import org.seasar.dbflute.DBDef;
import org.seasar.dbflute.Entity;
import org.seasar.dbflute.dbmeta.AbstractDBMeta;
import org.seasar.dbflute.dbmeta.PropertyGateway;
import org.seasar.dbflute.dbmeta.info.*;
import org.seasar.dbflute.dbmeta.name.*;
import com.example.dbflute.spring.dbflute.allcommon.*;
import com.example.dbflute.spring.dbflute.exentity.*;

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
        public Object read(Entity e) { return ((VendorTheLongAndWindingTableAndColumn)e).getTheLongAndWindingTableAndColumnId(); }
        public void write(Entity e, Object v) { ((VendorTheLongAndWindingTableAndColumn)e).setTheLongAndWindingTableAndColumnId(ctl(v)); }
    }
    public static class EpgTheLongAndWindingTableAndColumnName implements PropertyGateway {
        public Object read(Entity e) { return ((VendorTheLongAndWindingTableAndColumn)e).getTheLongAndWindingTableAndColumnName(); }
        public void write(Entity e, Object v) { ((VendorTheLongAndWindingTableAndColumn)e).setTheLongAndWindingTableAndColumnName((String)v); }
    }
    public static class EpgShortName implements PropertyGateway {
        public Object read(Entity e) { return ((VendorTheLongAndWindingTableAndColumn)e).getShortName(); }
        public void write(Entity e, Object v) { ((VendorTheLongAndWindingTableAndColumn)e).setShortName((String)v); }
    }
    public static class EpgShortSize implements PropertyGateway {
        public Object read(Entity e) { return ((VendorTheLongAndWindingTableAndColumn)e).getShortSize(); }
        public void write(Entity e, Object v) { ((VendorTheLongAndWindingTableAndColumn)e).setShortSize(cti(v)); }
    }

    // ===================================================================================
    //                                                                          Table Info
    //                                                                          ==========
    protected final String _tableDbName = "VENDOR_THE_LONG_AND_WINDING_TABLE_AND_COLUMN";
    protected final String _tablePropertyName = "vendorTheLongAndWindingTableAndColumn";
    protected final TableSqlName _tableSqlName = new TableSqlName("VENDOR_THE_LONG_AND_WINDING_TABLE_AND_COLUMN", _tableDbName);
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
        Map<ColumnInfo, ColumnInfo> map = newLinkedHashMap(columnTheLongAndWindingTableAndColumnId(), VendorTheLongAndWindingTableAndColumnRefDbm.getInstance().columnTheLongAndWindingTableAndColumnId());
        return cri("FK_VENDOR_THE_LONG_AND_WINDING_TABLE_AND_COLUMN_REF", "vendorTheLongAndWindingTableAndColumnRefList", this, VendorTheLongAndWindingTableAndColumnRefDbm.getInstance(), map, false, "vendorTheLongAndWindingTableAndColumn");
    }

    // ===================================================================================
    //                                                                        Various Info
    //                                                                        ============

    // ===================================================================================
    //                                                                           Type Name
    //                                                                           =========
    public String getEntityTypeName() { return "com.example.dbflute.spring.dbflute.exentity.VendorTheLongAndWindingTableAndColumn"; }
    public String getConditionBeanTypeName() { return "com.example.dbflute.spring.dbflute.cbean.VendorTheLongAndWindingTableAndColumnCB"; }
    public String getBehaviorTypeName() { return "com.example.dbflute.spring.dbflute.exbhv.VendorTheLongAndWindingTableAndColumnBhv"; }

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
    public void acceptPrimaryKeyMap(Entity e, Map<String, ? extends Object> m)
    { doAcceptPrimaryKeyMap((VendorTheLongAndWindingTableAndColumn)e, m); }
    public void acceptAllColumnMap(Entity e, Map<String, ? extends Object> m)
    { doAcceptAllColumnMap((VendorTheLongAndWindingTableAndColumn)e, m); }
    public Map<String, Object> extractPrimaryKeyMap(Entity e) { return doExtractPrimaryKeyMap(e); }
    public Map<String, Object> extractAllColumnMap(Entity e) { return doExtractAllColumnMap(e); }
}
