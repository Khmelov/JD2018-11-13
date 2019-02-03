package by.it.karnilava.jd03_02;

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
            statement.executeUpdate("DROP SCHEMA IF EXISTS `karnilavaTest`");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `karnilavaTest` DEFAULT CHARACTER SET utf8 ");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `karnilavaTest`.`Roles` (\n" +
                    "  `idRoles` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `Roles` VARCHAR(45) NULL,\n" +
                    "  PRIMARY KEY (`idRoles`))\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `karnilavaTest`.`Client` (\n" +
                    "  `idClient` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `ID passport` VARCHAR(45) NULL,\n" +
                    "  `first name` VARCHAR(50) NULL,\n" +
                    "  `last name` VARCHAR(50) NULL,\n" +
                    "  `password` VARCHAR(45) NULL,\n" +
                    "  `Roles_idRoles` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`idClient`),\n" +
                    "  UNIQUE INDEX `ID passport_UNIQUE` (`ID passport` ASC),\n" +
                    "  INDEX `fk_Client_Roles1_idx` (`Roles_idRoles` ASC),\n" +
                    "  CONSTRAINT `fk_Client_Roles1`\n" +
                    "    FOREIGN KEY (`Roles_idRoles`)\n" +
                    "    REFERENCES `karnilavaTest`.`Roles` (`idRoles`)\n" +
                    "    ON DELETE NO ACTION\n" +
                    "    ON UPDATE NO ACTION)\n" +
                    "ENGINE = InnoDB;\n");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `karnilavaTest`.`Type of account` (\n" +
                    "  `idType of account` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `Type` VARCHAR(45) NULL,\n" +
                    "  PRIMARY KEY (`idType of account`))\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `karnilavaTest`.`State options` (\n" +
                    "  `idState options` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `State optionscol` VARCHAR(45) NULL,\n" +
                    "  PRIMARY KEY (`idState options`))\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `karnilavaTest`.`Account features` (\n" +
                    "  `idAccounts` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `Number` VARCHAR(50) NULL,\n" +
                    "  `Balance` VARCHAR(45) NULL,\n" +
                    "  `Client_idClient` INT NOT NULL,\n" +
                    "  `Type of account_idType of account` INT NOT NULL,\n" +
                    "  `State options_idState options` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`idAccounts`, `Type of account_idType of account`),\n" +
                    "  INDEX `fk_Account features_Client1_idx` (`Client_idClient` ASC),\n" +
                    "  INDEX `fk_Account features_Type of account1_idx` (`Type of account_idType of account` ASC),\n" +
                    "  INDEX `fk_Account features_State options1_idx` (`State options_idState options` ASC),\n" +
                    "  CONSTRAINT `fk_Account features_Client1`\n" +
                    "    FOREIGN KEY (`Client_idClient`)\n" +
                    "    REFERENCES `karnilavaTest`.`Client` (`idClient`)\n" +
                    "    ON DELETE NO ACTION\n" +
                    "    ON UPDATE NO ACTION,\n" +
                    "  CONSTRAINT `fk_Account features_Type of account1`\n" +
                    "    FOREIGN KEY (`Type of account_idType of account`)\n" +
                    "    REFERENCES `karnilavaTest`.`Type of account` (`idType of account`)\n" +
                    "    ON DELETE NO ACTION\n" +
                    "    ON UPDATE NO ACTION,\n" +
                    "  CONSTRAINT `fk_Account features_State options1`\n" +
                    "    FOREIGN KEY (`State options_idState options`)\n" +
                    "    REFERENCES `karnilavaTest`.`State options` (`idState options`)\n" +
                    "    ON DELETE NO ACTION\n" +
                    "    ON UPDATE NO ACTION)\n" +
                    "ENGINE = InnoDB\n" +
                    "ROW_FORMAT = DEFAULT;");

            statement.executeUpdate("INSERT INTO `karnilavaTest`.`Roles` (`idRoles`, `Roles`) VALUES (1, 'Client');");
            statement.executeUpdate("INSERT INTO `karnilavaTest`.`Roles` (`idRoles`, `Roles`) VALUES (2, 'Admin');");
            statement.executeUpdate("INSERT INTO `karnilavaTest`.`Client` (`idClient`, `ID passport`, `first name`, `last name`, `password`, `Roles_idRoles`) VALUES (1, '3050992E011PB0', 'Natallia', 'Karnilava', '12345natasha', 1);");
            statement.executeUpdate("INSERT INTO `karnilavaTest`.`Type of account` (`idType of account`, `Type`) VALUES (1, 'Credit');");
            statement.executeUpdate("INSERT INTO `karnilavaTest`.`Type of account` (`idType of account`, `Type`) VALUES (2, 'Deposit');");
            statement.executeUpdate("INSERT INTO `karnilavaTest`.`Type of account` (`idType of account`, `Type`) VALUES (3, 'Current');");
            statement.executeUpdate("INSERT INTO `karnilavaTest`.`State options` (`idState options`, `State optionscol`) VALUES (1, 'Open');");
            statement.executeUpdate("INSERT INTO `karnilavaTest`.`State options` (`idState options`, `State optionscol`) VALUES (2, 'Blocked');");
            statement.executeUpdate("INSERT INTO `karnilavaTest`.`State options` (`idState options`, `State optionscol`) VALUES (3, 'Closed');");
            statement.executeUpdate("INSERT INTO `karnilavaTest`.`Account features` (`idAccounts`, `Number`, `Balance`, `Client_idClient`, `Type of account_idType of account`, `State options_idState options`) VALUES (1, '3014456789001', '100', 1, 3, 1);");
            statement.executeUpdate("INSERT INTO `karnilavaTest`.`Account features` (`idAccounts`, `Number`, `Balance`, `Client_idClient`, `Type of account_idType of account`, `State options_idState options`) VALUES (2, '3012456789002', '300', 1, 2, 1);");
            statement.executeUpdate("INSERT INTO `karnilavaTest`.`Account features` (`idAccounts`, `Number`, `Balance`, `Client_idClient`, `Type of account_idType of account`, `State options_idState options`) VALUES (3, '3011456789002', '0', 1, 1, 3);");


        } catch (
                SQLException e) {
            e.printStackTrace();
        }
    }
}

