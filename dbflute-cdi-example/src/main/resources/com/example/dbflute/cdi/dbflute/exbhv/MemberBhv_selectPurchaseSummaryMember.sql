/*
 [df:title]
 カーソル検索のExample
 
 [df:description]
 大量件数の検索などで一件ずつ読み込んで処理を行いたい場合はカーソル検索を
 利用します。CustomizeEntityマークに加えて、TypeSafeCursorマーク
 (cursor オプション) を付与し、カーソル検索であることを明示します。
 そうすることで、タイプセーフに ResultSet を扱える Cursor クラスが
 生成されます。(Entity は自動生成されない)
 ex) プログラム側の実装
 - - - - - - - - - - - - - - - - - - - - - - - - - - - -
 memberBhv.outsideSql().cursorHandling().selectCursor(...)
 - - - - - - - - - - - - - - - - - - - - - - - - - - - -
 
 FORコメントによる不定数の曖昧検索の条件(and連結)のExampleでもあります。
 FORコメントのプロパティとカレント変数のバインド変数コメントは、
 自動判別(AutoDetect)の対象外のため明示的にプロパティを宣言します。
 
 補足：
   o この外だしSQLの検索は ConditionBean で実現可能
     -> LikeSearchOption, SplitBy
     -> (Specify)DerivedReferrer, SpecifiedDerivedOrderBy
     -> Behavior.selectCursor(cb, handler)
*/
-- #df:entity#
-- +cursor+

-- !df:pmb!
-- !!AutoDetect!!
-- !!List<String> memberNameList:likeContain!!

select member.MEMBER_ID
     , member.MEMBER_NAME
     , member.BIRTHDATE
     , member.FORMALIZED_DATETIME
     , (select sum(purchase.PURCHASE_COUNT)
          from PURCHASE purchase
         where purchase.MEMBER_ID = member.MEMBER_ID
       ) as PURCHASE_SUMMARY
  from MEMBER member
 /*BEGIN*/
 where
   /*FOR pmb.memberNameList*/
   /*NEXT 'and '*/member.MEMBER_NAME like /*#current*/'%v%'
   /*END*/
   /*IF pmb.memberStatusCode != null*/
   and member.MEMBER_STATUS_CODE = /*pmb.memberStatusCode:cls(MemberStatus)*/'FML'
   /*END*/
   /*IF pmb.formalizedDatetime != null*/
   and member.FORMALIZED_DATETIME >= /*pmb.formalizedDatetime*/'2003-09-23 12:34:56.147'
   /*END*/
 /*END*/
 order by PURCHASE_SUMMARY desc