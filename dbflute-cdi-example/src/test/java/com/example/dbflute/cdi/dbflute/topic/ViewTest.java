package com.example.dbflute.cdi.dbflute.topic;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.seasar.dbflute.bhv.ConditionBeanSetupper;
import org.seasar.dbflute.cbean.ListResultBean;
import org.seasar.junitcdi.jta.Transactional;

import com.example.dbflute.cdi.dbflute.cbean.ProductStatusCB;
import com.example.dbflute.cdi.dbflute.cbean.PurchaseCB;
import com.example.dbflute.cdi.dbflute.cbean.SummaryProductCB;
import com.example.dbflute.cdi.dbflute.exbhv.ProductStatusBhv;
import com.example.dbflute.cdi.dbflute.exbhv.SummaryProductBhv;
import com.example.dbflute.cdi.dbflute.exentity.ProductStatus;
import com.example.dbflute.cdi.dbflute.exentity.Purchase;
import com.example.dbflute.cdi.dbflute.exentity.SummaryProduct;
import com.example.dbflute.cdi.unit.ContainerTestCase;

/**
 * @author jflute
 * @since 0.7.7 (2008/07/23 Wednesday)
 */
public class ViewTest extends ContainerTestCase {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    @Inject
    private SummaryProductBhv summaryProductBhv;
    @Inject
    private ProductStatusBhv productStatusBhv;

    // ===================================================================================
    //                                                                       Relation Test
    //                                                                       =============
    @Test
    @Transactional
    public void test_setupSelect_Tx() {
        // ## Arrange ##
        final SummaryProductCB cb = new SummaryProductCB();
        cb.setupSelect_ProductStatus();

        // ## Act ##
        final ListResultBean<SummaryProduct> productList = this.summaryProductBhv.selectList(cb);

        // ## Assert ##
        for (final SummaryProduct product : productList) {
            assertNotNull(product.getProductStatus());
        }
    }

    @Test
    @Transactional
    public void test_local_loadReferrer_Tx() {
        // ## Arrange ##
        final SummaryProductCB cb = new SummaryProductCB();
        final ListResultBean<SummaryProduct> summaryProductList = this.summaryProductBhv.selectList(cb);

        // ## Act ##
        this.summaryProductBhv.loadPurchaseList(summaryProductList, new ConditionBeanSetupper<PurchaseCB>() {
            public void setup(final PurchaseCB cb) {
                cb.query().addOrderBy_PurchaseDatetime_Desc();
            }
        });

        // ## Assert ##
        boolean existsPurchase = false;
        for (final SummaryProduct summaryProduct : summaryProductList) {
            this.log(summaryProduct);
            final List<Purchase> purchaseList = summaryProduct.getPurchaseList();
            for (final Purchase purchase : purchaseList) {
                this.log("    " + purchase.toString());
                existsPurchase = true;
            }
        }
        assertTrue(existsPurchase);
    }

    @Test
    @Transactional
    public void test_foreign_loadReferrer_Tx() {
        // ## Arrange ##
        final ProductStatusCB cb = new ProductStatusCB();
        final ListResultBean<ProductStatus> productStatusList = this.productStatusBhv.selectList(cb);

        // ## Act ##
        this.productStatusBhv.loadSummaryProductList(productStatusList, new ConditionBeanSetupper<SummaryProductCB>() {
            public void setup(final SummaryProductCB cb) {
                cb.query().addOrderBy_LatestPurchaseDatetime_Desc();
            }
        });

        // ## Assert ##
        boolean existsSummaryProduct = false;
        for (final ProductStatus productStatus : productStatusList) {
            this.log(productStatus);
            final List<SummaryProduct> summaryProductList = productStatus.getSummaryProductList();
            for (final SummaryProduct summaryProduct : summaryProductList) {
                this.log("    " + summaryProduct.toString());
                existsSummaryProduct = true;
            }
        }
        assertTrue(existsSummaryProduct);
    }
}
