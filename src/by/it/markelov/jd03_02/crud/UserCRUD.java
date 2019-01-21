package by.it.markelov.jd03_02.crud;

import by.it.markelov.jd03_02.beans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserCRUD {
    public User create(User user) throws SQLException {

        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {


            String sql = String.format("INSERT INTO `users`(`Login`, `Password`, `E-Mail`, `roles_ID`) " +
                    "VALUES ('%s','%s','%s','%d');", user.getLogin(), user.getPassword(), user.getEmail(), user.getRoles_ID());

            int countCreatedObject = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if (countCreatedObject == 1) {
                ResultSet keys = statement.getGeneratedKeys();
                if (keys.next()) {
                    int id = keys.getInt(1);
                    user.setId(id);
                }
            }
            return user;
        }
    }

    public User read(User user) throws SQLException {
        User result = null;
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("SELECT `ID`, `Login`, `Password`, `E-Mail`, `roles_ID` FROM `users` WHERE ID='%d'",
                    user.getId());
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                result = new User(
                        resultSet.getInt("ID"),
                        resultSet.getString("Login"),
                        resultSet.getString("Password"),
                        resultSet.getString("E-Mail"),
                        resultSet.getInt("roles_ID")
                );
            }
        }
        return result;
    }

    public boolean update(User user) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("UPDATE `users` SET " +
                            "`Login`=`%s`," +
                            "`Password`=`%s`," +
                            "`E-Mail`=`%s`," +
                            "`roles_ID`=%d " +
                            "WHERE ID=%d",
                    user.getLogin(),
                    user.getPassword(),
                    user.getEmail(),
                    user.getRoles_ID(),
                    user.getId());

            int countCreatedObject = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            return (countCreatedObject == 1);
        }
    }


    public boolean delete(User user) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("DELETE FROM `users` WHERE ID=%d", user.getId());

            int countCreatedObject = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            return (countCreatedObject == 1);
        }
    }
}