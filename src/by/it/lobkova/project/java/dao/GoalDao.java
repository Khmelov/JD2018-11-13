package by.it.lobkova.project.java.dao;

import by.it.lobkova.project.java.beans.Goal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GoalDao implements IDao<Goal> {

    @Override
    public boolean create(Goal goal) throws SQLException {
        String sql = String.format(
                "INSERT INTO `goals` (`name_goal`, `description_goal`, `beginDate`, `endDate`, `users_ID`) VALUES ('%s', '%s', '%d', '%d', ''%d)",
                goal.getName_goal(), goal.getDescription_goal(), goal.getBeginDate(), goal.getEndDate(), goal.getUser_id()
        );
        long id = Dao.executeCreateAndGetId(sql);
        goal.setId(id);
        return (id > 0);
    }

    @Override
    public boolean update(Goal goal) throws SQLException {
        String sql = String.format(
                "UPDATE `goals` SET `name_goal` = '%s', `description_goal` = '%s', `beginDate` = '%s', `endDate`, `users_ID` = '%d' WHERE `goals`.`id` = '%d'",
                goal.getName_goal(), goal.getDescription_goal(), goal.getBeginDate(), goal.getEndDate(), goal.getUser_id()
        );
        return Dao.executeUpdate(sql);
    }

    @Override
    public boolean delete(Goal goal) throws SQLException {
        String sql = String.format(
                "DELETE FROM `goals` WHERE `goals`.`id` = %d",
                goal.getId()
        );
        return Dao.executeUpdate(sql);
    }

    @Override
    public Goal read(long id) throws SQLException {
        String sqlSuffix = String.format("WHERE id=%d", id);
        List<Goal> all = getAll(sqlSuffix);
        return all.size() > 0 ? all.get(0) : null;
    }

    @Override
    public List<Goal> getAll(String sql) throws SQLException {
        List<Goal> result = new ArrayList<>();
        String sqlSufix = String.format("SELECT `id`, `name_goal`, `description_goal`, `beginDate`, `endDate`, `users_ID`" +
                "FROM `goals` %s", sql);
        Connection connection = Connect.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlSufix);
        while (resultSet.next()) {
            long id = resultSet.getLong("id");
            String name_goal = resultSet.getString("name_goal");
            String description_goal = resultSet.getString("description_goal");
            long beginDate = resultSet.getLong("BeginDate");
            long endDate = resultSet.getLong("BeginDate");
            long users_ID = resultSet.getLong("users_ID");
            Goal goal = new Goal(id, name_goal, description_goal, beginDate, endDate, users_ID);
            result.add(goal);
        }
        return result;
    }
}
