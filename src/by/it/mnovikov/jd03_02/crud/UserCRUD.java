package by.it.mnovikov.jd03_02.crud;

import by.it.mnovikov.jd03_02.beans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserCRUD {

    boolean create(User user) throws SQLException {
        String sql = String.format("INSERT INTO `users`(" +
                        "`login`, `password`, `email`, `first_name`," +
                        "`last_name`, `birthday`, `adress`, `roles_ID`)" +
                        "VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%d')",
                user.getLogin(), user.getPassword(), user.getEmail(), user.getFirst_name(),
                user.getLast_name(), user.getBirthday(), user.getAdress(), user.getRoles_id()
        );
        try (Connection connection = Connect_DB.getConnection();
             Statement statement = connection.createStatement()) {
            if (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    user.setId(generatedKeys.getInt(1));
                }
                return true;
            }
        }
        return false;
    }

    boolean delete(User user) throws SQLException {
        String sql = String.format("DELETE FROM `users` WHERE `users`.`id`='%d'", user.getId());
        try (Connection connection = Connect_DB.getConnection();
             Statement statement = connection.createStatement()) {
            return 1 == statement.executeUpdate(sql);
        }
    }

    boolean update(User user) throws SQLException {
        String sql = String.format(
                "UPDATE `users` SET" +
                        "`login`='%s',`password`='%s',`email`='%s'," +
                        "`first_name`='%s',`last_name`='%s',`birthday`='%s'," +
                        "`adress`='%s',`roles_ID`='%d' WHERE `users`.`id`=%d",
                user.getLogin(), user.getPassword(), user.getEmail(),
                user.getFirst_name(), user.getLast_name(), user.getBirthday(),
                user.getAdress(), user.getRoles_id(), user.getId());
        try (Connection connection = Connect_DB.getConnection();
             Statement statement = connection.createStatement()) {
            return 1 == statement.executeUpdate(sql);
        }
    }

    User read(int id) throws SQLException {
        String sql = String.format(
                "SELECT `ID`, `login`, `password`, `email`, `first_name`, `last_name`," +
                        "`birthday`, `adress`, `roles_ID` FROM `users` WHERE id = %d", id);
        try (Connection connection = Connect_DB.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                int userId = resultSet.getInt("id");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");
                String first_name = resultSet.getString("first_name");
                String last_name = resultSet.getString("last_name");
                long birthday = resultSet.getLong("birthday");
                String adress = resultSet.getString("adress");
                int roles_Id = resultSet.getInt("roles_ID");
                return new User();
            } else return null;
        }
    }
}
