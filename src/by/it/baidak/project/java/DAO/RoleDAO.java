package by.it.baidak.project.java.DAO;

import by.it.baidak.project.java.beans.Role;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RoleDAO extends AbstractDAO implements IDAO<Role> {

    @Override
    public Role read(int id) throws SQLException {
        String source = String.format("WHERE id=%d", id);
        List<Role> all = get(source);
        return all.size() > 0 ? all.get(0) : null;
    }

    @Override
    public boolean create(Role entity) throws SQLException {
        String sql = String.format(
                "INSERT INTO `roles` (`role`) " +
                        "VALUES ('%s')",
                entity.getRole()
        );
        long id = executeUpdate(sql,true);
        entity.setId(id);
        return (id > 0);
    }

    @Override
    public boolean update(Role entity) throws SQLException {
        String sql = String.format("UPDATE `roles` SET " +
                                    "`role` = '%s'" +
                                    "WHERE `roles`.`id` = %d",
                                     entity.getRole(), entity.getId()
        );
        return (executeUpdate(sql,true) > 0);
    }

    @Override
    public boolean delete(Role entity) throws SQLException {
        String sql = String.format(
                "DELETE FROM `roles` WHERE `roles`.`id` = %d",
                entity.getId()
        );
        return (executeUpdate(sql,true) > 0);
    }

    @Override
    public List<Role> get(String source) throws SQLException {
        List<Role> result=new ArrayList<>();
        String sql = String.format("SELECT * FROM `roles` %s",source);
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String strRole = resultSet.getString("role");
                Role role = new Role(id, strRole);
                result.add(role);
            }
            return result;
        }
    }
}
