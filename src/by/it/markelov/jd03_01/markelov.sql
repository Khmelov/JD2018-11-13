-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema markelov
-- -----------------------------------------------------
-- База для отчетного проекта
--
DROP SCHEMA IF EXISTS `markelov` ;

-- -----------------------------------------------------
-- Schema markelov
--
-- База для отчетного проекта
--
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `markelov` DEFAULT CHARACTER SET utf8 ;
USE `markelov` ;

-- -----------------------------------------------------
-- Table `markelov`.`roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `markelov`.`roles` ;

CREATE TABLE IF NOT EXISTS `markelov`.`roles` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Role` VARCHAR(45) NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `markelov`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `markelov`.`users` ;

CREATE TABLE IF NOT EXISTS `markelov`.`users` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Login` VARCHAR(45) NULL,
  `Password` VARCHAR(45) NULL,
  `E-Mail` VARCHAR(45) NULL,
  `roles_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_users_roles_idx` (`roles_ID` ASC),
  CONSTRAINT `fk_users_roles`
    FOREIGN KEY (`roles_ID`)
    REFERENCES `markelov`.`roles` (`ID`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `markelov`.`orders`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `markelov`.`orders` ;

CREATE TABLE IF NOT EXISTS `markelov`.`orders` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Shoe_name` VARCHAR(45) NULL,
  `Shoe_size` INT NULL,
  `Shoe_collour` VARCHAR(45) NULL,
  `Price` DOUBLE NULL,
  `users_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_orders_users1_idx` (`users_ID` ASC),
  CONSTRAINT `fk_orders_users1`
    FOREIGN KEY (`users_ID`)
    REFERENCES `markelov`.`users` (`ID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `markelov`.`shoe_names`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `markelov`.`shoe_names` ;

CREATE TABLE IF NOT EXISTS `markelov`.`shoe_names` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `orders_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_shoe_names_orders1_idx` (`orders_ID` ASC),
  CONSTRAINT `fk_shoe_names_orders1`
    FOREIGN KEY (`orders_ID`)
    REFERENCES `markelov`.`orders` (`ID`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `markelov`.`shoe_sizes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `markelov`.`shoe_sizes` ;

CREATE TABLE IF NOT EXISTS `markelov`.`shoe_sizes` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `shoe_size` DOUBLE NULL,
  `orders_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_shoe_sizes_orders1_idx` (`orders_ID` ASC),
  CONSTRAINT `fk_shoe_sizes_orders1`
    FOREIGN KEY (`orders_ID`)
    REFERENCES `markelov`.`orders` (`ID`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `markelov`.`shoe_collour`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `markelov`.`shoe_collour` ;

CREATE TABLE IF NOT EXISTS `markelov`.`shoe_collour` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `shoe_collour` VARCHAR(45) NULL,
  `orders_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_shoe_collour_orders1_idx` (`orders_ID` ASC),
  CONSTRAINT `fk_shoe_collour_orders1`
    FOREIGN KEY (`orders_ID`)
    REFERENCES `markelov`.`orders` (`ID`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `markelov`.`roles`
-- -----------------------------------------------------
START TRANSACTION;
USE `markelov`;
INSERT INTO `markelov`.`roles` (`ID`, `Role`) VALUES (DEFAULT, 'Administrator');
INSERT INTO `markelov`.`roles` (`ID`, `Role`) VALUES (DEFAULT, 'User');

COMMIT;


-- -----------------------------------------------------
-- Data for table `markelov`.`users`
-- -----------------------------------------------------
START TRANSACTION;
USE `markelov`;
INSERT INTO `markelov`.`users` (`ID`, `Login`, `Password`, `E-Mail`, `roles_ID`) VALUES (DEFAULT, 'Admin', 'PAdmin', 'Admin@gmail.com', 1);
INSERT INTO `markelov`.`users` (`ID`, `Login`, `Password`, `E-Mail`, `roles_ID`) VALUES (DEFAULT, 'User', 'PUser', 'User@gmail.com', 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `markelov`.`orders`
-- -----------------------------------------------------
START TRANSACTION;
USE `markelov`;
INSERT INTO `markelov`.`orders` (`ID`, `Shoe_name`, `Shoe_size`, `Shoe_collour`, `Price`, `users_ID`) VALUES (DEFAULT, 'Sneakers', 42, 'Green', 62.50, 2);
INSERT INTO `markelov`.`orders` (`ID`, `Shoe_name`, `Shoe_size`, `Shoe_collour`, `Price`, `users_ID`) VALUES (DEFAULT, 'Boots', 36, 'Black', 70.35, 2);
INSERT INTO `markelov`.`orders` (`ID`, `Shoe_name`, `Shoe_size`, `Shoe_collour`, `Price`, `users_ID`) VALUES (DEFAULT, 'Sandals', 40, 'White', 40.00, 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `markelov`.`shoe_names`
-- -----------------------------------------------------
START TRANSACTION;
USE `markelov`;
INSERT INTO `markelov`.`shoe_names` (`ID`, `name`, `orders_ID`) VALUES (DEFAULT, 'Sneakers', 1);
INSERT INTO `markelov`.`shoe_names` (`ID`, `name`, `orders_ID`) VALUES (DEFAULT, 'Boots', 2);
INSERT INTO `markelov`.`shoe_names` (`ID`, `name`, `orders_ID`) VALUES (DEFAULT, 'Sandals', 3);

COMMIT;


-- -----------------------------------------------------
-- Data for table `markelov`.`shoe_sizes`
-- -----------------------------------------------------
START TRANSACTION;
USE `markelov`;
INSERT INTO `markelov`.`shoe_sizes` (`ID`, `shoe_size`, `orders_ID`) VALUES (DEFAULT, 42, 1);
INSERT INTO `markelov`.`shoe_sizes` (`ID`, `shoe_size`, `orders_ID`) VALUES (DEFAULT, 36, 2);
INSERT INTO `markelov`.`shoe_sizes` (`ID`, `shoe_size`, `orders_ID`) VALUES (DEFAULT, 40, 3);

COMMIT;


-- -----------------------------------------------------
-- Data for table `markelov`.`shoe_collour`
-- -----------------------------------------------------
START TRANSACTION;
USE `markelov`;
INSERT INTO `markelov`.`shoe_collour` (`ID`, `shoe_collour`, `orders_ID`) VALUES (DEFAULT, 'Green', 1);
INSERT INTO `markelov`.`shoe_collour` (`ID`, `shoe_collour`, `orders_ID`) VALUES (DEFAULT, 'Black', 2);
INSERT INTO `markelov`.`shoe_collour` (`ID`, `shoe_collour`, `orders_ID`) VALUES (DEFAULT, 'White', 3);

COMMIT;

