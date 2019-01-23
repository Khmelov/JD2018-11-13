package by.it.markelov.jd03_03.dao;

import by.it.markelov.jd03_03.beans.ShoeName;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ShoeNameDAO extends AbstractDAO implements InterfaceDAO<ShoeName> {
    public ShoeName create(ShoeName shoeName) throws SQLException {
        String sql = String.format(Locale.ENGLISH, "INSERT INTO `shoe_names`(" +
                "`Shoe_name`, " +
                "`orders_ID`) " +
                "VALUES ('%s','%d');", shoeName.getShoeName(), shoeName.getOrders_ID());
        int id = executeCreate(sql);
        if (id > 0) {
            shoeName.setId(id);
            return shoeName;
        } else
            return null;
    }


    public ShoeName read(int id) throws SQLException {
        String where = String.format(Locale.ENGLISH, "WHERE ID='%d';", id);
        List<ShoeName> listShoeNames = getAll(where);
        if (listShoeNames.size() == 1) {
            return listShoeNames.get(0);
        } else {
            return null;
        }
    }

    public boolean update(ShoeName shoeName) throws SQLException {
        String sql = String.format(Locale.ENGLISH, "UPDATE `shoe_names` SET " +
                        "`Shoe_name`='%s',`orders_ID`='%d' WHERE ID='%d';",
                shoeName.getShoeName(),
                shoeName.getOrders_ID(),
                shoeName.getId());

        return executeUpdate(sql);
    }


    public boolean delete(ShoeName shoeName) throws SQLException {
        String sql = String.format(Locale.ENGLISH, "DELETE FROM `shoe_names` WHERE ID='%d';", shoeName.getId());

        return executeUpdate(sql);
    }


    @Override
    public List<ShoeName> getAll(String where) throws SQLException {

        List<ShoeName> resultList = new ArrayList<>();
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(Locale.ENGLISH, "SELECT `ID`, `Shoe_name`, `orders_ID` " +
                    "FROM `shoe_names` '%s';", where);
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                ShoeName shoeName = new ShoeName(
                        resultSet.getInt("ID"),
                        resultSet.getString("Shoe_name"),
                        resultSet.getInt("orders_ID"));
                resultList.add(shoeName);
            }
        }
        return resultList;
    }
}