package com.example.dbflute.spring.dbflute.whitebox.cbean;

import org.seasar.dbflute.cbean.SubQuery;
import org.seasar.dbflute.cbean.UnionQuery;
import org.seasar.dbflute.cbean.coption.LikeSearchOption;
import org.seasar.dbflute.exception.InvalidQueryRegisteredException;
import org.seasar.dbflute.util.DfTypeUtil;
import org.seasar.dbflute.util.Srl;

import com.example.dbflute.spring.dbflute.cbean.MemberCB;
import com.example.dbflute.spring.dbflute.cbean.PurchaseCB;
import com.example.dbflute.spring.dbflute.exbhv.MemberBhv;
import com.example.dbflute.spring.dbflute.exentity.Member;
import com.example.dbflute.spring.unit.UnitContainerTestCase;

/**
 * @author jflute
 * @since 0.9.7.8 (2010/12/20 Monday)
 */
public class WxCBInvalidQueryTest extends UnitContainerTestCase {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private MemberBhv memberBhv;

    // ===================================================================================
    //                                                                       Invalid Query
    //                                                                       =============
    public void test_checkInvalidQuery_basic() {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.query().setMemberId_Equal(null); // no exception
        cb.query().setMemberName_PrefixSearch(""); // no exception
        cb.checkInvalidQuery();

        // ## Act ##
        try {
            cb.query().setMemberId_Equal(null);

            // ## Assert ##
            fail();
        } catch (InvalidQueryRegisteredException e) {
            // OK
            log(e.getMessage());
            assertTrue(Srl.containsAll(e.getMessage(), "MEMBER_ID equal", "query()"));
        }
        try {
            cb.query().setMemberName_PrefixSearch("");

            fail();
        } catch (InvalidQueryRegisteredException e) {
            // OK
            log(e.getMessage());
            assertTrue(Srl.containsAll(e.getMessage(), "MEMBER_NAME likeSearch", "query()"));
        }

        // ## Act ##
        cb.query().setMemberId_Equal(3);
        Member actual = memberBhv.selectEntityWithDeletedCheck(cb);

        // ## Assert ##
        assertEquals(Integer.valueOf(3), actual.getMemberId());
    }

    public void test_checkInvalidQuery_fromTo() {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.checkInvalidQuery();

        // ## Act ##
        cb.query().setBirthdate_DateFromTo(DfTypeUtil.toDate("2006-09-26"), null); // OK
        assertTrue(Srl.contains(cb.toDisplaySql(), "2006-09-26"));
        cb.query().setBirthdate_DateFromTo(null, DfTypeUtil.toDate("2011-01-21")); // OK
        assertTrue(Srl.contains(cb.toDisplaySql(), "2011-01-22")); // added

        try {
            cb.query().setBirthdate_DateFromTo(null, null);

            // ## Assert ##
            fail();
        } catch (InvalidQueryRegisteredException e) {
            // OK
            log(e.getMessage());
        }
    }

    public void test_checkInvalidQuery_splitBy_basic() {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.checkInvalidQuery();
        LikeSearchOption option = new LikeSearchOption().splitByPipeLine();

        // ## Act ##
        cb.query().setMemberName_LikeSearch("FOO|BAR||QUX", option); // OK
        String sql = cb.toDisplaySql();
        assertTrue(Srl.containsAll(sql, "FOO", "BAR", "QUX"));
        assertEquals(3, Srl.count(sql, " like "));
        log(ln() + sql);
        try {
            cb.query().setMemberName_LikeSearch("|||", option);

            // ## Assert ##
            fail();
        } catch (InvalidQueryRegisteredException e) {
            // OK
            log(e.getMessage());
        }
    }

    public void test_checkInvalidQuery_subquery() {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.query().existsPurchaseList(new SubQuery<PurchaseCB>() {
            public void query(PurchaseCB subCB) {
                subCB.query().setPurchaseDatetime_Equal(null); // no exception
            }
        });
        cb.checkInvalidQuery();

        // ## Act ##
        try {
            cb.query().existsPurchaseList(new SubQuery<PurchaseCB>() {
                public void query(PurchaseCB subCB) {
                    subCB.query().setPurchaseDatetime_Equal(null);
                }
            });

            // ## Assert ##
            fail();
        } catch (InvalidQueryRegisteredException e) {
            // OK
            log(e.getMessage());
            assertTrue(Srl.containsAll(e.getMessage(), "PURCHASE_DATETIME equal", "query()"));
        }
    }

    public void test_checkInvalidQuery_union() {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.union(new UnionQuery<MemberCB>() {
            public void query(MemberCB unionCB) {
                unionCB.query().setMemberName_Equal("");
            }
        });
        cb.checkInvalidQuery();

        // ## Act ##
        try {
            cb.union(new UnionQuery<MemberCB>() {
                public void query(MemberCB unionCB) {
                    unionCB.query().setMemberAccount_Equal("");
                }
            });

            // ## Assert ##
            fail();
        } catch (InvalidQueryRegisteredException e) {
            // OK
            log(e.getMessage());
            assertTrue(Srl.containsAll(e.getMessage(), "MEMBER_ACCOUNT equal", "query()"));
        }
    }

    public void test_throughInvalidQuery_basic() {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.query().setMemberId_Equal(null); // no exception
        cb.query().setMemberName_PrefixSearch(""); // no exception
        cb.checkInvalidQuery();

        // ## Act ##
        try {
            cb.query().setMemberId_Equal(null);

            // ## Assert ##
            fail();
        } catch (InvalidQueryRegisteredException e) {
            // OK
            log(e.getMessage());
            assertTrue(Srl.containsAll(e.getMessage(), "MEMBER_ID equal", "query()"));
        }
        try {
            cb.query().setMemberName_PrefixSearch("");

            fail();
        } catch (InvalidQueryRegisteredException e) {
            // OK
            log(e.getMessage());
            assertTrue(Srl.containsAll(e.getMessage(), "MEMBER_NAME likeSearch", "query()"));
        }
        cb.acceptInvalidQuery();
        cb.query().setMemberId_Equal(null); // no exception
        cb.query().setMemberName_PrefixSearch(""); // no exception

        // ## Act ##
        cb.query().setMemberId_Equal(3);
        Member actual = memberBhv.selectEntityWithDeletedCheck(cb);

        // ## Assert ##
        assertEquals(Integer.valueOf(3), actual.getMemberId());
    }

    // ===================================================================================
    //                                                                        Empty String
    //                                                                        ============
    public void test_allowEmptyStringQuery_basic() {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.query().setMemberName_Equal("");

        // ## Act ##
        cb.allowEmptyStringQuery();

        // ## Assert ##
        cb.query().setMemberAccount_Equal("");
        String sql = cb.toDisplaySql();
        log(ln() + sql);
        assertFalse(sql.contains(" dfloc.MEMBER_NAME = ''"));
        assertTrue(sql.contains(" dfloc.MEMBER_ACCOUNT = ''"));
    }

    public void test_allowEmptyStringQuery_subquery() {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.query().existsPurchaseList(new SubQuery<PurchaseCB>() {
            public void query(PurchaseCB subCB) {
                subCB.query().queryProduct().setProductHandleCode_Equal("");
            }
        });

        // ## Act ##
        cb.allowEmptyStringQuery();
        cb.query().existsPurchaseList(new SubQuery<PurchaseCB>() {
            public void query(PurchaseCB subCB) {
                subCB.query().queryProduct().setProductStatusCode_Equal("");
            }
        });

        // ## Assert ##
        String sql = cb.toDisplaySql();
        log(ln() + sql);
        assertFalse(sql.contains("PRODUCT_HANDLE_CODE = ''"));
        assertTrue(sql.contains("PRODUCT_STATUS_CODE = ''"));
    }
}
