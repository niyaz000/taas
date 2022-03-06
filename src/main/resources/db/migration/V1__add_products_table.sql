CREATE TABLE IF NOT EXISTS `products` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `created_at` TIMESTAMP NOT NULL DEFAULT NOW(),
  `updated_at` TIMESTAMP NOT NULL DEFAULT NOW() ON UPDATE now(),
  `config` JSON NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `unique_constraint_name` (`name`)) ENGINE=InnoDB CHARACTER SET utf8mb4;
