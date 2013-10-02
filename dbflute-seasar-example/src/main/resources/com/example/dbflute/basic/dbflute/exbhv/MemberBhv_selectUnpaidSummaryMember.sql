/*
 [df:title]
 (自動)ページング検索のExample
 
 [df:description]
 ページング用のParameterBean宣言をして(extends Paging)、
 isPaging()メソッドでカウント取得と実データ取得を切り替えます。
  e.g. プログラム側の実装
  - - - - - - - - - - - - - - - - - - - - - - - - - -
  memberBhv.outsideSql().autoPaging().selectPage(...)
  - - - - - - - - - - - - - - - - - - - - - - - - - -
 自動ページングではページング条件を記述する必要はなく、ResultSetレベルで
 絞り込みを実現するカーソルスキップを利用します。
 基本的にはポインタシフトで対象レコードだけを読み込み、ポインタシフトが
 サポートされていないDBではループスルーでデータを読み飛ばします。
 手動ページングの方がパフォーマンス的に有利なのでそちらがお奨めです。
 ページング条件が複雑なDBで、パフォーマンスを割り切る時に自動ページングを利用します。
 
 LoadReferrerのためのPKカラムの設定のExampleでもあります。
 PrimaryKeyマーク("*" でPKカラムを囲う)でユニーク性を明示します。
 
 自動判別(AutoDetect)を利用していますが、IFコメントのみで利用されて
 いるプロパティは対象外なので、明示的に宣言しています。
 
 補足：
  o この外だしSQLの検索は ConditionBean で実装可能
   -> cb.paging(), Behavior.selectPage(cb)
*/
-- #df:entity#
-- *UNPAID_MAN_ID*

-- !df:pmb extends Paging!
-- !!AutoDetect!!
-- !!boolean unpaidMemberOnly!!

/*IF pmb.isPaging()*/
select member.MEMBER_ID as UNPAID_MAN_ID
     , member.MEMBER_NAME as UNPAID_MAN_NAME
     , (select sum(purchase.PURCHASE_PRICE)
          from PURCHASE purchase
         where purchase.MEMBER_ID = member.MEMBER_ID
           and purchase.PAYMENT_COMPLETE_FLG = 0
       ) as UNPAID_PRICE_SUMMARY
     , memberStatus.MEMBER_STATUS_NAME as STATUS_NAME
-- ELSE select count(*)
/*END*/
  from MEMBER member
    /*IF pmb.isPaging()*/
    left outer join MEMBER_STATUS memberStatus
      on member.MEMBER_STATUS_CODE = memberStatus.MEMBER_STATUS_CODE
    /*END*/
 /*BEGIN*/where
   /*IF pmb.memberId != null*/
       member.MEMBER_ID = /*pmb.memberId*/3
   /*END*/
   /*IF pmb.memberName != null*/
   and member.MEMBER_NAME like /*pmb.memberName*/'S%'
   /*END*/
   /*IF pmb.memberStatusCode != null*/
   and member.MEMBER_STATUS_CODE = /*pmb.memberStatusCode:cls(MemberStatus)*/'FML'
   /*END*/
   /*IF pmb.unpaidMemberOnly*/
   and exists (select 'yes'
                 from PURCHASE purchase
                where purchase.MEMBER_ID = member.MEMBER_ID
                  and purchase.PAYMENT_COMPLETE_FLG = 0
       )
   /*END*/
 /*END*/
 /*IF pmb.isPaging()*/
 order by UNPAID_PRICE_SUMMARY desc, member.MEMBER_ID asc
 /*END*/
