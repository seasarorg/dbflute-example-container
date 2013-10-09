/*
 * Copyright(c) DBFlute TestCo.,TestLtd. All Rights Reserved.
 */
package com.example.dbflute.cdi.dbflute.cbean.cq;

import org.seasar.dbflute.cbean.ConditionQuery;
import org.seasar.dbflute.cbean.SubQuery;
import org.seasar.dbflute.cbean.sqlclause.SqlClause;

import com.example.dbflute.cdi.dbflute.cbean.PurchaseCB;
import com.example.dbflute.cdi.dbflute.cbean.cq.bs.BsMemberCQ;

/**
 * The condition-query of MEMBER.
 * <p>
 * You can implement your original methods here.
 * This class remains when re-generating.
 * </p>
 * @author DBFlute(AutoGenerator)
 */
public class MemberCQ extends BsMemberCQ {

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    // You should NOT touch with this constructor.
    /**
     * Constructor.
     * @param referrerQuery The instance of referrer query. (NullAllowed: If null, this is base query)
     * @param sqlClause The instance of SQL clause. (NotNull)
     * @param aliasName The alias name for this query. (NotNull)
     * @param nestLevel The nest level of this query. (If zero, this is base query)
     */
    public MemberCQ(final ConditionQuery referrerQuery, final SqlClause sqlClause, final String aliasName,
            final int nestLevel) {
        super(referrerQuery, sqlClause, aliasName, nestLevel);
    }

    // ===================================================================================
    //                                                                       Arrange Query
    //                                                                       =============
    // You can make your arranged query methods here.
    //public void arrangeXxx() {
    //    ...
    //}
    /**
     * Arrange the query for selecting service members.
     * o starts 'S'
     * o status 'Formalized'
     * o exists the special product
     */
    public void arrangeServiceMember() {
        final Integer specialProductId = 3;
        this.setMemberName_PrefixSearch("S");
        this.setMemberStatusCode_Equal_正式会員();
        this.existsPurchaseList(new SubQuery<PurchaseCB>() {
            public void query(final PurchaseCB subCB) {
                subCB.query().setProductId_Equal(specialProductId);
            }
        });
    }
}
