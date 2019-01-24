-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema denisova
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `denisova` ;

-- -----------------------------------------------------
-- Schema denisova
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `denisova` DEFAULT CHARACTER SET utf8 ;
USE `denisova` ;

-- -----------------------------------------------------
-- Table `denisova`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `denisova`.`roles` (
  `id_role` INT NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(45) NULL,
  PRIMARY KEY (`id_role`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `denisova`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `denisova`.`users` (
  `id_user` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `id_role` INT NOT NULL,
  PRIMARY KEY (`id_user`),
  CONSTRAINT `fk_users_roles`
    FOREIGN KEY (`id_role`)
    REFERENCES `denisova`.`roles` (`id_role`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `denisova`.`themes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `denisova`.`themes` (
  `id_theme` INT NOT NULL AUTO_INCREMENT,
  `theme` VARCHAR(150) NULL,
  PRIMARY KEY (`id_theme`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `denisova`.`tests`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `denisova`.`tests` (
  `id_test` INT NOT NULL AUTO_INCREMENT,
  `test_name` VARCHAR(100) NULL,
  PRIMARY KEY (`id_test`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `denisova`.`type_lesson`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `denisova`.`type_lesson` (
  `id_type` INT NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(100) NULL,
  PRIMARY KEY (`id_type`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `denisova`.`lessons`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `denisova`.`lessons` (
  `id_lesson` INT NOT NULL AUTO_INCREMENT,
  `theory` VARCHAR(150) NULL,
  `id_test` INT NOT NULL,
  `id_theme` INT NOT NULL,
  `id_type` INT NOT NULL,
  PRIMARY KEY (`id_lesson`),
  CONSTRAINT `fk_lessons_tests1`
    FOREIGN KEY (`id_test`)
    REFERENCES `denisova`.`tests` (`id_test`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_lessons_themes1`
    FOREIGN KEY (`id_theme`)
    REFERENCES `denisova`.`themes` (`id_theme`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_lessons_type_lesson1`
    FOREIGN KEY (`id_type`)
    REFERENCES `denisova`.`type_lesson` (`id_type`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `denisova`.`questions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `denisova`.`questions` (
  `id_question` INT NOT NULL AUTO_INCREMENT,
  `question` VARCHAR(350) NULL,
  `id_test` INT NOT NULL,
  PRIMARY KEY (`id_question`),
  CONSTRAINT `fk_questions_tests1`
    FOREIGN KEY (`id_test`)
    REFERENCES `denisova`.`tests` (`id_test`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `denisova`.`answers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `denisova`.`answers` (
  `id_answer` INT NOT NULL AUTO_INCREMENT,
  `answer` VARCHAR(350) NULL,
  `status` VARCHAR(45) NULL,
  `id_question` INT NOT NULL,
  PRIMARY KEY (`id_answer`),
  CONSTRAINT `fk_answers_questions1`
    FOREIGN KEY (`id_question`)
    REFERENCES `denisova`.`questions` (`id_question`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `denisova`.`users_lessons`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `denisova`.`users_lessons` (
  `state` VARCHAR(45) NULL,
  `id_user` INT NOT NULL,
  `id_lesson` INT NOT NULL,
  PRIMARY KEY (`id_user`, `id_lesson`),
  CONSTRAINT `fk_users_lessons_users1`
    FOREIGN KEY (`id_user`)
    REFERENCES `denisova`.`users` (`id_user`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_users_lessons_lessons1`
    FOREIGN KEY (`id_lesson`)
    REFERENCES `denisova`.`lessons` (`id_lesson`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
