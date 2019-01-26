package by.it.naumenko.jd03_02.CRUD;

import by.it.naumenko.jd03_02.beens.Roles;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RoleCRUD {

    boolean create(Roles roles) throws SQLException {
        String sql = String.format("INSERT INTO `roles`(`role`) VALUES ('%s')", roles.getRole());
        System.out.println(sql);
        try (Connection connection = Connected.getConnection();
             Statement statement = connection.createStatement()) {
            if (statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS) == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    roles.setId_role(generatedKeys.getLong(1));

                }
                return true;
            }
        }
        return false;
    }

    boolean delete(Roles roles) throws SQLException {
        String sql = String.format("DELETE From 'roles' where 'roles'.'id_roles'=%d", roles.getId_role());


        try (Connection connection = Connected.getConnection();) {
            Statement statement = connection.createStatement();
            return (1 == statement.executeUpdate(sql));
        }
    }

    boolean update(Roles roles) throws SQLException {
        String sql = String.format("UPDATE `roles` SET `role` = %s WHERE `roles`.`id_roles` = %d",
                roles.getRole(), roles.getId_role());

        try (Connection connection = Connected.getConnection();) {
            Statement statement = connection.createStatement();
            return (1 == statement.executeUpdate(sql));
        }
    }


    Roles read(long id_Role) throws SQLException {
        String sql = String.format("SELECT * FROM `roles` WHERE `id_roles`=%d", id_Role);


        try (Connection connection = Connected.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                String role = resultSet.getString("role");
                return new Roles(id_Role, role);
            } else
                return null;
        }
    }
}

