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
  `id` INT NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `berdnik`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `berdnik`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nickname` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `roles_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_users_roles1_idx` (`roles_id` ASC),
  CONSTRAINT `fk_users_roles1`
    FOREIGN KEY (`roles_id`)
    REFERENCES `berdnik`.`roles` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `berdnik`.`buyers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `berdnik`.`buyers` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `item` VARCHAR(500) NULL,
  `specif` VARCHAR(2000) NULL,
  `price` INT NULL,
  `address` VARCHAR(1000) NULL,
  `users_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_buyers_users1_idx` (`users_id` ASC),
  CONSTRAINT `fk_buyers_users1`
    FOREIGN KEY (`users_id`)
    REFERENCES `berdnik`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `berdnik`.`roles`
-- -----------------------------------------------------
START TRANSACTION;
USE `berdnik`;
INSERT INTO `berdnik`.`roles` (`id`, `role`) VALUES (DEFAULT, 'admin');
INSERT INTO `berdnik`.`roles` (`id`, `role`) VALUES (DEFAULT, 'user');

COMMIT;


-- -----------------------------------------------------
-- Data for table `berdnik`.`users`
-- -----------------------------------------------------
START TRANSACTION;
USE `berdnik`;
INSERT INTO `berdnik`.`users` (`id`, `nickname`, `password`, `email`, `roles_id`) VALUES (DEFAULT, 'admin', 'admin', 'admin@mail.ru', NULL);
INSERT INTO `berdnik`.`users` (`id`, `nickname`, `password`, `email`, `roles_id`) VALUES (DEFAULT, 'user', 'user', 'user@mail.ru', NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `berdnik`.`buyers`
-- -----------------------------------------------------
START TRANSACTION;
USE `berdnik`;
INSERT INTO `berdnik`.`buyers` (`id`, `item`, `specif`, `price`, `address`, `users_id`) VALUES (DEFAULT, 'MSI GE73 8RF-096XRU Raider RGB', '17.3\" 1920 x 1080 IPS, Intel i7 8750H, 16 ГБ, HDD 1000 ГБ, NVIDIA GTX 1070 8 ГБ', 3868, 'Minsk Street 1-1', NULL);
INSERT INTO `berdnik`.`buyers` (`id`, `item`, `specif`, `price`, `address`, `users_id`) VALUES (DEFAULT, 'Dell G3 17 3779 G317-7664', '17.3\" 1920 x 1080 IPS, Intel i7 8750H, 16 ГБ, HDD+SSD 2000+256 ГБ, NVIDIA GTX 1060 6 ГБ', 3068, 'Minsk Street 2-2', NULL);

COMMIT;

