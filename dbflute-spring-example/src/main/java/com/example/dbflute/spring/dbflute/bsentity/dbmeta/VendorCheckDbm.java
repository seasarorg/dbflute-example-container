/*
 * Copyright 2004-2013 the Seasar Foundation and the Others.
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
 * The DB meta of VENDOR_CHECK. (Singleton)
 * @author DBFlute(AutoGenerator)
 */
public class VendorCheckDbm extends AbstractDBMeta {

    // ===================================================================================
    //                                                                           Singleton
    //                                                                           =========
    private static final VendorCheckDbm _instance = new VendorCheckDbm();
    private VendorCheckDbm() {}
    public static VendorCheckDbm getInstance() { return _instance; }

    // ===================================================================================
    //                                                                       Current DBDef
    //                                                                       =============
    public DBDef getCurrentDBDef() { return DBCurrent.getInstance().currentDBDef(); }

    // ===================================================================================
    //                                                                    Property Gateway
    //                                                                    ================
    protected final Map<String, PropertyGateway> _epgMap = newHashMap();
    {
        setupEpg(_epgMap, new EpgVendorCheckId(), "vendorCheckId");
        setupEpg(_epgMap, new EpgTypeOfChar(), "typeOfChar");
        setupEpg(_epgMap, new EpgTypeOfVarchar(), "typeOfVarchar");
        setupEpg(_epgMap, new EpgTypeOfClob(), "typeOfClob");
        setupEpg(_epgMap, new EpgTypeOfText(), "typeOfText");
        setupEpg(_epgMap, new EpgTypeOfNumericInteger(), "typeOfNumericInteger");
        setupEpg(_epgMap, new EpgTypeOfNumericBigint(), "typeOfNumericBigint");
        setupEpg(_epgMap, new EpgTypeOfNumericDecimal(), "typeOfNumericDecimal");
        setupEpg(_epgMap, new EpgTypeOfNumericIntegerMin(), "typeOfNumericIntegerMin");
        setupEpg(_epgMap, new EpgTypeOfNumericIntegerMax(), "typeOfNumericIntegerMax");
        setupEpg(_epgMap, new EpgTypeOfNumericBigintMin(), "typeOfNumericBigintMin");
        setupEpg(_epgMap, new EpgTypeOfNumericBigintMax(), "typeOfNumericBigintMax");
        setupEpg(_epgMap, new EpgTypeOfNumericSuperintMin(), "typeOfNumericSuperintMin");
        setupEpg(_epgMap, new EpgTypeOfNumericSuperintMax(), "typeOfNumericSuperintMax");
        setupEpg(_epgMap, new EpgTypeOfNumericMaxdecimal(), "typeOfNumericMaxdecimal");
        setupEpg(_epgMap, new EpgTypeOfInteger(), "typeOfInteger");
        setupEpg(_epgMap, new EpgTypeOfBigint(), "typeOfBigint");
        setupEpg(_epgMap, new EpgTypeOfDate(), "typeOfDate");
        setupEpg(_epgMap, new EpgTypeOfTimestamp(), "typeOfTimestamp");
        setupEpg(_epgMap, new EpgTypeOfTime(), "typeOfTime");
        setupEpg(_epgMap, new EpgTypeOfBoolean(), "typeOfBoolean");
        setupEpg(_epgMap, new EpgTypeOfBinary(), "typeOfBinary");
        setupEpg(_epgMap, new EpgTypeOfBlob(), "typeOfBlob");
        setupEpg(_epgMap, new EpgTypeOfUuid(), "typeOfUuid");
        setupEpg(_epgMap, new EpgTypeOfArray(), "typeOfArray");
        setupEpg(_epgMap, new EpgTypeOfOther(), "typeOfOther");
        setupEpg(_epgMap, new EpgJAVABeansProperty(), "JAVABeansProperty");
        setupEpg(_epgMap, new EpgJPopBeansProperty(), "JPopBeansProperty");
    }
    public PropertyGateway findPropertyGateway(String propertyName)
    { return doFindEpg(_epgMap, propertyName); }
    public static class EpgVendorCheckId implements PropertyGateway {
        public Object read(Entity e) { return ((VendorCheck)e).getVendorCheckId(); }
        public void write(Entity e, Object v) { ((VendorCheck)e).setVendorCheckId(ctl(v)); }
    }
    public static class EpgTypeOfChar implements PropertyGateway {
        public Object read(Entity e) { return ((VendorCheck)e).getTypeOfChar(); }
        public void write(Entity e, Object v) { ((VendorCheck)e).setTypeOfChar((String)v); }
    }
    public static class EpgTypeOfVarchar implements PropertyGateway {
        public Object read(Entity e) { return ((VendorCheck)e).getTypeOfVarchar(); }
        public void write(Entity e, Object v) { ((VendorCheck)e).setTypeOfVarchar((String)v); }
    }
    public static class EpgTypeOfClob implements PropertyGateway {
        public Object read(Entity e) { return ((VendorCheck)e).getTypeOfClob(); }
        public void write(Entity e, Object v) { ((VendorCheck)e).setTypeOfClob((String)v); }
    }
    public static class EpgTypeOfText implements PropertyGateway {
        public Object read(Entity e) { return ((VendorCheck)e).getTypeOfText(); }
        public void write(Entity e, Object v) { ((VendorCheck)e).setTypeOfText((String)v); }
    }
    public static class EpgTypeOfNumericInteger implements PropertyGateway {
        public Object read(Entity e) { return ((VendorCheck)e).getTypeOfNumericInteger(); }
        public void write(Entity e, Object v) { ((VendorCheck)e).setTypeOfNumericInteger(cti(v)); }
    }
    public static class EpgTypeOfNumericBigint implements PropertyGateway {
        public Object read(Entity e) { return ((VendorCheck)e).getTypeOfNumericBigint(); }
        public void write(Entity e, Object v) { ((VendorCheck)e).setTypeOfNumericBigint(ctl(v)); }
    }
    public static class EpgTypeOfNumericDecimal implements PropertyGateway {
        public Object read(Entity e) { return ((VendorCheck)e).getTypeOfNumericDecimal(); }
        public void write(Entity e, Object v) { ((VendorCheck)e).setTypeOfNumericDecimal(ctb(v)); }
    }
    public static class EpgTypeOfNumericIntegerMin implements PropertyGateway {
        public Object read(Entity e) { return ((VendorCheck)e).getTypeOfNumericIntegerMin(); }
        public void write(Entity e, Object v) { ((VendorCheck)e).setTypeOfNumericIntegerMin(cti(v)); }
    }
    public static class EpgTypeOfNumericIntegerMax implements PropertyGateway {
        public Object read(Entity e) { return ((VendorCheck)e).getTypeOfNumericIntegerMax(); }
        public void write(Entity e, Object v) { ((VendorCheck)e).setTypeOfNumericIntegerMax(cti(v)); }
    }
    public static class EpgTypeOfNumericBigintMin implements PropertyGateway {
        public Object read(Entity e) { return ((VendorCheck)e).getTypeOfNumericBigintMin(); }
        public void write(Entity e, Object v) { ((VendorCheck)e).setTypeOfNumericBigintMin(ctl(v)); }
    }
    public static class EpgTypeOfNumericBigintMax implements PropertyGateway {
        public Object read(Entity e) { return ((VendorCheck)e).getTypeOfNumericBigintMax(); }
        public void write(Entity e, Object v) { ((VendorCheck)e).setTypeOfNumericBigintMax(ctl(v)); }
    }
    public static class EpgTypeOfNumericSuperintMin implements PropertyGateway {
        public Object read(Entity e) { return ((VendorCheck)e).getTypeOfNumericSuperintMin(); }
        public void write(Entity e, Object v) { ((VendorCheck)e).setTypeOfNumericSuperintMin(ctb(v)); }
    }
    public static class EpgTypeOfNumericSuperintMax implements PropertyGateway {
        public Object read(Entity e) { return ((VendorCheck)e).getTypeOfNumericSuperintMax(); }
        public void write(Entity e, Object v) { ((VendorCheck)e).setTypeOfNumericSuperintMax(ctb(v)); }
    }
    public static class EpgTypeOfNumericMaxdecimal implements PropertyGateway {
        public Object read(Entity e) { return ((VendorCheck)e).getTypeOfNumericMaxdecimal(); }
        public void write(Entity e, Object v) { ((VendorCheck)e).setTypeOfNumericMaxdecimal(ctb(v)); }
    }
    public static class EpgTypeOfInteger implements PropertyGateway {
        public Object read(Entity e) { return ((VendorCheck)e).getTypeOfInteger(); }
        public void write(Entity e, Object v) { ((VendorCheck)e).setTypeOfInteger(cti(v)); }
    }
    public static class EpgTypeOfBigint implements PropertyGateway {
        public Object read(Entity e) { return ((VendorCheck)e).getTypeOfBigint(); }
        public void write(Entity e, Object v) { ((VendorCheck)e).setTypeOfBigint(ctl(v)); }
    }
    public static class EpgTypeOfDate implements PropertyGateway {
        public Object read(Entity e) { return ((VendorCheck)e).getTypeOfDate(); }
        public void write(Entity e, Object v) { ((VendorCheck)e).setTypeOfDate((java.util.Date)v); }
    }
    public static class EpgTypeOfTimestamp implements PropertyGateway {
        public Object read(Entity e) { return ((VendorCheck)e).getTypeOfTimestamp(); }
        public void write(Entity e, Object v) { ((VendorCheck)e).setTypeOfTimestamp((java.sql.Timestamp)v); }
    }
    public static class EpgTypeOfTime implements PropertyGateway {
        public Object read(Entity e) { return ((VendorCheck)e).getTypeOfTime(); }
        public void write(Entity e, Object v) { ((VendorCheck)e).setTypeOfTime((java.sql.Time)v); }
    }
    public static class EpgTypeOfBoolean implements PropertyGateway {
        public Object read(Entity e) { return ((VendorCheck)e).getTypeOfBoolean(); }
        public void write(Entity e, Object v) { ((VendorCheck)e).setTypeOfBoolean((Boolean)v); }
    }
    public static class EpgTypeOfBinary implements PropertyGateway {
        public Object read(Entity e) { return ((VendorCheck)e).getTypeOfBinary(); }
        public void write(Entity e, Object v) { ((VendorCheck)e).setTypeOfBinary((byte[])v); }
    }
    public static class EpgTypeOfBlob implements PropertyGateway {
        public Object read(Entity e) { return ((VendorCheck)e).getTypeOfBlob(); }
        public void write(Entity e, Object v) { ((VendorCheck)e).setTypeOfBlob((byte[])v); }
    }
    public static class EpgTypeOfUuid implements PropertyGateway {
        public Object read(Entity e) { return ((VendorCheck)e).getTypeOfUuid(); }
        public void write(Entity e, Object v) { ((VendorCheck)e).setTypeOfUuid((byte[])v); }
    }
    public static class EpgTypeOfArray implements PropertyGateway {
        public Object read(Entity e) { return ((VendorCheck)e).getTypeOfArray(); }
        public void write(Entity e, Object v) { ((VendorCheck)e).setTypeOfArray((String)v); }
    }
    public static class EpgTypeOfOther implements PropertyGateway {
        public Object read(Entity e) { return ((VendorCheck)e).getTypeOfOther(); }
        public void write(Entity e, Object v) { ((VendorCheck)e).setTypeOfOther((String)v); }
    }
    public static class EpgJAVABeansProperty implements PropertyGateway {
        public Object read(Entity e) { return ((VendorCheck)e).getJAVABeansProperty(); }
        public void write(Entity e, Object v) { ((VendorCheck)e).setJAVABeansProperty((String)v); }
    }
    public static class EpgJPopBeansProperty implements PropertyGateway {
        public Object read(Entity e) { return ((VendorCheck)e).getJPopBeansProperty(); }
        public void write(Entity e, Object v) { ((VendorCheck)e).setJPopBeansProperty((String)v); }
    }

    // ===================================================================================
    //                                                                          Table Info
    //                                                                          ==========
    protected final String _tableDbName = "VENDOR_CHECK";
    protected final String _tablePropertyName = "vendorCheck";
    protected final TableSqlName _tableSqlName = new TableSqlName("VENDOR_CHECK", _tableDbName);
    { _tableSqlName.xacceptFilter(DBFluteConfig.getInstance().getTableSqlNameFilter()); }
    public String getTableDbName() { return _tableDbName; }
    public String getTablePropertyName() { return _tablePropertyName; }
    public TableSqlName getTableSqlName() { return _tableSqlName; }

    // ===================================================================================
    //                                                                         Column Info
    //                                                                         ===========
    protected final ColumnInfo _columnVendorCheckId = cci("VENDOR_CHECK_ID", "VENDOR_CHECK_ID", null, null, true, "vendorCheckId", Long.class, true, false, "DECIMAL", 16, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnTypeOfChar = cci("TYPE_OF_CHAR", "TYPE_OF_CHAR", null, null, false, "typeOfChar", String.class, false, false, "CHAR", 3, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnTypeOfVarchar = cci("TYPE_OF_VARCHAR", "TYPE_OF_VARCHAR", null, null, false, "typeOfVarchar", String.class, false, false, "VARCHAR", 32, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnTypeOfClob = cci("TYPE_OF_CLOB", "TYPE_OF_CLOB", null, null, false, "typeOfClob", String.class, false, false, "CLOB", 2147483647, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnTypeOfText = cci("TYPE_OF_TEXT", "TYPE_OF_TEXT", null, null, false, "typeOfText", String.class, false, false, "CLOB", 2147483647, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnTypeOfNumericInteger = cci("TYPE_OF_NUMERIC_INTEGER", "TYPE_OF_NUMERIC_INTEGER", null, null, false, "typeOfNumericInteger", Integer.class, false, false, "DECIMAL", 5, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnTypeOfNumericBigint = cci("TYPE_OF_NUMERIC_BIGINT", "TYPE_OF_NUMERIC_BIGINT", null, null, false, "typeOfNumericBigint", Long.class, false, false, "DECIMAL", 12, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnTypeOfNumericDecimal = cci("TYPE_OF_NUMERIC_DECIMAL", "TYPE_OF_NUMERIC_DECIMAL", null, null, false, "typeOfNumericDecimal", java.math.BigDecimal.class, false, false, "DECIMAL", 5, 3, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnTypeOfNumericIntegerMin = cci("TYPE_OF_NUMERIC_INTEGER_MIN", "TYPE_OF_NUMERIC_INTEGER_MIN", null, null, false, "typeOfNumericIntegerMin", Integer.class, false, false, "DECIMAL", 1, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnTypeOfNumericIntegerMax = cci("TYPE_OF_NUMERIC_INTEGER_MAX", "TYPE_OF_NUMERIC_INTEGER_MAX", null, null, false, "typeOfNumericIntegerMax", Integer.class, false, false, "DECIMAL", 9, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnTypeOfNumericBigintMin = cci("TYPE_OF_NUMERIC_BIGINT_MIN", "TYPE_OF_NUMERIC_BIGINT_MIN", null, null, false, "typeOfNumericBigintMin", Long.class, false, false, "DECIMAL", 10, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnTypeOfNumericBigintMax = cci("TYPE_OF_NUMERIC_BIGINT_MAX", "TYPE_OF_NUMERIC_BIGINT_MAX", null, null, false, "typeOfNumericBigintMax", Long.class, false, false, "DECIMAL", 18, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnTypeOfNumericSuperintMin = cci("TYPE_OF_NUMERIC_SUPERINT_MIN", "TYPE_OF_NUMERIC_SUPERINT_MIN", null, null, false, "typeOfNumericSuperintMin", java.math.BigDecimal.class, false, false, "DECIMAL", 19, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnTypeOfNumericSuperintMax = cci("TYPE_OF_NUMERIC_SUPERINT_MAX", "TYPE_OF_NUMERIC_SUPERINT_MAX", null, null, false, "typeOfNumericSuperintMax", java.math.BigDecimal.class, false, false, "DECIMAL", 38, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnTypeOfNumericMaxdecimal = cci("TYPE_OF_NUMERIC_MAXDECIMAL", "TYPE_OF_NUMERIC_MAXDECIMAL", null, null, false, "typeOfNumericMaxdecimal", java.math.BigDecimal.class, false, false, "DECIMAL", 38, 38, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnTypeOfInteger = cci("TYPE_OF_INTEGER", "TYPE_OF_INTEGER", null, null, false, "typeOfInteger", Integer.class, false, false, "INTEGER", 10, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnTypeOfBigint = cci("TYPE_OF_BIGINT", "TYPE_OF_BIGINT", null, null, false, "typeOfBigint", Long.class, false, false, "BIGINT", 19, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnTypeOfDate = cci("TYPE_OF_DATE", "TYPE_OF_DATE", null, null, false, "typeOfDate", java.util.Date.class, false, false, "DATE", 8, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnTypeOfTimestamp = cci("TYPE_OF_TIMESTAMP", "TYPE_OF_TIMESTAMP", null, null, false, "typeOfTimestamp", java.sql.Timestamp.class, false, false, "TIMESTAMP", 23, 10, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnTypeOfTime = cci("TYPE_OF_TIME", "TYPE_OF_TIME", null, null, false, "typeOfTime", java.sql.Time.class, false, false, "TIME", 6, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnTypeOfBoolean = cci("TYPE_OF_BOOLEAN", "TYPE_OF_BOOLEAN", null, null, false, "typeOfBoolean", Boolean.class, false, false, "BOOLEAN", 1, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnTypeOfBinary = cci("TYPE_OF_BINARY", "TYPE_OF_BINARY", null, null, false, "typeOfBinary", byte[].class, false, false, "VARBINARY", 2147483647, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnTypeOfBlob = cci("TYPE_OF_BLOB", "TYPE_OF_BLOB", null, null, false, "typeOfBlob", byte[].class, false, false, "BLOB", 2147483647, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnTypeOfUuid = cci("TYPE_OF_UUID", "TYPE_OF_UUID", null, null, false, "typeOfUuid", byte[].class, false, false, "UUID", 2147483647, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnTypeOfArray = cci("TYPE_OF_ARRAY", "TYPE_OF_ARRAY", null, null, false, "typeOfArray", String.class, false, false, "ARRAY", null, null, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnTypeOfOther = cci("TYPE_OF_OTHER", "TYPE_OF_OTHER", null, null, false, "typeOfOther", String.class, false, false, "OTHER", 2147483647, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnJAVABeansProperty = cci("J_A_V_A_BEANS_PROPERTY", "J_A_V_A_BEANS_PROPERTY", null, null, false, "JAVABeansProperty", String.class, false, false, "VARCHAR", 10, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnJPopBeansProperty = cci("J_POP_BEANS_PROPERTY", "J_POP_BEANS_PROPERTY", null, null, false, "JPopBeansProperty", String.class, false, false, "VARCHAR", 10, 0, null, false, null, null, null, null, null);

    public ColumnInfo columnVendorCheckId() { return _columnVendorCheckId; }
    public ColumnInfo columnTypeOfChar() { return _columnTypeOfChar; }
    public ColumnInfo columnTypeOfVarchar() { return _columnTypeOfVarchar; }
    public ColumnInfo columnTypeOfClob() { return _columnTypeOfClob; }
    public ColumnInfo columnTypeOfText() { return _columnTypeOfText; }
    public ColumnInfo columnTypeOfNumericInteger() { return _columnTypeOfNumericInteger; }
    public ColumnInfo columnTypeOfNumericBigint() { return _columnTypeOfNumericBigint; }
    public ColumnInfo columnTypeOfNumericDecimal() { return _columnTypeOfNumericDecimal; }
    public ColumnInfo columnTypeOfNumericIntegerMin() { return _columnTypeOfNumericIntegerMin; }
    public ColumnInfo columnTypeOfNumericIntegerMax() { return _columnTypeOfNumericIntegerMax; }
    public ColumnInfo columnTypeOfNumericBigintMin() { return _columnTypeOfNumericBigintMin; }
    public ColumnInfo columnTypeOfNumericBigintMax() { return _columnTypeOfNumericBigintMax; }
    public ColumnInfo columnTypeOfNumericSuperintMin() { return _columnTypeOfNumericSuperintMin; }
    public ColumnInfo columnTypeOfNumericSuperintMax() { return _columnTypeOfNumericSuperintMax; }
    public ColumnInfo columnTypeOfNumericMaxdecimal() { return _columnTypeOfNumericMaxdecimal; }
    public ColumnInfo columnTypeOfInteger() { return _columnTypeOfInteger; }
    public ColumnInfo columnTypeOfBigint() { return _columnTypeOfBigint; }
    public ColumnInfo columnTypeOfDate() { return _columnTypeOfDate; }
    public ColumnInfo columnTypeOfTimestamp() { return _columnTypeOfTimestamp; }
    public ColumnInfo columnTypeOfTime() { return _columnTypeOfTime; }
    public ColumnInfo columnTypeOfBoolean() { return _columnTypeOfBoolean; }
    public ColumnInfo columnTypeOfBinary() { return _columnTypeOfBinary; }
    public ColumnInfo columnTypeOfBlob() { return _columnTypeOfBlob; }
    public ColumnInfo columnTypeOfUuid() { return _columnTypeOfUuid; }
    public ColumnInfo columnTypeOfArray() { return _columnTypeOfArray; }
    public ColumnInfo columnTypeOfOther() { return _columnTypeOfOther; }
    public ColumnInfo columnJAVABeansProperty() { return _columnJAVABeansProperty; }
    public ColumnInfo columnJPopBeansProperty() { return _columnJPopBeansProperty; }

    protected List<ColumnInfo> ccil() {
        List<ColumnInfo> ls = newArrayList();
        ls.add(columnVendorCheckId());
        ls.add(columnTypeOfChar());
        ls.add(columnTypeOfVarchar());
        ls.add(columnTypeOfClob());
        ls.add(columnTypeOfText());
        ls.add(columnTypeOfNumericInteger());
        ls.add(columnTypeOfNumericBigint());
        ls.add(columnTypeOfNumericDecimal());
        ls.add(columnTypeOfNumericIntegerMin());
        ls.add(columnTypeOfNumericIntegerMax());
        ls.add(columnTypeOfNumericBigintMin());
        ls.add(columnTypeOfNumericBigintMax());
        ls.add(columnTypeOfNumericSuperintMin());
        ls.add(columnTypeOfNumericSuperintMax());
        ls.add(columnTypeOfNumericMaxdecimal());
        ls.add(columnTypeOfInteger());
        ls.add(columnTypeOfBigint());
        ls.add(columnTypeOfDate());
        ls.add(columnTypeOfTimestamp());
        ls.add(columnTypeOfTime());
        ls.add(columnTypeOfBoolean());
        ls.add(columnTypeOfBinary());
        ls.add(columnTypeOfBlob());
        ls.add(columnTypeOfUuid());
        ls.add(columnTypeOfArray());
        ls.add(columnTypeOfOther());
        ls.add(columnJAVABeansProperty());
        ls.add(columnJPopBeansProperty());
        return ls;
    }

    { initializeInformationResource(); }

    // ===================================================================================
    //                                                                         Unique Info
    //                                                                         ===========
    // -----------------------------------------------------
    //                                       Primary Element
    //                                       ---------------
    protected UniqueInfo cpui() { return hpcpui(columnVendorCheckId()); }
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

    // ===================================================================================
    //                                                                        Various Info
    //                                                                        ============

    // ===================================================================================
    //                                                                           Type Name
    //                                                                           =========
    public String getEntityTypeName() { return "com.example.dbflute.spring.dbflute.exentity.VendorCheck"; }
    public String getConditionBeanTypeName() { return "com.example.dbflute.spring.dbflute.cbean.VendorCheckCB"; }
    public String getBehaviorTypeName() { return "com.example.dbflute.spring.dbflute.exbhv.VendorCheckBhv"; }

    // ===================================================================================
    //                                                                         Object Type
    //                                                                         ===========
    public Class<VendorCheck> getEntityType() { return VendorCheck.class; }

    // ===================================================================================
    //                                                                     Object Instance
    //                                                                     ===============
    public Entity newEntity() { return newMyEntity(); }
    public VendorCheck newMyEntity() { return new VendorCheck(); }

    // ===================================================================================
    //                                                                   Map Communication
    //                                                                   =================
    public void acceptPrimaryKeyMap(Entity e, Map<String, ? extends Object> m)
    { doAcceptPrimaryKeyMap((VendorCheck)e, m); }
    public void acceptAllColumnMap(Entity e, Map<String, ? extends Object> m)
    { doAcceptAllColumnMap((VendorCheck)e, m); }
    public Map<String, Object> extractPrimaryKeyMap(Entity e) { return doExtractPrimaryKeyMap(e); }
    public Map<String, Object> extractAllColumnMap(Entity e) { return doExtractAllColumnMap(e); }
}
