package by.it.lobkova.jd03_02.crud;

import by.it.lobkova.jd03_02.beans.User;

import java.sql.SQLException;
import java.sql.Statement;

public class TaskC {

    public static void main(String[] args) {
        try (Statement statement = Connect.getConnection().createStatement()) {
            createTables();
            fillTables();
//            deleteTables();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static void createTables() {
        try (Statement statement = Connect.getConnection().createStatement()){
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
                    "  `ID` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `name_goal` VARCHAR(100) NULL,\n" +
                    "  `description_goal` VARCHAR(500) NULL,\n" +
                    "  `beginDate` DATE NULL,\n" +
                    "  `endDate` DATE NULL,\n" +
                    "  `users_ID` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`ID`),\n" +
                    "  CONSTRAINT `fk_goals_users1`\n" +
                    "    FOREIGN KEY (`users_ID`)\n" +
                    "    REFERENCES `lobkova`.`users` (`ID`)\n" +
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
            statement.executeUpdate("INSERT INTO `lobkova`.`users` (`id`, `email`, `login`, `password`, `name`, `roles_ID`) VALUES (NULL, 'user2@user', 'user2', 'user2', 'user2', '2');");
            statement.executeUpdate("INSERT INTO `lobkova`.`users` (`id`, `email`, `login`, `password`, `name`, `roles_ID`) VALUES (NULL, 'user3@user', 'user3', 'user3', 'user3', '2');");
            statement.executeUpdate("INSERT INTO `lobkova`.`users` (`id`, `email`, `login`, `password`, `name`, `roles_ID`) VALUES (NULL, 'user4@user', 'user4', 'user4', 'user4', '2');");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void deleteTables() {
        try (Statement statement = Connect.getConnection().createStatement()) {
            statement.executeUpdate("DROP TABLE IF EXISTS `roles`");
            statement.executeUpdate("DROP TABLE IF EXISTS `users`");
            statement.executeUpdate("DROP TABLE IF EXISTS `tasks`");
            statement.executeUpdate("DROP TABLE IF EXISTS `goals`");
            System.out.println("Таблицы удалены");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void fillTables() {
        try {
            User Task1 = new User();
            UserCRUD taskCRUD = new UserCRUD();
            Task1.setEmail("user77772010");
            Task1.setLogin("task5p");
            Task1.setPassword("jj");
            Task1.setName("kkk");
            Task1.setRoles_id(1);
           if (taskCRUD.create(Task1)) {
               System.out.println("Таблицы заполнены");
           }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
