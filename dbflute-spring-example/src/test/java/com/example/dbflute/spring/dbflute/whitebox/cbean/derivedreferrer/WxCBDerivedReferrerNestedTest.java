package com.example.dbflute.spring.dbflute.whitebox.cbean.derivedreferrer;

import org.seasar.dbflute.cbean.ListResultBean;
import org.seasar.dbflute.cbean.OrQuery;
import org.seasar.dbflute.cbean.ScalarQuery;
import org.seasar.dbflute.cbean.SubQuery;
import org.seasar.dbflute.cbean.UnionQuery;
import org.seasar.dbflute.cbean.coption.DerivedReferrerOption;
import org.seasar.dbflute.util.DfTypeUtil;
import org.seasar.dbflute.util.Srl;

import com.example.dbflute.spring.dbflute.cbean.MemberCB;
import com.example.dbflute.spring.dbflute.cbean.MemberLoginCB;
import com.example.dbflute.spring.dbflute.cbean.MemberStatusCB;
import com.example.dbflute.spring.dbflute.cbean.PurchaseCB;
import com.example.dbflute.spring.dbflute.cbean.PurchasePaymentCB;
import com.example.dbflute.spring.dbflute.exbhv.MemberBhv;
import com.example.dbflute.spring.dbflute.exbhv.MemberStatusBhv;
import com.example.dbflute.spring.dbflute.exentity.Member;
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
    private MemberBhv memberBhv;
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
    //                                                                          with Union
    //                                                                          ==========
    public void test_sepcify_derivedReferrer_OneToManyToMany_nested_after_union() {
        // ## Arrange ##
        MemberStatusCB cb = new MemberStatusCB();
        cb.specify().derivedMemberList().max(new SubQuery<MemberCB>() {
            public void query(MemberCB subCB) {
                subCB.specify().derivedPurchaseList().max(new SubQuery<PurchaseCB>() {
                    public void query(PurchaseCB subCB) {
                        subCB.specify().columnPurchasePrice();
                        subCB.query().setPaymentCompleteFlg_Equal_True();
                    }
                }, null, new DerivedReferrerOption());
                subCB.query().setBirthdate_LessThan(DfTypeUtil.toDate("2010-12-04"));
                subCB.union(new UnionQuery<MemberCB>() {
                    public void query(MemberCB unionCB) {
                    }
                });
            }
        }, MemberStatus.ALIAS_maxPurchasePrice);

        // ## Act ##
        memberStatusBhv.selectList(cb); // expect no exception

        // ## Assert ##
        String sql = cb.toDisplaySql();
        assertTrue(sql.contains("where sub2loc.MEMBER_ID = sub1main.MEMBER_ID"));
        assertTrue(sql.contains("  and sub2loc.PAYMENT_COMPLETE_FLG = 1"));
        assertTrue(sql.contains("from (select sub1loc.MEMBER_ID, sub1loc.MEMBER_STATUS_CODE"));
        assertTrue(sql.contains("union"));
        assertTrue(sql.contains(") sub1main"));
        assertTrue(sql.contains("where sub1main.MEMBER_STATUS_CODE = dfloc.MEMBER_STATUS_CODE"));
    }

    public void test_sepcify_derivedReferrer_OneToManyToMany_nestedAfterUnion_and_union() {
        // ## Arrange ##
        MemberStatusCB cb = new MemberStatusCB();
        cb.specify().derivedMemberList().max(new SubQuery<MemberCB>() {
            public void query(MemberCB subCB) {
                subCB.specify().derivedPurchaseList().max(new SubQuery<PurchaseCB>() {
                    public void query(PurchaseCB subCB) {
                        subCB.specify().columnPurchasePrice();
                        subCB.query().setPaymentCompleteFlg_Equal_True();
                        subCB.union(new UnionQuery<PurchaseCB>() {
                            public void query(PurchaseCB unionCB) {
                                unionCB.query().setPurchasePrice_GreaterThan(2000);
                            }
                        });
                    }
                }, null, new DerivedReferrerOption());
                subCB.query().setBirthdate_LessThan(DfTypeUtil.toDate("2010-12-04"));
                subCB.union(new UnionQuery<MemberCB>() {
                    public void query(MemberCB unionCB) {
                    }
                });
            }
        }, MemberStatus.ALIAS_maxPurchasePrice);

        // ## Act ##
        memberStatusBhv.selectList(cb); // expect no exception

        // ## Assert ##
        String sql = cb.toDisplaySql();
        assertTrue(sql.contains("(select max((select max(sub2main.PURCHASE_PRICE)"));
        assertTrue(sql.contains("where sub2loc.PAYMENT_COMPLETE_FLG = 1"));
        assertTrue(sql.contains("where sub2loc.PURCHASE_PRICE > 2000"));
        assertTrue(sql.contains("where sub2main.MEMBER_ID = sub1main.MEMBER_ID"));
        assertTrue(sql.contains("from (select sub1loc.MEMBER_ID, sub1loc.MEMBER_STATUS_CODE"));
        assertTrue(sql.contains("union"));
        assertTrue(sql.contains(") sub1main"));
        assertTrue(sql.contains("where sub1main.MEMBER_STATUS_CODE = dfloc.MEMBER_STATUS_CODE"));
    }

    public void test_sepcify_derivedReferrer_OneToManyToMany_nestedAfterUnion_and_more_nestedAfterUnion() {
        // ## Arrange ##
        MemberStatusCB cb = new MemberStatusCB();
        cb.specify().derivedMemberList().max(new SubQuery<MemberCB>() {
            public void query(MemberCB subCB) {
                subCB.specify().derivedPurchaseList().max(new SubQuery<PurchaseCB>() {
                    public void query(PurchaseCB subCB) {
                        subCB.specify().derivedPurchasePaymentList().max(new SubQuery<PurchasePaymentCB>() {
                            public void query(PurchasePaymentCB subCB) {
                                subCB.specify().columnPaymentAmount();
                            }
                        }, null);
                        subCB.query().setPaymentCompleteFlg_Equal_True();
                        subCB.union(new UnionQuery<PurchaseCB>() {
                            public void query(PurchaseCB unionCB) {
                                unionCB.query().setPurchasePrice_GreaterThan(2000);
                            }
                        });
                    }
                }, null, new DerivedReferrerOption());
                subCB.query().setBirthdate_LessThan(DfTypeUtil.toDate("2010-12-04"));
                subCB.union(new UnionQuery<MemberCB>() {
                    public void query(MemberCB unionCB) {
                    }
                });
            }
        }, MemberStatus.ALIAS_maxPurchasePrice);

        // ## Act ##
        memberStatusBhv.selectList(cb); // expect no exception

        // ## Assert ##
        String sql = cb.toDisplaySql();
        assertTrue(sql.contains("(select max((select max((select max(sub3loc.PAYMENT_AMOUNT)"));
        assertTrue(sql.contains("where sub3loc.PURCHASE_ID = sub2main.PURCHASE_ID"));
        assertTrue(sql.contains("where sub2loc.PAYMENT_COMPLETE_FLG = 1"));
        assertTrue(sql.contains("where sub2loc.PURCHASE_PRICE > 2000"));
        assertTrue(sql.contains("where sub2main.MEMBER_ID = sub1main.MEMBER_ID"));
        assertTrue(sql.contains("from (select sub1loc.MEMBER_ID, sub1loc.MEMBER_STATUS_CODE"));
        assertTrue(sql.contains("union"));
        assertTrue(sql.contains(") sub1main"));
        assertTrue(sql.contains("where sub1main.MEMBER_STATUS_CODE = dfloc.MEMBER_STATUS_CODE"));
    }

    public void test_sepcify_derivedReferrer_OneToManyToMany_union_monkey() throws Exception {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.specify().derivedMemberLoginList().max(new SubQuery<MemberLoginCB>() {
            public void query(MemberLoginCB subCB) {
                subCB.specify().columnLoginDatetime();
                subCB.query().setMobileLoginFlg_Equal_False();
                subCB.union(new UnionQuery<MemberLoginCB>() {
                    public void query(MemberLoginCB unionCB) {
                        unionCB.query().setLoginMemberStatusCode_Equal_Formalized();
                    }
                });
            }
        }, Member.ALIAS_latestLoginDatetime);
        cb.specify().derivedPurchaseList().max(new SubQuery<PurchaseCB>() {
            public void query(PurchaseCB subCB) {
                subCB.specify().derivedPurchasePaymentList().max(new SubQuery<PurchasePaymentCB>() {
                    public void query(PurchasePaymentCB subCB) {
                        subCB.specify().columnPaymentAmount();
                    }
                }, null);
                subCB.union(new UnionQuery<PurchaseCB>() {
                    public void query(PurchaseCB unionCB) {
                    }
                });
            }
        }, Member.ALIAS_loginCount);

        // ## Act ##
        memberBhv.selectList(cb); // expect no exception

        // ## Assert ##
        // select dfloc.MEMBER_ID as MEMBER_ID, dfloc.MEMBER_NAME as MEMBER_NAME, dfloc.MEMBER_ACCOUNT as MEMBER_ACCOUNT, dfloc.MEMBER_STATUS_CODE as MEMBER_STATUS_CODE, dfloc.FORMALIZED_DATETIME as FORMALIZED_DATETIME, dfloc.BIRTHDATE as BIRTHDATE, dfloc.REGISTER_DATETIME as REGISTER_DATETIME, dfloc.REGISTER_USER as REGISTER_USER, dfloc.UPDATE_DATETIME as UPDATE_DATETIME, dfloc.UPDATE_USER as UPDATE_USER, dfloc.VERSION_NO as VERSION_NO
        //      , (select max(sub1main.LOGIN_DATETIME)
        //          from (select sub1loc.MEMBER_LOGIN_ID, sub1loc.MEMBER_ID, sub1loc.LOGIN_DATETIME
        //                  from MEMBER_LOGIN sub1loc
        //                 where sub1loc.MOBILE_LOGIN_FLG = 0
        //                 union 
        //                select sub1loc.MEMBER_LOGIN_ID, sub1loc.MEMBER_ID, sub1loc.LOGIN_DATETIME 
        //                  from MEMBER_LOGIN sub1loc 
        //                 where sub1loc.LOGIN_MEMBER_STATUS_CODE = 'FML'
        //               ) sub1main
        //         where sub1main.MEMBER_ID = dfloc.MEMBER_ID
        //       ) as LATEST_LOGIN_DATETIME
        //      , (select max((select max(sub2loc.PAYMENT_AMOUNT)
        //                       from PURCHASE_PAYMENT sub2loc 
        //                      where sub2loc.PURCHASE_ID = sub1main.PURCHASE_ID
        //                ))
        //           from (select sub1loc.PURCHASE_ID, sub1loc.MEMBER_ID
        //                   from PURCHASE sub1loc
        //                  union 
        //                 select sub1loc.PURCHASE_ID, sub1loc.MEMBER_ID 
        //                   from PURCHASE sub1loc 
        //                ) sub1main
        //          where sub1main.MEMBER_ID = dfloc.MEMBER_ID
        //        ) as LOGIN_COUNT
        //   from MEMBER dfloc
        String sql = cb.toDisplaySql();
        assertTrue(sql.contains(", (select max(sub1main.LOGIN_DATETIME)"));
        assertTrue(sql.contains("from (select sub1loc.MEMBER_LOGIN_ID, sub1loc.MEMBER_ID, sub1loc.LOGIN_DATETIME"));
        assertTrue(sql.contains("where sub1loc.MOBILE_LOGIN_FLG = 0"));
        assertTrue(sql.contains("where sub1loc.LOGIN_MEMBER_STATUS_CODE = 'FML'"));
        assertTrue(sql.contains("where sub1main.MEMBER_ID = dfloc.MEMBER_ID"));
        assertTrue(sql.contains(", (select max((select max(sub2loc.PAYMENT_AMOUNT)"));
        assertTrue(sql.contains("where sub2loc.PURCHASE_ID = sub1main.PURCHASE_ID"));
        assertTrue(sql.contains("from (select sub1loc.PURCHASE_ID, sub1loc.MEMBER_ID"));
        assertTrue(sql.contains("where sub1main.MEMBER_ID = dfloc.MEMBER_ID"));
    }

    // *nested with fixed-condition is at WxBizManyToOneVariantRelationTest

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
