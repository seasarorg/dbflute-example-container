/*
 [df:title]
 DomainEntityで受け取る検索のExample
 
 [df:description]
 戻り値Entityの型として DomainEntity を利用する場合は、
 CustomizeEntityマークに加えて domain オプションを付与します。
 (この場合、CustomizeEntityは生成されません)
 select句のカラムは全て関連付くBehaviorに対応するテーブルのカラム
 である必要があります。(Sql2Entityタスクにてチェックされます)
*/
-- #df:entity#
-- +domain+

-- !df:pmb!

select member.MEMBER_ID
     , member.MEMBER_NAME
     , member.BIRTHDATE
  from MEMBER member
