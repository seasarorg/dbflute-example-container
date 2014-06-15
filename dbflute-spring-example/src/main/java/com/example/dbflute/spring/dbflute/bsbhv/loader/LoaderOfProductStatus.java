/*
 * Copyright 2004-2014 the Seasar Foundation and the Others.
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
package com.example.dbflute.spring.dbflute.bsbhv.loader;

import java.util.List;

import org.seasar.dbflute.*;
import org.seasar.dbflute.bhv.*;
import com.example.dbflute.spring.dbflute.exbhv.*;
import com.example.dbflute.spring.dbflute.exentity.*;
import com.example.dbflute.spring.dbflute.cbean.*;

/**
 * The referrer loader of (商品ステータス)PRODUCT_STATUS as TABLE. <br />
 * <pre>
 * [primary key]
 *     PRODUCT_STATUS_CODE
 *
 * [column]
 *     PRODUCT_STATUS_CODE, PRODUCT_STATUS_NAME, DISPLAY_ORDER
 *
 * [sequence]
 *     
 *
 * [identity]
 *     
 *
 * [version-no]
 *     
 *
 * [foreign table]
 *     
 *
 * [referrer table]
 *     PRODUCT, SUMMARY_PRODUCT
 *
 * [foreign property]
 *     
 *
 * [referrer property]
 *     productList, summaryProductList
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public class LoaderOfProductStatus {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected List<ProductStatus> _selectedList;
    protected BehaviorSelector _selector;
    protected ProductStatusBhv _myBhv; // lazy-loaded

    // ===================================================================================
    //                                                                   Ready for Loading
    //                                                                   =================
    public LoaderOfProductStatus ready(List<ProductStatus> selectedList, BehaviorSelector selector)
    { _selectedList = selectedList; _selector = selector; return this; }

    protected ProductStatusBhv myBhv()
    { if (_myBhv != null) { return _myBhv; } else { _myBhv = _selector.select(ProductStatusBhv.class); return _myBhv; } }

    // ===================================================================================
    //                                                                       Load Referrer
    //                                                                       =============
    protected List<Product> _referrerProductList;
    public NestedReferrerLoaderGateway<LoaderOfProduct> loadProductList(ConditionBeanSetupper<ProductCB> setupper) {
        myBhv().loadProductList(_selectedList, setupper).withNestedReferrer(new ReferrerListHandler<Product>() {
            public void handle(List<Product> referrerList) { _referrerProductList = referrerList; }
        });
        return new NestedReferrerLoaderGateway<LoaderOfProduct>() {
            public void withNestedReferrer(ReferrerLoaderHandler<LoaderOfProduct> handler) {
                handler.handle(new LoaderOfProduct().ready(_referrerProductList, _selector));
            }
        };
    }

    protected List<SummaryProduct> _referrerSummaryProductList;
    public NestedReferrerLoaderGateway<LoaderOfSummaryProduct> loadSummaryProductList(ConditionBeanSetupper<SummaryProductCB> setupper) {
        myBhv().loadSummaryProductList(_selectedList, setupper).withNestedReferrer(new ReferrerListHandler<SummaryProduct>() {
            public void handle(List<SummaryProduct> referrerList) { _referrerSummaryProductList = referrerList; }
        });
        return new NestedReferrerLoaderGateway<LoaderOfSummaryProduct>() {
            public void withNestedReferrer(ReferrerLoaderHandler<LoaderOfSummaryProduct> handler) {
                handler.handle(new LoaderOfSummaryProduct().ready(_referrerSummaryProductList, _selector));
            }
        };
    }

    // ===================================================================================
    //                                                                    Pull out Foreign
    //                                                                    ================
    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public List<ProductStatus> getSelectedList() { return _selectedList; }
    public BehaviorSelector getSelector() { return _selector; }
}
