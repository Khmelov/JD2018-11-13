package by.it.lobkova.jd03_02.crud;

import by.it.lobkova.jd03_02.beans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserCRUD {

    boolean create(User user) throws SQLException {
        String sql = String.format(
                "INSERT INTO `lobkova`.`users` (`email`,`login`, `password`, `name`,  `roles_ID`) " +
                        "VALUES ('%s', '%s', '%s', '%s', '%d')",
                user.getEmail(), user.getLogin(), user.getPassword(), user.getName(), user.getRoles_id()
        );
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            if (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    user.setId(generatedKeys.getLong(1));
                }
                return true;
            }
        }
        return false;
    }

    boolean delete(User user) throws SQLException {
        String sql = String.format(
                "DELETE FROM `lobkova`.`users` WHERE `lobkova`.`users`.`id` = %d",
                user.getId()
        );
        try (Connection connection = Connect.getConnection();

             Statement statement = connection.createStatement()) {
            return (1 == statement.executeUpdate(sql));
        }
    }

    boolean update(User user) throws SQLException {
        String sql = String.format(
                "UPDATE `users` SET `email` = '%s', `login` = '%s', `password` = '%s', `name` = '%s', `roles_id` = '%d' WHERE `users`.`id` = '%d'",
                user.getEmail(), user.getLogin(),
                user.getPassword(), user.getName(), user.getRoles_id(),
                user.getId()
        );
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            return (1 == statement.executeUpdate(sql));
        }
    }

    User read(long id) throws SQLException {
        String sql = String.format("SELECT `id`, `login`, `password`, `email`, `name`, `roles_ID` " +
                "FROM `lobkova`.`users` WHERE id=%d", id);
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                //id ok
                String email = resultSet.getString("email");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");
                String name = resultSet.getString("name");
                long roles_Id = resultSet.getLong("roles_ID");
                return new User(id, email, login, password, name, roles_Id);
            } else
                return null;
        }

    }
}
