-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema naumenko
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `naumenko` ;

-- -----------------------------------------------------
-- Schema naumenko
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `naumenko` DEFAULT CHARACTER SET utf8 ;
USE `naumenko` ;

-- -----------------------------------------------------
-- Table `naumenko`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `naumenko`.`roles` (
  `id_roles` INT NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(45) NULL,
  PRIMARY KEY (`id_roles`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `naumenko`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `naumenko`.`users` (
  `id_users` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(100) NULL,
  `password` VARCHAR(45) NULL,
  `email` VARCHAR(100) NULL,
  `roles_id_roles` INT NOT NULL,
  PRIMARY KEY (`id_users`),
  INDEX `fk_users_roles_idx` (`roles_id_roles` ASC),
  CONSTRAINT `fk_users_roles`
    FOREIGN KEY (`roles_id_roles`)
    REFERENCES `naumenko`.`roles` (`id_roles`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `naumenko`.`cake`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `naumenko`.`cake` (
  `id_cake` INT NOT NULL AUTO_INCREMENT,
  `name_cake` VARCHAR(100) NULL,
  `size_cake` INT NULL,
  `weight_cake` INT NULL,
  `bescuit` VARCHAR(100) NULL,
  `decoration` VARCHAR(100) NULL,
  `cream` VARCHAR(45) NULL,
  `price_cake` DECIMAL NULL,
  PRIMARY KEY (`id_cake`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `naumenko`.`zakaz`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `naumenko`.`zakaz` (
  `id_zakaz` INT NOT NULL AUTO_INCREMENT,
  `date_zakaz` DATETIME NULL,
  `koltort` INT NULL,
  `price_zakaz` DECIMAL NULL,
  `users_id_users` INT NOT NULL,
  `cake_id_cake` INT NOT NULL,
  PRIMARY KEY (`id_zakaz`),
  INDEX `fk_zakaz_users1_idx` (`users_id_users` ASC),
  INDEX `fk_zakaz_cake1_idx` (`cake_id_cake` ASC),
  CONSTRAINT `fk_zakaz_users1`
    FOREIGN KEY (`users_id_users`)
    REFERENCES `naumenko`.`users` (`id_users`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `fk_zakaz_cake1`
    FOREIGN KEY (`cake_id_cake`)
    REFERENCES `naumenko`.`cake` (`id_cake`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `naumenko`.`roles`
-- -----------------------------------------------------
START TRANSACTION;
USE `naumenko`;
INSERT INTO `naumenko`.`roles` (`id_roles`, `role`) VALUES (DEFAULT, 'admin');
INSERT INTO `naumenko`.`roles` (`id_roles`, `role`) VALUES (DEFAULT, 'user');
INSERT INTO `naumenko`.`roles` (`id_roles`, `role`) VALUES (DEFAULT, 'client');

COMMIT;


-- -----------------------------------------------------
-- Data for table `naumenko`.`users`
-- -----------------------------------------------------
START TRANSACTION;
USE `naumenko`;
INSERT INTO `naumenko`.`users` (`id_users`, `login`, `password`, `email`, `roles_id_roles`) VALUES (DEFAULT, 'root', '', 'naumenkosergeyns@gmail.com', 1);
INSERT INTO `naumenko`.`users` (`id_users`, `login`, `password`, `email`, `roles_id_roles`) VALUES (DEFAULT, 'vasya', 'vasya', 'vasya@yandex.ru', 2);
INSERT INTO `naumenko`.`users` (`id_users`, `login`, `password`, `email`, `roles_id_roles`) VALUES (DEFAULT, 'kolya', 'kolya', 'kolya@mail.ru', 3);

COMMIT;


-- -----------------------------------------------------
-- Data for table `naumenko`.`cake`
-- -----------------------------------------------------
START TRANSACTION;
USE `naumenko`;
INSERT INTO `naumenko`.`cake` (`id_cake`, `name_cake`, `size_cake`, `weight_cake`, `bescuit`, `decoration`, `cream`, `price_cake`) VALUES (DEFAULT, 'red barhot', 30, 5, 'redbarhot', 'caramel', 'chiss', 150);
INSERT INTO `naumenko`.`cake` (`id_cake`, `name_cake`, `size_cake`, `weight_cake`, `bescuit`, `decoration`, `cream`, `price_cake`) VALUES (DEFAULT, 'milk girl', 18, 1, 'non', 'mars', 'chis', 30);

COMMIT;


-- -----------------------------------------------------
-- Data for table `naumenko`.`zakaz`
-- -----------------------------------------------------
START TRANSACTION;
USE `naumenko`;
INSERT INTO `naumenko`.`zakaz` (`id_zakaz`, `date_zakaz`, `koltort`, `price_zakaz`, `users_id_users`, `cake_id_cake`) VALUES (DEFAULT, '2018-12-25 05:52:30', 1, 150, 2, 1);
INSERT INTO `naumenko`.`zakaz` (`id_zakaz`, `date_zakaz`, `koltort`, `price_zakaz`, `users_id_users`, `cake_id_cake`) VALUES (DEFAULT, '2018-12-25 15:40:30', 2, 60, 3, 2);

COMMIT;

