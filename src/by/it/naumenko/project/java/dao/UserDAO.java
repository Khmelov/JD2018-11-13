package by.it.naumenko.project.java.dao;

import by.it.naumenko.project.java.beens.Users ;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

class UserDAO implements InterfaceDao<Users> {

    public boolean create(Users users) throws SQLException {
        String sql = String.format(
                "INSERT INTO `users` (`login`, `password`, `email`, " +
                        "`id_role`) " +
                        "VALUES ('%s', '%s', '%s', '%d')",
                users.getLogin(), users.getPassword(),
                users.getEmail(), users.getId_roles()
        );
        long id = Dao.executeCreateAndGetId(sql);
        users.setId_user(id);
        return (id > 0);
    }


    public boolean delete(Users users) throws SQLException {
        String sql = String.format("DELETE FROM `users` WHERE " +
                "`users`.`id_user` = %d", users.getId_user());
        return Dao.executeUpdate(sql);
    }

    public boolean update(Users users) throws SQLException {
        String sql = String.format("UPDATE `users` SET `" +
                        "login` = %s,`password` = %s, `email` = %s, " +
                        "`id_role` = %d WHERE " +
                        "`users`.`id_user` = %d",
                users.getLogin(), users.getPassword(),
                users.getEmail(), users.getId_roles(),
                users.getId_user());

        return Dao.executeUpdate(sql);
    }


    public Users read(long id_user) throws SQLException {
        String sqlSuffix = String.format("WHERE `id_user`=%d", id_user);
        List<Users> all = getAll(sqlSuffix);
        return all.size() > 0 ? all.get(0) : null;

    }

    @Override
    public List<Users> getAll(String sqlSuffix) throws SQLException {
        List<Users> result = new ArrayList<>();
        String sql = String.format("select * from `users` %s", sqlSuffix);

        System.out.println(sql);
        System.out.println(sqlSuffix);
        try (Connection connection = Connected.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                //id ok
                long id = resultSet.getLong("id_user");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");
                long id_roles = resultSet.getLong("id_role");
                Users users = new Users(id, login, password, email, id_roles);
                result.add(users);
            }
            return result;
        }
    }

    @Override
    public List<Users> getAll() throws SQLException {
        List<Users> AllZap = new ArrayList<>();
        String sql = String.format("select * from `users`");


        try (Connection connection = Connected.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                //id ok
                long id = resultSet.getLong("id_user");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");
                long id_roles = resultSet.getLong("id_role");
                Users users = new Users(id, login, password, email, id_roles);
                AllZap.add(users);
            }
            return AllZap;
        }
    }
}

