-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema zhivov
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `zhivov` ;

-- -----------------------------------------------------
-- Schema zhivov
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `zhivov` DEFAULT CHARACTER SET utf8 ;
USE `zhivov` ;

-- -----------------------------------------------------
-- Table `zhivov`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zhivov`.`roles` (
  `idroles` INT NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(20) NULL,
  PRIMARY KEY (`idroles`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zhivov`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zhivov`.`users` (
  `idusers` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NULL,
  `login` VARCHAR(45) NULL,
  `password` VARCHAR(16) NULL,
  `dateofbirth` DATE NULL,
  `email` VARCHAR(45) NULL,
  `tel` VARCHAR(45) NULL,
  `roles_idroles` INT NOT NULL,
  PRIMARY KEY (`idusers`),
  INDEX `fk_users_roles1_idx` (`roles_idroles` ASC),
  CONSTRAINT `fk_users_roles1`
    FOREIGN KEY (`roles_idroles`)
    REFERENCES `zhivov`.`roles` (`idroles`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zhivov`.`ads`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zhivov`.`ads` (
  `idads` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(50) NULL,
  `description` VARCHAR(2000) NULL,
  `brand` VARCHAR(45) NULL,
  `model` VARCHAR(45) NULL,
  `color` VARCHAR(45) NULL,
  `body` VARCHAR(45) NULL,
  `year` INT NULL,
  `equipment` VARCHAR(45) NULL,
  `mileage` INT NULL,
  `crashed` TINYINT NULL,
  `price` INT NULL,
  `users_idusers` INT NOT NULL,
  PRIMARY KEY (`idads`),
  INDEX `fk_ads_users1_idx` (`users_idusers` ASC),
  CONSTRAINT `fk_ads_users1`
    FOREIGN KEY (`users_idusers`)
    REFERENCES `zhivov`.`users` (`idusers`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `zhivov`.`users`
-- -----------------------------------------------------
START TRANSACTION;
USE `zhivov`;
INSERT INTO `zhivov`.`users` (`idusers`, `name`, `login`, `password`, `dateofbirth`, `email`, `tel`, `roles_idroles`) VALUES (DEFAULT, 'Petya', 'Petr2018', 'petpetya', '26.04.1993', 'petya@mail.ru', '+848651861668', DEFAULT);

COMMIT;


-- -----------------------------------------------------
-- Data for table `zhivov`.`ads`
-- -----------------------------------------------------
START TRANSACTION;
USE `zhivov`;
INSERT INTO `zhivov`.`ads` (`idads`, `title`, `description`, `brand`, `model`, `color`, `body`, `year`, `equipment`, `mileage`, `crashed`, `price`, `users_idusers`) VALUES (DEFAULT, 'TestTitle', 'TestDescription', 'Lancia', '53', 'yelow', 'coupe', 1996, 'standart', 186153, true, 580000, DEFAULT);

COMMIT;

