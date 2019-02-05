CREATE TABLE IF NOT EXISTS `naumenko2`.`basket` (
  `id_basket` INT NOT NULL AUTO_INCREMENT,
  `tovar` VARCHAR(100) NULL,
  `priceHt` DECIMAL NULL,
  `kolTovar` DECIMAL NULL,
  `biscuit` VARCHAR(100) NULL,
  `nachinka` VARCHAR(100) NULL,
  `decoration` VARCHAR(100) NULL,
  `cream` VARCHAR(100) NULL,
  `price_basket` DECIMAL NULL,
  `id_user` INT NOT NULL,
  PRIMARY KEY (`id_basket`),
  INDEX `fk_basket_users1_idx` (`id_user` ASC),
  CONSTRAINT `fk_basket_users1`
    FOREIGN KEY (`id_user`)
    REFERENCES `naumenko2`.`users` (`id_user`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;
