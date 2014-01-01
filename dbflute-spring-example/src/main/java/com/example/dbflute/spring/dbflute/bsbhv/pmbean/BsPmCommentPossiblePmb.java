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
package com.example.dbflute.spring.dbflute.bsbhv.pmbean;

import java.util.*;

import org.seasar.dbflute.outsidesql.typed.*;
import org.seasar.dbflute.jdbc.*;
import org.seasar.dbflute.jdbc.ParameterUtil.ShortCharHandlingMode;
import org.seasar.dbflute.util.DfCollectionUtil;
import org.seasar.dbflute.util.DfTypeUtil;
import com.example.dbflute.spring.dbflute.allcommon.*;
import com.example.dbflute.spring.dbflute.exbhv.*;

/**
 * The base class for typed parameter-bean of PmCommentPossible. <br />
 * This is related to "<span style="color: #AD4747">whitebox:pmcomment:selectPmCommentPossible</span>" on MemberBhv.
 * @author DBFlute(AutoGenerator)
 */
public class BsPmCommentPossiblePmb implements ExecuteHandlingPmb<MemberBhv>, FetchBean {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** The parameter of string. */
    protected String _string;

    /** The parameter of integer. */
    protected Integer _integer;

    /** The parameter of bigDecimal. */
    protected java.math.BigDecimal _bigDecimal;

    /** The parameter of date. */
    protected Date _date;

    /** The parameter of timestamp. */
    protected java.sql.Timestamp _timestamp;

    /** The parameter of exists. */
    protected boolean _exists;

    /** The parameter of notExists. */
    protected boolean _notExists;

    /** The parameter of list. */
    protected List<String> _list;

    /** The parameter of map. */
    protected Map<String, Integer> _map;

    /** The parameter of cdef. */
    protected com.example.dbflute.spring.dbflute.allcommon.CDef _cdef;

    /** The max size of safety result. */
    protected int _safetyMaxResultSize;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    /**
     * Constructor for the typed parameter-bean of PmCommentPossible. <br />
     * This is related to "<span style="color: #AD4747">whitebox:pmcomment:selectPmCommentPossible</span>" on MemberBhv.
     */
    public BsPmCommentPossiblePmb() {
    }

    // ===================================================================================
    //                                                                Typed Implementation
    //                                                                ====================
    /**
     * {@inheritDoc}
     */
    public String getOutsideSqlPath() {
        return "whitebox:pmcomment:selectPmCommentPossible";
    }

    // ===================================================================================
    //                                                                       Safety Result
    //                                                                       =============
    /**
     * {@inheritDoc}
     */
    public void checkSafetyResult(int safetyMaxResultSize) {
        _safetyMaxResultSize = safetyMaxResultSize;
    }

    /**
     * {@inheritDoc}
     */
    public int getSafetyMaxResultSize() {
        return _safetyMaxResultSize;
    }

    // ===================================================================================
    //                                                                       Assist Helper
    //                                                                       =============
    protected String filterStringParameter(String value) {
        if (isEmptyStringParameterAllowed()) {
            return value;
        }
        return convertEmptyToNull(value);
    }

    protected boolean isEmptyStringParameterAllowed() {
	    return DBFluteConfig.getInstance().isEmptyStringParameterAllowed();
    }

    protected String convertEmptyToNull(String value) {
	    return ParameterUtil.convertEmptyToNull(value);
    }

    protected String handleShortChar(String propertyName, String value, Integer size) {
        ShortCharHandlingMode mode = getShortCharHandlingMode(propertyName, value, size);
        return ParameterUtil.handleShortChar(propertyName, value, size, mode);
    }

    protected ShortCharHandlingMode getShortCharHandlingMode(String propertyName, String value, Integer size) {
        return ShortCharHandlingMode.NONE;
    }

    @SuppressWarnings("unchecked")
    protected <ELEMENT> ArrayList<ELEMENT> newArrayList(ELEMENT... elements) {
        Object obj = DfCollectionUtil.newArrayList(elements);
        return (ArrayList<ELEMENT>)obj; // to avoid the warning between JDK6 and JDK7
    }

    @SuppressWarnings("unchecked")
    protected <NUMBER extends Number> NUMBER toNumber(Object obj, Class<NUMBER> type) {
        return (NUMBER)DfTypeUtil.toNumber(obj, type);
    }

    protected Boolean toBoolean(Object obj) {
        return DfTypeUtil.toBoolean(obj);
    }

    protected Date toUtilDate(Date date) {
        return DfTypeUtil.toDate(date); // if sub class, re-create as pure date
    }

    protected String formatUtilDate(Date date) {
        String pattern = "yyyy-MM-dd";
        return DfTypeUtil.toString(date, pattern);
    }

    protected String formatByteArray(byte[] bytes) {
        return "byte[" + (bytes != null ? String.valueOf(bytes.length) : "null") + "]";
    }

    // ===================================================================================
    //                                                                      Basic Override
    //                                                                      ==============
    /**
     * @return The display string of all parameters. (NotNull)
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(DfTypeUtil.toClassTitle(this)).append(":");
        sb.append(xbuildColumnString());
        return sb.toString();
    }
    private String xbuildColumnString() {
        final String c = ", ";
        final StringBuilder sb = new StringBuilder();
        sb.append(c).append(_string);
        sb.append(c).append(_integer);
        sb.append(c).append(_bigDecimal);
        sb.append(c).append(formatUtilDate(_date));
        sb.append(c).append(_timestamp);
        sb.append(c).append(_exists);
        sb.append(c).append(_notExists);
        sb.append(c).append(_list);
        sb.append(c).append(_map);
        sb.append(c).append(_cdef);
        if (sb.length() > 0) { sb.delete(0, c.length()); }
        sb.insert(0, "{").append("}");
        return sb.toString();
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * [get] string <br />
     * @return The value of string. (Nullable, NotEmptyString(when String): if empty string, returns null)
     */
    public String getString() {
        return filterStringParameter(_string);
    }

    /**
     * [set] string <br />
     * @param string The value of string. (NullAllowed)
     */
    public void setString(String string) {
        _string = string;
    }

    /**
     * [get] integer <br />
     * @return The value of integer. (Nullable, NotEmptyString(when String): if empty string, returns null)
     */
    public Integer getInteger() {
        return _integer;
    }

    /**
     * [set] integer <br />
     * @param integer The value of integer. (NullAllowed)
     */
    public void setInteger(Integer integer) {
        _integer = integer;
    }

    /**
     * [get] bigDecimal <br />
     * @return The value of bigDecimal. (Nullable, NotEmptyString(when String): if empty string, returns null)
     */
    public java.math.BigDecimal getBigDecimal() {
        return _bigDecimal;
    }

    /**
     * [set] bigDecimal <br />
     * @param bigDecimal The value of bigDecimal. (NullAllowed)
     */
    public void setBigDecimal(java.math.BigDecimal bigDecimal) {
        _bigDecimal = bigDecimal;
    }

    /**
     * [get] date <br />
     * @return The value of date. (Nullable, NotEmptyString(when String): if empty string, returns null)
     */
    public Date getDate() {
        return toUtilDate(_date);
    }

    /**
     * [set] date <br />
     * @param date The value of date. (NullAllowed)
     */
    public void setDate(Date date) {
        _date = date;
    }

    /**
     * [get] timestamp <br />
     * @return The value of timestamp. (Nullable, NotEmptyString(when String): if empty string, returns null)
     */
    public java.sql.Timestamp getTimestamp() {
        return _timestamp;
    }

    /**
     * [set] timestamp <br />
     * @param timestamp The value of timestamp. (NullAllowed)
     */
    public void setTimestamp(java.sql.Timestamp timestamp) {
        _timestamp = timestamp;
    }

    /**
     * [get] exists <br />
     * @return The value of exists. (Nullable, NotEmptyString(when String): if empty string, returns null)
     */
    public boolean getExists() {
        return _exists;
    }

    /**
     * [set] exists <br />
     * @param exists The value of exists. (NullAllowed)
     */
    public void setExists(boolean exists) {
        _exists = exists;
    }

    /**
     * [get] notExists <br />
     * @return The value of notExists. (Nullable, NotEmptyString(when String): if empty string, returns null)
     */
    public boolean getNotExists() {
        return _notExists;
    }

    /**
     * [set] notExists <br />
     * @param notExists The value of notExists. (NullAllowed)
     */
    public void setNotExists(boolean notExists) {
        _notExists = notExists;
    }

    /**
     * [get] list <br />
     * @return The value of list. (Nullable, NotEmptyString(when String): if empty string, returns null)
     */
    public List<String> getList() {
        return _list;
    }

    /**
     * [set] list <br />
     * @param list The value of list. (NullAllowed)
     */
    public void setList(List<String> list) {
        _list = list;
    }

    /**
     * [get] map <br />
     * @return The value of map. (Nullable, NotEmptyString(when String): if empty string, returns null)
     */
    public Map<String, Integer> getMap() {
        return _map;
    }

    /**
     * [set] map <br />
     * @param map The value of map. (NullAllowed)
     */
    public void setMap(Map<String, Integer> map) {
        _map = map;
    }

    /**
     * [get] cdef <br />
     * @return The value of cdef. (Nullable, NotEmptyString(when String): if empty string, returns null)
     */
    public com.example.dbflute.spring.dbflute.allcommon.CDef getCdef() {
        return _cdef;
    }

    /**
     * [set] cdef <br />
     * @param cdef The value of cdef. (NullAllowed)
     */
    public void setCdef(com.example.dbflute.spring.dbflute.allcommon.CDef cdef) {
        _cdef = cdef;
    }

}
