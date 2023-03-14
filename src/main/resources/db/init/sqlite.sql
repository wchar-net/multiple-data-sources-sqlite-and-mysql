DROP TABLE IF EXISTS `sys_account`;
CREATE TABLE "sys_account" (
                               "account_id" integer NOT NULL PRIMARY KEY AUTOINCREMENT,
                               "account_name" text(50),
                               "is_delete" integer NOT NULL
);

insert into sys_account(`account_name`,`is_delete`) values ('Sophia for sqlite',1);
insert into sys_account(`account_name`,`is_delete`) values ('Mia for sqlite',1);
insert into sys_account(`account_name`,`is_delete`) values ('Charlotte for sqlite',1);