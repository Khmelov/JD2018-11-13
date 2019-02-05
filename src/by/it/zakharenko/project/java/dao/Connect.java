package by.it.zakharenko.project.java.dao;

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
                    connection = DriverManager.getConnection(CONFIG.DB_URL, CONFIG.USER, CONFIG.PASSWORD);
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


        try (Connection connection = DriverManager.getConnection(CONFIG.URL, CONFIG.USER, CONFIG.PASSWORD))  // CONFIG.URL - нужная база еще не создана
        {
            Statement statement = connection.createStatement();

            statement.executeUpdate("DROP SCHEMA IF EXISTS `zakharnk`");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `zakharnk` DEFAULT CHARACTER SET utf8");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `zakharnk`.`roles` (" +
                    "  `id` INT(11) NOT NULL AUTO_INCREMENT," +
                    "  `role` VARCHAR(100) NULL," +
                    "  PRIMARY KEY (`id`)," +
                    "  UNIQUE INDEX `role_UNIQUE` (`role` ASC))" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `zakharnk`.`users` (" +
                            "`id` INT(11) NOT NULL AUTO_INCREMENT,"+
                    "`email` VARCHAR(50) NULL,"+
                    "`username` VARCHAR(50) NULL DEFAULT NULL," +
                    "`password` VARCHAR(50) NULL DEFAULT NULL," +
                    "fullname` VARCHAR(50) NULL DEFAULT NULL," +
                    "`phone` VARCHAR(45) NULL,"+
                    "`address` VARCHAR(45) NULL,"+
                   "`roles_id` INT(11) NOT NULL," +
                    "PRIMARY KEY (`id`),"+
                    "INDEX `fk_clients_roles1_idx` (`roles_id` ASC),"+
                    "CONSTRAINT `fk_clients_roles1`"+
                    "FOREIGN KEY (`roles_id`)"+
                    "REFERENCES `zakharnk`.`roles` (`id`)"+
                    "ON DELETE RESTRICT"+
                    "ON UPDATE RESTRICT)"+
                    "ENGINE = InnoDB;");

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `zakharnk`.`items` (" +
                    "  `id` INT NOT NULL AUTO_INCREMENT," +
                    "  `title` VARCHAR(200) NULL," +
                    "  `price` INT NULL," +
                    "  PRIMARY KEY (`id`)," +
                    "  UNIQUE INDEX `title_UNIQUE` (`title` ASC))" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `zakharnk`.`orders` (" +
                    "  `id` INT(11) NOT NULL AUTO_INCREMENT," +
                    "  `date` DATE NULL," +
                    "  `time` TIME NULL," +
                    "  `users_id` INT NOT NULL," +
                    "  `items_id` INT NOT NULL," +
                    "  PRIMARY KEY (`id`)," +
                    "  INDEX `fk_orders_users1_idx` (`users_id` ASC)," +
                    "  INDEX `fk_orders_items1_idx` (`items_id` ASC)," +
                    "  CONSTRAINT `fk_orders_users1`" +
                    "    FOREIGN KEY (`users_id`)" +
                    "    REFERENCES `zakharnk`.`users` (`id`)" +
                    "    ON DELETE CASCADE" +
                    "    ON UPDATE CASCADE," +
                    "  CONSTRAINT `fk_orders_items1`" +
                    "    FOREIGN KEY (`items_id`)" +
                    "    REFERENCES `zakharnk`.`items` (`id`)" +
                    "    ON DELETE CASCADE" +
                    "    ON UPDATE CASCADE)" +
                    "ENGINE = InnoDB;");


            statement.executeUpdate("INSERT INTO `zakharnk`.`roles` (`id`, `role`) VALUES (DEFAULT, 'admin');");
            statement.executeUpdate("INSERT INTO `zakharnk`.`roles` (`id`, `role`) VALUES (DEFAULT, 'user');");
            statement.executeUpdate("INSERT INTO `zakharnk`.`roles` (`id`, `role`) VALUES (DEFAULT, 'guest');");

            statement.executeUpdate("INSERT INTO `zakharnk`.`users` (`id`, `email`, `username`, `password`, `fullname`, `phone`, `address`, `roles_id`)  + " +
                    "VALUES (DEFAULT, 'admin@gmail.com', 'admin', 'admin', 'Administrator', '+375297658895', 'Minsk', 1);");
            statement.executeUpdate("INSERT INTO `zakharnk`.`users` (`id`, `email`, `username`, `password`, `fullname`, `phone`, `address`, `roles_id`) + " +
                    "VALUES (DEFAULT, 'user@gmail.com', 'user', 'user', 'Zakharenko', '+375297658895', 'Minsk', 2);");
            //added user
            statement.executeUpdate( "INSERT INTO `zakharnk`.`users` (`id`, `email`, `username`, `password`, `fullname`, `phone`, `address`, `roles_id`) +" +
               "VALUES (DEFAULT, 'guest@gmail.com', 'guest', 'guest', 'Smith', '+375297658895', 'Minsk', 3);");

            //added item
            statement.executeUpdate("INSERT INTO `zakharnk`.`items` (`id`, `title`, `price`) +" +
                    "VALUES (DEFAULT, 'Vacuum Cleaner Samsung SC5241', 129);");
            statement.executeUpdate("INSERT INTO `zakharnk`.`items` (`id`, `title`, `price`) +" +
                    "VALUES (DEFAULT, 'Washing machine LG F2J5HS3W', 799);");


            statement.executeUpdate("INSERT INTO `zakharnk`.`orders` (`id`, `date`, `time`, `users_id`, `items_id`) " +
                    "VALUES (DEFAULT, '2019-01-19', '10:59:59', 2, 1);");
            statement.executeUpdate("INSERT INTO `zakharnk`.`orders` (`id`, `date`, `time`, `users_id`, `items_id`) +" +
                    "VALUES (DEFAULT, '2019-01-19', '10:02:13', 2, 1);");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

