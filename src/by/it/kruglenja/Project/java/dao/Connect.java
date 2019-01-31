package by.it.kruglenja.Project.java.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class Connect {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private static volatile Connection connection;

    static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            synchronized (Connect.class) {
                if (connection == null || connection.isClosed()) {
                    connection = DriverManager.getConnection(CN.URL, CN.USER, CN.PASSWORD);
                }
            }
        }
        return connection;
    }

    static void deleteDb() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:2016/", "root", "")) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DROP SCHEMA IF EXISTS `kruglenja` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `kruglenja`.`users` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `kruglenja`.`roles` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `kruglenja`.`order` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `kruglenja`.`spareParts` ;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void createDb() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:2016/", "root", "")) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `kruglenja` DEFAULT CHARACTER SET utf8 ;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `kruglenja`.`roles` (" +
                    "  `id` BIGINT NOT NULL AUTO_INCREMENT," +
                    "  `role` VARCHAR(45) NULL," +
                    "  PRIMARY KEY (`id`))" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `kruglenja`.`users` (" +
                    "  `id` BIGINT NOT NULL AUTO_INCREMENT," +
                    "  `login` VARCHAR(45) NULL DEFAULT NULL," +
                    "  `password` VARCHAR(45) NULL," +
                    "  `email` VARCHAR(45) NULL," +
                    "  `phone_number` VARCHAR(45) NULL DEFAULT NULL," +
                    "  `roles_id` BIGINT NOT NULL," +
                    "  PRIMARY KEY (`id`)," +
                    "  INDEX `fk_users_roles1_idx` (`roles_id` ASC)," +
                    "  CONSTRAINT `fk_users_roles1`" +
                    "    FOREIGN KEY (`roles_id`)" +
                    "    REFERENCES `kruglenja`.`roles` (`id`)" +
                    "    ON DELETE RESTRICT" +
                    "    ON UPDATE RESTRICT)" +
                    "ENGINE = InnoDB");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `kruglenja`.`spareParts` (" +
                    "  `id` BIGINT NOT NULL AUTO_INCREMENT," +
                    "  `model` VARCHAR(45) NULL DEFAULT NULL," +
                    "  `category` VARCHAR(45) NULL," +
                    "  `name` VARCHAR(45) NULL DEFAULT NULL," +
                    "  `serial_number` VARCHAR(45) NULL," +
                    "  `weight` VARCHAR(45) NULL DEFAULT NULL," +
                    "  `price` DOUBLE NULL DEFAULT NULL," +
                    "  `storageQuanity` INT NULL," +
                    "  PRIMARY KEY (`id`))" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `kruglenja`.`order` (" +
                    "  `id` BIGINT NOT NULL AUTO_INCREMENT," +
                    "  `quanity` INT NULL," +
                    "  `deliveryTime` VARCHAR(45) NULL," +
                    "  `totalPrice` INT NULL," +
                    "  `users_id` BIGINT NOT NULL," +
                    "  `spareParts_id` BIGINT NOT NULL," +
                    "  PRIMARY KEY (`id`)," +
                    "  INDEX `fk_order_users1_idx` (`users_id` ASC)," +
                    "  INDEX `fk_order_spareParts1_idx` (`spareParts_id` ASC)," +
                    "  CONSTRAINT `fk_order_users1`" +
                    "    FOREIGN KEY (`users_id`)" +
                    "    REFERENCES `kruglenja`.`users` (`id`)" +
                    "    ON DELETE CASCADE" +
                    "    ON UPDATE CASCADE," +
                    "  CONSTRAINT `fk_order_spareParts1`" +
                    "    FOREIGN KEY (`spareParts_id`)" +
                    "    REFERENCES `kruglenja`.`spareParts` (`id`)" +
                    "    ON DELETE CASCADE" +
                    "    ON UPDATE CASCADE)" +
                    "ENGINE = InnoDB;");

            statement.executeUpdate("INSERT INTO `kruglenja`.`spareParts` (`id`, `model`, `category`, `name`, `serial_number`, `weight`, `price`, `storageQuanity`) VALUES (DEFAULT, 'Ford', 'motor', 'motor', 214045204524, '352', 41233, 228);");
            statement.executeUpdate("INSERT INTO `kruglenja`.`spareParts` (`id`, `model`, `category`, `name`, `serial_number`, `weight`, `price`, `storageQuanity`) VALUES (DEFAULT, 'Mazda', 'engine', 'engine', 051871051184, '12', 1024, 322);");
            statement.executeUpdate("INSERT INTO `kruglenja`.`roles` (`id`, `role`) VALUES (DEFAULT, 'administrator');");
            statement.executeUpdate("INSERT INTO `kruglenja`.`roles` (`id`, `role`) VALUES (DEFAULT, 'user');");
            statement.executeUpdate("INSERT INTO `kruglenja`.`roles` (`id`, `role`) VALUES (DEFAULT, 'guest');");
            statement.executeUpdate("INSERT INTO `kruglenja`.`users` (`id`, `login`, `password`, `email`, `phone_number`, `roles_id`) VALUES (DEFAULT, 'admin', 'admin', 'admin@admin', '+9849871891789', 1);");
            statement.executeUpdate("INSERT INTO `kruglenja`.`users` (`id`, `login`, `password`, `email`, `phone_number`, `roles_id`) VALUES (DEFAULT, 'user', 'user', 'user@user', '+9849871891789', 2);");
            statement.executeUpdate("INSERT INTO `kruglenja`.`order` (`id`, `quanity`, `deliveryTime`, `totalPrice`, `spareParts_id`, `users_id`) VALUES (DEFAULT, 12, 'Послезавтра', 10.24, 1, 2);");
            statement.executeUpdate("INSERT INTO `kruglenja`.`order` (`id`, `quanity`, `deliveryTime`, `totalPrice`, `spareParts_id`, `users_id`) VALUES (DEFAULT, 12, 'Послезавтра', 4.44, 2, 2);");
            System.out.println("DB created");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
