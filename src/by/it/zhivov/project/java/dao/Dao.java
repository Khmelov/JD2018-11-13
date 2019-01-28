package by.it.zhivov.project.java.dao;

import by.it.zhivov.project.java.beans.Ad;
import by.it.zhivov.project.java.beans.Role;
import by.it.zhivov.project.java.beans.User;

import java.sql.*;

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
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:2016/?" +
                "useSSL=false" +
                "&" +
                "useUnicode=true&characterEncoding=UTF-8", "root", "");
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("DROP SCHEMA IF EXISTS `zhivov`");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `zhivov` DEFAULT CHARACTER SET utf8");
            statement.executeUpdate("USE `zhivov`");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `zhivov`.`roles` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `role` VARCHAR(20) NULL,\n" +
                    "  PRIMARY KEY (`id`))\n" +
                    "ENGINE = InnoDB");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `zhivov`.`users` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `name` VARCHAR(100) NULL,\n" +
                    "  `login` VARCHAR(45) NULL,\n" +
                    "  `password` VARCHAR(26) NULL,\n" +
                    "  `dateofbirth` DATE NULL,\n" +
                    "  `email` VARCHAR(45) NULL,\n" +
                    "  `tel` VARCHAR(45) NULL,\n" +
                    "  `roles_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_users_roles_idx` (`roles_id` ASC) VISIBLE,\n" +
                    "  UNIQUE INDEX `login_UNIQUE` (`login` ASC) VISIBLE,\n" +
                    "  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,\n" +
                    "  UNIQUE INDEX `tel_UNIQUE` (`tel` ASC) VISIBLE,\n" +
                    "  CONSTRAINT `fk_users_roles`\n" +
                    "    FOREIGN KEY (`roles_id`)\n" +
                    "    REFERENCES `zhivov`.`roles` (`id`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT)\n" +
                    "ENGINE = InnoDB");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `zhivov`.`ads` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `title` VARCHAR(50) NULL,\n" +
                    "  `description` VARCHAR(2000) NULL,\n" +
                    "  `brand` VARCHAR(45) NULL,\n" +
                    "  `model` VARCHAR(45) NULL,\n" +
                    "  `color` VARCHAR(45) NULL,\n" +
                    "  `body` VARCHAR(45) NULL,\n" +
                    "  `year` INT NULL,\n" +
                    "  `engine` DOUBLE NULL,\n" +
                    "  `at` INT NULL,\n" +
                    "  `driveunit` VARCHAR(15) NULL,\n" +
                    "  `equipment` VARCHAR(45) NULL,\n" +
                    "  `mileage` INT NULL,\n" +
                    "  `crashed` INT NULL,\n" +
                    "  `price` DOUBLE NULL,\n" +
                    "  `users_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_ads_users1_idx` (`users_id` ASC) VISIBLE,\n" +
                    "  CONSTRAINT `fk_ads_users1`\n" +
                    "    FOREIGN KEY (`users_id`)\n" +
                    "    REFERENCES `zhivov`.`users` (`id`)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE CASCADE)\n" +
                    "ENGINE = InnoDB");
            statement.executeUpdate("INSERT INTO `zhivov`.`roles` (`id`, `role`) VALUES (DEFAULT, 'admin')");
            statement.executeUpdate("INSERT INTO `zhivov`.`roles` (`id`, `role`) VALUES (DEFAULT, 'user')");
            statement.executeUpdate("INSERT INTO `zhivov`.`roles` (`id`, `role`) VALUES (DEFAULT, 'guest')");
            statement.executeUpdate("INSERT INTO `zhivov`.`users` (`id`, `name`, `login`, `password`, `dateofbirth`, `email`, `tel`, `roles_id`) VALUES (DEFAULT, 'm0rph3us', 'admin', 'admin', NULL, NULL, NULL, 1)");
            System.out.println("DB restored successful");
        }
    }
}
