-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema karnilava
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `karnilava` ;

-- -----------------------------------------------------
-- Schema karnilava
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `karnilava` DEFAULT CHARACTER SET utf8 ;
USE `karnilava` ;

-- -----------------------------------------------------
-- Table `karnilava`.`Roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `karnilava`.`Roles` ;

CREATE TABLE IF NOT EXISTS `karnilava`.`Roles` (
  `idRoles` INT NOT NULL AUTO_INCREMENT,
  `Roles` VARCHAR(45) NULL,
  PRIMARY KEY (`idRoles`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `karnilava`.`Client`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `karnilava`.`Client` ;

CREATE TABLE IF NOT EXISTS `karnilava`.`Client` (
  `idClient` INT NOT NULL AUTO_INCREMENT,
  `ID passport` VARCHAR(45) NULL,
  `first name` VARCHAR(50) NULL,
  `last name` VARCHAR(50) NULL,
  `password` VARCHAR(45) NULL,
  `Roles_idRoles` INT NOT NULL,
  PRIMARY KEY (`idClient`),
  UNIQUE INDEX `ID passport_UNIQUE` (`ID passport` ASC),
  INDEX `fk_Client_Roles1_idx` (`Roles_idRoles` ASC),
  CONSTRAINT `fk_Client_Roles1`
    FOREIGN KEY (`Roles_idRoles`)
    REFERENCES `karnilava`.`Roles` (`idRoles`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `karnilava`.`Type of account`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `karnilava`.`Type of account` ;

CREATE TABLE IF NOT EXISTS `karnilava`.`Type of account` (
  `idType of account` INT NOT NULL AUTO_INCREMENT,
  `Type` VARCHAR(45) NULL,
  PRIMARY KEY (`idType of account`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `karnilava`.`State options`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `karnilava`.`State options` ;

CREATE TABLE IF NOT EXISTS `karnilava`.`State options` (
  `idState options` INT NOT NULL AUTO_INCREMENT,
  `State optionscol` VARCHAR(45) NULL,
  PRIMARY KEY (`idState options`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `karnilava`.`Account features`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `karnilava`.`Account features` ;

CREATE TABLE IF NOT EXISTS `karnilava`.`Account features` (
  `idAccounts` INT NOT NULL AUTO_INCREMENT,
  `Number` VARCHAR(50) NULL,
  `Balance` VARCHAR(45) NULL,
  `Client_idClient` INT NOT NULL,
  `Type of account_idType of account` INT NOT NULL,
  `State options_idState options` INT NOT NULL,
  PRIMARY KEY (`idAccounts`, `Type of account_idType of account`),
  INDEX `fk_Account features_Client1_idx` (`Client_idClient` ASC),
  INDEX `fk_Account features_Type of account1_idx` (`Type of account_idType of account` ASC),
  INDEX `fk_Account features_State options1_idx` (`State options_idState options` ASC),
  CONSTRAINT `fk_Account features_Client1`
    FOREIGN KEY (`Client_idClient`)
    REFERENCES `karnilava`.`Client` (`idClient`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Account features_Type of account1`
    FOREIGN KEY (`Type of account_idType of account`)
    REFERENCES `karnilava`.`Type of account` (`idType of account`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Account features_State options1`
    FOREIGN KEY (`State options_idState options`)
    REFERENCES `karnilava`.`State options` (`idState options`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
ROW_FORMAT = DEFAULT;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `karnilava`.`Roles`
-- -----------------------------------------------------
START TRANSACTION;
USE `karnilava`;
INSERT INTO `karnilava`.`Roles` (`idRoles`, `Roles`) VALUES (1, 'Client');
INSERT INTO `karnilava`.`Roles` (`idRoles`, `Roles`) VALUES (2, 'Admin');

COMMIT;


-- -----------------------------------------------------
-- Data for table `karnilava`.`Client`
-- -----------------------------------------------------
START TRANSACTION;
USE `karnilava`;
INSERT INTO `karnilava`.`Client` (`idClient`, `ID passport`, `first name`, `last name`, `password`, `Roles_idRoles`) VALUES (1, '3050992E011PB0', 'Natallia', 'Karnilava', '12345natasha', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `karnilava`.`Type of account`
-- -----------------------------------------------------
START TRANSACTION;
USE `karnilava`;
INSERT INTO `karnilava`.`Type of account` (`idType of account`, `Type`) VALUES (1, 'Credit');
INSERT INTO `karnilava`.`Type of account` (`idType of account`, `Type`) VALUES (2, 'Deposit');
INSERT INTO `karnilava`.`Type of account` (`idType of account`, `Type`) VALUES (3, 'Current');

COMMIT;


-- -----------------------------------------------------
-- Data for table `karnilava`.`State options`
-- -----------------------------------------------------
START TRANSACTION;
USE `karnilava`;
INSERT INTO `karnilava`.`State options` (`idState options`, `State optionscol`) VALUES (1, 'Open');
INSERT INTO `karnilava`.`State options` (`idState options`, `State optionscol`) VALUES (2, 'Blocked');
INSERT INTO `karnilava`.`State options` (`idState options`, `State optionscol`) VALUES (3, 'Closed');

COMMIT;


-- -----------------------------------------------------
-- Data for table `karnilava`.`Account features`
-- -----------------------------------------------------
START TRANSACTION;
USE `karnilava`;
INSERT INTO `karnilava`.`Account features` (`idAccounts`, `Number`, `Balance`, `Client_idClient`, `Type of account_idType of account`, `State options_idState options`) VALUES (1, '3014456789001', '100', 1, 3, 1);
INSERT INTO `karnilava`.`Account features` (`idAccounts`, `Number`, `Balance`, `Client_idClient`, `Type of account_idType of account`, `State options_idState options`) VALUES (2, '3012456789002', '300', 1, 2, 1);
INSERT INTO `karnilava`.`Account features` (`idAccounts`, `Number`, `Balance`, `Client_idClient`, `Type of account_idType of account`, `State options_idState options`) VALUES (3, '3011456789002', '0', 1, 1, 3);

COMMIT;

