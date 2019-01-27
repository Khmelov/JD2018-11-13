package by.it.berdnik.jd03_03.dao;

import by.it.berdnik.jd03_03.beans.Role;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RoleDao implements InterfaceDao<Role> {

    public boolean create(Role role) throws SQLException {
        String sql = String.format(
                "INSERT INTO `roles` (`role`)" +
                        "VALUES ('%s')",
                role.getRole());
        long id = Dao.executeCreateAndGetId(sql);
        role.setId(id);
        return  (id > 0);
    }

    public Role read(long id) throws SQLException {
        String sqlSuffix = String.format("WHERE id=%d", id);
        List<Role> all = getAll(sqlSuffix);
        return all.size() > 0 ? all.get(0) : null;
    }

    public boolean update(Role role) throws SQLException {
        String sql = String.format(
                "UPDATE `roles` SET " +
                        "`role` = '%s'" +
                        "WHERE `roles`.`id` = %d",
                role.getRole(), role.getId());
        return Dao.executeUpdate(sql);
    }

    public boolean delete(Role role) throws SQLException {
        String sql = String.format(
                "DELETE FROM `roles` WHERE `roles`.`id` = %d",
                role.getId());
        return Dao.executeUpdate(sql);
    }

    @Override
    public List<Role> getAll(String sqlSuffix) throws SQLException {
        List<Role> result = new ArrayList<>();
        String sql = String.format("SELECT * " +
                "FROM `roles` %s", sqlSuffix);
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String strrole = resultSet.getString("role");
                Role role = new Role (id, strrole);
                result.add(role);
            }
                return result;
        }
    }
}
