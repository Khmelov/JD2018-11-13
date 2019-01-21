package by.it.seroglazov.jd03_02;

import by.it.seroglazov.jd03_01.Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class C_Init {

    private static Statement statement;
    private static Config config;

    static void createDatabase(Config config) {
        C_Init.config = config;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("ClassNotFoundException: " + e.getMessage());
        }

        try (Connection connection = DriverManager.getConnection(
                config.getDataBaseURL(), config.getUserName(), config.getPassword())) {
            statement = connection.createStatement();

            createDatabseAndTables();

            addIngTag("alcoholic beverage"); // 1
            addIngTag("non-alcoholic beverage"); // 2
            addIngTag("liqueur"); // 3
            addIngTag("whisky"); // 4
            addIngTag("bitter"); // 5
            addIngTag("citrus"); // 6

            addIngredient("gin"); // 1
            addIngredient("white rum"); // 2
            addIngredient("vodka"); // 3
            addIngredient("triple sec"); // 4
            addIngredient("fresh lemon juice"); // 5
            addIngredient("bourbon whiskey"); // 6
            addIngredient("plain water"); // 7
            addIngredient("angostura aromatic bitters"); // 8
            addIngredient("sugar"); // 9

            connectIngTag(1, 1);
            connectIngTag(2, 1);
            connectIngTag(3, 1);
            connectIngTag(4, 1);
            connectIngTag(4, 3);
            connectIngTag(5, 6);
            connectIngTag(6, 4);
            connectIngTag(7, 2);
            connectIngTag(8, 1);
            connectIngTag(8, 5);

            addRole("admin");
            addRole("user");

            addUser("Renat", "renat.seroglazov@gmail.com", 1);
            addUser("Vadim", "vadim.chernetski1991@gmail.com", 2);
            addUser("SER", "ser@mail.ru", 2);

            connectUserIng(1, 1);
            connectUserIng(1, 2);
            connectUserIng(1, 3);
            connectUserIng(1, 4);
            connectUserIng(1, 5);
            connectUserIng(1, 6);
            connectUserIng(1, 7);
            connectUserIng(1, 8);
            connectUserIng(1, 9);
            connectUserIng(2, 1);
            connectUserIng(2, 4);
            connectUserIng(2, 5);
            connectUserIng(3, 7);

            addRecipe("white lady", "Add all ingredients into cocktail shaker filled with ice.Shake well and strain" +
                    " into large cocktail glass.");
            addRecipe("old fashioned", "Place sugar cube in old-fashioned glass and saturate with bitters, add a dash " +
                    "of plain water. Muddle until dissolve. Fill the glass with ice cubes and add whiskey. Garnish " +
                    "with orange slice and a cocktail cherry.");

            addUnit("cl"); // 1 centiliter = 10 ml
            addUnit("ml"); // 2
            addUnit("slice"); // 3
            addUnit("dash"); // 4
            addUnit("cube"); // 5
            addUnit("splash"); // 6
            addUnit("unit"); // 7 (штука)

            // recipe_id, ing_id, amount, unit_id
            // white lady
            addAmount(1, 1, 4, 1); // 4 cl Gin
            addAmount(1, 4, 3, 1); // 3 cl Triple Sec
            addAmount(1, 5, 2, 1); // 2 cl Fresh lemon juice

            // old fashioned
            addAmount(2, 6, "4.5", 1); // 4.5 cl Bourbon whiskey
            addAmount(2, 8, 2, 4); // 2 Dashes Angostura Bitters
            addAmount(2, 9, 1, 5); // 1 sugar cube
            addAmount(2, 7, "few", 4); // Few dashes plain water

        } catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
        }
    }

    private static void addIngredient(String name) throws SQLException {
        statement.executeUpdate(
                "INSERT INTO `"+config.getDataBaseName()+"`.`ingredients` (`id`, `name`) VALUES (DEFAULT, '" + name + "');");
    }

    private static void addIngTag(String tag) throws SQLException {
        statement.executeUpdate(
                "INSERT INTO `"+config.getDataBaseName()+"`.`itags` (`id`, `text`) VALUES (DEFAULT, '" + tag + "');");
    }

    private static void connectIngTag(int ing_id, int tag_id) throws SQLException {
        statement.executeUpdate(
                "INSERT INTO `"+config.getDataBaseName()+"`.`ingredients_itags` (`ingredients_id`, `itags_id`) VALUES ("
                        + ing_id + ", " + tag_id + ");");
    }

    private static void addRole(String role) throws SQLException {
        statement.executeUpdate(
                "INSERT INTO `"+config.getDataBaseName()+"`.`roles` (`id`, `name`) VALUES (DEFAULT, '" + role + "');");
    }

    private static void addUser(String name, String email, int role) throws SQLException {
        statement.executeUpdate(
                "INSERT INTO `"+config.getDataBaseName()+"`.`users` (`id`, `nickname`, `email`, `roles_id`) VALUES (DEFAULT, '"
                        + name + "', '" + email + "', " + role + ");");
    }

    private static void connectUserIng(int user_id, int ing_id) throws SQLException {
        statement.executeUpdate(
                "INSERT INTO `"+config.getDataBaseName()+"`.`users_ingredients` (`users_id`, `ingredients_id`) VALUES ("
                        + user_id + ", " + ing_id + ");");
    }

    private static void addRecipe(String name, String description) throws SQLException {
        statement.executeUpdate(
                "INSERT INTO `"+config.getDataBaseName()+"`.`recipes` (`id`, `name`, `description`) VALUES (DEFAULT, '"
                        + name + "', '" + description + "');");
    }

    private static void addUnit(String name) throws SQLException {
        statement.executeUpdate(
                "INSERT INTO `"+config.getDataBaseName()+"`.`units` (`id`, `name`) VALUES (DEFAULT, '" + name + "');");
    }

    @SuppressWarnings("SameParameterValue")
    private static void addAmount(int recipe_id, int ing_id, String amount, int unit_id) throws SQLException {
        statement.executeUpdate(
                "INSERT INTO `"+config.getDataBaseName()+"`.`amounts` (`recipes_id`, `ingredients_id`, `amount`, `units_id`) VALUES (" +
                        recipe_id + ", " + ing_id + ", '" + amount + "', " + unit_id + ");\n");
    }

    // Overload method
    private static void addAmount(int recipe_id, int ing_id, int amount, int unit_id) throws SQLException {
        statement.executeUpdate(
                "INSERT INTO `"+config.getDataBaseName()+"`.`amounts` (`recipes_id`, `ingredients_id`, `amount`, `units_id`) VALUES (" +
                        recipe_id + ", " + ing_id + ", '" + amount + "', " + unit_id + ");\n");
    }

    private static void createDatabseAndTables() throws SQLException {
        statement.executeUpdate("DROP SCHEMA IF EXISTS `"+config.getDataBaseName()+"` ;");
        statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `"+config.getDataBaseName()+"` DEFAULT CHARACTER SET utf8 ;");
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS `"+config.getDataBaseName()+"`.`ingredients` (\n" +
                "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                "  `name` VARCHAR(100) NOT NULL,\n" +
                "  PRIMARY KEY (`id`))\n" +
                "ENGINE = InnoDB;");
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS `"+config.getDataBaseName()+"`.`itags` (\n" +
                "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                "  `text` VARCHAR(100) NOT NULL,\n" +
                "  PRIMARY KEY (`id`))\n" +
                "ENGINE = InnoDB;");
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS `"+config.getDataBaseName()+"`.`ingredients_itags` (\n" +
                "  `ingredients_id` INT NOT NULL,\n" +
                "  `itags_id` INT NOT NULL,\n" +
                "  INDEX `fk_ingredients_itags_ingredients_idx` (`ingredients_id` ASC),\n" +
                "  INDEX `fk_ingredients_itags_itags1_idx` (`itags_id` ASC),\n" +
                "  CONSTRAINT `fk_ingredients_itags_ingredients`\n" +
                "    FOREIGN KEY (`ingredients_id`)\n" +
                "    REFERENCES `"+config.getDataBaseName()+"`.`ingredients` (`id`)\n" +
                "    ON DELETE NO ACTION\n" +
                "    ON UPDATE NO ACTION,\n" +
                "  CONSTRAINT `fk_ingredients_itags_itags1`\n" +
                "    FOREIGN KEY (`itags_id`)\n" +
                "    REFERENCES `"+config.getDataBaseName()+"`.`itags` (`id`)\n" +
                "    ON DELETE NO ACTION\n" +
                "    ON UPDATE NO ACTION)\n" +
                "ENGINE = InnoDB;");
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS `"+config.getDataBaseName()+"`.`roles` (\n" +
                "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                "  `name` VARCHAR(45) NULL,\n" +
                "  PRIMARY KEY (`id`))\n" +
                "ENGINE = InnoDB;");
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS `"+config.getDataBaseName()+"`.`users` (\n" +
                "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                "  `nickname` VARCHAR(100) NOT NULL,\n" +
                "  `password` VARCHAR(100) NOT NULL,\n" +
                "  `email` VARCHAR(100) NOT NULL,\n" +
                "  `roles_id` INT NOT NULL DEFAULT 2,\n" +
                "  PRIMARY KEY (`id`),\n" +
                "  INDEX `fk_users_roles1_idx` (`roles_id` ASC),\n" +
                "  CONSTRAINT `fk_users_roles1`\n" +
                "    FOREIGN KEY (`roles_id`)\n" +
                "    REFERENCES `"+config.getDataBaseName()+"`.`roles` (`id`)\n" +
                "    ON DELETE NO ACTION\n" +
                "    ON UPDATE NO ACTION)\n" +
                "ENGINE = InnoDB;");
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS `"+config.getDataBaseName()+"`.`users_ingredients` (\n" +
                "  `users_id` INT NOT NULL,\n" +
                "  `ingredients_id` INT NOT NULL,\n" +
                "  INDEX `fk_users_ingredients_users1_idx` (`users_id` ASC),\n" +
                "  INDEX `fk_users_ingredients_ingredients1_idx` (`ingredients_id` ASC),\n" +
                "  CONSTRAINT `fk_users_ingredients_users1`\n" +
                "    FOREIGN KEY (`users_id`)\n" +
                "    REFERENCES `"+config.getDataBaseName()+"`.`users` (`id`)\n" +
                "    ON DELETE NO ACTION\n" +
                "    ON UPDATE NO ACTION,\n" +
                "  CONSTRAINT `fk_users_ingredients_ingredients1`\n" +
                "    FOREIGN KEY (`ingredients_id`)\n" +
                "    REFERENCES `"+config.getDataBaseName()+"`.`ingredients` (`id`)\n" +
                "    ON DELETE NO ACTION\n" +
                "    ON UPDATE NO ACTION)\n" +
                "ENGINE = InnoDB;");
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS `"+config.getDataBaseName()+"`.`recipes` (\n" +
                "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                "  `name` VARCHAR(100) NOT NULL,\n" +
                "  `description` VARCHAR(1000) NULL,\n" +
                "  PRIMARY KEY (`id`))\n" +
                "ENGINE = InnoDB;");
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS `"+config.getDataBaseName()+"`.`units` (\n" +
                "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                "  `name` VARCHAR(45) NULL,\n" +
                "  PRIMARY KEY (`id`))\n" +
                "ENGINE = InnoDB;");
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS `"+config.getDataBaseName()+"`.`amounts` (\n" +
                "  `recipes_id` INT NOT NULL,\n" +
                "  `ingredients_id` INT NOT NULL,\n" +
                "  `amount` VARCHAR(10) NOT NULL,\n" +
                "  `units_id` INT NOT NULL,\n" +
                "  INDEX `fk_recipes_ingredients_recipes1_idx` (`recipes_id` ASC),\n" +
                "  INDEX `fk_recipes_ingredients_ingredients1_idx` (`ingredients_id` ASC),\n" +
                "  INDEX `fk_recipes_ingredients_units1_idx` (`units_id` ASC),\n" +
                "  CONSTRAINT `fk_recipes_ingredients_recipes1`\n" +
                "    FOREIGN KEY (`recipes_id`)\n" +
                "    REFERENCES `"+config.getDataBaseName()+"`.`recipes` (`id`)\n" +
                "    ON DELETE NO ACTION\n" +
                "    ON UPDATE NO ACTION,\n" +
                "  CONSTRAINT `fk_recipes_ingredients_ingredients1`\n" +
                "    FOREIGN KEY (`ingredients_id`)\n" +
                "    REFERENCES `"+config.getDataBaseName()+"`.`ingredients` (`id`)\n" +
                "    ON DELETE NO ACTION\n" +
                "    ON UPDATE NO ACTION,\n" +
                "  CONSTRAINT `fk_recipes_ingredients_units1`\n" +
                "    FOREIGN KEY (`units_id`)\n" +
                "    REFERENCES `"+config.getDataBaseName()+"`.`units` (`id`)\n" +
                "    ON DELETE NO ACTION\n" +
                "    ON UPDATE NO ACTION)\n" +
                "ENGINE = InnoDB;");
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS `"+config.getDataBaseName()+"`.`rtags` (\n" +
                "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                "  `text` VARCHAR(100) NOT NULL,\n" +
                "  PRIMARY KEY (`id`))\n" +
                "ENGINE = InnoDB;");
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS `"+config.getDataBaseName()+"`.`recipes_rtags` (\n" +
                "  `recipes_id` INT NOT NULL,\n" +
                "  `rtags_id` INT NOT NULL,\n" +
                "  INDEX `fk_recipes_rtags_rtags1_idx` (`rtags_id` ASC),\n" +
                "  INDEX `fk_recipes_rtags_recipes1_idx` (`recipes_id` ASC),\n" +
                "  CONSTRAINT `fk_recipes_rtags_rtags1`\n" +
                "    FOREIGN KEY (`rtags_id`)\n" +
                "    REFERENCES `"+config.getDataBaseName()+"`.`rtags` (`id`)\n" +
                "    ON DELETE NO ACTION\n" +
                "    ON UPDATE NO ACTION,\n" +
                "  CONSTRAINT `fk_recipes_rtags_recipes1`\n" +
                "    FOREIGN KEY (`recipes_id`)\n" +
                "    REFERENCES `"+config.getDataBaseName()+"`.`recipes` (`id`)\n" +
                "    ON DELETE NO ACTION\n" +
                "    ON UPDATE NO ACTION)\n" +
                "ENGINE = InnoDB;");
    }
}
