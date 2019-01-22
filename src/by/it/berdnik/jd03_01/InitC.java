package by.it.berdnik.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InitC {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:2016/", "root", ""))
        {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DROP SCHEMA IF EXISTS `berdnik`");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `berdnik` DEFAULT CHARACTER SET utf8");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `berdnik`.`roles` (\n" +
                    "  `idroles` INT NOT NULL AUTO_INCREMENT," +
                    "  `role` VARCHAR(45) NULL," +
                    "  PRIMARY KEY (`idroles`))" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `berdnik`.`users` (\n" +
                    "  `idusers` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `nickname` VARCHAR(45) NULL,\n" +
                    "  `password` VARCHAR(45) NULL,\n" +
                    "  `e-mail` VARCHAR(45) NULL,\n" +
                    "  `roles_idroles` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`idusers`),\n" +
                    "  INDEX `fk_users_roles1_idx` (`roles_idroles` ASC),\n" +
                    "  CONSTRAINT `fk_users_roles1`\n" +
                    "    FOREIGN KEY (`roles_idroles`)\n" +
                    "    REFERENCES `berdnik`.`roles` (`idroles`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT)\n" +
                    "ENGINE = InnoDB;\n");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `berdnik`.`buyers` (\n" +
                    "  `idbuyers` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `item` VARCHAR(500) NULL,\n" +
                    "  `id_item` INT NULL,\n" +
                    "  `floor` INT NULL,\n" +
                    "  `specif` VARCHAR(2000) NULL,\n" +
                    "  `price` INT NULL,\n" +
                    "  `address` VARCHAR(1000) NULL,\n" +
                    "  `users_idusers` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`idbuyers`),\n" +
                    "  INDEX `fk_buyers_users1_idx` (`users_idusers` ASC),\n" +
                    "  CONSTRAINT `fk_buyers_users1`\n" +
                    "    FOREIGN KEY (`users_idusers`)\n" +
                    "    REFERENCES `berdnik`.`users` (`idusers`)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE CASCADE)\n" +
                    "ENGINE = InnoDB;\n");
            statement.executeUpdate("INSERT INTO `berdnik`.`roles` (`idroles`, `role`) VALUES (DEFAULT, 'admin');");
            statement.executeUpdate("INSERT INTO `berdnik`.`roles` (`idroles`, `role`) VALUES (DEFAULT, 'user');");
            statement.executeUpdate("INSERT INTO `berdnik`.`users` (`idusers`, `nickname`, `password`, `e-mail`, `roles_idroles`) VALUES (DEFAULT, 'admin', 'admin', 'admin@mail.ru', 1);");
            statement.executeUpdate("INSERT INTO `berdnik`.`users` (`idusers`, `nickname`, `password`, `e-mail`, `roles_idroles`) VALUES (DEFAULT, 'user', 'user', 'user@mail.ru', 2);");
            statement.executeUpdate("INSERT INTO `berdnik`.`buyers` (`idbuyers`, `item`, `id_item`, `specif`, `price`, `address`, `users_idusers`) VALUES (DEFAULT, 'MSI GE73 8RF-096XRU Raider RGB', 8096, '17.3\\\" 1920 x 1080 IPS, Intel i7 8750H, 16 ГБ, HDD 1000 ГБ, NVIDIA GTX 1070 8 ГБ', 3868, 'Minsk Street 1-1', 2);");
            statement.executeUpdate("INSERT INTO `berdnik`.`buyers` (`idbuyers`, `item`, `id_item`, `specif`, `price`, `address`, `users_idusers`) VALUES (DEFAULT, 'Dell G3 17 3779 G317-7664', 3779, '17.3\\\" 1920 x 1080 IPS, Intel i7 8750H, 16 ГБ, HDD+SSD 2000+256 ГБ, NVIDIA GTX 1060 6 ГБ', 3068, 'Minsk Street 2-2', 2);");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
