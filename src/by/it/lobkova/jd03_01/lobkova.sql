-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema lobkova
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `lobkova` ;

-- -----------------------------------------------------
-- Schema lobkova
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `lobkova` DEFAULT CHARACTER SET utf8 ;
USE `lobkova` ;

-- -----------------------------------------------------
-- Table `lobkova`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lobkova`.`roles` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lobkova`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lobkova`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(100) NULL,
  `login` VARCHAR(100) NULL,
  `password` VARCHAR(100) NULL,
  `name` VARCHAR(100) NULL,
  `roles_ID` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_users_roles1`
    FOREIGN KEY (`roles_ID`)
    REFERENCES `lobkova`.`roles` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lobkova`.`goals`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lobkova`.`goals` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name_goal` VARCHAR(100) NULL,
  `description_goal` VARCHAR(500) NULL,
  `beginDate` INT NULL,
  `end_date` INT NULL,
  `users_ID` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_goals_users1`
    FOREIGN KEY (`users_ID`)
    REFERENCES `lobkova`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lobkova`.`tasks`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lobkova`.`tasks` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name_task` VARCHAR(100) NULL,
  `Description_task` VARCHAR(500) NULL,
  `date` INT NULL,
  `goals_ID` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_tasks_goals1`
    FOREIGN KEY (`goals_ID`)
    REFERENCES `lobkova`.`goals` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
