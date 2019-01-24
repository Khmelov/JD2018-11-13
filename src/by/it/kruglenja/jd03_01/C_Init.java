package by.it.kruglenja.jd03_01;

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

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:2016/", "root", "")) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DROP SCHEMA IF EXISTS `kruglenja` ;");

            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `kruglenja` DEFAULT CHARACTER SET utf8 ;");

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `kruglenja`.`roles` (" +
                    "  `id` INT NOT NULL AUTO_INCREMENT," +
                    "  `role` VARCHAR(100) NULL," +
                    "  PRIMARY KEY (`id`))" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `kruglenja`.`users` (" +
                    "  `id` INT NOT NULL AUTO_INCREMENT," +
                    "  `login` VARCHAR(45) NULL DEFAULT NULL," +
                    "  `password` VARCHAR(45) NULL DEFAULT NULL," +
                    "  `email` VARCHAR(45) NULL DEFAULT NULL," +
                    "  `phone_number` VARCHAR(45) NULL DEFAULT NULL," +
                    "  `roles_id1` INT NOT NULL," +
                    "  PRIMARY KEY (`id`)," +
                    "  INDEX `fk_users_roles1_idx` (`roles_id1` ASC)," +
                    "  CONSTRAINT `fk_users_roles1`" +
                    "    FOREIGN KEY (`roles_id1`)" +
                    "    REFERENCES `kruglenja`.`roles` (`id`)" +
                    "    ON DELETE RESTRICT" +
                    "    ON UPDATE RESTRICT)" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `kruglenja`.`order` (" +
                    "  `id` INT NOT NULL AUTO_INCREMENT," +
                    "  `quanity` INT NULL," +
                    "  `deliveryTime` INT NULL," +
                    "  `totalPrice` INT NULL," +
                    "  `users_id` INT NOT NULL," +
                    "  PRIMARY KEY (`id`)," +
                    "  INDEX `fk_order_users1_idx` (`users_id` ASC)," +
                    "  CONSTRAINT `fk_order_users1`" +
                    "    FOREIGN KEY (`users_id`)" +
                    "    REFERENCES `kruglenja`.`users` (`id`)" +
                    "    ON DELETE NO ACTION" +
                    "    ON UPDATE NO ACTION)" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `kruglenja`.`sparePart` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `model` VARCHAR(45) NULL DEFAULT NULL,\n" +
                    "  `category` VARCHAR(45) NULL DEFAULT NULL,\n" +
                    "  `name` VARCHAR(45) NULL DEFAULT NULL,\n" +
                    "  `serial_number` BIGINT NULL DEFAULT NULL,\n" +
                    "  `weigth` VARCHAR(45) NULL DEFAULT NULL,\n" +
                    "  `price` INT NULL DEFAULT NULL,\n" +
                    "  `order_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_sparePart_order1_idx` (`order_id` ASC),\n" +
                    "  CONSTRAINT `fk_sparePart_order1`\n" +
                    "    FOREIGN KEY (`order_id`)\n" +
                    "    REFERENCES `kruglenja`.`order` (`id`)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE CASCADE)\n" +
                    "ENGINE = InnoDB;");

            statement.executeUpdate("INSERT INTO `kruglenja`.`roles` (`id`, `role`) VALUES (DEFAULT, 'administrator');");
            statement.executeUpdate("INSERT INTO `kruglenja`.`roles` (`id`, `role`) VALUES (DEFAULT, 'user');");
            statement.executeUpdate("INSERT INTO `kruglenja`.`roles` (`id`, `role`) VALUES (DEFAULT, 'guest');");
            statement.executeUpdate("INSERT INTO `kruglenja`.`users` (`id`, `login`, `password`, `email`, `phone_number`, `roles_id1`) VALUES (DEFAULT, 'user', 'user', 'user@user', '+9849871891789', 2);");
            statement.executeUpdate("INSERT INTO `kruglenja`.`users` (`id`, `login`, `password`, `email`, `phone_number`, `roles_id1`) VALUES (DEFAULT, 'user', 'user', 'user@user', '+9849871891789', 2);");
            statement.executeUpdate("INSERT INTO `kruglenja`.`order` (`id`, `quanity`, `deliveryTime`, `totalPrice`, `users_id`) VALUES (6, 12, 15, 1024, 2);");
            statement.executeUpdate("INSERT INTO `kruglenja`.`order` (`id`, `quanity`, `deliveryTime`, `totalPrice`, `users_id`) VALUES (8, 12, 44, 444, 1);");
            statement.executeUpdate("INSERT INTO `kruglenja`.`sparePart` (`id`, `model`, `category`, `name`, `serial_number`, `weigth`, `price`, `order_id`) VALUES (4, 'Mazda', 'engine', 'engine', 051871051184, '12', 1024, 8);");
            statement.executeUpdate("INSERT INTO `kruglenja`.`sparePart` (`id`, `model`, `category`, `name`, `serial_number`, `weigth`, `price`, `order_id`) VALUES (5, 'Ford', 'motor', 'motor', 214045204524, '352', 41233, 6);");
            System.out.println("DB created");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
