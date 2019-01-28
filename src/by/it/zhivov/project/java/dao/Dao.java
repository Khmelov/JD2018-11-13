package by.it.zhivov.project.java.dao;

import by.it.zhivov.project.java.beans.Ad;
import by.it.zhivov.project.java.beans.Role;
import by.it.zhivov.project.java.beans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Dao {
    private static volatile Dao dao;

    public InterfaceDao<Role> role;
    public InterfaceDao<User> user;
    public InterfaceDao<Ad> ad;


    private Dao() {
        role = new RoleDao();
        user = new UserDao();
        ad = new AdDao();
    }

    public static Dao getDao() {
        if (dao == null) {
            synchronized (Dao.class) {
                if (dao == null) {
                    dao = new Dao();
                }
            }
        }
        return dao;
    }

    static boolean executeUpdate(String sql) throws SQLException {
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            return ( 1 == statement.executeUpdate(sql) );
        }
    }

    static long executeCreateAndGetId(String sql) throws SQLException {
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            if (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    return generatedKeys.getLong(1);
                }
            }
        }
        return -1;
    }

    public static void restoreDB() throws SQLException {
        System.out.println("Staring DB restore");
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("DROP SCHEMA IF EXISTS `zhivov`");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `zhivov` DEFAULT CHARACTER SET utf8");
            statement.executeUpdate("USE `zhivov`");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `zhivov`.`roles` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `role` VARCHAR(20) NULL,\n" +
                    "  PRIMARY KEY (`id`))\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `zhivov`.`users` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `name` VARCHAR(100) NULL,\n" +
                    "  `login` VARCHAR(45) NULL,\n" +
                    "  `password` VARCHAR(26) NULL,\n" +
                    "  `dateofbirth` VARCHAR(10) NULL,\n" +
                    "  `email` VARCHAR(45) NULL,\n" +
                    "  `tel` VARCHAR(45) NULL,\n" +
                    "  `roles_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_users_roles_idx` (`roles_id` ASC),\n" +
                    "  CONSTRAINT `fk_users_roles`\n" +
                    "    FOREIGN KEY (`roles_id`)\n" +
                    "    REFERENCES `zhivov`.`roles` (`id`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT)\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `zhivov`.`ads` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `title` VARCHAR(50) NULL,\n" +
                    "  `description` VARCHAR(2000) NULL,\n" +
                    "  `brand` VARCHAR(45) NULL,\n" +
                    "  `model` VARCHAR(45) NULL,\n" +
                    "  `color` VARCHAR(45) NULL,\n" +
                    "  `body` VARCHAR(45) NULL,\n" +
                    "  `year` INT NULL,\n" +
                    "  `equipment` VARCHAR(45) NULL,\n" +
                    "  `mileage` INT NULL,\n" +
                    "  `crashed` VARCHAR(5) NULL,\n" +
                    "  `price` FLOAT NOT NULL,\n" +
                    "  `users_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_ads_users1_idx` (`users_id` ASC),\n" +
                    "  CONSTRAINT `fk_ads_users1`\n" +
                    "    FOREIGN KEY (`users_id`)\n" +
                    "    REFERENCES `zhivov`.`users` (`id`)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE CASCADE)\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("INSERT INTO `zhivov`.`roles` (`id`, `role`) VALUES (DEFAULT, 'admin')");
            statement.executeUpdate("INSERT INTO `zhivov`.`roles` (`id`, `role`) VALUES (DEFAULT, 'user')");
            statement.executeUpdate("INSERT INTO `zhivov`.`roles` (`id`, `role`) VALUES (DEFAULT, 'guest')");
            statement.executeUpdate("INSERT INTO `zhivov`.`users` (`id`, `name`, `login`, `password`, `dateofbirth`, `email`, `tel`, `roles_id`) VALUES (DEFAULT, 'Petya', 'Petr2018', 'petyapetya', '26.04.1993', 'petya@mail.ru', '+848651861668', 2)");
            statement.executeUpdate("INSERT INTO `zhivov`.`users` (`id`, `name`, `login`, `password`, `dateofbirth`, `email`, `tel`, `roles_id`) VALUES (DEFAULT, NULL, NULL, NULL, NULL, NULL, NULL, 3)");
            statement.executeUpdate("INSERT INTO `zhivov`.`users` (`id`, `name`, `login`, `password`, `dateofbirth`, `email`, `tel`, `roles_id`) VALUES (DEFAULT, NULL, NULL, NULL, NULL, NULL, NULL, 3)");
            statement.executeUpdate("INSERT INTO `zhivov`.`users` (`id`, `name`, `login`, `password`, `dateofbirth`, `email`, `tel`, `roles_id`) VALUES (DEFAULT, 'm0rph3us', 'admin', 'admin', NULL, NULL, NULL, 1)");
            statement.executeUpdate("INSERT INTO `zhivov`.`users` (`id`, `name`, `login`, `password`, `dateofbirth`, `email`, `tel`, `roles_id`) VALUES (DEFAULT, 'Andrey', 'Dron2355', 'drondron', '16.05.1980', 'dron@mail.ru', '+5616516568', 2)");
            statement.executeUpdate("INSERT INTO `zhivov`.`ads` (`id`, `title`, `description`, `brand`, `model`, `color`, `body`, `year`, `equipment`, `mileage`, `crashed`, `price`, `users_id`) VALUES (DEFAULT, 'TestTitle', 'TestDescription', 'Lancia', '53', 'yelow', 'coupe', 1996, 'standart', 186153, true, 580000, 1)");
            statement.executeUpdate("INSERT INTO `zhivov`.`ads` (`id`, `title`, `description`, `brand`, `model`, `color`, `body`, `year`, `equipment`, `mileage`, `crashed`, `price`, `users_id`) VALUES (DEFAULT, '2TestTitle', '2TestDescription', 'Opel', 'Astra', 'white', 'sedan', 2008, 'comfort', 40000, false, 1300000, 1)");
            statement.executeUpdate("INSERT INTO `zhivov`.`ads` (`id`, `title`, `description`, `brand`, `model`, `color`, `body`, `year`, `equipment`, `mileage`, `crashed`, `price`, `users_id`) VALUES (DEFAULT, '2TestTitle', '3TestDescription', 'Opel', 'Astra', 'white', 'sedan', 2008, 'comfort', 40000, false, 1300000, 1)");
            statement.executeUpdate("INSERT INTO `zhivov`.`ads` (`id`, `title`, `description`, `brand`, `model`, `color`, `body`, `year`, `equipment`, `mileage`, `crashed`, `price`, `users_id`) VALUES (DEFAULT, '3TestTitle', '4TestDescription', 'Opel', 'Astra', 'white', 'sedan', 2008, 'comfort', 40000, false, 1300000, 1)");
            statement.executeUpdate("INSERT INTO `zhivov`.`ads` (`id`, `title`, `description`, `brand`, `model`, `color`, `body`, `year`, `equipment`, `mileage`, `crashed`, `price`, `users_id`) VALUES (DEFAULT, '4TestTitle', '5TestDescription', 'Opel', 'Astra', 'white', 'sedan', 2008, 'comfort', 40000, false, 1300000, 1)");
            statement.executeUpdate("INSERT INTO `zhivov`.`ads` (`id`, `title`, `description`, `brand`, `model`, `color`, `body`, `year`, `equipment`, `mileage`, `crashed`, `price`, `users_id`) VALUES (DEFAULT, '5TestTitle', '6TestDescription', 'Opel', 'Astra', 'white', 'sedan', 2008, 'comfort', 40000, false, 1300000, 1)");
            statement.executeUpdate("INSERT INTO `zhivov`.`ads` (`id`, `title`, `description`, `brand`, `model`, `color`, `body`, `year`, `equipment`, `mileage`, `crashed`, `price`, `users_id`) VALUES (DEFAULT, '5TestTitle', '6TestDescription', 'Opel', 'Astra', 'white', 'sedan', 2008, 'comfort', 40000, false, 1300000, 4)");
            System.out.println("DB restored successful");
        }
    }
}