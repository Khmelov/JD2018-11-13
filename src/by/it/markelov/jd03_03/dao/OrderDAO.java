package by.it.markelov.jd03_03.dao;

import by.it.markelov.jd03_03.beans.Order;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class OrderDAO extends AbstractDAO implements InterfaceDAO<Order> {
    public Order create(Order order) throws SQLException {
        String sql = String.format(Locale.ENGLISH, "INSERT INTO `orders`(" +
                "`Shoe_name`," +
                " `Shoe_size`," +
                " `Shoe_colour`," +
                " `Price`," +
                " `users_ID`)" +
                " VALUES ('%s','%d','%s','%f','%d');", order.getShoeName(), order.getShoeSize(), order.getShoeColour(), order.getPrice(), order.getUsers_ID());
        int id = executeCreate(sql);
        if (id > 0) {
            order.setId(id);
            return order;
        } else return null;
    }

    public Order read(int id) throws SQLException {
        String where = String.format(Locale.ENGLISH, "WHERE ID='%d';", id);
        List<Order> listOrders = getAll(where);

        if (listOrders.size() == 1) {
            return listOrders.get(0);
        } else {
            return null;
        }
    }

    public boolean update(Order order) throws SQLException {
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

            return executeUpdate(sql);
        }


    public boolean delete(Order order) throws SQLException {
        String sql = String.format(Locale.ENGLISH, "DELETE FROM `orders` WHERE ID='%d';", order.getId());

        return executeUpdate(sql);
    }


    @Override
    public List<Order> getAll(String where) throws SQLException {
        List<Order> resultList = new ArrayList<>();
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(Locale.ENGLISH, " SELECT `ID`, `Shoe_name`, `Shoe_size`, `Shoe_colour`, `Price`, `users_ID` " +
                    "FROM `orders` %s", where);
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Order order = new Order(
                        resultSet.getInt("ID"),
                        resultSet.getString("Shoe_name"),
                        resultSet.getInt("Shoe_size"),
                        resultSet.getString("Shoe_colour"),
                        resultSet.getDouble("Price"),
                        resultSet.getInt("users_ID"));
                resultList.add(order);
            }
        }
        return resultList;
    }
}