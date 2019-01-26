CREATE TABLE IF NOT EXISTS `naumenko`.`zakaz` (
  `id_zakaz` INT NOT NULL AUTO_INCREMENT,
  `date_zakaz` DATETIME NULL,
  `koltort` INT NULL,
  `price_zakaz` DECIMAL NULL,
  `id_user` INT NOT NULL,
  `id_cake` INT NOT NULL,
  PRIMARY KEY (`id_zakaz`),
  INDEX `fk_zakaz_users1_idx` (`id_user` ASC),
  INDEX `fk_zakaz_cake1_idx` (`id_cake` ASC),
  CONSTRAINT `fk_zakaz_users1`
    FOREIGN KEY (`id_user`)
    REFERENCES `naumenko`.`users` (`id_user`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `fk_zakaz_cake1`
    FOREIGN KEY (`id_cake`)
    REFERENCES `naumenko`.`cake` (`id_cake`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;