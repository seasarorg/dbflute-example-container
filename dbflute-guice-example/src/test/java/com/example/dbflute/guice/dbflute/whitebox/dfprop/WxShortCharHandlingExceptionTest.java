package com.example.dbflute.guice.dbflute.whitebox.dfprop;

import org.seasar.dbflute.exception.CharParameterShortSizeException;
import org.seasar.dbflute.jdbc.ParameterUtil.ShortCharHandlingMode;

import com.example.dbflute.guice.dbflute.cbean.MemberCB;
import com.example.dbflute.guice.dbflute.exbhv.pmbean.OptionMemberPmb;
import com.example.dbflute.guice.unit.UnitContainerTestCase;

/**
 * @author jflute
 * @since 0.9.6.1 (2009/11/17 Tuesday)
 */
public class WxShortCharHandlingExceptionTest extends UnitContainerTestCase {

    public void test_shortChar_conditionBean_exception() {
        // ## Arrange ##
        MemberCB cb = new MemberCB();

        // ## Act ##
        try {
            cb.query().invokeQueryEqual("MEMBER_STATUS_CODE", "AB");

            // ## Assert ##
            fail();
        } catch (CharParameterShortSizeException e) {
            // OK
            log(e.getMessage());
        }
    }

    public void test_shortChar_parameterBean_exception() {
        // ## Arrange ##
        OptionMemberPmb pmb = new OptionMemberPmb();

        // ## Act ##
        pmb.setMemberStatusCode("AB");
        pmb.getMemberStatusCode(); // no exception because of not 'ref'
        pmb.setStatus("AB");
        try {
            pmb.getStatus();

            // ## Assert ##
            fail();
        } catch (CharParameterShortSizeException e) {
            // OK
            log(e.getMessage());
        }
    }

    public void test_shortChar_parameterBean_rfillByExtension() {
        // ## Arrange ##
        OptionMemberPmb pmb = new OptionMemberPmb() {
            @Override
            protected ShortCharHandlingMode getShortCharHandlingMode(String propertyName, String value, Integer size) {
                return ShortCharHandlingMode.RFILL;
            }
        };

        // ## Act ##
        pmb.setMemberStatusCode("AB");
        pmb.setStatus("AB");

        // ## Assert ##
        assertEquals("AB", pmb.getMemberStatusCode());
        assertEquals("AB ", pmb.getStatus());
    }

    public void test_shortChar_parameterBean_lfillByExtension() {
        // ## Arrange ##
        OptionMemberPmb pmb = new OptionMemberPmb() {
            @Override
            protected ShortCharHandlingMode getShortCharHandlingMode(String propertyName, String value, Integer size) {
                return ShortCharHandlingMode.LFILL;
            }
        };

        // ## Act ##
        pmb.setMemberStatusCode("AB");
        pmb.setStatus("AB");

        // ## Assert ##
        assertEquals("AB", pmb.getMemberStatusCode());
        assertEquals(" AB", pmb.getStatus());
    }

    public void test_shortChar_parameterBean_rfillByExtension_null() {
        // ## Arrange ##
        OptionMemberPmb pmb = new OptionMemberPmb() {
            @Override
            protected ShortCharHandlingMode getShortCharHandlingMode(String propertyName, String value, Integer size) {
                return ShortCharHandlingMode.RFILL;
            }
        };

        // ## Act ##
        pmb.setMemberStatusCode(null);
        pmb.setStatus(null);

        // ## Assert ##
        assertNull(pmb.getMemberStatusCode());
        assertNull(pmb.getStatus());
    }

    public void test_shortChar_parameterBean_rfillByExtension_empty() {
        // ## Arrange ##
        OptionMemberPmb pmb = new OptionMemberPmb() {
            @Override
            protected ShortCharHandlingMode getShortCharHandlingMode(String propertyName, String value, Integer size) {
                return ShortCharHandlingMode.RFILL;
            }
        };

        // ## Act ##
        pmb.setMemberStatusCode("");
        pmb.setStatus("");

        // ## Assert ##
        assertNull(pmb.getMemberStatusCode());
        assertNull(pmb.getStatus());
    }

    public void test_shortChar_parameterBean_rfillByExtension_oneSpace() {
        // ## Arrange ##
        OptionMemberPmb pmb = new OptionMemberPmb() {
            @Override
            protected ShortCharHandlingMode getShortCharHandlingMode(String propertyName, String value, Integer size) {
                return ShortCharHandlingMode.RFILL;
            }
        };

        // ## Act ##
        pmb.setMemberStatusCode(" ");
        pmb.setStatus(" ");

        // ## Assert ##
        assertEquals(" ", pmb.getMemberStatusCode());
        assertEquals("   ", pmb.getStatus());
    }
}
