package by.it.baidak.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Initialization {

    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:2016/", "root", "");
        Statement statement = connection.createStatement();
        statement.executeUpdate("DROP SCHEMA IF EXISTS `baidak`");
        statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `baidak` DEFAULT CHARACTER SET utf8");
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS `baidak`.`roles` (\n" +
                "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                "  `role` VARCHAR(45) NULL,\n" +
                "  PRIMARY KEY (`id`))\n" +
                "ENGINE = InnoDB;");
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS `baidak`.`users` (\n" +
                "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                "  `nickname` VARCHAR(45) NULL,\n" +
                "  `email` VARCHAR(45) NULL,\n" +
                "  `pass` VARCHAR(45) NULL,\n" +
                "  `roles_id` INT NOT NULL,\n" +
                "  PRIMARY KEY (`id`),\n" +
                "  INDEX `fk_users_roles_idx` (`roles_id` ASC),\n" +
                "  CONSTRAINT `fk_users_roles`\n" +
                "    FOREIGN KEY (`roles_id`)\n" +
                "    REFERENCES `baidak`.`roles` (`id`)\n" +
                "    ON DELETE RESTRICT\n" +
                "    ON UPDATE RESTRICT)\n" +
                "ENGINE = InnoDB;");
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS `baidak`.`posts` (\n" +
                "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                "  `head` VARCHAR(45) NULL,\n" +
                "  `date` VARCHAR(45) NULL,\n" +
                "  `users_id` INT NOT NULL,\n" +
                "  PRIMARY KEY (`id`),\n" +
                "  INDEX `fk_posts_users1_idx` (`users_id` ASC),\n" +
                "  CONSTRAINT `fk_posts_users1`\n" +
                "    FOREIGN KEY (`users_id`)\n" +
                "    REFERENCES `baidak`.`users` (`id`)\n" +
                "    ON DELETE CASCADE\n" +
                "    ON UPDATE CASCADE)\n" +
                "ENGINE = InnoDB;");
        statement.executeUpdate("INSERT INTO `baidak`.`roles` (`id`, `role`) VALUES (DEFAULT, 'admin')");
        statement.executeUpdate("INSERT INTO `baidak`.`roles` (`id`, `role`) VALUES (DEFAULT, 'user');");
        statement.executeUpdate("INSERT INTO `baidak`.`roles` (`id`, `role`) VALUES (DEFAULT, 'guest');");
        statement.executeUpdate("INSERT INTO `baidak`.`users` (`id`, `nickname`, `email`, `pass`, `roles_id`) VALUES (DEFAULT, 'makasin', 'maksimb@gm', '1234567', 2);");
        statement.executeUpdate("INSERT INTO `baidak`.`users` (`id`, `nickname`, `email`, `pass`, `roles_id`) VALUES (DEFAULT, 'gen', 'post@gmail', 'sql123', 2);");
        statement.executeUpdate("INSERT INTO `baidak`.`posts` (`id`, `head`, `date`, `users_id`) VALUES (DEFAULT, 'my first post', '18.01.2019', 2);");
    }
}
