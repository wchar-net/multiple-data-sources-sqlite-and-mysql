DROP TABLE IF EXISTS `sys_account`;
CREATE TABLE `sys_account` (
                               `account_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'primary,auto increment',
                               `account_name` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'account name',
                               `is_delete` tinyint(4) NOT NULL COMMENT '1 normal,0 delete',
                               PRIMARY KEY (`account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

insert into sys_account(`account_name`,`is_delete`) values ('Tom for mysql',1);
insert into sys_account(`account_name`,`is_delete`) values ('Emma for mysql',1);
insert into sys_account(`account_name`,`is_delete`) values ('Olivia for mysql',1);