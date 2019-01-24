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
CREATE TABLE IF NOT EXISTS `skarpovich`.`roles` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(100) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `role_UNIQUE` (`role` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `skarpovich`.`buyers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `skarpovich`.`buyers` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `fullname` VARCHAR(45) NULL,
  `phone` VARCHAR(45) NULL,
  `roles_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_buyers_roles_idx` (`roles_id` ASC),
  CONSTRAINT `fk_buyers_roles`
    FOREIGN KEY (`roles_id`)
    REFERENCES `skarpovich`.`roles` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `skarpovich`.`purchases`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `skarpovich`.`purchases` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `item` VARCHAR(100) NULL,
  `item_id` INT NULL,
  `color` VARCHAR(45) NULL,
  `price` DOUBLE NULL,
  `shipping_address` VARCHAR(200) NULL,
  `buyers_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_purchases_buyers1_idx` (`buyers_id` ASC),
  CONSTRAINT `fk_purchases_buyers1`
    FOREIGN KEY (`buyers_id`)
    REFERENCES `skarpovich`.`buyers` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `skarpovich`.`roles`
-- -----------------------------------------------------
START TRANSACTION;
USE `skarpovich`;
INSERT INTO `skarpovich`.`roles` (`id`, `role`) VALUES (DEFAULT, 'administrator');
INSERT INTO `skarpovich`.`roles` (`id`, `role`) VALUES (DEFAULT, 'buyer');
INSERT INTO `skarpovich`.`roles` (`id`, `role`) VALUES (DEFAULT, 'guest');

COMMIT;


-- -----------------------------------------------------
-- Data for table `skarpovich`.`buyers`
-- -----------------------------------------------------
START TRANSACTION;
USE `skarpovich`;
INSERT INTO `skarpovich`.`buyers` (`id`, `username`, `password`, `email`, `fullname`, `phone`, `roles_id`) VALUES (DEFAULT, 'admin', 'admin', 'admin@admin.com', 'John Black', '911-911-9111', 1);
INSERT INTO `skarpovich`.`buyers` (`id`, `username`, `password`, `email`, `fullname`, `phone`, `roles_id`) VALUES (DEFAULT, 'john', 'john1', 'johndoe@yahoo.com', 'John Doe', '212-564-5555', 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `skarpovich`.`purchases`
-- -----------------------------------------------------
START TRANSACTION;
USE `skarpovich`;
INSERT INTO `skarpovich`.`purchases` (`id`, `item`, `item_id`, `color`, `price`, `shipping_address`, `buyers_id`) VALUES (DEFAULT, 'Iphone X 3gb/128gb', 1023000, 'black', 999, '444 W. 27th Street, 4th Floor, New York, NY 10001', 2);
INSERT INTO `skarpovich`.`purchases` (`id`, `item`, `item_id`, `color`, `price`, `shipping_address`, `buyers_id`) VALUES (DEFAULT, 'Xiaomi Redmi Note 5 3gb/32gb', 1070099, 'red', 200, '555 W. 27th Street, 5rd Floor, New York, NY 10001', 2);

COMMIT;

