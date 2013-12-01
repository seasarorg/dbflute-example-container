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
 * The DB meta of MEMBER_ADDRESS. (Singleton)
 * @author DBFlute(AutoGenerator)
 */
public class MemberAddressDbm extends AbstractDBMeta {

    // ===================================================================================
    //                                                                           Singleton
    //                                                                           =========
    private static final MemberAddressDbm _instance = new MemberAddressDbm();
    private MemberAddressDbm() {}
    public static MemberAddressDbm getInstance() { return _instance; }

    // ===================================================================================
    //                                                                       Current DBDef
    //                                                                       =============
    public DBDef getCurrentDBDef() { return DBCurrent.getInstance().currentDBDef(); }

    // ===================================================================================
    //                                                                    Property Gateway
    //                                                                    ================
    protected final Map<String, PropertyGateway> _epgMap = newHashMap();
    {
        setupEpg(_epgMap, new EpgMemberAddressId(), "memberAddressId");
        setupEpg(_epgMap, new EpgMemberId(), "memberId");
        setupEpg(_epgMap, new EpgValidBeginDate(), "validBeginDate");
        setupEpg(_epgMap, new EpgValidEndDate(), "validEndDate");
        setupEpg(_epgMap, new EpgAddress(), "address");
        setupEpg(_epgMap, new EpgRegionId(), "regionId");
        setupEpg(_epgMap, new EpgRegisterDatetime(), "registerDatetime");
        setupEpg(_epgMap, new EpgRegisterUser(), "registerUser");
        setupEpg(_epgMap, new EpgUpdateDatetime(), "updateDatetime");
        setupEpg(_epgMap, new EpgUpdateUser(), "updateUser");
        setupEpg(_epgMap, new EpgVersionNo(), "versionNo");
    }
    public PropertyGateway findPropertyGateway(String propertyName)
    { return doFindEpg(_epgMap, propertyName); }
    public static class EpgMemberAddressId implements PropertyGateway {
        public Object read(Entity e) { return ((MemberAddress)e).getMemberAddressId(); }
        public void write(Entity e, Object v) { ((MemberAddress)e).setMemberAddressId(cti(v)); }
    }
    public static class EpgMemberId implements PropertyGateway {
        public Object read(Entity e) { return ((MemberAddress)e).getMemberId(); }
        public void write(Entity e, Object v) { ((MemberAddress)e).setMemberId(cti(v)); }
    }
    public static class EpgValidBeginDate implements PropertyGateway {
        public Object read(Entity e) { return ((MemberAddress)e).getValidBeginDate(); }
        public void write(Entity e, Object v) { ((MemberAddress)e).setValidBeginDate((java.util.Date)v); }
    }
    public static class EpgValidEndDate implements PropertyGateway {
        public Object read(Entity e) { return ((MemberAddress)e).getValidEndDate(); }
        public void write(Entity e, Object v) { ((MemberAddress)e).setValidEndDate((java.util.Date)v); }
    }
    public static class EpgAddress implements PropertyGateway {
        public Object read(Entity e) { return ((MemberAddress)e).getAddress(); }
        public void write(Entity e, Object v) { ((MemberAddress)e).setAddress((String)v); }
    }
    public class EpgRegionId implements PropertyGateway {
        public Object read(Entity e) { return ((MemberAddress)e).getRegionId(); }
        public void write(Entity e, Object v) {
            ColumnInfo col = columnRegionId();
            ccls(col, v);
            ((MemberAddress)e).setRegionIdAsRegion((CDef.Region)gcls(col, v));
        }
    }
    public static class EpgRegisterDatetime implements PropertyGateway {
        public Object read(Entity e) { return ((MemberAddress)e).getRegisterDatetime(); }
        public void write(Entity e, Object v) { ((MemberAddress)e).setRegisterDatetime((java.sql.Timestamp)v); }
    }
    public static class EpgRegisterUser implements PropertyGateway {
        public Object read(Entity e) { return ((MemberAddress)e).getRegisterUser(); }
        public void write(Entity e, Object v) { ((MemberAddress)e).setRegisterUser((String)v); }
    }
    public static class EpgUpdateDatetime implements PropertyGateway {
        public Object read(Entity e) { return ((MemberAddress)e).getUpdateDatetime(); }
        public void write(Entity e, Object v) { ((MemberAddress)e).setUpdateDatetime((java.sql.Timestamp)v); }
    }
    public static class EpgUpdateUser implements PropertyGateway {
        public Object read(Entity e) { return ((MemberAddress)e).getUpdateUser(); }
        public void write(Entity e, Object v) { ((MemberAddress)e).setUpdateUser((String)v); }
    }
    public static class EpgVersionNo implements PropertyGateway {
        public Object read(Entity e) { return ((MemberAddress)e).getVersionNo(); }
        public void write(Entity e, Object v) { ((MemberAddress)e).setVersionNo(ctl(v)); }
    }

    // ===================================================================================
    //                                                                          Table Info
    //                                                                          ==========
    protected final String _tableDbName = "MEMBER_ADDRESS";
    protected final String _tablePropertyName = "memberAddress";
    protected final TableSqlName _tableSqlName = new TableSqlName("MEMBER_ADDRESS", _tableDbName);
    { _tableSqlName.xacceptFilter(DBFluteConfig.getInstance().getTableSqlNameFilter()); }
    public String getTableDbName() { return _tableDbName; }
    public String getTablePropertyName() { return _tablePropertyName; }
    public TableSqlName getTableSqlName() { return _tableSqlName; }
    protected final String _tableAlias = "会員住所情報";
    public String getTableAlias() { return _tableAlias; }
    protected final String _tableComment = "会員の住所に関する情報で、同時に有効期間ごとに履歴管理されている。\n会員を基点に考えた場合、構造的には one-to-many だが、業務的な定型条件で one-to-one になる。このような構造を「業務的one-to-one」と呼ぶ！\n有効期間は隙間なく埋められるが、ここでは住所情報のない会員も存在し、厳密には(業務的な) \"1 : 0..1\" である。";
    public String getTableComment() { return _tableComment; }

    // ===================================================================================
    //                                                                         Column Info
    //                                                                         ===========
    protected final ColumnInfo _columnMemberAddressId = cci("MEMBER_ADDRESS_ID", "MEMBER_ADDRESS_ID", null, "会員住所ID", true, "memberAddressId", Integer.class, true, true, "INTEGER", 10, 0, "NEXT VALUE FOR PUBLIC.SYSTEM_SEQUENCE_FE3299EE_6709_48B7_B14D_55774C76E54D", false, null, "会員住所を識別するID。\n期間ごとに同じ会員のデータを保持することがあるため、これは単なるPKであってFKではない。", null, null, null);
    protected final ColumnInfo _columnMemberId = cci("MEMBER_ID", "MEMBER_ID", null, "会員ID", true, "memberId", Integer.class, false, false, "INTEGER", 10, 0, null, false, null, "会員を参照するID。\n期間ごとのデータがあるので、これだけではユニークにはならない。有効開始日と合わせて複合ユニーク制約となるが、厳密には完全な制約にはなっていない。有効期間の概念はRDBでは表現しきれないのである。", "member", null, null);
    protected final ColumnInfo _columnValidBeginDate = cci("VALID_BEGIN_DATE", "VALID_BEGIN_DATE", null, "有効開始日", true, "validBeginDate", java.util.Date.class, false, false, "DATE", 8, 0, null, false, null, "一つの有効期間の開始を示す日付。\n前の有効終了日の次の日の値が格納される。", null, null, null);
    protected final ColumnInfo _columnValidEndDate = cci("VALID_END_DATE", "VALID_END_DATE", null, "有効終了日", true, "validEndDate", java.util.Date.class, false, false, "DATE", 8, 0, null, false, null, "有効期間の終了日。\n期間の最後の日が格納される。基本的に、次の有効開始日の一日前の値となるが、次の有効期間がない場合は 9999/12/31 となる。", null, null, null);
    protected final ColumnInfo _columnAddress = cci("ADDRESS", "ADDRESS", null, "住所", true, "address", String.class, false, false, "VARCHAR", 200, 0, null, false, null, "まるごと住所", null, null, null);
    protected final ColumnInfo _columnRegionId = cci("REGION_ID", "REGION_ID", null, "地域ID", true, "regionId", Integer.class, false, false, "INTEGER", 10, 0, null, false, null, "地域を参照するID。かなり漠然とした地域。", "region", null, CDef.DefMeta.Region);
    protected final ColumnInfo _columnRegisterDatetime = cci("REGISTER_DATETIME", "REGISTER_DATETIME", null, null, true, "registerDatetime", java.sql.Timestamp.class, false, false, "TIMESTAMP", 23, 10, null, true, null, null, null, null, null);
    protected final ColumnInfo _columnRegisterUser = cci("REGISTER_USER", "REGISTER_USER", null, null, true, "registerUser", String.class, false, false, "VARCHAR", 200, 0, null, true, null, null, null, null, null);
    protected final ColumnInfo _columnUpdateDatetime = cci("UPDATE_DATETIME", "UPDATE_DATETIME", null, null, true, "updateDatetime", java.sql.Timestamp.class, false, false, "TIMESTAMP", 23, 10, null, true, null, null, null, null, null);
    protected final ColumnInfo _columnUpdateUser = cci("UPDATE_USER", "UPDATE_USER", null, null, true, "updateUser", String.class, false, false, "VARCHAR", 200, 0, null, true, null, null, null, null, null);
    protected final ColumnInfo _columnVersionNo = cci("VERSION_NO", "VERSION_NO", null, null, true, "versionNo", Long.class, false, false, "BIGINT", 19, 0, null, false, OptimisticLockType.VERSION_NO, null, null, null, null);

    public ColumnInfo columnMemberAddressId() { return _columnMemberAddressId; }
    public ColumnInfo columnMemberId() { return _columnMemberId; }
    public ColumnInfo columnValidBeginDate() { return _columnValidBeginDate; }
    public ColumnInfo columnValidEndDate() { return _columnValidEndDate; }
    public ColumnInfo columnAddress() { return _columnAddress; }
    public ColumnInfo columnRegionId() { return _columnRegionId; }
    public ColumnInfo columnRegisterDatetime() { return _columnRegisterDatetime; }
    public ColumnInfo columnRegisterUser() { return _columnRegisterUser; }
    public ColumnInfo columnUpdateDatetime() { return _columnUpdateDatetime; }
    public ColumnInfo columnUpdateUser() { return _columnUpdateUser; }
    public ColumnInfo columnVersionNo() { return _columnVersionNo; }

    protected List<ColumnInfo> ccil() {
        List<ColumnInfo> ls = newArrayList();
        ls.add(columnMemberAddressId());
        ls.add(columnMemberId());
        ls.add(columnValidBeginDate());
        ls.add(columnValidEndDate());
        ls.add(columnAddress());
        ls.add(columnRegionId());
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
    protected UniqueInfo cpui() { return hpcpui(columnMemberAddressId()); }
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
        return cfi("FK_MEMBER_ADDRESS_MEMBER", "member", this, MemberDbm.getInstance(), map, 0, false, false, false, false, null, null, false, "memberAddressList");
    }
    public ForeignInfo foreignRegion() {
        Map<ColumnInfo, ColumnInfo> map = newLinkedHashMap(columnRegionId(), RegionDbm.getInstance().columnRegionId());
        return cfi("FK_MEMBER_ADDRESS_REGION", "region", this, RegionDbm.getInstance(), map, 1, false, false, false, false, null, null, false, "memberAddressList");
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
    public String getEntityTypeName() { return "com.example.dbflute.basic.dbflute.exentity.MemberAddress"; }
    public String getConditionBeanTypeName() { return "com.example.dbflute.basic.dbflute.cbean.MemberAddressCB"; }
    public String getBehaviorTypeName() { return "com.example.dbflute.basic.dbflute.exbhv.MemberAddressBhv"; }

    // ===================================================================================
    //                                                                         Object Type
    //                                                                         ===========
    public Class<MemberAddress> getEntityType() { return MemberAddress.class; }

    // ===================================================================================
    //                                                                     Object Instance
    //                                                                     ===============
    public Entity newEntity() { return newMyEntity(); }
    public MemberAddress newMyEntity() { return new MemberAddress(); }

    // ===================================================================================
    //                                                                   Map Communication
    //                                                                   =================
    public void acceptPrimaryKeyMap(Entity e, Map<String, ? extends Object> m)
    { doAcceptPrimaryKeyMap((MemberAddress)e, m); }
    public void acceptAllColumnMap(Entity e, Map<String, ? extends Object> m)
    { doAcceptAllColumnMap((MemberAddress)e, m); }
    public Map<String, Object> extractPrimaryKeyMap(Entity e) { return doExtractPrimaryKeyMap(e); }
    public Map<String, Object> extractAllColumnMap(Entity e) { return doExtractAllColumnMap(e); }
}
