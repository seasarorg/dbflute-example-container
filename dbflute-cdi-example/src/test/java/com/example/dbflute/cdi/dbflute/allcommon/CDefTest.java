package com.example.dbflute.cdi.dbflute.allcommon;

import static org.junit.Assert.*;

import org.junit.Test;

import com.example.dbflute.cdi.dbflute.allcommon.CDef.MemberStatus;
import com.example.dbflute.cdi.unit.PlainTestCase;

/**
 * @author jflute
 * @since 0.8.0 (2008/09/22 Monday)
 */
public class CDefTest extends PlainTestCase {

    @Test
    public void test_CDef_valueOf_Success() {
        // ## Arrange ##
        final String value = "正式会員";

        // ## Act ##
        final MemberStatus memberStatus = CDef.MemberStatus.valueOf(value);

        // ## Assert ##
        assertNotNull(memberStatus);
        assertEquals("FML", memberStatus.code());
        assertEquals(value, memberStatus.name());
        assertEquals("正式会員", memberStatus.alias());
        assertTrue(memberStatus.equals(CDef.MemberStatus.正式会員));
        assertTrue(memberStatus.equals(CDef.MemberStatus.codeOf("FML")));
    }

    @Test
    public void test_CDef_valueOf_NotFound() {
        // ## Arrange ##
        final String value = "NotFound";

        // ## Act ##
        try {
            CDef.MemberStatus.valueOf(value);

            // ## Assert ##
            fail();
        } catch (final IllegalArgumentException e) {
            // OK
            this.log(e.getMessage());
        }
    }

    @Test
    public void test_CDef_valueOf_classValue_Success() {
        // ## Arrange ##
        final Class<CDef.MemberStatus> type = CDef.MemberStatus.class;

        // ## Act ##
        final MemberStatus memberStatus = Enum.valueOf(type, CDef.MemberStatus.正式会員.name());

        // ## Assert ##
        assertNotNull(memberStatus);
        assertEquals("FML", memberStatus.code());
        assertEquals("正式会員", memberStatus.name());
        assertEquals("正式会員", memberStatus.alias());
        assertTrue(memberStatus.equals(CDef.MemberStatus.正式会員));
        assertTrue(memberStatus.equals(CDef.MemberStatus.codeOf("FML")));
    }

    @Test
    public void test_CDef_valueOf_classValue_NotFound() {
        // ## Arrange ##
        final Class<CDef.MemberStatus> type = CDef.MemberStatus.class;

        // ## Act ##
        try {
            Enum.valueOf(type, CDef.MemberStatus.正式会員.toString());

            // ## Assert ##
            fail();
        } catch (final IllegalArgumentException e) {
            // OK
            this.log(e.getMessage());
        }
    }
}
