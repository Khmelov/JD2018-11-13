package by.it.denisova.project.java.dao;

import by.it.denisova.project.java.beans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements InterfaceDao<User> {

    public boolean create(User user) throws SQLException {
        String sql = String.format(
                "INSERT INTO `users` (`login`, `password`, `email`, `id_role`) " +
                        "VALUES ('%s', '%s', '%s', '%d')",
                user.getLogin(), user.getPassword(), user.getEmail(), user.getIdRole()
        );
        long id = Dao.executeCreateAndGetId(sql);
        user.setId(id);
        return (id > 0);
    }

    public boolean delete(User user) throws SQLException {
        String sql = String.format(
                "DELETE FROM `users` WHERE `users`.`id_user` = %d",
                user.getId()
        );
        return Dao.executeUpdate(sql);
    }

    public boolean update(User user) throws SQLException {
        String sql = String.format(
                "UPDATE `users` SET " +
                        "`login` = '%s', `password` = '%s', " +
                        "`email` = '%s',  `id_role` = '%d' " +
                        "WHERE `users`.`id_user` = %d" ,
                user.getLogin(), user.getPassword(),
                user.getEmail(), user.getIdRole(),
                user.getId()
        );
        return Dao.executeUpdate(sql);
    }

    public User read(long id) throws SQLException {
        String sqlSuffix = String.format("WHERE id_user = %d", id);
        List<User> all = getAll(sqlSuffix);
        return all.size() > 0 ? all.get(0) : null;
    }

    @Override
    public List<User> getAll(String sqlSuffix) throws SQLException {
        List<User> result=new ArrayList<>();
        String sql = String.format("SELECT `id_user`, `login`, `password`, `email`, `id_role` " +
                "FROM `users` %s",sqlSuffix);
        try (Connection connection = Connect.getConnection();
             Statement st = connection.createStatement()) {
            ResultSet resultSet = st.executeQuery(sql);
            while (resultSet.next()) {

                long id = resultSet.getLong("id_user");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");
                long id_role = resultSet.getLong("id_role");
                User user = new User(id, login, password, email, id_role);
                result.add(user);
            }
            return result;
        }
    }

}