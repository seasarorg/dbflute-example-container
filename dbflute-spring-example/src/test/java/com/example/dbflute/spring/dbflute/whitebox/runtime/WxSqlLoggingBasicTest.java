package com.example.dbflute.spring.dbflute.whitebox.runtime;

import java.util.HashSet;
import java.util.Set;

import org.seasar.dbflute.CallbackContext;
import org.seasar.dbflute.cbean.PagingResultBean;
import org.seasar.dbflute.jdbc.SqlLogHandler;
import org.seasar.dbflute.jdbc.SqlLogInfo;
import org.seasar.dbflute.util.DfCollectionUtil;
import org.seasar.dbflute.util.Srl;

import com.example.dbflute.spring.dbflute.exbhv.MemberBhv;
import com.example.dbflute.spring.dbflute.exbhv.pmbean.PurchaseMaxPriceMemberPmb;
import com.example.dbflute.spring.dbflute.exentity.customize.PurchaseMaxPriceMember;
import com.example.dbflute.spring.unit.UnitContainerTestCase;

/**
 * @author jflute
 * @since 0.9.5 (2009/04/08 Wednesday)
 */
public class WxSqlLoggingBasicTest extends UnitContainerTestCase {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private MemberBhv memberBhv;

    // ===================================================================================
    //                                                                          DisplaySql
    //                                                                          ==========
    public void test_outsideSql_displaySql() {
        // ## Arrange ##
        PurchaseMaxPriceMemberPmb pmb = new PurchaseMaxPriceMemberPmb();
        pmb.setMemberNameList_PrefixSearch(DfCollectionUtil.newArrayList("S", "M"));
        final Set<String> displaySqlSet = new HashSet<String>();
        int pageSize = 3;
        pmb.paging(pageSize, 1); // 1st page
        CallbackContext.setSqlLogHandlerOnThread(new SqlLogHandler() {
            public void handle(SqlLogInfo info) {
                displaySqlSet.add(info.getDisplaySql());
            }
        });

        // ## Act ##
        try {
            PagingResultBean<PurchaseMaxPriceMember> page1 = memberBhv.outsideSql().manualPaging().selectPage(pmb);

            // ## Assert ##
            assertNotSame(0, page1.size());
            for (PurchaseMaxPriceMember member : page1) {
                log(member);
                String memberName = member.getMemberName();

                if (!memberName.contains("S") && !memberName.contains("M")) {
                    fail("memberName should have S or M: " + memberName);
                }
            }
            assertEquals(2, displaySqlSet.size());
            for (String displaySql : displaySqlSet) {
                assertTrue(Srl.containsAll(displaySql, "'S%'", "'M%'"));
            }
        } finally {
            CallbackContext.clearSqlLogHandlerOnThread();
            assertFalse(CallbackContext.isExistBehaviorCommandHookOnThread());
            assertFalse(CallbackContext.isExistSqlLogHandlerOnThread());
            assertFalse(CallbackContext.isExistSqlResultHandlerOnThread());
            assertFalse(CallbackContext.isExistCallbackContextOnThread());
        }
    }
}
