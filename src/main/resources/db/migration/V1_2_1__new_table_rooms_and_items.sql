CREATE TABLE tomson.Rooms (
`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
`room_type` VARCHAR(255) NOT NULL,
`ammount` BIGINT(20) NOT NULL,
`id_property` BIGINT(20)NOT NULL,
`created_on` DATETIME,
`updated_on` DATETIME,
`deleted_on` DATETIME,
PRIMARY KEY (`id`));

CREATE TABLE tomson.Items (
`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
`item_name` VARCHAR(255) NOT NULL,
`item_type` VARCHAR(255) NOT NULL,
`ammount` BIGINT(20) NOT NULL,
`id_room` BIGINT(20) NOT NULL,
`id_property` BIGINT(20)NOT NULL,
`created_on` DATETIME,
`updated_on` DATETIME,
`deleted_on` DATETIME,
PRIMARY KEY (`id`));