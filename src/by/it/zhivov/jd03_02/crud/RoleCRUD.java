package by.it.zhivov.jd03_02.crud;

import by.it.zhivov.jd03_02.beans.Role;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RoleCRUD {
    public boolean create(Role role) throws SQLException {
        String sqlCmd = String.format("INSERT INTO `roles`" +
                "(`role`) " +
                "VALUES ('%s')", role.getRole());
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            if (1 == statement.executeUpdate(sqlCmd, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    role.setId(generatedKeys.getLong(1));
                }
                return true;
            }
        }
        return false;
    }

    public Role read(long idr) throws SQLException {
        String sqlCmd = String.format("SELECT `id`, `role`" +
                "FROM `roles` WHERE id=%d", idr);
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sqlCmd);
            if (resultSet.next()) {
                String role = resultSet.getString("role");
                return new Role(idr, role);
            } else return null;
        }
    }

    public boolean update(Role role) throws SQLException {
        String sqlCmd = String.format(
                "UPDATE `roles` SET " +
                        "`role`='%s'" +
                        "WHERE `roles`.`id`=%d",
                role.getRole(), role.getId()
        );
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            return ( 1 == statement.executeUpdate(sqlCmd) );
        }
    }

    public boolean delete(Role role) throws SQLException {
        String sqlCmd = String.format("DELETE FROM `roles` WHERE `roles`.`id`=%d", role.getId());
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            return ( 1 == statement.executeUpdate(sqlCmd) );
        }
    }
}
