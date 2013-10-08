-- #df:checkEnv(diffworld)#

alter table MEMBER alter column MEMBER_ACCOUNT VARCHAR(80) NOT NULL
;

drop table MEMBER_LOGIN;
create table MEMBER_LOGIN(
    MEMBER_LOGIN_ID BIGINT IDENTITY NOT NULL PRIMARY KEY,
    MOBILE_LOGIN_FLG INTEGER NOT NULL,
    MEMBER_ID INTEGER NOT NULL,
    LOGIN_DATETIME DATETIME NOT NULL,
    LOGIN_MEMBER_STATUS_CODE CHAR(3) NOT NULL
);
alter table MEMBER_LOGIN add constraint FK_MEMBER_LOGIN_MEMBER_STATUS 
    FOREIGN KEY (LOGIN_MEMBER_STATUS_CODE) references MEMBER_STATUS (MEMBER_STATUS_CODE);
alter table MEMBER_LOGIN add constraint FK_MEMBER_LOGIN_MEMBER 
    FOREIGN KEY (MEMBER_ID) references MEMBER (MEMBER_ID);
alter table MEMBER_LOGIN add constraint UQ_MEMBER_LOGIN UNIQUE (MEMBER_ID, LOGIN_DATETIME);

create SEQUENCE SEQ_DIFFWORLD START 1 INCREMENT 1
;
drop sequence SEQ_PURCHASE;
create sequence SEQ_PURCHASE START 1 INCREMENT 99
;

-- #df:begin#
CREATE ALIAS FN_DIFF_WORLD AS $$
@CODE 
int execFnDiffWorld() {
    return 908;
}
$$;
-- #df:end#

drop alias FN_NO_PARAMETER;

drop alias SP_NO_PARAMETER;
-- #df:begin#
CREATE ALIAS SP_NO_PARAMETER AS $$
@CODE
void execSpNoParameter() {
    System.out.println("DisneySea");
    System.out.println(" -> DockSideStage");
    System.out.println(" -> HungerStage");
}
$$;
-- #df:end#

update MEMBER_STATUS
   set DISPLAY_ORDER = 9
 where DISPLAY_ORDER = 1
;

insert into MEMBER_STATUS values('DIF', 'DiffWorld', 'diff world test status', 789)
;

update MEMBER
   set MEMBER_ACCOUNT = 'diffworld'
 where MEMBER_ID = 7
;

update MEMBER
   set MEMBER_ACCOUNT = 'diff"	"world'
 where MEMBER_ID = 9
;
