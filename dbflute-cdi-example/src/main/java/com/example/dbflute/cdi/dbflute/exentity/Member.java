/*
 * Copyright(c) DBFlute TestCo.,TestLtd. All Rights Reserved.
 */
package com.example.dbflute.cdi.dbflute.exentity;

import java.sql.Timestamp;

import com.example.dbflute.cdi.dbflute.bsentity.BsMember;

/**
 * The entity of MEMBER.
 * <p>
 * You can implement your original methods here.
 * This class remains when re-generating.
 * </p>
 * @author DBFlute(AutoGenerator)
 */
public class Member extends BsMember {

    /** Serial version UID. (Default) */
    private static final long serialVersionUID = 1L;

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    public static final String ALIAS_latestLoginDatetime = "LATEST_LOGIN_DATETIME";
    public static final String ALIAS_loginCount = "LOGIN_COUNT";
    public static final String ALIAS_productKindCount = "PRODUCT_KIND_COUNT";

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** 導出カラム「最終ログイン日時」のためのプロパティ。これは手動で作成する。 */
    protected Timestamp _latestLoginDatetime;

    /** 導出カラム「ログイン回数」のためのプロパティ。これは手動で作成する。 */
    protected Integer _loginCount;

    /** 導出カラム「プロダクト種類数」のためのプロパティ。これは手動で作成する。 */
    protected Integer _productKindCount;

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public Timestamp getLatestLoginDatetime() {
        return this._latestLoginDatetime;
    }

    public void setLatestLoginDatetime(final Timestamp latestLoginDatetime) {
        this._latestLoginDatetime = latestLoginDatetime;
    }

    public Integer getLoginCount() {
        return this._loginCount;
    }

    public void setLoginCount(final Integer loginCount) {
        this._loginCount = loginCount;
    }

    public Integer getProductKindCount() {
        return this._productKindCount;
    }

    public void setProductKindCount(final Integer productKindCount) {
        this._productKindCount = productKindCount;
    }
}
