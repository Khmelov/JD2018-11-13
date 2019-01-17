-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema kovalyova
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `kovalyova` ;

-- -----------------------------------------------------
-- Schema kovalyova
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `kovalyova` DEFAULT CHARACTER SET utf8 ;
USE `kovalyova` ;

-- -----------------------------------------------------
-- Table `kovalyova`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kovalyova`.`roles` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(100) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kovalyova`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kovalyova`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `roles_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_users_roles_idx` (`roles_id` ASC),
  CONSTRAINT `fk_users_roles`
    FOREIGN KEY (`roles_id`)
    REFERENCES `kovalyova`.`roles` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kovalyova`.`ads`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kovalyova`.`ads` (
  `id` INT NOT NULL,
  `description` VARCHAR(1000) NULL,
  `addres` VARCHAR(100) NULL,
  `floor` INT NULL,
  `floors` INT NULL,
  `rooms` INT NULL,
  `area` DECIMAL NULL,
  `price` VARCHAR(45) NULL,
  `users_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_ads_users1_idx` (`users_id` ASC),
  CONSTRAINT `fk_ads_users1`
    FOREIGN KEY (`users_id`)
    REFERENCES `kovalyova`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `kovalyova`.`roles`
-- -----------------------------------------------------
START TRANSACTION;
USE `kovalyova`;
INSERT INTO `kovalyova`.`roles` (`id`, `role`) VALUES (DEFAULT, 'admin');
INSERT INTO `kovalyova`.`roles` (`id`, `role`) VALUES (DEFAULT, 'user');
INSERT INTO `kovalyova`.`roles` (`id`, `role`) VALUES (DEFAULT, 'guest');

COMMIT;


-- -----------------------------------------------------
-- Data for table `kovalyova`.`users`
-- -----------------------------------------------------
START TRANSACTION;
USE `kovalyova`;
INSERT INTO `kovalyova`.`users` (`id`, `login`, `password`, `email`, `roles_id`) VALUES (DEFAULT, 'admin', 'admin', 'admin@mail.ru', 1);
INSERT INTO `kovalyova`.`users` (`id`, `login`, `password`, `email`, `roles_id`) VALUES (DEFAULT, 'user', 'user', 'user@mail.ru', 2);

COMMIT;

