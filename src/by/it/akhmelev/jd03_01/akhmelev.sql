-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema akhmelev
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `akhmelev` ;

-- -----------------------------------------------------
-- Schema akhmelev
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `akhmelev` DEFAULT CHARACTER SET utf8 ;
USE `akhmelev` ;

-- -----------------------------------------------------
-- Table `akhmelev`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `akhmelev`.`roles` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(100) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `akhmelev`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `akhmelev`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `roles_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_users_roles_idx` (`roles_id` ASC),
  CONSTRAINT `fk_users_roles`
    FOREIGN KEY (`roles_id`)
    REFERENCES `akhmelev`.`roles` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `akhmelev`.`ads`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `akhmelev`.`ads` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(2000) NULL,
  `address` VARCHAR(500) NULL,
  `floor` INT NULL,
  `floors` INT NULL,
  `rooms` INT NULL,
  `area` DECIMAL NULL,
  `price` DECIMAL NULL,
  `users_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_ads_users1_idx` (`users_id` ASC),
  CONSTRAINT `fk_ads_users1`
    FOREIGN KEY (`users_id`)
    REFERENCES `akhmelev`.`users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `akhmelev`.`roles`
-- -----------------------------------------------------
START TRANSACTION;
USE `akhmelev`;
INSERT INTO `akhmelev`.`roles` (`id`, `role`) VALUES (DEFAULT, 'admin');
INSERT INTO `akhmelev`.`roles` (`id`, `role`) VALUES (DEFAULT, 'user');
INSERT INTO `akhmelev`.`roles` (`id`, `role`) VALUES (DEFAULT, 'guest');

COMMIT;


-- -----------------------------------------------------
-- Data for table `akhmelev`.`users`
-- -----------------------------------------------------
START TRANSACTION;
USE `akhmelev`;
INSERT INTO `akhmelev`.`users` (`id`, `login`, `password`, `email`, `roles_id`) VALUES (DEFAULT, 'admin', 'admin', 'admin@mail.ru', 1);
INSERT INTO `akhmelev`.`users` (`id`, `login`, `password`, `email`, `roles_id`) VALUES (DEFAULT, 'user', 'user', 'user@mail.ru', 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `akhmelev`.`ads`
-- -----------------------------------------------------
START TRANSACTION;
USE `akhmelev`;
INSERT INTO `akhmelev`.`ads` (`id`, `description`, `address`, `floor`, `floors`, `rooms`, `area`, `price`, `users_id`) VALUES (DEFAULT, 'test1', 'test1 address', 3, 5, 3, 66, 99999, 2);
INSERT INTO `akhmelev`.`ads` (`id`, `description`, `address`, `floor`, `floors`, `rooms`, `area`, `price`, `users_id`) VALUES (DEFAULT, 'test2 description', 'test2 addres', 1, 1, 1, 10, 10000, 2);

COMMIT;

