package com.example.dbflute.spring.dbflute.whitebox.cbean.derivedreferrer;

import java.util.Date;

import org.seasar.dbflute.cbean.ListResultBean;
import org.seasar.dbflute.cbean.SubQuery;
import org.seasar.dbflute.cbean.coption.DerivedReferrerOption;
import org.seasar.dbflute.util.DfTypeUtil;

import com.example.dbflute.spring.dbflute.cbean.MemberCB;
import com.example.dbflute.spring.dbflute.cbean.MemberLoginCB;
import com.example.dbflute.spring.dbflute.exbhv.MemberBhv;
import com.example.dbflute.spring.dbflute.exentity.Member;
import com.example.dbflute.spring.unit.UnitContainerTestCase;

/**
 * @author jflute
 * @since 0.6.0 (2008/01/16 Wednesday)
 */
public class WxCBDerivedReferrerOptionTest extends UnitContainerTestCase {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private MemberBhv memberBhv;

    // ===================================================================================
    //                                                                          coalesce()
    //                                                                          ==========
    public void test_sepcify_derivedReferrer_option_coalesce() throws Exception {
        // ## Arrange ##
        int countAll;
        {
            MemberCB cb = new MemberCB();
            countAll = memberBhv.selectCount(cb);
        }
        {
            MemberCB cb = new MemberCB();
            cb.query().derivedMemberLoginList().max(new SubQuery<MemberLoginCB>() {
                public void query(MemberLoginCB subCB) {
                    subCB.specify().columnLoginDatetime();
                }
            }).isNull();
            memberBhv.selectEntityWithDeletedCheck(cb); // expect no exception
        }
        MemberCB cb = new MemberCB();
        cb.specify().derivedMemberLoginList().max(new SubQuery<MemberLoginCB>() {
            public void query(MemberLoginCB subCB) {
                subCB.specify().columnLoginDatetime();
            }
        }, Member.ALIAS_latestLoginDatetime, new DerivedReferrerOption().coalesce("1192-01-01"));

        // ## Act ##
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        assertFalse(memberList.isEmpty());
        assertEquals(countAll, memberList.size());
        boolean exists = false;
        for (Member member : memberList) {
            Date latestLoginDatetime = member.getLatestLoginDatetime();
            String loginDateView = DfTypeUtil.toString(latestLoginDatetime, "yyyy-MM-dd");
            log(member.getMemberName() + ":" + loginDateView);
            if ("1192-01-01".equals(loginDateView)) {
                exists = true;
            }
        }
        assertTrue(exists);
    }

    public void test_sepcify_derivedReferrer_option_sqlInjection() throws Exception {
        // ## Arrange ##
        int countAll;
        {
            MemberCB cb = new MemberCB();
            countAll = memberBhv.selectCount(cb);
        }
        {
            MemberCB cb = new MemberCB();
            cb.query().derivedMemberLoginList().max(new SubQuery<MemberLoginCB>() {
                public void query(MemberLoginCB subCB) {
                    subCB.specify().columnLoginDatetime();
                }
            }).isNull();
            memberBhv.selectEntityWithDeletedCheck(cb); // expect no exception
        }
        String coalesce = "foo')); select * from MEMBER";
        MemberCB cb = new MemberCB();
        cb.specify().derivedMemberLoginList().count(new SubQuery<MemberLoginCB>() {
            public void query(MemberLoginCB subCB) {
                subCB.specify().columnLoginMemberStatusCode();
            }
        }, Member.ALIAS_loginCount, new DerivedReferrerOption().coalesce(coalesce));

        // ## Act ##
        // expect no exception if the value is treated as bind-parameter
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        assertFalse(memberList.isEmpty());
        assertEquals(countAll, memberList.size());
        for (Member member : memberList) {
            Integer loginCount = member.getLoginCount();
            log(member.getMemberName() + ":" + loginCount);
        }
    }
}
