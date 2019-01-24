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
  `login` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
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
-- Table `naumenko`.`ads`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `naumenko`.`ads` (
  `id_ads` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(1000) NULL,
  `addres` VARCHAR(500) NULL,
  `flor` INT NULL,
  `flors` INT NULL,
  `roms` INT NULL,
  `area` DECIMAL NULL,
  `price` DECIMAL NULL,
  `users_id_users` INT NOT NULL,
  PRIMARY KEY (`id_ads`),
  INDEX `fk_ads_users1_idx` (`users_id_users` ASC),
  CONSTRAINT `fk_ads_users1`
    FOREIGN KEY (`users_id_users`)
    REFERENCES `naumenko`.`users` (`id_users`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `naumenko`.`roles`
-- -----------------------------------------------------
START TRANSACTION;
USE `naumenko`;
INSERT INTO `naumenko`.`roles` (`id_roles`, `role`) VALUES (DEFAULT, 'админ');
INSERT INTO `naumenko`.`roles` (`id_roles`, `role`) VALUES (DEFAULT, 'пользователь');
INSERT INTO `naumenko`.`roles` (`id_roles`, `role`) VALUES (DEFAULT, 'гость');

COMMIT;


-- -----------------------------------------------------
-- Data for table `naumenko`.`users`
-- -----------------------------------------------------
START TRANSACTION;
USE `naumenko`;
INSERT INTO `naumenko`.`users` (`id_users`, `login`, `password`, `email`, `roles_id_roles`) VALUES (DEFAULT, 'admin', 'admin', 'admin@gmail.com', 1);
INSERT INTO `naumenko`.`users` (`id_users`, `login`, `password`, `email`, `roles_id_roles`) VALUES (DEFAULT, 'user', 'user', 'user@gmail.com', 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `naumenko`.`ads`
-- -----------------------------------------------------
START TRANSACTION;
USE `naumenko`;
INSERT INTO `naumenko`.`ads` (`id_ads`, `description`, `addres`, `flor`, `flors`, `roms`, `area`, `price`, `users_id_users`) VALUES (DEFAULT, 'test1', 'minsk', 4, 15, 3, 152.2, 1458.2, 1);
INSERT INTO `naumenko`.`ads` (`id_ads`, `description`, `addres`, `flor`, `flors`, `roms`, `area`, `price`, `users_id_users`) VALUES (DEFAULT, 'test2', 'grodno', 1, 5, 2, 45, 40, 2);

COMMIT;

