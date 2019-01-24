package by.it.markelov.jd03_02.crud;

import by.it.markelov.jd03_02.beans.ShoeColour;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class ShoeColourCRUD {
    public ShoeColour create(ShoeColour shoeColour) throws SQLException {

        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {


            String sql = String.format(Locale.ENGLISH, "INSERT INTO `shoe_colours`(" +
                    "`Shoe_colour`, " +
                    "`orders_ID`) " +
                    "VALUES ('%s','%d');", shoeColour.getShoeColour(), shoeColour.getOrders_ID());

            int countCreatedObject = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if (countCreatedObject == 1) {
                ResultSet keys = statement.getGeneratedKeys();
                if (keys.next()) {
                    int id = keys.getInt(1);
                    shoeColour.setId(id);
                }
            }
            return shoeColour;
        }
    }

    public ShoeColour read(int id) throws SQLException {
        ShoeColour result = null;
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(Locale.ENGLISH, "SELECT `ID`, `Shoe_colour`, `orders_ID` " +
                    "FROM `shoe_colours` WHERE ID='%d';", id);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                result = new ShoeColour(
                        resultSet.getInt("ID"),
                        resultSet.getString("Shoe_colour"),
                        resultSet.getInt("orders_ID")
                );
            }
        }
        return result;
    }

    public boolean update(ShoeColour shoeColour) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(Locale.ENGLISH, "UPDATE `shoe_colours` SET " +
                            "`Shoe_colour`='%s'," +
                            "`orders_ID`='%d' WHERE ID='%d';",
                    shoeColour.getShoeColour(),
                    shoeColour.getOrders_ID(),
                    shoeColour.getId());

            int countCreatedObject = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            return (countCreatedObject == 1);
        }
    }

    public boolean delete(ShoeColour shoeColour) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(Locale.ENGLISH, "DELETE FROM `shoe_colours` WHERE ID='%d';", shoeColour.getId());

            int countCreatedObject = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            return (countCreatedObject == 1);
        }
    }
}