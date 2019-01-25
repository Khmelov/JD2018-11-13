-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema vchernetski
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `vchernetski` ;

-- -----------------------------------------------------
-- Schema vchernetski
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `vchernetski` DEFAULT CHARACTER SET utf8 ;
USE `vchernetski` ;

-- -----------------------------------------------------
-- Table `vchernetski`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `vchernetski`.`roles` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(100) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `vchernetski`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `vchernetski`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fio` VARCHAR(100) NULL,
  `numbergarages` INT NULL,
  `nickname` VARCHAR(100) NULL,
  `email` VARCHAR(100) NULL,
  `password` VARCHAR(100) NULL,
  `roles_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_users_roles1`
    FOREIGN KEY (`roles_id`)
    REFERENCES `vchernetski`.`roles` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_users_roles1_idx` ON `vchernetski`.`users` (`roles_id` ASC);


-- -----------------------------------------------------
-- Table `vchernetski`.`garages`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `vchernetski`.`garages` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `adress` VARCHAR(100) NULL,
  `carplaces` INT NULL,
  `users_id` INT NOT NULL,
  PRIMARY KEY (`id`, `users_id`),
  CONSTRAINT `fk_garages_users1`
    FOREIGN KEY (`users_id`)
    REFERENCES `vchernetski`.`users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE INDEX `fk_garages_users1_idx` ON `vchernetski`.`garages` (`users_id` ASC);


-- -----------------------------------------------------
-- Table `vchernetski`.`cars`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `vchernetski`.`cars` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `model` VARCHAR(100) NOT NULL,
  `color` VARCHAR(100) NULL,
  `year` INT NULL,
  `garages_id` INT NOT NULL,
  PRIMARY KEY (`id`, `model`),
  CONSTRAINT `fk_cars_garages1`
    FOREIGN KEY (`garages_id`)
    REFERENCES `vchernetski`.`garages` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_cars_garages1_idx` ON `vchernetski`.`cars` (`garages_id` ASC);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `vchernetski`.`roles`
-- -----------------------------------------------------
START TRANSACTION;
USE `vchernetski`;
INSERT INTO `vchernetski`.`roles` (`id`, `role`) VALUES (DEFAULT, 'admin');
INSERT INTO `vchernetski`.`roles` (`id`, `role`) VALUES (DEFAULT, 'user');
INSERT INTO `vchernetski`.`roles` (`id`, `role`) VALUES (DEFAULT, 'guest');

COMMIT;


-- -----------------------------------------------------
-- Data for table `vchernetski`.`users`
-- -----------------------------------------------------
START TRANSACTION;
USE `vchernetski`;
INSERT INTO `vchernetski`.`users` (`id`, `fio`, `numbergarages`, `nickname`, `email`, `password`, `roles_id`) VALUES (DEFAULT, 'Ivan Ivanovich Ivanov', 2, 'ivanich', 'ivanich@mail.ru', 'user', 2);
INSERT INTO `vchernetski`.`users` (`id`, `fio`, `numbergarages`, `nickname`, `email`, `password`, `roles_id`) VALUES (DEFAULT, 'Petr Petrovich Petrov', 0, 'petya', 'petya@yandex.ru', 'admin', 1);
INSERT INTO `vchernetski`.`users` (`id`, `fio`, `numbergarages`, `nickname`, `email`, `password`, `roles_id`) VALUES (DEFAULT, 'Vasilii Vasil\'evich Vasil\'ev', 0, 'vasya', 'vasya@gmail.com', 'guest', 3);

COMMIT;


-- -----------------------------------------------------
-- Data for table `vchernetski`.`garages`
-- -----------------------------------------------------
START TRANSACTION;
USE `vchernetski`;
INSERT INTO `vchernetski`.`garages` (`id`, `adress`, `carplaces`, `users_id`) VALUES (DEFAULT, 'Minsk, Lenina 3', 2, 1);
INSERT INTO `vchernetski`.`garages` (`id`, `adress`, `carplaces`, `users_id`) VALUES (DEFAULT, 'Minsk, Moskovskaya 17', 1, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `vchernetski`.`cars`
-- -----------------------------------------------------
START TRANSACTION;
USE `vchernetski`;
INSERT INTO `vchernetski`.`cars` (`id`, `model`, `color`, `year`, `garages_id`) VALUES (DEFAULT, 'BMW X5', 'white', 2015, 1);
INSERT INTO `vchernetski`.`cars` (`id`, `model`, `color`, `year`, `garages_id`) VALUES (DEFAULT, 'Range Rover Sport', 'black', 2012, 1);
INSERT INTO `vchernetski`.`cars` (`id`, `model`, `color`, `year`, `garages_id`) VALUES (DEFAULT, 'Audi A4', 'blue', 2018, 2);

COMMIT;

