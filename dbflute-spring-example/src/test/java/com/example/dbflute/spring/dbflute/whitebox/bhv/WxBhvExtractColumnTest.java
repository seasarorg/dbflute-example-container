package com.example.dbflute.spring.dbflute.whitebox.bhv;

import java.util.ArrayList;
import java.util.List;

import com.example.dbflute.spring.dbflute.cbean.MemberCB;
import com.example.dbflute.spring.dbflute.exbhv.MemberBhv;
import com.example.dbflute.spring.dbflute.exentity.Member;
import com.example.dbflute.spring.unit.UnitContainerTestCase;

/**
 * @author jflute
 * @since 1.0.1 (2012/12/16 Sunday)
 */
public class WxBhvExtractColumnTest extends UnitContainerTestCase {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private MemberBhv memberBhv;

    // ===================================================================================
    //                                                                          PrimaryKey
    //                                                                          ==========
    public void test_extractPK_List_basic() {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.setupSelect_MemberStatus();
        List<Member> memberList = memberBhv.selectList(cb);

        // ## Act ##
        List<Integer> memberIdList = memberBhv.extractMemberIdList(memberList);

        // ## Assert ##
        assertHasAnyElement(memberIdList);
        log(memberIdList);
        List<Integer> expectedIdList = new ArrayList<Integer>();
        for (Member member : memberList) {
            expectedIdList.add(member.getMemberId());
        }
        assertEquals(expectedIdList, memberIdList);
    }

    public void test_extractUQ_List_basic() {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.setupSelect_MemberStatus();
        List<Member> memberList = memberBhv.selectList(cb);

        // ## Act ##
        List<String> accountList = memberBhv.extractMemberAccountList(memberList);

        // ## Assert ##
        assertHasAnyElement(accountList);
        log(accountList);
        List<String> expectedAccountList = new ArrayList<String>();
        for (Member member : memberList) {
            expectedAccountList.add(member.getMemberAccount());
        }
        assertEquals(expectedAccountList, accountList);
    }
}
