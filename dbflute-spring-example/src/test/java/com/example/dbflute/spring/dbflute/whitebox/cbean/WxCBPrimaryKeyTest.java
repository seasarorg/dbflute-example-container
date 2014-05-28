package com.example.dbflute.spring.dbflute.whitebox.cbean;

import com.example.dbflute.spring.dbflute.cbean.MemberCB;
import com.example.dbflute.spring.dbflute.exbhv.MemberBhv;
import com.example.dbflute.spring.dbflute.exentity.Member;
import com.example.dbflute.spring.unit.UnitContainerTestCase;

/**
 * @author jflute
 */
public class WxCBPrimaryKeyTest extends UnitContainerTestCase {

    private MemberBhv memberBhv;

    // ===================================================================================
    //                                                                  acceptPrimaryKey()
    //                                                                  ==================
    public void test_acceptPrimaryKey() {
        // ## Arrange ##
        MemberCB cb = new MemberCB();

        // ## Act ##
        cb.acceptPrimaryKey(3);

        // ## Assert ##
        assertEquals(3, cb.query().getMemberId().getFixedQuery().get("equal"));
    }

    // ===================================================================================
    //                                                                    acceptUniqueOf()
    //                                                                    ================
    public void test_acceptUniqueOf_basic() {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.acceptUniqueOf("Pixy");

        // ## Act ##
        Member member = memberBhv.selectEntityWithDeletedCheck(cb);

        // ## Assert ##
        assertEquals("Pixy", member.getMemberAccount());
    }

    public void test_acceptUniqueOf_null() {
        // ## Arrange ##
        MemberCB cb = new MemberCB();

        // ## Act ##
        try {
            cb.acceptUniqueOf(null);
            // ## Assert ##
            fail();
        } catch (IllegalArgumentException e) {
            log(e.getMessage());
        }
    }
}
