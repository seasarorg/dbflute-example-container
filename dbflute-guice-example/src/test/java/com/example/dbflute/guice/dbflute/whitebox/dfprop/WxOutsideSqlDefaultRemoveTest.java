package com.example.dbflute.guice.dbflute.whitebox.dfprop;

import java.util.ArrayList;
import java.util.List;

import org.seasar.dbflute.CallbackContext;
import org.seasar.dbflute.jdbc.SqlLogHandler;
import org.seasar.dbflute.jdbc.SqlLogInfo;

import com.example.dbflute.guice.dbflute.exbhv.MemberBhv;
import com.example.dbflute.guice.dbflute.exbhv.pmbean.PmCommentHintPmb;
import com.example.dbflute.guice.unit.UnitContainerTestCase;

/**
 * @author jflute
 * @since 1.0.4A (2013/03/21 Thursday)
 */
public class WxOutsideSqlDefaultRemoveTest extends UnitContainerTestCase {

    private MemberBhv memberBhv;

    // ===================================================================================
    //                                                                                Hint
    //                                                                                ====
    public void test_Hint_basic() throws Exception {
        // ## Arrange ##
        PmCommentHintPmb pmb = new PmCommentHintPmb();
        final List<SqlLogInfo> infoList = new ArrayList<SqlLogInfo>();
        CallbackContext.setSqlLogHandlerOnThread(new SqlLogHandler() {
            public void handle(SqlLogInfo info) {
                infoList.add(info);
            }
        });

        // ## Act ##
        try {
            memberBhv.outsideSql().selectList(pmb);

            // ## Assert ##
            assertEquals(1, infoList.size());
            String executedSql = infoList.get(0).getExecutedSql();
            assertFalse(executedSql.contains("/*! MySQL*/"));
            assertFalse(executedSql.contains("/*+ Oracle*/"));
            assertFalse(executedSql.contains("--+ OracleLine"));
        } finally {
            CallbackContext.clearSqlLogHandlerOnThread();
        }
    }
}
