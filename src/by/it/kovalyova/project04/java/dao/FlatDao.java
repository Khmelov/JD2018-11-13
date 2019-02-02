package by.it.kovalyova.project04.java.dao;



import by.it.kovalyova.jd03_03.beans.Flat;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FlatDao implements InterfaceDao<Flat> {
    public boolean create(Flat flat) throws SQLException {
        String sql = String.format(
                "INSERT INTO `kovalyova`.`flats` (`description`, `address`," +
                        " `floor`, `floors`, `rooms`, `area`) VALUES\n" +
                        "'%s','%s','%d','%d','%d','%f')",
                flat.getDescription(), flat.getAddress(),
                flat.getFloor(), flat.getFloors(), flat.getArea()
        );
        long id = Dao.executeCreateAndGetId(sql);
        flat.setId(id);
        return (id > 0);


    }

    public boolean delete(Flat flat) throws SQLException {
        String sql = String.format(
                "DELETE FROM `ads` WHERE `ads`.`id` = %d",
                flat.getId()
        );
        return Dao.executeUpdate(sql);
    }

    public boolean update(Flat flat) throws SQLException {
        String sql = String.format(
                "UPDATE `kovalyova`.`flats` SET" +
                        "`description`='%s', `address`='%s'," +
                        " `floor`='%d', `floors`='%d', `rooms='%s'`, `area`='%f'" +
                        " WHERE `id`='%d'" +

                        flat.getDescription(), flat.getAddress(),
                flat.getFloor(), flat.getFloors(), flat.getArea(),flat.getId()
        );
        return Dao.executeUpdate(sql);
    }


    public Flat read(long id) throws SQLException {
        String sqlSuffix = String.format("WHERE id=%d", id);
        List<Flat> all = getAll(sqlSuffix);
        return all.size() > 0 ? all.get(0) : null;
    }

    @Override
    public List<Flat> getAll(String sqlSuffix) throws SQLException {
        List<Flat> result = new ArrayList<>();
        String sql = String.format("SELECT * " +
                "FROM `flats` %s", sqlSuffix);
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {

                //  Flat flat = new Flat(args);
                //  result.add(ad);
            }

            return result;
        }
    }
}