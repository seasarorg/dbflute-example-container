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
 * The DB meta of MEMBER_WITHDRAWAL. (Singleton)
 * @author DBFlute(AutoGenerator)
 */
public class MemberWithdrawalDbm extends AbstractDBMeta {

    // ===================================================================================
    //                                                                           Singleton
    //                                                                           =========
    private static final MemberWithdrawalDbm _instance = new MemberWithdrawalDbm();
    private MemberWithdrawalDbm() {}
    public static MemberWithdrawalDbm getInstance() { return _instance; }

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
        setupEpg(_epgMap, new EpgWithdrawalReasonCode(), "withdrawalReasonCode");
        setupEpg(_epgMap, new EpgWithdrawalReasonInputText(), "withdrawalReasonInputText");
        setupEpg(_epgMap, new EpgWithdrawalDatetime(), "withdrawalDatetime");
        setupEpg(_epgMap, new EpgRegisterDatetime(), "registerDatetime");
        setupEpg(_epgMap, new EpgRegisterUser(), "registerUser");
        setupEpg(_epgMap, new EpgUpdateDatetime(), "updateDatetime");
        setupEpg(_epgMap, new EpgUpdateUser(), "updateUser");
        setupEpg(_epgMap, new EpgVersionNo(), "versionNo");
    }
    public PropertyGateway findPropertyGateway(String propertyName)
    { return doFindEpg(_epgMap, propertyName); }
    public static class EpgMemberId implements PropertyGateway {
        public Object read(Entity e) { return ((MemberWithdrawal)e).getMemberId(); }
        public void write(Entity e, Object v) { ((MemberWithdrawal)e).setMemberId(cti(v)); }
    }
    public static class EpgWithdrawalReasonCode implements PropertyGateway {
        public Object read(Entity e) { return ((MemberWithdrawal)e).getWithdrawalReasonCode(); }
        public void write(Entity e, Object v) { ((MemberWithdrawal)e).setWithdrawalReasonCode((String)v); }
    }
    public static class EpgWithdrawalReasonInputText implements PropertyGateway {
        public Object read(Entity e) { return ((MemberWithdrawal)e).getWithdrawalReasonInputText(); }
        public void write(Entity e, Object v) { ((MemberWithdrawal)e).setWithdrawalReasonInputText((String)v); }
    }
    public static class EpgWithdrawalDatetime implements PropertyGateway {
        public Object read(Entity e) { return ((MemberWithdrawal)e).getWithdrawalDatetime(); }
        public void write(Entity e, Object v) { ((MemberWithdrawal)e).setWithdrawalDatetime((java.sql.Timestamp)v); }
    }
    public static class EpgRegisterDatetime implements PropertyGateway {
        public Object read(Entity e) { return ((MemberWithdrawal)e).getRegisterDatetime(); }
        public void write(Entity e, Object v) { ((MemberWithdrawal)e).setRegisterDatetime((java.sql.Timestamp)v); }
    }
    public static class EpgRegisterUser implements PropertyGateway {
        public Object read(Entity e) { return ((MemberWithdrawal)e).getRegisterUser(); }
        public void write(Entity e, Object v) { ((MemberWithdrawal)e).setRegisterUser((String)v); }
    }
    public static class EpgUpdateDatetime implements PropertyGateway {
        public Object read(Entity e) { return ((MemberWithdrawal)e).getUpdateDatetime(); }
        public void write(Entity e, Object v) { ((MemberWithdrawal)e).setUpdateDatetime((java.sql.Timestamp)v); }
    }
    public static class EpgUpdateUser implements PropertyGateway {
        public Object read(Entity e) { return ((MemberWithdrawal)e).getUpdateUser(); }
        public void write(Entity e, Object v) { ((MemberWithdrawal)e).setUpdateUser((String)v); }
    }
    public static class EpgVersionNo implements PropertyGateway {
        public Object read(Entity e) { return ((MemberWithdrawal)e).getVersionNo(); }
        public void write(Entity e, Object v) { ((MemberWithdrawal)e).setVersionNo(ctl(v)); }
    }

    // ===================================================================================
    //                                                                          Table Info
    //                                                                          ==========
    protected final String _tableDbName = "MEMBER_WITHDRAWAL";
    protected final String _tablePropertyName = "memberWithdrawal";
    protected final TableSqlName _tableSqlName = new TableSqlName("MEMBER_WITHDRAWAL", _tableDbName);
    { _tableSqlName.xacceptFilter(DBFluteConfig.getInstance().getTableSqlNameFilter()); }
    public String getTableDbName() { return _tableDbName; }
    public String getTablePropertyName() { return _tablePropertyName; }
    public TableSqlName getTableSqlName() { return _tableSqlName; }
    protected final String _tableAlias = "会員退会情報";
    public String getTableAlias() { return _tableAlias; }
    protected final String _tableComment = "退会会員の退会に関する詳細な情報。\n退会会員のみデータが存在し、\"1 : 0..1\" のパターンの one-to-one である。\n共通カラムがあってバージョンNOがないパターン。\n基本的に更新は入らないが、重要なデータなので万が一のために更新系の共通カラムも。";
    public String getTableComment() { return _tableComment; }

    // ===================================================================================
    //                                                                         Column Info
    //                                                                         ===========
    protected final ColumnInfo _columnMemberId = cci("MEMBER_ID", "MEMBER_ID", null, null, true, "memberId", Integer.class, true, false, "INTEGER", 10, 0, null, false, null, null, "member", null, null);
    protected final ColumnInfo _columnWithdrawalReasonCode = cci("WITHDRAWAL_REASON_CODE", "WITHDRAWAL_REASON_CODE", null, "退会理由コード", false, "withdrawalReasonCode", String.class, false, false, "CHAR", 3, 0, null, false, null, "定型的な退会した理由を参照するコード。\n何も言わずに退会する会員もいるので必須項目ではない。", "withdrawalReason", null, CDef.DefMeta.WithdrawalReason);
    protected final ColumnInfo _columnWithdrawalReasonInputText = cci("WITHDRAWAL_REASON_INPUT_TEXT", "WITHDRAWAL_REASON_INPUT_TEXT", null, "退会理由入力テキスト", false, "withdrawalReasonInputText", String.class, false, false, "CLOB", 2147483647, 0, null, false, null, "会員がフリーテキストで入力できる退会理由。\nもう言いたいこと言ってもらう感じ。サイト運営側としてはこういうのは真摯に受け止めて改善していきたいところ。", null, null, null);
    protected final ColumnInfo _columnWithdrawalDatetime = cci("WITHDRAWAL_DATETIME", "WITHDRAWAL_DATETIME", null, "退会日時", true, "withdrawalDatetime", java.sql.Timestamp.class, false, false, "TIMESTAMP", 23, 10, null, false, null, "退会した瞬間の日時。\n正式会員日時と違い、こっちは one-to-one の別テーブルで管理されている。", null, null, null);
    protected final ColumnInfo _columnRegisterDatetime = cci("REGISTER_DATETIME", "REGISTER_DATETIME", null, null, true, "registerDatetime", java.sql.Timestamp.class, false, false, "TIMESTAMP", 23, 10, null, true, null, null, null, null, null);
    protected final ColumnInfo _columnRegisterUser = cci("REGISTER_USER", "REGISTER_USER", null, null, true, "registerUser", String.class, false, false, "VARCHAR", 200, 0, null, true, null, null, null, null, null);
    protected final ColumnInfo _columnUpdateDatetime = cci("UPDATE_DATETIME", "UPDATE_DATETIME", null, null, true, "updateDatetime", java.sql.Timestamp.class, false, false, "TIMESTAMP", 23, 10, null, true, null, null, null, null, null);
    protected final ColumnInfo _columnUpdateUser = cci("UPDATE_USER", "UPDATE_USER", null, null, true, "updateUser", String.class, false, false, "VARCHAR", 200, 0, null, true, null, null, null, null, null);
    protected final ColumnInfo _columnVersionNo = cci("VERSION_NO", "VERSION_NO", null, null, true, "versionNo", Long.class, false, false, "BIGINT", 19, 0, null, false, OptimisticLockType.VERSION_NO, null, null, null, null);

    public ColumnInfo columnMemberId() { return _columnMemberId; }
    public ColumnInfo columnWithdrawalReasonCode() { return _columnWithdrawalReasonCode; }
    public ColumnInfo columnWithdrawalReasonInputText() { return _columnWithdrawalReasonInputText; }
    public ColumnInfo columnWithdrawalDatetime() { return _columnWithdrawalDatetime; }
    public ColumnInfo columnRegisterDatetime() { return _columnRegisterDatetime; }
    public ColumnInfo columnRegisterUser() { return _columnRegisterUser; }
    public ColumnInfo columnUpdateDatetime() { return _columnUpdateDatetime; }
    public ColumnInfo columnUpdateUser() { return _columnUpdateUser; }
    public ColumnInfo columnVersionNo() { return _columnVersionNo; }

    protected List<ColumnInfo> ccil() {
        List<ColumnInfo> ls = newArrayList();
        ls.add(columnMemberId());
        ls.add(columnWithdrawalReasonCode());
        ls.add(columnWithdrawalReasonInputText());
        ls.add(columnWithdrawalDatetime());
        ls.add(columnRegisterDatetime());
        ls.add(columnRegisterUser());
        ls.add(columnUpdateDatetime());
        ls.add(columnUpdateUser());
        ls.add(columnVersionNo());
        return ls;
    }

    { initializeInformationResource(); }

    // ===================================================================================
    //                                                                         Unique Info
    //                                                                         ===========
    // -----------------------------------------------------
    //                                       Primary Element
    //                                       ---------------
    protected UniqueInfo cpui() { return hpcpui(columnMemberId()); }
    public boolean hasPrimaryKey() { return true; }
    public boolean hasCompoundPrimaryKey() { return false; }

    // ===================================================================================
    //                                                                       Relation Info
    //                                                                       =============
    // -----------------------------------------------------
    //                                      Foreign Property
    //                                      ----------------
    public ForeignInfo foreignMember() {
        Map<ColumnInfo, ColumnInfo> map = newLinkedHashMap(columnMemberId(), MemberDbm.getInstance().columnMemberId());
        return cfi("FK_MEMBER_WITHDRAWAL_MEMBER", "member", this, MemberDbm.getInstance(), map, 0, true, false, false, false, null, null, false, "memberWithdrawalAsOne");
    }
    public ForeignInfo foreignWithdrawalReason() {
        Map<ColumnInfo, ColumnInfo> map = newLinkedHashMap(columnWithdrawalReasonCode(), WithdrawalReasonDbm.getInstance().columnWithdrawalReasonCode());
        return cfi("FK_MEMBER_WITHDRAWAL_WITHDRAWAL_REASON", "withdrawalReason", this, WithdrawalReasonDbm.getInstance(), map, 1, false, false, false, false, null, null, false, "memberWithdrawalList");
    }

    // -----------------------------------------------------
    //                                     Referrer Property
    //                                     -----------------

    // ===================================================================================
    //                                                                        Various Info
    //                                                                        ============
    public boolean hasVersionNo() { return true; }
    public ColumnInfo getVersionNoColumnInfo() { return _columnVersionNo; }
    public boolean hasCommonColumn() { return true; }
    public List<ColumnInfo> getCommonColumnInfoList()
    { return newArrayList(columnRegisterDatetime(), columnRegisterUser(), columnUpdateDatetime(), columnUpdateUser()); }
    public List<ColumnInfo> getCommonColumnInfoBeforeInsertList()
    { return newArrayList(columnRegisterDatetime(), columnRegisterUser(), columnUpdateDatetime(), columnUpdateUser()); }
    public List<ColumnInfo> getCommonColumnInfoBeforeUpdateList()
    { return newArrayList(columnUpdateDatetime(), columnUpdateUser()); }

    // ===================================================================================
    //                                                                           Type Name
    //                                                                           =========
    public String getEntityTypeName() { return "com.example.dbflute.spring.dbflute.exentity.MemberWithdrawal"; }
    public String getConditionBeanTypeName() { return "com.example.dbflute.spring.dbflute.cbean.MemberWithdrawalCB"; }
    public String getBehaviorTypeName() { return "com.example.dbflute.spring.dbflute.exbhv.MemberWithdrawalBhv"; }

    // ===================================================================================
    //                                                                         Object Type
    //                                                                         ===========
    public Class<MemberWithdrawal> getEntityType() { return MemberWithdrawal.class; }

    // ===================================================================================
    //                                                                     Object Instance
    //                                                                     ===============
    public Entity newEntity() { return newMyEntity(); }
    public MemberWithdrawal newMyEntity() { return new MemberWithdrawal(); }

    // ===================================================================================
    //                                                                   Map Communication
    //                                                                   =================
    public void acceptPrimaryKeyMap(Entity e, Map<String, ? extends Object> m)
    { doAcceptPrimaryKeyMap((MemberWithdrawal)e, m); }
    public void acceptAllColumnMap(Entity e, Map<String, ? extends Object> m)
    { doAcceptAllColumnMap((MemberWithdrawal)e, m); }
    public Map<String, Object> extractPrimaryKeyMap(Entity e) { return doExtractPrimaryKeyMap(e); }
    public Map<String, Object> extractAllColumnMap(Entity e) { return doExtractAllColumnMap(e); }
}
