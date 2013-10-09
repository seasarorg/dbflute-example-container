/*
 * Copyright(c) DBFlute TestCo.,TestLtd. All Rights Reserved.
 */
package com.example.dbflute.cdi.dbflute.cbean.cq.ciq;

import java.util.Map;
import org.seasar.dbflute.cbean.*;
import org.seasar.dbflute.cbean.ckey.*;
import org.seasar.dbflute.cbean.coption.ConditionOption;
import org.seasar.dbflute.cbean.cvalue.ConditionValue;
import org.seasar.dbflute.cbean.sqlclause.SqlClause;
import org.seasar.dbflute.exception.IllegalConditionBeanOperationException;
import com.example.dbflute.cdi.dbflute.cbean.*;
import com.example.dbflute.cdi.dbflute.cbean.cq.bs.*;
import com.example.dbflute.cdi.dbflute.cbean.cq.*;

/**
 * The condition-query for in-line of SUMMARY_WITHDRAWAL.
 * @author DBFlute(AutoGenerator)
 */
public class SummaryWithdrawalCIQ extends AbstractBsSummaryWithdrawalCQ {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected BsSummaryWithdrawalCQ _myCQ;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public SummaryWithdrawalCIQ(ConditionQuery childQuery, SqlClause sqlClause
                        , String aliasName, int nestLevel, BsSummaryWithdrawalCQ myCQ) {
        super(childQuery, sqlClause, aliasName, nestLevel);
        _myCQ = myCQ;
        _foreignPropertyName = _myCQ.xgetForeignPropertyName(); // accept foreign property name
        _relationPath = _myCQ.xgetRelationPath(); // accept relation path
        _inline = true;
    }

    // ===================================================================================
    //                                                             Override about Register
    //                                                             =======================
    @Override
    protected void reflectRelationOnUnionQuery(ConditionQuery bq, ConditionQuery uq) {
        String msg = "InlineView must not need UNION method: " + bq + " : " + uq;
        throw new IllegalConditionBeanOperationException(msg);
    }

    @Override
    protected void setupConditionValueAndRegisterWhereClause(ConditionKey k, Object v, ConditionValue cv, String col) {
        regIQ(k, v, cv, col);
    }

    @Override
    protected void setupConditionValueAndRegisterWhereClause(ConditionKey k, Object v, ConditionValue cv, String col, ConditionOption op) {
        regIQ(k, v, cv, col, op);
    }

    @Override
    protected void registerWhereClause(String wc) {
        registerInlineWhereClause(wc);
    }

    @Override
    protected boolean isInScopeRelationSuppressLocalAliasName() {
        if (_onClause) {
            throw new IllegalConditionBeanOperationException("InScopeRelation on OnClause is unsupported.");
        }
        return true;
    }

    // ===================================================================================
    //                                                                Override about Query
    //                                                                ====================
    protected ConditionValue getCValueMemberId() { return _myCQ.getMemberId(); }
    protected ConditionValue getCValueMemberName() { return _myCQ.getMemberName(); }
    protected ConditionValue getCValueWithdrawalReasonCode() { return _myCQ.getWithdrawalReasonCode(); }
    protected ConditionValue getCValueWithdrawalReasonText() { return _myCQ.getWithdrawalReasonText(); }
    protected ConditionValue getCValueWithdrawalReasonInputText() { return _myCQ.getWithdrawalReasonInputText(); }
    protected ConditionValue getCValueWithdrawalDatetime() { return _myCQ.getWithdrawalDatetime(); }
    protected ConditionValue getCValueMemberStatusCode() { return _myCQ.getMemberStatusCode(); }
    protected ConditionValue getCValueMemberStatusName() { return _myCQ.getMemberStatusName(); }
    protected ConditionValue getCValueMaxPurchasePrice() { return _myCQ.getMaxPurchasePrice(); }
    protected Map<String, Object> xfindFixedConditionDynamicParameterMap(String property) { return null; }

    protected void throwIICBOE(String name) { // throwInlineIllegalConditionBeanOperationException()
        throw new IllegalConditionBeanOperationException(name + " at InlineView is unsupported.");
    }

    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xinCB() { return SummaryWithdrawalCB.class.getName(); }
    protected String xinCQ() { return SummaryWithdrawalCQ.class.getName(); }
}
