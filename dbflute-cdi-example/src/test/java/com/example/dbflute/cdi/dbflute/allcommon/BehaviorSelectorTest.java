package com.example.dbflute.cdi.dbflute.allcommon;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;
import org.seasar.dbflute.BehaviorSelector;
import org.seasar.dbflute.Entity;
import org.seasar.dbflute.bhv.BehaviorReadable;
import org.seasar.dbflute.bhv.core.BehaviorCommandInvoker;
import org.seasar.dbflute.cbean.ConditionBean;
import org.seasar.dbflute.cbean.ListResultBean;
import org.seasar.dbflute.dbmeta.DBMeta;
import org.seasar.junitcdi.jta.Transactional;

import com.example.dbflute.cdi.dbflute.bsentity.dbmeta.MemberDbm;
import com.example.dbflute.cdi.dbflute.cbean.MemberCB;
import com.example.dbflute.cdi.dbflute.exbhv.MemberBhv;
import com.example.dbflute.cdi.dbflute.exentity.Member;
import com.example.dbflute.cdi.unit.ContainerTestCase;

/**
 * The test of behaviorSelector.
 * @author jflute
 * @since 0.5.8 (2007/11/28 Wednesday)
 */
public class BehaviorSelectorTest extends ContainerTestCase {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    @Inject
    private BehaviorSelector behaviorSelector;
    @Inject
    private MemberBhv memberBhv;
    @Inject
    private BehaviorCommandInvoker invoker;
    @Inject
    private ImplementedInvokerAssistant invokerAssistant;

    // ===================================================================================
    //                                                                          Initialize
    //                                                                          ==========
    @Test
    @Transactional
    public void test_BehaviorSelector_initializeConditionBeanMetaData_Tx() {
        // ## Arrange ##
        assertTrue(this.invoker.isExecutionCacheEmpty());
        assertFalse(this.invokerAssistant.isDisposable());

        // ## Act ##
        this.behaviorSelector.initializeConditionBeanMetaData();

        // ## Assert ##
        assertFalse(this.invoker.isExecutionCacheEmpty());
        assertFalse(this.invokerAssistant.isDisposable());
    }

    // ===================================================================================
    //                                                                              byName
    //                                                                              ======
    /**
     * テーブル名からBehaviorを取得して、テーブルのプロパティ名を取得する。
     */
    @Test
    @Transactional
    public void test_BehaviorSelector_byName_and_getTablePropertyName_Tx() {
        // ## Arrange ##
        final String tableDbName = "MEMBER";

        // ## Act ##
        final BehaviorReadable bhv = this.behaviorSelector.byName(tableDbName);
        final DBMeta dbmeta = bhv.getDBMeta();
        final String tablePropertyName = dbmeta.getTablePropertyName();

        // ## Assert ##
        assertNotNull(tablePropertyName);
        this.log("/********************************");
        this.log("tablePropertyName=" + tablePropertyName);
        this.log("**********/");
        assertNotNull(MemberDbm.getInstance().getTablePropertyName(), tablePropertyName);
    }

    /**
     * テーブル名からBehaviorを取得して、ConditionBeanを生成して(条件なし)、件数を検索する。
     */
    @Test
    @Transactional
    public void test_BehaviorSelector_byName_and_readCount_Tx() {
        // ## Arrange ##
        final String tableDbName = "MEMBER";

        // ## Act ##
        final BehaviorReadable bhv = this.behaviorSelector.byName(tableDbName);
        final ConditionBean cb = bhv.newConditionBean();
        final int count = bhv.readCount(cb);

        // ## Assert ##
        this.log("/********************************");
        this.log("count=" + count);
        this.log("**********/");
        assertEquals(this.memberBhv.selectCount(new MemberCB()), count);
    }

    /**
     * テーブル名からBehaviorを取得して、ConditionBeanを生成して(ソート条件のみ)、リストを検索する。
     */
    @Test
    @Transactional
    public void test_BehaviorSelector_byName_and_readList_Tx() {
        // ## Arrange ##
        final String tableDbName = "MEMBER";

        // ## Act ##
        final BehaviorReadable bhv = this.behaviorSelector.byName(tableDbName);
        final ConditionBean cb = bhv.newConditionBean();
        cb.addOrderBy_PK_Desc();
        final ListResultBean<? extends Entity> entityList = bhv.readList(cb);

        // ## Assert ##
        assertNotNull(entityList);
        this.log("/********************************");
        for (final Entity entity : entityList) {
            this.log("entity=" + entity);
        }
        this.log("**********/");
        final MemberCB expectedCB = new MemberCB();
        expectedCB.addOrderBy_PK_Desc();
        final ListResultBean<Member> expectedList = this.memberBhv.selectList(expectedCB);
        assertEquals(expectedList, entityList);
    }
}
