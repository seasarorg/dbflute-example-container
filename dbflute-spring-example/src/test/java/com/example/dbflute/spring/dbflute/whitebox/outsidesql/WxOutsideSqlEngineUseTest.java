package com.example.dbflute.spring.dbflute.whitebox.outsidesql;

import org.seasar.dbflute.bhv.core.BehaviorCommandInvoker;
import org.seasar.dbflute.cbean.ListResultBean;
import org.seasar.dbflute.outsidesql.executor.OutsideSqlBasicExecutor;

import com.example.dbflute.spring.dbflute.exbhv.pmbean.SimpleMemberPmb;
import com.example.dbflute.spring.dbflute.exentity.customize.SimpleMember;
import com.example.dbflute.spring.unit.UnitContainerTestCase;

/**
 * @author jflute
 * @since 1.0.5L (2014/09/13 Saturday)
 */
public class WxOutsideSqlEngineUseTest extends UnitContainerTestCase {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private BehaviorCommandInvoker behaviorCommandInvoker;

    // ===================================================================================
    //                                                                          DummyTable
    //                                                                          ==========
    public void test_OutsideSql_dummyTableExecution() throws Exception {
        // ## Arrange ##
        OutsideSqlBasicExecutor<Object> executor = behaviorCommandInvoker.createOutsideSqlBasicExecutor("sea");
        String path = "com/example/dbflute/spring/dbflute/exbhv/MemberBhv_selectSimpleMember.sql";
        SimpleMemberPmb pmb = new SimpleMemberPmb();
        Class<SimpleMember> entityType = SimpleMember.class;

        // ## Act ##
        ListResultBean<SimpleMember> memberList = executor.selectList(path, pmb, entityType);

        // ## Assert ##
        assertHasAnyElement(memberList);
        for (SimpleMember member : memberList) {
            log(member.getMemberName());
        }
    }
}
