/*
 * Copyright 2004-2014 the Seasar Foundation and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package com.example.dbflute.guice.dbflute.whitebox.dfprop;

import org.seasar.dbflute.exception.InvalidQueryRegisteredException;
import org.seasar.dbflute.util.Srl;

import com.example.dbflute.guice.dbflute.cbean.MemberCB;
import com.example.dbflute.guice.dbflute.exbhv.MemberBhv;
import com.example.dbflute.guice.dbflute.exentity.Member;
import com.example.dbflute.guice.unit.UnitContainerTestCase;

/**
 * @author jflute
 * @since 1.0.5K (2014/08/03 Sunday)
 */
public class WxJava8NullOrEmptyQueryTest extends UnitContainerTestCase {

    private MemberBhv memberBhv;

    // ===================================================================================
    //                                                                               Check
    //                                                                               =====
    // -----------------------------------------------------
    //                                                 Basic
    //                                                 -----
    public void test_checkNullOrEmptyQuery_basic() {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.ignoreNullOrEmptyQuery();
        cb.query().setMemberId_Equal(null); // no exception
        cb.query().setMemberName_PrefixSearch(""); // no exception
        cb.checkNullOrEmptyQuery();

        // ## Act ##
        try {
            cb.query().setMemberId_Equal(null);

            // ## Assert ##
            fail();
        } catch (InvalidQueryRegisteredException e) {
            // OK
            log(e.getMessage());
            assertTrue(Srl.containsAll(e.getMessage(), "MEMBER_ID equal", "query()"));
        }
        try {
            cb.query().setMemberName_PrefixSearch("");

            fail();
        } catch (InvalidQueryRegisteredException e) {
            // OK
            log(e.getMessage());
            assertTrue(Srl.containsAll(e.getMessage(), "MEMBER_NAME likeSearch", "query()"));
        }

        // ## Act ##
        cb.query().setMemberId_Equal(3);
        Member actual = memberBhv.selectEntityWithDeletedCheck(cb);

        // ## Assert ##
        assertEquals(Integer.valueOf(3), actual.getMemberId());
    }

    // -----------------------------------------------------
    //                                                FromTo
    //                                                ------
    public void test_checkNullOrEmptyQuery_fromTo_bothNull() {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.specify().columnMemberName(); // remove BIRTHDATE to assert

        // ## Act ##
        try {
            cb.query().setBirthdate_DateFromTo(null, null);
            fail();
        } catch (InvalidQueryRegisteredException e) {
            // OK
            log(e.getMessage());
            assertTrue(Srl.containsAll(e.getMessage(), "MEMBER.BIRTHDATE greaterEqual", "query()"));
        }

        String sql = cb.toDisplaySql();
        log(ln() + sql);
        assertNotContains(sql, "BIRTHDATE");
    }

    // ===================================================================================
    //                                                                              Ignore
    //                                                                              ======
    public void test_ignoreNullOrEmptyQuery_basic() {
        // ## Arrange ##
        MemberCB cb = new MemberCB();

        // ## Act ##
        try {
            cb.query().setMemberId_Equal(null);

            // ## Assert ##
            fail();
        } catch (InvalidQueryRegisteredException e) {
            // OK
            log(e.getMessage());
            assertTrue(Srl.containsAll(e.getMessage(), "MEMBER_ID equal", "query()"));
        }
        try {
            cb.query().setMemberName_PrefixSearch("");

            fail();
        } catch (InvalidQueryRegisteredException e) {
            // OK
            log(e.getMessage());
            assertTrue(Srl.containsAll(e.getMessage(), "MEMBER_NAME likeSearch", "query()"));
        }
        cb.ignoreNullOrEmptyQuery();
        cb.query().setMemberId_Equal(null); // no exception
        cb.query().setMemberName_PrefixSearch(""); // no exception

        // ## Act ##
        cb.query().setMemberId_Equal(3);
        Member actual = memberBhv.selectEntityWithDeletedCheck(cb);

        // ## Assert ##
        assertEquals(Integer.valueOf(3), actual.getMemberId());
    }

    public void test_ignoreNullOrEmptyQuery_fromTo_oneSide() {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.specify().columnMemberName(); // remove BIRTHDATE to assert
        cb.ignoreNullOrEmptyQuery();

        // ## Act ##
        cb.query().setBirthdate_DateFromTo(null, null);

        String sql = cb.toDisplaySql();
        log(ln() + sql);
        assertNotContains(sql, "BIRTHDATE");
    }
}
