-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema karnilava1
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `karnilava1` ;

-- -----------------------------------------------------
-- Schema karnilava1
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `karnilava1` DEFAULT CHARACTER SET utf8 ;
USE `karnilava1` ;

-- -----------------------------------------------------
-- Table `karnilava1`.`role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `karnilava1`.`role` ;

CREATE TABLE IF NOT EXISTS `karnilava1`.`role` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `karnilava1`.`client`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `karnilava1`.`client` ;

CREATE TABLE IF NOT EXISTS `karnilava1`.`client` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `passport` VARCHAR(45) NULL,
  `firstName` VARCHAR(50) NULL,
  `lastName` VARCHAR(50) NULL,
  `password` VARCHAR(45) NULL,
  `idRoles` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `ID passport_UNIQUE` (`passport` ASC),
  INDEX `fk_Client_Roles1_idx` (`idRoles` ASC),
  CONSTRAINT `fk_Client_Roles1`
    FOREIGN KEY (`idRoles`)
    REFERENCES `karnilava1`.`role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `karnilava1`.`type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `karnilava1`.`type` ;

CREATE TABLE IF NOT EXISTS `karnilava1`.`type` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `karnilava1`.`state`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `karnilava1`.`state` ;

CREATE TABLE IF NOT EXISTS `karnilava1`.`state` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `state` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `karnilava1`.`account`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `karnilava1`.`account` ;

CREATE TABLE IF NOT EXISTS `karnilava1`.`account` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `number` VARCHAR(50) NULL,
  `balance` VARCHAR(45) NULL,
  `idClient` INT NOT NULL,
  `idType` INT NOT NULL,
  `idState` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Account features_Client1_idx` (`idClient` ASC),
  INDEX `fk_Account features_Type of account1_idx` (`idType` ASC),
  INDEX `fk_Account features_State options1_idx` (`idState` ASC),
  CONSTRAINT `fk_Account features_Client1`
    FOREIGN KEY (`idClient`)
    REFERENCES `karnilava1`.`client` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Account features_Type of account1`
    FOREIGN KEY (`idType`)
    REFERENCES `karnilava1`.`type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Account features_State options1`
    FOREIGN KEY (`idState`)
    REFERENCES `karnilava1`.`state` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
ROW_FORMAT = DEFAULT;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `karnilava1`.`role`
-- -----------------------------------------------------
START TRANSACTION;
USE `karnilava1`;
INSERT INTO `karnilava1`.`role` (`id`, `role`) VALUES (1, 'Client');
INSERT INTO `karnilava1`.`role` (`id`, `role`) VALUES (2, 'Admin');

COMMIT;


-- -----------------------------------------------------
-- Data for table `karnilava1`.`client`
-- -----------------------------------------------------
START TRANSACTION;
USE `karnilava1`;
INSERT INTO `karnilava1`.`client` (`id`, `passport`, `firstName`, `lastName`, `password`, `idRoles`) VALUES (1, '3050992E011PB0', 'Natallia', 'Karnilava', '12345natasha', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `karnilava1`.`type`
-- -----------------------------------------------------
START TRANSACTION;
USE `karnilava1`;
INSERT INTO `karnilava1`.`type` (`id`, `type`) VALUES (1, 'Credit');
INSERT INTO `karnilava1`.`type` (`id`, `type`) VALUES (2, 'Deposit');
INSERT INTO `karnilava1`.`type` (`id`, `type`) VALUES (3, 'Current');

COMMIT;


-- -----------------------------------------------------
-- Data for table `karnilava1`.`state`
-- -----------------------------------------------------
START TRANSACTION;
USE `karnilava1`;
INSERT INTO `karnilava1`.`state` (`id`, `state`) VALUES (1, 'Open');
INSERT INTO `karnilava1`.`state` (`id`, `state`) VALUES (2, 'Blocked');
INSERT INTO `karnilava1`.`state` (`id`, `state`) VALUES (3, 'Closed');

COMMIT;


-- -----------------------------------------------------
-- Data for table `karnilava1`.`account`
-- -----------------------------------------------------
START TRANSACTION;
USE `karnilava1`;
INSERT INTO `karnilava1`.`account` (`id`, `number`, `balance`, `idClient`, `idType`, `idState`) VALUES (1, '3014456789001', '100', 1, 3, 1);
INSERT INTO `karnilava1`.`account` (`id`, `number`, `balance`, `idClient`, `idType`, `idState`) VALUES (2, '3012456789002', '300', 1, 2, 1);
INSERT INTO `karnilava1`.`account` (`id`, `number`, `balance`, `idClient`, `idType`, `idState`) VALUES (3, '3011456789002', '0', 1, 1, 3);

COMMIT;

