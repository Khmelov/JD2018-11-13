CREATE TABLE IF NOT EXISTS `naumenko2`.`zakaz` (
  `id_zakaz` INT NOT NULL AUTO_INCREMENT,
  `tovar` VARCHAR(100) NULL,
  `priceHt` DECIMAL NULL,
  `kolTovar` DECIMAL NULL,
  `biscuit` VARCHAR(100) NULL,
  `nachinka` VARCHAR(100) NULL,
  `decoration` VARCHAR(100) NULL,
  `cream` VARCHAR(100) NULL,
  `price_zakaz` DECIMAL NULL,
  `id_user` INT NOT NULL,
  `id_tovar` INT NOT NULL,
  PRIMARY KEY (`id_zakaz`),
  INDEX `fk_zakaz_users1_idx` (`id_user` ASC),
  INDEX `fk_zakaz_cake1_idx` (`id_tovar` ASC),
  CONSTRAINT `fk_zakaz_users1`
    FOREIGN KEY (`id_user`)
    REFERENCES `naumenko2`.`users` (`id_user`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `fk_zakaz_cake1`
    FOREIGN KEY (`id_tovar`)
    REFERENCES `naumenko2`.`cake` (`id_tovar`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
