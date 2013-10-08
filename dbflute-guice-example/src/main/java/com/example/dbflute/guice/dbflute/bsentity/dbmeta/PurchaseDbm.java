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
 * The DB meta of PURCHASE. (Singleton)
 * @author DBFlute(AutoGenerator)
 */
public class PurchaseDbm extends AbstractDBMeta {

    // ===================================================================================
    //                                                                           Singleton
    //                                                                           =========
    private static final PurchaseDbm _instance = new PurchaseDbm();
    private PurchaseDbm() {}
    public static PurchaseDbm getInstance() { return _instance; }

    // ===================================================================================
    //                                                                       Current DBDef
    //                                                                       =============
    public DBDef getCurrentDBDef() { return DBCurrent.getInstance().currentDBDef(); }

    // ===================================================================================
    //                                                                    Property Gateway
    //                                                                    ================
    protected final Map<String, PropertyGateway> _epgMap = newHashMap();
    {
        setupEpg(_epgMap, new EpgPurchaseId(), "purchaseId");
        setupEpg(_epgMap, new EpgMemberId(), "memberId");
        setupEpg(_epgMap, new EpgProductId(), "productId");
        setupEpg(_epgMap, new EpgPurchaseDatetime(), "purchaseDatetime");
        setupEpg(_epgMap, new EpgPurchaseCount(), "purchaseCount");
        setupEpg(_epgMap, new EpgPurchasePrice(), "purchasePrice");
        setupEpg(_epgMap, new EpgPaymentCompleteFlg(), "paymentCompleteFlg");
        setupEpg(_epgMap, new EpgRegisterDatetime(), "registerDatetime");
        setupEpg(_epgMap, new EpgRegisterUser(), "registerUser");
        setupEpg(_epgMap, new EpgUpdateDatetime(), "updateDatetime");
        setupEpg(_epgMap, new EpgUpdateUser(), "updateUser");
        setupEpg(_epgMap, new EpgVersionNo(), "versionNo");
    }
    public PropertyGateway findPropertyGateway(String propertyName)
    { return doFindEpg(_epgMap, propertyName); }
    public static class EpgPurchaseId implements PropertyGateway {
        public Object read(Entity e) { return ((Purchase)e).getPurchaseId(); }
        public void write(Entity e, Object v) { ((Purchase)e).setPurchaseId(ctl(v)); }
    }
    public static class EpgMemberId implements PropertyGateway {
        public Object read(Entity e) { return ((Purchase)e).getMemberId(); }
        public void write(Entity e, Object v) { ((Purchase)e).setMemberId(cti(v)); }
    }
    public static class EpgProductId implements PropertyGateway {
        public Object read(Entity e) { return ((Purchase)e).getProductId(); }
        public void write(Entity e, Object v) { ((Purchase)e).setProductId(cti(v)); }
    }
    public static class EpgPurchaseDatetime implements PropertyGateway {
        public Object read(Entity e) { return ((Purchase)e).getPurchaseDatetime(); }
        public void write(Entity e, Object v) { ((Purchase)e).setPurchaseDatetime((java.sql.Timestamp)v); }
    }
    public static class EpgPurchaseCount implements PropertyGateway {
        public Object read(Entity e) { return ((Purchase)e).getPurchaseCount(); }
        public void write(Entity e, Object v) { ((Purchase)e).setPurchaseCount(cti(v)); }
    }
    public static class EpgPurchasePrice implements PropertyGateway {
        public Object read(Entity e) { return ((Purchase)e).getPurchasePrice(); }
        public void write(Entity e, Object v) { ((Purchase)e).setPurchasePrice(cti(v)); }
    }
    public class EpgPaymentCompleteFlg implements PropertyGateway {
        public Object read(Entity e) { return ((Purchase)e).getPaymentCompleteFlg(); }
        public void write(Entity e, Object v) {
            ColumnInfo col = columnPaymentCompleteFlg();
            ccls(col, v);
            ((Purchase)e).setPaymentCompleteFlgAsFlg((CDef.Flg)gcls(col, v));
        }
    }
    public static class EpgRegisterDatetime implements PropertyGateway {
        public Object read(Entity e) { return ((Purchase)e).getRegisterDatetime(); }
        public void write(Entity e, Object v) { ((Purchase)e).setRegisterDatetime((java.sql.Timestamp)v); }
    }
    public static class EpgRegisterUser implements PropertyGateway {
        public Object read(Entity e) { return ((Purchase)e).getRegisterUser(); }
        public void write(Entity e, Object v) { ((Purchase)e).setRegisterUser((String)v); }
    }
    public static class EpgUpdateDatetime implements PropertyGateway {
        public Object read(Entity e) { return ((Purchase)e).getUpdateDatetime(); }
        public void write(Entity e, Object v) { ((Purchase)e).setUpdateDatetime((java.sql.Timestamp)v); }
    }
    public static class EpgUpdateUser implements PropertyGateway {
        public Object read(Entity e) { return ((Purchase)e).getUpdateUser(); }
        public void write(Entity e, Object v) { ((Purchase)e).setUpdateUser((String)v); }
    }
    public static class EpgVersionNo implements PropertyGateway {
        public Object read(Entity e) { return ((Purchase)e).getVersionNo(); }
        public void write(Entity e, Object v) { ((Purchase)e).setVersionNo(ctl(v)); }
    }

    // ===================================================================================
    //                                                                          Table Info
    //                                                                          ==========
    protected final String _tableDbName = "PURCHASE";
    protected final String _tablePropertyName = "purchase";
    protected final TableSqlName _tableSqlName = new TableSqlName("EXAMPLEDB.PUBLIC.PURCHASE", _tableDbName);
    { _tableSqlName.xacceptFilter(DBFluteConfig.getInstance().getTableSqlNameFilter()); }
    public String getTableDbName() { return _tableDbName; }
    public String getTablePropertyName() { return _tablePropertyName; }
    public TableSqlName getTableSqlName() { return _tableSqlName; }
    protected final String _tableAlias = "購入";
    public String getTableAlias() { return _tableAlias; }

    // ===================================================================================
    //                                                                         Column Info
    //                                                                         ===========
    protected final ColumnInfo _columnPurchaseId = cci("PURCHASE_ID", "PURCHASE_ID", null, null, true, "purchaseId", Long.class, true, true, "BIGINT", 19, 0, "NEXT VALUE FOR PUBLIC.SYSTEM_SEQUENCE_0F494868_B95B_4FA9_95F8_430BB3833F8F", false, null, null, null, null, null);
    protected final ColumnInfo _columnMemberId = cci("MEMBER_ID", "MEMBER_ID", null, "会員ID", true, "memberId", Integer.class, false, false, "INTEGER", 10, 0, null, false, null, null, "member,memberLoginAsBizManyToOne", null, null);
    protected final ColumnInfo _columnProductId = cci("PRODUCT_ID", "PRODUCT_ID", null, "商品ID", true, "productId", Integer.class, false, false, "INTEGER", 10, 0, null, false, null, null, "product,summaryProduct", null, null);
    protected final ColumnInfo _columnPurchaseDatetime = cci("PURCHASE_DATETIME", "PURCHASE_DATETIME", null, "購入日時", true, "purchaseDatetime", java.sql.Timestamp.class, false, false, "TIMESTAMP", 23, 10, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnPurchaseCount = cci("PURCHASE_COUNT", "PURCHASE_COUNT", null, "購入数量", true, "purchaseCount", Integer.class, false, false, "INTEGER", 10, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnPurchasePrice = cci("PURCHASE_PRICE", "PURCHASE_PRICE", null, "購入価格", true, "purchasePrice", Integer.class, false, false, "INTEGER", 10, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnPaymentCompleteFlg = cci("PAYMENT_COMPLETE_FLG", "PAYMENT_COMPLETE_FLG", null, "支払完了フラグ", true, "paymentCompleteFlg", Integer.class, false, false, "INTEGER", 10, 0, null, false, null, null, null, null, CDef.DefMeta.Flg);
    protected final ColumnInfo _columnRegisterDatetime = cci("REGISTER_DATETIME", "REGISTER_DATETIME", null, null, true, "registerDatetime", java.sql.Timestamp.class, false, false, "TIMESTAMP", 23, 10, null, true, null, null, null, null, null);
    protected final ColumnInfo _columnRegisterUser = cci("REGISTER_USER", "REGISTER_USER", null, null, true, "registerUser", String.class, false, false, "VARCHAR", 200, 0, null, true, null, null, null, null, null);
    protected final ColumnInfo _columnUpdateDatetime = cci("UPDATE_DATETIME", "UPDATE_DATETIME", null, null, true, "updateDatetime", java.sql.Timestamp.class, false, false, "TIMESTAMP", 23, 10, null, true, null, null, null, null, null);
    protected final ColumnInfo _columnUpdateUser = cci("UPDATE_USER", "UPDATE_USER", null, null, true, "updateUser", String.class, false, false, "VARCHAR", 200, 0, null, true, null, null, null, null, null);
    protected final ColumnInfo _columnVersionNo = cci("VERSION_NO", "VERSION_NO", null, null, true, "versionNo", Long.class, false, false, "BIGINT", 19, 0, null, false, OptimisticLockType.VERSION_NO, null, null, null, null);

    public ColumnInfo columnPurchaseId() { return _columnPurchaseId; }
    public ColumnInfo columnMemberId() { return _columnMemberId; }
    public ColumnInfo columnProductId() { return _columnProductId; }
    public ColumnInfo columnPurchaseDatetime() { return _columnPurchaseDatetime; }
    public ColumnInfo columnPurchaseCount() { return _columnPurchaseCount; }
    public ColumnInfo columnPurchasePrice() { return _columnPurchasePrice; }
    public ColumnInfo columnPaymentCompleteFlg() { return _columnPaymentCompleteFlg; }
    public ColumnInfo columnRegisterDatetime() { return _columnRegisterDatetime; }
    public ColumnInfo columnRegisterUser() { return _columnRegisterUser; }
    public ColumnInfo columnUpdateDatetime() { return _columnUpdateDatetime; }
    public ColumnInfo columnUpdateUser() { return _columnUpdateUser; }
    public ColumnInfo columnVersionNo() { return _columnVersionNo; }

    protected List<ColumnInfo> ccil() {
        List<ColumnInfo> ls = newArrayList();
        ls.add(columnPurchaseId());
        ls.add(columnMemberId());
        ls.add(columnProductId());
        ls.add(columnPurchaseDatetime());
        ls.add(columnPurchaseCount());
        ls.add(columnPurchasePrice());
        ls.add(columnPaymentCompleteFlg());
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
    protected UniqueInfo cpui() { return hpcpui(columnPurchaseId()); }
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
        return cfi("FK_PURCHASE_MEMBER", "member", this, MemberDbm.getInstance(), map, 0, false, false, false, false, null, null, false, "purchaseList");
    }
    public ForeignInfo foreignProduct() {
        Map<ColumnInfo, ColumnInfo> map = newLinkedHashMap(columnProductId(), ProductDbm.getInstance().columnProductId());
        return cfi("FK_PURCHASE_PRODUCT", "product", this, ProductDbm.getInstance(), map, 1, false, false, false, false, null, null, false, "purchaseList");
    }
    public ForeignInfo foreignSummaryProduct() {
        Map<ColumnInfo, ColumnInfo> map = newLinkedHashMap(columnProductId(), SummaryProductDbm.getInstance().columnProductId());
        return cfi("FK_PURCHASE_SUMMARY_PRODUCT", "summaryProduct", this, SummaryProductDbm.getInstance(), map, 2, false, false, false, true, null, null, false, "purchaseList");
    }
    public ForeignInfo foreignMemberLoginAsBizManyToOne() {
        Map<ColumnInfo, ColumnInfo> map = newLinkedHashMap(columnMemberId(), MemberLoginDbm.getInstance().columnMemberId());
        return cfi("FK_PURCHASE_BIZ_MANY_TO_ONE_TEST", "memberLoginAsBizManyToOne", this, MemberLoginDbm.getInstance(), map, 3, false, false, false, true, "$$foreignAlias$$.MEMBER_STATUS_CODE = 'PRV'", null, false, null);
    }

    // -----------------------------------------------------
    //                                     Referrer Property
    //                                     -----------------

    // ===================================================================================
    //                                                                        Various Info
    //                                                                        ============
    public boolean hasIdentity() { return true; }
    public boolean hasSequence() { return true; }
    public String getSequenceName() { return "PUBLIC.SEQ_PURCHASE"; }
    public Integer getSequenceIncrementSize() { return 8; }
    public Integer getSequenceCacheSize() { return 8; }
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
    public String getEntityTypeName() { return "com.example.dbflute.guice.dbflute.exentity.Purchase"; }
    public String getConditionBeanTypeName() { return "com.example.dbflute.guice.dbflute.cbean.PurchaseCB"; }
    public String getBehaviorTypeName() { return "com.example.dbflute.guice.dbflute.exbhv.PurchaseBhv"; }

    // ===================================================================================
    //                                                                         Object Type
    //                                                                         ===========
    public Class<Purchase> getEntityType() { return Purchase.class; }

    // ===================================================================================
    //                                                                     Object Instance
    //                                                                     ===============
    public Entity newEntity() { return newMyEntity(); }
    public Purchase newMyEntity() { return new Purchase(); }

    // ===================================================================================
    //                                                                   Map Communication
    //                                                                   =================
    public void acceptPrimaryKeyMap(Entity e, Map<String, ? extends Object> m)
    { doAcceptPrimaryKeyMap((Purchase)e, m); }
    public void acceptAllColumnMap(Entity e, Map<String, ? extends Object> m)
    { doAcceptAllColumnMap((Purchase)e, m); }
    public Map<String, Object> extractPrimaryKeyMap(Entity e) { return doExtractPrimaryKeyMap(e); }
    public Map<String, Object> extractAllColumnMap(Entity e) { return doExtractAllColumnMap(e); }
}
