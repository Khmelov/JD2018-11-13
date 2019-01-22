package by.it.mnovikov.jd03_02.crud;

import by.it.mnovikov.jd03_02.beans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by user on 19.01.2019.
 */
public class UserCRUD {

    boolean create (User user) throws SQLException {
        String sql = String.format("INSERT");

        Connection connection = Connect.getConnection();
        Statement statement = connection.createStatement();
        if (1==statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)){
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()){
                user.setId(generatedKeys.getLong(1));
            }
            return true;
        }
        return false;
    }

    boolean delete (User user) throws SQLException {
        String sql = String.format("DELETE FROM `users` WHERE `users`.`id` = %d", user.getId());
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()){
            return 1==statement.executeUpdate(sql);
        }
    }

    boolean update (User user) throws SQLException {
        String sql = String.format("UPDATE `users` SET", user.getId());
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()){
            return 1==statement.executeUpdate(sql);
        }
    }

    User read (long id) throws SQLException {
        String sql = "SELECT";
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()){
                long userId = resultSet.getLong("id");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");
                long roles_Id = resultSet.getLong("roles_id");
                return new User();
            } else return null;
        }
        }

}
