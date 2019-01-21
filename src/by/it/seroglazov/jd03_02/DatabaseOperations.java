package by.it.seroglazov.jd03_02;

import by.it.seroglazov.jd03_02.Config;
import by.it.seroglazov.jd03_02.MyConstants;
import by.it.seroglazov.jd03_02.MyDatabaseConnector;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseOperations {
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

    public static boolean deleteAllTable() {
        try (Connection connection = MyDatabaseConnector.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("DROP TABLE IF EXISTS amounts");
            statement.executeUpdate("DROP TABLE IF EXISTS units");
            statement.executeUpdate("DROP TABLE IF EXISTS recipes");
            statement.executeUpdate("DROP TABLE IF EXISTS rtypes");
            statement.executeUpdate("DROP TABLE IF EXISTS ingredients");
        } catch (SQLException e) {
            System.err.println("Can't delete tables with message: " + e.getMessage());
            return false;
        }
        return true;
    }

    public static boolean createAllTables() {
        try (Connection connection = MyDatabaseConnector.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `ingredients` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `name` VARCHAR(100) NOT NULL,\n" +
                    "  PRIMARY KEY (`id`))\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `rtypes` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `text` VARCHAR(100) NOT NULL,\n" +
                    "  PRIMARY KEY (`id`))\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `recipes` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `name` VARCHAR(100) NOT NULL,\n" +
                    "  `description` VARCHAR(1000) NULL,\n" +
                    "  `rtype_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_recipes_rtypes1_idx` (`rtype_id` ASC),\n" +
                    "  CONSTRAINT `fk_recipes_rtypes1`\n" +
                    "    FOREIGN KEY (`rtype_id`)\n" +
                    "    REFERENCES `rtypes` (`id`)\n" +
                    "    ON DELETE NO ACTION\n" +
                    "    ON UPDATE NO ACTION)\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `units` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `name` VARCHAR(100) NOT NULL,\n" +
                    "  PRIMARY KEY (`id`))\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `amounts` (\n" +
                    "  `recipe_id` INT NOT NULL,\n" +
                    "  `ingredient_id` INT NOT NULL,\n" +
                    "  `text` VARCHAR(45) NOT NULL,\n" +
                    "  `unit_id` INT NOT NULL,\n" +
                    "  INDEX `fk_recipes_ingredients_recipes1_idx` (`recipe_id` ASC),\n" +
                    "  INDEX `fk_recipes_ingredients_ingredients1_idx` (`ingredient_id` ASC),\n" +
                    "  INDEX `fk_recipes_ingredients_units1_idx` (`unit_id` ASC),\n" +
                    "  CONSTRAINT `fk_recipes_ingredients_recipes1`\n" +
                    "    FOREIGN KEY (`recipe_id`)\n" +
                    "    REFERENCES `recipes` (`id`)\n" +
                    "    ON DELETE NO ACTION\n" +
                    "    ON UPDATE NO ACTION,\n" +
                    "  CONSTRAINT `fk_recipes_ingredients_ingredients1`\n" +
                    "    FOREIGN KEY (`ingredient_id`)\n" +
                    "    REFERENCES `ingredients` (`id`)\n" +
                    "    ON DELETE NO ACTION\n" +
                    "    ON UPDATE NO ACTION,\n" +
                    "  CONSTRAINT `fk_recipes_ingredients_units1`\n" +
                    "    FOREIGN KEY (`unit_id`)\n" +
                    "    REFERENCES `units` (`id`)\n" +
                    "    ON DELETE NO ACTION\n" +
                    "    ON UPDATE NO ACTION)\n" +
                    "ENGINE = InnoDB;");
            return true;
        } catch (SQLException e) {
            System.err.println("Can't create tables with message: " + e.getMessage());
            return false;
        }
    }

    public static boolean createDatabase() {
        try (Connection connection = MyDatabaseConnector.getConnectionWithoutDBName();
             Statement statement = connection.createStatement()) {

            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `" + config.getDataBaseName() +
                    "` DEFAULT CHARACTER SET utf8 ;");

        } catch (SQLException e) {
            System.err.println("Can't create database with message: " + e.getMessage());
            return false;
        }
        return true;
    }
}

