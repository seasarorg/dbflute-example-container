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
 * The referrer loader of (購入)PURCHASE as TABLE. <br>
 * <pre>
 * [primary key]
 *     PURCHASE_ID
 *
 * [column]
 *     PURCHASE_ID, MEMBER_ID, PRODUCT_ID, PURCHASE_DATETIME, PURCHASE_COUNT, PURCHASE_PRICE, PAYMENT_COMPLETE_FLG, REGISTER_DATETIME, REGISTER_USER, UPDATE_DATETIME, UPDATE_USER, VERSION_NO
 *
 * [sequence]
 *     
 *
 * [identity]
 *     PURCHASE_ID
 *
 * [version-no]
 *     VERSION_NO
 *
 * [foreign table]
 *     MEMBER, PRODUCT, SUMMARY_PRODUCT
 *
 * [referrer table]
 *     PURCHASE_PAYMENT
 *
 * [foreign property]
 *     member, product, summaryProduct
 *
 * [referrer property]
 *     purchasePaymentList
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public class LoaderOfPurchase {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected List<Purchase> _selectedList;
    protected BehaviorSelector _selector;
    protected PurchaseBhv _myBhv; // lazy-loaded

    // ===================================================================================
    //                                                                   Ready for Loading
    //                                                                   =================
    public LoaderOfPurchase ready(List<Purchase> selectedList, BehaviorSelector selector)
    { _selectedList = selectedList; _selector = selector; return this; }

    protected PurchaseBhv myBhv()
    { if (_myBhv != null) { return _myBhv; } else { _myBhv = _selector.select(PurchaseBhv.class); return _myBhv; } }

    // ===================================================================================
    //                                                                       Load Referrer
    //                                                                       =============
    protected List<PurchasePayment> _referrerPurchasePaymentList;
    public NestedReferrerLoaderGateway<LoaderOfPurchasePayment> loadPurchasePaymentList(ConditionBeanSetupper<PurchasePaymentCB> setupper) {
        myBhv().loadPurchasePaymentList(_selectedList, setupper).withNestedReferrer(new ReferrerListHandler<PurchasePayment>() {
            public void handle(List<PurchasePayment> referrerList) { _referrerPurchasePaymentList = referrerList; }
        });
        return new NestedReferrerLoaderGateway<LoaderOfPurchasePayment>() {
            public void withNestedReferrer(ReferrerLoaderHandler<LoaderOfPurchasePayment> handler) {
                handler.handle(new LoaderOfPurchasePayment().ready(_referrerPurchasePaymentList, _selector));
            }
        };
    }

    // ===================================================================================
    //                                                                    Pull out Foreign
    //                                                                    ================
    protected LoaderOfMember _foreignMemberLoader;
    public LoaderOfMember pulloutMember() {
        if (_foreignMemberLoader != null) { return _foreignMemberLoader; }
        List<Member> pulledList = myBhv().pulloutMember(_selectedList);
        _foreignMemberLoader = new LoaderOfMember().ready(pulledList, _selector);
        return _foreignMemberLoader;
    }

    protected LoaderOfProduct _foreignProductLoader;
    public LoaderOfProduct pulloutProduct() {
        if (_foreignProductLoader != null) { return _foreignProductLoader; }
        List<Product> pulledList = myBhv().pulloutProduct(_selectedList);
        _foreignProductLoader = new LoaderOfProduct().ready(pulledList, _selector);
        return _foreignProductLoader;
    }

    protected LoaderOfSummaryProduct _foreignSummaryProductLoader;
    public LoaderOfSummaryProduct pulloutSummaryProduct() {
        if (_foreignSummaryProductLoader != null) { return _foreignSummaryProductLoader; }
        List<SummaryProduct> pulledList = myBhv().pulloutSummaryProduct(_selectedList);
        _foreignSummaryProductLoader = new LoaderOfSummaryProduct().ready(pulledList, _selector);
        return _foreignSummaryProductLoader;
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public List<Purchase> getSelectedList() { return _selectedList; }
    public BehaviorSelector getSelector() { return _selector; }
}
