package by.it.lobkova.jd03_03.dao;

import by.it.lobkova.jd03_03.beans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements IDao<User> {

    public boolean create(User user) throws SQLException {
        String sql = String.format(
                "INSERT INTO `lobkova`.`users` (`email`,`login`, `password`, `name`,  `roles_ID`) " +
                        "VALUES ('%s', '%s', '%s', '%s', '%d')",
                user.getEmail(), user.getLogin(), user.getPassword(), user.getName(), user.getRoles_id()
        );
        long id = Dao.executeCreateAndGetId(sql);
        user.setId(id);
        return (id > 0);
    }

    public boolean delete(User user) throws SQLException {
        String sql = String.format(
                "DELETE FROM `lobkova`.`users` WHERE `lobkova`.`users`.`id` = %d",
                user.getId()
        );
        return Dao.executeUpdate(sql);
    }

    public boolean update(User user) throws SQLException {
        String sql = String.format(
                "UPDATE `users` SET `email` = '%s', `login` = '%s', `password` = '%s', `name` = '%s', `roles_id` = '%d' WHERE `users`.`id` = '%d'",
                user.getEmail(), user.getLogin(),
                user.getPassword(), user.getName(), user.getRoles_id(),
                user.getId()
        );
        return Dao.executeUpdate(sql);
    }

    public User read(long id) throws SQLException {
        String sqlSuffix = String.format("WHERE id=%d", id);
        List<User> all = getAll(sqlSuffix);
        return all.size() > 0 ? all.get(0) : null;
    }

    @Override
    public List<User> getAll(String sql) throws SQLException {
        List<User> result=new ArrayList<>();
        String sqlSuffix = String.format("SELECT `id`, `login`, `password`, `email`, `name`, `roles_ID`  " +
                "FROM `users` %s",sql);
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sqlSuffix);
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");
                String name = resultSet.getString("name");
                long roles_Id = resultSet.getLong("roles_id");
                User user = new User(id, login, password, email, name, roles_Id);
                result.add(user);
            }
            return result;
        }
    }
}
