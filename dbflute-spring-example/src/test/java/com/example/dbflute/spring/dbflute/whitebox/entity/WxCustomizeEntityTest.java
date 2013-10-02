package com.example.dbflute.spring.dbflute.whitebox.entity;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;

import org.seasar.dbflute.util.DfTypeUtil;

import com.example.dbflute.spring.dbflute.bsentity.customize.dbmeta.ForcedTypeDbm;
import com.example.dbflute.spring.dbflute.bsentity.customize.dbmeta.SimpleVendorCheckDbm;
import com.example.dbflute.spring.dbflute.exentity.customize.ForcedType;
import com.example.dbflute.spring.dbflute.exentity.customize.SimpleMember;
import com.example.dbflute.spring.dbflute.exentity.customize.SimpleVendorCheck;
import com.example.dbflute.spring.unit.UnitContainerTestCase;

/**
 * @author jflute
 * @since 0.9.5 (2009/04/08 Wednesday)
 */
public class WxCustomizeEntityTest extends UnitContainerTestCase {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========

    // ===================================================================================
    //                                                                           Byte Type
    //                                                                           =========
    public void test_BLOB_equals_CustomizeEntity_nonPrimaryKey_sameByte() {
        // ## Arrange ##
        assertFalse(SimpleVendorCheckDbm.getInstance().hasPrimaryKey());
        SimpleVendorCheck vendorCheck = new SimpleVendorCheck();
        vendorCheck.setTypeOfText("FOO");
        try {
            vendorCheck.setTypeOfBlob("BAR".getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException(e);
        }
        SimpleVendorCheck other = new SimpleVendorCheck();
        other.setTypeOfText("FOO");
        try {
            other.setTypeOfBlob("BAR".getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException(e);
        }

        // ## Act ##
        boolean actual = vendorCheck.equals(other); // expect no exception

        // ## Assert ##
        log("actual=" + actual);
        assertTrue(actual);
    }

    // ===================================================================================
    //                                                                         Forced Type
    //                                                                         ===========
    public void test_Sql2Entity_forcedType() {
        // ## Arrange ##
        ForcedType forcedType = new ForcedType();

        // ## Act ##
        BigInteger maxMemberId = forcedType.getMaxMemberId();

        // ## Assert ##
        assertNull(maxMemberId);
        assertEquals(BigInteger.class, ForcedTypeDbm.getInstance().columnMaxMemberId().getPropertyType());
    }

    // ===================================================================================
    //                                                                        Serializable
    //                                                                        ============
    public void test_serializable_basic() {
        // ## Arrange ##
        SimpleMember member = new SimpleMember();
        member.setMemberName("Stojkovic");
        member.setBirthdate(currentDate());

        // ## Act ##
        byte[] binary = DfTypeUtil.toBinary(member);
        Serializable serializable = DfTypeUtil.toSerializable(binary);

        // ## Assert ##
        log(serializable);
        assertNotNull(serializable);
        assertEquals(member.toString(), serializable.toString());
    }
}
