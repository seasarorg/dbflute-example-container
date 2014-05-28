package com.example.dbflute.spring.dbflute.whitebox.bhv;

import java.sql.Timestamp;

import org.seasar.dbflute.exception.EntityAlreadyDeletedException;

import com.example.dbflute.spring.dbflute.cbean.MemberCB;
import com.example.dbflute.spring.dbflute.exbhv.MemberBhv;
import com.example.dbflute.spring.dbflute.exbhv.MemberStatusBhv;
import com.example.dbflute.spring.dbflute.exbhv.PurchaseBhv;
import com.example.dbflute.spring.dbflute.exentity.Member;
import com.example.dbflute.spring.dbflute.exentity.MemberStatus;
import com.example.dbflute.spring.dbflute.exentity.Purchase;
import com.example.dbflute.spring.unit.UnitContainerTestCase;

/**
 * @author jflute
 * @since 0.6.0 (2008/01/16 Wednesday)
 */
public class WxBhvEntityDeleteTest extends UnitContainerTestCase {

    private MemberBhv memberBhv;
    private MemberStatusBhv memberStatusBhv;
    private PurchaseBhv purchaseBhv;

    // ===================================================================================
    //                                                                               Basic
    //                                                                               =====
    public void test_delete() {
        // ## Arrange ##
        deleteMemberReferrer();

        Member beforeMember = memberBhv.selectByPKValueWithDeletedCheck(3);
        Long versionNo = beforeMember.getVersionNo();

        Member member = new Member();
        member.setMemberId(3);
        member.setVersionNo(versionNo);

        // ## Act ##
        memberBhv.delete(member);

        // ## Assert ##
        try {
            memberBhv.selectByPKValueWithDeletedCheck(3);
            fail();
        } catch (EntityAlreadyDeletedException e) {
            // OK
            log(e.getMessage());
        }
    }

    public void test_deleteNonstrict() {
        // ## Arrange ##
        deleteMemberReferrer();

        Member member = new Member();
        member.setMemberId(3);

        // ## Act ##
        memberBhv.deleteNonstrict(member);

        // ## Assert ##
        try {
            memberBhv.selectByPKValueWithDeletedCheck(3);
            fail();
        } catch (EntityAlreadyDeletedException e) {
            // OK
            log(e.getMessage());
        }
    }

    public void test_deleteNonstrictIgnoreDeleted() {
        // ## Arrange ##
        Member member = new Member();
        member.setMemberId(99999);

        // ## Act ##
        memberBhv.deleteNonstrictIgnoreDeleted(member);

        // ## Assert ##
        try {
            memberBhv.selectByPKValueWithDeletedCheck(99999);
            fail();
        } catch (EntityAlreadyDeletedException e) {
            // OK
            log(e.getMessage());
        }
    }

    public void test_delete_nonOptimisticLockTable_deleted() throws Exception {
        // ## Arrange ##
        MemberStatus memberStatus = new MemberStatus();
        memberStatus.setMemberStatusCode("NON");

        // ## Act ##
        try {
            memberStatusBhv.delete(memberStatus);

            // ## Assert ##
            fail();
        } catch (EntityAlreadyDeletedException e) {
            // OK
            log(e.getMessage());
        }
    }

    // ===================================================================================
    //                                                                           Unique By
    //                                                                           =========
    public void test_delete_uniqueBy_simpleKey_basic() throws Exception {
        // ## Arrange ##
        deleteMemberReferrer();
        String memberAccount = "Pixy";
        Member before = selectByAccount(memberAccount);
        Member member = new Member();
        member.uniqueBy(memberAccount);
        member.setMemberName("UniqueBy");
        member.setVersionNo(before.getVersionNo());

        // ## Act ##
        memberBhv.delete(member);

        // ## Assert ##
        try {
            selectByAccount(memberAccount);
            fail();
        } catch (EntityAlreadyDeletedException e) {
            log(e.getMessage());
        }
    }

    protected Member selectByAccount(String account) {
        MemberCB cb = new MemberCB();
        cb.query().setMemberAccount_Equal(account);
        return memberBhv.selectEntityWithDeletedCheck(cb);
    }

    public void test_delete_uniqueBy_compoundKey_basic() throws Exception {
        // ## Arrange ##
        Purchase before = purchaseBhv.selectByPKValueWithDeletedCheck(3L);
        Purchase purchase = new Purchase();
        purchase.setPurchaseId(99999L); // dummy
        Integer memberId = before.getMemberId();
        Integer productId = before.getProductId();
        Timestamp purchaseDatetime = before.getPurchaseDatetime();
        purchase.uniqueBy(memberId, productId, purchaseDatetime);
        purchase.setPurchaseCount(123456789);
        purchase.setVersionNo(before.getVersionNo());

        // ## Act ##
        purchaseBhv.delete(purchase);

        // ## Assert ##
        try {
            purchaseBhv.selectByPKValueWithDeletedCheck(3L);
            fail();
        } catch (EntityAlreadyDeletedException e) {
            log(e.getMessage());
        }
    }

    public void test_deleteNonstrict_uniqueBy_compoundKey_basic() throws Exception {
        // ## Arrange ##
        Purchase before = purchaseBhv.selectByPKValueWithDeletedCheck(3L);
        Purchase purchase = new Purchase();
        purchase.setPurchaseId(99999L); // dummy
        Integer memberId = before.getMemberId();
        Integer productId = before.getProductId();
        Timestamp purchaseDatetime = before.getPurchaseDatetime();
        purchase.uniqueBy(memberId, productId, purchaseDatetime);
        purchase.setPurchaseCount(123456789);

        // ## Act ##
        purchaseBhv.deleteNonstrict(purchase);

        // ## Assert ##
        try {
            purchaseBhv.selectByPKValueWithDeletedCheck(3L);
            fail();
        } catch (EntityAlreadyDeletedException e) {
            log(e.getMessage());
        }
    }
}
