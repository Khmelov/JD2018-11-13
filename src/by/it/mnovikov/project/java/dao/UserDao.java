package by.it.mnovikov.project.java.dao;

import by.it.mnovikov.project.java.beans.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements InterfaceDao<User> {


    public boolean create(User user) throws SQLException {
        String sql = String.format("INSERT INTO `users`(" +
                        "`login`, `password`, `email`, `first_name`," +
                        "`last_name`, `birthday`, `adress`, `roles_ID`)" +
                        "VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%d')",
                user.getLogin(), user.getPassword(), user.getEmail(), user.getFirst_name(),
                user.getLast_name(), user.getBirthday(), user.getAdress(), user.getRoles_id()
        );
        int id = Dao.executeCreateAndGetId(sql);
        user.setId(id);
        return false;
    }

    public boolean delete(User user) throws SQLException {
        String sql = String.format(
                "DELETE FROM `users` WHERE `users`.`ID`='%d'",
                user.getId()
        );
        return Dao.executeUpdate(sql);
    }

    public boolean update(User user) throws SQLException {
        String sql = String.format(
                "UPDATE `users` SET" +
                        "`login`='%s',`password`='%s',`email`='%s'," +
                        "`first_name`='%s',`last_name`='%s',`birthday`='%s'," +
                        "`adress`='%s',`roles_ID`='%d' WHERE `users`.`ID`=%d",
                user.getLogin(), user.getPassword(), user.getEmail(),
                user.getFirst_name(), user.getLast_name(), user.getBirthday(),
                user.getAdress(), user.getRoles_id(), user.getId());
        return Dao.executeUpdate(sql);
    }

    public User read(int id) throws SQLException {
        String sqlSuffix = String.format("WHERE ID = %d", id);
        List<User> users = getAll(sqlSuffix);
        return users.size() > 0 ? users.get(0) : null;
    }

    @Override
    public List<User> getAll(String sqlSuffix) throws SQLException {
        List<User> result = new ArrayList<>();
        String sql = String.format("SELECT `ID`, `login`, `password`, `email`, `first_name`, " +
                "`last_name`, `birthday`, `adress`, `roles_ID` FROM `users` '%s'", sqlSuffix);
        try (Statement statement = Connect.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                //id ok
                int id = resultSet.getInt("ID");
                String strLogin = resultSet.getString("login");
                String strPassword = resultSet.getString("password");
                String strEmail = resultSet.getString("email");
                String strFirstName = resultSet.getString("first_name");
                String strLastName = resultSet.getString("last_name");
                Timestamp birthday = resultSet.getTimestamp("birthday");
                String strAdress = resultSet.getString("adress");
                int rolesID = resultSet.getInt("roles_ID");
                User user = new User(id, strLogin, strPassword, strEmail,
                        strFirstName, strLastName, birthday, strAdress, rolesID);
                result.add(user);
            }
            return result;
        }
    }
}

