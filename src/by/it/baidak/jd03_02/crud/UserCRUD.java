package by.it.baidak.jd03_02.crud;

import by.it.baidak.jd03_02.beans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserCRUD {

    boolean create(User user) throws SQLException {
        String sql = String.format(
                "INSERT INTO `users` (`email`, `nickname`, `pass`, `roles_id`) " +
                        "VALUES ('%s', '%s', '%s', '%d')",
                user.getEmail(), user.getNickname(), user.getPassword(), user.getRoles_Id()
        );
        try (Connection connection = by.it.baidak.jd03_02.crud.Connection.getConnection();
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
        try (Connection connection = by.it.baidak.jd03_02.crud.Connection.getConnection();

             Statement statement = connection.createStatement()) {
            return (1 == statement.executeUpdate(sql));
        }
    }

    boolean update(User user) throws SQLException {
        String sql = String.format(
                "UPDATE `users` SET " +
                        "`email` = '%s', `nickname` = '%s', " +
                        "`pass` = '%s',  `roles_id` = '%d' " +
                        "WHERE `users`.`id` = %d",
                user.getEmail(), user.getNickname(),
                user.getPassword(), user.getRoles_Id(),
                user.getId()
        );
        try (Connection connection = by.it.baidak.jd03_02.crud.Connection.getConnection();
             Statement statement = connection.createStatement()) {
            return (1 == statement.executeUpdate(sql));
        }
    }

    User read(long id) throws SQLException {
        String sql=String.format("SELECT `id`, `email`, `nickname`, `pass`, `roles_id` " +
                "FROM `users` WHERE id=%d",id);
        try (Connection connection = by.it.baidak.jd03_02.crud.Connection.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()){
                String email=resultSet.getString("email");
                String nickname=resultSet.getString("nickname");
                String pass=resultSet.getString("pass");
                long roles_Id=resultSet.getLong("roles_id");
                return new User(id,nickname,pass,email,roles_Id);
            }
            else
                return null;
        }
    }

}
