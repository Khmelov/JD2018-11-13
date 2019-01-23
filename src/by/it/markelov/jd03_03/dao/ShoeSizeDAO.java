package by.it.markelov.jd03_03.dao;

import by.it.markelov.jd03_03.beans.ShoeSize;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ShoeSizeDAO extends AbstractDAO implements InterfaceDAO<ShoeSize> {
    public ShoeSize create(ShoeSize shoeSize) throws SQLException {
        String sql = String.format(Locale.ENGLISH, "INSERT INTO `shoe_sizes`(" +
                "`Shoe_size`, " +
                "`orders_ID`) " +
                "VALUES ('%f','%d');", shoeSize.getShoeSize(), shoeSize.getOrders_ID());
        int id = executeCreate(sql);
        if (id > 0) {
            shoeSize.setId(id);
            return shoeSize;
        } else {
            return null;
        }
    }

    public ShoeSize read(int id) throws SQLException {
        String where = String.format(Locale.ENGLISH, "WHERE ID='%d';", id);
        List<ShoeSize> listShoeSizes = getAll(where);
        if (listShoeSizes.size() == 1) {
            return listShoeSizes.get(0);
        } else {
            return null;
        }
    }

    public boolean update(ShoeSize shoeSize) throws SQLException {
        String sql = String.format(Locale.ENGLISH, "UPDATE `shoe_sizes` SET " +
                        "`Shoe_size`='%f',`orders_ID`='%d' WHERE ID='%d';",
                shoeSize.getShoeSize(),
                shoeSize.getOrders_ID(),
                shoeSize.getId());

        return executeUpdate(sql);
    }


    public boolean delete(ShoeSize shoeSize) throws SQLException {
        String sql = String.format(Locale.ENGLISH, "DELETE FROM `shoe_sizes` WHERE ID='%d';", shoeSize.getId());

        return executeUpdate(sql);
    }


    @Override
    public List<ShoeSize> getAll(String where) throws SQLException {
        List<ShoeSize> resultList = new ArrayList<>();
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(Locale.ENGLISH, "SELECT `ID`, `Shoe_size`, `orders_ID` " +
                    "FROM `shoe_sizes` %s", where);
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                ShoeSize shoeSize = new ShoeSize(
                        resultSet.getInt("ID"),
                        resultSet.getDouble("Shoe_size"),
                        resultSet.getInt("orders_ID"));
                resultList.add(shoeSize);
            }
        }
        return resultList;
    }
}