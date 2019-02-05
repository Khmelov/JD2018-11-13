package by.it.lobkova.project.java.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect {

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
            synchronized (Connection.class) {
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

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:2016/lobkova?/", "root", "")) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DROP SCHEMA IF EXISTS `lobkova`");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `lobkova` DEFAULT CHARACTER SET utf8");
            statement.executeUpdate("DROP TABLE IF EXISTS `lobkova`.`roles`");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `lobkova`.`roles` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `role` VARCHAR(45) NULL,\n" +
                    "  PRIMARY KEY (`id`))\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `lobkova`.`users` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `email` VARCHAR(100) NULL,\n" +
                    "  `login` VARCHAR(100) NULL,\n" +
                    "  `password` VARCHAR(100) NULL,\n" +
                    "  `name` VARCHAR(100) NULL,\n" +
                    "  `roles_ID` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  CONSTRAINT `fk_users_roles1`\n" +
                    "    FOREIGN KEY (`roles_ID`)\n" +
                    "    REFERENCES `lobkova`.`roles` (`id`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT)\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `lobkova`.`goals` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `name_goal` VARCHAR(100) NULL,\n" +
                    "  `description_goal` VARCHAR(500) NULL,\n" +
                    "  `beginDate` INT(100) NULL,\n" +
                    "  `endDate` INT(100) NULL,\n" +
                    "  `users_ID` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  CONSTRAINT `fk_goals_users1`\n" +
                    "    FOREIGN KEY (`users_ID`)\n" +
                    "    REFERENCES `lobkova`.`users` (`id`)\n" +
                    "    ON DELETE NO ACTION\n" +
                    "    ON UPDATE NO ACTION)\n" +
                    "ENGINE = InnoDB;\n");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `lobkova`.`tasks` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `name_task` VARCHAR(100) NULL,\n" +
                    "  `description_task` VARCHAR(500) NULL,\n" +
                    "  `date` INT NULL,\n" +
                    "  `goals_ID` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  CONSTRAINT `fk_tasks_goals1`\n" +
                    "    FOREIGN KEY (`goals_ID`)\n" +
                    "    REFERENCES `lobkova`.`goals` (`id`)\n" +
                    "    ON DELETE NO ACTION\n" +
                    "    ON UPDATE NO ACTION)\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("INSERT INTO `lobkova`.`roles` (`id`, `role`) VALUES (DEFAULT, 'administrator');");
            statement.executeUpdate("INSERT INTO `lobkova`.`roles` (`id`, `role`) VALUES (DEFAULT, 'user');");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
