package com.example.dbflute.spring.dbflute.whitebox.runtime;

import org.seasar.dbflute.DBDef;
import org.seasar.dbflute.jdbc.ValueType;
import org.seasar.dbflute.resource.ResourceContext;
import org.seasar.dbflute.s2dao.valuetype.TnValueTypes;
import org.seasar.dbflute.unit.core.thread.ThreadFireExecution;
import org.seasar.dbflute.unit.core.thread.ThreadFireResource;

import com.example.dbflute.spring.unit.UnitContainerTestCase;

/**
 * @author jflute
 * @since 0.9.9.8 (2012/09/01 Saturday)
 */
public class WxRuntimeThreadSafeTest extends UnitContainerTestCase {

    // ===================================================================================
    //                                                                           Framework
    //                                                                           =========
    public void test_ThreadSafe_ValueType_getValueType() {
        threadFire(new ThreadFireExecution<Void>() {
            public Void execute(ThreadFireResource resource) {
                long id = Thread.currentThread().getId();
                boolean foo = (id % 2 == 0);
                ResourceContext context = new ResourceContext();
                if (foo) {
                    context.setCurrentDBDef(DBDef.MySQL);
                } else {
                    context.setCurrentDBDef(DBDef.Oracle);
                }
                ResourceContext.setResourceContextOnThread(context);
                for (int i = 0; i < 10000; i++) {
                    ValueType valueType = TnValueTypes.getValueType(java.util.Date.class);
                    if (foo) {
                        assertEquals(TnValueTypes.UTILDATE_AS_SQLDATE, valueType);
                    } else {
                        assertEquals(TnValueTypes.UTILDATE_AS_TIMESTAMP, valueType);
                    }
                    assertNotNull(TnValueTypes.getValueType(java.sql.Timestamp.class));
                    assertNotNull(TnValueTypes.getValueType(java.util.UUID.class));
                }
                return null;
            }
        });
    }
}
