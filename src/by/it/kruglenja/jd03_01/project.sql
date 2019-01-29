-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema kruglenja
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `kruglenja` ;

-- -----------------------------------------------------
-- Schema kruglenja
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `kruglenja` DEFAULT CHARACTER SET utf8 ;
USE `kruglenja` ;

-- -----------------------------------------------------
-- Table `kruglenja`.`roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `kruglenja`.`roles` ;

CREATE TABLE IF NOT EXISTS `kruglenja`.`roles` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kruglenja`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `kruglenja`.`users` ;

CREATE TABLE IF NOT EXISTS `kruglenja`.`users` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NULL DEFAULT NULL,
  `password` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  `phone_number` VARCHAR(45) NULL DEFAULT NULL,
  `roles_id1` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_users_roles_idx` (`roles_id` ASC),
  CONSTRAINT `fk_users_roles`
    FOREIGN KEY (`roles_id`)
    REFERENCES `kruglenja`.`roles` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kruglenja`.`order`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `kruglenja`.`order` ;

CREATE TABLE IF NOT EXISTS `kruglenja`.`order` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `quanity` INT NULL,
  `deliveryTime` INT NULL,
  `totalPrice` INT NULL,
  `users_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_order_users1_idx` (`users_id` ASC),
  CONSTRAINT `fk_order_users`
    FOREIGN KEY (`users_id`)
    REFERENCES `kruglenja`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kruglenja`.`sparePart`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `kruglenja`.`sparePart` ;

CREATE TABLE IF NOT EXISTS `kruglenja`.`sparePart` (
  `id` BIGINT NOT NULL,
  `model` VARCHAR(45) NULL DEFAULT NULL,
  `category` VARCHAR(45) NULL,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `serial_number` BIGINT NULL,
  `weigth` VARCHAR(45) NULL DEFAULT NULL,
  `price` DOUBLE NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Data for table `kruglenja`.`roles`
-- -----------------------------------------------------
START TRANSACTION;
USE `kruglenja`;
INSERT INTO `kruglenja`.`roles` (`id`, `role`) VALUES (DEFAULT, 'administrator');
INSERT INTO `kruglenja`.`roles` (`id`, `role`) VALUES (DEFAULT, 'user');
INSERT INTO `kruglenja`.`roles` (`id`, `role`) VALUES (DEFAULT, 'guest');

COMMIT;


-- -----------------------------------------------------
-- Data for table `kruglenja`.`users`
-- -----------------------------------------------------
START TRANSACTION;
USE `kruglenja`;
INSERT INTO `kruglenja`.`users` (`id`, `login`, `password`, `email`, `phone_number`, `roles_id`) VALUES (DEFAULT, 'admin', 'admin', 'admin@admin', '+6541814654189', 1);
INSERT INTO `kruglenja`.`users` (`id`, `login`, `password`, `email`, `phone_number`, `roles_id`) VALUES (DEFAULT, 'user', 'user', 'user@user', '+9849871891789', 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `kruglenja`.`order`
-- -----------------------------------------------------
START TRANSACTION;
USE `kruglenja`;
INSERT INTO `kruglenja`.`order` (`id`, `quanity`, `deliveryTime`, `totalPrice`, `users_id`) VALUES (DEFAULT, 12, 15, 1024, 2);
INSERT INTO `kruglenja`.`order` (`id`, `quanity`, `deliveryTime`, `totalPrice`, `users_id`) VALUES (DEFAULT, 12, 44, 444, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `kruglenja`.`sparePart`
-- -----------------------------------------------------
START TRANSACTION;
USE `kruglenja`;
INSERT INTO `kruglenja`.`sparePart` (`id`, `model`, `category`, `name`, `serial_number`, `weigth`, `price`) VALUES (1, 'Mazda', 'engine', 'engine', 051871051184, '12', 1024);
INSERT INTO `kruglenja`.`sparePart` (`id`, `model`, `category`, `name`, `serial_number`, `weigth`, `price`) VALUES (2, 'Ford', 'motor', 'motor', 214045204524, '352', 41233);

COMMIT;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
