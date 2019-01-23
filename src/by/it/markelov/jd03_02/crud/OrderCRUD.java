package by.it.markelov.jd03_02.crud;

import by.it.markelov.jd03_02.beans.Order;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class OrderCRUD {
    public Order create(Order order) throws SQLException {

        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {


            String sql = String.format(Locale.ENGLISH, "INSERT INTO `orders`(" +
                    "`Shoe_name`," +
                    " `Shoe_size`," +
                    " `Shoe_colour`," +
                    " `Price`," +
                    " `users_ID`)" +
                    " VALUES ('%s','%d','%s','%f','%d');", order.getShoeName(), order.getShoeSize(), order.getShoeColour(), order.getPrice(), order.getUsers_ID());

            int countCreatedObject = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if (countCreatedObject == 1) {
                ResultSet keys = statement.getGeneratedKeys();
                if (keys.next()) {
                    int id = keys.getInt(1);
                    order.setId(id);
                }
            }
            return order;
        }
    }

    public Order read(int id) throws SQLException {
        Order result = null;
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(Locale.ENGLISH, " SELECT `ID`, `Shoe_name`, `Shoe_size`, `Shoe_colour`, `Price`, `users_ID` " +
                    "FROM `orders` WHERE ID='%d';", id);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                result = new Order(
                        resultSet.getInt("ID"),
                        resultSet.getString("Shoe_name"),
                        resultSet.getInt("Shoe_size"),
                        resultSet.getString("Shoe_colour"),
                        resultSet.getDouble("Price"),
                        resultSet.getInt("users_ID")
                );
            }
        }
        return result;
    }

    public boolean update(Order order) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(Locale.ENGLISH, "UPDATE `orders` SET " +
                            "`Shoe_name`='%s'," +
                            "`Shoe_size`='%d'," +
                            "`Shoe_colour`='%s'," +
                            "`Price`='%f'," +
                            "`users_ID`='%d'" +
                            " WHERE ID='%d';",
                    order.getShoeName(),
                    order.getShoeSize(),
                    order.getShoeColour(),
                    order.getPrice(),
                    order.getUsers_ID(),
                    order.getId());

            int countCreatedObject = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            return (countCreatedObject == 1);
        }
    }

    public boolean delete(Order order) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(Locale.ENGLISH, "DELETE FROM `orders` WHERE ID='%d';", order.getId());

            int countCreatedObject = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            return (countCreatedObject == 1);
        }
    }
}