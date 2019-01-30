package by.it.mnovikov.project.java.dao;

import by.it.mnovikov.project.java.beans.Role;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RoleDao implements InterfaceDao<Role> {

    public boolean create(Role role) throws SQLException {
        String sql = String.format(
                "INSERT INTO `roles` (`role`) " +
                        "VALUES ('%s')",
                role.getRole()
        );
        int id = Dao.executeCreateAndGetId(sql);
        role.setId(id);
        return (id > 0);
    }

    public boolean delete(Role role) throws SQLException {
        String sql = String.format(
                "DELETE FROM `roles` WHERE `roles`.`ID` = %d",
                role.getId()
        );
        return Dao.executeUpdate(sql);
    }

    public boolean update(Role role) throws SQLException {
        String sql = String.format(
                "UPDATE `roles` SET " +
                        "`role` = '%s'" +
                        "WHERE `roles`.`ID` = %d",
                role.getRole(), role.getId()
        );
        return Dao.executeUpdate(sql);
    }

    public Role read(int id) throws SQLException {
        String sqlSuffix = String.format("WHERE ID=%d", id);
        List<Role> all = getAll(sqlSuffix);
        return all.size() > 0 ? all.get(0) : null;
    }

    @Override
    public List<Role> getAll(String sqlSuffix) throws SQLException {
        List<Role> result=new ArrayList<>();
        String sql = String.format("SELECT * " +
                "FROM `roles` %s",sqlSuffix);
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                //id ok
                int id = resultSet.getInt("ID");
                String strRole = resultSet.getString("role");
                Role role = new Role(id, strRole);
                result.add(role);
            }
            return result;
        }
    }


}
