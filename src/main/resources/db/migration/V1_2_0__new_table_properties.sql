CREATE TABLE tomson.Properties (
`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
`house_type` VARCHAR(255) NOT NULL,
`created_on` DATETIME,
`updated_on` DATETIME,
`deleted_on` DATETIME,
PRIMARY KEY (`id`));