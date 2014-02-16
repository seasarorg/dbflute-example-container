/*
 * Copyright(c) DBFlute TestCo.,TestLtd. All Rights Reserved.
 */
package com.example.dbflute.cdi.dbflute.bsentity.dbmeta;

import java.util.List;
import java.util.Map;

import org.seasar.dbflute.DBDef;
import org.seasar.dbflute.Entity;
import org.seasar.dbflute.dbmeta.AbstractDBMeta;
import org.seasar.dbflute.dbmeta.PropertyGateway;
import org.seasar.dbflute.dbmeta.info.*;
import org.seasar.dbflute.dbmeta.name.*;
import com.example.dbflute.cdi.dbflute.allcommon.*;
import com.example.dbflute.cdi.dbflute.exentity.*;

/**
 * The DB meta of PRODUCT_CATEGORY. (Singleton)
 * @author DBFlute(AutoGenerator)
 */
public class ProductCategoryDbm extends AbstractDBMeta {

    // ===================================================================================
    //                                                                           Singleton
    //                                                                           =========
    private static final ProductCategoryDbm _instance = new ProductCategoryDbm();
    private ProductCategoryDbm() {}
    public static ProductCategoryDbm getInstance() { return _instance; }

    // ===================================================================================
    //                                                                       Current DBDef
    //                                                                       =============
    public DBDef getCurrentDBDef() { return DBCurrent.getInstance().currentDBDef(); }

    // ===================================================================================
    //                                                                    Property Gateway
    //                                                                    ================
    protected final Map<String, PropertyGateway> _epgMap = newHashMap();
    {
        setupEpg(_epgMap, new EpgProductCategoryCode(), "productCategoryCode");
        setupEpg(_epgMap, new EpgProductCategoryName(), "productCategoryName");
        setupEpg(_epgMap, new EpgParentCategoryCode(), "parentCategoryCode");
    }
    public PropertyGateway findPropertyGateway(String propertyName)
    { return doFindEpg(_epgMap, propertyName); }
    public static class EpgProductCategoryCode implements PropertyGateway {
        public Object read(Entity et) { return ((ProductCategory)et).getProductCategoryCode(); }
        public void write(Entity et, Object vl) { ((ProductCategory)et).setProductCategoryCode((String)vl); }
    }
    public static class EpgProductCategoryName implements PropertyGateway {
        public Object read(Entity et) { return ((ProductCategory)et).getProductCategoryName(); }
        public void write(Entity et, Object vl) { ((ProductCategory)et).setProductCategoryName((String)vl); }
    }
    public static class EpgParentCategoryCode implements PropertyGateway {
        public Object read(Entity et) { return ((ProductCategory)et).getParentCategoryCode(); }
        public void write(Entity et, Object vl) { ((ProductCategory)et).setParentCategoryCode((String)vl); }
    }

    // ===================================================================================
    //                                                                          Table Info
    //                                                                          ==========
    protected final String _tableDbName = "PRODUCT_CATEGORY";
    protected final String _tablePropertyName = "productCategory";
    protected final TableSqlName _tableSqlName = new TableSqlName("PRODUCT_CATEGORY", _tableDbName);
    { _tableSqlName.xacceptFilter(DBFluteConfig.getInstance().getTableSqlNameFilter()); }
    public String getTableDbName() { return _tableDbName; }
    public String getTablePropertyName() { return _tablePropertyName; }
    public TableSqlName getTableSqlName() { return _tableSqlName; }
    protected final String _tableAlias = "商品カテゴリ";
    public String getTableAlias() { return _tableAlias; }
    protected final String _tableComment = "商品のカテゴリを表現するマスタ。\n自己参照の階層になっている。";
    public String getTableComment() { return _tableComment; }

    // ===================================================================================
    //                                                                         Column Info
    //                                                                         ===========
    protected final ColumnInfo _columnProductCategoryCode = cci("PRODUCT_CATEGORY_CODE", "PRODUCT_CATEGORY_CODE", null, "商品カテゴリコード", true, "productCategoryCode", String.class, true, false, "CHAR", 3, 0, null, false, null, null, null, "productList,productCategorySelfList", null);
    protected final ColumnInfo _columnProductCategoryName = cci("PRODUCT_CATEGORY_NAME", "PRODUCT_CATEGORY_NAME", null, "商品カテゴリ名称", true, "productCategoryName", String.class, false, false, "VARCHAR", 50, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnParentCategoryCode = cci("PARENT_CATEGORY_CODE", "PARENT_CATEGORY_CODE", null, "親カテゴリコード", false, "parentCategoryCode", String.class, false, false, "CHAR", 3, 0, null, false, null, "最上位の場合はデータなし。", "productCategorySelf", null, null);

    public ColumnInfo columnProductCategoryCode() { return _columnProductCategoryCode; }
    public ColumnInfo columnProductCategoryName() { return _columnProductCategoryName; }
    public ColumnInfo columnParentCategoryCode() { return _columnParentCategoryCode; }

    protected List<ColumnInfo> ccil() {
        List<ColumnInfo> ls = newArrayList();
        ls.add(columnProductCategoryCode());
        ls.add(columnProductCategoryName());
        ls.add(columnParentCategoryCode());
        return ls;
    }

    { initializeInformationResource(); }

    // ===================================================================================
    //                                                                         Unique Info
    //                                                                         ===========
    // -----------------------------------------------------
    //                                       Primary Element
    //                                       ---------------
    protected UniqueInfo cpui() { return hpcpui(columnProductCategoryCode()); }
    public boolean hasPrimaryKey() { return true; }
    public boolean hasCompoundPrimaryKey() { return false; }

    // ===================================================================================
    //                                                                       Relation Info
    //                                                                       =============
    // -----------------------------------------------------
    //                                      Foreign Property
    //                                      ----------------
    public ForeignInfo foreignProductCategorySelf() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnParentCategoryCode(), ProductCategoryDbm.getInstance().columnProductCategoryCode());
        return cfi("FK_PRODUCT_CATEGORY_PARENT", "productCategorySelf", this, ProductCategoryDbm.getInstance(), mp, 0, false, false, false, false, null, null, false, "productCategorySelfList");
    }

    // -----------------------------------------------------
    //                                     Referrer Property
    //                                     -----------------
    public ReferrerInfo referrerProductList() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnProductCategoryCode(), ProductDbm.getInstance().columnProductCategoryCode());
        return cri("FK_PRODUCT_PRODUCT_CATEGORY", "productList", this, ProductDbm.getInstance(), mp, false, "productCategory");
    }
    public ReferrerInfo referrerProductCategorySelfList() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnProductCategoryCode(), ProductCategoryDbm.getInstance().columnParentCategoryCode());
        return cri("FK_PRODUCT_CATEGORY_PARENT", "productCategorySelfList", this, ProductCategoryDbm.getInstance(), mp, false, "productCategorySelf");
    }

    // ===================================================================================
    //                                                                        Various Info
    //                                                                        ============

    // ===================================================================================
    //                                                                           Type Name
    //                                                                           =========
    public String getEntityTypeName() { return "com.example.dbflute.cdi.dbflute.exentity.ProductCategory"; }
    public String getConditionBeanTypeName() { return "com.example.dbflute.cdi.dbflute.cbean.ProductCategoryCB"; }
    public String getBehaviorTypeName() { return "com.example.dbflute.cdi.dbflute.exbhv.ProductCategoryBhv"; }

    // ===================================================================================
    //                                                                         Object Type
    //                                                                         ===========
    public Class<ProductCategory> getEntityType() { return ProductCategory.class; }

    // ===================================================================================
    //                                                                     Object Instance
    //                                                                     ===============
    public Entity newEntity() { return newMyEntity(); }
    public ProductCategory newMyEntity() { return new ProductCategory(); }

    // ===================================================================================
    //                                                                   Map Communication
    //                                                                   =================
    public void acceptPrimaryKeyMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptPrimaryKeyMap((ProductCategory)et, mp); }
    public void acceptAllColumnMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptAllColumnMap((ProductCategory)et, mp); }
    public Map<String, Object> extractPrimaryKeyMap(Entity et) { return doExtractPrimaryKeyMap(et); }
    public Map<String, Object> extractAllColumnMap(Entity et) { return doExtractAllColumnMap(et); }
}
