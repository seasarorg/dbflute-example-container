package com.example.dbflute.cdi.unit;

import java.sql.Timestamp;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * The test base of simple test for Basic Example.
 * @author taktos
 * @since 0.9.8.3 (2011/05/10 Tuesday)
 */
public abstract class PlainTestCase {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** Log instance for sub class. */
    private static final Log _log = LogFactory.getLog(PlainTestCase.class);

    // ===================================================================================
    //                                                                      General Helper
    //                                                                      ==============
    protected void log(final Object msg) {
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
