package by.it.kruglenja.jd03_03.dao;


import by.it.kruglenja.jd03_03.beans.Order;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrderDao implements InterfaceDao<Order> {

    public boolean create(Order order) throws SQLException {
        String sql = String.format("INSERT INTO `order` (`quanity`, `deliveryTime`, `totalPrice`, `users_id`)" +
                        " VALUES ('%d', '%s', '%.2f', '%d')",
                order.getQuanity(), order.getDeliveryTime(), order.getTotalPrice(), order.getUsers_id());
        long id = Dao.executeCrate(sql);
        order.setId(id);
        return (id > 0);
    }

    public boolean delete(Order order) throws SQLException {
        String sql = String.format("DELETE FROM `order` WHERE `order`.`id` = %d",
                order.getId());
        return Dao.executeUpdate(sql);

    }

    public boolean update(Order order) throws SQLException {
        String sql = String.format("UPDATE `order` SET `quanity` = '%d'," +
                        "`deliveryTime` = '%s', `totalPrice` = '%.2f', `users_id` = '%d'",
                order.getQuanity(), order.getDeliveryTime(), order.getTotalPrice(), order.getUsers_id());
        return Dao.executeUpdate(sql);
    }

    public Order read(long id) throws SQLException {
        List<Order> order = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (order.size() > 0){
            return order.get(0);
        }else {
            return null;
        }
    }

    @Override
    public List<Order> getAll(String sqlSuffix) throws SQLException {
        List<Order> orderList = new ArrayList<>();
        String sql = "SELECT * FROM order " + sqlSuffix + " ;";
        System.out.println(sql);
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet res = statement.executeQuery(sql);
            while (res.next()) {
                Order order = new Order();
                order.setId(res.getLong("id"));
                order.setQuanity(res.getInt("quanity"));
                order.setDeliveryTime(res.getString("deliveryTime"));
                order.setTotalPrice(res.getDouble("totalPrice"));
                order.setUsers_id(res.getLong("users_id"));
                orderList.add(order);
            }
        }
        return orderList;
    }
}
