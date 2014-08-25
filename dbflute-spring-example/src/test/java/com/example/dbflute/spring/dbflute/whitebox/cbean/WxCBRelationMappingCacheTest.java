package com.example.dbflute.spring.dbflute.whitebox.cbean;

import java.util.List;

import org.seasar.dbflute.bhv.ConditionBeanSetupper;
import org.seasar.dbflute.bhv.ReferrerLoaderHandler;
import org.seasar.dbflute.cbean.ListResultBean;

import com.example.dbflute.spring.dbflute.bsbhv.loader.LoaderOfMember;
import com.example.dbflute.spring.dbflute.cbean.MemberCB;
import com.example.dbflute.spring.dbflute.cbean.MemberLoginCB;
import com.example.dbflute.spring.dbflute.exbhv.MemberBhv;
import com.example.dbflute.spring.dbflute.exentity.Member;
import com.example.dbflute.spring.dbflute.exentity.MemberLogin;
import com.example.dbflute.spring.dbflute.exentity.MemberStatus;
import com.example.dbflute.spring.unit.UnitContainerTestCase;

/**
 * @author jflute
 * @since 1.0.5K (2014/08/25 Monday)
 */
public class WxCBRelationMappingCacheTest extends UnitContainerTestCase {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private MemberBhv memberBhv;

    // ===================================================================================
    //                                                                      First Relation
    //                                                                      ==============
    public void test_() throws Exception {
        // ## Arrange ##
        // ## Act ##
        ListResultBean<Member> cachedList = selectMemberList(false);
        ListResultBean<Member> nonCachedList = selectMemberList(true);

        // ## Assert ##
        assertHasAnyElement(cachedList);
        assertHasAnyElement(nonCachedList);
        for (int i = 0; i < cachedList.size(); i++) {
            Member cached = cachedList.get(i);
            Member nonCached = nonCachedList.get(i);
            MemberStatus cachedStatus = cached.getMemberStatus();
            MemberStatus nonCachedStatus = nonCached.getMemberStatus();
            List<MemberLogin> cachedLoginList = cachedStatus.getMemberLoginList();
            List<MemberLogin> nonCachedLoginList = nonCachedStatus.getMemberLoginList();
            int cachedLoginSize = cachedLoginList.size();
            int nonCachedLoginSize = nonCachedLoginList.size();
            log(cached.getMemberName(), cachedStatus.getMemberStatusName(), cachedStatus.instanceHash(),
                    nonCachedStatus.instanceHash(), cachedLoginSize, nonCachedLoginSize);
            assertEquals(cached.getMemberName(), nonCached.getMemberName());
            assertEquals(cachedStatus.getMemberStatusName(), nonCachedStatus.getMemberStatusName());
            assertEquals(cachedLoginSize, nonCachedLoginSize);
            if (!cachedLoginList.isEmpty()) {
                markHere("existsLogin");
            }
        }
        assertMarked("existsLogin");
    }

    @SuppressWarnings("deprecation")
    protected ListResultBean<Member> selectMemberList(boolean suppressCache) {
        MemberCB cb = new MemberCB();
        if (suppressCache) {
            cb.disableRelationMappingCache();
        }
        cb.setupSelect_MemberStatus();
        ListResultBean<Member> memberList = memberBhv.selectList(cb);
        memberBhv.load(memberList, new ReferrerLoaderHandler<LoaderOfMember>() {
            public void handle(LoaderOfMember loader) {
                loader.pulloutMemberStatus().loadMemberLoginList(new ConditionBeanSetupper<MemberLoginCB>() {
                    public void setup(MemberLoginCB referrerCB) {
                    }
                });
            }
        });
        return memberList;
    }
}
