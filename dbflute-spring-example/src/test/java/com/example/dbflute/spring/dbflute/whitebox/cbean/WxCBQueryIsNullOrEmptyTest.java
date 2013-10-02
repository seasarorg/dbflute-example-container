package com.example.dbflute.spring.dbflute.whitebox.cbean;

import org.seasar.dbflute.cbean.ListResultBean;

import com.example.dbflute.spring.dbflute.cbean.MemberWithdrawalCB;
import com.example.dbflute.spring.dbflute.exbhv.MemberWithdrawalBhv;
import com.example.dbflute.spring.dbflute.exentity.MemberWithdrawal;
import com.example.dbflute.spring.unit.UnitContainerTestCase;

/**
 * @author jflute
 * @since 0.9.9.0A (2011/07/29 Friday)
 */
public class WxCBQueryIsNullOrEmptyTest extends UnitContainerTestCase {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private MemberWithdrawalBhv memberWithdrawalBhv;

    // ===================================================================================
    //                                                                               Basic
    //                                                                               =====
    public void test_isNullOrEmpty_basic() {
        // ## Arrange ##
        {
            MemberWithdrawalCB cb = new MemberWithdrawalCB();
            cb.query().setWithdrawalReasonInputText_IsNull();
            cb.fetchFirst(1);
            MemberWithdrawal before = memberWithdrawalBhv.selectEntityWithDeletedCheck(cb);
            before.setWithdrawalReasonInputText("");
            memberWithdrawalBhv.updateNonstrict(before);
        }
        {
            MemberWithdrawalCB cb = new MemberWithdrawalCB();
            cb.query().setWithdrawalReasonInputText_IsNotNull();
            cb.fetchFirst(1);
            MemberWithdrawal before = memberWithdrawalBhv.selectEntityWithDeletedCheck(cb);
            before.setWithdrawalReasonInputText(null);
            memberWithdrawalBhv.updateNonstrict(before);
        }
        MemberWithdrawalCB cb = new MemberWithdrawalCB();
        cb.query().setWithdrawalReasonInputText_IsNullOrEmpty();

        // ## Act ##
        ListResultBean<MemberWithdrawal> withdrawalList = memberWithdrawalBhv.selectList(cb);

        // ## Assert ##
        assertFalse(withdrawalList.isEmpty());
        boolean existsEmpty = false;
        boolean existsNull = false;
        for (MemberWithdrawal withdrawal : withdrawalList) {
            String inputText = withdrawal.getWithdrawalReasonInputText();
            if (inputText != null && inputText.equals("")) {
                existsEmpty = true;
            } else {
                assertNull(inputText);
                existsNull = true;
            }
            log(withdrawal);
        }
        assertTrue(existsEmpty);
        assertTrue(existsNull);
    }
}
