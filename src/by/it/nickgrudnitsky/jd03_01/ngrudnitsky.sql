-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema ngrudnitsky
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `ngrudnitsky` ;

-- -----------------------------------------------------
-- Schema ngrudnitsky
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ngrudnitsky` DEFAULT CHARACTER SET utf8 ;
USE `ngrudnitsky` ;

-- -----------------------------------------------------
-- Table `ngrudnitsky`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ngrudnitsky`.`roles` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(100) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ngrudnitsky`.`viewers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ngrudnitsky`.`viewers` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(100) NULL,
  `password` VARCHAR(100) NULL,
  `nickname` VARCHAR(20) NULL,
  `roles_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_viewers_roles1_idx` (`roles_id` ASC) VISIBLE,
  CONSTRAINT `fk_viewers_roles1`
    FOREIGN KEY (`roles_id`)
    REFERENCES `ngrudnitsky`.`roles` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ngrudnitsky`.`streamers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ngrudnitsky`.`streamers` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(100) NULL,
  `password` VARCHAR(100) NULL,
  `channelname` VARCHAR(45) NULL,
  `roles_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_streamers_roles1_idx` (`roles_id` ASC) VISIBLE,
  CONSTRAINT `fk_streamers_roles1`
    FOREIGN KEY (`roles_id`)
    REFERENCES `ngrudnitsky`.`roles` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ngrudnitsky`.`viewers_has_streamers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ngrudnitsky`.`viewers_has_streamers` (
  `viewers_id` INT NOT NULL,
  `streamers_id` INT NOT NULL,
  PRIMARY KEY (`viewers_id`, `streamers_id`),
  INDEX `fk_viewers_has_streamers_streamers1_idx` (`streamers_id` ASC) VISIBLE,
  INDEX `fk_viewers_has_streamers_viewers1_idx` (`viewers_id` ASC) VISIBLE,
  CONSTRAINT `fk_viewers_has_streamers_viewers1`
    FOREIGN KEY (`viewers_id`)
    REFERENCES `ngrudnitsky`.`viewers` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_viewers_has_streamers_streamers1`
    FOREIGN KEY (`streamers_id`)
    REFERENCES `ngrudnitsky`.`streamers` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `ngrudnitsky`.`roles`
-- -----------------------------------------------------
START TRANSACTION;
USE `ngrudnitsky`;
INSERT INTO `ngrudnitsky`.`roles` (`id`, `role`) VALUES (DEFAULT, 'admin');
INSERT INTO `ngrudnitsky`.`roles` (`id`, `role`) VALUES (DEFAULT, 'streamer');
INSERT INTO `ngrudnitsky`.`roles` (`id`, `role`) VALUES (DEFAULT, 'viewer');

COMMIT;


-- -----------------------------------------------------
-- Data for table `ngrudnitsky`.`viewers`
-- -----------------------------------------------------
START TRANSACTION;
USE `ngrudnitsky`;
INSERT INTO `ngrudnitsky`.`viewers` (`id`, `email`, `password`, `nickname`, `roles_id`) VALUES (DEFAULT, 'grud97@gmail.com', 'password', 'NickGS', 3);
INSERT INTO `ngrudnitsky`.`viewers` (`id`, `email`, `password`, `nickname`, `roles_id`) VALUES (DEFAULT, 'pewdiepie@pewd.se', 'youloose', 'pewdiepie', 3);

COMMIT;


-- -----------------------------------------------------
-- Data for table `ngrudnitsky`.`streamers`
-- -----------------------------------------------------
START TRANSACTION;
USE `ngrudnitsky`;
INSERT INTO `ngrudnitsky`.`streamers` (`id`, `email`, `password`, `channelname`, `roles_id`) VALUES (DEFAULT, 'ninja@gmail.com', 'fortnightlover', 'Ninja', 2);
INSERT INTO `ngrudnitsky`.`streamers` (`id`, `email`, `password`, `channelname`, `roles_id`) VALUES (DEFAULT, 'silvername@gmail.com', 'hearthstone', 'SilverName', 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `ngrudnitsky`.`viewers_has_streamers`
-- -----------------------------------------------------
START TRANSACTION;
USE `ngrudnitsky`;
INSERT INTO `ngrudnitsky`.`viewers_has_streamers` (`viewers_id`, `streamers_id`) VALUES (1, 1);
INSERT INTO `ngrudnitsky`.`viewers_has_streamers` (`viewers_id`, `streamers_id`) VALUES (1, 2);
INSERT INTO `ngrudnitsky`.`viewers_has_streamers` (`viewers_id`, `streamers_id`) VALUES (2, 1);

COMMIT;

