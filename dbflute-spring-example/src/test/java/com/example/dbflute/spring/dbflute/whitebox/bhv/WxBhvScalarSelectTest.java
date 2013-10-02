package com.example.dbflute.spring.dbflute.whitebox.bhv;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.seasar.dbflute.CallbackContext;
import org.seasar.dbflute.cbean.ListResultBean;
import org.seasar.dbflute.cbean.OrQuery;
import org.seasar.dbflute.cbean.ScalarQuery;
import org.seasar.dbflute.cbean.SubQuery;
import org.seasar.dbflute.cbean.UnionQuery;
import org.seasar.dbflute.cbean.coption.DerivedReferrerOption;
import org.seasar.dbflute.cbean.coption.ScalarSelectOption;
import org.seasar.dbflute.exception.SpecifyColumnTwoOrMoreColumnException;
import org.seasar.dbflute.exception.SpecifyColumnWithDerivedReferrerException;
import org.seasar.dbflute.exception.SpecifyDerivedReferrerTwoOrMoreException;
import org.seasar.dbflute.exception.SpecifyRelationIllegalPurposeException;
import org.seasar.dbflute.jdbc.SqlLogHandler;
import org.seasar.dbflute.jdbc.SqlLogInfo;
import org.seasar.dbflute.util.DfTypeUtil;
import org.seasar.dbflute.util.Srl;

import com.example.dbflute.spring.dbflute.bsentity.dbmeta.MemberServiceDbm;
import com.example.dbflute.spring.dbflute.bsentity.dbmeta.SummaryWithdrawalDbm;
import com.example.dbflute.spring.dbflute.cbean.MemberCB;
import com.example.dbflute.spring.dbflute.cbean.MemberServiceCB;
import com.example.dbflute.spring.dbflute.cbean.PurchaseCB;
import com.example.dbflute.spring.dbflute.cbean.SummaryWithdrawalCB;
import com.example.dbflute.spring.dbflute.exbhv.MemberBhv;
import com.example.dbflute.spring.dbflute.exbhv.MemberServiceBhv;
import com.example.dbflute.spring.dbflute.exbhv.SummaryWithdrawalBhv;
import com.example.dbflute.spring.dbflute.exentity.Member;
import com.example.dbflute.spring.unit.UnitContainerTestCase;

/**
 * @author jflute
 * @since 0.6.0 (2008/01/16 Wednesday)
 */
public class WxBhvScalarSelectTest extends UnitContainerTestCase {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private MemberBhv memberBhv;
    private MemberServiceBhv memberServiceBhv;
    private SummaryWithdrawalBhv summaryWithdrawalBhv;

    // ===================================================================================
    //                                                                               Basic
    //                                                                               =====
    public void test_ScalarSelect_max() {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.specify().columnBirthdate();
        cb.query().setMemberStatusCode_Equal_Formalized();
        cb.query().setBirthdate_IsNotNull();
        cb.query().addOrderBy_Birthdate_Desc();
        cb.fetchFirst(1);
        Date expected = memberBhv.selectEntityWithDeletedCheck(cb).getBirthdate();

        // ## Act ##
        Date birthdate = memberBhv.scalarSelect(Date.class).max(new ScalarQuery<MemberCB>() {
            public void query(MemberCB cb) {
                cb.specify().columnBirthdate(); // *Point!
                cb.query().setMemberStatusCode_Equal_Formalized();
            }
        });

        // ## Assert ##
        assertEquals(expected, birthdate);
    }

    // ===================================================================================
    //                                                                      (Unique) Count
    //                                                                      ==============
    public void test_ScalarSelect_count() {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        int countAll = memberBhv.selectCount(cb);

        // ## Act ##
        Integer scalarCount = memberBhv.scalarSelect(Integer.class).count(new ScalarQuery<MemberCB>() {
            public void query(MemberCB cb) {
                cb.specify().columnMemberId();
            }
        });

        // ## Assert ##
        assertEquals(countAll, scalarCount);
    }

    // ===================================================================================
    //                                                                      Count Distinct
    //                                                                      ==============
    public void test_ScalarSelect_countDistinct_basic() {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        ListResultBean<Member> memberList = memberBhv.selectList(cb);
        HashSet<String> statusSet = new HashSet<String>();
        for (Member member : memberList) {
            statusSet.add(member.getMemberStatusCode());
        }

        // ## Act ##
        Integer kindCount = memberBhv.scalarSelect(Integer.class).countDistinct(new ScalarQuery<MemberCB>() {
            public void query(MemberCB cb) {
                cb.specify().columnMemberStatusCode();
            }
        });

        // ## Assert ##
        assertEquals(statusSet.size(), kindCount);
    }

    public void test_ScalarSelect_countDistinct_noHist() {
        // ## Arrange ##

        // ## Act ##
        Integer kindCount = memberBhv.scalarSelect(Integer.class).countDistinct(new ScalarQuery<MemberCB>() {
            public void query(MemberCB cb) {
                cb.specify().columnMemberStatusCode();
                cb.query().setMemberName_Equal("no exist");
            }
        });

        // ## Assert ##
        assertEquals(0, kindCount);
    }

    // ===================================================================================
    //                                                                     DerivedReferrer
    //                                                                     ===============
    public void test_ScalarSelect_DerivedReferrer_basic() {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.specify().derivedPurchaseList().max(new SubQuery<PurchaseCB>() {
            public void query(PurchaseCB subCB) {
                subCB.specify().columnPurchasePrice();
                subCB.query().setPaymentCompleteFlg_Equal_True();
                subCB.query().setPurchasePrice_GreaterEqual(800);
            }
        }, Member.ALIAS_productKindCount, new DerivedReferrerOption().coalesce(0));
        cb.query().setMemberStatusCode_Equal_Formalized();
        ListResultBean<Member> memberList = memberBhv.selectList(cb);
        Integer expected = 0;
        for (Member member : memberList) {
            Integer max = member.getProductKindCount();
            log(member.getMemberName() + " = " + max);
            expected = expected + member.getProductKindCount();
        }

        // ## Act ##
        Integer sum = memberBhv.scalarSelect(Integer.class).sum(new ScalarQuery<MemberCB>() {
            public void query(MemberCB cb) {
                cb.specify().derivedPurchaseList().max(new SubQuery<PurchaseCB>() {
                    public void query(PurchaseCB subCB) {
                        subCB.specify().columnPurchasePrice();
                        subCB.query().setPaymentCompleteFlg_Equal_True();
                        subCB.query().setPurchasePrice_GreaterEqual(800);
                    }
                }, null);
                cb.query().setMemberStatusCode_Equal_Formalized();
            }
        });

        // ## Assert ##
        log("sum = " + sum);
        assertEquals(expected, sum);
    }

    public void test_ScalarSelect_DerivedReferrer_with_UnionQuery() {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.specify().derivedPurchaseList().max(new SubQuery<PurchaseCB>() {
            public void query(PurchaseCB subCB) {
                subCB.specify().columnPurchasePrice();
                subCB.query().setPaymentCompleteFlg_Equal_True();
                subCB.query().setPurchasePrice_GreaterEqual(800);
            }
        }, Member.ALIAS_productKindCount, new DerivedReferrerOption().coalesce(0));
        cb.orScopeQuery(new OrQuery<MemberCB>() {
            public void query(MemberCB orCB) {
                orCB.query().setMemberStatusCode_Equal_Withdrawal();
                orCB.query().setMemberName_PrefixSearch("S");
            }
        });
        ListResultBean<Member> memberList = memberBhv.selectList(cb);
        Integer expected = 0;
        for (Member member : memberList) {
            Integer max = member.getProductKindCount();
            log(member.getMemberName() + " = " + max);
            expected = expected + member.getProductKindCount();
        }

        // ## Act ##
        Integer sum = memberBhv.scalarSelect(Integer.class).sum(new ScalarQuery<MemberCB>() {
            public void query(MemberCB cb) {
                cb.specify().derivedPurchaseList().max(new SubQuery<PurchaseCB>() {
                    public void query(PurchaseCB subCB) {
                        subCB.specify().columnPurchasePrice();
                        subCB.query().setPaymentCompleteFlg_Equal_True();
                        subCB.query().setPurchasePrice_GreaterEqual(800);
                    }
                }, null);
                cb.query().setMemberStatusCode_Equal_Withdrawal();
                cb.union(new UnionQuery<MemberCB>() {
                    public void query(MemberCB unionCB) {
                        unionCB.query().setMemberName_PrefixSearch("S");
                    }
                });
            }
        });

        // ## Assert ##
        log("sum = " + sum);
    }

    // ===================================================================================
    //                                                                          UnionQuery
    //                                                                          ==========
    public void test_ScalarSelect_with_UnionQuery_basic_sum() {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.setupSelect_MemberServiceAsOne();
        ListResultBean<Member> memberList = memberBhv.selectList(cb);
        Integer expected = 0;
        for (Member member : memberList) {
            Integer pointCount = member.getMemberServiceAsOne().getServicePointCount();
            log("pointCount = " + pointCount);
            expected = expected + pointCount;
        }
        final Set<String> markSet = new HashSet<String>();
        CallbackContext.setSqlLogHandlerOnThread(new SqlLogHandler() {
            public void handle(SqlLogInfo info) {
                MemberServiceDbm dbm = MemberServiceDbm.getInstance();
                String displaySql = info.getDisplaySql();
                assertTrue(Srl.contains(displaySql, dbm.columnMemberServiceId().getColumnDbName()));
                assertTrue(Srl.contains(displaySql, dbm.columnServicePointCount().getColumnDbName()));
                assertFalse(Srl.contains(displaySql, dbm.columnServiceRankCode().getColumnDbName()));
                markSet.add("handle");
            }
        });

        // ## Act ##
        try {
            Integer sum = memberServiceBhv.scalarSelect(Integer.class).sum(new ScalarQuery<MemberServiceCB>() {
                public void query(MemberServiceCB cb) {
                    cb.specify().columnServicePointCount();
                    cb.union(new UnionQuery<MemberServiceCB>() {
                        public void query(MemberServiceCB unionCB) {
                        }
                    });
                }
            });

            // ## Assert ##
            log("sum = " + sum);
            assertEquals(expected, sum); // should be selected uniquely
            assertTrue(markSet.contains("handle"));
        } finally {
            CallbackContext.clearSqlLogHandlerOnThread();
        }
    }

    public void test_ScalarSelect_with_UnionQuery_noPrimaryKey_sum() {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.specify().derivedPurchaseList().max(new SubQuery<PurchaseCB>() {
            public void query(PurchaseCB subCB) {
                subCB.specify().columnPurchasePrice();
            }
        }, Member.ALIAS_productKindCount);
        cb.query().setMemberStatusCode_Equal_Withdrawal();
        cb.query().addSpecifiedDerivedOrderBy_Desc(Member.ALIAS_productKindCount);
        ListResultBean<Member> memberList = memberBhv.selectList(cb);
        Integer expected = 0;
        for (Member member : memberList) {
            Integer maxPurchasePrice = member.getProductKindCount();
            log("maxPurchasePrice = " + maxPurchasePrice);
            expected = expected + maxPurchasePrice;
        }
        final Set<String> markSet = new HashSet<String>();
        CallbackContext.setSqlLogHandlerOnThread(new SqlLogHandler() {
            public void handle(SqlLogInfo info) {
                String displaySql = info.getDisplaySql();
                SummaryWithdrawalDbm dbm = SummaryWithdrawalDbm.getInstance();
                assertTrue(Srl.contains(displaySql, dbm.columnMaxPurchasePrice().getColumnDbName()));
                assertTrue(Srl.contains(displaySql, dbm.columnWithdrawalDatetime().getColumnDbName()));
                markSet.add("handle");
            }
        });

        // ## Act ##
        try {
            Integer sum = summaryWithdrawalBhv.scalarSelect(Integer.class).sum(new ScalarQuery<SummaryWithdrawalCB>() {
                public void query(SummaryWithdrawalCB cb) {
                    cb.specify().columnMaxPurchasePrice();
                    cb.union(new UnionQuery<SummaryWithdrawalCB>() {
                        public void query(SummaryWithdrawalCB unionCB) {
                        }
                    });
                }
            });

            // ## Assert ##
            log("sum = " + sum);
            assertEquals(expected, sum); // should be selected uniquely
            assertTrue(markSet.contains("handle"));
        } finally {
            CallbackContext.clearSqlLogHandlerOnThread();
        }
    }

    // ===================================================================================
    //                                                                             Illegal
    //                                                                             =======
    public void test_ScalarSelect_duplicated_basic() {
        // ## Arrange ##
        // ## Act ##
        try {
            memberBhv.scalarSelect(Date.class).max(new ScalarQuery<MemberCB>() {
                public void query(MemberCB cb) {
                    cb.specify().columnMemberAccount();
                    cb.specify().columnBirthdate();
                }
            });

            // ## Assert ##
            fail();
        } catch (SpecifyColumnTwoOrMoreColumnException e) {
            // OK
            log(e.getMessage());
        }
    }

    public void test_ScalarSelect_duplicated_both() {
        // ## Arrange ##
        // ## Act ##
        try {
            memberBhv.scalarSelect(Date.class).max(new ScalarQuery<MemberCB>() {
                public void query(MemberCB cb) {
                    cb.specify().columnMemberAccount();
                    cb.specify().derivedPurchaseList().max(new SubQuery<PurchaseCB>() {
                        public void query(PurchaseCB subCB) {
                            subCB.specify().columnPurchaseCount();
                        }
                    }, null);
                }
            });

            // ## Assert ##
            fail();
        } catch (SpecifyColumnWithDerivedReferrerException e) {
            // OK
            log(e.getMessage());
        }
    }

    public void test_ScalarSelect_duplicated_DerivedReferrer() {
        // ## Arrange ##
        // ## Act ##
        try {
            memberBhv.scalarSelect(Date.class).max(new ScalarQuery<MemberCB>() {
                public void query(MemberCB cb) {
                    cb.specify().derivedPurchaseList().max(new SubQuery<PurchaseCB>() {
                        public void query(PurchaseCB subCB) {
                            subCB.specify().columnPurchaseCount();
                        }
                    }, null);
                    cb.specify().derivedPurchaseList().max(new SubQuery<PurchaseCB>() {
                        public void query(PurchaseCB subCB) {
                            subCB.specify().columnPurchasePrice();
                        }
                    }, null);
                }
            });

            // ## Assert ##
            fail();
        } catch (SpecifyDerivedReferrerTwoOrMoreException e) {
            // OK
            log(e.getMessage());
        }
    }

    public void test_ScalarSelect_specifyRelation() {
        // ## Arrange ##
        // ## Act ##
        try {
            memberBhv.scalarSelect(Date.class).max(new ScalarQuery<MemberCB>() {
                public void query(MemberCB cb) {
                    cb.specify().specifyMemberStatus();
                }
            });

            // ## Assert ##
            fail();
        } catch (SpecifyRelationIllegalPurposeException e) {
            // OK
            log(e.getMessage());
        }
    }

    // ===================================================================================
    //                                                                              Option
    //                                                                              ======
    public void test_ScalarSelect_option_basic() {
        // ## Arrange ##
        int coalesce = 7849238;

        // ## Act ##
        Integer max = memberBhv.scalarSelect(Integer.class).max(new ScalarQuery<MemberCB>() {
            public void query(MemberCB cb) {
                cb.specify().columnMemberId();
                cb.query().setMemberStatusCode_Equal_Formalized();
                cb.query().setMemberName_Equal("no exist");
            }
        }, new ScalarSelectOption().coalesce(coalesce));

        // ## Assert ##
        assertEquals(Integer.valueOf(coalesce), max);
    }

    public void test_ScalarSelect_option_date() {
        // ## Arrange ##
        String coalesce = "2011-12-12";

        // ## Act ##
        Date birthdate = memberBhv.scalarSelect(Date.class).max(new ScalarQuery<MemberCB>() {
            public void query(MemberCB cb) {
                cb.specify().columnBirthdate();
                cb.query().setMemberStatusCode_Equal_Formalized();
                cb.query().setMemberName_Equal("no exist");
            }
        }, new ScalarSelectOption().coalesce(coalesce));

        // ## Assert ##
        assertEquals(coalesce, DfTypeUtil.toString(birthdate, "yyyy-MM-dd"));
    }

    public void test_ScalarSelect_option_DerivedReferrer_basic() {
        // ## Arrange ##
        int coalesce = 7849238;

        // ## Act ##
        Integer max = memberBhv.scalarSelect(Integer.class).max(new ScalarQuery<MemberCB>() {
            public void query(MemberCB cb) {
                cb.specify().derivedPurchaseList().avg(new SubQuery<PurchaseCB>() {
                    public void query(PurchaseCB subCB) {
                        subCB.specify().columnPurchasePrice();
                    }
                }, null);
                cb.query().setMemberStatusCode_Equal_Formalized();
                cb.query().setMemberName_Equal("no exist");
            }
        }, new ScalarSelectOption().coalesce(coalesce));

        // ## Assert ##
        assertEquals(Integer.valueOf(coalesce), max);
    }

    public void test_ScalarSelect_option_DerivedReferrer_severalFunction() {
        // ## Arrange ##
        int coalesce = 7849238;

        // ## Act ##
        Integer max = memberBhv.scalarSelect(Integer.class).max(new ScalarQuery<MemberCB>() {
            public void query(MemberCB cb) {
                cb.specify().derivedPurchaseList().avg(new SubQuery<PurchaseCB>() {
                    public void query(PurchaseCB subCB) {
                        subCB.specify().columnPurchasePrice();
                    }
                }, null);
                cb.query().setMemberStatusCode_Equal_Formalized();
                cb.query().setMemberName_Equal("no exist");
            }
        }, new ScalarSelectOption().coalesce(coalesce).round(2));

        // ## Assert ##
        assertEquals(Integer.valueOf(coalesce), max);
    }
}
