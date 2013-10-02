package com.example.dbflute.spring.dbflute.vendor;

import java.util.List;

import org.seasar.dbflute.bhv.ConditionBeanSetupper;
import org.seasar.dbflute.cbean.ListResultBean;

import com.example.dbflute.spring.dbflute.cbean.ProductStatusCB;
import com.example.dbflute.spring.dbflute.cbean.PurchaseCB;
import com.example.dbflute.spring.dbflute.cbean.SummaryProductCB;
import com.example.dbflute.spring.dbflute.exbhv.ProductStatusBhv;
import com.example.dbflute.spring.dbflute.exbhv.PurchaseBhv;
import com.example.dbflute.spring.dbflute.exbhv.SummaryProductBhv;
import com.example.dbflute.spring.dbflute.exentity.ProductStatus;
import com.example.dbflute.spring.dbflute.exentity.Purchase;
import com.example.dbflute.spring.dbflute.exentity.SummaryProduct;
import com.example.dbflute.spring.unit.UnitContainerTestCase;

/**
 * @author jflute
 * @since 0.7.7 (2008/07/23 Wednesday)
 */
public class VendorViewTest extends UnitContainerTestCase {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private PurchaseBhv purchaseBhv;
    private SummaryProductBhv summaryProductBhv;
    private ProductStatusBhv productStatusBhv;

    // ===================================================================================
    //                                                                       Table to View
    //                                                                       =============
    public void test_TableToView_setupSelect() {
        // ## Arrange ##
        PurchaseCB cb = new PurchaseCB();
        cb.setupSelect_SummaryProduct();

        // ## Act ##
        ListResultBean<Purchase> purchaseList = purchaseBhv.selectList(cb);

        // ## Assert ##
        for (Purchase purchase : purchaseList) {
            SummaryProduct summaryProduct = purchase.getSummaryProduct();
            log(purchase.getPurchaseId() + ", " + summaryProduct);
            assertNotNull(summaryProduct);
        }
    }

    // ===================================================================================
    //                                                                       View to Table
    //                                                                       =============
    public void test_ViewToTable_setupSelect() {
        // ## Arrange ##
        SummaryProductCB cb = new SummaryProductCB();
        cb.setupSelect_ProductStatus();

        // ## Act ##
        ListResultBean<SummaryProduct> productList = summaryProductBhv.selectList(cb);

        // ## Assert ##
        for (SummaryProduct product : productList) {
            assertNotNull(product.getProductStatus());
        }
    }

    public void test_ViewToTable_local_loadReferrer() {
        // ## Arrange ##
        SummaryProductCB cb = new SummaryProductCB();
        ListResultBean<SummaryProduct> summaryProductList = summaryProductBhv.selectList(cb);

        // ## Act ##
        summaryProductBhv.loadPurchaseList(summaryProductList, new ConditionBeanSetupper<PurchaseCB>() {
            public void setup(PurchaseCB cb) {
                cb.query().addOrderBy_PurchaseDatetime_Desc();
            }
        });

        // ## Assert ##
        boolean existsPurchase = false;
        for (SummaryProduct summaryProduct : summaryProductList) {
            log(summaryProduct);
            List<Purchase> purchaseList = summaryProduct.getPurchaseList();
            for (Purchase purchase : purchaseList) {
                log("    " + purchase.toString());
                existsPurchase = true;
            }
        }
        assertTrue(existsPurchase);
    }

    public void test_ViewToTable_foreign_loadReferrer() {
        // ## Arrange ##
        ProductStatusCB cb = new ProductStatusCB();
        ListResultBean<ProductStatus> productStatusList = productStatusBhv.selectList(cb);

        // ## Act ##
        productStatusBhv.loadSummaryProductList(productStatusList, new ConditionBeanSetupper<SummaryProductCB>() {
            public void setup(SummaryProductCB cb) {
                cb.query().addOrderBy_LatestPurchaseDatetime_Desc();
            }
        });

        // ## Assert ##
        boolean existsSummaryProduct = false;
        for (ProductStatus productStatus : productStatusList) {
            log(productStatus);
            List<SummaryProduct> summaryProductList = productStatus.getSummaryProductList();
            for (SummaryProduct summaryProduct : summaryProductList) {
                log("    " + summaryProduct.toString());
                existsSummaryProduct = true;
            }
        }
        assertTrue(existsSummaryProduct);
    }
}
