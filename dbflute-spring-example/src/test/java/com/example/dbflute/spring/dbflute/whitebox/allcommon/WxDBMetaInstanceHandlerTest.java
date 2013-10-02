package com.example.dbflute.spring.dbflute.whitebox.allcommon;

import org.seasar.dbflute.unit.core.PlainTestCase;

import com.example.dbflute.spring.dbflute.allcommon.DBMetaInstanceHandler;

/**
 * @author jflute
 */
public class WxDBMetaInstanceHandlerTest extends PlainTestCase {

    public void test_byTableFlexibleName() throws Exception {
        // expect no not-found exception
        assertNotNull(DBMetaInstanceHandler.findDBMeta("MEMBER"));
        assertNotNull(DBMetaInstanceHandler.findDBMeta("Member"));
        assertNotNull(DBMetaInstanceHandler.findDBMeta("member"));
        assertNotNull(DBMetaInstanceHandler.findDBMeta("MEMBER_STATUS"));
        assertNotNull(DBMetaInstanceHandler.findDBMeta("MemberStatus"));
        assertNotNull(DBMetaInstanceHandler.findDBMeta("memberstatus"));
        assertNotNull(DBMetaInstanceHandler.findDBMeta("MEMBER_STATUS"));
        assertNotNull(DBMetaInstanceHandler.findDBMeta("PUBLIC.MEMBER"));
        assertNotNull(DBMetaInstanceHandler.findDBMeta("abc.MEMBER"));
    }
}
