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
DROP TABLE IF EXISTS `mnovikov`.`roles` ;

CREATE TABLE IF NOT EXISTS `mnovikov`.`roles` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(50) NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mnovikov`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mnovikov`.`users` ;

CREATE TABLE IF NOT EXISTS `mnovikov`.`users` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `birthday` TIMESTAMP(6) NULL,
  `adress` VARCHAR(500) NULL,
  `roles_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_users_roles_idx` (`roles_ID` ASC),
  UNIQUE INDEX `login_UNIQUE` (`login` ASC),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC),
  CONSTRAINT `fk_users_roles`
    FOREIGN KEY (`roles_ID`)
    REFERENCES `mnovikov`.`roles` (`ID`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mnovikov`.`orders`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mnovikov`.`orders` ;

CREATE TABLE IF NOT EXISTS `mnovikov`.`orders` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `date` TIMESTAMP(6) NULL,
  `users_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_orders_users1_idx` (`users_ID` ASC),
  CONSTRAINT `fk_orders_users1`
    FOREIGN KEY (`users_ID`)
    REFERENCES `mnovikov`.`users` (`ID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mnovikov`.`goods`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mnovikov`.`goods` ;

CREATE TABLE IF NOT EXISTS `mnovikov`.`goods` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NULL,
  `discription` VARCHAR(2000) NULL,
  `type` VARCHAR(45) NULL,
  `productivity` DOUBLE NULL,
  `price` DOUBLE NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mnovikov`.`orders_goods`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mnovikov`.`orders_goods` ;

CREATE TABLE IF NOT EXISTS `mnovikov`.`orders_goods` (
  `orders_ID` INT NOT NULL,
  `goods_ID` INT NOT NULL,
  INDEX `fk_orders_goods_orders1_idx` (`orders_ID` ASC),
  INDEX `fk_orders_goods_goods1_idx` (`goods_ID` ASC),
  CONSTRAINT `fk_orders_goods_orders1`
    FOREIGN KEY (`orders_ID`)
    REFERENCES `mnovikov`.`orders` (`ID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_orders_goods_goods1`
    FOREIGN KEY (`goods_ID`)
    REFERENCES `mnovikov`.`goods` (`ID`)
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
INSERT INTO `mnovikov`.`roles` (`ID`, `role`) VALUES (DEFAULT, 'Administrator');
INSERT INTO `mnovikov`.`roles` (`ID`, `role`) VALUES (DEFAULT, 'Customer');

COMMIT;


-- -----------------------------------------------------
-- Data for table `mnovikov`.`users`
-- -----------------------------------------------------
START TRANSACTION;
USE `mnovikov`;
INSERT INTO `mnovikov`.`users` (`ID`, `login`, `password`, `email`, `first_name`, `last_name`, `birthday`, `adress`, `roles_ID`) VALUES (DEFAULT, 'Administrator', 'root111', 'admin@mail.ru', 'Maksim', 'Novikov', '1986-02-12 11:0:00', 'Minsk, Knorina 1', 1);
INSERT INTO `mnovikov`.`users` (`ID`, `login`, `password`, `email`, `first_name`, `last_name`, `birthday`, `adress`, `roles_ID`) VALUES (DEFAULT, 'customer_01', 'qwerty', 'cus_01@mail.ru', 'Pavel', 'Derevyanko', '1980-01-01 12:00:30', 'Minsk, Lenina 1/5', 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `mnovikov`.`orders`
-- -----------------------------------------------------
START TRANSACTION;
USE `mnovikov`;
INSERT INTO `mnovikov`.`orders` (`ID`, `date`, `users_ID`) VALUES (DEFAULT, '2019-01-20 20:18:55', 2);
INSERT INTO `mnovikov`.`orders` (`ID`, `date`, `users_ID`) VALUES (DEFAULT, '2019-01-21 21:11:51', 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `mnovikov`.`goods`
-- -----------------------------------------------------
START TRANSACTION;
USE `mnovikov`;
INSERT INTO `mnovikov`.`goods` (`ID`, `title`, `discription`, `type`, `productivity`, `price`) VALUES (DEFAULT, 'Nietfeld Speedprobe', 'Speedprob is a towed work implement for extracting soil samples at a depth of 12-30 cm at a travelling speed of 8-12 km/hr., depending on the soil type and properties.', 'auto', 16, 7000);
INSERT INTO `mnovikov`.`goods` (`ID`, `title`, `discription`, `type`, `productivity`, `price`) VALUES (DEFAULT, 'Nietfeld BOPROB', 'BOPROB is a towed work implement for extracting soil samples at a depth of 10-30 cm at a travelling speed of 3-12 km/hr., depending on the soil type and properties.', 'mauto', 15, 8000);

COMMIT;


-- -----------------------------------------------------
-- Data for table `mnovikov`.`orders_goods`
-- -----------------------------------------------------
START TRANSACTION;
USE `mnovikov`;
INSERT INTO `mnovikov`.`orders_goods` (`orders_ID`, `goods_ID`) VALUES (1, 1);
INSERT INTO `mnovikov`.`orders_goods` (`orders_ID`, `goods_ID`) VALUES (1, 2);
INSERT INTO `mnovikov`.`orders_goods` (`orders_ID`, `goods_ID`) VALUES (2, 1);

COMMIT;

