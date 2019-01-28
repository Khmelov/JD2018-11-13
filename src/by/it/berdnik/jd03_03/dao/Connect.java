package by.it.berdnik.jd03_03.dao;

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

    static void reset() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:2016/", "root", ""))
        {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DROP SCHEMA IF EXISTS `berdnik`");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `berdnik` DEFAULT CHARACTER SET utf8");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `berdnik`.`roles` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT," +
                    "  `role` VARCHAR(45) NULL," +
                    "  PRIMARY KEY (`id`))" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `berdnik`.`users` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `nickname` VARCHAR(45) NULL,\n" +
                    "  `password` VARCHAR(45) NULL,\n" +
                    "  `email` VARCHAR(45) NULL,\n" +
                    "  `roles_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_users_roles_idx` (`roles_id` ASC),\n" +
                    "  CONSTRAINT `fk_users_roles1`\n" +
                    "    FOREIGN KEY (`roles_id`)\n" +
                    "    REFERENCES `berdnik`.`roles` (`id`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT)\n" +
                    "ENGINE = InnoDB;\n");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `berdnik`.`buyers` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `item` VARCHAR(500) NULL,\n" +
                    "  `specif` VARCHAR(2000) NULL,\n" +
                    "  `price` INT NULL,\n" +
                    "  `address` VARCHAR(1000) NULL,\n" +
                    "  `users_id` INT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_buyers_users1_idx` (`users_id` ASC),\n" +
                    "  CONSTRAINT `fk_buyers_users1`\n" +
                    "    FOREIGN KEY (`users_id`)\n" +
                    "    REFERENCES `berdnik`.`users` (`id`)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE CASCADE)\n" +
                    "ENGINE = InnoDB;\n");
            statement.executeUpdate("INSERT INTO `berdnik`.`roles` (`id`, `role`) VALUES (DEFAULT, 'admin');");
            statement.executeUpdate("INSERT INTO `berdnik`.`roles` (`id`, `role`) VALUES (DEFAULT, 'user');");
            statement.executeUpdate("INSERT INTO `berdnik`.`users` (`id`, `nickname`, `password`, `email`, `roles_id`) VALUES (DEFAULT, 'admin', 'admin', 'admin@mail.ru', 1);");
            statement.executeUpdate("INSERT INTO `berdnik`.`users` (`id`, `nickname`, `password`, `email`, `roles_id`) VALUES (DEFAULT, 'user', 'user', 'user@mail.ru', 2);");
            statement.executeUpdate("INSERT INTO `berdnik`.`buyers` (`id`, `item`, `specif`, `price`, `address`, `users_id`) VALUES (DEFAULT, 'MSI GE73 8RF-096XRU Raider RGB', '17.3\\\" 1920 x 1080 IPS, Intel i7 8750H, 16 ГБ, HDD 1000 ГБ, NVIDIA GTX 1070 8 ГБ', 3868, 'Minsk Street 1-1', 2);");
            statement.executeUpdate("INSERT INTO `berdnik`.`buyers` (`id`, `item`, `specif`, `price`, `address`, `users_id`) VALUES (DEFAULT, 'Dell G3 17 3779 G317-7664', '17.3\\\" 1920 x 1080 IPS, Intel i7 8750H, 16 ГБ, HDD+SSD 2000+256 ГБ, NVIDIA GTX 1060 6 ГБ', 3068, 'Minsk Street 2-2', 2);");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}