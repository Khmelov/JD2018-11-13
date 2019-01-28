-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mydb` ;

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema ngrudnitsky
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `ngrudnitsky` ;

-- -----------------------------------------------------
-- Schema ngrudnitsky
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ngrudnitsky` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`games`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`games` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `game` VARCHAR(100) NULL,
  `link` VARCHAR(200) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

USE `ngrudnitsky` ;

-- -----------------------------------------------------
-- Table `ngrudnitsky`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ngrudnitsky`.`roles` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ngrudnitsky`.`streamers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ngrudnitsky`.`streamers` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(100) NULL DEFAULT NULL,
  `password` VARCHAR(100) NULL DEFAULT NULL,
  `channelname` VARCHAR(45) NULL DEFAULT NULL,
  `roles_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_streamers_roles1_idx` (`roles_id` ASC),
  CONSTRAINT `fk_streamers_roles1`
    FOREIGN KEY (`roles_id`)
    REFERENCES `ngrudnitsky`.`roles` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ngrudnitsky`.`viewers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ngrudnitsky`.`viewers` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(100) NULL DEFAULT NULL,
  `password` VARCHAR(100) NULL DEFAULT NULL,
  `nickname` VARCHAR(20) NULL DEFAULT NULL,
  `roles_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_viewers_roles1_idx` (`roles_id` ASC),
  CONSTRAINT `fk_viewers_roles1`
    FOREIGN KEY (`roles_id`)
    REFERENCES `ngrudnitsky`.`roles` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `mydb`.`games`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`games` (`id`, `game`, `link`) VALUES (DEFAULT, 'HearthStone', NULL);
INSERT INTO `mydb`.`games` (`id`, `game`, `link`) VALUES (DEFAULT, 'Fortnight', NULL);
INSERT INTO `mydb`.`games` (`id`, `game`, `link`) VALUES (DEFAULT, 'DOTA 2', NULL);
INSERT INTO `mydb`.`games` (`id`, `game`, `link`) VALUES (DEFAULT, 'PUBG', NULL);
INSERT INTO `mydb`.`games` (`id`, `game`, `link`) VALUES (DEFAULT, 'League of Legends', NULL);

COMMIT;

