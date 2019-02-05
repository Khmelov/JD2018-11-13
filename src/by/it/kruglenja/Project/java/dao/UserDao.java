package by.it.kruglenja.Project.java.dao;


import by.it.kruglenja.Project.java.beans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements InterfaceDao<User> {

    public boolean create(User user) throws SQLException {
        String sql = String.format("INSERT INTO `users` (`login`, `password`, `email`, `phone_number`, `roles_id`)" +
                        " VALUES ('%s', '%s', '%s', '%s', '%d')",
                user.getLogin(), user.getPassword(), user.getEmail(), user.getPhone_number(), user.getRoles_Id());
        long id = Dao.executeCrate(sql);
        user.setId(id);
        return (id > 0);
    }

    public boolean delete(User user) throws SQLException {
        String sql = String.format("DELETE FROM `users` WHERE `users`.`id` = %d",
                user.getId());
        return Dao.executeUpdate(sql);

    }

    public boolean update(User user) throws SQLException {
        String sql = String.format("UPDATE `users` SET `login` = '%s'," +
                        "`password` = '%s', `email` = '%s', `phone_number` = '%s', `roles_id` = '%d' WHERE `users`.`id` = %d",
                user.getLogin(), user.getPassword(), user.getEmail(), user.getPhone_number(), user.getRoles_Id(),
                user.getId());
        return Dao.executeUpdate(sql);
    }

    public User read(long id) throws SQLException {
        List<User> users = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (users.size() > 0){
            return users.get(0);
        }else {
            return null;
        }
    }

    @Override
    public List<User> getAll(String sqlSuffix) throws SQLException {
        List<User> users = new ArrayList<>();
        String sql = String.format("SELECT `id`, `login`, `password`, `email`, `phone_number`, `roles_id` " +
                "FROM `users` %s",sqlSuffix);
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet res = statement.executeQuery(sql);
            while (res.next()) {
                User user = new User();
                user.setId(res.getLong("id"));
                user.setLogin(res.getString("login"));
                user.setPassword(res.getString("password"));
                user.setEmail(res.getString("email"));
                user.setPhone_number(res.getString("phone_number"));
                user.setRoles_Id(res.getLong("roles_id"));
                users.add(user);
            }
        }
        return users;
    }
}
