package by.it.lobkova.jd03_02.crud;

import by.it.lobkova.jd03_02.beans.Task;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TaskCRUD {

    boolean create(Task task) throws SQLException {
        String sql = String.format(
                "INSERT INTO `tasks` (`name_task`, `description_task`, `date`, `goals_ID`) VALUES ('%s', '%s', '%d', '%d')",
                task.getName_task(), task.getDescription_task(), task.getDate(), task.getGoals_ID()
        );
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            if (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    task.setId(generatedKeys.getLong(1));
                }
                return true;
            }
        }
        return false;
    }

    boolean delete(Task task) throws SQLException {
        String sql = String.format(
                "DELETE FROM `tasks` WHERE `tasks`.`id` = %d",
                task.getId()
        );
        try (Connection connection = Connect.getConnection();

             Statement statement = connection.createStatement()) {
            return (1 == statement.executeUpdate(sql));
        }
    }

    boolean update(Task task) throws SQLException {
        String sql = String.format(
                "UPDATE `tasks` SET `name_task` = '%s', `description_task` = '%s', `date` = '%s', `goals_ID` = '%d' WHERE `tasks`.`id` = '%d'",
                task.getName_task(), task.getDescription_task(),
                task.getDate(), task.getId(), task.getGoals_ID()
        );
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            return (1 == statement.executeUpdate(sql));
        }
    }

    Task read(long id) throws SQLException {
        String sql = String.format("SELECT `id`, `name_task`, `description_task`, `date`, `goals_ID`" +
                "FROM `tasks` WHERE id=%d", id);
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                //id ok
                String name_task = resultSet.getString("name_task");
                String description_task = resultSet.getString("description_task");
                long date = resultSet.getLong("date");
                long goals_ID = resultSet.getLong("goals_ID");
                return new Task(id, name_task, description_task, date, goals_ID);
            } else
                return null;
        }

    }
}
