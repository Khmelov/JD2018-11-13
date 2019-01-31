package by.it.kruglenja.Project.java.dao;

import by.it.kruglenja.Project.java.beans.Order;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class OrderDao implements InterfaceDao<Order> {
    public boolean create(Order order) throws SQLException {
        String sql = String.format(Locale.US, "INSERT INTO `order`(`quanity`, `deliveryTime`, `totalPrice`, `spareParts_id`, `users_id`)"
                        + " VALUES ('%d', '%s', '%.2f', '%d', '%d')",
                order.getQuanity(), order.getDeliveryTime(), order.getTotalPrice(),
                order.getSparePart_id(), order.getUsers_id());
        System.out.println(sql);
        long id = Dao.executeCrate(sql);
        order.setId(id);
        return (id > 0);
    }

    public boolean delete(Order order) throws SQLException {
        String sql = String.format("DELETE FROM `order` WHERE `order`.`id` = %d", order.getId());
        return Dao.executeUpdate(sql);
    }

    public boolean update(Order order) throws SQLException {
        String sql = String.format(Locale.US, "UPDATE `order` SET `quanity`='%d',`deliveryTime`='%s'," +
                        "`totalPrice`='%.2f',`spareParts_id`='%d',`users_id`='%d' WHERE 1",
                order.getQuanity(), order.getDeliveryTime(), order.getTotalPrice(), order.getSparePart_id(),
                order.getUsers_id());
        return Dao.executeUpdate(sql);
    }

    public Order read(long id) throws SQLException {
        List<Order> order = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (order.size() > 0) {
            return order.get(0);
        } else {
            return null;
        }

    }

    @Override
    public List<Order> getAll(String sqlSuffix) throws SQLException {
        List<Order> sp = new ArrayList<>();
        String sql = String.format("SELECT * FROM  `order` %s", sqlSuffix);
        System.out.println(sql);
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Order order = new Order();
                order.setId(resultSet.getLong("id"));
                order.setQuanity(resultSet.getInt("quanity"));
                order.setDeliveryTime(resultSet.getString("deliveryTime"));
                order.setTotalPrice(resultSet.getDouble("totalPrice"));
                order.setSparePart_id(resultSet.getLong("spareParts_id"));
                order.setUsers_id(resultSet.getLong("users_id"));

                sp.add(order);
            }
        }
        return sp;
    }

}
