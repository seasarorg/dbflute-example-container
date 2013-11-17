CREATE TABLE VENDOR_CHECK (
	VENDOR_CHECK_ID NUMERIC(16) NOT NULL PRIMARY KEY,
	TYPE_OF_CHAR CHAR,
	TYPE_OF_VARCHAR VARCHAR,
	TYPE_OF_TEXT TEXT,
	TYPE_OF_NUMERIC_INTEGER NUMERIC(5, 0),
	TYPE_OF_NUMERIC_BIGINT NUMERIC(12, 0),
	TYPE_OF_NUMERIC_DECIMAL NUMERIC(5, 3),
	TYPE_OF_NUMERIC_INTEGER_MIN NUMERIC(1, 0),
	TYPE_OF_NUMERIC_INTEGER_MAX NUMERIC(9, 0),
	TYPE_OF_NUMERIC_BIGINT_MIN NUMERIC(10, 0),
	TYPE_OF_NUMERIC_BIGINT_MAX NUMERIC(18, 0),
	TYPE_OF_NUMERIC_SUPERINT_MIN NUMERIC(19, 0),
	TYPE_OF_NUMERIC_SUPERINT_MAX NUMERIC(38, 0),
	TYPE_OF_NUMERIC_MAXDECIMAL NUMERIC(38, 38),
	TYPE_OF_BOOLEAN BOOLEAN,
	TYPE_OF_BLOB BLOB,
	U_Y_TEXT TEXT
);