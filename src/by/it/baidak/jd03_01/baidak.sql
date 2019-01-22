-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema baidak
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema baidak
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `baidak` DEFAULT CHARACTER SET utf8 ;
USE `baidak` ;

-- -----------------------------------------------------
-- Table `baidak`.`roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `baidak`.`roles` ;

CREATE TABLE IF NOT EXISTS `baidak`.`roles` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `baidak`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `baidak`.`users` ;

CREATE TABLE IF NOT EXISTS `baidak`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nickname` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `pass` VARCHAR(45) NULL,
  `roles_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_users_roles_idx` (`roles_id` ASC),
  CONSTRAINT `fk_users_roles`
    FOREIGN KEY (`roles_id`)
    REFERENCES `baidak`.`roles` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `baidak`.`posts`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `baidak`.`posts` ;

CREATE TABLE IF NOT EXISTS `baidak`.`posts` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `head` VARCHAR(45) NULL,
  `date` VARCHAR(45) NULL,
  `users_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_posts_users1_idx` (`users_id` ASC),
  CONSTRAINT `fk_posts_users1`
    FOREIGN KEY (`users_id`)
    REFERENCES `baidak`.`users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `baidak`.`roles`
-- -----------------------------------------------------
START TRANSACTION;
USE `baidak`;
INSERT INTO `baidak`.`roles` (`id`, `role`) VALUES (DEFAULT, 'admin');
INSERT INTO `baidak`.`roles` (`id`, `role`) VALUES (DEFAULT, 'user');
INSERT INTO `baidak`.`roles` (`id`, `role`) VALUES (DEFAULT, 'guest');

COMMIT;


-- -----------------------------------------------------
-- Data for table `baidak`.`users`
-- -----------------------------------------------------
START TRANSACTION;
USE `baidak`;
INSERT INTO `baidak`.`users` (`id`, `nickname`, `email`, `pass`, `roles_id`) VALUES (DEFAULT, 'makasin', 'maksimb@gm', '1234567', 2);
INSERT INTO `baidak`.`users` (`id`, `nickname`, `email`, `pass`, `roles_id`) VALUES (DEFAULT, 'gen', 'post@gmail', 'sql123', 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `baidak`.`posts`
-- -----------------------------------------------------
START TRANSACTION;
USE `baidak`;
INSERT INTO `baidak`.`posts` (`id`, `head`, `date`, `users_id`) VALUES (DEFAULT, 'my first post', '18.01.2019', 2);

COMMIT;

