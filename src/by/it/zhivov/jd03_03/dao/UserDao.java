package by.it.zhivov.jd03_03.dao;

import by.it.zhivov.jd03_03.beans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements InterfaceDao<User> {

    public boolean create(User user) throws SQLException {
        String sqlCmd = String.format("INSERT INTO `users` " +
                        "(`name`, `login`, `password`, `dateofbirth`, `email`, `tel`, `roles_id`) " +
                        "VALUES ('%s','%s','%s','%s','%s','%s','%d')",
                user.getName(), user.getLogin(), user.getPassword(), user.getDateOfBirth(), user.getEmail(),
                user.getTel(), user.getRoles_Id());
        long id = Dao.executeCreateAndGetId(sqlCmd);
        user.setId(id);
        return id > 0;
    }

    public User read(long id) throws SQLException {
        String sqlSuffix = String.format(" WHERE id=%d", id);
        List<User> all = getAll(sqlSuffix);
        return all.size() > 0 ? all.get(0) : null;
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
        return Dao.executeUpdate(sqlCmd);
    }

    public boolean delete(User user) throws SQLException {
        String sqlCmd = String.format("DELETE FROM `users` WHERE `users`.`id`=%d", user.getId());
        return Dao.executeUpdate(sqlCmd);
    }

    @Override
    public List<User> getAll(String sqlSuffix) throws SQLException {
        List<User> result = new ArrayList<>();
        String sqlCmd = String.format("SELECT * " +
                "FROM `users` %s", sqlSuffix);
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sqlCmd);
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");
                String dateofbirth = resultSet.getString("dateofbirth");
                String email = resultSet.getString("email");
                String tel = resultSet.getString("tel");
                long roles_id = resultSet.getLong("roles_id");
                User user = new User(id, name, login, password, dateofbirth, email, tel, roles_id);
                result.add(user);
            }
            return result;
        }
    }
}
