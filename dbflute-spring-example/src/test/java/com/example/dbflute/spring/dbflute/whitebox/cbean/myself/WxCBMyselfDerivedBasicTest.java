package com.example.dbflute.spring.dbflute.whitebox.cbean.myself;

import org.seasar.dbflute.cbean.ListResultBean;
import org.seasar.dbflute.cbean.SpecifyQuery;
import org.seasar.dbflute.cbean.SubQuery;
import org.seasar.dbflute.cbean.UnionQuery;
import org.seasar.dbflute.cbean.coption.DerivedReferrerOption;
import org.seasar.dbflute.exception.SQLFailureException;

import com.example.dbflute.spring.dbflute.cbean.MemberCB;
import com.example.dbflute.spring.dbflute.exbhv.MemberBhv;
import com.example.dbflute.spring.dbflute.exentity.Member;
import com.example.dbflute.spring.unit.UnitContainerTestCase;

/**
 * @author jflute
 * @since 0.9.9.7C (2012/08/06 Monday)
 */
public class WxCBMyselfDerivedBasicTest extends UnitContainerTestCase {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private MemberBhv memberBhv;

    // ===================================================================================
    //                                                              (Specify)MyselfDerived
    //                                                              ======================
    // -----------------------------------------------------
    //                                               Ranking
    //                                               -------
    public void test_SpecifyMyselfDerived_ranking_basic() throws Exception {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.setupSelect_MemberServiceAsOne();
        final MemberCB dreamCruiseCB = cb.dreamCruiseCB();
        cb.specify().myselfDerived().count(new SubQuery<MemberCB>() {
            public void query(MemberCB subCB) {
                subCB.specify().columnMemberId();
                subCB.columnQuery(new SpecifyQuery<MemberCB>() {
                    public void specify(MemberCB cb) {
                        cb.specify().specifyMemberServiceAsOne().columnServicePointCount();
                    }
                }).greaterThan(new SpecifyQuery<MemberCB>() {
                    public void specify(MemberCB cb) {
                        cb.overTheWaves(dreamCruiseCB.specify().specifyMemberServiceAsOne().columnServicePointCount());
                    }
                });
            }
        }, Member.ALIAS_loginCount, new DerivedReferrerOption().plus(1));
        cb.query().queryMemberServiceAsOne().addOrderBy_ServicePointCount_Desc();

        // ## Act ##
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        Integer previousPoint = null;
        Integer previousRank = null;
        boolean existsSame = false;
        for (Member member : memberList) {
            Integer memberId = member.getMemberId();
            Integer servicePointCount = member.getMemberServiceAsOne().getServicePointCount();
            Integer pointRank = member.getLoginCount();
            log(memberId + ", " + servicePointCount + ", " + pointRank);
            if (previousPoint != null && previousPoint < servicePointCount) {
                fail();
            }
            if (previousRank != null && previousRank > pointRank) {
                fail();
            }
            if (previousRank != null && previousRank == pointRank) {
                assertEquals(servicePointCount, previousPoint);
                existsSame = true;
            }
            previousPoint = servicePointCount;
            previousRank = pointRank;
        }
        assertTrue(existsSame);
    }

    // *H2 does not support this so this test moved to dbflute-mysql-example
    //public void test_SpecifyMyselfDerived_ranking_derived() throws Exception {
    //}

    public void test_SpecifyMyselfDerived_ranking_noisy() throws Exception {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.setupSelect_MemberServiceAsOne();
        final MemberCB dreamCruiseCB = cb.dreamCruiseCB();
        cb.specify().myselfDerived().count(new SubQuery<MemberCB>() {
            public void query(MemberCB subCB) {
                subCB.specify().columnMemberId();
                subCB.columnQuery(new SpecifyQuery<MemberCB>() {
                    public void specify(MemberCB cb) {
                        cb.specify().specifyMemberServiceAsOne().columnServicePointCount();
                    }
                }).greaterThan(new SpecifyQuery<MemberCB>() {
                    public void specify(MemberCB cb) {
                        cb.overTheWaves(dreamCruiseCB.specify().specifyMemberServiceAsOne().columnServicePointCount());
                    }
                });
            }
        }, Member.ALIAS_loginCount, new DerivedReferrerOption().plus(1));
        DerivedReferrerOption option = new DerivedReferrerOption().coalesce(0).multiply(9).plus(1)
                .minus(dreamCruiseCB.specify().columnMemberId());
        cb.specify().myselfDerived().count(new SubQuery<MemberCB>() {
            public void query(MemberCB subCB) {
                subCB.specify().columnMemberId();
                subCB.columnQuery(new SpecifyQuery<MemberCB>() {
                    public void specify(MemberCB cb) {
                        cb.specify().specifyMemberServiceAsOne().columnServicePointCount();
                    }
                }).greaterThan(new SpecifyQuery<MemberCB>() {
                    public void specify(MemberCB cb) {
                        cb.overTheWaves(dreamCruiseCB.specify().specifyMemberServiceAsOne().columnServicePointCount());
                    }
                });
            }
        }, Member.ALIAS_productKindCount, option);
        cb.query().queryMemberServiceAsOne().addOrderBy_ServicePointCount_Desc();

        // ## Act ##
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        Integer previousPoint = null;
        Integer previousRank = null;
        boolean existsSame = false;
        for (Member member : memberList) {
            Integer memberId = member.getMemberId();
            Integer servicePointCount = member.getMemberServiceAsOne().getServicePointCount();
            Integer pointRank = member.getLoginCount();
            log(memberId + ", " + servicePointCount + ", " + pointRank);
            if (previousPoint != null && previousPoint < servicePointCount) {
                fail();
            }
            if (previousRank != null && previousRank > pointRank) {
                fail();
            }
            if (previousRank != null && previousRank == pointRank) {
                assertEquals(servicePointCount, previousPoint);
                existsSame = true;
            }
            previousPoint = servicePointCount;
            previousRank = pointRank;
        }
        assertTrue(existsSame);
    }

    // -----------------------------------------------------
    //                                                 Union
    //                                                 -----
    public void test_SpecifyMyselfDerived_union() throws Exception {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.setupSelect_MemberServiceAsOne();
        final MemberCB dreamCruiseCB = cb.dreamCruiseCB();
        cb.specify().myselfDerived().count(new SubQuery<MemberCB>() {
            public void query(MemberCB subCB) {
                subCB.specify().columnMemberId();
                subCB.query().setMemberStatusCode_Equal_Formalized();
                subCB.columnQuery(new SpecifyQuery<MemberCB>() {
                    public void specify(MemberCB cb) {
                        cb.specify().specifyMemberServiceAsOne().columnServicePointCount();
                    }
                }).greaterThan(new SpecifyQuery<MemberCB>() {
                    public void specify(MemberCB cb) {
                        cb.overTheWaves(dreamCruiseCB.specify().specifyMemberServiceAsOne().columnServicePointCount());
                    }
                });
                subCB.union(new UnionQuery<MemberCB>() {
                    public void query(MemberCB unionCB) {
                        unionCB.query().setMemberStatusCode_Equal_Provisional();
                        unionCB.columnQuery(new SpecifyQuery<MemberCB>() {
                            public void specify(MemberCB cb) {
                                cb.specify().specifyMemberServiceAsOne().columnServicePointCount();
                            }
                        }).greaterThan(new SpecifyQuery<MemberCB>() {
                            public void specify(MemberCB cb) {
                                cb.overTheWaves(dreamCruiseCB.specify().specifyMemberServiceAsOne()
                                        .columnServicePointCount());
                            }
                        });
                    }
                });
            }
        }, Member.ALIAS_loginCount, new DerivedReferrerOption().plus(1));
        cb.query().queryMemberServiceAsOne().addOrderBy_ServicePointCount_Desc();

        // ## Act ##
        try {
            memberBhv.selectList(cb);

            // ## Assert ##
            fail(); // because of inline-view
        } catch (SQLFailureException e) {
            // OK
            log(e.getMessage());
        }
    }

    // -----------------------------------------------------
    //                                                 Plain
    //                                                 -----
    public void test_SpecifyMyselfDerived_plain_basic() throws Exception {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.specify().myselfDerived().count(new SubQuery<MemberCB>() {
            public void query(MemberCB subCB) {
                subCB.specify().columnMemberId();
                subCB.query().setMemberStatusCode_Equal_Formalized();
            }
        }, Member.ALIAS_loginCount, new DerivedReferrerOption().plus(1).minus(2).coalesce(9));

        // ## Act ##
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        assertHasAnyElement(memberList);
        Integer previous = null;
        for (Member member : memberList) {
            Integer memberId = member.getMemberId();
            Integer current = member.getLoginCount();
            log(memberId + ", " + current);
            if (previous != null && previous != current) {
                fail();
            }
            previous = current;
        }
    }

    // ===================================================================================
    //                                                                (Query)MyselfDerived
    //                                                                ====================
    // -----------------------------------------------------
    //                                               Ranking
    //                                               -------
    public void test_QueryMyselfDerived_ranking_basic() throws Exception {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        final MemberCB dreamCruiseCB = cb.dreamCruiseCB();
        cb.specify().myselfDerived().count(new SubQuery<MemberCB>() {
            public void query(MemberCB subCB) {
                subCB.specify().columnMemberId();
                subCB.columnQuery(new SpecifyQuery<MemberCB>() {
                    public void specify(MemberCB cb) {
                        cb.specify().specifyMemberServiceAsOne().columnServicePointCount();
                    }
                }).greaterThan(new SpecifyQuery<MemberCB>() {
                    public void specify(MemberCB cb) {
                        cb.overTheWaves(dreamCruiseCB.specify().specifyMemberServiceAsOne().columnServicePointCount());
                    }
                });
            }
        }, Member.ALIAS_loginCount, new DerivedReferrerOption().plus(1));
        cb.query().myselfDerived().count(new SubQuery<MemberCB>() {
            public void query(MemberCB subCB) {
                subCB.specify().columnMemberId();
                subCB.columnQuery(new SpecifyQuery<MemberCB>() {
                    public void specify(MemberCB cb) {
                        cb.specify().specifyMemberServiceAsOne().columnServicePointCount();
                    }
                }).greaterThan(new SpecifyQuery<MemberCB>() {
                    public void specify(MemberCB cb) {
                        cb.overTheWaves(dreamCruiseCB.specify().specifyMemberServiceAsOne().columnServicePointCount());
                    }
                });
            }
        }, new DerivedReferrerOption().plus(1)).lessEqual(3);
        cb.query().queryMemberServiceAsOne().addOrderBy_ServicePointCount_Desc();

        // ## Act ##
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        Integer previousRank = null;
        for (Member member : memberList) {
            Integer memberId = member.getMemberId();
            Integer pointRank = member.getLoginCount();
            log(memberId + ", " + pointRank);
            if (previousRank != null && previousRank > pointRank) {
                fail();
            }
            assertNull(member.getMemberServiceAsOne());
            assertTrue(pointRank <= 3);
            previousRank = pointRank;
        }
        assertEquals(3, memberList.size());
    }
}
