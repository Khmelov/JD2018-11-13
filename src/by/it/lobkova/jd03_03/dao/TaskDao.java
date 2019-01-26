package by.it.lobkova.jd03_03.dao;

import by.it.lobkova.jd03_03.beans.Task;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TaskDao implements IDao<Task> {

    @Override
    public boolean create(Task task) throws SQLException {
        String sql = String.format(
                "INSERT INTO `tasks` (`name_task`, `description_task`, `date`, `goals_ID`) VALUES ('%s', '%s', '%d', '%d')",
                task.getName_task(), task.getDescription_task(), task.getDate(), task.getGoals_ID()
        );
        long id = Dao.executeCreateAndGetId(sql);
        task.setId(id);
        return (id > 0);
    }

    @Override
    public boolean update(Task task) throws SQLException {
        String sql = String.format(
                "UPDATE `tasks` SET `name_task` = '%s', `description_task` = '%s', `date` = '%s', `goals_ID` = '%d' WHERE `tasks`.`id` = '%d'",
                task.getName_task(), task.getDescription_task(),
                task.getDate(), task.getId(), task.getGoals_ID()
        );
        return Dao.executeUpdate(sql);
    }

    @Override
    public boolean delete(Task task) throws SQLException {
        String sql = String.format(
                "DELETE FROM `tasks` WHERE `tasks`.`id` = %d",
                task.getId()
        );
        return Dao.executeUpdate(sql);
    }

    @Override
    public Task read(long id) throws SQLException {
        String sqlSuffix = String.format("WHERE id=%d", id);
        List<Task> all = getAll(sqlSuffix);
        return all.size() > 0 ? all.get(0) : null;
    }

    @Override
    public List<Task> getAll(String sql) throws SQLException {
        List<Task> result = new ArrayList<>();
        String sqlSufix = String.format("SELECT `id`, `name_task`, `description_task`, `date`, `goals_ID`" +
                "FROM `tasks` %s", sql);
        Connection connection = Connect.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlSufix);
        while (resultSet.next()) {
            long id = resultSet.getLong("id");
            String name_task = resultSet.getString("name_task");
            String description_task = resultSet.getString("description_task");
            long date = resultSet.getLong("date");
            long goals_ID = resultSet.getLong("goals_ID");
            Task task = new Task(id, name_task, description_task, date, goals_ID);
            result.add(task);
        }
        return result;
    }
}
