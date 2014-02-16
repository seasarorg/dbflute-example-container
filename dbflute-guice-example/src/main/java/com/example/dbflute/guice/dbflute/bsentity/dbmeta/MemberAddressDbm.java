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
        public Object read(Entity et) { return ((MemberAddress)et).getMemberAddressId(); }
        public void write(Entity et, Object vl) { ((MemberAddress)et).setMemberAddressId(cti(vl)); }
    }
    public static class EpgMemberId implements PropertyGateway {
        public Object read(Entity et) { return ((MemberAddress)et).getMemberId(); }
        public void write(Entity et, Object vl) { ((MemberAddress)et).setMemberId(cti(vl)); }
    }
    public static class EpgValidBeginDate implements PropertyGateway {
        public Object read(Entity et) { return ((MemberAddress)et).getValidBeginDate(); }
        public void write(Entity et, Object vl) { ((MemberAddress)et).setValidBeginDate((java.util.Date)vl); }
    }
    public static class EpgValidEndDate implements PropertyGateway {
        public Object read(Entity et) { return ((MemberAddress)et).getValidEndDate(); }
        public void write(Entity et, Object vl) { ((MemberAddress)et).setValidEndDate((java.util.Date)vl); }
    }
    public static class EpgAddress implements PropertyGateway {
        public Object read(Entity et) { return ((MemberAddress)et).getAddress(); }
        public void write(Entity et, Object vl) { ((MemberAddress)et).setAddress((String)vl); }
    }
    public static class EpgRegionId implements PropertyGateway {
        public Object read(Entity et) { return ((MemberAddress)et).getRegionId(); }
        public void write(Entity et, Object vl) { ((MemberAddress)et).setRegionId(cti(vl)); }
    }
    public static class EpgRegisterDatetime implements PropertyGateway {
        public Object read(Entity et) { return ((MemberAddress)et).getRegisterDatetime(); }
        public void write(Entity et, Object vl) { ((MemberAddress)et).setRegisterDatetime((java.sql.Timestamp)vl); }
    }
    public static class EpgRegisterUser implements PropertyGateway {
        public Object read(Entity et) { return ((MemberAddress)et).getRegisterUser(); }
        public void write(Entity et, Object vl) { ((MemberAddress)et).setRegisterUser((String)vl); }
    }
    public static class EpgUpdateDatetime implements PropertyGateway {
        public Object read(Entity et) { return ((MemberAddress)et).getUpdateDatetime(); }
        public void write(Entity et, Object vl) { ((MemberAddress)et).setUpdateDatetime((java.sql.Timestamp)vl); }
    }
    public static class EpgUpdateUser implements PropertyGateway {
        public Object read(Entity et) { return ((MemberAddress)et).getUpdateUser(); }
        public void write(Entity et, Object vl) { ((MemberAddress)et).setUpdateUser((String)vl); }
    }
    public static class EpgVersionNo implements PropertyGateway {
        public Object read(Entity et) { return ((MemberAddress)et).getVersionNo(); }
        public void write(Entity et, Object vl) { ((MemberAddress)et).setVersionNo(ctl(vl)); }
    }

    // ===================================================================================
    //                                                                          Table Info
    //                                                                          ==========
    protected final String _tableDbName = "MEMBER_ADDRESS";
    protected final String _tablePropertyName = "memberAddress";
    protected final TableSqlName _tableSqlName = new TableSqlName("EXAMPLEDB.PUBLIC.MEMBER_ADDRESS", _tableDbName);
    { _tableSqlName.xacceptFilter(DBFluteConfig.getInstance().getTableSqlNameFilter()); }
    public String getTableDbName() { return _tableDbName; }
    public String getTablePropertyName() { return _tablePropertyName; }
    public TableSqlName getTableSqlName() { return _tableSqlName; }
    protected final String _tableAlias = "会員住所情報";
    public String getTableAlias() { return _tableAlias; }

    // ===================================================================================
    //                                                                         Column Info
    //                                                                         ===========
    protected final ColumnInfo _columnMemberAddressId = cci("MEMBER_ADDRESS_ID", "MEMBER_ADDRESS_ID", null, "会員住所ID", true, "memberAddressId", Integer.class, true, true, "INTEGER", 10, 0, "NEXT VALUE FOR PUBLIC.SYSTEM_SEQUENCE_7B561CF0_A6E2_4927_9D2E_005DA1F73714", false, null, null, null, null, null);
    protected final ColumnInfo _columnMemberId = cci("MEMBER_ID", "MEMBER_ID", null, "会員ID", true, "memberId", Integer.class, false, false, "INTEGER", 10, 0, null, false, null, null, "member", null, null);
    protected final ColumnInfo _columnValidBeginDate = cci("VALID_BEGIN_DATE", "VALID_BEGIN_DATE", null, "有効開始日", true, "validBeginDate", java.util.Date.class, false, false, "DATE", 8, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnValidEndDate = cci("VALID_END_DATE", "VALID_END_DATE", null, "有効終了日", true, "validEndDate", java.util.Date.class, false, false, "DATE", 8, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnAddress = cci("ADDRESS", "ADDRESS", null, "住所", true, "address", String.class, false, false, "VARCHAR", 200, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnRegionId = cci("REGION_ID", "REGION_ID", null, "地域ID", true, "regionId", Integer.class, false, false, "INTEGER", 10, 0, null, false, null, null, "region", null, CDef.DefMeta.Region);
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
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnMemberId(), MemberDbm.getInstance().columnMemberId());
        return cfi("FK_MEMBER_ADDRESS_MEMBER", "member", this, MemberDbm.getInstance(), mp, 0, false, false, false, false, null, null, false, "memberAddressList");
    }
    public ForeignInfo foreignRegion() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnRegionId(), RegionDbm.getInstance().columnRegionId());
        return cfi("FK_MEMBER_ADDRESS_REGION", "region", this, RegionDbm.getInstance(), mp, 1, false, false, false, false, null, null, false, "memberAddressList");
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
    public String getEntityTypeName() { return "com.example.dbflute.guice.dbflute.exentity.MemberAddress"; }
    public String getConditionBeanTypeName() { return "com.example.dbflute.guice.dbflute.cbean.MemberAddressCB"; }
    public String getBehaviorTypeName() { return "com.example.dbflute.guice.dbflute.exbhv.MemberAddressBhv"; }

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
    public void acceptPrimaryKeyMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptPrimaryKeyMap((MemberAddress)et, mp); }
    public void acceptAllColumnMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptAllColumnMap((MemberAddress)et, mp); }
    public Map<String, Object> extractPrimaryKeyMap(Entity et) { return doExtractPrimaryKeyMap(et); }
    public Map<String, Object> extractAllColumnMap(Entity et) { return doExtractAllColumnMap(et); }
}
