package by.it.naumenko.jd03_02.CRUD;

import by.it.naumenko.jd03_02.beens.Users;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class UserCRUD {

    boolean create(Users users) throws SQLException {
        String sql = String.format(
                "INSERT INTO `users` (`login`, `password`, `email`, `roles_id_roles`) " +
                        "VALUES ('%s', '%s', '%s', '%d')",
                users.getLogin(), users.getPassword(), users.getEmail(), users.getId_roles()
        );
        try (Connection connection = Connected.getConnection();
             Statement statement = connection.createStatement()) {
            if (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    users.setId_user(generatedKeys.getLong(1));
                }
                return true;
            }
        }
        return false;
    }


    boolean delete(Users users) throws SQLException {
        String sql = String.format("DELETE FROM `users` WHERE `users`.`id_users` = %d", users.getId_user());


        try (Connection connection = Connected.getConnection()) {
            Statement statement = connection.createStatement();
            return (1 == statement.executeUpdate(sql));
        }
    }

    boolean update(Users users) throws SQLException {
        String sql = String.format("UPDATE `users` SET `" +
                        "login` = %s,`password` = %s, `email` = %s, " +
                        "`roles_id_roles` = %d WHERE `users`.`id_users` = %d",
                users.getLogin(), users.getPassword(),
                users.getEmail(), users.getId_roles(), users.getId_user());

        try (Connection connection = Connected.getConnection()) {
            Statement statement = connection.createStatement();
            return (1 == statement.executeUpdate(sql));
        }
    }


    Users read(long id_user) throws SQLException {
        String sql = String.format("SELECT * FROM `users` WHERE `id_users`=%d", id_user);


        try (Connection connection = Connected.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                String lodin = resultSet.getString("login");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");
                long id_roles = resultSet.getLong("roles_id_roles");
                return new Users(id_user, lodin, password, email, id_roles);
            } else
                return null;
        }
    }
}

