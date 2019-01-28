package by.it.seroglazov.project.java.dao;

import by.it.seroglazov.project.java.MyConstants;
import by.it.seroglazov.project.java.beans.*;
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

    @SuppressWarnings("WeakerAccess")
    boolean fillDatabaseFromXml() {
        if (!Validate()) return false;
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
        try {
            for (int i = 0; i < nodes.getLength(); i++) {
                Node recipeNode = nodes.item(i);
                if (recipeNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element recipeEl = (Element) recipeNode;
                    String name = recipeEl.getElementsByTagName("name").item(0).getTextContent();
                    String rtypeStr = recipeEl.getElementsByTagName("type").item(0).getTextContent();
                    long typeId = insureRtypeExistsAndGetId(rtypeStr);
                    String description = recipeEl.getElementsByTagName("description").item(0).getTextContent();
                    Recipe recipe = new Recipe(name, typeId, description);
                    recDao.create(recipe);
                    long recipeId = recipe.getId();
                    NodeList ings = recipeEl.getElementsByTagName("ingredient");
                    for (int j = 0; j < ings.getLength(); j++) {
                        Node ingNode = ings.item(j);
                        if (ingNode.getNodeType() == Node.ELEMENT_NODE) {
                            Element ing = (Element) ingNode;
                            String ingName = ing.getElementsByTagName("name").item(0).getTextContent();
                            long ingId = insureIngredientExistsAndGetId(ingName);
                            String unitStr = ing.getElementsByTagName("unit").item(0).getTextContent();
                            long unitId = insureUnitExistsAndGetId(unitStr);
                            String amountText = ing.getElementsByTagName("amount").item(0).getTextContent();
                            amDao.create(new Amount(recipeId, ingId, amountText, unitId));
                        }
                    }

                }
            }
        } catch (Exception e) {
            System.err.println("Error while parsing xml file: " + MyConstants.xmlRecipesFileName);
        }
        return true;
    }

    private boolean Validate() {
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        try {
            Source xmlFile = new StreamSource(new File(MyConstants.xmlRecipesFileName));
            Schema schema = schemaFactory.newSchema(new File(MyConstants.xsdSchemaFileName));
            Validator validator = schema.newValidator();
            validator.validate(xmlFile);
        } catch (Exception e) {
            System.err.println("Can't validate file: " + MyConstants.xmlRecipesFileName + " reason: " + e.getMessage());
            return false;
        }
        return true;
    }

    private Dao<Rtype> rtDao = new MyDao<>(new Rtype());
    private Dao<Ingredient> ingDao = new MyDao<>(new Ingredient());
    private Dao<Unit> unitDao = new MyDao<>(new Unit());
    private Dao<Amount> amDao = new MyDao<>(new Amount());
    private Dao<Recipe> recDao = new MyDao<>(new Recipe());

    private long insureRtypeExistsAndGetId(String text) throws Exception {
        Rtype rtype = rtDao.findFirstByFieldValue("text", text);
        if (rtype == null) {
            rtype = new Rtype(text);
            rtDao.create(rtype);
        }
        return rtype.getId();
    }

    private long insureIngredientExistsAndGetId(String name) throws Exception {
        Ingredient ing = ingDao.findFirstByFieldValue("name", name);
        if (ing == null) {
            ing = new Ingredient(name);
            ingDao.create(ing);
        }
        return ing.getId();
    }

    private long insureUnitExistsAndGetId(String name) throws Exception {
        Unit unit = unitDao.findFirstByFieldValue("name", name);
        if (unit == null) {
            unit = new Unit(name);
            unitDao.create(unit);
        }
        return unit.getId();
    }

    @SuppressWarnings("WeakerAccess")
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

    @SuppressWarnings("WeakerAccess")
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

    @SuppressWarnings("unused")
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

    @SuppressWarnings("WeakerAccess")
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
                    "    ON DELETE CASCADE\n" +
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
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE NO ACTION,\n" +
                    "  CONSTRAINT `fk_recipes_ingredients_ingredients1`\n" +
                    "    FOREIGN KEY (`ingredient_id`)\n" +
                    "    REFERENCES `ingredients` (`id`)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE NO ACTION,\n" +
                    "  CONSTRAINT `fk_recipes_ingredients_units1`\n" +
                    "    FOREIGN KEY (`unit_id`)\n" +
                    "    REFERENCES `units` (`id`)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE NO ACTION)\n" +
                    "ENGINE = InnoDB;");
            return true;
        } catch (SQLException e) {
            System.err.println("Can't create tables with message: " + e.getMessage());
            return false;
        }
    }

    void resetDatabase() {

        System.out.print("Delete database if exists... ");
        if (!deleteDatabase()) {
            System.out.println("fail.");
            return;
        }
        System.out.println("done.");

        System.out.print("Create database... ");
        if (!createDatabase()) {
            System.out.println("fail.");
            return;
        }
        System.out.println("done.");

        System.out.print("Create tables... ");
        if (!createAllTables()) {
            System.out.println("fail.");
            return;
        }
        System.out.println("done.");

        System.out.print("Fill tables from XML file... ");
        if (!fillDatabaseFromXml()) {
            System.out.println("fail.");
            return;
        }
        System.out.println("done.");
    }
}
