-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mnovikov
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mnovikov` ;

-- -----------------------------------------------------
-- Schema mnovikov
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mnovikov` DEFAULT CHARACTER SET utf8 ;
USE `mnovikov` ;

-- -----------------------------------------------------
-- Table `mnovikov`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mnovikov`.`roles` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(100) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mnovikov`.`admin`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mnovikov`.`admin` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `roles_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_users_roles_idx` (`roles_id` ASC),
  CONSTRAINT `fk_users_roles`
    FOREIGN KEY (`roles_id`)
    REFERENCES `mnovikov`.`roles` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mnovikov`.`ads`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mnovikov`.`ads` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(100) NULL,
  `discription` VARCHAR(2000) NULL,
  `samler_type` VARCHAR(100) NULL,
  `users_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_ads_users1_idx` (`users_id` ASC),
  CONSTRAINT `fk_ads_users1`
    FOREIGN KEY (`users_id`)
    REFERENCES `mnovikov`.`admin` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `mnovikov`.`roles`
-- -----------------------------------------------------
START TRANSACTION;
USE `mnovikov`;
INSERT INTO `mnovikov`.`roles` (`id`, `role`) VALUES (DEFAULT, 'admin');
INSERT INTO `mnovikov`.`roles` (`id`, `role`) VALUES (DEFAULT, 'user');
INSERT INTO `mnovikov`.`roles` (`id`, `role`) VALUES (DEFAULT, 'guest');

COMMIT;


-- -----------------------------------------------------
-- Data for table `mnovikov`.`admin`
-- -----------------------------------------------------
START TRANSACTION;
USE `mnovikov`;
INSERT INTO `mnovikov`.`admin` (`id`, `login`, `password`, `email`, `roles_id`) VALUES (DEFAULT, 'admin', 'admin', 'admin@mail.ru', 1);
INSERT INTO `mnovikov`.`admin` (`id`, `login`, `password`, `email`, `roles_id`) VALUES (DEFAULT, 'user', 'user', 'user@mail.ru', 2);
INSERT INTO `mnovikov`.`admin` (`id`, `login`, `password`, `email`, `roles_id`) VALUES (DEFAULT, 'guest', 'guest', 'guest@mail.ru', 3);

COMMIT;


-- -----------------------------------------------------
-- Data for table `mnovikov`.`ads`
-- -----------------------------------------------------
START TRANSACTION;
USE `mnovikov`;
INSERT INTO `mnovikov`.`ads` (`id`, `title`, `discription`, `samler_type`, `users_id`) VALUES (DEFAULT, 'test1', 'test for test1 descr', 'auto', 2);
INSERT INTO `mnovikov`.`ads` (`id`, `title`, `discription`, `samler_type`, `users_id`) VALUES (DEFAULT, 'test2', 'test for test2 desr', 'hand', 2);

COMMIT;

