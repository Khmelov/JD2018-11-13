CREATE TABLE IF NOT EXISTS `naumenko`.`users` (
  `id_users` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(100) NULL,
  `password` VARCHAR(45) NULL,
  `email` VARCHAR(100) NULL,
  `roles_id_roles` INT NOT NULL,
  PRIMARY KEY (`id_users`),
  INDEX `fk_users_roles_idx` (`roles_id_roles` ASC),
  CONSTRAINT `fk_users_roles`
    FOREIGN KEY (`roles_id_roles`)
    REFERENCES `naumenko`.`roles` (`id_roles`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;