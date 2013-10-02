package com.example.dbflute.spring.dbflute.whitebox.bhv;

import org.seasar.dbflute.exception.EntityAlreadyDeletedException;

import com.example.dbflute.spring.dbflute.exbhv.MemberBhv;
import com.example.dbflute.spring.dbflute.exbhv.MemberStatusBhv;
import com.example.dbflute.spring.dbflute.exentity.Member;
import com.example.dbflute.spring.dbflute.exentity.MemberStatus;
import com.example.dbflute.spring.unit.UnitContainerTestCase;

/**
 * @author jflute
 * @since 0.6.0 (2008/01/16 Wednesday)
 */
public class WxBhvEntityDeleteTest extends UnitContainerTestCase {

    private MemberBhv memberBhv;
    private MemberStatusBhv memberStatusBhv;

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
}
