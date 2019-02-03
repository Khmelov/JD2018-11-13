CREATE TABLE IF NOT EXISTS `naumenko`.`profil` (
  `id_profil` INT NOT NULL AUTO_INCREMENT,
  `name_profil` VARCHAR(45) NULL,
  `lastName_profil` VARCHAR(45) NULL,
  `dayBirth` INT NULL,
  `mountBirth` VARCHAR(45) NULL,
  `yearBirth` INT NULL,
  `pol` VARCHAR(45) NULL,
  `city` VARCHAR(45) NULL,
  `street` VARCHAR(45) NULL,
  `home` INT NULL,
  `korpus` INT NULL,
  `kvartira` INT NULL,
  `tel` VARCHAR(45) NULL,
  `kol_zakaz` INT NULL,
  `about` VARCHAR(255) NULL,
  `id_user` INT NOT NULL,
  PRIMARY KEY (`id_profil`),
  INDEX `fk_profil_users1_idx` (`id_user` ASC),
  CONSTRAINT `fk_profil_users1`
    FOREIGN KEY (`id_user`)
    REFERENCES `naumenko`.`users` (`id_user`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;
