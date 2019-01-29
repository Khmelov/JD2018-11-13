package by.it.lobkova.project.java.dao;

import by.it.lobkova.project.java.beans.Role;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RoleDao implements IDao<Role> {
    @Override
    public boolean create(Role role) throws SQLException {
        String sql = String.format(
                "INSERT INTO `roles` (`role`) VALUES ('%s')",
                role.getRole()
        );
        long id = Dao.executeCreateAndGetId(sql);
        role.setId(id);
        return (id > 0);
    }

    @Override
    public boolean update(Role role) throws SQLException {
        String sql = String.format(
                "UPDATE `roles` SET `role` = '%s' WHERE `roles`.`id` = '%d'",
                role.getRole(), role.getId()
        );
        return Dao.executeUpdate(sql);
    }

    @Override
    public boolean delete(Role role) throws SQLException {
        String sql = String.format(
                "DELETE FROM `roles` WHERE `roles`.`id` = %d",
                role.getId()
        );
        return Dao.executeUpdate(sql);
    }

    @Override
    public Role read(long id) throws SQLException {
        String sqlSuffix = String.format("WHERE id=%d", id);
        List<Role> all = getAll(sqlSuffix);
        return all.size() > 0 ? all.get(0) : null;
    }

    @Override
    public List<Role> getAll(String sql) throws SQLException {
        List<Role> result = new ArrayList<>();
        String sqlSufix = String.format("SELECT `id`, `role`" +
                "FROM `roles` %s", sql);
        Connection connection = Connect.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlSufix);
        while (resultSet.next()) {
            long id = resultSet.getLong("id");
            String role = resultSet.getString("role");
            Role role1 = new Role(id, role);
            result.add(role1);
        }
        return result;
    }
}
