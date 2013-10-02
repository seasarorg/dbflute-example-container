package com.example.dbflute.spring.dbflute.whitebox.cbean;

import org.seasar.dbflute.cbean.ListResultBean;
import org.seasar.dbflute.cbean.OrQuery;
import org.seasar.dbflute.cbean.ScalarQuery;
import org.seasar.dbflute.cbean.SubQuery;
import org.seasar.dbflute.cbean.coption.DerivedReferrerOption;
import org.seasar.dbflute.util.DfTypeUtil;
import org.seasar.dbflute.util.Srl;

import com.example.dbflute.spring.dbflute.cbean.MemberCB;
import com.example.dbflute.spring.dbflute.cbean.MemberLoginCB;
import com.example.dbflute.spring.dbflute.cbean.MemberStatusCB;
import com.example.dbflute.spring.dbflute.cbean.PurchaseCB;
import com.example.dbflute.spring.dbflute.exbhv.MemberStatusBhv;
import com.example.dbflute.spring.dbflute.exentity.MemberStatus;
import com.example.dbflute.spring.unit.UnitContainerTestCase;

/**
 * @author jflute
 * @since 0.9.7.7 (2010/12/04 Saturday)
 */
public class WxCBDerivedReferrerNestedTest extends UnitContainerTestCase {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    //private MemberBhv memberBhv;
    private MemberStatusBhv memberStatusBhv;

    // ===================================================================================
    //                                                                               Basic
    //                                                                               =====
    public void test_sepcify_derivedReferrer_OneToManyToMany_max_basic() {
        // ## Arrange ##
        Integer formalizedMax = memberStatusBhv.scalarSelect(Integer.class).max(new ScalarQuery<MemberStatusCB>() {
            public void query(MemberStatusCB cb) {
                cb.specify().derivedMemberList().max(new SubQuery<MemberCB>() {
                    public void query(MemberCB subCB) {
                        subCB.specify().derivedPurchaseList().max(new SubQuery<PurchaseCB>() {
                            public void query(PurchaseCB subCB) {
                                subCB.specify().columnPurchasePrice();
                                subCB.query().setPaymentCompleteFlg_Equal_True();
                            }
                        }, null);
                        subCB.query().setBirthdate_LessThan(currentDate());
                    }
                }, null);
                cb.query().setMemberStatusCode_Equal_Formalized();
            }
        });
        Integer provisinalMax = memberStatusBhv.scalarSelect(Integer.class).max(new ScalarQuery<MemberStatusCB>() {
            public void query(MemberStatusCB cb) {
                cb.specify().derivedMemberList().max(new SubQuery<MemberCB>() {
                    public void query(MemberCB subCB) {
                        subCB.specify().derivedPurchaseList().max(new SubQuery<PurchaseCB>() {
                            public void query(PurchaseCB subCB) {
                                subCB.specify().columnPurchasePrice();
                                subCB.query().setPaymentCompleteFlg_Equal_True();
                            }
                        }, null);
                        subCB.query().setBirthdate_LessThan(currentDate());
                    }
                }, null);
                cb.query().setMemberStatusCode_Equal_Provisional();
            }
        });
        Integer withdrawalMax = memberStatusBhv.scalarSelect(Integer.class).max(new ScalarQuery<MemberStatusCB>() {
            public void query(MemberStatusCB cb) {
                cb.specify().derivedMemberList().max(new SubQuery<MemberCB>() {
                    public void query(MemberCB subCB) {
                        subCB.specify().derivedPurchaseList().max(new SubQuery<PurchaseCB>() {
                            public void query(PurchaseCB subCB) {
                                subCB.specify().columnPurchasePrice();
                                subCB.query().setPaymentCompleteFlg_Equal_True();
                            }
                        }, null);
                        subCB.query().setBirthdate_LessThan(DfTypeUtil.toDate("2010-12-04"));
                    }
                }, null);
                cb.query().setMemberStatusCode_Equal_Withdrawal();
            }
        });

        MemberStatusCB cb = new MemberStatusCB();
        cb.specify().derivedMemberList().max(new SubQuery<MemberCB>() {
            public void query(MemberCB subCB) {
                subCB.specify().derivedPurchaseList().max(new SubQuery<PurchaseCB>() {
                    public void query(PurchaseCB subCB) {
                        subCB.specify().columnPurchasePrice();
                        subCB.query().setPaymentCompleteFlg_Equal_True();
                    }
                }, null);
                subCB.query().setBirthdate_LessThan(currentDate());
            }
        }, MemberStatus.ALIAS_maxPurchasePrice);
        cb.orScopeQuery(new OrQuery<MemberStatusCB>() {
            public void query(MemberStatusCB orCB) {
                orCB.query().setMemberStatusCode_Equal_Formalized();
                orCB.query().setMemberStatusCode_Equal_Withdrawal();
                orCB.query().setMemberStatusCode_Equal_Provisional();
            }
        });

        // ## Act ##
        ListResultBean<MemberStatus> statusList = memberStatusBhv.selectList(cb);

        // ## Assert ##
        assertNotSame(0, statusList.size());
        for (MemberStatus status : statusList) {
            Integer maxPurchasePrice = status.getMaxPurchasePrice();
            log(status.getMemberStatusName() + ", " + maxPurchasePrice);
            if (status.isMemberStatusCodeFormalized()) {
                assertEquals(formalizedMax, maxPurchasePrice);
            } else if (status.isMemberStatusCodeProvisional()) {
                assertEquals(provisinalMax, maxPurchasePrice);
            } else if (status.isMemberStatusCodeWithdrawal()) {
                assertEquals(withdrawalMax, maxPurchasePrice);
            }
        }
    }

    public void test_sepcify_derivedReferrer_OneToManyToMany_moreNested_basic() {
        // ## Arrange ##
        MemberStatusCB cb = new MemberStatusCB();
        cb.specify().derivedMemberList().max(new SubQuery<MemberCB>() {
            public void query(MemberCB subCB) {
                subCB.specify().derivedPurchaseList().max(new SubQuery<PurchaseCB>() {
                    public void query(PurchaseCB subCB) {
                        subCB.specify().specifyMember().derivedMemberLoginList().max(new SubQuery<MemberLoginCB>() {
                            public void query(MemberLoginCB subCB) {
                                subCB.specify().columnMemberId();
                                subCB.query().setMobileLoginFlg_Equal_False();
                            }
                        }, null);
                        subCB.query().setPaymentCompleteFlg_Equal_True();
                    }
                }, null);
                subCB.query().setBirthdate_LessThan(DfTypeUtil.toDate("2010-12-04"));
            }
        }, MemberStatus.ALIAS_maxPurchasePrice);
        cb.orScopeQuery(new OrQuery<MemberStatusCB>() {
            public void query(MemberStatusCB orCB) {
                orCB.query().setMemberStatusCode_Equal_Formalized();
                orCB.query().setMemberStatusCode_Equal_Withdrawal();
                orCB.query().setMemberStatusCode_Equal_Provisional();
            }
        });

        // ## Act ##
        ListResultBean<MemberStatus> statusList = memberStatusBhv.selectList(cb); // expect no exception

        // ## Assert ##
        assertNotSame(0, statusList.size());
        for (MemberStatus status : statusList) {
            Integer maxPurchasePrice = status.getMaxPurchasePrice();
            log(status.getMemberStatusName() + ", " + maxPurchasePrice);
        }
        String sql = cb.toDisplaySql();
        assertTrue(Srl.contains(sql, "(select max((select max((select max(sub3loc.MEMBER_ID)"));
        assertTrue(Srl.contains(sql, "and sub3loc.MOBILE_LOGIN_FLG = 0"));
        assertTrue(Srl.contains(sql, "and sub2loc.PAYMENT_COMPLETE_FLG = 1"));
        assertTrue(Srl.contains(sql, "sub1loc.BIRTHDATE < '2010-12-04'"));
    }

    public void test_sepcify_derivedReferrer_OneToManyToMany_moreNested_option() {
        // ## Arrange ##
        MemberStatusCB cb = new MemberStatusCB();
        cb.specify().derivedMemberList().max(new SubQuery<MemberCB>() {
            public void query(MemberCB subCB) {
                subCB.specify().derivedPurchaseList().max(new SubQuery<PurchaseCB>() {
                    public void query(PurchaseCB subCB) {
                        subCB.specify().specifyMember().derivedMemberLoginList().max(new SubQuery<MemberLoginCB>() {
                            public void query(MemberLoginCB subCB) {
                                subCB.specify().columnMemberId();
                                subCB.query().setMobileLoginFlg_Equal_False();
                            }
                        }, null);
                        subCB.query().setPaymentCompleteFlg_Equal_True();
                    }
                }, null, new DerivedReferrerOption().coalesce(0));
                subCB.query().setBirthdate_LessThan(DfTypeUtil.toDate("2010-12-04"));
            }
        }, MemberStatus.ALIAS_maxPurchasePrice);
        cb.orScopeQuery(new OrQuery<MemberStatusCB>() {
            public void query(MemberStatusCB orCB) {
                orCB.query().setMemberStatusCode_Equal_Formalized();
                orCB.query().setMemberStatusCode_Equal_Withdrawal();
                orCB.query().setMemberStatusCode_Equal_Provisional();
            }
        });

        // ## Act ##
        ListResultBean<MemberStatus> statusList = memberStatusBhv.selectList(cb); // expect no exception

        // ## Assert ##
        assertNotSame(0, statusList.size());
        for (MemberStatus status : statusList) {
            Integer maxPurchasePrice = status.getMaxPurchasePrice();
            log(status.getMemberStatusName() + ", " + maxPurchasePrice);
        }
        String sql = cb.toDisplaySql();
        assertTrue(Srl.contains(sql, "select max((select coalesce(max((select max(sub3loc.MEMBER_ID)"));
        assertTrue(Srl.contains(sql, "and sub3loc.MOBILE_LOGIN_FLG = 0"));
        assertTrue(Srl.contains(sql, "and sub2loc.PAYMENT_COMPLETE_FLG = 1"));
        assertTrue(Srl.contains(sql, "sub1loc.BIRTHDATE < '2010-12-04'"));
    }

    // ===================================================================================
    //                                                         with (Query)DerivedReferrer
    //                                                         ===========================
    public void test_sepcify_derivedReferrer_OneToManyToMany_with_QueryDerivedReferrer_basic() {
        // ## Arrange ##
        MemberStatusCB cb = new MemberStatusCB();
        cb.specify().derivedMemberList().max(new SubQuery<MemberCB>() {
            public void query(MemberCB subCB) {
                subCB.specify().derivedPurchaseList().max(new SubQuery<PurchaseCB>() {
                    public void query(PurchaseCB subCB) {
                        subCB.specify().columnPurchasePrice();
                        subCB.query().setPaymentCompleteFlg_Equal_True();
                        subCB.query().queryProduct().derivedPurchaseList().max(new SubQuery<PurchaseCB>() {
                            public void query(PurchaseCB subCB) {
                                subCB.specify().columnPurchasePrice();
                                subCB.query().setPurchaseId_GreaterThan(-1L);
                            }
                        }).greaterThan(300);
                    }
                }, null);
                subCB.query().setBirthdate_LessThan(DfTypeUtil.toDate("2010-12-04"));
                subCB.query().derivedPurchaseList().avg(new SubQuery<PurchaseCB>() {
                    public void query(PurchaseCB subCB) {
                        subCB.specify().columnPurchasePrice();
                    }
                }).lessEqual(2000);
            }
        }, MemberStatus.ALIAS_maxPurchasePrice);
        cb.orScopeQuery(new OrQuery<MemberStatusCB>() {
            public void query(MemberStatusCB orCB) {
                orCB.query().setMemberStatusCode_Equal_Formalized();
                orCB.query().setMemberStatusCode_Equal_Withdrawal();
                orCB.query().setMemberStatusCode_Equal_Provisional();
            }
        });

        // ## Act ##
        ListResultBean<MemberStatus> statusList = memberStatusBhv.selectList(cb);

        // ## Assert ##
        assertNotSame(0, statusList.size());
        for (MemberStatus status : statusList) {
            Integer maxPurchasePrice = status.getMaxPurchasePrice();
            log(status.getMemberStatusName() + ", " + maxPurchasePrice);
        }
        String sql = cb.toDisplaySql();
        assertTrue(Srl.contains(sql, "sub3loc.PURCHASE_ID > -1"));
        assertTrue(Srl.contains(sql, ") > 300"));
        assertTrue(Srl.contains(sql, "sub1loc.BIRTHDATE < '2010-12-04'"));
        assertTrue(Srl.contains(sql, " <= 2000"));
    }
}
