package by.it.mnovikov.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by user on 17.01.2019.
 */
public class C_init {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:2016", "root", "")){
            Statement statement = connection.createStatement();
            statement.executeUpdate("DROP SCHEMA IF EXISTS `mnovikov`");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `mnovikov` DEFAULT CHARACTER SET utf8");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `mnovikov`.`roles` (" +
                    "  `id` INT NOT NULL AUTO_INCREMENT," +
                    "  `role` VARCHAR(100) NULL," +
                    "  PRIMARY KEY (`id`))" +
                    "ENGINE = InnoDB");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `mnovikov`.`admin` (" +
                    "  `id` INT NOT NULL AUTO_INCREMENT," +
                    "  `login` VARCHAR(45) NULL," +
                    "  `password` VARCHAR(45) NULL," +
                    "  `email` VARCHAR(45) NULL," +
                    "  `roles_id` INT NOT NULL," +
                    "  PRIMARY KEY (`id`)," +
                    "  INDEX `fk_users_roles_idx` (`roles_id` ASC)," +
                    "  CONSTRAINT `fk_users_roles`" +
                    "    FOREIGN KEY (`roles_id`)" +
                    "    REFERENCES `mnovikov`.`roles` (`id`)" +
                    "    ON DELETE RESTRICT" +
                    "    ON UPDATE RESTRICT)" +
                    "ENGINE = InnoDB");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `mnovikov`.`ads` (" +
                    "  `id` INT NOT NULL AUTO_INCREMENT," +
                    "  `title` VARCHAR(100) NULL," +
                    "  `discription` VARCHAR(2000) NULL," +
                    "  `samler_type` VARCHAR(100) NULL," +
                    "  `users_id` INT NOT NULL," +
                    "  PRIMARY KEY (`id`)," +
                    "  INDEX `fk_ads_users1_idx` (`users_id` ASC)," +
                    "  CONSTRAINT `fk_ads_users1`" +
                    "    FOREIGN KEY (`users_id`)" +
                    "    REFERENCES `mnovikov`.`admin` (`id`)" +
                    "    ON DELETE CASCADE" +
                    "    ON UPDATE CASCADE)" +
                    "ENGINE = InnoDB");
            statement.executeUpdate("INSERT INTO `mnovikov`.`roles` (`id`, `role`) VALUES (DEFAULT, 'admin')");
            statement.executeUpdate("INSERT INTO `mnovikov`.`roles` (`id`, `role`) VALUES (DEFAULT, 'user')");
            statement.executeUpdate("INSERT INTO `mnovikov`.`roles` (`id`, `role`) VALUES (DEFAULT, 'guest')");
            statement.executeUpdate("INSERT INTO `mnovikov`.`admin` (`id`, `login`, `password`, `email`, `roles_id`) VALUES (DEFAULT, 'admin', 'admin', 'admin@mail.ru', 1);");
            statement.executeUpdate("INSERT INTO `mnovikov`.`admin` (`id`, `login`, `password`, `email`, `roles_id`) VALUES (DEFAULT, 'user', 'user', 'user@mail.ru', 2)");
            statement.executeUpdate("INSERT INTO `mnovikov`.`admin` (`id`, `login`, `password`, `email`, `roles_id`) VALUES (DEFAULT, 'guest', 'guest', 'guest@mail.ru', 3)");
            statement.executeUpdate("INSERT INTO `mnovikov`.`ads` (`id`, `title`, `discription`, `samler_type`, `users_id`) VALUES (DEFAULT, 'test1', 'test for test1 descr', 'auto', 2)");
            statement.executeUpdate("INSERT INTO `mnovikov`.`ads` (`id`, `title`, `discription`, `samler_type`, `users_id`) VALUES (DEFAULT, 'test2', 'test for test2 desr', 'hand', 2)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
