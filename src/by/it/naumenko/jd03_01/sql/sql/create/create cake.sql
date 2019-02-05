CREATE TABLE IF NOT EXISTS `naumenko2`.`cake` (
    `id_tovar` INT NOT NULL AUTO_INCREMENT,
  `kategoriya` VARCHAR(100) NULL,
  `price` DECIMAL NULL,
  `biscuit` INT NULL,
  `nachinka` VARCHAR(100) NULL,
  `decoration` VARCHAR(100) NULL,
  `cream` VARCHAR(45) NULL,
  PRIMARY KEY (`id_tovar`))
ENGINE = InnoDB;