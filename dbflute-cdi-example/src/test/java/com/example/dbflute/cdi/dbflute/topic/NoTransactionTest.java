package com.example.dbflute.cdi.dbflute.topic;

import static org.junit.Assert.*;

import java.sql.SQLException;

import javax.inject.Inject;

import org.junit.Test;
import org.seasar.dbflute.cbean.ListResultBean;

import com.example.dbflute.cdi.dbflute.cbean.MemberCB;
import com.example.dbflute.cdi.dbflute.exbhv.MemberBhv;
import com.example.dbflute.cdi.dbflute.exentity.Member;
import com.example.dbflute.cdi.unit.ContainerTestCase;

/**
 * @author jflute
 * @since 0.9.5.1 (2009/06/10 Wednesday)
 */
public class NoTransactionTest extends ContainerTestCase {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    @Inject
    private MemberBhv memberBhv;

    // ===================================================================================
    //                                                                          ColumnInfo
    //                                                                          ==========
    @Test
    public void test_noTransaction() throws SQLException {
        // ## Arrange ##
        final MemberCB cb = new MemberCB();
        cb.query().setBirthdate_IsNotNull();

        // ## Act & Assert ##
        for (int i = 0; i < 300; i++) { // Expect the connection pool won't be empty
            final ListResultBean<Member> memberList = this.memberBhv.selectList(cb); // Expect no exception
            assertFalse(memberList.isEmpty());
        }
    }
}
