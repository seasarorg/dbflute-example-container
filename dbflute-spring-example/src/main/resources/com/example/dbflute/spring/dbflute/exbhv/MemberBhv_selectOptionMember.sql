/*
 [df:title]
 The example for select using options
 
 [df:description]
 This SQL is an example for various options of parameter.
 Point:
   o The option of like search (like, likePrefix, likeContain, likeSuffix)
   o The option of from-to search (fromDate, toDate)
   o The option of classifications for ParameterBean (ref(...) or cls(...))
   o The auto option of classifications for CustomizeEntity 
   o The option of reference to table columns (ref(...))
   o How to set several options (...|...)
*/
-- #df:entity#

-- !df:pmb!
-- !!Integer memberId!!
-- !!String memberName:likePrefix!!
-- !!String memberAccount:like!!
-- !!Date fromFormalizedDate:fromDate!!
-- !!Date toFormalizedDate:toDate!!
-- !!Date fromFormalizedMonth:fromDate(option)!!
-- !!Date toFormalizedMonth:toDate(option)!!
-- !!String memberStatusCode:ref(MEMBER)!! // reference option (including classification)
-- !!Integer displayOrder:ref(MEMBER_STATUS)!!
-- !!Date birthdate:fromDate|ref(MEMBER.BIRTHDATE)!! // several options
-- !!String status:cls(MemberStatus)!! // direct classification setting
-- !!String statusFormalized:cls(MemberStatus.Formalized)!! // fixed classification setting
-- !!List<$$CDef$$.MemberStatus> statusList:ref(MEMBER.MEMBER_STATUS_CODE)!! // classification to list
-- !!List<String> statusFixedList:cls(MemberStatus.Formalized, Withdrawal)!! // fixed classification list
-- !!Integer paymentCompleteFlg:cls(Flg)!! // direct one as Integer
-- !!Integer paymentCompleteTrue:cls(Flg.True)!! // fixed one as Integer

select member.MEMBER_ID
     , member.MEMBER_NAME
     , member.BIRTHDATE -- // select column comment here (no as)
     , member.FORMALIZED_DATETIME as FORMALIZED_DATETIME -- // select column comment here (using as)
     , member.MEMBER_STATUS_CODE -- for Classification Test of Sql2Entity
     , memberStatus.MEMBER_STATUS_NAME
     , memberStatus.DISPLAY_ORDER as STATUS_DISPLAY_ORDER -- for Alias Name Test
     , 0 as DUMMY_FLG -- // for Classification Test of Sql2Entity
     , 0 as DUMMY_NOFLG -- // for Classification Test of Sql2Entity
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
   /*IF pmb.fromFormalizedMonth != null*/
   and member.FORMALIZED_DATETIME >= /*pmb.fromFormalizedMonth*/'1964-12-01'
   /*END*/
   /*IF pmb.toFormalizedMonth != null*/
   and member.FORMALIZED_DATETIME < /*pmb.toFormalizedMonth*/'1974-04-01'
   /*END*/
   /*IF pmb.memberStatusCode != null*/
   and member.MEMBER_STATUS_CODE = /*pmb.memberStatusCode*/'WDL'
   /*END*/
 /*END*/
 order by member.MEMBER_ID asc
