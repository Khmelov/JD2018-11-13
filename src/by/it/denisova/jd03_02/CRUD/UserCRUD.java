package by.it.denisova.jd03_02.CRUD;

import by.it.denisova.jd03_02.beans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserCRUD {

    boolean create(User user) throws SQLException{
        String sql = String.format("INSERT INTO `users` (`login`, `password`, `email`, `id_role`) " +
                        "VALUES ('%s', '%s', '%s', '%d')",
                user.getLogin(), user.getPassword(), user.getEmail(), user.getIdRole()
        );
        try (Connection connection = Connect.getConnection();
             Statement st = connection.createStatement()) {
            if (1 == st.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet generatedKeys = st.getGeneratedKeys();
                if(generatedKeys.next()) {
                    user.setId(generatedKeys.getLong(1));
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
             Statement st = connection.createStatement()) {
            return (1 == st.executeUpdate(sql));
        }
    }

    boolean update (User user) throws  SQLException {
        String sql = String.format(
                "UPDATE `users` SET " +
                        "`login` = '%s', `password` = '%s', " +
                        "`email` = '%s',  `id_role` = '%d' " +
                        "WHERE `users`.`id_user` = %d",
                user.getLogin(), user.getPassword(), user.getEmail(),user.getIdRole(), user.getId()
        );
        try (Connection connection = Connect.getConnection();
                Statement st = connection.createStatement()){
            return (1 == st.executeUpdate(sql));
        }
    }

    User read (long id) throws SQLException {
        String sql = String.format(
          "SELECT * FROM `users` WHERE id_user = %d", id
        );

        try (Connection connection = Connect.getConnection();
                Statement st = connection.createStatement()) {
            ResultSet resSet = st.executeQuery(sql);
            if(resSet.next()) {
                String login = resSet.getString("login");
                String password = resSet.getString("password");
                String email = resSet.getNString("email");
                long id_role = resSet.getLong("id_role");
                return new User(id, login, password, email,id_role);
            }
            else return null;
        }
    }
}
