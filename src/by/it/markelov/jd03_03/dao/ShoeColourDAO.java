package by.it.markelov.jd03_03.dao;

import by.it.markelov.jd03_03.beans.ShoeColour;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ShoeColourDAO extends AbstractDAO implements InterfaceDAO<ShoeColour> {
    public ShoeColour create(ShoeColour shoeColour) throws SQLException {
        String sql = String.format(Locale.ENGLISH, "INSERT INTO `shoe_colours`(" +
                "`Shoe_colour`, " +
                "`orders_ID`) " +
                "VALUES ('%s','%d');", shoeColour.getShoeColour(), shoeColour.getOrders_ID());
        int id = executeCreate(sql);
        if (id > 0) {
            shoeColour.setId(id);
            return shoeColour;
        } else return null;
    }

    public ShoeColour read(int id) throws SQLException {
        String where = String.format(Locale.ENGLISH, "WHERE ID='%d';", id);
        List<ShoeColour> listShoeColours = getAll(where);
        if (listShoeColours.size() == 1) {
            return listShoeColours.get(0);
        } else {
            return null;
        }
    }

    public boolean update(ShoeColour shoeColour) throws SQLException {
        String sql = String.format(Locale.ENGLISH, "UPDATE `shoe_colours` SET " +
                        "`Shoe_colour`='%s'," +
                        "`orders_ID`='%d' WHERE ID='%d';",
                shoeColour.getShoeColour(),
                shoeColour.getOrders_ID(),
                shoeColour.getId());

        return executeUpdate(sql);
    }


    public boolean delete(ShoeColour shoeColour) throws SQLException {
        String sql = String.format(Locale.ENGLISH, "DELETE FROM `shoe_colours` WHERE ID='%d';", shoeColour.getId());

        return executeUpdate(sql);
    }


    @Override
    public List<ShoeColour> getAll(String where) throws SQLException {
        List<ShoeColour> resultList = new ArrayList<>();
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(Locale.ENGLISH, "SELECT `ID`, `Shoe_colour`, `orders_ID` " +
                    "FROM `shoe_colours` %s", where);
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                ShoeColour shoeColour = new ShoeColour(
                        resultSet.getInt("ID"),
                        resultSet.getString("Shoe_colour"),
                        resultSet.getInt("orders_ID"));
                resultList.add(shoeColour);
            }
        }
        return resultList;
    }
}