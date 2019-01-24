package by.it.denisova.jd03_02.CRUD;

import by.it.denisova.jd03_02.beans.Role;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RoleCRUD {

    boolean create(Role role) throws SQLException {
        String sql = String.format(
                "INSERT INTO `roles` (`role`) " +
                        "VALUES ('%s')",
                role.getRole()
        );
        try (Connection connection = Connect.getConnection();
             Statement st = connection.createStatement()) {
            if (1 == st.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet generatedKeys = st.getGeneratedKeys();
                if (generatedKeys.next()) {
                    role.setId(generatedKeys.getLong(1));
                }
                return true;
            }
        }

        return false;
    }

    boolean delete(Role role) throws SQLException {
        String sql = String.format(
                "DELETE FROM `roles` WHERE `roles`.`id_role` = %d",
                role.getId()
        );
        try (Connection connection = Connect.getConnection();
             Statement st = connection.createStatement()) {
            return (1 == st.executeUpdate(sql));
        }
    }

    boolean update(Role role) throws SQLException {
        String sql = String.format(
                "UPDATE `roles` SET `role` = '%s' WHERE `roles`.`id_role` = %d",
                role.getRole(), role.getId()
        );

        try (Connection connection = Connect.getConnection();
             Statement st = connection.createStatement()) {
            return (1 == st.executeUpdate(sql));
        }
    }

    Role read(long id) throws SQLException {
        String sql = String.format(
                "SELECT * FROM `roles` WHERE id_role = %d",id
        );
        try (Connection connection = Connect.getConnection();
             Statement st = connection.createStatement()) {
            ResultSet resSet = st.executeQuery(sql);
            if (resSet.next()) {
                String role = resSet.getString("role");
                return new Role(id, role);
            } else return null;
        }
    }


}
