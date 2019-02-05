package by.it.karnilava.jd03_03.dao;

import by.it.karnilava.jd03_03.beans.Role;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RoleDAO extends DAO implements InterfaceDAO<Role> {
    @Override
    public Role read(long id) {
        String where = String.format("WHERE id=%d", id);
        List<Role> roles = getAll(where);
        if (roles.size() > 0) {
            return roles.get(0);
        } else
            return null;

    }

    @Override
    public boolean create(Role role) throws SQLException {
        String sql = String.format(
                "INSERT INTO `karnilava1`.`role` (`role`) VALUES('%s');",
                role.getRole()
        );
        long id = DAO.executeCreateAndGetId(sql);
        role.setId(id);
        return (id > 0);

    }

    @Override
    public boolean update(Role role) throws SQLException {
        String sql = String.format(
                "UPDATE `karnilava1`.`role` SET `role` = '%s' " +
                        "WHERE  `karnilava1`.`role`.`id` =%d",

                role.getRole(), role.getId()

        );
        return (executeUpdate(sql));

    }

    @Override
    public boolean delete(Role role) throws SQLException {
        String sql = String.format("DELETE FROM `karnilava1`.`role` " +
                        "WHERE `karnilava1`.`role`.`id` =%d",
                role.getId()
        );
        return DAO.executeUpdate(sql);
    }

    @Override
    public List<Role> getAll(String WhereAndOrder) {
        List<Role> roles = new ArrayList<>();
        String sql = String.format("SELECT `id`, `role` FROM `karnilava1`.`role` " + WhereAndOrder);

        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Role role = new Role();
                role.setId(rs.getInt("id"));
                role.setRole(rs.getString("role"));

               roles.add(role);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return roles;

    }
}
