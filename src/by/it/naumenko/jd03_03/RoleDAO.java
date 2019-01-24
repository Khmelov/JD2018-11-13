package by.it.naumenko.jd03_03;

import by.it.naumenko.jd03_03.beens.Roles;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RoleDAO implements InterfaceDao<Roles> {

    public boolean create(Roles roles) throws SQLException {
        String sql = String.format(
                "INSERT INTO `roles`(`role`) VALUES ('%s')",
                roles.getRole());
        long id = Dao.executeCreateAndGetId(sql);
        roles.setId_role(id);
        return (id > 0);
    }

    public boolean delete(Roles roles) throws SQLException {
        String sql = String.format(
                "DELETE FROM `roles` WHERE `roles`.`id_role` = %d",
                roles.getId_role());
        System.out.println(sql);
        return Dao.executeUpdate(sql);
    }

    public boolean update(Roles roles) throws SQLException {
        String sql = String.format("UPDATE `roles` SET `role` = %s WHERE " +
                        "`roles`.`id_role` = %d",
                roles.getRole(), roles.getId_role());

        return Dao.executeUpdate(sql);
    }


    public Roles read(long id_Role) throws SQLException {
        String sqlSuffix = String.format("WHERE `id_role`=%d", id_Role);
        List<Roles> all = getAll(sqlSuffix);
        return all.size() > 0 ? all.get(0) : null;
    }

    @Override
    public List<Roles> getAll(String sqlSuffix) throws SQLException {
        List<Roles> result = new ArrayList<>();
        String sql = String.format("SELECT * " +
                "FROM `roles` %s", sqlSuffix);
        System.out.println(sql);
        System.out.println(sqlSuffix);
        try (Connection connection = Connected.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                //id ok
                long id = resultSet.getLong("id_role");
                String strRole = resultSet.getString("role");
                Roles role = new Roles(id, strRole);
                result.add(role);
            }
            return result;
        }
    }

    @Override
    public List<Roles> getAll() throws SQLException {
        List<Roles> AllZap = new ArrayList<>();
        String sql = String.format("SELECT * FROM `roles`");
        try (Connection connection = Connected.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                //id ok
                long id = resultSet.getLong("id_role");
                String strRole = resultSet.getString("role");
                Roles role = new Roles(id, strRole);
                AllZap.add(role);
            }
            return AllZap;
        }
    }
}

