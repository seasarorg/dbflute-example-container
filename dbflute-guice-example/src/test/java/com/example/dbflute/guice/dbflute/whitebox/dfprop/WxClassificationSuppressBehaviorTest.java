package com.example.dbflute.guice.dbflute.whitebox.dfprop;

import org.seasar.dbflute.BehaviorSelector;

import com.example.dbflute.guice.unit.UnitContainerTestCase;

/**
 * @author jflute
 * @since 1.0.5B (2014/02/19 Wednesday)
 */
public class WxClassificationSuppressBehaviorTest extends UnitContainerTestCase {

    private BehaviorSelector behaviorSelector;

    public void test_initializeConditionBeanMetaData() throws Exception {
        behaviorSelector.initializeConditionBeanMetaData();
    }
}
