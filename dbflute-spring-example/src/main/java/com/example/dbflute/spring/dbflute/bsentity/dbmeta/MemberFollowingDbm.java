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
 * The DB meta of MEMBER_FOLLOWING. (Singleton)
 * @author DBFlute(AutoGenerator)
 */
public class MemberFollowingDbm extends AbstractDBMeta {

    // ===================================================================================
    //                                                                           Singleton
    //                                                                           =========
    private static final MemberFollowingDbm _instance = new MemberFollowingDbm();
    private MemberFollowingDbm() {}
    public static MemberFollowingDbm getInstance() { return _instance; }

    // ===================================================================================
    //                                                                       Current DBDef
    //                                                                       =============
    public DBDef getCurrentDBDef() { return DBCurrent.getInstance().currentDBDef(); }

    // ===================================================================================
    //                                                                    Property Gateway
    //                                                                    ================
    protected final Map<String, PropertyGateway> _epgMap = newHashMap();
    {
        setupEpg(_epgMap, new EpgMemberFollowingId(), "memberFollowingId");
        setupEpg(_epgMap, new EpgMyMemberId(), "myMemberId");
        setupEpg(_epgMap, new EpgYourMemberId(), "yourMemberId");
        setupEpg(_epgMap, new EpgFollowDatetime(), "followDatetime");
    }
    public PropertyGateway findPropertyGateway(String propertyName)
    { return doFindEpg(_epgMap, propertyName); }
    public static class EpgMemberFollowingId implements PropertyGateway {
        public Object read(Entity e) { return ((MemberFollowing)e).getMemberFollowingId(); }
        public void write(Entity e, Object v) { ((MemberFollowing)e).setMemberFollowingId(ctl(v)); }
    }
    public static class EpgMyMemberId implements PropertyGateway {
        public Object read(Entity e) { return ((MemberFollowing)e).getMyMemberId(); }
        public void write(Entity e, Object v) { ((MemberFollowing)e).setMyMemberId(cti(v)); }
    }
    public static class EpgYourMemberId implements PropertyGateway {
        public Object read(Entity e) { return ((MemberFollowing)e).getYourMemberId(); }
        public void write(Entity e, Object v) { ((MemberFollowing)e).setYourMemberId(cti(v)); }
    }
    public static class EpgFollowDatetime implements PropertyGateway {
        public Object read(Entity e) { return ((MemberFollowing)e).getFollowDatetime(); }
        public void write(Entity e, Object v) { ((MemberFollowing)e).setFollowDatetime((java.sql.Timestamp)v); }
    }

    // ===================================================================================
    //                                                                          Table Info
    //                                                                          ==========
    protected final String _tableDbName = "MEMBER_FOLLOWING";
    protected final String _tablePropertyName = "memberFollowing";
    protected final TableSqlName _tableSqlName = new TableSqlName("MEMBER_FOLLOWING", _tableDbName);
    { _tableSqlName.xacceptFilter(DBFluteConfig.getInstance().getTableSqlNameFilter()); }
    public String getTableDbName() { return _tableDbName; }
    public String getTablePropertyName() { return _tablePropertyName; }
    public TableSqlName getTableSqlName() { return _tableSqlName; }
    protected final String _tableAlias = "会員フォローイング";
    public String getTableAlias() { return _tableAlias; }
    protected final String _tableComment = "とある会員が他の会員をフォローできる。すると、フォローした会員の購入履歴が閲覧できる。";
    public String getTableComment() { return _tableComment; }

    // ===================================================================================
    //                                                                         Column Info
    //                                                                         ===========
    protected final ColumnInfo _columnMemberFollowingId = cci("MEMBER_FOLLOWING_ID", "MEMBER_FOLLOWING_ID", null, "会員フォローイングID", true, "memberFollowingId", Long.class, true, true, "BIGINT", 19, 0, "NEXT VALUE FOR PUBLIC.SYSTEM_SEQUENCE_3840FCF5_130B_493B_97C2_FB1F52D1D458", false, null, "連番", null, null, null);
    protected final ColumnInfo _columnMyMemberId = cci("MY_MEMBER_ID", "MY_MEMBER_ID", null, "わたし", true, "myMemberId", Integer.class, false, false, "INTEGER", 10, 0, null, false, null, "気になった人がいて...勇気を振り絞った会員のID。", "memberByMyMemberId", null, null);
    protected final ColumnInfo _columnYourMemberId = cci("YOUR_MEMBER_ID", "YOUR_MEMBER_ID", null, "あなた", true, "yourMemberId", Integer.class, false, false, "INTEGER", 10, 0, null, false, null, "いきなりのアクションに...ちょっと心揺らいだ会員のID。", "memberByYourMemberId", null, null);
    protected final ColumnInfo _columnFollowDatetime = cci("FOLLOW_DATETIME", "FOLLOW_DATETIME", null, "その瞬間", true, "followDatetime", java.sql.Timestamp.class, false, false, "TIMESTAMP", 23, 10, null, false, null, "ふりかえるとちょっと恥ずかしい気持ちになる日時", null, null, null);

    public ColumnInfo columnMemberFollowingId() { return _columnMemberFollowingId; }
    public ColumnInfo columnMyMemberId() { return _columnMyMemberId; }
    public ColumnInfo columnYourMemberId() { return _columnYourMemberId; }
    public ColumnInfo columnFollowDatetime() { return _columnFollowDatetime; }

    protected List<ColumnInfo> ccil() {
        List<ColumnInfo> ls = newArrayList();
        ls.add(columnMemberFollowingId());
        ls.add(columnMyMemberId());
        ls.add(columnYourMemberId());
        ls.add(columnFollowDatetime());
        return ls;
    }

    { initializeInformationResource(); }

    // ===================================================================================
    //                                                                         Unique Info
    //                                                                         ===========
    // -----------------------------------------------------
    //                                       Primary Element
    //                                       ---------------
    protected UniqueInfo cpui() { return hpcpui(columnMemberFollowingId()); }
    public boolean hasPrimaryKey() { return true; }
    public boolean hasCompoundPrimaryKey() { return false; }

    // ===================================================================================
    //                                                                       Relation Info
    //                                                                       =============
    // -----------------------------------------------------
    //                                      Foreign Property
    //                                      ----------------
    public ForeignInfo foreignMemberByMyMemberId() {
        Map<ColumnInfo, ColumnInfo> map = newLinkedHashMap(columnMyMemberId(), MemberDbm.getInstance().columnMemberId());
        return cfi("FK_MEMBER_FOLLOWING_MY_MEMBER", "memberByMyMemberId", this, MemberDbm.getInstance(), map, 0, false, false, false, false, null, null, false, "memberFollowingByMyMemberIdList");
    }
    public ForeignInfo foreignMemberByYourMemberId() {
        Map<ColumnInfo, ColumnInfo> map = newLinkedHashMap(columnYourMemberId(), MemberDbm.getInstance().columnMemberId());
        return cfi("FK_MEMBER_FOLLOWING_YOUR_MEMBER", "memberByYourMemberId", this, MemberDbm.getInstance(), map, 1, false, false, false, false, null, null, false, "memberFollowingByYourMemberIdList");
    }

    // -----------------------------------------------------
    //                                     Referrer Property
    //                                     -----------------

    // ===================================================================================
    //                                                                        Various Info
    //                                                                        ============
    public boolean hasIdentity() { return true; }

    // ===================================================================================
    //                                                                           Type Name
    //                                                                           =========
    public String getEntityTypeName() { return "com.example.dbflute.spring.dbflute.exentity.MemberFollowing"; }
    public String getConditionBeanTypeName() { return "com.example.dbflute.spring.dbflute.cbean.MemberFollowingCB"; }
    public String getBehaviorTypeName() { return "com.example.dbflute.spring.dbflute.exbhv.MemberFollowingBhv"; }

    // ===================================================================================
    //                                                                         Object Type
    //                                                                         ===========
    public Class<MemberFollowing> getEntityType() { return MemberFollowing.class; }

    // ===================================================================================
    //                                                                     Object Instance
    //                                                                     ===============
    public Entity newEntity() { return newMyEntity(); }
    public MemberFollowing newMyEntity() { return new MemberFollowing(); }

    // ===================================================================================
    //                                                                   Map Communication
    //                                                                   =================
    public void acceptPrimaryKeyMap(Entity e, Map<String, ? extends Object> m)
    { doAcceptPrimaryKeyMap((MemberFollowing)e, m); }
    public void acceptAllColumnMap(Entity e, Map<String, ? extends Object> m)
    { doAcceptAllColumnMap((MemberFollowing)e, m); }
    public Map<String, Object> extractPrimaryKeyMap(Entity e) { return doExtractPrimaryKeyMap(e); }
    public Map<String, Object> extractAllColumnMap(Entity e) { return doExtractAllColumnMap(e); }
}
