CREATE TABLE IF NOT EXISTS `naumenko`.`zakaz` (
  `id_zakaz` INT NOT NULL AUTO_INCREMENT,
  `date_zakaz` DATETIME NULL,
  `koltort` INT NULL,
  `price_zakaz` DECIMAL NULL,
  `users_id_users` INT NOT NULL,
  `cake_id_cake` INT NOT NULL,
  PRIMARY KEY (`id_zakaz`),
  INDEX `fk_zakaz_users1_idx` (`users_id_users` ASC),
  INDEX `fk_zakaz_cake1_idx` (`cake_id_cake` ASC),
  CONSTRAINT `fk_zakaz_users1`
    FOREIGN KEY (`users_id_users`)
    REFERENCES `naumenko`.`users` (`id_users`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `fk_zakaz_cake1`
    FOREIGN KEY (`cake_id_cake`)
    REFERENCES `naumenko`.`cake` (`id_cake`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;