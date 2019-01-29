package by.it.mnovikov.jd03_02.crud;

import java.sql.SQLException;
import java.sql.Statement;

public class ResetDB {
    public static void dropTables(Statement statement) throws SQLException {
        statement.executeUpdate("DROP TABLE IF EXISTS `mnovikov`.`orders_goods`");
        statement.executeUpdate("DROP TABLE IF EXISTS `mnovikov`.`goods`");
        statement.executeUpdate("DROP TABLE IF EXISTS `mnovikov`.`orders`");
        statement.executeUpdate("DROP TABLE IF EXISTS `mnovikov`.`users`");
        statement.executeUpdate("DROP TABLE IF EXISTS `mnovikov`.`roles`");
        System.out.println("Delete all tables");
    }

    public static void createDB(Statement statement) throws SQLException {
        statement.executeUpdate("DROP SCHEMA IF EXISTS `mnovikov`");
        statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `mnovikov` DEFAULT CHARACTER SET utf8");
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS `mnovikov`.`roles` (" +
                "  `ID` INT NOT NULL AUTO_INCREMENT," +
                "  `role` VARCHAR(50) NULL," +
                "  PRIMARY KEY (`ID`))" +
                "ENGINE = InnoDB");
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS `mnovikov`.`users` (" +
                "  `ID` INT NOT NULL AUTO_INCREMENT," +
                "  `login` VARCHAR(45) NULL," +
                "  `password` VARCHAR(45) NULL," +
                "  `email` VARCHAR(45) NULL," +
                "  `first_name` VARCHAR(45) NULL," +
                "  `last_name` VARCHAR(45) NULL," +
                "  `birthday` TIMESTAMP(6) NULL," +
                "  `adress` VARCHAR(500) NULL," +
                "  `roles_ID` INT NOT NULL," +
                "    PRIMARY KEY (`ID`)," +
                "  INDEX `fk_users_roles_idx` (`roles_ID` ASC)," +
                "  UNIQUE INDEX `login_UNIQUE` (`login` ASC)," +
                "  UNIQUE INDEX `email_UNIQUE` (`email` ASC)," +
                "  CONSTRAINT `fk_users_roles`" +
                "    FOREIGN KEY (`roles_ID`)" +
                "    REFERENCES `mnovikov`.`roles` (`ID`)" +
                "    ON DELETE RESTRICT" +
                "    ON UPDATE RESTRICT)" +
                "ENGINE = InnoDB;");
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS `mnovikov`.`orders` (\n" +
                "  `ID` INT NOT NULL AUTO_INCREMENT,\n" +
                "  `date` TIMESTAMP(6) NULL,\n" +
                "  `users_ID` INT NOT NULL,\n" +
                "  PRIMARY KEY (`ID`),\n" +
                "  INDEX `fk_orders_users1_idx` (`users_ID` ASC),\n" +
                "  CONSTRAINT `fk_orders_users1`\n" +
                "    FOREIGN KEY (`users_ID`)\n" +
                "    REFERENCES `mnovikov`.`users` (`ID`)\n" +
                "    ON DELETE CASCADE\n" +
                "    ON UPDATE CASCADE)\n" +
                "ENGINE = InnoDB");
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS `mnovikov`.`goods` (" +
                "  `ID` INT NOT NULL AUTO_INCREMENT," +
                "  `title` VARCHAR(45) NULL," +
                "  `discription` VARCHAR(2000) NULL," +
                "  `type` VARCHAR(45) NULL," +
                "  `productivity` DOUBLE NULL," +
                "  `price` DOUBLE NULL," +
                "  PRIMARY KEY (`ID`))" +
                "ENGINE = InnoDB");
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS `mnovikov`.`orders_goods` (" +
                "  `orders_ID` INT NOT NULL," +
                "  `goods_ID` INT NOT NULL," +
                "  INDEX `fk_orders_goods_orders1_idx` (`orders_ID` ASC)," +
                "  INDEX `fk_orders_goods_goods1_idx` (`goods_ID` ASC)," +
                "  CONSTRAINT `fk_orders_goods_orders1`" +
                "    FOREIGN KEY (`orders_ID`)" +
                "    REFERENCES `mnovikov`.`orders` (`ID`)" +
                "    ON DELETE CASCADE" +
                "    ON UPDATE CASCADE," +
                "  CONSTRAINT `fk_orders_goods_goods1`" +
                "    FOREIGN KEY (`goods_ID`)" +
                "    REFERENCES `mnovikov`.`goods` (`ID`)" +
                "    ON DELETE CASCADE" +
                "    ON UPDATE CASCADE)" +
                "ENGINE = InnoDB");

        //наполнение таблицы ролей
        statement.executeUpdate("INSERT INTO `mnovikov`.`roles` (`ID`, `role`) VALUES (DEFAULT, 'Administrator')");
        statement.executeUpdate("INSERT INTO `mnovikov`.`roles` (`ID`, `role`) VALUES (DEFAULT, 'Customer')");

        //наполнение таблицы пользователей
        statement.executeUpdate("INSERT INTO `mnovikov`.`users`" +
                "(`ID`, `login`, `password`, `email`," +
                "`first_name`, `last_name`, `birthday`, `adress`, `roles_ID`) VALUES" +
                "(DEFAULT, 'Administrator', 'root111', 'admin@mail.ru'," +
                "'Maksim', 'Novikov', '1986-02-12 11:0:00', 'Minsk, Knorina 1', 1)");
        statement.executeUpdate("INSERT INTO `mnovikov`.`users`" +
                "(`ID`, `login`, `password`, `email`," +
                "`first_name`, `last_name`, `birthday`, `adress`, `roles_ID`) VALUES" +
                "(DEFAULT, 'customer_01', 'qwerty', 'cus_01@mail.ru'," +
                "'Pavel', 'Derevyanko', '1980-01-01 12:00:30', 'Minsk, Lenina 1/5', 2)");

        //наполнение таблицы заказов
        statement.executeUpdate("INSERT INTO `mnovikov`.`orders`" +
                "(`ID`, `date`, `users_ID`) VALUES(DEFAULT, '2019-01-20 20:18:55', 2)");
        statement.executeUpdate("INSERT INTO `mnovikov`.`orders`" +
                "(`ID`, `date`, `users_ID`) VALUES (DEFAULT, '2019-01-21 21:11:51', 2)");

        //наполнение таблицы товаров
        statement.executeUpdate("INSERT INTO `mnovikov`.`goods`" +
                "(`ID`, `title`, `discription`," +
                "`type`, `productivity`, `price`) VALUES" +
                "(DEFAULT, 'Nietfeld Speedprobe', 'Speedprob is a towed work implement for extracting soil samples at a depth of 12-30 cm at a travelling speed of 8-12 km/hr., depending on the soil type and properties.'," +
                "'auto', 16.8, 7000.67)");
        statement.executeUpdate("INSERT INTO `mnovikov`.`goods`" +
                "(`ID`, `title`, `discription`," +
                "`type`, `productivity`, `price`)" +
                "VALUES (DEFAULT, 'Nietfeld BOPROB', 'BOPROB is a towed work implement for extracting soil samples at a depth of 10-30 cm at a travelling speed of 3-12 km/hr., depending on the soil type and properties.'," +
                "'mauto', 15.3, 8000.5)");

        //наполнение таблицы товар-заказ
        statement.executeUpdate("INSERT INTO `mnovikov`.`orders_goods` (`orders_ID`, `goods_ID`) VALUES (1, 1)");
        statement.executeUpdate("INSERT INTO `mnovikov`.`orders_goods` (`orders_ID`, `goods_ID`) VALUES (1, 2)");
        statement.executeUpdate("INSERT INTO `mnovikov`.`orders_goods` (`orders_ID`, `goods_ID`) VALUES (2, 1)");

        System.out.println("DB created");
    }

}
