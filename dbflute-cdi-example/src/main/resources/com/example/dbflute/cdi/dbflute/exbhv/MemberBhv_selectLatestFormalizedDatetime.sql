/*
 [df:title]
 スカラ値検索のExample
 
 [df:description]
 スカラ値検索では CustomizeEntity は生成する必要ないため、
 CustomizeEntityマークに加えて scalar オプションを付与し、
 単一カラムであることを明示します。そうすることで呼び出し側で
 String 型や Integer 型などで受け取れます。
 また、パラメータがなくても ParameterBean の宣言をすることで、
 TypedParameterBean を使った定型呼び出しができます。
 e.g. プログラム側の実装 (定型呼び出し形式)
 - - - - - - - - - - - - - - - - - - - - - - - - - - - -
 LatestFormalizedDatetimePmb pmb = ...
 Timestamp formalizedDatetime
     = memberBhv.outsideSql().entityHanlding().selectEntity(pmb)
 - - - - - - - - - - - - - - - - - - - - - - - - - - - -
 
 補足：
   o この外だしSQLの検索は ConditionBean で実現可能
     -> Behavior.scalarSelect()
*/
-- #df:entity#
-- +scalar+

-- !df:pmb!

select max(member.FORMALIZED_DATETIME) as maxValue from MEMBER member
