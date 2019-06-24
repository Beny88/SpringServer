CREATE TABLE user (
`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
`username` VARCHAR(255) NOT NULL,
`password` VARCHAR(255) NOT NULL,
`account_not_expired` BOOL NOT NULL DEFAULT '1',
`account_not_locked` BOOL NOT NULL DEFAULT '1',
`credential_not_expired` BOOL NOT NULL DEFAULT '1',
`enabled` BOOL NOT NULL DEFAULT '1',
`created_on` DATETIME,
`updated_on` DATETIME,
`deleted_on` DATETIME,
PRIMARY KEY (`id`),
INDEX `idx_user_username` (`username` ASC));