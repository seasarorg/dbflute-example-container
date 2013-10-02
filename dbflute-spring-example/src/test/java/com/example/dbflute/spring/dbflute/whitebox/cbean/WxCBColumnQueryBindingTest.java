package com.example.dbflute.spring.dbflute.whitebox.cbean;

import java.sql.Timestamp;

import org.seasar.dbflute.cbean.SpecifyQuery;
import org.seasar.dbflute.cbean.SubQuery;
import org.seasar.dbflute.cbean.UnionQuery;
import org.seasar.dbflute.cbean.coption.DerivedReferrerOption;
import org.seasar.dbflute.util.DfTypeUtil;
import org.seasar.dbflute.util.Srl;

import com.example.dbflute.spring.dbflute.cbean.MemberLoginCB;
import com.example.dbflute.spring.dbflute.cbean.MemberServiceCB;
import com.example.dbflute.spring.dbflute.cbean.PurchaseCB;
import com.example.dbflute.spring.dbflute.cbean.ServiceRankCB;
import com.example.dbflute.spring.dbflute.exbhv.MemberServiceBhv;
import com.example.dbflute.spring.dbflute.exbhv.ServiceRankBhv;
import com.example.dbflute.spring.dbflute.exentity.ServiceRank;
import com.example.dbflute.spring.unit.UnitContainerTestCase;

/**
 * @author jflute
 * @since 0.9.8.6 (2011/06/22 Wednesday)
 */
public class WxCBColumnQueryBindingTest extends UnitContainerTestCase {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private MemberServiceBhv memberServiceBhv;
    private ServiceRankBhv serviceRankBhv;

    // ===================================================================================
    //                                                                               Basic
    //                                                                               =====
    public void test_ColumnQuery_rightDerived_basic() throws Exception {
        // ## Arrange ##
        MemberServiceCB cb = new MemberServiceCB();
        cb.columnQuery(new SpecifyQuery<MemberServiceCB>() {
            public void specify(MemberServiceCB cb) {
                cb.specify().columnServicePointCount();
            }
        }).greaterThan(new SpecifyQuery<MemberServiceCB>() {
            public void specify(MemberServiceCB cb) {
                cb.specify().specifyServiceRank().derivedMemberServiceList().avg(new SubQuery<MemberServiceCB>() {
                    public void query(MemberServiceCB subCB) {
                        subCB.specify().columnServicePointCount();
                        subCB.query().setUpdateUser_Equal("ColumnQueryUser");
                    }
                }, null, new DerivedReferrerOption().coalesce(123).round(8));
            }
        });

        // ## Act ##
        memberServiceBhv.selectList(cb); // expect no exception
        String displaySql = cb.toDisplaySql();

        // ## Assert ##
        log(ln() + displaySql);
        assertTrue(displaySql.contains("= 'ColumnQueryUser'"));
        assertTrue(displaySql.contains(", 123), 8)"));
    }

    // ===================================================================================
    //                                                                      ExistsReferrer
    //                                                                      ==============
    public void test_ColumnQuery_in_ExistsReferrer_rightDerived_basic() throws Exception {
        // ## Arrange ##
        ServiceRankCB cb = new ServiceRankCB();
        cb.query().existsMemberServiceList(new SubQuery<MemberServiceCB>() {
            public void query(MemberServiceCB subCB) {
                subCB.columnQuery(new SpecifyQuery<MemberServiceCB>() {
                    public void specify(MemberServiceCB cb) {
                        cb.specify().columnServicePointCount();
                    }
                }).greaterThan(new SpecifyQuery<MemberServiceCB>() {
                    public void specify(MemberServiceCB cb) {
                        cb.specify().specifyServiceRank().derivedMemberServiceList()
                                .avg(new SubQuery<MemberServiceCB>() {
                                    public void query(MemberServiceCB subCB) {
                                        subCB.specify().columnServicePointCount();
                                        subCB.query().setUpdateUser_Equal("ColumnQueryUser");
                                    }
                                }, null, new DerivedReferrerOption().coalesce(123).round(8));
                    }
                });
            }
        });

        // ## Act ##
        serviceRankBhv.selectList(cb); // expect no exception
        String displaySql = cb.toDisplaySql();

        // ## Assert ##
        log(ln() + displaySql);
        assertTrue(displaySql.contains("= 'ColumnQueryUser'"));
        assertTrue(displaySql.contains(", 123), 8)"));
    }

    public void test_ColumnQuery_in_ExistsReferrer_rightDerived_calculation() throws Exception {
        // ## Arrange ##
        ServiceRankCB cb = new ServiceRankCB();
        cb.query().existsMemberServiceList(new SubQuery<MemberServiceCB>() {
            public void query(MemberServiceCB subCB) {
                subCB.columnQuery(new SpecifyQuery<MemberServiceCB>() {
                    public void specify(MemberServiceCB cb) {
                        cb.specify().columnServicePointCount();
                    }
                }).greaterThan(new SpecifyQuery<MemberServiceCB>() {
                    public void specify(MemberServiceCB cb) {
                        cb.specify().specifyServiceRank().derivedMemberServiceList()
                                .avg(new SubQuery<MemberServiceCB>() {
                                    public void query(MemberServiceCB subCB) {
                                        subCB.specify().columnServicePointCount();
                                        subCB.query().setUpdateUser_Equal("ColumnQueryUser");
                                    }
                                }, null, new DerivedReferrerOption().coalesce(123).round(8));
                    }
                }).plus(999);
            }
        });

        // ## Act ##
        serviceRankBhv.selectList(cb); // expect no exception
        String displaySql = cb.toDisplaySql();

        // ## Assert ##
        log(ln() + displaySql);
        assertTrue(displaySql.contains(" = 'ColumnQueryUser'"));
        assertTrue(displaySql.contains(", 123), 8)"));
        assertTrue(displaySql.contains(" ) + 999"));
    }

    public void test_ColumnQuery_in_UnionExistsReferrer_rightDerived_calculation() throws Exception {
        // ## Arrange ##
        ServiceRankCB cb = new ServiceRankCB();
        cb.query().existsMemberServiceList(new SubQuery<MemberServiceCB>() {
            public void query(MemberServiceCB subCB) {
                subCB.columnQuery(new SpecifyQuery<MemberServiceCB>() {
                    public void specify(MemberServiceCB cb) {
                        cb.specify().columnServicePointCount();
                    }
                }).greaterThan(new SpecifyQuery<MemberServiceCB>() {
                    public void specify(MemberServiceCB cb) {
                        cb.specify().specifyServiceRank().derivedMemberServiceList()
                                .avg(new SubQuery<MemberServiceCB>() {
                                    public void query(MemberServiceCB subCB) {
                                        subCB.specify().columnServicePointCount();
                                        subCB.query().setUpdateUser_Equal("ColumnQueryUser1");
                                    }
                                }, null, new DerivedReferrerOption().coalesce(123).round(8));
                    }
                }).plus(999);
            }
        });
        cb.union(new UnionQuery<ServiceRankCB>() {
            public void query(ServiceRankCB unionCB) {
                unionCB.query().existsMemberServiceList(new SubQuery<MemberServiceCB>() {
                    public void query(MemberServiceCB subCB) {
                        subCB.columnQuery(new SpecifyQuery<MemberServiceCB>() {
                            public void specify(MemberServiceCB cb) {
                                cb.specify().columnServicePointCount();
                            }
                        }).greaterThan(new SpecifyQuery<MemberServiceCB>() {
                            public void specify(MemberServiceCB cb) {
                                cb.specify().specifyServiceRank().derivedMemberServiceList()
                                        .avg(new SubQuery<MemberServiceCB>() {
                                            public void query(MemberServiceCB subCB) {
                                                subCB.specify().columnServicePointCount();
                                                subCB.query().setUpdateUser_Equal("ColumnQueryUser2");
                                                subCB.query().queryMember()
                                                        .existsMemberLoginList(new SubQuery<MemberLoginCB>() {
                                                            public void query(MemberLoginCB subCB) {
                                                                Timestamp timestamp = DfTypeUtil
                                                                        .toTimestamp("2011-12-21");
                                                                subCB.query().setLoginDatetime_GreaterEqual(timestamp);
                                                            }
                                                        });
                                            }
                                        }, null, new DerivedReferrerOption().coalesce(456).round(7));
                            }
                        }).plus(888).minus(654);
                    }
                });
            }
        });

        // ## Act ##
        serviceRankBhv.selectList(cb); // expect no exception
        String displaySql = cb.toDisplaySql();

        // ## Assert ##
        log(ln() + displaySql);
        String front = Srl.substringFirstFront(displaySql, " union ");
        String rear = Srl.substringFirstRear(displaySql, " union ");
        assertTrue(front.contains(" = 'ColumnQueryUser1'"));
        assertTrue(front.contains(", 123), 8)"));
        assertTrue(front.contains(" ) + 999"));
        assertTrue(rear.contains(" = 'ColumnQueryUser2'"));
        assertTrue(rear.contains(", 456), 7)"));
        assertTrue(rear.contains(" ) + 888) - 654"));
        assertTrue(rear.contains(">= '2011-12-21 00:00:00.000'"));
    }

    // ===================================================================================
    //                                                                           On Parade
    //                                                                           =========
    public void test_ColumnQuery_onParade() throws Exception {
        // ## Arrange ##
        ServiceRankCB cb = new ServiceRankCB();
        cb.specify().derivedMemberServiceList().count(new SubQuery<MemberServiceCB>() {
            public void query(MemberServiceCB subCB) {
                subCB.specify().columnMemberServiceId();
            }
        }, ServiceRank.ALIAS_memberCount);
        cb.specify().derivedMemberServiceList().sum(new SubQuery<MemberServiceCB>() {
            public void query(MemberServiceCB subCB) {
                subCB.specify().specifyMember().derivedPurchaseList().max(new SubQuery<PurchaseCB>() {
                    public void query(PurchaseCB subCB) {
                        subCB.specify().columnPurchasePrice();
                    }
                }, null);
            }
        }, ServiceRank.ALIAS_maxPurchasePrice);
        cb.specify().derivedMemberServiceList().avg(new SubQuery<MemberServiceCB>() {
            public void query(MemberServiceCB subCB) {
                subCB.specify().specifyMember().derivedPurchaseList().avg(new SubQuery<PurchaseCB>() {
                    public void query(PurchaseCB subCB) {
                        subCB.specify().columnPurchasePrice();
                    }
                }, null);
            }
        }, ServiceRank.ALIAS_avgPurchasePrice);
        cb.specify().derivedMemberServiceList().avg(new SubQuery<MemberServiceCB>() {
            public void query(MemberServiceCB subCB) {
                subCB.specify().columnServicePointCount();
            }
        }, ServiceRank.ALIAS_sumPointCount);
        cb.specify().derivedMemberServiceList().count(new SubQuery<MemberServiceCB>() {
            public void query(MemberServiceCB subCB) {
                subCB.specify().specifyMember().derivedMemberLoginList().count(new SubQuery<MemberLoginCB>() {

                    public void query(MemberLoginCB subCB) {
                        subCB.specify().columnMemberLoginId();
                    }
                }, null);
            }
        }, ServiceRank.ALIAS_loginCount);
        cb.columnQuery(new SpecifyQuery<ServiceRankCB>() {
            public void specify(ServiceRankCB cb) {
                cb.specify().columnDisplayOrder();
            }
        }).greaterThan(new SpecifyQuery<ServiceRankCB>() {
            public void specify(ServiceRankCB cb) {
                cb.specify().derivedMemberServiceList().avg(new SubQuery<MemberServiceCB>() {
                    public void query(MemberServiceCB subCB) {
                        subCB.specify().columnServicePointCount();
                        subCB.query().setUpdateUser_Equal("ColumnQueryUser");
                    }
                }, null, new DerivedReferrerOption().coalesce(123).round(8));
            }
        });
        cb.query().existsMemberServiceList(new SubQuery<MemberServiceCB>() {
            public void query(MemberServiceCB subCB) {
                subCB.columnQuery(new SpecifyQuery<MemberServiceCB>() {
                    public void specify(MemberServiceCB cb) {
                        cb.specify().columnServicePointCount();
                    }
                }).greaterThan(new SpecifyQuery<MemberServiceCB>() {
                    public void specify(MemberServiceCB cb) {
                        cb.specify().specifyServiceRank().derivedMemberServiceList()
                                .avg(new SubQuery<MemberServiceCB>() {
                                    public void query(MemberServiceCB subCB) {
                                        subCB.specify().columnServicePointCount();
                                        subCB.query().setUpdateUser_Equal("ColumnQueryUser");
                                    }
                                }, null, new DerivedReferrerOption().coalesce(123));
                    }
                });
                subCB.columnQuery(new SpecifyQuery<MemberServiceCB>() {
                    public void specify(MemberServiceCB cb) {
                        cb.specify().specifyServiceRank().derivedMemberServiceList()
                                .avg(new SubQuery<MemberServiceCB>() {
                                    public void query(MemberServiceCB subCB) {
                                        subCB.specify().columnServicePointCount();
                                        subCB.query().setUpdateUser_Equal("@ServicePointCount");
                                    }
                                }, null, new DerivedReferrerOption().coalesce(789));
                    }
                }).greaterThan(new SpecifyQuery<MemberServiceCB>() {
                    public void specify(MemberServiceCB cb) {
                        cb.specify().columnServicePointCount();
                    }
                });
                subCB.columnQuery(new SpecifyQuery<MemberServiceCB>() {
                    public void specify(MemberServiceCB cb) {
                        cb.specify().specifyMember().derivedPurchaseList().max(new SubQuery<PurchaseCB>() {
                            public void query(PurchaseCB subCB) {
                                subCB.specify().columnPurchasePrice();
                            }
                        }, null);
                    }
                }).greaterThan(new SpecifyQuery<MemberServiceCB>() {
                    public void specify(MemberServiceCB cb) {
                        cb.specify().specifyServiceRank().derivedMemberServiceList()
                                .avg(new SubQuery<MemberServiceCB>() {
                                    public void query(MemberServiceCB subCB) {
                                        subCB.specify().columnServicePointCount();
                                    }
                                }, null, new DerivedReferrerOption().coalesce(456));
                    }
                }).plus(999);
            }
        });

        // ## Act ##
        serviceRankBhv.selectList(cb); // expect no exception
        String displaySql = cb.toDisplaySql();

        // ## Assert ##
        log(ln() + displaySql);
        assertTrue(displaySql.contains("= 'ColumnQueryUser'"));
        assertTrue(displaySql.contains(", 123"));
    }
}
