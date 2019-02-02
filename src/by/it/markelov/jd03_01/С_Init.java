package by.it.markelov.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class С_Init {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:2016/", "root", "")) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DROP SCHEMA IF EXISTS `markelov`;");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `markelov` DEFAULT CHARACTER SET utf8 ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `markelov`.`roles`;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `markelov`.`roles` (" +
                    "  `ID` INT NOT NULL AUTO_INCREMENT," +
                    "  `Role` VARCHAR(45) NULL," +
                    "  PRIMARY KEY (`ID`))" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("DROP TABLE IF EXISTS `markelov`.`users`;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `markelov`.`users` (" +
                    "  `ID` INT NOT NULL AUTO_INCREMENT," +
                    "  `Login` VARCHAR(45) NULL," +
                    "  `Password` VARCHAR(45) NULL," +
                    "  `E-Mail` VARCHAR(45) NULL," +
                    "  `roles_ID` INT NOT NULL," +
                    "  PRIMARY KEY (`ID`)," +
                    "  INDEX `fk_users_roles_idx` (`roles_ID` ASC)," +
                    "  CONSTRAINT `fk_users_roles`" +
                    "    FOREIGN KEY (`roles_ID`)" +
                    "    REFERENCES `markelov`.`roles` (`ID`)" +
                    "    ON DELETE RESTRICT" +
                    "    ON UPDATE RESTRICT)" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("DROP TABLE IF EXISTS `markelov`.`orders`;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `markelov`.`orders` (" +
                    "  `ID` INT NOT NULL AUTO_INCREMENT," +
                    "  `Shoe_name` VARCHAR(45) NULL," +
                    "  `Shoe_size` INT NULL," +
                    "  `Shoe_colour` VARCHAR(45) NULL," +
                    "  `Price` DOUBLE NULL," +
                    "  `users_ID` INT NOT NULL," +
                    "  PRIMARY KEY (`ID`)," +
                    "  INDEX `fk_orders_users1_idx` (`users_ID` ASC)," +
                    "  CONSTRAINT `fk_orders_users1`" +
                    "    FOREIGN KEY (`users_ID`)" +
                    "    REFERENCES `markelov`.`users` (`ID`)" +
                    "    ON DELETE CASCADE" +
                    "    ON UPDATE CASCADE)" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("DROP TABLE IF EXISTS `markelov`.`shoe_names`;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `markelov`.`shoe_names` (" +
                    "  `ID` INT NOT NULL AUTO_INCREMENT," +
                    "  `Shoe_name` VARCHAR(45) NULL," +
                    "  `orders_ID` INT NOT NULL," +
                    "  PRIMARY KEY (`ID`)," +
                    "  INDEX `fk_shoe_names_orders1_idx` (`orders_ID` ASC)," +
                    "  CONSTRAINT `fk_shoe_names_orders1`" +
                    "    FOREIGN KEY (`orders_ID`)" +
                    "    REFERENCES `markelov`.`orders` (`ID`)" +
                    "    ON DELETE RESTRICT" +
                    "    ON UPDATE RESTRICT)" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("DROP TABLE IF EXISTS `markelov`.`shoe_sizes`;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `markelov`.`shoe_sizes` (" +
                    "  `ID` INT NOT NULL AUTO_INCREMENT," +
                    "  `Shoe_size` DOUBLE NULL," +
                    "  `orders_ID` INT NOT NULL," +
                    "  PRIMARY KEY (`ID`)," +
                    "  INDEX `fk_shoe_sizes_orders1_idx` (`orders_ID` ASC)," +
                    "  CONSTRAINT `fk_shoe_sizes_orders1`" +
                    "    FOREIGN KEY (`orders_ID`)" +
                    "    REFERENCES `markelov`.`orders` (`ID`)" +
                    "    ON DELETE RESTRICT" +
                    "    ON UPDATE RESTRICT)" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("DROP TABLE IF EXISTS `markelov`.`shoe_colours`;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `markelov`.`shoe_colours` (" +
                    "  `ID` INT NOT NULL AUTO_INCREMENT," +
                    "  `Shoe_colour` VARCHAR(45) NULL," +
                    "  `orders_ID` INT NOT NULL," +
                    "  PRIMARY KEY (`ID`)," +
                    "  INDEX `fk_shoe_colours_orders1_idx` (`orders_ID` ASC)," +
                    "  CONSTRAINT `fk_shoe_colours_orders1`" +
                    "    FOREIGN KEY (`orders_ID`)" +
                    "    REFERENCES `markelov`.`orders` (`ID`)" +
                    "    ON DELETE RESTRICT" +
                    "    ON UPDATE RESTRICT)" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("INSERT INTO `markelov`.`roles` (`ID`, `Role`) VALUES (DEFAULT, 'Administrator');");
            statement.executeUpdate("INSERT INTO `markelov`.`roles` (`ID`, `Role`) VALUES (DEFAULT, 'User');");
            statement.executeUpdate("INSERT INTO `markelov`.`users` (`ID`, `Login`, `Password`, `E-Mail`, `roles_ID`) VALUES (DEFAULT, 'Admin', 'PAdmin', 'Admin@gmail.com', 1);");
            statement.executeUpdate("INSERT INTO `markelov`.`users` (`ID`, `Login`, `Password`, `E-Mail`, `roles_ID`) VALUES (DEFAULT, 'User', 'PUser', 'User@gmail.com', 2);");
            statement.executeUpdate("INSERT INTO `markelov`.`orders` (`ID`, `Shoe_name`, `Shoe_size`, `Shoe_colour`, `Price`, `users_ID`) VALUES (DEFAULT, 'Sneakers', 42, 'Green', 62.50, 2);");
            statement.executeUpdate("INSERT INTO `markelov`.`orders` (`ID`, `Shoe_name`, `Shoe_size`, `Shoe_colour`, `Price`, `users_ID`) VALUES (DEFAULT, 'Boots', 36, 'Black', 70.35, 2);");
            statement.executeUpdate("INSERT INTO `markelov`.`orders` (`ID`, `Shoe_name`, `Shoe_size`, `Shoe_colour`, `Price`, `users_ID`) VALUES (DEFAULT, 'Sandals', 40, 'White', 40.00, 2);");
            statement.executeUpdate("INSERT INTO `markelov`.`shoe_names` (`ID`, `Shoe_name`, `orders_ID`) VALUES (DEFAULT, 'Sneakers', 1);");
            statement.executeUpdate("INSERT INTO `markelov`.`shoe_names` (`ID`, `Shoe_name`, `orders_ID`) VALUES (DEFAULT, 'Boots', 2);");
            statement.executeUpdate("INSERT INTO `markelov`.`shoe_names` (`ID`, `Shoe_name`, `orders_ID`) VALUES (DEFAULT, 'Sandals', 3);");
            statement.executeUpdate("INSERT INTO `markelov`.`shoe_sizes` (`ID`, `Shoe_size`, `orders_ID`) VALUES (DEFAULT, 42, 1);");
            statement.executeUpdate("INSERT INTO `markelov`.`shoe_sizes` (`ID`, `Shoe_size`, `orders_ID`) VALUES (DEFAULT, 36, 2);");
            statement.executeUpdate("INSERT INTO `markelov`.`shoe_sizes` (`ID`, `Shoe_size`, `orders_ID`) VALUES (DEFAULT, 40, 3);");
            statement.executeUpdate("INSERT INTO `markelov`.`shoe_colours` (`ID`, `Shoe_colour`, `orders_ID`) VALUES (DEFAULT, 'Green', 1);");
            statement.executeUpdate("INSERT INTO `markelov`.`shoe_colours` (`ID`, `Shoe_colour`, `orders_ID`) VALUES (DEFAULT, 'Black', 2);");
            statement.executeUpdate("INSERT INTO `markelov`.`shoe_colours` (`ID`, `Shoe_colour`, `orders_ID`) VALUES (DEFAULT, 'White', 3);");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
