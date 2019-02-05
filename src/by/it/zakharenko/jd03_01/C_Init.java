package by.it.zakharenko.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class C_Init {
    static void createDatabase(Statement statement) throws SQLException {

            statement.executeUpdate("DROP SCHEMA IF EXISTS `zakharnk`");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `zakharnk` DEFAULT CHARACTER SET utf8");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `zakharnk`.`roles` (" +
                    "  `id` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                    "  `role` VARCHAR(100) NOT NULL,\n" +
                    "  PRIMARY KEY (`id`))\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `zakharnk`.`clients` (\n" +
                    "  `id` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                    "  `e-mail` VARCHAR(50) NULL,\n" +
                    "  `login` VARCHAR(50) NULL DEFAULT NULL,\n" +
                    "  `password` VARCHAR(50) NULL DEFAULT NULL,\n" +
                    "  `phone_number` VARCHAR(50) NULL DEFAULT NULL,\n" +
                    "  `roles_id` INT(11) NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_clients_roles1_idx` (`roles_id` ASC),\n" +
                    "  CONSTRAINT `fk_clients_roles1`\n" +
                    "    FOREIGN KEY (`roles_id`)\n" +
                    "    REFERENCES `zakharnk`.`roles` (`id`)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE RESTRICT)\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `zakharnk`.`orders` (\n" +
                    "  `id` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                    "  `name` VARCHAR(50) NULL DEFAULT NULL,\n" +
                    "  `item` VARCHAR(100) NULL DEFAULT NULL,\n" +
                    "  `item_id` INT(11) NOT NULL,\n" +
                    "  `colour` VARCHAR(50) NULL DEFAULT NULL,\n" +
                    "  `price` DOUBLE NULL DEFAULT NULL,\n" +
                    "  `address` VARCHAR(100) NULL DEFAULT NULL,\n" +
                    "  `clients_id` INT(11) NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_orders_clients_idx` (`clients_id` ASC),\n" +
                    "  CONSTRAINT `fk_orders_clients`\n" +
                    "    FOREIGN KEY (`clients_id`)\n" +
                    "    REFERENCES `zakharnk`.`clients` (`id`)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE RESTRICT)\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("INSERT INTO `zakharnk`.`roles` (`id`, `role`) VALUES (DEFAULT, 'admin');");
            statement.executeUpdate("INSERT INTO `zakharnk`.`roles` (`id`, `role`) VALUES (DEFAULT, 'client');");
            statement.executeUpdate("INSERT INTO `zakharnk`.`roles` (`id`, `role`) VALUES (DEFAULT, 'guest');");
            statement.executeUpdate("INSERT INTO `zakharnk`.`clients` (`id`, `e-mail`, `login`, `password`, `phone_number`, `roles_id`) VALUES (DEFAULT, 'admin@gmail.com', 'admin', 'admin', '+375297658895', 1);");
            statement.executeUpdate("INSERT INTO `zakharnk`.`clients` (`id`, `e-mail`, `login`, `password`, `phone_number`, `roles_id`) VALUES (DEFAULT, 'lizazakharenko@gmail.com', 'liza', 'liza', '+375297658895', 2);");
            statement.executeUpdate("INSERT INTO `zakharnk`.`orders` (`id`, `name`, `item`, `item_id`, `colour`, `price`, `address`, `clients_id`) VALUES (DEFAULT, 'Vacuum cleaner', 'Samsung SC5241', 1234, 'grey', 129, 'Minsk, Rokossovskogo ave, 145-173', 2);");
            statement.executeUpdate("INSERT INTO `zakharnk`.`orders` (`id`, `name`, `item`, `item_id`, `colour`, `price`, `address`, `clients_id`) VALUES (DEFAULT, 'Washing machine', 'LG F2J5HS3W', 1253, 'white', 799, 'Minsk, Rokossovskogo ave, 145-173', 2);");
    }
}
