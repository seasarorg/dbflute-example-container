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

import org.seasar.dbflute.exception.EntityAlreadyDeletedException;
import org.seasar.dbflute.optional.OptionalEntity;
import org.seasar.dbflute.optional.OptionalThingConsumer;

import com.example.dbflute.guice.dbflute.cbean.MemberCB;
import com.example.dbflute.guice.dbflute.exbhv.MemberBhv;
import com.example.dbflute.guice.dbflute.exentity.Member;
import com.example.dbflute.guice.unit.UnitContainerTestCase;

/**
 * @author jflute
 * @since 1.0.5F (2014/05/05 Monday)
 */
public class WxJava8OptionalEntityTest extends UnitContainerTestCase {

    private MemberBhv memberBhv;

    public void test_selectEntity_basic() throws Exception {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.query().setMemberId_Equal(3);

        // ## Act ##
        OptionalEntity<Member> entity = memberBhv.selectEntity(cb);

        // ## Assert ##
        log(entity.toString());
        final Member member = entity.get();
        assertEquals((Integer) 3, member.getMemberId());
        assertTrue(entity.isPresent());
        entity.ifPresent(new OptionalThingConsumer<Member>() {
            public void accept(Member value) {
                assertEquals(member, value);
            }
        });
        entity.orElseNull();
    }

    public void test_selectEntity_notFound() throws Exception {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.query().setMemberId_Equal(99999);

        // ## Act ##
        OptionalEntity<Member> entity = memberBhv.selectEntity(cb);

        // ## Assert ##
        log(entity.toString());
        try {
            entity.get();
            fail();
        } catch (EntityAlreadyDeletedException e) {
            log(e.getMessage());
        }
        assertFalse(entity.isPresent());
    }
}
