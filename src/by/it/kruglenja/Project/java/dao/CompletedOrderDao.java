package by.it.kruglenja.Project.java.dao;

import by.it.kruglenja.Project.java.beans.CompletedOrder;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CompletedOrderDao implements InterfaceDao<CompletedOrder> {
    @Override
    public boolean create(CompletedOrder completedOrder) throws SQLException {
        String sql = String.format(Locale.US, "INSERT INTO `readyorder`(`address`, `info`,`totalPrice`, `users_id`)"
                        + " VALUES ('%s', '%s', '%.2f', '%d')",
                completedOrder.getAddress(), completedOrder.getInfo(), completedOrder.getTotalPrice(), completedOrder.getUsers_id());
        System.out.println(sql);
        long id = Dao.executeCrate(sql);
        completedOrder.setId(id);
        return (id > 0);
    }

    @Override
    public boolean update(CompletedOrder completedOrder) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(CompletedOrder completedOrder) throws SQLException {
        String sql = String.format("DELETE FROM `readyorder` WHERE `readyorder`.`id` = %d",
                completedOrder.getId());
        return Dao.executeUpdate(sql);
    }

    @Override
    public CompletedOrder read(long id) throws SQLException {
        List<CompletedOrder> completedOrders = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (completedOrders.size() > 0) {
            return completedOrders.get(0);
        } else {
            return null;
        }
    }

    @Override
    public List<CompletedOrder> getAll(String sqlSuffix) throws SQLException {
        List<CompletedOrder> completedOrders = new ArrayList<>();
        String sql = String.format("SELECT `id`, `address`, `info`, `totalPrice`, `users_id`  " +
                "FROM `readyorder` %s",sqlSuffix);
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet res = statement.executeQuery(sql);
            while (res.next()) {
                CompletedOrder completedOrder = new CompletedOrder();
                completedOrder.setId(res.getLong("id"));
                completedOrder.setAddress(res.getString("address"));
                completedOrder.setInfo(res.getString("info"));
                completedOrder.setTotalPrice(res.getDouble("totalPrice"));
                completedOrder.setUsers_id(res.getLong("users_id"));
                completedOrders.add(completedOrder);
            }
        }
        return completedOrders;
    }
}
