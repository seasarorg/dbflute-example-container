package com.example.dbflute.spring.dbflute.whitebox.bhv;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.seasar.dbflute.bhv.InsertOption;
import org.seasar.dbflute.bhv.QueryInsertSetupper;
import org.seasar.dbflute.cbean.ConditionBean;
import org.seasar.dbflute.cbean.ListResultBean;
import org.seasar.dbflute.util.DfCollectionUtil;
import org.seasar.dbflute.util.DfTypeUtil;

import com.example.dbflute.spring.dbflute.cbean.MemberCB;
import com.example.dbflute.spring.dbflute.cbean.MemberWithdrawalCB;
import com.example.dbflute.spring.dbflute.cbean.WithdrawalReasonCB;
import com.example.dbflute.spring.dbflute.exbhv.MemberBhv;
import com.example.dbflute.spring.dbflute.exbhv.MemberWithdrawalBhv;
import com.example.dbflute.spring.dbflute.exbhv.WithdrawalReasonBhv;
import com.example.dbflute.spring.dbflute.exentity.Member;
import com.example.dbflute.spring.dbflute.exentity.MemberWithdrawal;
import com.example.dbflute.spring.dbflute.exentity.WithdrawalReason;
import com.example.dbflute.spring.unit.UnitContainerTestCase;

/**
 * @author jflute
 * @since 0.9.7.9 (2011/01/08 Saturday)
 */
public class WxBhvVaryingQueryInsertTest extends UnitContainerTestCase {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private MemberBhv memberBhv;
    private WithdrawalReasonBhv withdrawalReasonBhv;
    private MemberWithdrawalBhv memberWithdrawalBhv;

    // ===================================================================================
    //                                                                       Common Column
    //                                                                       =============
    public void test_varyingQueryInsert_disableCommonColumnAutoSetup() { // and same column
        // ## Arrange ##
        int countAll = memberWithdrawalBhv.selectCount(new MemberWithdrawalCB());
        Map<Integer, Member> formalizedMemberMap = new LinkedHashMap<Integer, Member>();
        {
            MemberCB cb = new MemberCB();
            cb.query().setMemberStatusCode_Equal_Formalized();
            ListResultBean<Member> memberList = memberBhv.selectList(cb);
            for (Member member : memberList) {
                formalizedMemberMap.put(member.getMemberId(), member);
            }
        }
        final WithdrawalReason firstReason;
        {
            WithdrawalReasonCB cb = new WithdrawalReasonCB();
            cb.fetchFirst(1);
            firstReason = withdrawalReasonBhv.selectEntityWithDeletedCheck(cb);
        }

        // ## Act ##
        int inserted = memberWithdrawalBhv.varyingQueryInsert(
                new QueryInsertSetupper<MemberWithdrawal, MemberWithdrawalCB>() {
                    public ConditionBean setup(MemberWithdrawal entity, MemberWithdrawalCB intoCB) {
                        entity.setWithdrawalReasonCode(firstReason.getWithdrawalReasonCode());
                        MemberCB cb = new MemberCB();

                        intoCB.specify().columnMemberId().mappedFrom(cb.specify().columnMemberId());
                        intoCB.specify().columnWithdrawalDatetime().mappedFrom(cb.specify().columnFormalizedDatetime());
                        intoCB.specify().columnWithdrawalReasonInputText().mappedFrom(cb.specify().columnMemberName());
                        intoCB.specify().columnRegisterDatetime().mappedFrom(cb.specify().columnFormalizedDatetime());
                        intoCB.specify().columnRegisterUser().mappedFrom(cb.specify().columnMemberName());
                        intoCB.specify().columnUpdateDatetime().mappedFrom(cb.specify().columnFormalizedDatetime());
                        intoCB.specify().columnUpdateUser().mappedFrom(cb.specify().columnMemberName());

                        cb.query().setMemberStatusCode_Equal_Formalized();
                        return cb;
                    }
                }, new InsertOption<MemberWithdrawalCB>().disableCommonColumnAutoSetup());

        // ## Assert ##
        assertNotSame(0, inserted);
        int actualCountAll = memberWithdrawalBhv.selectCount(new MemberWithdrawalCB());
        assertNotSame(countAll, actualCountAll);
        assertTrue(countAll < actualCountAll);
        assertEquals(actualCountAll - countAll, inserted);

        MemberWithdrawalCB cb = new MemberWithdrawalCB();
        List<Integer> memberIdList = DfCollectionUtil.newArrayList();
        for (Member member : formalizedMemberMap.values()) {
            memberIdList.add(member.getMemberId());
        }
        cb.query().setMemberId_InScope(memberIdList);
        ListResultBean<MemberWithdrawal> actualList = memberWithdrawalBhv.selectList(cb);
        assertNotSame(0, actualList.size());
        assertEquals(memberIdList.size(), actualList.size());
        String fmt = "yyyy-MM-dd HH:mm:ss.SSS";
        for (MemberWithdrawal actual : actualList) {
            String withdrawalReasonCode = actual.getWithdrawalReasonCode();
            assertNotNull(withdrawalReasonCode);
            assertEquals(firstReason.getWithdrawalReasonCode(), withdrawalReasonCode);
            Member member = formalizedMemberMap.get(actual.getMemberId());

            // common columns
            String formalizedDatetime = DfTypeUtil.toString(member.getFormalizedDatetime(), fmt);
            assertEquals(member.getMemberName(), actual.getWithdrawalReasonInputText());
            assertEquals(formalizedDatetime, DfTypeUtil.toString(actual.getRegisterDatetime(), fmt));
            assertEquals(member.getMemberName(), actual.getRegisterUser());
            assertEquals(formalizedDatetime, DfTypeUtil.toString(actual.getUpdateDatetime(), fmt));
            assertEquals(member.getMemberName(), actual.getUpdateUser());
        }
    }
}
