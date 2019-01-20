package by.it.akhmelev.jd03_02.crud;

import by.it.akhmelev.jd03_02.beans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class UserCRUD {

    boolean create(User user) throws SQLException {
        String sql = String.format(
                "INSERT INTO `users` (`login`, `password`, `email`, `roles_id`) " +
                        "VALUES ('%s', '%s', '%s', '%d')",
                user.getLogin(), user.getPassword(), user.getEmail(), user.getRoles_Id()
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
                "DELETE FROM `users` WHERE `users`.`id` = %d",
                user.getId()
        );
        try (Connection connection = Connect.getConnection();

             Statement statement = connection.createStatement()) {
            return (1 == statement.executeUpdate(sql));
        }
    }

    boolean update(User user) throws SQLException {
        String sql = String.format(
                "UPDATE `users` SET " +
                        "`login` = '%s', `password` = '%s', " +
                        "`email` = '%s',  `roles_id` = '%d' " +
                        "WHERE `users`.`id` = %d",
                user.getLogin(), user.getPassword(),
                user.getEmail(), user.getRoles_Id(),
                user.getId()
        );
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            return (1 == statement.executeUpdate(sql));
        }
    }

    User read(long id) throws SQLException {
        String sql=String.format("SELECT `id`, `login`, `password`, `email`, `roles_id` " +
                "FROM `users` WHERE id=%d",id);
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()){
                //id ok
                String login=resultSet.getString("login");
                String password=resultSet.getString("password");
                String email=resultSet.getString("email");
                long roles_Id=resultSet.getLong("roles_id");
                return new User(id,login,password,email,roles_Id);
            }
            else
                return null;
        }

    }


}
