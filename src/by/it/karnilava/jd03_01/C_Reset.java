package by.it.karnilava.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class C_Reset {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (
                Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:2016/", "root", "")) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DROP TABLE IF EXISTS `karnilavaTest`.`Account features` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `karnilavaTest`.`State options` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `karnilavaTest`.`Type of account` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `karnilavaTest`.`Client` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `karnilavaTest`.`Roles` ;");
            statement.executeUpdate("DROP SCHEMA IF EXISTS `karnilavaTest` ;");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

