package by.it.markelov.jd03_02.crud;

import by.it.markelov.jd03_02.beans.ShoeSize;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class ShoeSizeCRUD {
    public ShoeSize create(ShoeSize shoeSize) throws SQLException {

        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {


            String sql = String.format(Locale.ENGLISH, "INSERT INTO `shoe_sizes`(" +
                    "`Shoe_size`, " +
                    "`orders_ID`) " +
                    "VALUES ('%f','%d');", shoeSize.getShoeSize(), shoeSize.getOrders_ID());

            int countCreatedObject = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if (countCreatedObject == 1) {
                ResultSet keys = statement.getGeneratedKeys();
                if (keys.next()) {
                    int id = keys.getInt(1);
                    shoeSize.setId(id);
                }
            }
            return shoeSize;
        }
    }

    public ShoeSize read(int id) throws SQLException {
        ShoeSize result = null;
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(Locale.ENGLISH, "SELECT `ID`, `Shoe_size`, `orders_ID` " +
                    "FROM `shoe_sizes` WHERE ID='%d';", id);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                result = new ShoeSize(
                        resultSet.getInt("ID"),
                        resultSet.getDouble("Shoe_size"),
                        resultSet.getInt("orders_ID")
                );
            }
        }
        return result;
    }

    public boolean update(ShoeSize shoeSize) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(Locale.ENGLISH, "UPDATE `shoe_sizes` SET " +
                            "`Shoe_size`='%f',`orders_ID`='%d' WHERE ID='%d';",
                    shoeSize.getShoeSize(),
                    shoeSize.getOrders_ID(),
                    shoeSize.getId());

            int countCreatedObject = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            return (countCreatedObject == 1);
        }
    }

    public boolean delete(ShoeSize shoeSize) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(Locale.ENGLISH, "DELETE FROM `shoe_sizes` WHERE ID='%d';", shoeSize.getId());

            int countCreatedObject = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            return (countCreatedObject == 1);
        }
    }
}