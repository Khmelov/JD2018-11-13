package by.it.zakharenko.jd03_02.crud;

import by.it.zakharenko.jd03_02.beans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class UserCRUD {

    boolean create(User user) throws SQLException {
        String sql = String.format(
                "INSERT INTO `users` (`username`, `password`, `email`, `fullname`, `phone`, `address`, `roles_id`) " +
                        "VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%d')",
                user.getUsername(), user.getPassword(), user.getEmail(), user.getFullname(), user.getPhone(), user.getAddress(), user.getRoles_id()
        );
        try (Connection connection = Connect.getConnection();
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
                        "`username` = '%s', `password` = '%s', " +
                        "`email` = '%s',  `fullname` = '%s', " +
                        "`phone` = '%s',  `address` = '%s' " +
                        "WHERE `users`.`id` = %d",
                user.getUsername(), user.getPassword(),
                user.getEmail(), user.getFullname(),
                user.getPhone(), user.getAddress(), user.getId()

        );
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            return (1 == statement.executeUpdate(sql));
        }
    }

    User read(int id) throws SQLException {
        String sql=String.format("SELECT `username`, `password`, `email`, `fullname`, `phone`, `address`, `roles_id` " +
                "FROM `users` WHERE id=%d",id);
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()){
                //id ok
                String username=resultSet.getString("username");
                String password=resultSet.getString("password");

                String email=resultSet.getString("email");
                String fullname=resultSet.getString("fullname");
                String phone=resultSet.getString("phone");
                String address=resultSet.getString("address");

                int roles_id=resultSet.getInt("roles_id");
                return new User(id,username,password,email,fullname,phone,address,roles_id);
            }
            else
                return null;
        }
    }

}
