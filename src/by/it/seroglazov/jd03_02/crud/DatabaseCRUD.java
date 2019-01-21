package by.it.seroglazov.jd03_02.crud;

import by.it.seroglazov.jd03_02.Config;
import by.it.seroglazov.jd03_02.MyConstants;
import by.it.seroglazov.jd03_02.MyDatabaseConnector;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseCRUD {
    private static Config config;

    static {
        try {
            config = new Config();
            config.loadFromXml(MyConstants.configFileFullName);
        } catch (IOException e) {
            System.err.println("Can't read config file " + MyConstants.configFileFullName
                    + " with message: " + e.getMessage());
        }
    }

    public static boolean deleteDatabase() {
        try (Connection connection = MyDatabaseConnector.getConnectionWithoutDBName();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("DROP SCHEMA IF EXISTS `" + config.getDataBaseName() + "` ;");
        } catch (SQLException e) {
            System.err.println("Can't delete database with message: " + e.getMessage());
            return false;
        }
        return true;
    }

    public static boolean createDatabase() {
        try (Connection connection = MyDatabaseConnector.getConnectionWithoutDBName();
             Statement statement = connection.createStatement()) {

            statement.executeUpdate("DROP SCHEMA IF EXISTS `" + config.getDataBaseName() + "` ;");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `" + config.getDataBaseName() +
                    "` DEFAULT CHARACTER SET utf8 ;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `" + config.getDataBaseName() + "`.`ingredients` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `name` VARCHAR(100) NOT NULL,\n" +
                    "  PRIMARY KEY (`id`))\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `" + config.getDataBaseName() + "`.`itags` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `text` VARCHAR(100) NOT NULL,\n" +
                    "  PRIMARY KEY (`id`))\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `" + config.getDataBaseName() +
                    "`.`ingredients_itags` (\n" +
                    "  `ingredients_id` INT NOT NULL,\n" +
                    "  `itags_id` INT NOT NULL,\n" +
                    "  INDEX `fk_ingredients_itags_ingredients_idx` (`ingredients_id` ASC),\n" +
                    "  INDEX `fk_ingredients_itags_itags1_idx` (`itags_id` ASC),\n" +
                    "  CONSTRAINT `fk_ingredients_itags_ingredients`\n" +
                    "    FOREIGN KEY (`ingredients_id`)\n" +
                    "    REFERENCES `" + config.getDataBaseName() + "`.`ingredients` (`id`)\n" +
                    "    ON DELETE NO ACTION\n" +
                    "    ON UPDATE NO ACTION,\n" +
                    "  CONSTRAINT `fk_ingredients_itags_itags1`\n" +
                    "    FOREIGN KEY (`itags_id`)\n" +
                    "    REFERENCES `" + config.getDataBaseName() + "`.`itags` (`id`)\n" +
                    "    ON DELETE NO ACTION\n" +
                    "    ON UPDATE NO ACTION)\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `" + config.getDataBaseName() + "`.`roles` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `name` VARCHAR(45) NULL,\n" +
                    "  PRIMARY KEY (`id`))\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `" + config.getDataBaseName() + "`.`users` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `nickname` VARCHAR(100) NOT NULL,\n" +
                    "  `email` VARCHAR(100) NOT NULL,\n" +
                    "  `roles_id` INT NOT NULL DEFAULT 2,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_users_roles1_idx` (`roles_id` ASC),\n" +
                    "  CONSTRAINT `fk_users_roles1`\n" +
                    "    FOREIGN KEY (`roles_id`)\n" +
                    "    REFERENCES `" + config.getDataBaseName() + "`.`roles` (`id`)\n" +
                    "    ON DELETE NO ACTION\n" +
                    "    ON UPDATE NO ACTION)\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `" + config.getDataBaseName() + "`.`users_ingredients` (\n" +
                    "  `users_id` INT NOT NULL,\n" +
                    "  `ingredients_id` INT NOT NULL,\n" +
                    "  INDEX `fk_users_ingredients_users1_idx` (`users_id` ASC),\n" +
                    "  INDEX `fk_users_ingredients_ingredients1_idx` (`ingredients_id` ASC),\n" +
                    "  CONSTRAINT `fk_users_ingredients_users1`\n" +
                    "    FOREIGN KEY (`users_id`)\n" +
                    "    REFERENCES `" + config.getDataBaseName() + "`.`users` (`id`)\n" +
                    "    ON DELETE NO ACTION\n" +
                    "    ON UPDATE NO ACTION,\n" +
                    "  CONSTRAINT `fk_users_ingredients_ingredients1`\n" +
                    "    FOREIGN KEY (`ingredients_id`)\n" +
                    "    REFERENCES `" + config.getDataBaseName() + "`.`ingredients` (`id`)\n" +
                    "    ON DELETE NO ACTION\n" +
                    "    ON UPDATE NO ACTION)\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `" + config.getDataBaseName() + "`.`rtype` (\n" +
                            "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                            "  `text` VARCHAR(100) NOT NULL,\n" +
                            "  PRIMARY KEY (`id`))\n" +
                            "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `" + config.getDataBaseName() + "`.`recipes` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `name` VARCHAR(100) NOT NULL,\n" +
                    "  `description` VARCHAR(1000) NULL,\n" +
                    "  `rtype_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_recipes_rtype1_idx` (`rtype_id` ASC),\n" +
                    "  CONSTRAINT `fk_recipes_rtype1`\n" +
                    "    FOREIGN KEY (`rtype_id`)\n" +
                    "    REFERENCES `seroglazov`.`rtype` (`id`)\n" +
                    "    ON DELETE NO ACTION\n" +
                    "    ON UPDATE NO ACTION)\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `" + config.getDataBaseName() + "`.`units` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `name` VARCHAR(45) NULL,\n" +
                    "  PRIMARY KEY (`id`))\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `" + config.getDataBaseName() + "`.`amounts` (\n" +
                    "  `recipes_id` INT NOT NULL,\n" +
                    "  `ingredients_id` INT NOT NULL,\n" +
                    "  `amount` VARCHAR(10) NOT NULL,\n" +
                    "  `units_id` INT NOT NULL,\n" +
                    "  INDEX `fk_recipes_ingredients_recipes1_idx` (`recipes_id` ASC),\n" +
                    "  INDEX `fk_recipes_ingredients_ingredients1_idx` (`ingredients_id` ASC),\n" +
                    "  INDEX `fk_recipes_ingredients_units1_idx` (`units_id` ASC),\n" +
                    "  CONSTRAINT `fk_recipes_ingredients_recipes1`\n" +
                    "    FOREIGN KEY (`recipes_id`)\n" +
                    "    REFERENCES `" + config.getDataBaseName() + "`.`recipes` (`id`)\n" +
                    "    ON DELETE NO ACTION\n" +
                    "    ON UPDATE NO ACTION,\n" +
                    "  CONSTRAINT `fk_recipes_ingredients_ingredients1`\n" +
                    "    FOREIGN KEY (`ingredients_id`)\n" +
                    "    REFERENCES `" + config.getDataBaseName() + "`.`ingredients` (`id`)\n" +
                    "    ON DELETE NO ACTION\n" +
                    "    ON UPDATE NO ACTION,\n" +
                    "  CONSTRAINT `fk_recipes_ingredients_units1`\n" +
                    "    FOREIGN KEY (`units_id`)\n" +
                    "    REFERENCES `" + config.getDataBaseName() + "`.`units` (`id`)\n" +
                    "    ON DELETE NO ACTION\n" +
                    "    ON UPDATE NO ACTION)\n" +
                    "ENGINE = InnoDB;");
        } catch (SQLException e) {
            System.err.println("Can't create database with message: " + e.getMessage());
            return false;
        }
        return true;
    }
}

