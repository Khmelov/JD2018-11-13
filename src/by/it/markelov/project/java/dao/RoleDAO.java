package by.it.markelov.project.java.dao;

import by.it.markelov.project.java.beans.Role;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class RoleDAO extends AbstractDAO implements InterfaceDAO<Role> {
    public Role create(Role role) throws SQLException {

        String sql = String.format(Locale.ENGLISH, "INSERT INTO `roles`(`Role`) VALUES ('%s');", role.getRole());
        int id = executeCreate(sql);
        if (id > 0) {
            role.setId(id);
            return role;
        } else
            return null;
    }


    public Role read(int id) throws SQLException {
        String where = String.format(Locale.ENGLISH, "WHERE ID='%d'",
                id);
        List<Role> listRoles = getAll(where);

        if (listRoles.size() == 1) {
            return listRoles.get(0);
        } else {
            return null;
        }

    }

    public boolean update(Role role) throws SQLException {
        String sql = String.format(Locale.ENGLISH, "UPDATE `roles` SET `Role`='%s' WHERE ID='%d';", role.getRole(), role.getId());

        return executeUpdate(sql);
    }


    public boolean delete(Role role) throws SQLException {
        String sql = String.format(Locale.ENGLISH, "DELETE FROM `roles` WHERE ID='%d';", role.getId());

        return executeUpdate(sql);
    }


    @Override
    public List<Role> getAll(String where) throws SQLException {
        List<Role> resultList = new ArrayList<>();
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(Locale.ENGLISH, "SELECT `ID`, `Role` FROM `roles` %s", where);
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Role role = new Role(
                        resultSet.getInt("ID"),
                        resultSet.getString("Role"));
                resultList.add(role);
            }
        }
        return resultList;
    }
}