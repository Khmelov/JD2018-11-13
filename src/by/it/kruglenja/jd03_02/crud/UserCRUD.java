package by.it.kruglenja.jd03_02.crud;


import by.it.kruglenja.jd03_02.beans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserCRUD {

    boolean crate(User user) throws SQLException {
        String sql = String.format("INSERT INTO `users` (`login`, `password`, `email`, `phone_number`, `roles_id`)" +
                        " VALUES ('%s', '%s', '%s', '%s', '%d')",
                user.getLogin(), user.getPassword(), user.getEmail(), user.getPhone_number(), user.getRoles_Id());
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
        String sql = String.format("DELETE FROM `users` WHERE `users`.`id` = %d",
                user.getId());
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            return (1 == statement.executeUpdate(sql));
        }
    }

    boolean update(User user) throws SQLException {
        String sql = String.format("UPDATE `users` SET `login` = '%s'," +
                        "`password` = '%s', `email` = '%s', `phone_number` = '%s', `roles_id` = '%d' WHERE `users`.`id` = %d",
                user.getLogin(), user.getPassword(), user.getEmail(), user.getPhone_number(), user.getRoles_Id(),
                user.getId());
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            return (1 == statement.executeUpdate(sql));
        }
    }

    User read(long id) throws SQLException {
        String sql = String.format("SELECT `id`, `login`, `password`, `email`, `phone_number`," +
                " `roles_id` FROM `users` WHERE id = %d", id);
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {

                String login = resultSet.getString("login");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");
                String phone_number = resultSet.getString("phone_number");
                long roles_id = resultSet.getLong("roles_id");
                return new User(id, login, password, email, phone_number, roles_id);
            } else {
                return null;
            }
        }
    }
}
