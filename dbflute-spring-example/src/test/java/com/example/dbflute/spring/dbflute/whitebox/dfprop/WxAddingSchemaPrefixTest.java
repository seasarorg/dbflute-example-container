package com.example.dbflute.spring.dbflute.whitebox.dfprop;

import org.seasar.dbflute.unit.core.PlainTestCase;

import com.example.dbflute.spring.dbflute.bsentity.dbmeta.MemberDbm;

/**
 * @author jflute
 * @since 0.9.6.8 (2010/04/18 Sunday)
 */
public class WxAddingSchemaPrefixTest extends PlainTestCase {

    public void test_table() {
        assertFalse(MemberDbm.getInstance().getTableSqlName().toString().contains("."));
    }
}