package com.example.dbflute.spring.dbflute.vendor;

import org.seasar.dbflute.cbean.ListResultBean;

import com.example.dbflute.spring.dbflute.cbean.VendorIdentityOnlyCB;
import com.example.dbflute.spring.dbflute.cbean.VendorPrimaryKeyOnlyCB;
import com.example.dbflute.spring.dbflute.exbhv.VendorIdentityOnlyBhv;
import com.example.dbflute.spring.dbflute.exbhv.VendorPrimaryKeyOnlyBhv;
import com.example.dbflute.spring.dbflute.exentity.VendorIdentityOnly;
import com.example.dbflute.spring.dbflute.exentity.VendorPrimaryKeyOnly;
import com.example.dbflute.spring.unit.UnitContainerTestCase;

/**
 * @author jflute
 * @since 0.9.7.2 (2010/06/15 Tuesday)
 */
public class VendorTrickyTest extends UnitContainerTestCase {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private VendorPrimaryKeyOnlyBhv vendorPrimaryKeyOnlyBhv;
    private VendorIdentityOnlyBhv vendorIdentityOnlyBhv;

    // ===================================================================================
    //                                                                     PrimaryKey Only
    //                                                                     ===============
    public void test_PrimaryKeyOnly_selectList_basic() throws Exception {
        // ## Arrange ##
        VendorPrimaryKeyOnlyCB cb = new VendorPrimaryKeyOnlyCB();

        // ## Act ##
        ListResultBean<VendorPrimaryKeyOnly> pkOnlyList = vendorPrimaryKeyOnlyBhv.selectList(cb);

        // ## Assert ##
        assertHasZeroElement(pkOnlyList);
    }

    public void test_PrimaryKeyOnly_insert_basic() throws Exception {
        // ## Arrange ##
        VendorPrimaryKeyOnly pkOnly = new VendorPrimaryKeyOnly();
        pkOnly.setPrimaryKeyOnlyId(99999L);

        // ## Act ##
        vendorPrimaryKeyOnlyBhv.insert(pkOnly);

        // ## Assert ##
        vendorPrimaryKeyOnlyBhv.selectByPKValueWithDeletedCheck(99999L); // expect no exception
    }

    // ===================================================================================
    //                                                                       Identity Only
    //                                                                       =============
    public void test_IdentityOnly_selectList_basic() throws Exception {
        // ## Arrange ##
        VendorIdentityOnlyCB cb = new VendorIdentityOnlyCB();

        // ## Act ##
        ListResultBean<VendorIdentityOnly> pkOnlyList = vendorIdentityOnlyBhv.selectList(cb);

        // ## Assert ##
        assertHasZeroElement(pkOnlyList);
    }

    public void test_IdentityOnly_insert_basic() throws Exception {
        // ## Arrange ##
        VendorIdentityOnly pkOnly = new VendorIdentityOnly();
        pkOnly.setIdentityOnlyId(99999L);

        // ## Act ##
        try {
            vendorIdentityOnlyBhv.insert(pkOnly);

            // ## Assert ##
            fail();
        } catch (RuntimeException e) { // because of no insert property
            log(e.getMessage());
        }
    }
}
