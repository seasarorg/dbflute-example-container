/*
 [df:title]
 Select句が一個だけの検索のExample
 
 [df:description]
 Select句が一個だけの場合は CustomizeEntity の自動生成は不要のため、
 CustomizeEntityマークに加えて scalar オプションを付与し、
 単一カラムであることを明示します。そうすることで、呼び出し側で
 String 型や Integer 型などのリスト型で受け取れます。
 (一件検索の場合はスカラ型でそのまま受け取れます)
 ex) プログラム側の実装 (定型呼び出し形式)
 - - - - - - - - - - - - - - - - - - - - - - - - - -
 MemberNamePmb pmb = ...
 String name = memberBhv.outsideSql().selectList(pmb)
 - - - - - - - - - - - - - - - - - - - - - - - - - -
 
 補足：
   o この外だしSQLの検索は ConditionBean で実現可能
     -> SpecifyColumn
     -> Behavior.scalarSelect(query)
*/
-- #df:entity#
-- +scalar+

-- !df:pmb!
-- !!AutoDetect!!

select member.MEMBER_NAME
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
   /*IF pmb.existsBirthdate()*/
   and member.BIRTHDATE is not null 
   /*END*/
 /*END*/
 order by member.MEMBER_ID asc
