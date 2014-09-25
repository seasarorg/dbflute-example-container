package com.example.dbflute.spring.unit;

import org.seasar.dbflute.BehaviorSelector;
import org.seasar.dbflute.bhv.BehaviorWritable;
import org.seasar.dbflute.bhv.DeleteOption;
import org.seasar.dbflute.cbean.ConditionBean;
import org.seasar.dbflute.unit.spring.ContainerTestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.dbflute.spring.JdbcBeansJavaConfig;
import com.example.dbflute.spring.dbflute.allcommon.DBFluteBeansJavaConfig;
import com.example.dbflute.spring.dbflute.exbhv.MemberAddressBhv;
import com.example.dbflute.spring.dbflute.exbhv.MemberFollowingBhv;
import com.example.dbflute.spring.dbflute.exbhv.MemberLoginBhv;
import com.example.dbflute.spring.dbflute.exbhv.MemberSecurityBhv;
import com.example.dbflute.spring.dbflute.exbhv.MemberServiceBhv;
import com.example.dbflute.spring.dbflute.exbhv.MemberWithdrawalBhv;
import com.example.dbflute.spring.dbflute.exbhv.PurchaseBhv;
import com.example.dbflute.spring.dbflute.exbhv.PurchasePaymentBhv;

/**
 * The test case with container for unit test.
 * @author jflute
 * @since 0.6.3 (2008/02/02 Saturday)
 */
public abstract class UnitContainerTestCase extends ContainerTestCase {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private BehaviorSelector _behaviorSelector;

    // ===================================================================================
    //                                                                             Prepare
    //                                                                             =======
    @Override
    protected ApplicationContext provideDefaultApplicationContext() {
        return new AnnotationConfigApplicationContext(JdbcBeansJavaConfig.class, DBFluteBeansJavaConfig.class);
    }

    // ===================================================================================
    //                                                                         Data Helper
    //                                                                         ===========
    protected void deleteAll(Class<? extends BehaviorWritable> clazz) {
        BehaviorWritable bhv = _behaviorSelector.select(clazz);
        ConditionBean cb = bhv.newConditionBean();
        bhv.rangeRemove(cb, new DeleteOption<ConditionBean>().allowNonQueryDelete());
    }

    protected void deleteMemberReferrer() {
        deleteAll(MemberAddressBhv.class);
        deleteAll(MemberFollowingBhv.class);
        deleteAll(MemberLoginBhv.class);
        deleteAll(MemberServiceBhv.class);
        deleteAll(MemberSecurityBhv.class);
        deleteAll(MemberWithdrawalBhv.class);
        deleteAll(PurchasePaymentBhv.class);
        deleteAll(PurchaseBhv.class);
    }
}
