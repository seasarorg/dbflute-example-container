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
import org.seasar.dbflute.cbean.coption.LikeSearchOption;
import org.seasar.dbflute.cbean.coption.FromToOption;
import org.seasar.dbflute.util.DfCollectionUtil;
import org.seasar.dbflute.exception.*;
import org.seasar.dbflute.util.DfTypeUtil;
import com.example.dbflute.spring.dbflute.allcommon.*;
import com.example.dbflute.spring.dbflute.exbhv.*;

/**
 * The base class for typed parameter-bean of ParameterAutoDetect. <br />
 * This is related to "<span style="color: #AD4747">whitebox:pmbean:selectParameterAutoDetect</span>" on MemberBhv.
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsParameterAutoDetectPmb implements ExecuteHandlingPmb<MemberBhv>, FetchBean {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** The parameter of normalInteger. */
    protected Integer _normalInteger;

    /** The parameter of noTestValue. */
    protected String _noTestValue;

    /** The parameter of prefixSearchOption:likePrefix. */
    protected String _prefixSearchOption;

    /** The option of like-search for prefixSearchOption. */
    protected LikeSearchOption _prefixSearchOptionInternalLikeSearchOption;

    /** The parameter of suffixSearchOption:ref(MEMBER.MEMBER_NAME)|likeSuffix :: refers to (会員名称)MEMBER_NAME: {IX, NotNull, VARCHAR(200)}. */
    protected String _suffixSearchOption;

    /** The option of like-search for suffixSearchOption. */
    protected LikeSearchOption _suffixSearchOptionInternalLikeSearchOption;

    /** The parameter of containSearchOption:likeContain. */
    protected String _containSearchOption;

    /** The option of like-search for containSearchOption. */
    protected LikeSearchOption _containSearchOptionInternalLikeSearchOption;

    /** The parameter of normalLikeSearchOption:like. */
    protected String _normalLikeSearchOption;

    /** The option of like-search for normalLikeSearchOption. */
    protected LikeSearchOption _normalLikeSearchOptionInternalLikeSearchOption;

    /** The parameter of normalCls:cls(MemberStatus.Withdrawal). */
    protected String _normalCls = CDef.MemberStatus.Withdrawal.code();

    /** The parameter of normalDate. */
    protected Date _normalDate;

    /** The parameter of fromDateOption:fromDate. */
    protected Date _fromDateOption;

    /** The parameter of toDateOption:toDate. */
    protected Date _toDateOption;

    /** The parameter of duplicateFromDate:fromDate. */
    protected Date _duplicateFromDate;

    /** The parameter of integerList. */
    protected List<Integer> _integerList;

    /** The parameter of cdefList:cls(MemberStatus)|ref(MEMBER.MEMBER_STATUS_CODE) :: refers to (会員ステータスコード)MEMBER_STATUS_CODE: {IX, NotNull, CHAR(3), FK to MEMBER_STATUS, classification=MemberStatus}. */
    protected List<com.example.dbflute.spring.dbflute.allcommon.CDef.MemberStatus> _cdefList;

    /** The parameter of memberStatusCodeList:cls(MemberStatus)|ref(MEMBER) :: refers to (会員ステータスコード)MEMBER_STATUS_CODE: {IX, NotNull, CHAR(3), FK to MEMBER_STATUS, classification=MemberStatus}. */
    protected List<com.example.dbflute.spring.dbflute.allcommon.CDef.MemberStatus> _memberStatusCodeList;

    /** The parameter of forCommentBasic:likePrefix. */
    protected List<String> _forCommentBasic;

    /** The option of like-search for forCommentBasic. */
    protected LikeSearchOption _forCommentBasicInternalLikeSearchOption;

    /** The parameter of nestedForList. */
    protected List<List<List<Integer>>> _nestedForList;

    /** The parameter of bindInIfCommentForList. */
    protected List<Date> _bindInIfCommentForList;

    /** The parameter of ifCommentOnly. */
    protected boolean _ifCommentOnly;

    /** The parameter of ifCommentAndFirst. */
    protected boolean _ifCommentAndFirst;

    /** The parameter of ifCommentAndSecond. */
    protected String _ifCommentAndSecond;

    /** The parameter of ifCommentAndThird. */
    protected Integer _ifCommentAndThird;

    /** The parameter of ifCommentBooleanNotFormal. */
    protected boolean _ifCommentBooleanNotFormal;

    /** The parameter of ifCommentBooleanNotWrongSyntax. */
    protected String _ifCommentBooleanNotWrongSyntax;

    /** The parameter of overriddenFromDate. */
    protected String _overriddenFromDate;

    /** The parameter of definedBoolean. */
    protected boolean _definedBoolean;

    /** The max size of safety result. */
    protected int _safetyMaxResultSize;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    /**
     * Constructor for the typed parameter-bean of ParameterAutoDetect. <br />
     * This is related to "<span style="color: #AD4747">whitebox:pmbean:selectParameterAutoDetect</span>" on MemberBhv.
     */
    public BsParameterAutoDetectPmb() {
    }

    // ===================================================================================
    //                                                                Typed Implementation
    //                                                                ====================
    /**
     * {@inheritDoc}
     */
    public String getOutsideSqlPath() {
        return "whitebox:pmbean:selectParameterAutoDetect";
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
    //                                                                   Alternate Boolean
    //                                                                   =================
    /**
     * This is an alternate boolean method waiting for your overriding.
     * @return The determination, true or false for your complex conditions.
     */
    public abstract boolean isFirstAlternate();

    /**
     * This is an alternate boolean method waiting for your overriding.
     * @return The determination, true or false for your complex conditions.
     */
    public abstract boolean isNotUseAlternate();

    /**
     * This is an alternate boolean method waiting for your overriding.
     * @return The determination, true or false for your complex conditions.
     */
    public abstract boolean isDuplicateAlternate();

    /**
     * This is an alternate boolean method waiting for your overriding.
     * @return The determination, true or false for your complex conditions.
     */
    public abstract boolean hasDefinedBoolean();

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
    protected <ELEMENT> ArrayList<ELEMENT> newArrayList(ELEMENT... elements) { // might be called by option handling
        Object obj = DfCollectionUtil.newArrayList(elements);
        return (ArrayList<ELEMENT>)obj; // to avoid the warning between JDK6 and JDK7
    }

    @SuppressWarnings("unchecked")
    protected <NUMBER extends Number> NUMBER toNumber(Object obj, Class<NUMBER> type) { // might be called by option handling
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

    protected void assertLikeSearchOptionValid(String name, LikeSearchOption option) {
        if (option == null) {
            String msg = "The like-search option is required!";
            throw new RequiredOptionNotFoundException(msg);
        }
        if (option.isSplit()) {
            String msg = "The split of like-search is NOT available on parameter-bean.";
            msg = msg + " Don't use splitByXxx(): " + option;
            throw new IllegalOutsideSqlOperationException(msg);
        }
    }

    protected void assertFromToOptionValid(String name, FromToOption option) {
        if (option == null) {
            String msg = "The from-to option is required!";
            throw new RequiredOptionNotFoundException(msg);
        }
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
    protected String xbuildColumnString() {
        final String dm = ", ";
        final StringBuilder sb = new StringBuilder();
        sb.append(dm).append(_normalInteger);
        sb.append(dm).append(_noTestValue);
        sb.append(dm).append(_prefixSearchOption);
        sb.append(dm).append(_suffixSearchOption);
        sb.append(dm).append(_containSearchOption);
        sb.append(dm).append(_normalLikeSearchOption);
        sb.append(dm).append(_normalCls);
        sb.append(dm).append(formatUtilDate(_normalDate));
        sb.append(dm).append(formatUtilDate(_fromDateOption));
        sb.append(dm).append(formatUtilDate(_toDateOption));
        sb.append(dm).append(formatUtilDate(_duplicateFromDate));
        sb.append(dm).append(_integerList);
        sb.append(dm).append(_cdefList);
        sb.append(dm).append(_memberStatusCodeList);
        sb.append(dm).append(_forCommentBasic);
        sb.append(dm).append(_nestedForList);
        sb.append(dm).append(_bindInIfCommentForList);
        sb.append(dm).append(_ifCommentOnly);
        sb.append(dm).append(_ifCommentAndFirst);
        sb.append(dm).append(_ifCommentAndSecond);
        sb.append(dm).append(_ifCommentAndThird);
        sb.append(dm).append(_ifCommentBooleanNotFormal);
        sb.append(dm).append(_ifCommentBooleanNotWrongSyntax);
        sb.append(dm).append(_overriddenFromDate);
        sb.append(dm).append(_definedBoolean);
        if (sb.length() > 0) { sb.delete(0, dm.length()); }
        sb.insert(0, "{").append("}");
        return sb.toString();
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * [get] normalInteger <br />
     * memberId's comment
     * @return The value of normalInteger. (Nullable, NotEmptyString(when String): if empty string, returns null)
     */
    public Integer getNormalInteger() {
        return _normalInteger;
    }

    /**
     * [set] normalInteger <br />
     * memberId's comment
     * @param normalInteger The value of normalInteger. (NullAllowed)
     */
    public void setNormalInteger(Integer normalInteger) {
        _normalInteger = normalInteger;
    }

    /**
     * [get] noTestValue <br />
     * @return The value of noTestValue. (Nullable, NotEmptyString(when String): if empty string, returns null)
     */
    public String getNoTestValue() {
        return filterStringParameter(_noTestValue);
    }

    /**
     * [set] noTestValue <br />
     * @param noTestValue The value of noTestValue. (NullAllowed)
     */
    public void setNoTestValue(String noTestValue) {
        _noTestValue = noTestValue;
    }

    /**
     * [get] prefixSearchOption:likePrefix <br />
     * @return The value of prefixSearchOption. (Nullable, NotEmptyString(when String): if empty string, returns null)
     */
    public String getPrefixSearchOption() {
        return filterStringParameter(_prefixSearchOption);
    }

    /**
     * [set as prefixSearch] prefixSearchOption:likePrefix <br />
     * @param prefixSearchOption The value of prefixSearchOption. (NullAllowed)
     */
    public void setPrefixSearchOption_PrefixSearch(String prefixSearchOption) {
        _prefixSearchOption = prefixSearchOption;
        _prefixSearchOptionInternalLikeSearchOption = new LikeSearchOption().likePrefix();
    }

    /**
     * Get the internal option of likeSearch for prefixSearchOption. {Internal Method: Don't invoke this}
     * @return The internal option of likeSearch for prefixSearchOption. (NullAllowed)
     */
    public LikeSearchOption getPrefixSearchOptionInternalLikeSearchOption() {
        return _prefixSearchOptionInternalLikeSearchOption;
    }

    /**
     * [get] suffixSearchOption:ref(MEMBER.MEMBER_NAME)|likeSuffix :: refers to (会員名称)MEMBER_NAME: {IX, NotNull, VARCHAR(200)} <br />
     * @return The value of suffixSearchOption. (Nullable, NotEmptyString(when String): if empty string, returns null)
     */
    public String getSuffixSearchOption() {
        return filterStringParameter(_suffixSearchOption);
    }

    /**
     * [set as suffixSearch] suffixSearchOption:ref(MEMBER.MEMBER_NAME)|likeSuffix :: refers to (会員名称)MEMBER_NAME: {IX, NotNull, VARCHAR(200)} <br />
     * @param suffixSearchOption The value of suffixSearchOption. (NullAllowed)
     */
    public void setSuffixSearchOption_SuffixSearch(String suffixSearchOption) {
        _suffixSearchOption = suffixSearchOption;
        _suffixSearchOptionInternalLikeSearchOption = new LikeSearchOption().likeSuffix();
    }

    /**
     * Get the internal option of likeSearch for suffixSearchOption. {Internal Method: Don't invoke this}
     * @return The internal option of likeSearch for suffixSearchOption. (NullAllowed)
     */
    public LikeSearchOption getSuffixSearchOptionInternalLikeSearchOption() {
        return _suffixSearchOptionInternalLikeSearchOption;
    }

    /**
     * [get] containSearchOption:likeContain <br />
     * comment with implicit(likeContain)
     * @return The value of containSearchOption. (Nullable, NotEmptyString(when String): if empty string, returns null)
     */
    public String getContainSearchOption() {
        return filterStringParameter(_containSearchOption);
    }

    /**
     * [set as containSearch] containSearchOption:likeContain <br />
     * comment with implicit(likeContain)
     * @param containSearchOption The value of containSearchOption. (NullAllowed)
     */
    public void setContainSearchOption_ContainSearch(String containSearchOption) {
        _containSearchOption = containSearchOption;
        _containSearchOptionInternalLikeSearchOption = new LikeSearchOption().likeContain();
    }

    /**
     * Get the internal option of likeSearch for containSearchOption. {Internal Method: Don't invoke this}
     * @return The internal option of likeSearch for containSearchOption. (NullAllowed)
     */
    public LikeSearchOption getContainSearchOptionInternalLikeSearchOption() {
        return _containSearchOptionInternalLikeSearchOption;
    }

    /**
     * [get] normalLikeSearchOption:like <br />
     * @return The value of normalLikeSearchOption. (Nullable, NotEmptyString(when String): if empty string, returns null)
     */
    public String getNormalLikeSearchOption() {
        return filterStringParameter(_normalLikeSearchOption);
    }

    /**
     * [set as likeSearch] normalLikeSearchOption:like <br />
     * @param normalLikeSearchOption The value of normalLikeSearchOption. (NullAllowed)
     * @param normalLikeSearchOptionOption The option of likeSearch for normalLikeSearchOption which is NOT split mode. (NotNull)
     */
    public void setNormalLikeSearchOption(String normalLikeSearchOption, LikeSearchOption normalLikeSearchOptionOption) {
        assertLikeSearchOptionValid("normalLikeSearchOptionOption", normalLikeSearchOptionOption);
        _normalLikeSearchOption = normalLikeSearchOption;
        _normalLikeSearchOptionInternalLikeSearchOption = normalLikeSearchOptionOption;
    }

    /**
     * Get the internal option of likeSearch for normalLikeSearchOption. {Internal Method: Don't invoke this}
     * @return The internal option of likeSearch for normalLikeSearchOption. (NullAllowed)
     */
    public LikeSearchOption getNormalLikeSearchOptionInternalLikeSearchOption() {
        return _normalLikeSearchOptionInternalLikeSearchOption;
    }

    /**
     * [get] normalCls:cls(MemberStatus.Withdrawal) <br />
     * fixed classification
     * @return The value of normalCls. (Nullable, NotEmptyString(when String): if empty string, returns null)
     */
    public String getNormalCls() {
        return filterStringParameter(_normalCls);
    }

    /**
     * [get] normalDate <br />
     * @return The value of normalDate. (Nullable, NotEmptyString(when String): if empty string, returns null)
     */
    public Date getNormalDate() {
        return toUtilDate(_normalDate);
    }

    /**
     * [set] normalDate <br />
     * @param normalDate The value of normalDate. (NullAllowed)
     */
    public void setNormalDate(Date normalDate) {
        _normalDate = normalDate;
    }

    /**
     * [get] fromDateOption:fromDate <br />
     * @return The value of fromDateOption. (Nullable, NotEmptyString(when String): if empty string, returns null)
     */
    public Date getFromDateOption() {
        return toUtilDate(_fromDateOption);
    }

    /**
     * [set as fromDate] fromDateOption:fromDate <br />
     * @param fromDateOption The value of fromDateOption. (NullAllowed)
     */
    public void setFromDateOption_FromDate(Date fromDateOption) {
        _fromDateOption = new FromToOption().compareAsDate().filterFromDate(fromDateOption);
    }

    /**
     * [get] toDateOption:toDate <br />
     * @return The value of toDateOption. (Nullable, NotEmptyString(when String): if empty string, returns null)
     */
    public Date getToDateOption() {
        return toUtilDate(_toDateOption);
    }

    /**
     * [set as toDate] toDateOption:toDate <br />
     * @param toDateOption The value of toDateOption. (NullAllowed)
     */
    public void setToDateOption_ToDate(Date toDateOption) {
        _toDateOption = new FromToOption().compareAsDate().filterToDate(toDateOption);
    }

    /**
     * [get] duplicateFromDate:fromDate <br />
     * @return The value of duplicateFromDate. (Nullable, NotEmptyString(when String): if empty string, returns null)
     */
    public Date getDuplicateFromDate() {
        return toUtilDate(_duplicateFromDate);
    }

    /**
     * [set as fromDate] duplicateFromDate:fromDate <br />
     * @param duplicateFromDate The value of duplicateFromDate. (NullAllowed)
     */
    public void setDuplicateFromDate_FromDate(Date duplicateFromDate) {
        _duplicateFromDate = new FromToOption().compareAsDate().filterFromDate(duplicateFromDate);
    }

    /**
     * [get] integerList <br />
     * @return The value of integerList. (Nullable, NotEmptyString(when String): if empty string, returns null)
     */
    public List<Integer> getIntegerList() {
        return _integerList;
    }

    /**
     * [set] integerList <br />
     * @param integerList The value of integerList. (NullAllowed)
     */
    public void setIntegerList(List<Integer> integerList) {
        _integerList = integerList;
    }

    /**
     * [get] cdefList:cls(MemberStatus)|ref(MEMBER.MEMBER_STATUS_CODE) :: refers to (会員ステータスコード)MEMBER_STATUS_CODE: {IX, NotNull, CHAR(3), FK to MEMBER_STATUS, classification=MemberStatus} <br />
     * @return The value of cdefList. (Nullable, NotEmptyString(when String): if empty string, returns null)
     */
    public List<com.example.dbflute.spring.dbflute.allcommon.CDef.MemberStatus> getCdefList() {
        return _cdefList;
    }

    /**
     * [set] cdefList:cls(MemberStatus)|ref(MEMBER.MEMBER_STATUS_CODE) :: refers to (会員ステータスコード)MEMBER_STATUS_CODE: {IX, NotNull, CHAR(3), FK to MEMBER_STATUS, classification=MemberStatus} <br />
     * @param cdefList The value of cdefList. (NullAllowed)
     */
    public void setCdefList(List<com.example.dbflute.spring.dbflute.allcommon.CDef.MemberStatus> cdefList) {
        _cdefList = cdefList;
    }

    /**
     * [get] memberStatusCodeList:cls(MemberStatus)|ref(MEMBER) :: refers to (会員ステータスコード)MEMBER_STATUS_CODE: {IX, NotNull, CHAR(3), FK to MEMBER_STATUS, classification=MemberStatus} <br />
     * @return The value of memberStatusCodeList. (Nullable, NotEmptyString(when String): if empty string, returns null)
     */
    public List<com.example.dbflute.spring.dbflute.allcommon.CDef.MemberStatus> getMemberStatusCodeList() {
        return _memberStatusCodeList;
    }

    /**
     * [set] memberStatusCodeList:cls(MemberStatus)|ref(MEMBER) :: refers to (会員ステータスコード)MEMBER_STATUS_CODE: {IX, NotNull, CHAR(3), FK to MEMBER_STATUS, classification=MemberStatus} <br />
     * @param memberStatusCodeList The value of memberStatusCodeList. (NullAllowed)
     */
    public void setMemberStatusCodeList(List<com.example.dbflute.spring.dbflute.allcommon.CDef.MemberStatus> memberStatusCodeList) {
        _memberStatusCodeList = memberStatusCodeList;
    }

    /**
     * [get] forCommentBasic:likePrefix <br />
     * @return The value of forCommentBasic. (Nullable, NotEmptyString(when String): if empty string, returns null)
     */
    public List<String> getForCommentBasic() {
        return _forCommentBasic;
    }

    /**
     * [set as prefixSearch] forCommentBasic:likePrefix <br />
     * @param forCommentBasic The value of forCommentBasic. (NullAllowed)
     */
    public void setForCommentBasic_PrefixSearch(List<String> forCommentBasic) {
        _forCommentBasic = forCommentBasic;
        _forCommentBasicInternalLikeSearchOption = new LikeSearchOption().likePrefix();
    }

    /**
     * Get the internal option of likeSearch for forCommentBasic. {Internal Method: Don't invoke this}
     * @return The internal option of likeSearch for forCommentBasic. (NullAllowed)
     */
    public LikeSearchOption getForCommentBasicInternalLikeSearchOption() {
        return _forCommentBasicInternalLikeSearchOption;
    }

    /**
     * [get] nestedForList <br />
     * @return The value of nestedForList. (Nullable, NotEmptyString(when String): if empty string, returns null)
     */
    public List<List<List<Integer>>> getNestedForList() {
        return _nestedForList;
    }

    /**
     * [set] nestedForList <br />
     * @param nestedForList The value of nestedForList. (NullAllowed)
     */
    public void setNestedForList(List<List<List<Integer>>> nestedForList) {
        _nestedForList = nestedForList;
    }

    /**
     * [get] bindInIfCommentForList <br />
     * @return The value of bindInIfCommentForList. (Nullable, NotEmptyString(when String): if empty string, returns null)
     */
    public List<Date> getBindInIfCommentForList() {
        return _bindInIfCommentForList;
    }

    /**
     * [set] bindInIfCommentForList <br />
     * @param bindInIfCommentForList The value of bindInIfCommentForList. (NullAllowed)
     */
    public void setBindInIfCommentForList(List<Date> bindInIfCommentForList) {
        _bindInIfCommentForList = bindInIfCommentForList;
    }

    /**
     * [get] ifCommentOnly <br />
     * @return The value of ifCommentOnly. (Nullable, NotEmptyString(when String): if empty string, returns null)
     */
    public boolean getIfCommentOnly() {
        return _ifCommentOnly;
    }

    /**
     * [set] ifCommentOnly <br />
     * @param ifCommentOnly The value of ifCommentOnly. (NullAllowed)
     */
    public void setIfCommentOnly(boolean ifCommentOnly) {
        _ifCommentOnly = ifCommentOnly;
    }

    /**
     * [get] ifCommentAndFirst <br />
     * @return The value of ifCommentAndFirst. (Nullable, NotEmptyString(when String): if empty string, returns null)
     */
    public boolean getIfCommentAndFirst() {
        return _ifCommentAndFirst;
    }

    /**
     * [set] ifCommentAndFirst <br />
     * @param ifCommentAndFirst The value of ifCommentAndFirst. (NullAllowed)
     */
    public void setIfCommentAndFirst(boolean ifCommentAndFirst) {
        _ifCommentAndFirst = ifCommentAndFirst;
    }

    /**
     * [get] ifCommentAndSecond <br />
     * @return The value of ifCommentAndSecond. (Nullable, NotEmptyString(when String): if empty string, returns null)
     */
    public String getIfCommentAndSecond() {
        return filterStringParameter(_ifCommentAndSecond);
    }

    /**
     * [set] ifCommentAndSecond <br />
     * @param ifCommentAndSecond The value of ifCommentAndSecond. (NullAllowed)
     */
    public void setIfCommentAndSecond(String ifCommentAndSecond) {
        _ifCommentAndSecond = ifCommentAndSecond;
    }

    /**
     * [get] ifCommentAndThird <br />
     * @return The value of ifCommentAndThird. (Nullable, NotEmptyString(when String): if empty string, returns null)
     */
    public Integer getIfCommentAndThird() {
        return _ifCommentAndThird;
    }

    /**
     * [set] ifCommentAndThird <br />
     * @param ifCommentAndThird The value of ifCommentAndThird. (NullAllowed)
     */
    public void setIfCommentAndThird(Integer ifCommentAndThird) {
        _ifCommentAndThird = ifCommentAndThird;
    }

    /**
     * [get] ifCommentBooleanNotFormal <br />
     * @return The value of ifCommentBooleanNotFormal. (Nullable, NotEmptyString(when String): if empty string, returns null)
     */
    public boolean getIfCommentBooleanNotFormal() {
        return _ifCommentBooleanNotFormal;
    }

    /**
     * [set] ifCommentBooleanNotFormal <br />
     * @param ifCommentBooleanNotFormal The value of ifCommentBooleanNotFormal. (NullAllowed)
     */
    public void setIfCommentBooleanNotFormal(boolean ifCommentBooleanNotFormal) {
        _ifCommentBooleanNotFormal = ifCommentBooleanNotFormal;
    }

    /**
     * [get] ifCommentBooleanNotWrongSyntax <br />
     * @return The value of ifCommentBooleanNotWrongSyntax. (Nullable, NotEmptyString(when String): if empty string, returns null)
     */
    public String getIfCommentBooleanNotWrongSyntax() {
        return filterStringParameter(_ifCommentBooleanNotWrongSyntax);
    }

    /**
     * [set] ifCommentBooleanNotWrongSyntax <br />
     * @param ifCommentBooleanNotWrongSyntax The value of ifCommentBooleanNotWrongSyntax. (NullAllowed)
     */
    public void setIfCommentBooleanNotWrongSyntax(String ifCommentBooleanNotWrongSyntax) {
        _ifCommentBooleanNotWrongSyntax = ifCommentBooleanNotWrongSyntax;
    }

    /**
     * [get] overriddenFromDate <br />
     * @return The value of overriddenFromDate. (Nullable, NotEmptyString(when String): if empty string, returns null)
     */
    public String getOverriddenFromDate() {
        return filterStringParameter(_overriddenFromDate);
    }

    /**
     * [set] overriddenFromDate <br />
     * @param overriddenFromDate The value of overriddenFromDate. (NullAllowed)
     */
    public void setOverriddenFromDate(String overriddenFromDate) {
        _overriddenFromDate = overriddenFromDate;
    }

    /**
     * [get] definedBoolean <br />
     * @return The value of definedBoolean. (Nullable, NotEmptyString(when String): if empty string, returns null)
     */
    public boolean getDefinedBoolean() {
        return _definedBoolean;
    }

    /**
     * [set] definedBoolean <br />
     * @param definedBoolean The value of definedBoolean. (NullAllowed)
     */
    public void setDefinedBoolean(boolean definedBoolean) {
        _definedBoolean = definedBoolean;
    }
}
