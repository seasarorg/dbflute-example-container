package com.example.dbflute.spring.dbflute.whitebox.cbean;

import org.seasar.dbflute.cbean.ListResultBean;
import org.seasar.dbflute.cbean.SpecifyQuery;
import org.seasar.dbflute.exception.FixedConditionParameterNotFoundException;

import com.example.dbflute.spring.dbflute.cbean.MemberCB;
import com.example.dbflute.spring.dbflute.exbhv.MemberBhv;
import com.example.dbflute.spring.dbflute.exentity.Member;
import com.example.dbflute.spring.dbflute.exentity.MemberAddress;
import com.example.dbflute.spring.unit.UnitContainerTestCase;

/**
 * @author jflute
 * @since 1.0.4F (2013/07/05 Friday)
 */
public class WxCBBizOneToOneTest extends UnitContainerTestCase {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private MemberBhv memberBhv;

    // ===================================================================================
    //                                                               SetupSelect(Relation)
    //                                                               =====================
    public void test_BizOneToOne_basic() {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.setupSelect_MemberAddressAsValid(currentDate());

        // ## Act ##
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        assertHasAnyElement(memberList);
        boolean exists = false;
        for (Member member : memberList) {
            MemberAddress address = member.getMemberAddressAsValid();
            log(member.getMemberName(), address != null ? address.getAddress() : null);
            if (address != null) {
                assertNotNull(address.getValidBeginDate());
                assertNotNull(address.getValidEndDate());
                assertNotNull(address.getAddress());
                exists = true;
            }
            assertTrue(member.getMemberAddressList().isEmpty());
        }
        assertTrue(exists);
    }

    public void test_BizOneToOne_nullBinding() {
        // ## Arrange ##
        MemberCB cb = new MemberCB();

        // ## Act ##
        try {
            cb.setupSelect_MemberAddressAsValid(null);

            // ## Assert ##
            fail();
        } catch (FixedConditionParameterNotFoundException e) {
            log(e.getMessage());
        }
    }

    // ===================================================================================
    //                                                                       SpecifyColumn
    //                                                                       =============
    public void test_BizOneToOne_SpecifyColumn_specifyEmpty() {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.setupSelect_MemberAddressAsValid(currentDate());
        cb.specify().specifyMemberAddressAsValid().columnAddress();

        // ## Act ##
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        assertHasAnyElement(memberList);
        boolean exists = false;
        for (Member member : memberList) {
            MemberAddress address = member.getMemberAddressAsValid();
            log(member.getMemberName(), address != null ? address.getAddress() : null);
            if (address != null) {
                if (address.getAddress() != null) {
                    exists = true;
                }
                assertNull(address.getValidBeginDate());
            }
        }
        assertTrue(exists);
    }

    public void test_BizOneToOne_SpecifyColumn_specifyOnceMore() {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.setupSelect_MemberAddressAsValid(currentDate());
        cb.specify().specifyMemberAddressAsValid(currentDate()).columnAddress();

        // ## Act ##
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        assertHasAnyElement(memberList);
        boolean exists = false;
        for (Member member : memberList) {
            MemberAddress address = member.getMemberAddressAsValid();
            log(member.getMemberName(), address != null ? address.getAddress() : null);
            if (address != null) {
                if (address.getAddress() != null) {
                    exists = true;
                }
                assertNull(address.getValidBeginDate());
            }
        }
        assertTrue(exists);
    }

    // ===================================================================================
    //                                                                         ColumnQuery
    //                                                                         ===========
    public void test_BizOneToOne_ColumnQuery_specifyEmpty() {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.columnQuery(new SpecifyQuery<MemberCB>() {
            public void specify(MemberCB cb) {
                cb.specify().columnBirthdate();
            }
        }).lessThan(new SpecifyQuery<MemberCB>() {
            public void specify(MemberCB cb) {
                cb.specify().specifyMemberAddressAsValid().columnValidBeginDate();
            }
        });

        // ## Act ##
        try {
            memberBhv.selectList(cb);
            // ## Assert ##
            fail();
        } catch (FixedConditionParameterNotFoundException e) {
            log(e.getMessage());
        }
    }
}
