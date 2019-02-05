package by.it.karnilava.jd03_03.dao;

import by.it.karnilava.jd03_03.beans.Type;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TypeDAO extends DAO implements InterfaceDAO<Type> {
    @Override
    public Type read(long id) {
        String where = String.format("WHERE id=%d", id);
        List<Type> types = getAll(where);
        if (types.size() > 0) {
            return types.get(0);

        } else
            return null;
    }

    @Override
    public boolean create(Type type) throws SQLException {
        String sql = String.format(
                "INSERT INTO `karnilava1`.`type` (`type`) VALUES('%s');",
                type.getType()
        );
        long id = DAO.executeCreateAndGetId(sql);
        type.setId(id);
        return (id > 0);

    }

    @Override
    public boolean update(Type type) throws SQLException {
        String sql = String.format(
                "UPDATE `karnilava1`.`type` SET `type` = '%s' " +
                        "WHERE  `karnilava1`.`type`.`id` =%d",

                type.getType(), type.getId()

        );
        return (executeUpdate(sql));

    }

    @Override
    public boolean delete(Type type) throws SQLException {
        String sql = String.format("DELETE FROM `karnilava1`.`type` " +
                        "WHERE `karnilava1`.`type`.`id` =%d",
                type.getId()
        );
        return DAO.executeUpdate(sql);
    }

    @Override
    public List<Type> getAll(String WhereAndOrder) {
        List<Type> types = new ArrayList<>();
        String sql = String.format("SELECT `id`, `type` FROM `karnilava1`.`type` " + WhereAndOrder);

        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Type type = new Type();
                type.setId(rs.getInt("id"));
                type.setType(rs.getString("type"));

                types.add(type);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return types;

    }
}
