package com.example.dbflute.spring.dbflute.whitebox.outsidesql;

import java.util.List;

import com.example.dbflute.spring.dbflute.exbhv.MemberBhv;
import com.example.dbflute.spring.dbflute.exbhv.pmbean.SubDirectoryCheckPmb;
import com.example.dbflute.spring.dbflute.exentity.customize.SubDirectoryCheck;
import com.example.dbflute.spring.unit.UnitContainerTestCase;

/**
 * @author jflute
 * @since 0.6.0 (2008/01/16 Wednesday)
 */
public class WxOutsideSqlSubDirTest extends UnitContainerTestCase {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private MemberBhv memberBhv;

    // ===================================================================================
    //                                                                               Basic
    //                                                                               =====
    public void test_outsideSql_subdir_basic() {
        // ## Arrange ##
        SubDirectoryCheckPmb pmb = new SubDirectoryCheckPmb();
        pmb.setMemberName_PrefixSearch("S");

        // ## Act ##
        List<SubDirectoryCheck> memberList = memberBhv.outsideSql().selectList(pmb);

        // ## Assert ##
        assertFalse(memberList.isEmpty());
        log("{SubDirectoryCheck}");
        for (SubDirectoryCheck entity : memberList) {
            Integer memberId = entity.getMemberId();
            String memberName = entity.getMemberName();
            assertNotNull(memberId);
            assertNotNull(memberName);
            assertTrue(memberName.startsWith("S"));
        }
    }
}
