package by.it.nickgrudnitsky.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class C_Init {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

       try(Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/", "root", "")){
           Statement statement = connection.createStatement();
           statement.executeUpdate("DROP SCHEMA IF EXISTS `ngrudnitsky` ;");
           statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `ngrudnitsky` DEFAULT CHARACTER SET utf8 ;");
           statement.executeUpdate("CREATE TABLE IF NOT EXISTS `ngrudnitsky`.`roles` (\n" +
                   "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                   "  `role` VARCHAR(100) NULL,\n" +
                   "  PRIMARY KEY (`id`))\n" +
                   "ENGINE = InnoDB;");
           statement.executeUpdate("CREATE TABLE IF NOT EXISTS `ngrudnitsky`.`viewers` (\n" +
                   "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                   "  `email` VARCHAR(100) NULL,\n" +
                   "  `password` VARCHAR(100) NULL,\n" +
                   "  `nickname` VARCHAR(20) NULL,\n" +
                   "  `roles_id` INT NOT NULL,\n" +
                   "  PRIMARY KEY (`id`),\n" +
                   "  INDEX `fk_viewers_roles1_idx` (`roles_id` ASC) VISIBLE,\n" +
                   "  CONSTRAINT `fk_viewers_roles1`\n" +
                   "    FOREIGN KEY (`roles_id`)\n" +
                   "    REFERENCES `ngrudnitsky`.`roles` (`id`)\n" +
                   "    ON DELETE NO ACTION\n" +
                   "    ON UPDATE NO ACTION)\n" +
                   "ENGINE = InnoDB;");
           statement.executeUpdate("CREATE TABLE IF NOT EXISTS `ngrudnitsky`.`streamers` (\n" +
                   "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                   "  `email` VARCHAR(100) NULL,\n" +
                   "  `password` VARCHAR(100) NULL,\n" +
                   "  `channelname` VARCHAR(45) NULL,\n" +
                   "  `roles_id` INT NOT NULL,\n" +
                   "  PRIMARY KEY (`id`),\n" +
                   "  INDEX `fk_streamers_roles1_idx` (`roles_id` ASC) VISIBLE,\n" +
                   "  CONSTRAINT `fk_streamers_roles1`\n" +
                   "    FOREIGN KEY (`roles_id`)\n" +
                   "    REFERENCES `ngrudnitsky`.`roles` (`id`)\n" +
                   "    ON DELETE RESTRICT\n" +
                   "    ON UPDATE RESTRICT)\n" +
                   "ENGINE = InnoDB;");
           statement.executeUpdate("CREATE TABLE IF NOT EXISTS `ngrudnitsky`.`viewers_has_streamers` (\n" +
                   "  `viewers_id` INT NOT NULL,\n" +
                   "  `streamers_id` INT NOT NULL,\n" +
                   "  PRIMARY KEY (`viewers_id`, `streamers_id`),\n" +
                   "  INDEX `fk_viewers_has_streamers_streamers1_idx` (`streamers_id` ASC) VISIBLE,\n" +
                   "  INDEX `fk_viewers_has_streamers_viewers1_idx` (`viewers_id` ASC) VISIBLE,\n" +
                   "  CONSTRAINT `fk_viewers_has_streamers_viewers1`\n" +
                   "    FOREIGN KEY (`viewers_id`)\n" +
                   "    REFERENCES `ngrudnitsky`.`viewers` (`id`)\n" +
                   "    ON DELETE NO ACTION\n" +
                   "    ON UPDATE NO ACTION,\n" +
                   "  CONSTRAINT `fk_viewers_has_streamers_streamers1`\n" +
                   "    FOREIGN KEY (`streamers_id`)\n" +
                   "    REFERENCES `ngrudnitsky`.`streamers` (`id`)\n" +
                   "    ON DELETE NO ACTION\n" +
                   "    ON UPDATE NO ACTION)\n" +
                   "ENGINE = InnoDB;");
           statement.executeUpdate("INSERT INTO `ngrudnitsky`.`roles` (`id`, `role`) VALUES (DEFAULT, 'admin');");
           statement.executeUpdate("INSERT INTO `ngrudnitsky`.`roles` (`id`, `role`) VALUES (DEFAULT, 'streamer');");
           statement.executeUpdate("INSERT INTO `ngrudnitsky`.`roles` (`id`, `role`) VALUES (DEFAULT, 'viewer');\n");
           statement.executeUpdate("INSERT INTO `ngrudnitsky`.`viewers` (`id`, `email`, `password`, `nickname`, `roles_id`) VALUES (DEFAULT, 'grud97@gmail.com', 'password', 'NickGS', 3);");
           statement.executeUpdate("INSERT INTO `ngrudnitsky`.`viewers` (`id`, `email`, `password`, `nickname`, `roles_id`) VALUES (DEFAULT, 'pewdiepie@pewd.se', 'youloose', 'pewdiepie', 3);");
           statement.executeUpdate("INSERT INTO `ngrudnitsky`.`streamers` (`id`, `email`, `password`, `channelname`, `roles_id`) VALUES (DEFAULT, 'ninja@gmail.com', 'fortnightlover', 'Ninja', 2);");
           statement.executeUpdate("INSERT INTO `ngrudnitsky`.`streamers` (`id`, `email`, `password`, `channelname`, `roles_id`) VALUES (DEFAULT, 'silvername@gmail.com', 'hearthstone', 'SilverName', 2);");
           statement.executeUpdate("INSERT INTO `ngrudnitsky`.`viewers_has_streamers` (`viewers_id`, `streamers_id`) VALUES (1, 1);");
           statement.executeUpdate("INSERT INTO `ngrudnitsky`.`viewers_has_streamers` (`viewers_id`, `streamers_id`) VALUES (1, 2);");
           statement.executeUpdate("INSERT INTO `ngrudnitsky`.`viewers_has_streamers` (`viewers_id`, `streamers_id`) VALUES (2, 1);");
       } catch (SQLException e) {
           e.printStackTrace();
       }
    }
}
