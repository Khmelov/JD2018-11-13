package by.it.vchernetski.jd03_02.crud;

import by.it.vchernetski.jd03_02.beans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserCRUD {

    boolean create(User user) throws SQLException {
        String sql = String.format("INSERT INTO `users` (`fio`, `numbergarages`, `nickname`, `email`, `password`, `roles_id`) " +
                "VALUES ('%s', '%d', '%s', '%s', '%s', '%d')", user.getFio(), user.getNumbergarages(), user.getNickname(), user.getEmail(), user.getPassword(), user.getRoles_id());
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
        String sql = String.format("DELETE FROM `users` WHERE `users`.`id` = %d", user.getId());
        try(Connection connection = Connect.getConnection();
        Statement statement = connection.createStatement()) {
            return (1 == statement.executeUpdate(sql));
        }
    }

    boolean update(User user) throws SQLException {
        String sql = String.format("UPDATE `users` SET " +
                "`fio` = '%s', " +
                "`numbergarages` = '%d', " +
                "`nickname` = '%s', " +
                "`email` = '%s', " +
                "`password` = '%s', " +
                "`roles_id` = '%d' " +
                "WHERE `users`.`id` = %d", user.getFio(), user.getNumbergarages(),user.getNickname(),user.getEmail(),user.getPassword(),user.getRoles_id(),user.getId());
        try(Connection connection = Connect.getConnection();
        Statement statement = connection.createStatement()) {
            return (1 == statement.executeUpdate(sql));
        }
    }
    User read(long id) throws SQLException {
        String sql = String.format("SELECT `id`, `fio`, `numbergarages`, `nickname`, `email`, `password`, `roles_id` FROM `users` WHERE id = %d",id);
        try(Connection connection = Connect.getConnection();
            Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            if(resultSet.next()){
                return new User(id,
                        resultSet.getString("fio"),
                        resultSet.getString("nickname"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getInt("numbergarages"),
                        resultSet.getLong("roles_id"));
            }
            else
                return null;
        }
    }
}
