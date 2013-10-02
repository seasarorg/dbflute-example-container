package com.example.dbflute.spring.dbflute.whitebox.bhv;

import org.seasar.dbflute.Entity;
import org.seasar.dbflute.bhv.UpdateOption;
import org.seasar.dbflute.cbean.SpecifyQuery;

import com.example.dbflute.spring.dbflute.cbean.MemberCB;
import com.example.dbflute.spring.dbflute.exbhv.MemberBhv;
import com.example.dbflute.spring.dbflute.exentity.Member;
import com.example.dbflute.spring.unit.UnitContainerTestCase;

/**
 * @author jflute
 */
public class WxBhvInterfaceDispatchTest extends UnitContainerTestCase {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private MemberBhv memberBhv;

    // ===================================================================================
    //                                                                       Entity Select
    //                                                                       =============
    public void test_readEntity_basic() {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.query().setMemberId_Equal(3);

        // ## Act ##
        Entity entity = memberBhv.readEntity(cb);

        // ## Assert ##
        assertNotNull(entity);
    }

    // ===================================================================================
    //                                                                       Entity Update
    //                                                                       =============
    public void test_create_basic() {
        // ## Arrange ##
        Member member = new Member();
        member.setMemberName("foo");
        member.setMemberAccount("bar");
        member.setMemberStatusCode_Formalized();

        // ## Act ##
        memberBhv.create(member, null);

        // ## Assert ##
        Member actual = memberBhv.selectByPKValueWithDeletedCheck(member.getMemberId());
        assertEquals("foo", actual.getMemberName());
    }

    public void test_modify_basic() {
        // ## Arrange ##
        Member member = memberBhv.selectByPKValueWithDeletedCheck(3);
        member.setMemberName("foo");

        // ## Act ##
        memberBhv.modify(member, null);

        // ## Assert ##
        Member actual = memberBhv.selectByPKValueWithDeletedCheck(member.getMemberId());
        assertEquals("foo", actual.getMemberName());
    }

    public void test_modifyNonstrict_basic() {
        // ## Arrange ##
        Member member = new Member();
        member.setMemberId(3);
        member.setMemberName("foo");
        member.setMemberAccount("bar");
        member.setMemberStatusCode_Formalized();

        // ## Act ##
        memberBhv.modifyNonstrict(member, null);

        // ## Assert ##
        Member actual = memberBhv.selectByPKValueWithDeletedCheck(member.getMemberId());
        assertEquals("foo", actual.getMemberName());
        assertEquals("bar", actual.getMemberAccount());
    }

    public void test_modifyNonstrict_specify() {
        // ## Arrange ##
        Member member = memberBhv.selectByPKValueWithDeletedCheck(3);
        member.setMemberName("foo");
        String preAccount = member.getMemberAccount();
        member.setMemberAccount("bar");
        member.setVersionNo(null);
        UpdateOption<MemberCB> option = new UpdateOption<MemberCB>();
        option.specify(new SpecifyQuery<MemberCB>() {
            public void specify(MemberCB cb) {
                cb.specify().columnMemberName();
            }
        });

        // ## Act ##
        memberBhv.modifyNonstrict(member, option);

        // ## Assert ##
        Member actual = memberBhv.selectByPKValueWithDeletedCheck(member.getMemberId());
        assertEquals("foo", actual.getMemberName());
        assertEquals(preAccount, actual.getMemberAccount());
    }

    public void test_createOrModify_basic() {
        // ## Arrange ##
        Member member = new Member();
        member.setMemberName("foo");
        member.setMemberAccount("bar");
        member.setMemberStatusCode_Formalized();

        // ## Act ##
        memberBhv.createOrModify(member, null, null);

        // ## Assert ##
        {
            Member actual = memberBhv.selectByPKValueWithDeletedCheck(member.getMemberId());
            assertEquals("foo", actual.getMemberName());
        }

        // ## Act ##
        member.setMemberName("qux");
        memberBhv.createOrModify(member, null, null);

        // ## Assert ##
        {
            Member actual = memberBhv.selectByPKValueWithDeletedCheck(member.getMemberId());
            assertEquals("qux", actual.getMemberName());
        }
    }

    public void test_createOrModifyNonstrict_basic() {
        // ## Arrange ##
        Member member = new Member();
        member.setMemberName("foo");
        member.setMemberAccount("bar");
        member.setMemberStatusCode_Formalized();

        // ## Act ##
        memberBhv.createOrModifyNonstrict(member, null, null);

        // ## Assert ##
        {
            Member actual = memberBhv.selectByPKValueWithDeletedCheck(member.getMemberId());
            assertEquals("foo", actual.getMemberName());
        }

        // ## Act ##
        member.setMemberName("qux");
        member.setVersionNo(null);
        memberBhv.createOrModifyNonstrict(member, null, null);

        // ## Assert ##
        {
            Member actual = memberBhv.selectByPKValueWithDeletedCheck(member.getMemberId());
            assertEquals("qux", actual.getMemberName());
        }
    }

    public void test_createOrModifyNonstrict_specify() {
        // ## Arrange ##
        Member member = memberBhv.selectByPKValueWithDeletedCheck(3);
        member.setMemberName("foo");
        String preAccount = member.getMemberAccount();
        member.setMemberAccount("bar");
        member.setMemberStatusCode_Formalized();
        UpdateOption<MemberCB> option = new UpdateOption<MemberCB>();
        option.specify(new SpecifyQuery<MemberCB>() {
            public void specify(MemberCB cb) {
                cb.specify().columnMemberName();
            }
        });

        // ## Act ##
        memberBhv.createOrModifyNonstrict(member, null, option);

        // ## Assert ##
        {
            Member actual = memberBhv.selectByPKValueWithDeletedCheck(member.getMemberId());
            assertEquals("foo", actual.getMemberName());
            assertEquals(preAccount, actual.getMemberAccount());
        }
    }
}
