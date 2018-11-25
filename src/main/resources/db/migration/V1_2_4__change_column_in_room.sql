ALTER TABLE `room` DROP COLUMN id_property;
ALTER TABLE `room` ADD COLUMN property_id BIGINT(20);