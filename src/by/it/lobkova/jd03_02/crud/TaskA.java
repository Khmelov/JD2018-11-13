package by.it.lobkova.jd03_02.crud;

import by.it.lobkova.jd03_02.beans.Task;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TaskA {
    public static void main(String[] args) {
        String task = "user5";
        String sql = String.format("SELECT `id` FROM `tasks` WHERE `name_task`=%s", task);
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            Task task1 = new Task();
            if (resultSet.next()) {
                task1.setId(resultSet.getInt(1));
                task1.setName_task(resultSet.getString(2));
                task1.setDescription_task(resultSet.getString(3));
                task1.setDate(resultSet.getLong(4));
                task1.setGoals_ID(resultSet.getLong(5));
                System.out.println(task1);
            }
    } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
