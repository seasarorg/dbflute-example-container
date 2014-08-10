package com.example.dbflute.guice.dbflute.bsbhv.pmbean;

import java.util.*;

import org.seasar.dbflute.outsidesql.typed.*;
import org.seasar.dbflute.jdbc.*;
import org.seasar.dbflute.jdbc.ParameterUtil.ShortCharHandlingMode;
import org.seasar.dbflute.cbean.coption.LikeSearchOption;
import org.seasar.dbflute.cbean.coption.FromToOption;
import org.seasar.dbflute.util.DfCollectionUtil;
import org.seasar.dbflute.exception.*;
import org.seasar.dbflute.util.DfTypeUtil;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.ReadableInstant;
import org.joda.time.ReadablePartial;
import com.example.dbflute.guice.dbflute.allcommon.*;
import com.example.dbflute.guice.dbflute.exbhv.*;
import com.example.dbflute.guice.dbflute.exentity.customize.*;

/**
 * The base class for typed parameter-bean of OptionMember. <br />
 * This is related to "<span style="color: #AD4747">selectOptionMember</span>" on MemberBhv.
 * @author DBFlute(AutoGenerator)
 */
public class BsOptionMemberPmb implements ListHandlingPmb<MemberBhv, OptionMember>, EntityHandlingPmb<MemberBhv, OptionMember>, FetchBean {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** The parameter of memberId. */
    protected Integer _memberId;

    /** The parameter of memberName:likePrefix. */
    protected String _memberName;

    /** The option of like-search for memberName. */
    protected LikeSearchOption _memberNameInternalLikeSearchOption;

    /** The parameter of memberAccount:like. */
    protected String _memberAccount;

    /** The option of like-search for memberAccount. */
    protected LikeSearchOption _memberAccountInternalLikeSearchOption;

    /** The parameter of fromFormalizedDate:fromDate. */
    protected org.joda.time.LocalDate _fromFormalizedDate;

    /** The parameter of toFormalizedDate:toDate. */
    protected org.joda.time.LocalDate _toFormalizedDate;

    /** The parameter of fromFormalizedOptionDate:fromDate(option). */
    protected org.joda.time.LocalDate _fromFormalizedOptionDate;

    /** The parameter of toFormalizedOptionDate:toDate(option). */
    protected org.joda.time.LocalDate _toFormalizedOptionDate;

    /** The parameter of memberStatusCode:cls(MemberStatus). */
    protected String _memberStatusCode;

    /** The parameter of displayOrder:ref(MemberStatus) :: refers to (表示順)DISPLAY_ORDER: {UQ, NotNull, INTEGER(10)}. */
    protected Integer _displayOrder;

    /** The parameter of birthdate:fromDate|ref(Member) :: refers to (生年月日)BIRTHDATE: {DATE(8)}. */
    protected org.joda.time.LocalDate _birthdate;

    /** The parameter of status:cls(MemberStatus)|ref(Member.MEMBER_STATUS_CODE) :: refers to (会員ステータスコード)MEMBER_STATUS_CODE: {IX, NotNull, CHAR(3), FK to MEMBER_STATUS, classification=MemberStatus}. */
    protected String _status;

    /** The max size of safety result. */
    protected int _safetyMaxResultSize;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    /**
     * Constructor for the typed parameter-bean of OptionMember. <br />
     * This is related to "<span style="color: #AD4747">selectOptionMember</span>" on MemberBhv.
     */
    public BsOptionMemberPmb() {
    }

    // ===================================================================================
    //                                                                Typed Implementation
    //                                                                ====================
    /**
     * {@inheritDoc}
     */
    public String getOutsideSqlPath() {
        return "selectOptionMember";
    }

    /**
     * Get the type of an entity for result. (implementation)
     * @return The type instance of an entity, customize entity. (NotNull)
     */
    public Class<OptionMember> getEntityType() {
        return OptionMember.class;
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
        return ShortCharHandlingMode.EXCEPTION;
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

    protected Date toUtilDate(Object date) {
        if (date != null && date instanceof ReadablePartial) {
            return new Date(((ReadablePartial) date).toDateTime(null).getMillis());
        } else if (date != null && date instanceof ReadableInstant) {
            return new Date(((ReadableInstant) date).getMillis());
        }
        return DfTypeUtil.toDate(date); // if sub class, re-create as pure date
    }

    @SuppressWarnings("unchecked")
    protected <DATE> DATE toLocalDate(Date date, Class<DATE> localType) {
        if (LocalDate.class.isAssignableFrom(localType)) {
            return (DATE)LocalDate.fromDateFields(date);
        } else if (LocalDateTime.class.isAssignableFrom(localType)) {
            return (DATE)LocalDateTime.fromDateFields(date);
        }
        return null; // unreachable
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
        sb.append(dm).append(_memberId);
        sb.append(dm).append(_memberName);
        sb.append(dm).append(_memberAccount);
        sb.append(dm).append(_fromFormalizedDate);
        sb.append(dm).append(_toFormalizedDate);
        sb.append(dm).append(_fromFormalizedOptionDate);
        sb.append(dm).append(_toFormalizedOptionDate);
        sb.append(dm).append(_memberStatusCode);
        sb.append(dm).append(_displayOrder);
        sb.append(dm).append(_birthdate);
        sb.append(dm).append(_status);
        if (sb.length() > 0) { sb.delete(0, dm.length()); }
        sb.insert(0, "{").append("}");
        return sb.toString();
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * [get] memberId <br />
     * @return The value of memberId. (Nullable, NotEmptyString(when String): if empty string, returns null)
     */
    public Integer getMemberId() {
        return _memberId;
    }

    /**
     * [set] memberId <br />
     * @param memberId The value of memberId. (NullAllowed)
     */
    public void setMemberId(Integer memberId) {
        _memberId = memberId;
    }

    /**
     * [get] memberName:likePrefix <br />
     * @return The value of memberName. (Nullable, NotEmptyString(when String): if empty string, returns null)
     */
    public String getMemberName() {
        return filterStringParameter(_memberName);
    }

    /**
     * [set as prefixSearch] memberName:likePrefix <br />
     * @param memberName The value of memberName. (NullAllowed)
     */
    public void setMemberName_PrefixSearch(String memberName) {
        _memberName = memberName;
        _memberNameInternalLikeSearchOption = new LikeSearchOption().likePrefix();
    }

    /**
     * Get the internal option of likeSearch for memberName. {Internal Method: Don't invoke this}
     * @return The internal option of likeSearch for memberName. (NullAllowed)
     */
    public LikeSearchOption getMemberNameInternalLikeSearchOption() {
        return _memberNameInternalLikeSearchOption;
    }

    /**
     * [get] memberAccount:like <br />
     * @return The value of memberAccount. (Nullable, NotEmptyString(when String): if empty string, returns null)
     */
    public String getMemberAccount() {
        return filterStringParameter(_memberAccount);
    }

    /**
     * [set as likeSearch] memberAccount:like <br />
     * @param memberAccount The value of memberAccount. (NullAllowed)
     * @param memberAccountOption The option of likeSearch for memberAccount which is NOT split mode. (NotNull)
     */
    public void setMemberAccount(String memberAccount, LikeSearchOption memberAccountOption) {
        assertLikeSearchOptionValid("memberAccountOption", memberAccountOption);
        _memberAccount = memberAccount;
        _memberAccountInternalLikeSearchOption = memberAccountOption;
    }

    /**
     * Get the internal option of likeSearch for memberAccount. {Internal Method: Don't invoke this}
     * @return The internal option of likeSearch for memberAccount. (NullAllowed)
     */
    public LikeSearchOption getMemberAccountInternalLikeSearchOption() {
        return _memberAccountInternalLikeSearchOption;
    }

    /**
     * [get] fromFormalizedDate:fromDate <br />
     * @return The value of fromFormalizedDate. (Nullable, NotEmptyString(when String): if empty string, returns null)
     */
    public org.joda.time.LocalDate getFromFormalizedDate() {
        return _fromFormalizedDate;
    }

    /**
     * [set as fromDate] fromFormalizedDate:fromDate <br />
     * @param fromFormalizedDate The value of fromFormalizedDate. (NullAllowed)
     */
    public void setFromFormalizedDate_FromDate(org.joda.time.LocalDate fromFormalizedDate) {
        _fromFormalizedDate = toLocalDate(new FromToOption().compareAsDate().filterFromDate(toUtilDate(fromFormalizedDate)), org.joda.time.LocalDate.class);
    }

    /**
     * [get] toFormalizedDate:toDate <br />
     * @return The value of toFormalizedDate. (Nullable, NotEmptyString(when String): if empty string, returns null)
     */
    public org.joda.time.LocalDate getToFormalizedDate() {
        return _toFormalizedDate;
    }

    /**
     * [set as toDate] toFormalizedDate:toDate <br />
     * @param toFormalizedDate The value of toFormalizedDate. (NullAllowed)
     */
    public void setToFormalizedDate_ToDate(org.joda.time.LocalDate toFormalizedDate) {
        _toFormalizedDate = toLocalDate(new FromToOption().compareAsDate().filterToDate(toUtilDate(toFormalizedDate)), org.joda.time.LocalDate.class);
    }

    /**
     * [get] fromFormalizedOptionDate:fromDate(option) <br />
     * @return The value of fromFormalizedOptionDate. (Nullable, NotEmptyString(when String): if empty string, returns null)
     */
    public org.joda.time.LocalDate getFromFormalizedOptionDate() {
        return _fromFormalizedOptionDate;
    }

    /**
     * [set as fromScope] fromFormalizedOptionDate:fromDate(option) <br />
     * @param fromFormalizedOptionDate The value of fromFormalizedOptionDate. (NullAllowed)
     * @param fromFormalizedOptionDateOption The option of from-to scope for fromFormalizedOptionDate. (NotNull)
     */
    public void setFromFormalizedOptionDate_FromDate(org.joda.time.LocalDate fromFormalizedOptionDate, FromToOption fromFormalizedOptionDateOption) {
        assertFromToOptionValid("fromFormalizedOptionDateOption", fromFormalizedOptionDateOption);
        _fromFormalizedOptionDate = toLocalDate(fromFormalizedOptionDateOption.filterFromDate(toUtilDate(fromFormalizedOptionDate)), org.joda.time.LocalDate.class);
    }

    /**
     * [get] toFormalizedOptionDate:toDate(option) <br />
     * @return The value of toFormalizedOptionDate. (Nullable, NotEmptyString(when String): if empty string, returns null)
     */
    public org.joda.time.LocalDate getToFormalizedOptionDate() {
        return _toFormalizedOptionDate;
    }

    /**
     * [set as toScope] toFormalizedOptionDate:toDate(option) <br />
     * @param toFormalizedOptionDate The value of toFormalizedOptionDate. (NullAllowed)
     * @param toFormalizedOptionDateOption The option of from-to scope for toFormalizedOptionDate. (NotNull)
     */
    public void setToFormalizedOptionDate_ToDate(org.joda.time.LocalDate toFormalizedOptionDate, FromToOption toFormalizedOptionDateOption) {
        assertFromToOptionValid("toFormalizedOptionDateOption", toFormalizedOptionDateOption);
        _toFormalizedOptionDate = toLocalDate(toFormalizedOptionDateOption.filterToDate(toUtilDate(toFormalizedOptionDate)), org.joda.time.LocalDate.class);
    }

    /**
     * [get] memberStatusCode:cls(MemberStatus) <br />
     * @return The value of memberStatusCode. (Nullable, NotEmptyString(when String): if empty string, returns null)
     */
    public String getMemberStatusCode() {
        return filterStringParameter(_memberStatusCode);
    }

    /**
     * [set] memberStatusCode:cls(MemberStatus) <br />
     * @param memberStatusCode The value of memberStatusCode. (NullAllowed)
     */
    public void setMemberStatusCode(String memberStatusCode) {
        _memberStatusCode = memberStatusCode;
    }

    /**
     * [set as Formalized] memberStatusCode:cls(MemberStatus) <br />
     * as formal member, allowed to use all service
     */
    public void setMemberStatusCode_Formalized() {
        _memberStatusCode = CDef.MemberStatus.Formalized.code();
    }

    /**
     * [set as Withdrawal] memberStatusCode:cls(MemberStatus) <br />
     * withdrawal is fixed, not allowed to use service
     */
    public void setMemberStatusCode_Withdrawal() {
        _memberStatusCode = CDef.MemberStatus.Withdrawal.code();
    }

    /**
     * [set as Provisional] memberStatusCode:cls(MemberStatus) <br />
     * first status after entry, allowed to use only part of service
     */
    public void setMemberStatusCode_Provisional() {
        _memberStatusCode = CDef.MemberStatus.Provisional.code();
    }

    /**
     * [get] displayOrder:ref(MemberStatus) :: refers to (表示順)DISPLAY_ORDER: {UQ, NotNull, INTEGER(10)} <br />
     * @return The value of displayOrder. (Nullable, NotEmptyString(when String): if empty string, returns null)
     */
    public Integer getDisplayOrder() {
        return _displayOrder;
    }

    /**
     * [set] displayOrder:ref(MemberStatus) :: refers to (表示順)DISPLAY_ORDER: {UQ, NotNull, INTEGER(10)} <br />
     * @param displayOrder The value of displayOrder. (NullAllowed)
     */
    public void setDisplayOrder(Integer displayOrder) {
        _displayOrder = displayOrder;
    }

    /**
     * [get] birthdate:fromDate|ref(Member) :: refers to (生年月日)BIRTHDATE: {DATE(8)} <br />
     * @return The value of birthdate. (Nullable, NotEmptyString(when String): if empty string, returns null)
     */
    public org.joda.time.LocalDate getBirthdate() {
        return _birthdate;
    }

    /**
     * [set as fromDate] birthdate:fromDate|ref(Member) :: refers to (生年月日)BIRTHDATE: {DATE(8)} <br />
     * @param birthdate The value of birthdate. (NullAllowed)
     */
    public void setBirthdate_FromDate(org.joda.time.LocalDate birthdate) {
        _birthdate = toLocalDate(new FromToOption().compareAsDate().filterFromDate(toUtilDate(birthdate)), org.joda.time.LocalDate.class);
    }

    /**
     * [get] status:cls(MemberStatus)|ref(Member.MEMBER_STATUS_CODE) :: refers to (会員ステータスコード)MEMBER_STATUS_CODE: {IX, NotNull, CHAR(3), FK to MEMBER_STATUS, classification=MemberStatus} <br />
     * @return The value of status. (Nullable, NotEmptyString(when String): if empty string, returns null)
     */
    public String getStatus() {
        String filtered = filterStringParameter(_status);
        filtered = handleShortChar("status", filtered, 3);
        return filtered;
    }

    /**
     * [set] status:cls(MemberStatus)|ref(Member.MEMBER_STATUS_CODE) :: refers to (会員ステータスコード)MEMBER_STATUS_CODE: {IX, NotNull, CHAR(3), FK to MEMBER_STATUS, classification=MemberStatus} <br />
     * @param status The value of status. (NullAllowed)
     */
    public void setStatus(String status) {
        _status = status;
    }

    /**
     * [set as Formalized] status:cls(MemberStatus)|ref(Member.MEMBER_STATUS_CODE) :: refers to (会員ステータスコード)MEMBER_STATUS_CODE: {IX, NotNull, CHAR(3), FK to MEMBER_STATUS, classification=MemberStatus} <br />
     * as formal member, allowed to use all service
     */
    public void setStatus_Formalized() {
        _status = CDef.MemberStatus.Formalized.code();
    }

    /**
     * [set as Withdrawal] status:cls(MemberStatus)|ref(Member.MEMBER_STATUS_CODE) :: refers to (会員ステータスコード)MEMBER_STATUS_CODE: {IX, NotNull, CHAR(3), FK to MEMBER_STATUS, classification=MemberStatus} <br />
     * withdrawal is fixed, not allowed to use service
     */
    public void setStatus_Withdrawal() {
        _status = CDef.MemberStatus.Withdrawal.code();
    }

    /**
     * [set as Provisional] status:cls(MemberStatus)|ref(Member.MEMBER_STATUS_CODE) :: refers to (会員ステータスコード)MEMBER_STATUS_CODE: {IX, NotNull, CHAR(3), FK to MEMBER_STATUS, classification=MemberStatus} <br />
     * first status after entry, allowed to use only part of service
     */
    public void setStatus_Provisional() {
        _status = CDef.MemberStatus.Provisional.code();
    }
}
