/*
 [df:title]
 (手動)ページング検索のExample
 
 [df:description]
 ページング用のParameterBean宣言をして(extends Paging)、
 isPaging()メソッドでカウント取得と実データ取得を切り替えます。
  e.g. プログラム側の実装
  - - - - - - - - - - - - - - - - - - - - - - - - - - -
  memberBhv.outsideSql().manualPaging().selectPage(...)
  - - - - - - - - - - - - - - - - - - - - - - - - - - -
 ページング条件は「H2 Database」のlimit句を利用しています。
 
 FORコメントによる不定数の曖昧検索の条件(and連結)のExampleでもあります。
 FORコメントのプロパティとカレント変数のバインド変数コメントは、
 自動判別(AutoDetect)の対象外のため明示的にプロパティを宣言します。
 
 また、区分値カラムに対する複数条件 InScope のExampleでもあります。
 AutoDetect に加えて ref オプションを使うことで、参照カラムに対応する
 CDef の区分値クラスがリストの要素型として自動的に解決されます。 
 
 補足：
  o この外だしSQLの検索は ConditionBean で実装可能:
   -> cb.paging(), Behavior.selectPage(cb)
   -> LikeSearchOption, SplitBy, AsOrSplit
   -> OrderBy, NullsFirst/Last
   -> (Specify)DerivedReferrer
*/
-- #df:entity#

-- !df:pmb extends Paging!
-- !!AutoDetect!!
-- !!List<String> memberNameList:likePrefix!!

/*IF pmb.isPaging()*/
select member.MEMBER_ID
     , member.MEMBER_NAME
     , (select max(purchase.PURCHASE_PRICE)
          from PURCHASE purchase
         where purchase.MEMBER_ID = member.MEMBER_ID
       ) as PURCHASE_MAX_PRICE
     , memberStatus.MEMBER_STATUS_NAME
-- ELSE select count(*)
/*END*/
  from MEMBER member
    /*IF pmb.isPaging()*/
    left outer join MEMBER_STATUS memberStatus
      on member.MEMBER_STATUS_CODE = memberStatus.MEMBER_STATUS_CODE
    /*END*/
 /*BEGIN*/
 where
   /*IF pmb.memberId != null*/
   member.MEMBER_ID = /*pmb.memberId*/3
   /*END*/
   /*FOR pmb.memberNameList*//*FIRST*/and (/*END*/
     /*NEXT 'or '*/member.MEMBER_NAME like /*#current*/'%v%'
   /*LAST*/)/*END*//*END*/
   /*IF pmb.memberStatusCodeList != null && !pmb.memberStatusCodeList.isEmpty()*/
   and member.MEMBER_STATUS_CODE in /*pmb.memberStatusCodeList:ref(MEMBER)*/('FML', 'PRV')
   /*END*/
 /*END*/
 /*IF pmb.isPaging()*/
 order by PURCHASE_MAX_PRICE desc nulls last, member.MEMBER_ID asc
 limit /*$pmb.pageStartIndex*/80, /*$pmb.fetchSize*/20
 /*END*/