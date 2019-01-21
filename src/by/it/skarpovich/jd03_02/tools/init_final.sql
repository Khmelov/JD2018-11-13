-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema skarpovich
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `skarpovich` ;

-- -----------------------------------------------------
-- Schema skarpovich
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `skarpovich` DEFAULT CHARACTER SET utf8 ;
USE `skarpovich` ;

-- -----------------------------------------------------
-- Table `skarpovich`.`roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `skarpovich`.`roles` ;

CREATE TABLE IF NOT EXISTS `skarpovich`.`roles` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `role_UNIQUE` (`role` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `skarpovich`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `skarpovich`.`users` ;

CREATE TABLE IF NOT EXISTS `skarpovich`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `fullname` VARCHAR(45) NULL,
  `phone` VARCHAR(45) NULL,
  `address` VARCHAR(100) NULL,
  `roles_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC),
  INDEX `fk_users_roles_idx` (`roles_id` ASC),
  CONSTRAINT `fk_users_roles`
    FOREIGN KEY (`roles_id`)
    REFERENCES `skarpovich`.`roles` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `skarpovich`.`items`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `skarpovich`.`items` ;

CREATE TABLE IF NOT EXISTS `skarpovich`.`items` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NULL,
  `floors` INT NULL,
  `square` INT NULL,
  `materials` VARCHAR(300) NULL,
  `price` DOUBLE NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `title_UNIQUE` (`title` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `skarpovich`.`orders`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `skarpovich`.`orders` ;

CREATE TABLE IF NOT EXISTS `skarpovich`.`orders` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `date` DATE NULL,
  `time` TIME NULL,
  `users_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_orders_users1_idx` (`users_id` ASC),
  CONSTRAINT `fk_orders_users1`
    FOREIGN KEY (`users_id`)
    REFERENCES `skarpovich`.`users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `skarpovich`.`orders_items`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `skarpovich`.`orders_items` ;

CREATE TABLE IF NOT EXISTS `skarpovich`.`orders_items` (
  `orders_id` INT NOT NULL,
  `items_id` INT NOT NULL,
  INDEX `fk_orders_items_orders1_idx` (`orders_id` ASC),
  INDEX `fk_orders_items_items1_idx` (`items_id` ASC),
  CONSTRAINT `fk_orders_items_orders1`
    FOREIGN KEY (`orders_id`)
    REFERENCES `skarpovich`.`orders` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_orders_items_items1`
    FOREIGN KEY (`items_id`)
    REFERENCES `skarpovich`.`items` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `skarpovich`.`roles`
-- -----------------------------------------------------
START TRANSACTION;
USE `skarpovich`;
INSERT INTO `skarpovich`.`roles` (`id`, `role`) VALUES (DEFAULT, 'admin');
INSERT INTO `skarpovich`.`roles` (`id`, `role`) VALUES (DEFAULT, 'user');
INSERT INTO `skarpovich`.`roles` (`id`, `role`) VALUES (DEFAULT, 'guest');

COMMIT;


-- -----------------------------------------------------
-- Data for table `skarpovich`.`users`
-- -----------------------------------------------------
START TRANSACTION;
USE `skarpovich`;
INSERT INTO `skarpovich`.`users` (`id`, `username`, `password`, `email`, `fullname`, `phone`, `address`, `roles_id`) VALUES (DEFAULT, 'admin', 'admin', 'admin@admin.com', 'John Black', '911-911-9111', 'Kremlin, Russia', 1);
INSERT INTO `skarpovich`.`users` (`id`, `username`, `password`, `email`, `fullname`, `phone`, `address`, `roles_id`) VALUES (DEFAULT, 'john', 'john1', 'johndoe@yahoo.com', 'John Doe', '212-564-5555', '444 W. 27th Street, 4th Floor, New York, NY 10001', 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `skarpovich`.`items`
-- -----------------------------------------------------
START TRANSACTION;
USE `skarpovich`;
INSERT INTO `skarpovich`.`items` (`id`, `title`, `floors`, `square`, `materials`, `price`) VALUES (DEFAULT, 'Zx87', 1, 133, 'Aerated concrete, ceramic blocks', 510);
INSERT INTO `skarpovich`.`items` (`id`, `title`, `floors`, `square`, `materials`, `price`) VALUES (DEFAULT, 'Zx152', 2, 299, 'Aerated concrete, ceramic blocks', 650);

COMMIT;


-- -----------------------------------------------------
-- Data for table `skarpovich`.`orders`
-- -----------------------------------------------------
START TRANSACTION;
USE `skarpovich`;
INSERT INTO `skarpovich`.`orders` (`id`, `date`, `time`, `users_id`) VALUES (DEFAULT, '2019-01-19', '10:59:59', 2);
INSERT INTO `skarpovich`.`orders` (`id`, `date`, `time`, `users_id`) VALUES (DEFAULT, '2019-01-20', '11:00:00', 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `skarpovich`.`orders_items`
-- -----------------------------------------------------
START TRANSACTION;
USE `skarpovich`;
INSERT INTO `skarpovich`.`orders_items` (`orders_id`, `items_id`) VALUES (1, 1);
INSERT INTO `skarpovich`.`orders_items` (`orders_id`, `items_id`) VALUES (2, 2);

COMMIT;

