-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema seroglazov
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `seroglazov` ;

-- -----------------------------------------------------
-- Schema seroglazov
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `seroglazov` DEFAULT CHARACTER SET utf8 ;
USE `seroglazov` ;

-- -----------------------------------------------------
-- Table `seroglazov`.`ingredients`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `seroglazov`.`ingredients` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `seroglazov`.`rtypes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `seroglazov`.`rtypes` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `text` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `seroglazov`.`recipes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `seroglazov`.`recipes` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `description` VARCHAR(1000) NULL,
  `rtype_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_recipes_rtypes1_idx` (`rtype_id` ASC),
  CONSTRAINT `fk_recipes_rtypes1`
    FOREIGN KEY (`rtype_id`)
    REFERENCES `seroglazov`.`rtypes` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `seroglazov`.`units`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `seroglazov`.`units` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `seroglazov`.`amounts`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `seroglazov`.`amounts` (
  `recipe_id` INT NOT NULL,
  `ingredient_id` INT NOT NULL,
  `amount` VARCHAR(10) NOT NULL,
  `unit_id` INT NOT NULL,
  INDEX `fk_recipes_ingredients_recipes1_idx` (`recipe_id` ASC),
  INDEX `fk_recipes_ingredients_ingredients1_idx` (`ingredient_id` ASC),
  INDEX `fk_recipes_ingredients_units1_idx` (`unit_id` ASC),
  CONSTRAINT `fk_recipes_ingredients_recipes1`
    FOREIGN KEY (`recipe_id`)
    REFERENCES `seroglazov`.`recipes` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_recipes_ingredients_ingredients1`
    FOREIGN KEY (`ingredient_id`)
    REFERENCES `seroglazov`.`ingredients` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_recipes_ingredients_units1`
    FOREIGN KEY (`unit_id`)
    REFERENCES `seroglazov`.`units` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `seroglazov`.`ingredients`
-- -----------------------------------------------------
START TRANSACTION;
USE `seroglazov`;
INSERT INTO `seroglazov`.`ingredients` (`id`, `name`) VALUES (DEFAULT, 'gin');
INSERT INTO `seroglazov`.`ingredients` (`id`, `name`) VALUES (DEFAULT, 'white rum');
INSERT INTO `seroglazov`.`ingredients` (`id`, `name`) VALUES (DEFAULT, 'vodka');
INSERT INTO `seroglazov`.`ingredients` (`id`, `name`) VALUES (DEFAULT, 'triple sec');

COMMIT;


-- -----------------------------------------------------
-- Data for table `seroglazov`.`units`
-- -----------------------------------------------------
START TRANSACTION;
USE `seroglazov`;
INSERT INTO `seroglazov`.`units` (`id`, `name`) VALUES (DEFAULT, 'cl');
INSERT INTO `seroglazov`.`units` (`id`, `name`) VALUES (DEFAULT, 'ml');
INSERT INTO `seroglazov`.`units` (`id`, `name`) VALUES (DEFAULT, 'slice');
INSERT INTO `seroglazov`.`units` (`id`, `name`) VALUES (DEFAULT, 'dash');
INSERT INTO `seroglazov`.`units` (`id`, `name`) VALUES (DEFAULT, 'cube');

COMMIT;

