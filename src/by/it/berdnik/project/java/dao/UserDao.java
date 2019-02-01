package by.it.berdnik.project.java.dao;

import by.it.berdnik.project.java.beans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements InterfaceDao<User> {

    public boolean create(User user) throws SQLException {
        String sql = String.format(
                "INSERT INTO `users` (`nickname`, `password`, `email`, `roles_id`)" +
                        "VALUES ('%s', '%s', '%s', '%d')",
                user.getNickname(), user.getPassword(), user.getEmail(), user.getRoles_Id());
        long id = Dao.executeCreateAndGetId(sql);
        user.setId(id);
        return  (id > 0);
    }

    public User read(long id) throws SQLException {
        String sqlSuffix = String.format("WHERE id=%d", id);
        List<User> all = getAll(sqlSuffix);
        return all.size() > 0 ? all.get(0) : null;
    }

    public boolean update(User user) throws SQLException {
        String sql = String.format(
                "UPDATE `users` SET " +
                        "`nickname` = '%s', `password` = '%s', " +
                        "`email` = '%s',  `roles_id` = '%d' " +
                        "WHERE `users`.`id` = %d",
                user.getNickname(), user.getPassword(),
                user.getEmail(), user.getRoles_Id(),
                user.getId());
        return Dao.executeUpdate(sql);
    }

    public boolean delete(User user) throws SQLException {
        String sql = String.format(
                "DELETE FROM `users` WHERE `users`.`id` = %d",
                user.getId());
        return Dao.executeUpdate(sql);
    }

    @Override
    public List<User> getAll(String sqlSuffix) throws SQLException {
        List<User> result = new ArrayList<>();
        String sql = String.format("SELECT `id`, `nickname`, `password`, `email`, `roles_id` " +
                "FROM `users` %s", sqlSuffix);
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String nickname = resultSet.getString("nickname");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");
                long roles_Id = resultSet.getLong("roles_id");
                User user = new User (id, nickname, password, email, roles_Id);
                result.add(user);
            }
                return result;
        }
    }
}
