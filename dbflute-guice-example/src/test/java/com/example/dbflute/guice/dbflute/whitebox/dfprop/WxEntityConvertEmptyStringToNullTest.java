package com.example.dbflute.guice.dbflute.whitebox.dfprop;

import java.lang.reflect.Field;

import org.seasar.dbflute.exception.SQLFailureException;
import org.seasar.dbflute.util.DfReflectionUtil;

import com.example.dbflute.guice.dbflute.exbhv.MemberBhv;
import com.example.dbflute.guice.dbflute.exentity.Member;
import com.example.dbflute.guice.unit.UnitContainerTestCase;

/**
 * @author jflute
 * @since 0.9.6.9 (2010/05/13 Thursday)
 */
public class WxEntityConvertEmptyStringToNullTest extends UnitContainerTestCase {

    private MemberBhv memberBhv;

    public void test_getter_filtered() {
        // ## Arrange ##
        Member member = new Member();
        member.setMemberName("");
        member.setMemberAccount(null);
        member.setRegisterUser(" ");

        // ## Act & Assert ##
        assertNull(member.getMemberName());
        assertNull(member.getMemberAccount());
        assertEquals(" ", member.getRegisterUser());
        assertNull(member.getUpdateUser());
        Field field = DfReflectionUtil.getAccessibleField(Member.class, "_memberName");
        field.setAccessible(true);
        assertEquals("", DfReflectionUtil.getValue(field, member));
    }

    public void test_update_filtered_emptyString() {
        // ## Arrange ##
        Member member = new Member();
        member.setMemberId(3);
        member.setMemberName("");

        // ## Act ##
        try {
            memberBhv.updateNonstrict(member);

            // ## Assert ##
            fail("should not allowed to update by null value");
        } catch (SQLFailureException e) {
            // OK
            log(e.getMessage());
        }
    }

    public void test_update_filtered_spaceString() {
        // ## Arrange ##
        Member member = new Member();
        member.setMemberId(3);
        member.setMemberName(" ");

        // ## Act ##
        memberBhv.updateNonstrict(member);

        // ## Assert ##
        Member actual = memberBhv.selectByPKValueWithDeletedCheck(3);
        assertEquals(" ", actual.getMemberName());
    }
}
