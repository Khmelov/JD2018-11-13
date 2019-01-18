package by.it.markelov.jd03_01;

import java.sql.*;

public class ToConsole {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:2016/", "root", "")) {
            Statement statement = connection.createStatement();

            System.out.println("Users and their priorities");

            ResultSet resultSet = statement.executeQuery("SELECT * FROM `markelov`.`users`;");
            while (resultSet.next()) {
                String out = resultSet.getString("Login") + ", " + resultSet.getString("roles_ID");
                System.out.println(out);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
