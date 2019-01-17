-- -----------------------------------------------------
-- Table `itacademy`.`roles`
-- -----------------------------------------------------
--DROP TABLE IF EXISTS `itacademy`.`ads` ;
--DROP TABLE IF EXISTS `itacademy`.`users` ;
--DROP TABLE IF EXISTS `itacademy`.`roles` ;

DROP SCHEMA IF EXISTS `itacademy` ;

-- -----------------------------------------------------
-- Schema akhmelev
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `itacademy` DEFAULT CHARACTER SET utf8;

-- -----------------------------------------------------
-- Table `itacademy`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `itacademy`.`roles` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `Role` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `itacademy`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `itacademy`.`users` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `Login` VARCHAR(45) NULL DEFAULT NULL,
  `Password` VARCHAR(45) NULL DEFAULT NULL,
  `Email` VARCHAR(45) NULL DEFAULT NULL,
  `FK_roles` INT(11) NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_users_FK_rolesx` (`FK_roles` ASC),
  CONSTRAINT `fk_users_roles`
    FOREIGN KEY (`FK_roles`)
    REFERENCES `itacademy`.`roles` (`ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `itacademy`.`ads`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `itacademy`.`ads` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `RoomCount` INT(11) NULL DEFAULT NULL,
  `Floor` INT(11) NULL DEFAULT NULL,
  `Floors` INT(11) NULL DEFAULT NULL,
  `Price` DOUBLE NULL DEFAULT NULL,
  `Area` DOUBLE NULL DEFAULT NULL,
  `Description` VARCHAR(5000) NULL DEFAULT NULL,
  `Address` VARCHAR(200) NULL DEFAULT NULL,
  `FK_users` INT(11) NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_ads_users1_idx` (`FK_users` ASC),
  CONSTRAINT `fk_ads_users1`
    FOREIGN KEY (`FK_users`)
    REFERENCES `itacademy`.`users` (`ID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 17
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Data for table `itacademy`.`roles`
-- -----------------------------------------------------
START TRANSACTION;
USE `itacademy`;
INSERT INTO `itacademy`.`roles` (`ID`, `Role`) VALUES (DEFAULT, 'Admin');
INSERT INTO `itacademy`.`roles` (`ID`, `Role`) VALUES (DEFAULT, 'User');
INSERT INTO `itacademy`.`roles` (`ID`, `Role`) VALUES (DEFAULT, 'Guest');

COMMIT;


-- -----------------------------------------------------
-- Data for table `itacademy`.`users`
-- -----------------------------------------------------
INSERT INTO `itacademy`.`users` (`ID`, `Login`, `Password`, `Email`, `FK_roles`) VALUES (DEFAULT, 'Admin', 'admin', 'adm@it.by', 1);
INSERT INTO `itacademy`.`users` (`ID`, `Login`, `Password`, `Email`, `FK_roles`) VALUES (DEFAULT, 'User', 'user', 'user@it.by', 2);



-- -----------------------------------------------------
-- Data for table `itacademy`.`ads`
-- -----------------------------------------------------
INSERT INTO `itacademy`.`ads` (`ID`, `RoomCount`, `Floor`, `Floors`, `Price`, `Area`, `Description`, `Address`, `FK_users`) VALUES (DEFAULT, 1, 2, 5, 55555, 50, 'Тестовое объявление', 'Кнорина 9', 2);

