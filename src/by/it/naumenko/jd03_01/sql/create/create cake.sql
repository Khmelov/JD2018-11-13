CREATE TABLE IF NOT EXISTS `naumenko`.`cake` (
  `id_cake` INT NOT NULL AUTO_INCREMENT,
  `name_cake` VARCHAR(100) NULL,
  `size_cake` INT NULL,
  `weight_cake` INT NULL,
  `bescuit` VARCHAR(100) NULL,
  `decoration` VARCHAR(100) NULL,
  `cream` VARCHAR(45) NULL,
  `price_cake` DECIMAL NULL,
  PRIMARY KEY (`id_cake`))
ENGINE = InnoDB;