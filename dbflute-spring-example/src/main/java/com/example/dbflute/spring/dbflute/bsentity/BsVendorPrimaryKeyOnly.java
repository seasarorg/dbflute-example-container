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
package com.example.dbflute.spring.dbflute.bsentity;

import java.util.List;
import java.util.ArrayList;

import org.seasar.dbflute.dbmeta.DBMeta;
import org.seasar.dbflute.dbmeta.AbstractEntity;
import com.example.dbflute.spring.dbflute.allcommon.DBMetaInstanceHandler;
import com.example.dbflute.spring.dbflute.exentity.*;

/**
 * The entity of VENDOR_PRIMARY_KEY_ONLY as TABLE. <br />
 * <pre>
 * [primary-key]
 *     PRIMARY_KEY_ONLY_ID
 * 
 * [column]
 *     PRIMARY_KEY_ONLY_ID
 * 
 * [sequence]
 *     
 * 
 * [identity]
 *     
 * 
 * [version-no]
 *     
 * 
 * [foreign table]
 *     
 * 
 * [referrer table]
 *     
 * 
 * [foreign property]
 *     
 * 
 * [referrer property]
 *     
 * 
 * [get/set template]
 * /= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
 * Long primaryKeyOnlyId = entity.getPrimaryKeyOnlyId();
 * entity.setPrimaryKeyOnlyId(primaryKeyOnlyId);
 * = = = = = = = = = =/
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsVendorPrimaryKeyOnly extends AbstractEntity {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** Serial version UID. (Default) */
    private static final long serialVersionUID = 1L;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    // -----------------------------------------------------
    //                                                Column
    //                                                ------
    /** PRIMARY_KEY_ONLY_ID: {PK, NotNull, BIGINT(19)} */
    protected Long _primaryKeyOnlyId;

    // ===================================================================================
    //                                                                          Table Name
    //                                                                          ==========
    /**
     * {@inheritDoc}
     */
    public String getTableDbName() {
        return "VENDOR_PRIMARY_KEY_ONLY";
    }

    /**
     * {@inheritDoc}
     */
    public String getTablePropertyName() { // according to Java Beans rule
        return "vendorPrimaryKeyOnly";
    }

    // ===================================================================================
    //                                                                              DBMeta
    //                                                                              ======
    /**
     * {@inheritDoc}
     */
    public DBMeta getDBMeta() {
        return DBMetaInstanceHandler.findDBMeta(getTableDbName());
    }

    // ===================================================================================
    //                                                                         Primary Key
    //                                                                         ===========
    /**
     * {@inheritDoc}
     */
    public boolean hasPrimaryKeyValue() {
        if (getPrimaryKeyOnlyId() == null) { return false; }
        return true;
    }

    // ===================================================================================
    //                                                                    Foreign Property
    //                                                                    ================
    // ===================================================================================
    //                                                                   Referrer Property
    //                                                                   =================
    protected <ELEMENT> List<ELEMENT> newReferrerList() {
        return new ArrayList<ELEMENT>();
    }

    // ===================================================================================
    //                                                                      Basic Override
    //                                                                      ==============
    @Override
    protected boolean doEquals(Object obj) {
        if (obj instanceof BsVendorPrimaryKeyOnly) {
            BsVendorPrimaryKeyOnly other = (BsVendorPrimaryKeyOnly)obj;
            if (!xSV(_primaryKeyOnlyId, other._primaryKeyOnlyId)) { return false; }
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected int doHashCode(int initial) {
        int hs = initial;
        hs = xCH(hs, getTableDbName());
        hs = xCH(hs, _primaryKeyOnlyId);
        return hs;
    }

    @Override
    protected String doBuildStringWithRelation(String li) {
        return "";
    }

    @Override
    protected String doBuildColumnString(String dm) {
        StringBuilder sb = new StringBuilder();
        sb.append(dm).append(xfND(_primaryKeyOnlyId));
        if (sb.length() > dm.length()) {
            sb.delete(0, dm.length());
        }
        sb.insert(0, "{").append("}");
        return sb.toString();
    }

    @Override
    protected String doBuildRelationString(String dm) {
        return "";
    }

    @Override
    public VendorPrimaryKeyOnly clone() {
        return (VendorPrimaryKeyOnly)super.clone();
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * [get] PRIMARY_KEY_ONLY_ID: {PK, NotNull, BIGINT(19)} <br />
     * @return The value of the column 'PRIMARY_KEY_ONLY_ID'. (basically NotNull if selected: for the constraint)
     */
    public Long getPrimaryKeyOnlyId() {
        checkSpecifiedProperty("primaryKeyOnlyId");
        return _primaryKeyOnlyId;
    }

    /**
     * [set] PRIMARY_KEY_ONLY_ID: {PK, NotNull, BIGINT(19)} <br />
     * @param primaryKeyOnlyId The value of the column 'PRIMARY_KEY_ONLY_ID'. (basically NotNull if update: for the constraint)
     */
    public void setPrimaryKeyOnlyId(Long primaryKeyOnlyId) {
        registerModifiedProperty("primaryKeyOnlyId");
        _primaryKeyOnlyId = primaryKeyOnlyId;
    }
}
