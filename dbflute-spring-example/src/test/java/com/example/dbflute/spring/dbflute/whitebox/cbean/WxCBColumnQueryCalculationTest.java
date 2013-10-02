package com.example.dbflute.spring.dbflute.whitebox.cbean;

import java.math.BigDecimal;

import org.seasar.dbflute.cbean.ListResultBean;
import org.seasar.dbflute.cbean.SpecifyQuery;
import org.seasar.dbflute.cbean.SubQuery;
import org.seasar.dbflute.cbean.coption.DerivedReferrerOption;
import org.seasar.dbflute.exception.ColumnQueryCalculationUnsupportedColumnTypeException;

import com.example.dbflute.spring.dbflute.cbean.MemberCB;
import com.example.dbflute.spring.dbflute.cbean.PurchaseCB;
import com.example.dbflute.spring.dbflute.exbhv.MemberBhv;
import com.example.dbflute.spring.dbflute.exentity.Member;
import com.example.dbflute.spring.unit.UnitContainerTestCase;

/**
 * @author jflute
 * @since 0.6.0 (2008/01/16 Wednesday)
 */
public class WxCBColumnQueryCalculationTest extends UnitContainerTestCase {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private MemberBhv memberBhv;

    // ===================================================================================
    //                                                                               Basic 
    //                                                                               =====
    public void test_ColumnQuery_calculation_plus() throws Exception {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.setupSelect_MemberStatus();
        cb.specify().specifyMemberStatus().columnDisplayOrder();
        cb.columnQuery(new SpecifyQuery<MemberCB>() {
            public void specify(MemberCB cb) {
                cb.specify().columnMemberId();
            }
        }).equal(new SpecifyQuery<MemberCB>() {
            public void specify(MemberCB cb) {
                cb.specify().specifyMemberStatus().columnDisplayOrder();
            }
        }).plus(1);
        cb.query().addOrderBy_MemberId_Asc();

        // ## Act ##
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        assertFalse(memberList.isEmpty());
        for (Member member : memberList) {
            Integer memberId = member.getMemberId();
            Integer displayOrder = member.getMemberStatus().getDisplayOrder();
            log(memberId + ", " + displayOrder);
            assertEquals(Integer.valueOf(displayOrder + 1), memberId);
        }
    }

    public void test_ColumnQuery_calculation_multiply_plus() throws Exception {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.setupSelect_MemberStatus();
        cb.specify().specifyMemberStatus().columnDisplayOrder();
        cb.columnQuery(new SpecifyQuery<MemberCB>() {
            public void specify(MemberCB cb) {
                cb.specify().columnMemberId();
            }
        }).equal(new SpecifyQuery<MemberCB>() {
            public void specify(MemberCB cb) {
                cb.specify().specifyMemberStatus().columnDisplayOrder();
            }
        }).multiply(2).divide(2).plus(1);
        cb.query().addOrderBy_MemberId_Asc();

        // ## Act ##
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        assertFalse(memberList.isEmpty());
        for (Member member : memberList) {
            Integer memberId = member.getMemberId();
            Integer displayOrder = member.getMemberStatus().getDisplayOrder();
            log(memberId + ", " + displayOrder);
            assertEquals(Integer.valueOf(displayOrder + 1), memberId);
        }
    }

    public void test_ColumnQuery_calculation_decimal() throws Exception {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.setupSelect_MemberStatus();
        cb.specify().specifyMemberStatus().columnDisplayOrder();
        cb.columnQuery(new SpecifyQuery<MemberCB>() {
            public void specify(MemberCB cb) {
                cb.specify().columnMemberId();
            }
        }).equal(new SpecifyQuery<MemberCB>() {
            public void specify(MemberCB cb) {
                cb.specify().specifyMemberStatus().columnDisplayOrder();
            }
        }).plus(new BigDecimal("1.000"));
        cb.query().addOrderBy_MemberId_Asc();

        // ## Act ##
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        assertTrue(cb.toDisplaySql().contains("+ 1.000"));
        assertFalse(memberList.isEmpty());
        for (Member member : memberList) {
            Integer memberId = member.getMemberId();
            Integer displayOrder = member.getMemberStatus().getDisplayOrder();
            log(memberId + ", " + displayOrder);
            assertEquals(Integer.valueOf(displayOrder + 1), memberId);
        }
    }

    public void test_ColumnQuery_calculation_with_DerivedReferrer() throws Exception {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.specify().derivedPurchaseList().min(new SubQuery<PurchaseCB>() {
            public void query(PurchaseCB subCB) {
                subCB.specify().columnPurchasePrice();
                subCB.query().setPaymentCompleteFlg_Equal_True();
            }
        }, Member.ALIAS_productKindCount, new DerivedReferrerOption().coalesce(0));
        cb.columnQuery(new SpecifyQuery<MemberCB>() {
            public void specify(MemberCB cb) {
                cb.specify().derivedPurchaseList().min(new SubQuery<PurchaseCB>() {
                    public void query(PurchaseCB subCB) {
                        subCB.specify().columnPurchasePrice();
                        subCB.query().setPaymentCompleteFlg_Equal_True();
                    }
                }, null, new DerivedReferrerOption().coalesce(0));
            }
        }).lessThan(new SpecifyQuery<MemberCB>() {
            public void specify(MemberCB cb) {
                cb.specify().columnMemberId();
            }
        }).multiply(500).plus(1);

        // ## Act ##
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        assertFalse(memberList.isEmpty());
        for (Member member : memberList) {
            Integer memberId = member.getMemberId();
            Integer minPrice = member.getProductKindCount();
            Integer calc = (memberId * 500) + 1;
            log(memberId + " : " + minPrice + " < " + calc);
            assertTrue(minPrice < calc);
        }
    }

    public void test_ColumnQuery_calculation_notNumber() throws Exception {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.columnQuery(new SpecifyQuery<MemberCB>() {
            public void specify(MemberCB cb) {
                cb.specify().columnBirthdate();
            }
        }).lessEqual(new SpecifyQuery<MemberCB>() {
            public void specify(MemberCB cb) {
                cb.specify().columnFormalizedDatetime();
            }
        }).plus(1);

        // ## Act ##
        try {
            memberBhv.selectList(cb);

            // ## Assert ##
            fail();
        } catch (ColumnQueryCalculationUnsupportedColumnTypeException e) {
            // OK
            log(e.getMessage());
        }
    }

    // ===================================================================================
    //                                                                                Left 
    //                                                                                ====
    public void test_ColumnQuery_calculation_left() throws Exception {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.setupSelect_MemberStatus();
        cb.specify().specifyMemberStatus().columnDisplayOrder();
        cb.columnQuery(new SpecifyQuery<MemberCB>() {
            public void specify(MemberCB cb) {
                cb.specify().columnMemberId();
            }
        }).equal(new SpecifyQuery<MemberCB>() {
            public void specify(MemberCB cb) {
                cb.specify().specifyMemberStatus().columnDisplayOrder();
            }
        }).left().plus(1).minus(2);
        cb.query().addOrderBy_MemberId_Asc();

        // ## Act ##
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        assertFalse(memberList.isEmpty());
        for (Member member : memberList) {
            Integer memberId = member.getMemberId();
            Integer displayOrder = member.getMemberStatus().getDisplayOrder();
            log(memberId + ", " + displayOrder);
            assertEquals(Integer.valueOf(displayOrder + 1), memberId);
        }
    }

    public void test_ColumnQuery_calculation_left_and_right() throws Exception {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.setupSelect_MemberStatus();
        cb.specify().specifyMemberStatus().columnDisplayOrder();
        cb.columnQuery(new SpecifyQuery<MemberCB>() {
            public void specify(MemberCB cb) {
                cb.specify().columnMemberId();
            }
        }).equal(new SpecifyQuery<MemberCB>() {
            public void specify(MemberCB cb) {
                cb.specify().specifyMemberStatus().columnDisplayOrder();
            }
        }).left().plus(2).minus(2).right().plus(1);
        cb.query().addOrderBy_MemberId_Asc();

        // ## Act ##
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        assertFalse(memberList.isEmpty());
        for (Member member : memberList) {
            Integer memberId = member.getMemberId();
            Integer displayOrder = member.getMemberStatus().getDisplayOrder();
            log(memberId + ", " + displayOrder);
            assertEquals(Integer.valueOf(displayOrder + 1), memberId);
        }
    }
}
