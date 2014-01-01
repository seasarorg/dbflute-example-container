package com.example.dbflute.spring.dbflute.whitebox.runtime;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.seasar.dbflute.cbean.ListResultBean;
import org.seasar.dbflute.cbean.extracting.EntityColumnExtractor;
import org.seasar.dbflute.cbean.grouping.GroupingListDeterminer;
import org.seasar.dbflute.cbean.grouping.GroupingListRowResource;
import org.seasar.dbflute.cbean.grouping.GroupingMapDeterminer;
import org.seasar.dbflute.cbean.grouping.GroupingOption;
import org.seasar.dbflute.cbean.grouping.GroupingRowEndDeterminer;
import org.seasar.dbflute.cbean.grouping.GroupingRowResource;
import org.seasar.dbflute.cbean.grouping.GroupingRowSetupper;

import com.example.dbflute.spring.dbflute.cbean.MemberCB;
import com.example.dbflute.spring.dbflute.exbhv.MemberBhv;
import com.example.dbflute.spring.dbflute.exentity.Member;
import com.example.dbflute.spring.unit.UnitContainerTestCase;

/**
 * @author jflute
 * @since 1.0.1 (2012/12/17 Monday)
 */
public class WxListResultBeanTest extends UnitContainerTestCase {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private MemberBhv memberBhv;

    // ===================================================================================
    //                                                                       Grouping List
    //                                                                       =============
    public void test_groupingList_count() {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.query().addOrderBy_MemberName_Asc();
        ListResultBean<Member> memberList = memberBhv.selectList(cb);
        log("ListResultBean.toString():" + ln() + " " + memberList);

        // ## Act ##
        List<ListResultBean<Member>> groupingList = memberList.groupingList(new GroupingListDeterminer<Member>() {
            public boolean isBreakRow(GroupingListRowResource<Member> rowResource, Member nextEntity) {
                return rowResource.getNextIndex() >= 3;
            }
        });

        // ## Assert ##
        assertFalse(groupingList.isEmpty());
        int rowIndex = 0;
        for (ListResultBean<Member> elementList : groupingList) {
            log("[" + rowIndex + "]: " + elementList.size());
            for (Member member : elementList) {
                log("  " + member);
            }
            assertTrue(elementList.size() <= 3);
            assertEquals(memberList.getTableDbName(), elementList.getTableDbName());
            assertEquals(memberList.getAllRecordCount(), elementList.getAllRecordCount());
            assertEquals(memberList.getOrderByClause(), elementList.getOrderByClause());
            ++rowIndex;
        }
    }

    public void test_groupingList_initChar() {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.query().addOrderBy_MemberName_Asc();
        ListResultBean<Member> memberList = memberBhv.selectList(cb);
        log("ListResultBean.toString():" + ln() + " " + memberList);

        // ## Act ##
        List<ListResultBean<Member>> groupingList = memberList.groupingList(new GroupingListDeterminer<Member>() {
            public boolean isBreakRow(GroupingListRowResource<Member> rowResource, Member nextEntity) {
                Member currentEntity = rowResource.getCurrentEntity();
                String currentInitChar = currentEntity.getMemberName().substring(0, 1);
                String nextInitChar = nextEntity.getMemberName().substring(0, 1);
                return !currentInitChar.equalsIgnoreCase(nextInitChar);
            }
        });

        // ## Assert ##
        assertFalse(groupingList.isEmpty());
        int entityCount = 0;
        for (ListResultBean<Member> elementList : groupingList) {
            String currentInitChar = null;
            for (Member member : elementList) {
                if (currentInitChar == null) {
                    currentInitChar = member.getMemberName().substring(0, 1);
                    log("[" + currentInitChar + "]");
                }
                log("  " + member.getMemberName() + ", " + member);
                assertEquals(currentInitChar, member.getMemberName().substring(0, 1));
                ++entityCount;
            }
        }
        assertEquals(memberList.size(), entityCount);
    }

    // ===================================================================================
    //                                                                        Grouping Map
    //                                                                        ============
    public void test_groupingMap_initChar() {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.query().addOrderBy_MemberName_Asc();
        ListResultBean<Member> memberList = memberBhv.selectList(cb);
        log("ListResultBean.toString():" + ln() + " " + memberList);

        // ## Act ##
        Map<String, ListResultBean<Member>> groupingMap = memberList.groupingMap(new GroupingMapDeterminer<Member>() {
            public String provideKey(Member entity) {
                return entity.getMemberName().substring(0, 1);
            }
        });

        // ## Assert ##
        assertHasAnyElement(groupingMap.keySet());
        Set<Entry<String, ListResultBean<Member>>> entrySet = groupingMap.entrySet();
        for (Entry<String, ListResultBean<Member>> entry : entrySet) {
            String initChar = entry.getKey();
            ListResultBean<Member> elementList = entry.getValue();
            log("[" + initChar + "]");
            for (Member member : elementList) {
                log("  " + member.getMemberName() + ", " + member);
                assertEquals(initChar, member.getMemberName().substring(0, 1));
            }
            assertEquals(memberList.getTableDbName(), elementList.getTableDbName());
            assertEquals(memberList.getAllRecordCount(), elementList.getAllRecordCount());
            assertEquals(memberList.getOrderByClause(), elementList.getOrderByClause());
        }
    }

    // ===================================================================================
    //                                                                   old Grouping List
    //                                                                   =================
    public void test_old_groupingList_count() {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.query().addOrderBy_MemberName_Asc();
        ListResultBean<Member> memberList = memberBhv.selectList(cb);
        log("ListResultBean.toString():" + ln() + " " + memberList);

        // ## Act ##
        GroupingOption<Member> groupingOption = new GroupingOption<Member>(3);
        @SuppressWarnings("deprecation")
        List<List<Member>> groupingList = memberList.groupingList(new GroupingRowSetupper<List<Member>, Member>() {
            public List<Member> setup(GroupingRowResource<Member> groupingRowResource) {
                return new ArrayList<Member>(groupingRowResource.getGroupingRowList());
            }
        }, groupingOption);

        // ## Assert ##
        assertFalse(groupingList.isEmpty());
        int rowIndex = 0;
        for (List<Member> elementList : groupingList) {
            assertTrue(elementList.size() <= 3);
            log("[" + rowIndex + "]");
            for (Member member : elementList) {
                log("  " + member);
            }
            ++rowIndex;
        }
    }

    public void test_old_groupingList_determine() {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.query().addOrderBy_MemberName_Asc();
        ListResultBean<Member> memberList = memberBhv.selectList(cb);
        log("ListResultBean.toString():" + ln() + " " + memberList);

        // ## Act ##
        GroupingOption<Member> groupingOption = new GroupingOption<Member>(); // The breakCount is unnecessary in this case.
        groupingOption.setGroupingRowEndDeterminer(new GroupingRowEndDeterminer<Member>() {
            public boolean determine(GroupingRowResource<Member> rowResource, Member nextEntity) {
                Member currentEntity = rowResource.getCurrentEntity();
                String currentInitChar = currentEntity.getMemberName().substring(0, 1);
                String nextInitChar = nextEntity.getMemberName().substring(0, 1);
                return !currentInitChar.equalsIgnoreCase(nextInitChar);
            }
        });
        @SuppressWarnings("deprecation")
        List<List<Member>> groupingList = memberList.groupingList(new GroupingRowSetupper<List<Member>, Member>() {
            public List<Member> setup(GroupingRowResource<Member> groupingRowResource) {
                return new ArrayList<Member>(groupingRowResource.getGroupingRowList());
            }
        }, groupingOption);

        // ## Assert ##
        assertFalse(groupingList.isEmpty());
        int entityCount = 0;
        for (List<Member> elementList : groupingList) {
            String currentInitChar = null;
            for (Member member : elementList) {
                if (currentInitChar == null) {
                    currentInitChar = member.getMemberName().substring(0, 1);
                    log("[" + currentInitChar + "]");
                }
                log("  " + member.getMemberName() + ", " + member);
                assertEquals(currentInitChar, member.getMemberName().substring(0, 1));
                ++entityCount;
            }
        }
        assertEquals(memberList.size(), entityCount);
    }

    public void test_old_groupingList_determineWithCount() {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.query().addOrderBy_MemberName_Asc();
        ListResultBean<Member> memberList = memberBhv.selectList(cb);
        log("ListResultBean.toString():" + ln() + " " + memberList);

        // ## Act ##
        GroupingOption<Member> groupingOption = new GroupingOption<Member>(3);
        groupingOption.setGroupingRowEndDeterminer(new GroupingRowEndDeterminer<Member>() {
            public boolean determine(GroupingRowResource<Member> rowResource, Member nextEntity) {
                Member currentEntity = rowResource.getCurrentEntity();
                String currentInitChar = currentEntity.getMemberName().substring(0, 1);
                String nextInitChar = nextEntity.getMemberName().substring(0, 1);
                return !currentInitChar.equalsIgnoreCase(nextInitChar);
            }
        });
        @SuppressWarnings("deprecation")
        List<List<Member>> groupingList = memberList.groupingList(new GroupingRowSetupper<List<Member>, Member>() {
            public List<Member> setup(GroupingRowResource<Member> groupingRowResource) {
                return new ArrayList<Member>(groupingRowResource.getGroupingRowList());
            }
        }, groupingOption);

        // ## Assert ##
        assertFalse(groupingList.isEmpty());
        int entityCount = 0;
        for (List<Member> elementList : groupingList) {
            String currentInitChar = null;
            for (Member member : elementList) {
                if (currentInitChar == null) {
                    currentInitChar = member.getMemberName().substring(0, 1);
                    log("[" + currentInitChar + "]");
                }
                log("  " + member.getMemberName() + ", " + member);
                assertEquals(currentInitChar, member.getMemberName().substring(0, 1));
                ++entityCount;
            }
        }
        assertEquals(memberList.size(), entityCount);
    }

    // ===================================================================================
    //                                                                      Extract Column
    //                                                                      ==============
    public void test_extractColumnList_basic() {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.setupSelect_MemberStatus();
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Act ##
        List<Integer> memberIdList = memberList.extractColumnList(new EntityColumnExtractor<Member, Integer>() {
            public Integer extract(Member entity) {
                return entity.getMemberId();
            }
        });

        // ## Assert ##
        assertHasAnyElement(memberIdList);
        log(memberIdList);
        List<Integer> expectedIdList = memberBhv.extractMemberIdList(memberList);
        assertEquals(expectedIdList, memberIdList);
    }

    public void test_extractColumnList_NotNullElement() {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.setupSelect_MemberStatus();
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Act ##
        Set<Date> birthdateSet = memberList.extractColumnSet(new EntityColumnExtractor<Member, Date>() {
            public Date extract(Member entity) {
                return entity.getBirthdate();
            }
        });

        // ## Assert ##
        assertHasAnyElement(birthdateSet);
        log(birthdateSet);
        for (Date birthdate : birthdateSet) {
            assertNotNull(birthdate);
        }
        Set<Date> expectedSet = newLinkedHashSet();
        for (Member member : memberList) {
            Date birthdate = member.getBirthdate();
            if (birthdate != null) {
                expectedSet.add(birthdate);
            }
        }
        assertEquals(expectedSet, birthdateSet);
    }

    public void test_extractColumnSet_basic() {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.setupSelect_MemberStatus();
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Act ##
        Set<String> statusSet = memberList.extractColumnSet(new EntityColumnExtractor<Member, String>() {
            public String extract(Member entity) {
                return entity.getMemberStatusCode();
            }
        });

        // ## Assert ##
        assertHasAnyElement(statusSet);
        log(statusSet);
        Set<String> expectedSet = newLinkedHashSet();
        for (Member member : memberList) {
            String statusCode = member.getMemberStatusCode();
            expectedSet.add(statusCode);
        }
        assertEquals(expectedSet, statusSet);
    }
}
