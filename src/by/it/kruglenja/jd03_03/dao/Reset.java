package by.it.kruglenja.jd03_03.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Reset {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:2016/", "root", "")) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DROP SCHEMA IF EXISTS `kruglenja` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `kruglenja`.`users` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `kruglenja`.`roles` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `kruglenja`.`order` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `kruglenja`.`spareParts` ;");
            System.out.println("DB deleted");
            statement.executeUpdate("DROP SCHEMA IF EXISTS `kruglenja` ;");

            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `kruglenja` DEFAULT CHARACTER SET utf8 ;");

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `kruglenja`.`roles` (" +
                    "  `id` BIGINT NOT NULL AUTO_INCREMENT," +
                    "  `role` VARCHAR(100) NULL," +
                    "  PRIMARY KEY (`id`))" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `kruglenja`.`users` (" +
                    "  `id` BIGINT NOT NULL AUTO_INCREMENT," +
                    "  `login` VARCHAR(45) NULL DEFAULT NULL," +
                    "  `password` VARCHAR(45) NULL," +
                    "  `email` VARCHAR(45) NULL DEFAULT NULL," +
                    "  `phone_number` VARCHAR(45) NULL DEFAULT NULL," +
                    "  `roles_id` BIGINT NOT NULL," +
                    "  PRIMARY KEY (`id`)," +
                    "  INDEX `fk_users_roles1_idx` (`roles_id` ASC)," +
                    "  CONSTRAINT `fk_users_roles1`" +
                    "    FOREIGN KEY (`roles_id`)" +
                    "    REFERENCES `kruglenja`.`roles` (`id`)" +
                    "    ON DELETE RESTRICT" +
                    "    ON UPDATE RESTRICT)" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `kruglenja`.`order` (" +
                    "  `id` BIGINT NOT NULL AUTO_INCREMENT," +
                    "  `quanity` INT NULL," +
                    "  `deliveryTime` VARCHAR(45) NULL," +
                    "  `totalPrice` DOUBLE NULL," +
                    "  `users_id` BIGINT NOT NULL," +
                    "  PRIMARY KEY (`id`)," +
                    "  INDEX `fk_order_users_idx` (`users_id` ASC)," +
                    "  CONSTRAINT `fk_order_users`" +
                    "    FOREIGN KEY (`users_id`)" +
                    "    REFERENCES `kruglenja`.`users` (`id`)" +
                    "    ON DELETE CASCADE" +
                    "    ON UPDATE CASCADE)" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `kruglenja`.`spareParts` (" +
                    "  `id` BIGINT NOT NULL AUTO_INCREMENT," +
                    "  `model` VARCHAR(45) NULL DEFAULT NULL," +
                    "  `category` VARCHAR(45) NULL," +
                    "  `name` VARCHAR(45) NULL DEFAULT NULL," +
                    "  `serial_number` VARCHAR(45) NULL," +
                    "  `weight` DOUBLE NULL DEFAULT NULL," +
                    "  `price` DOUBLE NULL DEFAULT NULL," +
                    "  PRIMARY KEY (`id`))" +
                    "ENGINE = InnoDB;");

            statement.executeUpdate("INSERT INTO `kruglenja`.`roles` (`id`, `role`) VALUES (DEFAULT, 'administrator');");
            statement.executeUpdate("INSERT INTO `kruglenja`.`roles` (`id`, `role`) VALUES (DEFAULT, 'user');");
            statement.executeUpdate("INSERT INTO `kruglenja`.`roles` (`id`, `role`) VALUES (DEFAULT, 'guest');");
            statement.executeUpdate("INSERT INTO `kruglenja`.`users` (`id`, `login`, `password`, `email`, `phone_number`, `roles_id`) VALUES (DEFAULT, 'admin', 'admin', 'admin@admin', '+9849871891789', 1);");
            statement.executeUpdate("INSERT INTO `kruglenja`.`users` (`id`, `login`, `password`, `email`, `phone_number`, `roles_id`) VALUES (DEFAULT, 'user', 'user', 'user@user', '+9849871891789', 2);");
            statement.executeUpdate("INSERT INTO `kruglenja`.`order` (`id`, `quanity`, `deliveryTime`, `totalPrice`, `users_id`) VALUES (DEFAULT, 12, 15, 1024.25, 2);");
            statement.executeUpdate("INSERT INTO `kruglenja`.`order` (`id`, `quanity`, `deliveryTime`, `totalPrice`, `users_id`) VALUES (DEFAULT, 12, 44, 443.24, 1);");
            statement.executeUpdate("INSERT INTO `kruglenja`.`spareParts` (`id`, `model`, `category`, `name`, `serial_number`, `weight`, `price`) VALUES (DEFAULT, 'Mazda', 'engine', 'engine', 051871051184, '12', 1024);");
            statement.executeUpdate("INSERT INTO `kruglenja`.`spareParts` (`id`, `model`, `category`, `name`, `serial_number`, `weight`, `price`) VALUES (DEFAULT, 'Ford', 'motor', 'motor', 214045204524, '352', 41233);");
            System.out.println("DB created");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}