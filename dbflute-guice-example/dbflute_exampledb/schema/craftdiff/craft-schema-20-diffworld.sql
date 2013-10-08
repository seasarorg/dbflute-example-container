-- #df:checkEnv(diffworld)#
-- normally not use in business like this: (it's test for DBFlute)

-- =======================================================================================
--                                                                               Test Data
--                                                                               =========
-- #df:assertEquals(Member)#
select mb.MEMBER_NAME, mb.MEMBER_ACCOUNT, mb.BIRTHDATE
  from MEMBER mb
;

-- #df:assertEquals(Product)#
select prd.PRODUCT_NAME, prd.PRODUCT_STATUS_CODE
  from PRODUCT prd
;
