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
package com.example.dbflute.basic.dbflute.bsentity.dbmeta;

import java.util.List;
import java.util.Map;

import org.seasar.dbflute.DBDef;
import org.seasar.dbflute.Entity;
import org.seasar.dbflute.dbmeta.AbstractDBMeta;
import org.seasar.dbflute.dbmeta.PropertyGateway;
import org.seasar.dbflute.dbmeta.info.*;
import org.seasar.dbflute.dbmeta.name.*;
import com.example.dbflute.basic.dbflute.allcommon.*;
import com.example.dbflute.basic.dbflute.exentity.*;

/**
 * The DB meta of MEMBER_SERVICE. (Singleton)
 * @author DBFlute(AutoGenerator)
 */
public class MemberServiceDbm extends AbstractDBMeta {

    // ===================================================================================
    //                                                                           Singleton
    //                                                                           =========
    private static final MemberServiceDbm _instance = new MemberServiceDbm();
    private MemberServiceDbm() {}
    public static MemberServiceDbm getInstance() { return _instance; }

    // ===================================================================================
    //                                                                       Current DBDef
    //                                                                       =============
    public DBDef getCurrentDBDef() { return DBCurrent.getInstance().currentDBDef(); }

    // ===================================================================================
    //                                                                    Property Gateway
    //                                                                    ================
    protected final Map<String, PropertyGateway> _epgMap = newHashMap();
    {
        setupEpg(_epgMap, new EpgMemberServiceId(), "memberServiceId");
        setupEpg(_epgMap, new EpgMemberId(), "memberId");
        setupEpg(_epgMap, new EpgServicePointCount(), "servicePointCount");
        setupEpg(_epgMap, new EpgServiceRankCode(), "serviceRankCode");
        setupEpg(_epgMap, new EpgRegisterDatetime(), "registerDatetime");
        setupEpg(_epgMap, new EpgRegisterUser(), "registerUser");
        setupEpg(_epgMap, new EpgUpdateDatetime(), "updateDatetime");
        setupEpg(_epgMap, new EpgUpdateUser(), "updateUser");
        setupEpg(_epgMap, new EpgVersionNo(), "versionNo");
    }
    public PropertyGateway findPropertyGateway(String propertyName)
    { return doFindEpg(_epgMap, propertyName); }
    public static class EpgMemberServiceId implements PropertyGateway {
        public Object read(Entity e) { return ((MemberService)e).getMemberServiceId(); }
        public void write(Entity e, Object v) { ((MemberService)e).setMemberServiceId(cti(v)); }
    }
    public static class EpgMemberId implements PropertyGateway {
        public Object read(Entity e) { return ((MemberService)e).getMemberId(); }
        public void write(Entity e, Object v) { ((MemberService)e).setMemberId(cti(v)); }
    }
    public static class EpgServicePointCount implements PropertyGateway {
        public Object read(Entity e) { return ((MemberService)e).getServicePointCount(); }
        public void write(Entity e, Object v) { ((MemberService)e).setServicePointCount(cti(v)); }
    }
    public class EpgServiceRankCode implements PropertyGateway {
        public Object read(Entity e) { return ((MemberService)e).getServiceRankCode(); }
        public void write(Entity e, Object v) {
            ColumnInfo col = columnServiceRankCode();
            ccls(col, v);
            ((MemberService)e).setServiceRankCodeAsServiceRank((CDef.ServiceRank)gcls(col, v));
        }
    }
    public static class EpgRegisterDatetime implements PropertyGateway {
        public Object read(Entity e) { return ((MemberService)e).getRegisterDatetime(); }
        public void write(Entity e, Object v) { ((MemberService)e).setRegisterDatetime((java.sql.Timestamp)v); }
    }
    public static class EpgRegisterUser implements PropertyGateway {
        public Object read(Entity e) { return ((MemberService)e).getRegisterUser(); }
        public void write(Entity e, Object v) { ((MemberService)e).setRegisterUser((String)v); }
    }
    public static class EpgUpdateDatetime implements PropertyGateway {
        public Object read(Entity e) { return ((MemberService)e).getUpdateDatetime(); }
        public void write(Entity e, Object v) { ((MemberService)e).setUpdateDatetime((java.sql.Timestamp)v); }
    }
    public static class EpgUpdateUser implements PropertyGateway {
        public Object read(Entity e) { return ((MemberService)e).getUpdateUser(); }
        public void write(Entity e, Object v) { ((MemberService)e).setUpdateUser((String)v); }
    }
    public static class EpgVersionNo implements PropertyGateway {
        public Object read(Entity e) { return ((MemberService)e).getVersionNo(); }
        public void write(Entity e, Object v) { ((MemberService)e).setVersionNo(ctl(v)); }
    }

    // ===================================================================================
    //                                                                          Table Info
    //                                                                          ==========
    protected final String _tableDbName = "MEMBER_SERVICE";
    protected final String _tablePropertyName = "memberService";
    protected final TableSqlName _tableSqlName = new TableSqlName("MEMBER_SERVICE", _tableDbName);
    { _tableSqlName.xacceptFilter(DBFluteConfig.getInstance().getTableSqlNameFilter()); }
    public String getTableDbName() { return _tableDbName; }
    public String getTablePropertyName() { return _tablePropertyName; }
    public TableSqlName getTableSqlName() { return _tableSqlName; }
    protected final String _tableAlias = "会員サービス";
    public String getTableAlias() { return _tableAlias; }
    protected final String _tableComment = "会員のサービス情報（ポイントサービスなど）。\nテストケースのために、あえて統一性を崩してユニーク制約経由の one-to-one を表現している。";
    public String getTableComment() { return _tableComment; }

    // ===================================================================================
    //                                                                         Column Info
    //                                                                         ===========
    protected final ColumnInfo _columnMemberServiceId = cci("MEMBER_SERVICE_ID", "MEMBER_SERVICE_ID", null, "会員サービスID", true, "memberServiceId", Integer.class, true, true, "INTEGER", 10, 0, "NEXT VALUE FOR PUBLIC.SYSTEM_SEQUENCE_A8857EAD_E150_40D0_A358_9C33FC10308C", false, null, "独立した主キーとなるが、実質的に会員IDとは one-to-one である。", null, null, null);
    protected final ColumnInfo _columnMemberId = cci("MEMBER_ID", "MEMBER_ID", null, "会員ID", true, "memberId", Integer.class, false, false, "INTEGER", 10, 0, null, false, null, "会員を参照するID。ユニークなので、会員とは one-to-one の関係に。", "member", null, null);
    protected final ColumnInfo _columnServicePointCount = cci("SERVICE_POINT_COUNT", "SERVICE_POINT_COUNT", null, "サービスポイント数", true, "servicePointCount", Integer.class, false, false, "INTEGER", 10, 0, null, false, null, "購入したら増えて使ったら減る。", null, null, null);
    protected final ColumnInfo _columnServiceRankCode = cci("SERVICE_RANK_CODE", "SERVICE_RANK_CODE", null, "サービスランクコード", true, "serviceRankCode", String.class, false, false, "CHAR", 3, 0, null, false, null, "どんなランクがあるのかドキドキですね。", "serviceRank", null, CDef.DefMeta.ServiceRank);
    protected final ColumnInfo _columnRegisterDatetime = cci("REGISTER_DATETIME", "REGISTER_DATETIME", null, null, true, "registerDatetime", java.sql.Timestamp.class, false, false, "TIMESTAMP", 23, 10, null, true, null, null, null, null, null);
    protected final ColumnInfo _columnRegisterUser = cci("REGISTER_USER", "REGISTER_USER", null, null, true, "registerUser", String.class, false, false, "VARCHAR", 200, 0, null, true, null, null, null, null, null);
    protected final ColumnInfo _columnUpdateDatetime = cci("UPDATE_DATETIME", "UPDATE_DATETIME", null, null, true, "updateDatetime", java.sql.Timestamp.class, false, false, "TIMESTAMP", 23, 10, null, true, null, null, null, null, null);
    protected final ColumnInfo _columnUpdateUser = cci("UPDATE_USER", "UPDATE_USER", null, null, true, "updateUser", String.class, false, false, "VARCHAR", 200, 0, null, true, null, null, null, null, null);
    protected final ColumnInfo _columnVersionNo = cci("VERSION_NO", "VERSION_NO", null, null, true, "versionNo", Long.class, false, false, "BIGINT", 19, 0, null, false, OptimisticLockType.VERSION_NO, null, null, null, null);

    public ColumnInfo columnMemberServiceId() { return _columnMemberServiceId; }
    public ColumnInfo columnMemberId() { return _columnMemberId; }
    public ColumnInfo columnServicePointCount() { return _columnServicePointCount; }
    public ColumnInfo columnServiceRankCode() { return _columnServiceRankCode; }
    public ColumnInfo columnRegisterDatetime() { return _columnRegisterDatetime; }
    public ColumnInfo columnRegisterUser() { return _columnRegisterUser; }
    public ColumnInfo columnUpdateDatetime() { return _columnUpdateDatetime; }
    public ColumnInfo columnUpdateUser() { return _columnUpdateUser; }
    public ColumnInfo columnVersionNo() { return _columnVersionNo; }

    protected List<ColumnInfo> ccil() {
        List<ColumnInfo> ls = newArrayList();
        ls.add(columnMemberServiceId());
        ls.add(columnMemberId());
        ls.add(columnServicePointCount());
        ls.add(columnServiceRankCode());
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
    protected UniqueInfo cpui() { return hpcpui(columnMemberServiceId()); }
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
        return cfi("FK_MEMBER_SERVICE_MEMBER", "member", this, MemberDbm.getInstance(), map, 0, true, false, false, false, null, null, false, "memberServiceAsOne");
    }
    public ForeignInfo foreignServiceRank() {
        Map<ColumnInfo, ColumnInfo> map = newLinkedHashMap(columnServiceRankCode(), ServiceRankDbm.getInstance().columnServiceRankCode());
        return cfi("FK_MEMBER_SERVICE_SERVICE_RANK_CODE", "serviceRank", this, ServiceRankDbm.getInstance(), map, 1, false, false, false, false, null, null, false, "memberServiceList");
    }

    // -----------------------------------------------------
    //                                     Referrer Property
    //                                     -----------------

    // ===================================================================================
    //                                                                        Various Info
    //                                                                        ============
    public boolean hasIdentity() { return true; }
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
    public String getEntityTypeName() { return "com.example.dbflute.basic.dbflute.exentity.MemberService"; }
    public String getConditionBeanTypeName() { return "com.example.dbflute.basic.dbflute.cbean.MemberServiceCB"; }
    public String getBehaviorTypeName() { return "com.example.dbflute.basic.dbflute.exbhv.MemberServiceBhv"; }

    // ===================================================================================
    //                                                                         Object Type
    //                                                                         ===========
    public Class<MemberService> getEntityType() { return MemberService.class; }

    // ===================================================================================
    //                                                                     Object Instance
    //                                                                     ===============
    public Entity newEntity() { return newMyEntity(); }
    public MemberService newMyEntity() { return new MemberService(); }

    // ===================================================================================
    //                                                                   Map Communication
    //                                                                   =================
    public void acceptPrimaryKeyMap(Entity e, Map<String, ? extends Object> m)
    { doAcceptPrimaryKeyMap((MemberService)e, m); }
    public void acceptAllColumnMap(Entity e, Map<String, ? extends Object> m)
    { doAcceptAllColumnMap((MemberService)e, m); }
    public Map<String, Object> extractPrimaryKeyMap(Entity e) { return doExtractPrimaryKeyMap(e); }
    public Map<String, Object> extractAllColumnMap(Entity e) { return doExtractAllColumnMap(e); }
}
