package by.it.markelov.project.java.dao;

import by.it.markelov.project.java.beans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class UserDAO extends AbstractDAO implements InterfaceDAO<User> {
    public User create(User user) throws SQLException {
        String sql = String.format(Locale.ENGLISH, "INSERT INTO `users`(`Login`, `Password`, `E-Mail`, `roles_ID`) " +
                "VALUES ('%s','%s','%s','%d');", user.getLogin(), user.getPassword(), user.getEmail(), user.getRoles_ID());
        int id = executeCreate(sql);
        if (id > 0) {
            user.setId(id);
            return user;
        } else return null;
    }

    public User read(int id) throws SQLException {
        String where = String.format(Locale.ENGLISH, "WHERE ID='%d';", id);
        List<User> listUsers = getAll(where);
        if (listUsers.size() == 1) {
            return listUsers.get(0);
        } else {
            return null;
        }
    }

    public boolean update(User user) throws SQLException {
        String sql = String.format(Locale.ENGLISH, "UPDATE `users` SET " +
                        "`Login`='%s'," +
                        "`Password`='%s'," +
                        "`E-Mail`='%s'," +
                        "`roles_ID`='%d' " +
                        "WHERE ID='%d'",
                user.getLogin(),
                user.getPassword(),
                user.getEmail(),
                user.getRoles_ID(),
                user.getId());

        return executeUpdate(sql);
    }


    public boolean delete(User user) throws SQLException {
        String sql = String.format(Locale.ENGLISH, "DELETE FROM `users` WHERE ID='%d'", user.getId());

        return executeUpdate(sql);
    }


    @Override
    public List<User> getAll(String where) throws SQLException {
        List<User> resultList = new ArrayList<>();
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(Locale.ENGLISH, "SELECT `ID`, `Login`, `Password`, `E-Mail`, `roles_ID` FROM `users` %s",
                    where);
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                User user = new User(
                        resultSet.getInt("ID"),
                        resultSet.getString("Login"),
                        resultSet.getString("Password"),
                        resultSet.getString("E-Mail"),
                        resultSet.getInt("roles_ID"));
                resultList.add(user);
            }
        }
        return resultList;
    }
}