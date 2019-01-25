package by.it.vchernetski.jd03_01;



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
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:2016/", "root", "")){
            Statement statement = connection.createStatement();
            statement.executeUpdate("DROP SCHEMA IF EXISTS `vchernetski`");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `vchernetski` DEFAULT CHARACTER SET utf8");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `vchernetski`.`roles` (" +
                    "  `id` INT NOT NULL AUTO_INCREMENT," +
                    "  `role` VARCHAR(100) NULL," +
                    "  PRIMARY KEY (`id`))" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `vchernetski`.`users` (" +
                    "  `id` INT NOT NULL AUTO_INCREMENT," +
                    "  `fio` VARCHAR(100) NULL," +
                    "  `numbergarages` INT NULL," +
                    "  `nickname` VARCHAR(100) NULL," +
                    "  `email` VARCHAR(100) NULL," +
                    "  `password` VARCHAR(100) NULL," +
                    "  `roles_id` INT NOT NULL," +
                    "  PRIMARY KEY (`id`)," +
                    "  CONSTRAINT `fk_users_roles1`" +
                    "    FOREIGN KEY (`roles_id`)" +
                    "    REFERENCES `vchernetski`.`roles` (`id`)" +
                    "    ON DELETE NO ACTION" +
                    "    ON UPDATE NO ACTION)" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `vchernetski`.`garages` (" +
                    "  `id` INT NOT NULL AUTO_INCREMENT," +
                    "  `adress` VARCHAR(100) NULL," +
                    "  `carplaces` INT NULL," +
                    "  `users_id` INT NOT NULL," +
                    "  PRIMARY KEY (`id`, `users_id`)," +
                    "  INDEX `fk_garages_users1_idx` (`users_id` ASC)," +
                    "  CONSTRAINT `fk_garages_users1`" +
                    "    FOREIGN KEY (`users_id`)" +
                    "    REFERENCES `vchernetski`.`users` (`id`)" +
                    "    ON DELETE CASCADE" +
                    "    ON UPDATE CASCADE)" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `vchernetski`.`cars` (" +
                    "  `id` INT NOT NULL AUTO_INCREMENT," +
                    "  `model` VARCHAR(100) NOT NULL," +
                    "  `color` VARCHAR(100) NULL," +
                    "  `year` INT NULL," +
                    "  `garages_id` INT NOT NULL," +
                    "  PRIMARY KEY (`id`, `model`)," +
                    "  CONSTRAINT `fk_cars_garages1`" +
                    "    FOREIGN KEY (`garages_id`)" +
                    "    REFERENCES `vchernetski`.`garages` (`id`)" +
                    "    ON DELETE NO ACTION" +
                    "    ON UPDATE NO ACTION)" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("INSERT INTO `vchernetski`.`roles` (`id`, `role`) VALUES (DEFAULT, 'admin');");
            statement.executeUpdate("INSERT INTO `vchernetski`.`roles` (`id`, `role`) VALUES (DEFAULT, 'user');");
            statement.executeUpdate("INSERT INTO `vchernetski`.`roles` (`id`, `role`) VALUES (DEFAULT, 'guest');");
            statement.executeUpdate("INSERT INTO `vchernetski`.`users` (`id`, `fio`, `numbergarages`, `nickname`, `email`, `password`, `roles_id`) VALUES (DEFAULT, 'Ivan Ivanovich Ivanov', 2, 'ivanich', 'ivanich@mail.ru', 'user', 2);");
            statement.executeUpdate("INSERT INTO `vchernetski`.`users` (`id`, `fio`, `numbergarages`, `nickname`, `email`, `password`, `roles_id`) VALUES (DEFAULT, 'Petr Petrovich Petrov', 0, 'petya', 'petya@yandex.ru', 'admin', 1);");
            statement.executeUpdate("INSERT INTO `vchernetski`.`users` (`id`, `fio`, `numbergarages`, `nickname`, `email`, `password`, `roles_id`) VALUES (DEFAULT, 'Vasilii Vasil\\'evich Vasil\\'ev', 0, 'vasya', 'vasya@gmail.com', 'guest', 3);");
            statement.executeUpdate("INSERT INTO `vchernetski`.`garages` (`id`, `adress`, `carplaces`, `users_id`) VALUES (DEFAULT, 'Minsk, Lenina 3', 2, 1);");
            statement.executeUpdate("INSERT INTO `vchernetski`.`garages` (`id`, `adress`, `carplaces`, `users_id`) VALUES (DEFAULT, 'Minsk, Moskovskaya 17', 1, 1);");
            statement.executeUpdate("INSERT INTO `vchernetski`.`cars` (`id`, `model`, `color`, `year`, `garages_id`) VALUES (DEFAULT, 'BMW X5', 'white', 2015, 1);");
            statement.executeUpdate("INSERT INTO `vchernetski`.`cars` (`id`, `model`, `color`, `year`, `garages_id`) VALUES (DEFAULT, 'Range Rover Sport', 'black', 2012, 1);");
            statement.executeUpdate("INSERT INTO `vchernetski`.`cars` (`id`, `model`, `color`, `year`, `garages_id`) VALUES (DEFAULT, 'Audi A4', 'blue', 2018, 2);");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
