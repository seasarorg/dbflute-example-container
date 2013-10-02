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
package com.example.dbflute.spring.dbflute.bsentity.customize.dbmeta;

import java.util.List;
import java.util.Map;

import org.seasar.dbflute.DBDef;
import org.seasar.dbflute.Entity;
import org.seasar.dbflute.dbmeta.AbstractDBMeta;
import org.seasar.dbflute.dbmeta.PropertyGateway;
import org.seasar.dbflute.dbmeta.info.*;
import org.seasar.dbflute.dbmeta.name.*;
import com.example.dbflute.spring.dbflute.allcommon.*;
import com.example.dbflute.spring.dbflute.exentity.customize.*;

/**
 * The DB meta of PurchaseSummaryMember. (Singleton)
 * @author DBFlute(AutoGenerator)
 */
public class PurchaseSummaryMemberDbm extends AbstractDBMeta {

    // ===================================================================================
    //                                                                           Singleton
    //                                                                           =========
    private static final PurchaseSummaryMemberDbm _instance = new PurchaseSummaryMemberDbm();
    private PurchaseSummaryMemberDbm() {}
    public static PurchaseSummaryMemberDbm getInstance() { return _instance; }

    // ===================================================================================
    //                                                                       Current DBDef
    //                                                                       =============
    public DBDef getCurrentDBDef() { return DBCurrent.getInstance().currentDBDef(); }

    // ===================================================================================
    //                                                                    Property Gateway
    //                                                                    ================
    protected final Map<String, PropertyGateway> _epgMap = newHashMap();
    {
        setupEpg(_epgMap, new EpgMemberId(), "memberId");
        setupEpg(_epgMap, new EpgMemberName(), "memberName");
        setupEpg(_epgMap, new EpgBirthdate(), "birthdate");
        setupEpg(_epgMap, new EpgFormalizedDatetime(), "formalizedDatetime");
        setupEpg(_epgMap, new EpgPurchaseSummary(), "purchaseSummary");
    }
    public PropertyGateway findPropertyGateway(String propertyName)
    { return doFindEpg(_epgMap, propertyName); }
    public static class EpgMemberId implements PropertyGateway {
        public Object read(Entity e) { return ((PurchaseSummaryMember)e).getMemberId(); }
        public void write(Entity e, Object v) { ((PurchaseSummaryMember)e).setMemberId(cti(v)); }
    }
    public static class EpgMemberName implements PropertyGateway {
        public Object read(Entity e) { return ((PurchaseSummaryMember)e).getMemberName(); }
        public void write(Entity e, Object v) { ((PurchaseSummaryMember)e).setMemberName((String)v); }
    }
    public static class EpgBirthdate implements PropertyGateway {
        public Object read(Entity e) { return ((PurchaseSummaryMember)e).getBirthdate(); }
        public void write(Entity e, Object v) { ((PurchaseSummaryMember)e).setBirthdate((java.util.Date)v); }
    }
    public static class EpgFormalizedDatetime implements PropertyGateway {
        public Object read(Entity e) { return ((PurchaseSummaryMember)e).getFormalizedDatetime(); }
        public void write(Entity e, Object v) { ((PurchaseSummaryMember)e).setFormalizedDatetime((java.sql.Timestamp)v); }
    }
    public static class EpgPurchaseSummary implements PropertyGateway {
        public Object read(Entity e) { return ((PurchaseSummaryMember)e).getPurchaseSummary(); }
        public void write(Entity e, Object v) { ((PurchaseSummaryMember)e).setPurchaseSummary(ctl(v)); }
    }

    // ===================================================================================
    //                                                                          Table Info
    //                                                                          ==========
    protected final String _tableDbName = "PurchaseSummaryMember";
    protected final String _tablePropertyName = "purchaseSummaryMember";
    protected final TableSqlName _tableSqlName = new TableSqlName("PurchaseSummaryMember", _tableDbName);
    { _tableSqlName.xacceptFilter(DBFluteConfig.getInstance().getTableSqlNameFilter()); }
    public String getTableDbName() { return _tableDbName; }
    public String getTablePropertyName() { return _tablePropertyName; }
    public TableSqlName getTableSqlName() { return _tableSqlName; }

    // ===================================================================================
    //                                                                         Column Info
    //                                                                         ===========
    protected final ColumnInfo _columnMemberId = cci("MEMBER_ID", "MEMBER_ID", null, "会員ID", false, "memberId", Integer.class, false, false, "INTEGER", 10, 0, null, false, null, "連番として自動採番される。会員IDだけに限らず採番方法はDBMS次第。", null, null, null);
    protected final ColumnInfo _columnMemberName = cci("MEMBER_NAME", "MEMBER_NAME", null, "会員名称", false, "memberName", String.class, false, false, "VARCHAR", 200, 0, null, false, null, "会員のフルネームの名称。\n苗字と名前を分けて管理することが多いが、ここでは単純にひとまとめ。", null, null, null);
    protected final ColumnInfo _columnBirthdate = cci("BIRTHDATE", "BIRTHDATE", null, "生年月日", false, "birthdate", java.util.Date.class, false, false, "DATE", 8, 0, null, false, null, "必須項目ではないので、このデータがない会員もいる。", null, null, null);
    protected final ColumnInfo _columnFormalizedDatetime = cci("FORMALIZED_DATETIME", "FORMALIZED_DATETIME", null, "正式会員日時", false, "formalizedDatetime", java.sql.Timestamp.class, false, false, "TIMESTAMP", 23, 10, null, false, null, "会員が正式に確定した(正式会員になった)日時。\n一度確定したらもう二度と更新されないはずだ！", null, null, null);
    protected final ColumnInfo _columnPurchaseSummary = cci("PURCHASE_SUMMARY", "PURCHASE_SUMMARY", null, null, false, "purchaseSummary", Long.class, false, false, "BIGINT", 10, 0, null, false, null, null, null, null, null);

    public ColumnInfo columnMemberId() { return _columnMemberId; }
    public ColumnInfo columnMemberName() { return _columnMemberName; }
    public ColumnInfo columnBirthdate() { return _columnBirthdate; }
    public ColumnInfo columnFormalizedDatetime() { return _columnFormalizedDatetime; }
    public ColumnInfo columnPurchaseSummary() { return _columnPurchaseSummary; }

    protected List<ColumnInfo> ccil() {
        List<ColumnInfo> ls = newArrayList();
        ls.add(columnMemberId());
        ls.add(columnMemberName());
        ls.add(columnBirthdate());
        ls.add(columnFormalizedDatetime());
        ls.add(columnPurchaseSummary());
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
    public String getEntityTypeName() { return "com.example.dbflute.spring.dbflute.exentity.customize.PurchaseSummaryMember"; }
    public String getConditionBeanTypeName() { return null; }
    public String getBehaviorTypeName() { return null; }

    // ===================================================================================
    //                                                                         Object Type
    //                                                                         ===========
    public Class<PurchaseSummaryMember> getEntityType() { return PurchaseSummaryMember.class; }

    // ===================================================================================
    //                                                                     Object Instance
    //                                                                     ===============
    public Entity newEntity() { return newMyEntity(); }
    public PurchaseSummaryMember newMyEntity() { return new PurchaseSummaryMember(); }

    // ===================================================================================
    //                                                                   Map Communication
    //                                                                   =================
    public void acceptPrimaryKeyMap(Entity e, Map<String, ? extends Object> m)
    { doAcceptPrimaryKeyMap((PurchaseSummaryMember)e, m); }
    public void acceptAllColumnMap(Entity e, Map<String, ? extends Object> m)
    { doAcceptAllColumnMap((PurchaseSummaryMember)e, m); }
    public Map<String, Object> extractPrimaryKeyMap(Entity e) { return doExtractPrimaryKeyMap(e); }
    public Map<String, Object> extractAllColumnMap(Entity e) { return doExtractAllColumnMap(e); }
}
