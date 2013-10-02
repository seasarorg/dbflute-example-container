package com.example.dbflute.spring.dbflute.whitebox.entity;

import org.seasar.dbflute.unit.core.PlainTestCase;

import com.example.dbflute.spring.dbflute.allcommon.CDef;
import com.example.dbflute.spring.dbflute.exentity.Member;
import com.example.dbflute.spring.dbflute.exentity.MemberLogin;

/**
 * @author jflute
 * @since 0.9.5 (2009/04/08 Wednesday)
 */
public class WxEntityClassificationTest extends PlainTestCase {

    // ===================================================================================
    //                                                                             Setting
    //                                                                             =======
    public void test_setting_basic() {
        // ## Arrange ##
        Member member = new Member();

        // ## Act & Assert ##
        member.setMemberStatusCode_Formalized();
        assertTrue(member.isMemberStatusCodeFormalized());
        member.setMemberStatusCode_Withdrawal();
        assertTrue(member.isMemberStatusCodeWithdrawal());
        member.setMemberStatusCodeAsMemberStatus(CDef.MemberStatus.Provisional);
        assertTrue(member.isMemberStatusCodeProvisional());
        member.setMemberStatusCodeAsMemberStatus(null);
        assertFalse(member.isMemberStatusCodeProvisional());
        assertNull(member.getMemberStatusCode());
    }

    public void test_setting_sisters() {
        // ## Arrange ##
        MemberLogin login = new MemberLogin();

        // ## Act & Assert ##
        login.setMobileLoginFlgAsBoolean(true);
        assertTrue(login.isMobileLoginFlgTrue());
        assertEquals(1, login.getMobileLoginFlg());

        login.setMobileLoginFlgAsBoolean(false);
        assertTrue(login.isMobileLoginFlgFalse());
        assertEquals(0, login.getMobileLoginFlg());

        login.setMobileLoginFlgAsBoolean(null);
        assertNull(login.getMobileLoginFlg());

        login.setMobileLoginFlg_True();
        assertTrue(login.isMobileLoginFlgTrue());
        assertEquals(1, login.getMobileLoginFlg());
    }
}
