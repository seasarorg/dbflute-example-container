/*
 [df:title]
 オプションを使った検索のExample
 
 [df:description]
 参考ポイント：
   o 曖昧検索のオプション(like, likePrefix, likeContain, likeSuffix)
   o FromTo検索のオプション(fromDate, toDate)
   o ParameterBeanで区分値を利用するオプション(ref(...) or cls(...))
   o CustomizeEntityで区分値を利用(自動オプション)
   o ParameterBeanのプロパティの参照カラムを指定するオプション(ref(...))
   o ParameterBeanのプロパティのオプションを複数付与(...|...)
 FORMALIZED_DATETIMEに対する日付範囲条件に関しては、
 時分秒を意識しない日付検索に対して、カラムの型は時分秒を保持するので、
 FromTo検索のオプション指定をすることで効果的に実装が可能です。
 ToDate側の演算子は「<=」ではなく「<」というように等値要素を抜くこと。
*/
-- #df:entity#

-- !df:pmb!
-- !!Integer memberId!!
-- !!String memberName:likePrefix!!
-- !!String memberAccount:like!!
-- !!Date fromFormalizedDate:fromDate!!
-- !!Date toFormalizedDate:toDate!!
-- !!String memberStatusCode:ref(MEMBER)!! // テーブルのカラムを参照して関連付け (区分値も関連付けられる)
-- !!Integer displayOrder:ref(MEMBER_STATUS)!!
-- !!Date birthdate:fromDate|ref(MEMBER.BIRTHDATE)!! // 複数のオプションを付与
-- !!String status:cls(MemberStatus)!! // 直接区分値に関連付ける

select member.MEMBER_ID
     , member.MEMBER_NAME
     , member.BIRTHDATE -- // select column comment here (no as)
     , member.FORMALIZED_DATETIME as FORMALIZED_DATETIME -- // select column comment here (using as)
     , member.MEMBER_STATUS_CODE -- for Classification Test of Sql2Entity
     , memberStatus.MEMBER_STATUS_NAME
     , memberStatus.DISPLAY_ORDER as STATUS_DISPLAY_ORDER -- for Alias Name Test
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
   /*IF pmb.memberStatusCode != null*/
   and member.MEMBER_STATUS_CODE = /*pmb.memberStatusCode*/'WDL'
   /*END*/
 /*END*/
 order by member.MEMBER_ID asc
