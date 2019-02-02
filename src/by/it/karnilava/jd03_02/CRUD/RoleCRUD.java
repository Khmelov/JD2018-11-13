package by.it.karnilava.jd03_02.CRUD;


import by.it.karnilava.jd03_02.beans.Role;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RoleCRUD {

    boolean create(Role role) {
        String sql = String.format(
                "INSERT INTO `karnilava`.`Roles` ( `Roles`) " +
                        "VALUES ('%s')",
                role.getRole());

        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            if (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    role.setId(generatedKeys.getLong(1));

                }
                return true;
            }
        } catch (Exception e) {
            System.out.println("Creation of " + role.toString() + " is failed");
            return false;

        }
        return false;
    }

    boolean delete(Role role) throws SQLException {
        String sql = String.format(
                "DELETE FROM `karnilava`.`roles` WHERE `karnilava`.`roles`.`idRoles` = %d",
                role.getId()
        );
        try (Connection connection = Connect.getConnection();

             Statement statement = connection.createStatement()) {
            return (1 == statement.executeUpdate(sql));
        }
    }

    boolean update(Role role) throws SQLException {
        String sql = String.format(
                "UPDATE `karnilava`.`roles`  SET " +
                        "`Roles` = '%s' " +
                        "WHERE `karnilava`.`roles`.`idRoles` = %d",
                role.getRole(), role.getId()
        );
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            return (1 == statement.executeUpdate(sql));
        }
    }


    Role read(long id) throws SQLException {
        String sql=String.format("SELECT `idRoles`,`Roles` " +
                "FROM  `karnilava`.`roles` WHERE `karnilava`.`roles`.`idRoles`=%d",id);
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()){
                //id ok
                String role=resultSet.getString("roles");

                return new Role(id,role);
            }
            else
                return null;
        }

    }


}
