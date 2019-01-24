package by.it.berdnik.jd03_02.crud;

import by.it.berdnik.jd03_02.beans.Role;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RoleCRUD {
    boolean create(Role role) throws SQLException {
        String sql = String.format("INSERT INTO `roles`(`role`)" +
                "VALUES ('%s')", role.getRole());
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            if (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    role.setId(generatedKeys.getLong(1));
                }
                return true;
            }
        }
        return false;
    }

    Role read(long id) throws SQLException {
        String sql = String.format("SELECT `ID`, `role`" +
                "FROM `roles` WHERE ID=%d", id);
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                String role = resultSet.getString("role");
                long ID = resultSet.getLong("id");
                return new Role(id, role);
            } else
                return null;
        }
    }

    boolean update(Role role) throws SQLException {
        String sql = String.format(
                "UPDATE `roles` SET " +
                        "`role` = '%s'" +
                        "WHERE `role`.`id` = %d",
                role.getRole(), role.getId());
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            return (1 == statement.executeUpdate(sql));
        }
    }

    boolean delete(Role role) throws SQLException {
        String sql = String.format(
                "DELETE FROM `roles` WHERE `roles`.`id` = %d",
                role.getId());
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            return (1 == statement.executeUpdate(sql));
        }
    }
}
