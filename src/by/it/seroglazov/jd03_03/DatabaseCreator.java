package by.it.seroglazov.jd03_03;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

class DatabaseCreator {

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

    private static class InstanceHolder {
        static final DatabaseCreator instance = new DatabaseCreator();
    }

    private DatabaseCreator() {
    }

    static DatabaseCreator getCreator() {
        return InstanceHolder.instance;
    }

    boolean fillDatabaseFromXml() {

        // Validation
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_INSTANCE_NS_URI);
        try {
            Source xmlFile = new StreamSource(new File(MyConstants.xmlRecipesFileName));
            Schema schema = schemaFactory.newSchema(new File(MyConstants.xsdSchemaFileName));
            Validator validator = schema.newValidator();
            validator.validate(xmlFile);
        } catch (Exception e) {
            System.err.println("Can't validate file: " + MyConstants.xmlRecipesFileName + " reason: " + e.getMessage());
            return false;
        }

        // If validated
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder;
        Document document;
        try {
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
            document = documentBuilder.parse(new File(MyConstants.xmlRecipesFileName));
        } catch (Exception e) {
            System.err.println("Can't parse XML file: " + MyConstants.xmlRecipesFileName);
            return false;
        }
        Element root = document.getDocumentElement();
        NodeList nodes = root.getElementsByTagName("recipe");
        for (int i = 0; i < nodes.getLength(); i++) {
            Node recipeNode = nodes.item(i);
            if (recipeNode.getNodeType() == Node.ELEMENT_NODE) {
                Element recipe = (Element) recipeNode;
                String name = recipe.getElementsByTagName("name").item(0).getTextContent();
                String type = recipe.getElementsByTagName("type").item(0).getTextContent();

                String description = recipe.getElementsByTagName("description").item(0).getTextContent();
                NodeList ings = recipe.getElementsByTagName("ingredient");
                for (int j = 0; j < ings.getLength(); j++) {
                    Node ingNode = ings.item(j);
                    if (ingNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element ing = (Element) ingNode;
                        String ingName = ing.getElementsByTagName("name").item(0).getTextContent();
                        String ingAmount = ing.getElementsByTagName("amount").item(0).getTextContent();
                        String ingUnit = ing.getElementsByTagName("unit").item(0).getTextContent();
                    }
                }
            }
        }
        return true;
    }

    boolean createDatabase() {
        try (Connection connection = DatabaseConnector.getConnection(false);
             Statement statement = connection.createStatement()) {

            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `" + config.getDataBaseName() +
                    "` DEFAULT CHARACTER SET utf8 ;");

        } catch (SQLException e) {
            System.err.println("Can't create database with message: " + e.getMessage());
            return false;
        }
        return true;
    }

    boolean deleteDatabase() {
        try (Connection connection = DatabaseConnector.getConnection(false);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("DROP SCHEMA IF EXISTS `" + config.getDataBaseName() + "` ;");
        } catch (SQLException e) {
            System.err.println("Can't delete database with message: " + e.getMessage());
            return false;
        }
        return true;
    }

    boolean deleteAllTable() {
        try (Connection connection = DatabaseConnector.getConnection();
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

    boolean createAllTables() {
        try (Connection connection = DatabaseConnector.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `ingredients` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `name` VARCHAR(100) NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    " UNIQUE INDEX `name_UNIQUE` (`name` ASC))\n" +
                    " ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `rtypes` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `text` VARCHAR(100) NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    " UNIQUE INDEX `text_UNIQUE` (`text` ASC))\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `recipes` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `name` VARCHAR(100) NOT NULL,\n" +
                    "  `description` VARCHAR(1000) NULL,\n" +
                    "  `rtype_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_recipes_rtypes1_idx` (`rtype_id` ASC),\n" +
                    " UNIQUE INDEX `name_UNIQUE` (`name` ASC),\n" +
                    "  CONSTRAINT `fk_recipes_rtypes1`\n" +
                    "    FOREIGN KEY (`rtype_id`)\n" +
                    "    REFERENCES `rtypes` (`id`)\n" +
                    "    ON DELETE NO ACTION\n" +
                    "    ON UPDATE NO ACTION)\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `units` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `name` VARCHAR(100) NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    " UNIQUE INDEX `name_UNIQUE` (`name` ASC))\n" +
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
}
