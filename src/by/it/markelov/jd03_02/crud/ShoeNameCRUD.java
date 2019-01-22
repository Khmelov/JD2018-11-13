package by.it.markelov.jd03_02.crud;

import by.it.markelov.jd03_02.beans.ShoeName;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class ShoeNameCRUD {
    public ShoeName create(ShoeName shoeName) throws SQLException {

        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {


            String sql = String.format(Locale.ENGLISH, "INSERT INTO `shoe_names`(" +
                    "`Shoe_name`, " +
                    "`orders_ID`) " +
                    "VALUES ('%s','%d');", shoeName.getShoeName(), shoeName.getOrders_ID());

            int countCreatedObject = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if (countCreatedObject == 1) {
                ResultSet keys = statement.getGeneratedKeys();
                if (keys.next()) {
                    int id = keys.getInt(1);
                    shoeName.setId(id);
                }
            }
            return shoeName;
        }
    }

    public ShoeName read(int id) throws SQLException {
        ShoeName result = null;
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(Locale.ENGLISH, "SELECT `ID`, `Shoe_name`, `orders_ID` " +
                    "FROM `shoe_names` WHERE ID='%d';", id);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                result = new ShoeName(
                        resultSet.getInt("ID"),
                        resultSet.getString("Shoe_name"),
                        resultSet.getInt("orders_ID")
                );
            }
        }
        return result;
    }

    public boolean update(ShoeName shoeName) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(Locale.ENGLISH, "UPDATE `shoe_names` SET " +
                            "`Shoe_name`='%s',`orders_ID`='%d' WHERE ID='%d';",
                    shoeName.getShoeName(),
                    shoeName.getOrders_ID(),
                    shoeName.getId());

            int countCreatedObject = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            return (countCreatedObject == 1);
        }
    }

    public boolean delete(ShoeName shoeName) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(Locale.ENGLISH, "DELETE FROM `shoe_names` WHERE ID='%d';", shoeName.getId());

            int countCreatedObject = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            return (countCreatedObject == 1);
        }
    }
}