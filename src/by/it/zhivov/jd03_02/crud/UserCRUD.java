package by.it.zhivov.jd03_02.crud;

import by.it.zhivov.jd03_02.beans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserCRUD {
    public boolean create(User user) throws SQLException {
        String sqlCmd = String.format("INSERT INTO `users`" +
                        "(`name`, `login`, `password`, `dateofbirth`, `email`, `tel`, `roles_id`) " +
                        "VALUES ('%s','%s','%s','%s','%s','%s','%d')",
                user.getName(), user.getLogin(), user.getPassword(), user.getDateOfBirth(), user.getEmail(),
                user.getTel(), user.getRoles_Id());
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            if (1 == statement.executeUpdate(sqlCmd, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    user.setId(generatedKeys.getLong(1));
                }
                return true;
            }
        }
        return false;
    }

    public User read(long id) throws SQLException {
        String sqlCmd = String.format("SELECT `id`, `name`, `login`, `password`, `dateofbirth`, `email`, `tel`," +
                " `roles_id` FROM `users` WHERE id=%d", id);
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sqlCmd);
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");
                String dateofbirth = resultSet.getString("dateofbirth");
                String email = resultSet.getString("email");
                String tel = resultSet.getString("tel");
                long roles_id = resultSet.getLong("roles_id");
                return new User(id, name, login, password, dateofbirth, email, tel, roles_id);
            } else return null;
        }
    }

    public boolean update(User user) throws SQLException {
        String sqlCmd = String.format(
                "UPDATE `users` SET " +
                        "`name`='%s'," +
                        "`login`='%s'," +
                        "`password`='%s'," +
                        "`dateofbirth`='%s'," +
                        "`email`='%s'," +
                        "`tel`='%s'," +
                        "`roles_id`='%d' " +
                        "WHERE `users`.`id`=%d",
                user.getName(), user.getLogin(), user.getPassword(),
                user.getDateOfBirth(), user.getEmail(), user.getTel(),
                user.getRoles_Id(), user.getId()
        );
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            return ( 1 == statement.executeUpdate(sqlCmd) );
        }
    }

    public boolean delete(User user) throws SQLException {
        String sqlCmd = String.format("DELETE FROM `users` WHERE `users`.`id`=%d", user.getId());
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            return ( 1 == statement.executeUpdate(sqlCmd) );
        }
    }

}
