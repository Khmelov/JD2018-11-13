package by.it.skarpovich.jd03_03.dao;


import by.it.skarpovich.jd03_03.beans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements InterfaceDao<User> {

    public boolean create(User user) throws SQLException {
        String sql = String.format(
                "INSERT INTO `users` (`username`, `password`, `email`, `fullname`, `phone`, `address`, `roles_id`) " +
                        "VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%d')",
                user.getUsername(), user.getPassword(), user.getEmail(), user.getFullname(), user.getPhone(), user.getAddress(), user.getRoles_id()
        );
        int id = Dao.executeCreateAndGetId(sql);
        user.setId(id);
        return (id > 0);
    }

    public boolean delete(User user) throws SQLException {
        String sql = String.format(
                "DELETE FROM `users` WHERE `users`.`id` = %d",
                user.getId()
        );
        return Dao.executeUpdate(sql);
    }

    public boolean update(User user) throws SQLException {
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
        return Dao.executeUpdate(sql);
    }

    public User read(int id) throws SQLException {
        String sqlSuffix = String.format("WHERE id=%d", id);
        List<User> all = getAll(sqlSuffix);
        return all.size() > 0 ? all.get(0) : null;
    }

    @Override
    public List<User> getAll(String sqlSuffix) throws SQLException {
        List<User> result=new ArrayList<>();
        String sql=String.format("SELECT `id`, `username`, `password`, `email`, `fullname`, `phone`, `address`, `roles_id` " +
                "FROM `users` %s",sqlSuffix);
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()){

                int id = resultSet.getInt("id");
                String username=resultSet.getString("username");
                String password=resultSet.getString("password");

                String email=resultSet.getString("email");
                String fullname=resultSet.getString("fullname");
                String phone=resultSet.getString("phone");
                String address=resultSet.getString("address");

                int roles_id=resultSet.getInt("roles_id");

                User user = new User(id,username,password,email,fullname,phone,address,roles_id);
                result.add(user);
            }
            return result;
        }
    }


}
