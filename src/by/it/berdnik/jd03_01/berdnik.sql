-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema berdnik
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `berdnik` ;

-- -----------------------------------------------------
-- Schema berdnik
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `berdnik` DEFAULT CHARACTER SET utf8 ;
USE `berdnik` ;

-- -----------------------------------------------------
-- Table `berdnik`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `berdnik`.`roles` (
  `idroles` INT NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(45) NULL,
  PRIMARY KEY (`idroles`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `berdnik`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `berdnik`.`users` (
  `idusers` INT NOT NULL AUTO_INCREMENT,
  `nickname` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `e-mail` VARCHAR(45) NULL,
  `roles_idroles` INT NOT NULL,
  PRIMARY KEY (`idusers`),
  INDEX `fk_users_roles1_idx` (`roles_idroles` ASC),
  CONSTRAINT `fk_users_roles1`
    FOREIGN KEY (`roles_idroles`)
    REFERENCES `berdnik`.`roles` (`idroles`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `berdnik`.`buyers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `berdnik`.`buyers` (
  `idbuyers` INT NOT NULL AUTO_INCREMENT,
  `item` VARCHAR(500) NULL,
  `id_item` INT NULL,
  `specif` VARCHAR(2000) NULL,
  `price` INT NULL,
  `address` VARCHAR(1000) NULL,
  `users_idusers` INT NOT NULL,
  PRIMARY KEY (`idbuyers`),
  INDEX `fk_buyers_users1_idx` (`users_idusers` ASC),
  CONSTRAINT `fk_buyers_users1`
    FOREIGN KEY (`users_idusers`)
    REFERENCES `berdnik`.`users` (`idusers`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `berdnik`.`roles`
-- -----------------------------------------------------
START TRANSACTION;
USE `berdnik`;
INSERT INTO `berdnik`.`roles` (`idroles`, `role`) VALUES (DEFAULT, 'admin');
INSERT INTO `berdnik`.`roles` (`idroles`, `role`) VALUES (DEFAULT, 'user');

COMMIT;


-- -----------------------------------------------------
-- Data for table `berdnik`.`users`
-- -----------------------------------------------------
START TRANSACTION;
USE `berdnik`;
INSERT INTO `berdnik`.`users` (`idusers`, `nickname`, `password`, `e-mail`, `roles_idroles`) VALUES (DEFAULT, 'admin', 'admin', 'admin@mail.ru', 1);
INSERT INTO `berdnik`.`users` (`idusers`, `nickname`, `password`, `e-mail`, `roles_idroles`) VALUES (DEFAULT, 'user', 'user', 'user@mail.ru', 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `berdnik`.`buyers`
-- -----------------------------------------------------
START TRANSACTION;
USE `berdnik`;
INSERT INTO `berdnik`.`buyers` (`idbuyers`, `item`, `id_item`, `specif`, `price`, `address`, `users_idusers`) VALUES (DEFAULT, 'MSI GE73 8RF-096XRU Raider RGB', 8096, '17.3\" 1920 x 1080 IPS, Intel i7 8750H, 16 ГБ, HDD 1000 ГБ, NVIDIA GTX 1070 8 ГБ', 3868, 'Minsk Street 1-1', 2);
INSERT INTO `berdnik`.`buyers` (`idbuyers`, `item`, `id_item`, `specif`, `price`, `address`, `users_idusers`) VALUES (DEFAULT, 'Dell G3 17 3779 G317-7664', 3779, '17.3\" 1920 x 1080 IPS, Intel i7 8750H, 16 ГБ, HDD+SSD 2000+256 ГБ, NVIDIA GTX 1060 6 ГБ', 3068, 'Minsk Street 2-2', 2);

COMMIT;

