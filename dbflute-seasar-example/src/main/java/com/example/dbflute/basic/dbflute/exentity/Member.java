/*
 * Copyright(c) DBFlute TestCo.,TestLtd. All Rights Reserved.
 */
package com.example.dbflute.basic.dbflute.exentity;

import java.sql.Timestamp;

import com.example.dbflute.basic.dbflute.bsentity.BsMember;

/**
 * The entity of MEMBER.
 * @author DBFlute(AutoGenerator)
 * @author jflute
 */
public class Member extends BsMember {

    /** Serial version UID. (Default) */
    private static final long serialVersionUID = 1L;

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    public static final String ALIAS_highestPurchasePrice = "HIGHEST_PURCHASE_PRICE";
    public static final String ALIAS_latestLoginDatetime = "LATEST_LOGIN_DATETIME";
    public static final String ALIAS_loginCount = "LOGIN_COUNT";
    public static final String ALIAS_productKindCount = "PRODUCT_KIND_COUNT";

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** 導出カラム「最大購入価格」のためのプロパティ */
    protected Integer _highestPurchasePrice;

    /** 導出カラム「最終ログイン日時」のためのプロパティ */
    protected Timestamp _latestLoginDatetime;

    /** 導出カラム「ログイン回数」のためのプロパティ */
    protected Integer _loginCount;

    /** 導出カラム「プロダクト種類数」のためのプロパティ */
    protected Integer _productKindCount;

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public Integer getHighestPurchasePrice() {
        return _highestPurchasePrice;
    }

    public void setHighestPurchasePrice(Integer highestPurchasePrice) {
        this._highestPurchasePrice = highestPurchasePrice;
    }

    public Timestamp getLatestLoginDatetime() {
        return _latestLoginDatetime;
    }

    public void setLatestLoginDatetime(Timestamp latestLoginDatetime) {
        _latestLoginDatetime = latestLoginDatetime;
    }

    public Integer getLoginCount() {
        return _loginCount;
    }

    public void setLoginCount(Integer loginCount) {
        this._loginCount = loginCount;
    }

    public Integer getProductKindCount() {
        return _productKindCount;
    }

    public void setProductKindCount(Integer productKindCount) {
        this._productKindCount = productKindCount;
    }
}
