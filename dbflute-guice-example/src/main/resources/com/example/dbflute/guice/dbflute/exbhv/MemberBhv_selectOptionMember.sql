-- #df:entity#

-- !df:pmb!
-- !!Integer memberId!!
-- !!String memberName:likePrefix!!
-- !!String memberAccount:like!!
-- !!Date fromFormalizedDate:fromDate!!
-- !!Date toFormalizedDate:toDate!!
-- !!Date fromFormalizedOptionDate:fromDate(option)!!
-- !!Date toFormalizedOptionDate:toDate(option)!!
-- !!String memberStatusCode:cls(MemberStatus)!!
-- !!Integer displayOrder:ref(MemberStatus)!!
-- !!Date birthdate:fromDate|ref(Member)!!
-- !!String status:cls(MemberStatus)|ref(Member.MEMBER_STATUS_CODE)!!

select member.MEMBER_ID
     , member.MEMBER_NAME
     , member.BIRTHDATE
     , member.FORMALIZED_DATETIME
     , member.MEMBER_STATUS_CODE -- for Classification Test of Sql2Entity
     , memberStatus.DISPLAY_ORDER as STATUS_DISPLAY_ORDER -- for Alias Name Test
     , memberStatus.MEMBER_STATUS_NAME
     , 0 as DUMMY_FLG -- for Classification Test of Sql2Entity
     , 0 as DUMMY_NOFLG -- for Classification Test of Sql2Entity
  from MEMBER member
    left outer join MEMBER_STATUS memberStatus
      on member.MEMBER_STATUS_CODE = memberStatus.MEMBER_STATUS_CODE
 /*BEGIN*/
 where
   /*IF pmb.memberId != null*/
   member.MEMBER_ID = /*pmb.memberId*/3
   /*END*/
   /*IF pmb.memberName != null*/
   and member.MEMBER_NAME like /*pmb.memberName*/'S%'
   /*END*/
   /*IF pmb.memberAccount != null*/
   and member.MEMBER_ACCOUNT like /*pmb.memberAccount*/'%v%'
   /*END*/
   /*IF pmb.fromFormalizedDate != null*/
   and member.FORMALIZED_DATETIME >= /*pmb.fromFormalizedDate*/'1964-12-27'
   /*END*/
   /*IF pmb.toFormalizedDate != null*/
   and member.FORMALIZED_DATETIME < /*pmb.toFormalizedDate*/'1974-04-17'
   /*END*/
   /*IF pmb.fromFormalizedOptionDate != null*/
   and member.FORMALIZED_DATETIME >= /*pmb.fromFormalizedOptionDate*/'1964-12-27'
   /*END*/
   /*IF pmb.toFormalizedOptionDate != null*/
   and member.FORMALIZED_DATETIME < /*pmb.toFormalizedOptionDate*/'1974-04-17'
   /*END*/
   /*IF pmb.memberStatusCode != null*/
   and member.MEMBER_STATUS_CODE = /*pmb.memberStatusCode*/'WDL'
   /*END*/
 /*END*/
 order by member.MEMBER_ID asc
