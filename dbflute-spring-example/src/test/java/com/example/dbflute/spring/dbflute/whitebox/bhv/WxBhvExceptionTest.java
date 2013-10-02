package com.example.dbflute.spring.dbflute.whitebox.bhv;

import org.seasar.dbflute.exception.EntityPrimaryKeyNotFoundException;

import com.example.dbflute.spring.dbflute.exbhv.MemberBhv;
import com.example.dbflute.spring.dbflute.exentity.Member;
import com.example.dbflute.spring.unit.UnitContainerTestCase;

/**
 * @author jflute
 * @since 0.9.9.1F (2011/11/05 Saturday)
 */
public class WxBhvExceptionTest extends UnitContainerTestCase {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private MemberBhv memberBhv;

    // ===================================================================================
    //                                                                      Not PrimaryKey
    //                                                                      ==============
    public void test_updateNonstrict_PrimarykeyNotFound() {
        // ## Arrange ##
        Member member = new Member();
        member.setMemberName("Pixy");

        // ## Act ##
        try {
            memberBhv.updateNonstrict(member);

            // ## Assert ##
            fail();
        } catch (EntityPrimaryKeyNotFoundException e) {
            // OK
            log(e.getMessage());
        }
    }
}
