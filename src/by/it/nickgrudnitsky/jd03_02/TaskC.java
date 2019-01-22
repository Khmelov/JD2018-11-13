package by.it.nickgrudnitsky.jd03_02;


import by.it.nickgrudnitsky.jd03_02.CRUD.RoleCRUD;
import by.it.nickgrudnitsky.jd03_02.CRUD.StreamerCRUD;
import by.it.nickgrudnitsky.jd03_02.CRUD.ViewerCRUD;
import by.it.nickgrudnitsky.jd03_02.beans.Role;
import by.it.nickgrudnitsky.jd03_02.beans.Streamer;
import by.it.nickgrudnitsky.jd03_02.beans.Viewer;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TaskC {
    public static void main(String[] args) {
        TaskC taskC = new TaskC();
        taskC.deleteDBS();
        taskC.createDBS();
        taskC.fillDBS();

    }

    public void createDBS() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:2016/", "root", "")) {
            Statement statement = connection.createStatement();
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
            System.out.println("Successfully created DBS.");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deleteDBS() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:2016/", "root", "")) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DROP SCHEMA IF EXISTS `ngrudnitsky`");
            System.out.println("Successfully deleted DBS.");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void fillDBS() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:2016/", "root", "")) {
            Statement statement = connection.createStatement();
            RoleCRUD roleCRUD = new RoleCRUD();
            Role role1 = new Role("admin");
            Role role2 = new Role("streamer");
            Role role3 = new Role("viewer");
            roleCRUD.create(role1);
            roleCRUD.create(role2);
            roleCRUD.create(role3);

            ViewerCRUD viewerCRUD = new ViewerCRUD();
            Viewer viewer1 = new Viewer("grud97@gmail.com", "password", "NickGS", 3);
            Viewer viewer2 = new Viewer("pewdiepie@pewd.se", "youloose", "pewdiepie", 3);
            viewerCRUD.create(viewer1);
            viewerCRUD.create(viewer2);

            StreamerCRUD streamerCRUD= new StreamerCRUD();
            Streamer streamer1 = new Streamer("ninja@gmail.com", "fortnightlover", "Ninja", 2);
            Streamer streamer2 = new Streamer("silvername@gmail.com@pewd.se", "hearthstone", "SilverName", 2);
            streamerCRUD.create(streamer1);
            streamerCRUD.create(streamer2);




            statement.executeUpdate("INSERT INTO `ngrudnitsky`.`viewers_has_streamers` (`viewers_id`, `streamers_id`) VALUES (1, 1);");
            statement.executeUpdate("INSERT INTO `ngrudnitsky`.`viewers_has_streamers` (`viewers_id`, `streamers_id`) VALUES (1, 2);");
            statement.executeUpdate("INSERT INTO `ngrudnitsky`.`viewers_has_streamers` (`viewers_id`, `streamers_id`) VALUES (2, 1);");
            System.out.println("Successfully filled out DBS");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
