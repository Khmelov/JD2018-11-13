-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

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
  `id` INT NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(20) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zhivov`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zhivov`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NULL,
  `login` VARCHAR(45) NULL,
  `password` VARCHAR(26) NULL,
  `dateofbirth` DATE NULL,
  `email` VARCHAR(45) NULL,
  `tel` VARCHAR(45) NULL,
  `roles_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_users_roles_idx` (`roles_id` ASC) VISIBLE,
  UNIQUE INDEX `login_UNIQUE` (`login` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  UNIQUE INDEX `tel_UNIQUE` (`tel` ASC) VISIBLE,
  CONSTRAINT `fk_users_roles`
    FOREIGN KEY (`roles_id`)
    REFERENCES `zhivov`.`roles` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zhivov`.`ads`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zhivov`.`ads` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(50) NULL,
  `description` VARCHAR(2000) NULL,
  `brand` VARCHAR(45) NULL,
  `model` VARCHAR(45) NULL,
  `color` VARCHAR(45) NULL,
  `body` VARCHAR(45) NULL,
  `year` INT NULL,
  `engine` DOUBLE NULL,
  `at` INT NULL,
  `driveunit` VARCHAR(15) NULL,
  `equipment` VARCHAR(45) NULL,
  `mileage` INT NULL,
  `crashed` INT NULL,
  `price` DOUBLE NULL,
  `users_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_ads_users1_idx` (`users_id` ASC) VISIBLE,
  CONSTRAINT `fk_ads_users1`
    FOREIGN KEY (`users_id`)
    REFERENCES `zhivov`.`users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `zhivov`.`roles`
-- -----------------------------------------------------
START TRANSACTION;
USE `zhivov`;
INSERT INTO `zhivov`.`roles` (`id`, `role`) VALUES (DEFAULT, 'admin');
INSERT INTO `zhivov`.`roles` (`id`, `role`) VALUES (DEFAULT, 'user');
INSERT INTO `zhivov`.`roles` (`id`, `role`) VALUES (DEFAULT, 'guest');

COMMIT;


-- -----------------------------------------------------
-- Data for table `zhivov`.`users`
-- -----------------------------------------------------
START TRANSACTION;
USE `zhivov`;
INSERT INTO `zhivov`.`users` (`id`, `name`, `login`, `password`, `dateofbirth`, `email`, `tel`, `roles_id`) VALUES (1, 'm0rph3us', 'admin', 'admin', NULL, NULL, NULL, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `zhivov`.`ads`
-- -----------------------------------------------------
START TRANSACTION;
USE `zhivov`;
INSERT INTO `zhivov`.`ads` (`id`, `title`, `description`, `brand`, `model`, `color`, `body`, `year`, `engine`, `at`, `driveunit`, `equipment`, `mileage`, `crashed`, `price`, `users_id`) VALUES (DEFAULT, 'Best Car', 'This car the beast of cars', 'Lancia', '53', 'yelow', 'coupe', 1996, 2.6, 0, 'full', 'standart', 186153, 1, 580000, 1);

COMMIT;

