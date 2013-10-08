package com.example.dbflute.guice.unit;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * The test base of simple test.
 * @author jflute
 * @since 0.9.2 (2009/02/18 Wednesday)
 */
public abstract class PlainTestCase extends TestCase {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** Log instance for sub class. */
    private static final Log _log = LogFactory.getLog(PlainTestCase.class);
    // ===================================================================================
    //                                                                       Assert Helper
    //                                                                       =============
    // -----------------------------------------------------
    //                                                Equals
    //                                                ------
    // to avoid setting like this:
    //  assertEquals(Integer.valueOf(3), member.getMemberId())
    protected void assertEquals(String message, int expected, Integer actual) {
        assertEquals(message, Integer.valueOf(expected), actual);
    }

    protected void assertEquals(int expected, Integer actual) {
        assertEquals(null, Integer.valueOf(expected), actual);
    }

    // -----------------------------------------------------
    //                                                  List
    //                                                  ----
    protected void assertListEmpty(List<?> list) {
        if (!list.isEmpty()) {
            fail("the list should be empty but: " + list);
        }
    }

    protected void assertListNotEmpty(List<?> list) {
        if (list.isEmpty()) {
            fail("the list should not be empty but empty.");
        }
    }

    protected void assertListHasOneElement(List<?> list) {
        if (list.size() != 1) {
            fail("the list should have only one element but: " + list);
        }
    }

    protected void assertListHasSeveralElement(List<?> list) {
        if (list.size() >= 2) {
            fail("the list should have several elements but: " + list);
        }
    }

    // ===================================================================================
    //                                                                      General Helper
    //                                                                      ==============
    protected void log(Object msg) {
        _log.debug(msg);
    }

    protected Date currentDate() {
        return new Date(System.currentTimeMillis());
    }

    protected Timestamp currentTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    protected String ln() {
        return "\n";
    }
}
