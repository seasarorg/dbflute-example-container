package com.example.dbflute.guice.dbflute.cbean.cq.bs;

import java.util.*;

import org.seasar.dbflute.cbean.*;
import org.seasar.dbflute.cbean.chelper.*;
import org.seasar.dbflute.cbean.ckey.*;
import org.seasar.dbflute.cbean.coption.*;
import org.seasar.dbflute.cbean.cvalue.ConditionValue;
import org.seasar.dbflute.cbean.sqlclause.SqlClause;
import org.seasar.dbflute.dbmeta.DBMetaProvider;
import com.example.dbflute.guice.dbflute.allcommon.*;
import com.example.dbflute.guice.dbflute.cbean.*;
import com.example.dbflute.guice.dbflute.cbean.cq.*;

/**
 * The abstract condition-query of PRODUCT_STATUS.
 * @author DBFlute(AutoGenerator)
 */
public abstract class AbstractBsProductStatusCQ extends AbstractConditionQuery {

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public AbstractBsProductStatusCQ(ConditionQuery childQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
        super(childQuery, sqlClause, aliasName, nestLevel);
    }

    // ===================================================================================
    //                                                                     DBMeta Provider
    //                                                                     ===============
    @Override
    protected DBMetaProvider xgetDBMetaProvider() {
        return DBMetaInstanceHandler.getProvider();
    }

    // ===================================================================================
    //                                                                          Table Name
    //                                                                          ==========
    public String getTableDbName() {
        return "PRODUCT_STATUS";
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * (商品ステータスコード)PRODUCT_STATUS_CODE: {PK, NotNull, CHAR(3), classification=ProductStatus}
     * @param productStatusCode The value of productStatusCode as equal. (NullAllowed: if null (or empty), no condition)
     */
    public void setProductStatusCode_Equal(String productStatusCode) {
        doSetProductStatusCode_Equal(fRES(productStatusCode));
    }

    /**
     * Equal(=). As ProductStatus. And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * (商品ステータスコード)PRODUCT_STATUS_CODE: {PK, NotNull, CHAR(3), classification=ProductStatus} <br />
     * status for product
     * @param cdef The instance of classification definition (as ENUM type). (NullAllowed: if null, no condition)
     */
    public void setProductStatusCode_Equal_AsProductStatus(CDef.ProductStatus cdef) {
        doSetProductStatusCode_Equal(cdef != null ? cdef.code() : null);
    }

    /**
     * Equal(=). As 生産販売可能 (ONS). And OnlyOnceRegistered. <br />
     * 生産販売可能
     */
    public void setProductStatusCode_Equal_生産販売可能() {
        setProductStatusCode_Equal_AsProductStatus(CDef.ProductStatus.生産販売可能);
    }

    /**
     * Equal(=). As 生産中止 (PST). And OnlyOnceRegistered. <br />
     * 生産中止
     */
    public void setProductStatusCode_Equal_生産中止() {
        setProductStatusCode_Equal_AsProductStatus(CDef.ProductStatus.生産中止);
    }

    /**
     * Equal(=). As 販売中止 (SST). And OnlyOnceRegistered. <br />
     * 販売中止
     */
    public void setProductStatusCode_Equal_販売中止() {
        setProductStatusCode_Equal_AsProductStatus(CDef.ProductStatus.販売中止);
    }

    protected void doSetProductStatusCode_Equal(String productStatusCode) {
        regProductStatusCode(CK_EQ, hSC("PRODUCT_STATUS_CODE", productStatusCode, 3, "E"));
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * (商品ステータスコード)PRODUCT_STATUS_CODE: {PK, NotNull, CHAR(3), classification=ProductStatus}
     * @param productStatusCode The value of productStatusCode as notEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setProductStatusCode_NotEqual(String productStatusCode) {
        doSetProductStatusCode_NotEqual(fRES(productStatusCode));
    }

    /**
     * NotEqual(&lt;&gt;). As ProductStatus. And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * (商品ステータスコード)PRODUCT_STATUS_CODE: {PK, NotNull, CHAR(3), classification=ProductStatus} <br />
     * status for product
     * @param cdef The instance of classification definition (as ENUM type). (NullAllowed: if null, no condition)
     */
    public void setProductStatusCode_NotEqual_AsProductStatus(CDef.ProductStatus cdef) {
        doSetProductStatusCode_NotEqual(cdef != null ? cdef.code() : null);
    }

    /**
     * NotEqual(&lt;&gt;). As 生産販売可能 (ONS). And OnlyOnceRegistered. <br />
     * 生産販売可能
     */
    public void setProductStatusCode_NotEqual_生産販売可能() {
        setProductStatusCode_NotEqual_AsProductStatus(CDef.ProductStatus.生産販売可能);
    }

    /**
     * NotEqual(&lt;&gt;). As 生産中止 (PST). And OnlyOnceRegistered. <br />
     * 生産中止
     */
    public void setProductStatusCode_NotEqual_生産中止() {
        setProductStatusCode_NotEqual_AsProductStatus(CDef.ProductStatus.生産中止);
    }

    /**
     * NotEqual(&lt;&gt;). As 販売中止 (SST). And OnlyOnceRegistered. <br />
     * 販売中止
     */
    public void setProductStatusCode_NotEqual_販売中止() {
        setProductStatusCode_NotEqual_AsProductStatus(CDef.ProductStatus.販売中止);
    }

    protected void doSetProductStatusCode_NotEqual(String productStatusCode) {
        regProductStatusCode(CK_NES, hSC("PRODUCT_STATUS_CODE", productStatusCode, 3, "E"));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * (商品ステータスコード)PRODUCT_STATUS_CODE: {PK, NotNull, CHAR(3), classification=ProductStatus}
     * @param productStatusCodeList The collection of productStatusCode as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setProductStatusCode_InScope(Collection<String> productStatusCodeList) {
        doSetProductStatusCode_InScope(productStatusCodeList);
    }

    /**
     * InScope {in ('a', 'b')}. As ProductStatus. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * (商品ステータスコード)PRODUCT_STATUS_CODE: {PK, NotNull, CHAR(3), classification=ProductStatus} <br />
     * status for product
     * @param cdefList The list of classification definition (as ENUM type). (NullAllowed: if null (or empty), no condition)
     */
    public void setProductStatusCode_InScope_AsProductStatus(Collection<CDef.ProductStatus> cdefList) {
        doSetProductStatusCode_InScope(cTStrL(cdefList));
    }

    public void doSetProductStatusCode_InScope(Collection<String> productStatusCodeList) {
        regINS(CK_INS, cTL(productStatusCodeList), getCValueProductStatusCode(), "PRODUCT_STATUS_CODE");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * (商品ステータスコード)PRODUCT_STATUS_CODE: {PK, NotNull, CHAR(3), classification=ProductStatus}
     * @param productStatusCodeList The collection of productStatusCode as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setProductStatusCode_NotInScope(Collection<String> productStatusCodeList) {
        doSetProductStatusCode_NotInScope(productStatusCodeList);
    }

    /**
     * NotInScope {not in ('a', 'b')}. As ProductStatus. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * (商品ステータスコード)PRODUCT_STATUS_CODE: {PK, NotNull, CHAR(3), classification=ProductStatus} <br />
     * status for product
     * @param cdefList The list of classification definition (as ENUM type). (NullAllowed: if null (or empty), no condition)
     */
    public void setProductStatusCode_NotInScope_AsProductStatus(Collection<CDef.ProductStatus> cdefList) {
        doSetProductStatusCode_NotInScope(cTStrL(cdefList));
    }

    public void doSetProductStatusCode_NotInScope(Collection<String> productStatusCodeList) {
        regINS(CK_NINS, cTL(productStatusCodeList), getCValueProductStatusCode(), "PRODUCT_STATUS_CODE");
    }

    /**
     * Set up ExistsReferrer (correlated sub-query). <br />
     * {exists (select PRODUCT_STATUS_CODE from PRODUCT where ...)} <br />
     * (商品)PRODUCT by PRODUCT_STATUS_CODE, named 'productAsOne'.
     * <pre>
     * cb.query().<span style="color: #FD4747">existsProductList</span>(new SubQuery&lt;ProductCB&gt;() {
     *     public void query(ProductCB subCB) {
     *         subCB.query().setXxx...
     *     }
     * });
     * </pre>
     * @param subQuery The sub-query of ProductList for 'exists'. (NotNull)
     */
    public void existsProductList(SubQuery<ProductCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        ProductCB cb = new ProductCB(); cb.xsetupForExistsReferrer(this); subQuery.query(cb);
        String pp = keepProductStatusCode_ExistsReferrer_ProductList(cb.query()); // for saving query-value.
        registerExistsReferrer(cb.query(), "PRODUCT_STATUS_CODE", "PRODUCT_STATUS_CODE", pp, "productList");
    }
    public abstract String keepProductStatusCode_ExistsReferrer_ProductList(ProductCQ sq);

    /**
     * Set up ExistsReferrer (correlated sub-query). <br />
     * {exists (select PRODUCT_STATUS_CODE from SUMMARY_PRODUCT where ...)} <br />
     * SUMMARY_PRODUCT by PRODUCT_STATUS_CODE, named 'summaryProductAsOne'.
     * <pre>
     * cb.query().<span style="color: #FD4747">existsSummaryProductList</span>(new SubQuery&lt;SummaryProductCB&gt;() {
     *     public void query(SummaryProductCB subCB) {
     *         subCB.query().setXxx...
     *     }
     * });
     * </pre>
     * @param subQuery The sub-query of SummaryProductList for 'exists'. (NotNull)
     */
    public void existsSummaryProductList(SubQuery<SummaryProductCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        SummaryProductCB cb = new SummaryProductCB(); cb.xsetupForExistsReferrer(this); subQuery.query(cb);
        String pp = keepProductStatusCode_ExistsReferrer_SummaryProductList(cb.query()); // for saving query-value.
        registerExistsReferrer(cb.query(), "PRODUCT_STATUS_CODE", "PRODUCT_STATUS_CODE", pp, "summaryProductList");
    }
    public abstract String keepProductStatusCode_ExistsReferrer_SummaryProductList(SummaryProductCQ sq);

    /**
     * Set up NotExistsReferrer (correlated sub-query). <br />
     * {not exists (select PRODUCT_STATUS_CODE from PRODUCT where ...)} <br />
     * (商品)PRODUCT by PRODUCT_STATUS_CODE, named 'productAsOne'.
     * <pre>
     * cb.query().<span style="color: #FD4747">notExistsProductList</span>(new SubQuery&lt;ProductCB&gt;() {
     *     public void query(ProductCB subCB) {
     *         subCB.query().setXxx...
     *     }
     * });
     * </pre>
     * @param subQuery The sub-query of ProductStatusCode_NotExistsReferrer_ProductList for 'not exists'. (NotNull)
     */
    public void notExistsProductList(SubQuery<ProductCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        ProductCB cb = new ProductCB(); cb.xsetupForExistsReferrer(this); subQuery.query(cb);
        String pp = keepProductStatusCode_NotExistsReferrer_ProductList(cb.query()); // for saving query-value.
        registerNotExistsReferrer(cb.query(), "PRODUCT_STATUS_CODE", "PRODUCT_STATUS_CODE", pp, "productList");
    }
    public abstract String keepProductStatusCode_NotExistsReferrer_ProductList(ProductCQ sq);

    /**
     * Set up NotExistsReferrer (correlated sub-query). <br />
     * {not exists (select PRODUCT_STATUS_CODE from SUMMARY_PRODUCT where ...)} <br />
     * SUMMARY_PRODUCT by PRODUCT_STATUS_CODE, named 'summaryProductAsOne'.
     * <pre>
     * cb.query().<span style="color: #FD4747">notExistsSummaryProductList</span>(new SubQuery&lt;SummaryProductCB&gt;() {
     *     public void query(SummaryProductCB subCB) {
     *         subCB.query().setXxx...
     *     }
     * });
     * </pre>
     * @param subQuery The sub-query of ProductStatusCode_NotExistsReferrer_SummaryProductList for 'not exists'. (NotNull)
     */
    public void notExistsSummaryProductList(SubQuery<SummaryProductCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        SummaryProductCB cb = new SummaryProductCB(); cb.xsetupForExistsReferrer(this); subQuery.query(cb);
        String pp = keepProductStatusCode_NotExistsReferrer_SummaryProductList(cb.query()); // for saving query-value.
        registerNotExistsReferrer(cb.query(), "PRODUCT_STATUS_CODE", "PRODUCT_STATUS_CODE", pp, "summaryProductList");
    }
    public abstract String keepProductStatusCode_NotExistsReferrer_SummaryProductList(SummaryProductCQ sq);

    /**
     * Set up InScopeRelation (sub-query). <br />
     * {in (select PRODUCT_STATUS_CODE from PRODUCT where ...)} <br />
     * (商品)PRODUCT by PRODUCT_STATUS_CODE, named 'productAsOne'.
     * @param subQuery The sub-query of ProductList for 'in-scope'. (NotNull)
     */
    public void inScopeProductList(SubQuery<ProductCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        ProductCB cb = new ProductCB(); cb.xsetupForInScopeRelation(this); subQuery.query(cb);
        String pp = keepProductStatusCode_InScopeRelation_ProductList(cb.query()); // for saving query-value.
        registerInScopeRelation(cb.query(), "PRODUCT_STATUS_CODE", "PRODUCT_STATUS_CODE", pp, "productList");
    }
    public abstract String keepProductStatusCode_InScopeRelation_ProductList(ProductCQ sq);

    /**
     * Set up InScopeRelation (sub-query). <br />
     * {in (select PRODUCT_STATUS_CODE from SUMMARY_PRODUCT where ...)} <br />
     * SUMMARY_PRODUCT by PRODUCT_STATUS_CODE, named 'summaryProductAsOne'.
     * @param subQuery The sub-query of SummaryProductList for 'in-scope'. (NotNull)
     */
    public void inScopeSummaryProductList(SubQuery<SummaryProductCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        SummaryProductCB cb = new SummaryProductCB(); cb.xsetupForInScopeRelation(this); subQuery.query(cb);
        String pp = keepProductStatusCode_InScopeRelation_SummaryProductList(cb.query()); // for saving query-value.
        registerInScopeRelation(cb.query(), "PRODUCT_STATUS_CODE", "PRODUCT_STATUS_CODE", pp, "summaryProductList");
    }
    public abstract String keepProductStatusCode_InScopeRelation_SummaryProductList(SummaryProductCQ sq);

    /**
     * Set up NotInScopeRelation (sub-query). <br />
     * {not in (select PRODUCT_STATUS_CODE from PRODUCT where ...)} <br />
     * (商品)PRODUCT by PRODUCT_STATUS_CODE, named 'productAsOne'.
     * @param subQuery The sub-query of ProductList for 'not in-scope'. (NotNull)
     */
    public void notInScopeProductList(SubQuery<ProductCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        ProductCB cb = new ProductCB(); cb.xsetupForInScopeRelation(this); subQuery.query(cb);
        String pp = keepProductStatusCode_NotInScopeRelation_ProductList(cb.query()); // for saving query-value.
        registerNotInScopeRelation(cb.query(), "PRODUCT_STATUS_CODE", "PRODUCT_STATUS_CODE", pp, "productList");
    }
    public abstract String keepProductStatusCode_NotInScopeRelation_ProductList(ProductCQ sq);

    /**
     * Set up NotInScopeRelation (sub-query). <br />
     * {not in (select PRODUCT_STATUS_CODE from SUMMARY_PRODUCT where ...)} <br />
     * SUMMARY_PRODUCT by PRODUCT_STATUS_CODE, named 'summaryProductAsOne'.
     * @param subQuery The sub-query of SummaryProductList for 'not in-scope'. (NotNull)
     */
    public void notInScopeSummaryProductList(SubQuery<SummaryProductCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        SummaryProductCB cb = new SummaryProductCB(); cb.xsetupForInScopeRelation(this); subQuery.query(cb);
        String pp = keepProductStatusCode_NotInScopeRelation_SummaryProductList(cb.query()); // for saving query-value.
        registerNotInScopeRelation(cb.query(), "PRODUCT_STATUS_CODE", "PRODUCT_STATUS_CODE", pp, "summaryProductList");
    }
    public abstract String keepProductStatusCode_NotInScopeRelation_SummaryProductList(SummaryProductCQ sq);

    public void xsderiveProductList(String fn, SubQuery<ProductCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        ProductCB cb = new ProductCB(); cb.xsetupForDerivedReferrer(this); sq.query(cb);
        String pp = keepProductStatusCode_SpecifyDerivedReferrer_ProductList(cb.query()); // for saving query-value.
        registerSpecifyDerivedReferrer(fn, cb.query(), "PRODUCT_STATUS_CODE", "PRODUCT_STATUS_CODE", pp, "productList", al, op);
    }
    public abstract String keepProductStatusCode_SpecifyDerivedReferrer_ProductList(ProductCQ sq);

    public void xsderiveSummaryProductList(String fn, SubQuery<SummaryProductCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        SummaryProductCB cb = new SummaryProductCB(); cb.xsetupForDerivedReferrer(this); sq.query(cb);
        String pp = keepProductStatusCode_SpecifyDerivedReferrer_SummaryProductList(cb.query()); // for saving query-value.
        registerSpecifyDerivedReferrer(fn, cb.query(), "PRODUCT_STATUS_CODE", "PRODUCT_STATUS_CODE", pp, "summaryProductList", al, op);
    }
    public abstract String keepProductStatusCode_SpecifyDerivedReferrer_SummaryProductList(SummaryProductCQ sq);

    /**
     * Prepare for (Query)DerivedReferrer. <br />
     * {FOO &lt;= (select max(BAR) from PRODUCT where ...)} <br />
     * (商品)PRODUCT by PRODUCT_STATUS_CODE, named 'productAsOne'.
     * <pre>
     * cb.query().<span style="color: #FD4747">derivedProductList()</span>.<span style="color: #FD4747">max</span>(new SubQuery&lt;ProductCB&gt;() {
     *     public void query(ProductCB subCB) {
     *         subCB.specify().<span style="color: #FD4747">columnFoo...</span> <span style="color: #3F7E5E">// derived column by function</span>
     *         subCB.query().setBar... <span style="color: #3F7E5E">// referrer condition</span>
     *     }
     * }).<span style="color: #FD4747">greaterEqual</span>(123); <span style="color: #3F7E5E">// condition to derived column</span>
     * </pre>
     * @return The object to set up a function for referrer table. (NotNull)
     */
    public HpQDRFunction<ProductCB> derivedProductList() {
        return xcreateQDRFunctionProductList();
    }
    protected HpQDRFunction<ProductCB> xcreateQDRFunctionProductList() {
        return new HpQDRFunction<ProductCB>(new HpQDRSetupper<ProductCB>() {
            public void setup(String fn, SubQuery<ProductCB> sq, String rd, Object vl, DerivedReferrerOption op) {
                xqderiveProductList(fn, sq, rd, vl, op);
            }
        });
    }
    public void xqderiveProductList(String fn, SubQuery<ProductCB> sq, String rd, Object vl, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        ProductCB cb = new ProductCB(); cb.xsetupForDerivedReferrer(this); sq.query(cb);
        String sqpp = keepProductStatusCode_QueryDerivedReferrer_ProductList(cb.query()); // for saving query-value.
        String prpp = keepProductStatusCode_QueryDerivedReferrer_ProductListParameter(vl);
        registerQueryDerivedReferrer(fn, cb.query(), "PRODUCT_STATUS_CODE", "PRODUCT_STATUS_CODE", sqpp, "productList", rd, vl, prpp, op);
    }
    public abstract String keepProductStatusCode_QueryDerivedReferrer_ProductList(ProductCQ sq);
    public abstract String keepProductStatusCode_QueryDerivedReferrer_ProductListParameter(Object vl);

    /**
     * Prepare for (Query)DerivedReferrer. <br />
     * {FOO &lt;= (select max(BAR) from SUMMARY_PRODUCT where ...)} <br />
     * SUMMARY_PRODUCT by PRODUCT_STATUS_CODE, named 'summaryProductAsOne'.
     * <pre>
     * cb.query().<span style="color: #FD4747">derivedSummaryProductList()</span>.<span style="color: #FD4747">max</span>(new SubQuery&lt;SummaryProductCB&gt;() {
     *     public void query(SummaryProductCB subCB) {
     *         subCB.specify().<span style="color: #FD4747">columnFoo...</span> <span style="color: #3F7E5E">// derived column by function</span>
     *         subCB.query().setBar... <span style="color: #3F7E5E">// referrer condition</span>
     *     }
     * }).<span style="color: #FD4747">greaterEqual</span>(123); <span style="color: #3F7E5E">// condition to derived column</span>
     * </pre>
     * @return The object to set up a function for referrer table. (NotNull)
     */
    public HpQDRFunction<SummaryProductCB> derivedSummaryProductList() {
        return xcreateQDRFunctionSummaryProductList();
    }
    protected HpQDRFunction<SummaryProductCB> xcreateQDRFunctionSummaryProductList() {
        return new HpQDRFunction<SummaryProductCB>(new HpQDRSetupper<SummaryProductCB>() {
            public void setup(String fn, SubQuery<SummaryProductCB> sq, String rd, Object vl, DerivedReferrerOption op) {
                xqderiveSummaryProductList(fn, sq, rd, vl, op);
            }
        });
    }
    public void xqderiveSummaryProductList(String fn, SubQuery<SummaryProductCB> sq, String rd, Object vl, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        SummaryProductCB cb = new SummaryProductCB(); cb.xsetupForDerivedReferrer(this); sq.query(cb);
        String sqpp = keepProductStatusCode_QueryDerivedReferrer_SummaryProductList(cb.query()); // for saving query-value.
        String prpp = keepProductStatusCode_QueryDerivedReferrer_SummaryProductListParameter(vl);
        registerQueryDerivedReferrer(fn, cb.query(), "PRODUCT_STATUS_CODE", "PRODUCT_STATUS_CODE", sqpp, "summaryProductList", rd, vl, prpp, op);
    }
    public abstract String keepProductStatusCode_QueryDerivedReferrer_SummaryProductList(SummaryProductCQ sq);
    public abstract String keepProductStatusCode_QueryDerivedReferrer_SummaryProductListParameter(Object vl);

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br />
     * (商品ステータスコード)PRODUCT_STATUS_CODE: {PK, NotNull, CHAR(3), classification=ProductStatus}
     */
    public void setProductStatusCode_IsNull() { regProductStatusCode(CK_ISN, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br />
     * (商品ステータスコード)PRODUCT_STATUS_CODE: {PK, NotNull, CHAR(3), classification=ProductStatus}
     */
    public void setProductStatusCode_IsNotNull() { regProductStatusCode(CK_ISNN, DOBJ); }

    protected void regProductStatusCode(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueProductStatusCode(), "PRODUCT_STATUS_CODE"); }
    protected abstract ConditionValue getCValueProductStatusCode();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * (商品ステータス名称)PRODUCT_STATUS_NAME: {NotNull, VARCHAR(50)}
     * @param productStatusName The value of productStatusName as equal. (NullAllowed: if null (or empty), no condition)
     */
    public void setProductStatusName_Equal(String productStatusName) {
        doSetProductStatusName_Equal(fRES(productStatusName));
    }

    protected void doSetProductStatusName_Equal(String productStatusName) {
        regProductStatusName(CK_EQ, productStatusName);
    }

    /**
     * PrefixSearch {like 'xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * (商品ステータス名称)PRODUCT_STATUS_NAME: {NotNull, VARCHAR(50)}
     * @param productStatusName The value of productStatusName as prefixSearch. (NullAllowed: if null (or empty), no condition)
     */
    public void setProductStatusName_PrefixSearch(String productStatusName) {
        setProductStatusName_LikeSearch(productStatusName, cLSOP());
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * (商品ステータス名称)PRODUCT_STATUS_NAME: {NotNull, VARCHAR(50)} <br />
     * <pre>e.g. setProductStatusName_LikeSearch("xxx", new <span style="color: #FD4747">LikeSearchOption</span>().likeContain());</pre>
     * @param productStatusName The value of productStatusName as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    public void setProductStatusName_LikeSearch(String productStatusName, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(productStatusName), getCValueProductStatusName(), "PRODUCT_STATUS_NAME", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br />
     * And NullOrEmptyIgnored, SeveralRegistered. <br />
     * (商品ステータス名称)PRODUCT_STATUS_NAME: {NotNull, VARCHAR(50)}
     * @param productStatusName The value of productStatusName as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    public void setProductStatusName_NotLikeSearch(String productStatusName, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(productStatusName), getCValueProductStatusName(), "PRODUCT_STATUS_NAME", likeSearchOption);
    }

    protected void regProductStatusName(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueProductStatusName(), "PRODUCT_STATUS_NAME"); }
    protected abstract ConditionValue getCValueProductStatusName();
    
    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br />
     * (表示順)DISPLAY_ORDER: {UQ, NotNull, INTEGER(10)}
     * @param displayOrder The value of displayOrder as equal. (NullAllowed: if null, no condition)
     */
    public void setDisplayOrder_Equal(Integer displayOrder) {
        doSetDisplayOrder_Equal(displayOrder);
    }

    protected void doSetDisplayOrder_Equal(Integer displayOrder) {
        regDisplayOrder(CK_EQ, displayOrder);
    }

    /**
     * RangeOf with various options. (versatile) <br />
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br />
     * And NullIgnored, OnlyOnceRegistered. <br />
     * (表示順)DISPLAY_ORDER: {UQ, NotNull, INTEGER(10)}
     * @param minNumber The min number of displayOrder. (NullAllowed: if null, no from-condition)
     * @param maxNumber The max number of displayOrder. (NullAllowed: if null, no to-condition)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    public void setDisplayOrder_RangeOf(Integer minNumber, Integer maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, getCValueDisplayOrder(), "DISPLAY_ORDER", rangeOfOption);
    }

    protected void regDisplayOrder(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueDisplayOrder(), "DISPLAY_ORDER"); }
    protected abstract ConditionValue getCValueDisplayOrder();

    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    protected ProductStatusCB newMyCB() {
        return new ProductStatusCB();
    }
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xabCQ() { return ProductStatusCQ.class.getName(); }
    protected String xabLSO() { return LikeSearchOption.class.getName(); }
    protected String xabSSQS() { return HpSSQSetupper.class.getName(); }
}
