package com.example.dbflute.spring.dbflute.whitebox.outsidesql;

import java.util.List;
import java.util.Map;

import org.seasar.dbflute.outsidesql.irregular.IrgMapListCursorHandler;

import com.example.dbflute.spring.dbflute.bsentity.dbmeta.MemberDbm;
import com.example.dbflute.spring.dbflute.exbhv.MemberBhv;
import com.example.dbflute.spring.dbflute.exbhv.pmbean.SimpleMemberPmb;
import com.example.dbflute.spring.unit.UnitContainerTestCase;

/**
 * @author jflute
 * @since 1.0.5F (2014/05/12 Monday)
 */
public class WxOutsideSqlIrregularTest extends UnitContainerTestCase {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private MemberBhv memberBhv;

    // ===================================================================================
    //                                                                  Insert with Cursor
    //                                                                  ==================
    public void test_IrgMapListCursorHandler_basic() throws Exception {
        // ## Arrange ##
        String path = MemberBhv.PATH_selectSimpleMember;
        SimpleMemberPmb pmb = new SimpleMemberPmb();
        pmb.setMemberName_PrefixSearch("S");

        // ## Act ##
        @SuppressWarnings("unchecked")
        List<Map<String, Object>> resultList = (List<Map<String, Object>>) memberBhv.outsideSql().cursorHandling()
                .selectCursor(path, pmb, new IrgMapListCursorHandler());

        // ## Assert ##
        assertHasAnyElement(resultList);
        for (Map<String, Object> resultMap : resultList) {
            log(resultMap);
            String memberName = (String) resultMap.get(MemberDbm.getInstance().columnMemberName().getColumnDbName());
            assertTrue(memberName.startsWith("S"));
        }
    }
}
