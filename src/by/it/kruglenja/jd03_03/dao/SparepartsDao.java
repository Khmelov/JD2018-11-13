package by.it.kruglenja.jd03_03.dao;

import by.it.kruglenja.jd03_03.beans.Spareparts;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SparepartsDao implements InterfaceDao<Spareparts> {
    public boolean create(Spareparts spareparts) throws SQLException {
        String sql = String.format(Locale.US, "INSERT INTO `spareparts` ( `model`, `category`, `name`, `serial_number`, `weight`, `price`)" +
                        " VALUES ('%s', '%s', '%s', '%s', '%f', '%f')",
                spareparts.getModel(), spareparts.getCategory(), spareparts.getName(),
                spareparts.getSerial_number(), spareparts.getWeight(), spareparts.getPrice());
        long id = Dao.executeCrate(sql);
        spareparts.setId(id);
        return (id > 0);
    }

    public boolean delete(Spareparts spareparts) throws SQLException {
        String sql = String.format("DELETE FROM `sparepart` WHERE `spareparts`.`id` = %d", spareparts.getId());
        return Dao.executeUpdate(sql);
    }

    public boolean update(Spareparts spareparts) throws SQLException {
        String sql = String.format(Locale.US, "UPDATE `spareparts` SET `model` = '%s', `category` = '%s', `name` = '%s', " +
                        "`serial_number` = '%s', `weight` = '%f', `price` = '%f' WHERE `sparepart`.`id` = %d",
                spareparts.getModel(), spareparts.getCategory(), spareparts.getName(), spareparts.getSerial_number(),
                spareparts.getWeight(), spareparts.getPrice(), spareparts.getId());
        return Dao.executeUpdate(sql);
    }

    public Spareparts read(long id) throws SQLException {
        List<Spareparts> spareparts = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (spareparts.size() > 0){
            return spareparts.get(0);
        }else {
            return null;
        }

    }

    @Override
    public List<Spareparts> getAll(String sqlSuffix) throws SQLException {
        List<Spareparts> sp = new ArrayList<>();
        String sql = "SELECT * FROM  spareparts " + sqlSuffix + " ;";
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Spareparts spareparts = new Spareparts();
                spareparts.setId(resultSet.getLong("id"));
                spareparts.setModel(resultSet.getString("model"));
                spareparts.setCategory(resultSet.getString("category"));
                spareparts.setName(resultSet.getString("name"));
                spareparts.setSerial_number(resultSet.getString("serial_number"));
                spareparts.setWeight(resultSet.getDouble("weight"));
                spareparts.setPrice(resultSet.getDouble("price"));

                sp.add(spareparts);
            }
        }
        return sp;
    }

}
