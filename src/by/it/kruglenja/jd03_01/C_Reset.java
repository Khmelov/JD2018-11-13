package by.it.kruglenja.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class C_Reset {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:2016/", "root", "")) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DROP SCHEMA IF EXISTS `kruglenja` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `kruglenja`.`users` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `kruglenja`.`roles` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `kruglenja`.`order` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `kruglenja`.`sparePart` ;");
            System.out.println("DB deleted");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}