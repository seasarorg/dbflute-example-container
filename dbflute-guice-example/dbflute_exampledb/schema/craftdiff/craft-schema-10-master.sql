
-- =======================================================================================
--                                                                             Master Data
--                                                                             ===========
-- #df:assertEquals(MemberStatus)#
select MEMBER_STATUS_CODE as KEY, MEMBER_STATUS_NAME, DISPLAY_ORDER
  from MEMBER_STATUS
 order by KEY
;

-- #df:assertTableEquals(TableCls, suffix:_STATUS, except:DESCRIPTION)#
select 'dummy'
;
