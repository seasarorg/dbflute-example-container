/*
 [df:title]
 シンプルな会員検索のExample
 
 [df:description]
 このSQLは外だしSQLの最も基本的なExampleです。
 参考ポイント：
   o パラメータコメント(IFコメントやバインド変数コメントなど)の利用方法
   o Sql2Entityで生成するCustomizeEntityとParameterBeanの定義方法
   o 外だしSQLの業務的なタイトル・説明(SchemaHTMLにて表示される)の記述方法
 外だしSQLのエンコーディングはデフォルトで「UTF-8」です。
 ダブルバイト文字を利用する場合はエディタのエンコーディングにご注意下さい。
 補足：
   o この外だしSQLの検索は ConditionBean で実現可能
     -> SetupSelect(Relation), Query, OrderBy
*/
-- #df:entity#

-- !df:pmb!
-- !!Integer memberId!!
-- !!String memberName:likePrefix!!
-- !!Date birthdate!!

select member.MEMBER_ID
     , member.MEMBER_NAME
     , member.BIRTHDATE
     , memberStatus.MEMBER_STATUS_NAME
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
   /*IF pmb.birthdate != null*/
   and member.BIRTHDATE = /*pmb.birthdate*/'1966-09-15'
   /*END*/
 /*END*/
 order by member.BIRTHDATE desc, member.MEMBER_ID asc
