package by.it.lobkova.jd03_02.crud;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TaskA {
    public static void main(String[] args) throws SQLException {
        String task = "user5";
        String sql = String.format("SELECT `id`,`name_task` FROM `tasks` WHERE `name_task` = '%s'", task);
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            System.out.println("Tasks:");
            while (resultSet.next()) {
                System.out.printf("id = %d   ", resultSet.getLong(1));
                System.out.printf("name_task = %s ", resultSet.getString(2));
                System.out.println();
            }
    } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
