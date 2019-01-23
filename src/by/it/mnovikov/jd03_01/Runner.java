package by.it.mnovikov.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Runner {
    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB)) {
            Statement statement = connection.createStatement();
            C_Init.createDB(statement);
            System.out.println("-------------------");
            C_Reset.deleteTables(statement);
            System.out.println("-------------------");
            C_Reset.dropTables(statement);
            System.out.println("-------------------");
            C_Reset.deleteDB(statement);
            System.out.println("-------------------");
            C_Init.createDB(statement);

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}