package by.it.mnovikov.jd03_03.dao;

import by.it.mnovikov.jd03_03.beans.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class UserDao implements InterfaceDao<User> {

    public boolean create(User user) throws SQLException {
        String sql = String.format(Locale.ENGLISH,"INSERT INTO `users`(" +
                        "`login`, `password`, `email`, `first_name`," +
                        "`last_name`, `birthday`, `adress`, `roles_ID`)" +
                        "VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%d')",
                user.getLogin(), user.getPassword(), user.getEmail(), user.getFirst_name(),
                user.getLast_name(), user.getBirthday(), user.getAdress(), user.getRoles_id()
        );
        int id = Dao.executeCreateAndGetId(sql);
        user.setId(id);
        return (id>0);
    }

    public boolean delete(User user) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "DELETE FROM `users` WHERE `users`.`id`='%d'", user.getId()
        );
        return Dao.executeUpdate(sql);
    }

    public boolean update(User user) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "UPDATE `users` SET" +
                        "`login`='%s',`password`='%s',`email`='%s'," +
                        "`first_name`='%s',`last_name`='%s',`birthday`='%s'," +
                        "`adress`='%s',`roles_ID`='%d' WHERE `users`.`id`=%d",
                user.getLogin(), user.getPassword(), user.getEmail(),
                user.getFirst_name(), user.getLast_name(), user.getBirthday(),
                user.getAdress(), user.getRoles_id(), user.getId());
        return Dao.executeUpdate(sql);
    }

    public User read(int id) throws SQLException {
        String sqlSuffix = String.format(Locale.ENGLISH,"WHERE id=%d", id);
        List<User> all = getAll(sqlSuffix);
        return all.size() > 0 ? all.get(0) : null;
}

    @Override
    public List<User> getAll(String sqlSuffix) throws SQLException {
        List<User> result = new ArrayList<>();
        String sql = String.format(Locale.ENGLISH,"SELECT * FROM `users` '%s'", sqlSuffix);
        try (Statement statement = Connect.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                //id ok
                int id = resultSet.getInt("id");
                String strLogin = resultSet.getString("login");
                String strPassword = resultSet.getString("password");
                String strEmail = resultSet.getString("email");
                String strFirstName = resultSet.getString("first_name");
                String strLastName = resultSet.getString("Last_name");
                Timestamp birthday = resultSet.getTimestamp("birthday");
                String adress = resultSet.getString("adress");
                int rolesID = resultSet.getInt("roles_ID");
                User user = new User(id, strLogin, strPassword, strEmail,
                        strFirstName, strLastName, birthday, adress, rolesID);
                result.add(user);
            }
            return result;
        }
    }
}

