-- #df:checkEnv(ut)#
-- *ut only to avoid schema-sync-check test

-- /= = = = = = = = = = = = = = = = = = = = = = =
-- for the test of fixed-only biz-one-to-one
-- = = = = = = = = = =/
CREATE TABLE WHITE_DATE_TERM (
	DATE_TERM_ID NUMERIC(16) NOT NULL PRIMARY KEY,
	DATE_TERM_VALUE VARCHAR(200) NOT NULL,
	BEGIN_DATE DATE NOT NULL,
	END_DATE DATE NOT NULL
);
