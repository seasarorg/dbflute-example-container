package com.example.dbflute.spring.dbflute.whitebox.entity;

import java.util.List;

import org.seasar.dbflute.dbmeta.info.ForeignInfo;
import org.seasar.dbflute.dbmeta.info.ReferrerInfo;
import org.seasar.dbflute.unit.core.PlainTestCase;

import com.example.dbflute.spring.dbflute.bsentity.dbmeta.MemberDbm;
import com.example.dbflute.spring.dbflute.bsentity.dbmeta.MemberStatusDbm;
import com.example.dbflute.spring.dbflute.exentity.Member;
import com.example.dbflute.spring.dbflute.exentity.MemberStatus;
import com.example.dbflute.spring.dbflute.exentity.Purchase;

/**
 * @author jflute
 * @since 0.9.9.3D (2012/03/24 Saturday)
 */
public class WxDBMetaRelationInfoTest extends PlainTestCase {

    // ===================================================================================
    //                                                                        Foreign Info
    //                                                                        ============
    public void test_foreignInfo_manyToOne() {
        // ## Arrange & Act ##
        ForeignInfo foreignInfo = MemberDbm.getInstance().foreignMemberStatus();

        // ## Assert ##
        assertNotNull(foreignInfo);
        assertNotNull(foreignInfo.getForeignPropertyName());
        assertEquals(MemberStatusDbm.getInstance().referrerMemberList(), foreignInfo.getReverseRelation());
    }

    public void test_foreignInfo_read() {
        // ## Arrange ##
        ForeignInfo foreignInfo = MemberDbm.getInstance().foreignMemberStatus();
        Member member = new Member();
        MemberStatus memberStatus = new MemberStatus();
        memberStatus.setMemberStatusCode("foo");
        memberStatus.setMemberStatusName("bar");
        member.setMemberStatus(memberStatus);

        // ## Act ##
        MemberStatus actualStatus = (MemberStatus) foreignInfo.read(member);

        // ## Assert ##
        assertNotNull(actualStatus);
        assertEquals(memberStatus, actualStatus);
        assertEquals("foo", actualStatus.getMemberStatusCode());
        assertEquals("bar", actualStatus.getMemberStatusName());
    }

    public void test_foreignInfo_write() {
        // ## Arrange ##
        ForeignInfo foreignInfo = MemberDbm.getInstance().foreignMemberStatus();
        Member member = new Member();
        MemberStatus memberStatus = new MemberStatus();
        memberStatus.setMemberStatusCode("foo");
        memberStatus.setMemberStatusName("bar");

        // ## Act ##
        foreignInfo.write(member, memberStatus);

        // ## Assert ##
        MemberStatus actualStatus = member.getMemberStatus();
        assertNotNull(actualStatus);
        assertEquals(memberStatus, actualStatus);
        assertEquals("foo", actualStatus.getMemberStatusCode());
        assertEquals("bar", actualStatus.getMemberStatusName());
    }

    // ===================================================================================
    //                                                                       Referrer Info
    //                                                                       =============
    public void test_referrerInfo_read() {
        // ## Arrange ##
        ReferrerInfo referrerInfo = MemberDbm.getInstance().referrerPurchaseList();
        Member member = new Member();
        List<Purchase> purchaseList = newArrayList();
        Purchase purchase1 = new Purchase();
        purchase1.setPurchaseId(1L);
        purchaseList.add(purchase1);
        Purchase purchase2 = new Purchase();
        purchase2.setPurchaseId(2L);
        purchaseList.add(purchase2);
        member.setPurchaseList(purchaseList);

        // ## Act ##
        @SuppressWarnings("unchecked")
        List<Purchase> actualList = (List<Purchase>) referrerInfo.read(member);

        // ## Assert ##
        assertNotNull(actualList);
        assertEquals(purchaseList, actualList);
    }

    public void test_referrerInfo_write() {
        // ## Arrange ##
        ReferrerInfo referrerInfo = MemberDbm.getInstance().referrerPurchaseList();
        Member member = new Member();
        List<Purchase> purchaseList = newArrayList();
        Purchase purchase1 = new Purchase();
        purchase1.setPurchaseId(1L);
        purchaseList.add(purchase1);
        Purchase purchase2 = new Purchase();
        purchase2.setPurchaseId(2L);
        purchaseList.add(purchase2);
        member.setPurchaseList(purchaseList);

        // ## Act ##
        referrerInfo.write(member, purchaseList);

        // ## Assert ##
        List<Purchase> actualList = member.getPurchaseList();
        assertNotNull(actualList);
        assertEquals(purchaseList, actualList);
    }
}
