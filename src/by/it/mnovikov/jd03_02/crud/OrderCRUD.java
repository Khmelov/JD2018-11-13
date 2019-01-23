package by.it.mnovikov.jd03_02.crud;

import by.it.mnovikov.jd03_02.beans.Order;

import java.sql.*;

public class OrderCRUD {

    public boolean create(Order order) throws SQLException {
        String sql = String.format(
                "INSERT INTO `orders`(`date`, `users_ID`)" +
                        "VALUES ('%s', '%d')",
                order.getDate(), order.getUsers_ID()
        );
        try (Statement statement = Connect_DB.getConnection().createStatement()) {
            if (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet keys = statement.getGeneratedKeys();
                if (keys.next()) {
                    order.setId(keys.getInt(1));
                }
                return true;
            }
        }
        return false;
    }

    public boolean delete(Order order) throws SQLException {
        String sql = String.format(
                "DELETE FROM `orders` WHERE `orders`.`id`='%d'", order.getId());
        try (Statement statement = Connect_DB.getConnection().createStatement()) {
            return 1 == statement.executeUpdate(sql);
        }
    }

    public boolean update(Order order) throws SQLException {
        String sql = String.format(
                "UPDATE `orders` SET `date`='%s',`users_ID`='%d' WHERE `orders`.`id`='%d'",
                order.getDate(), order.getUsers_ID(), order.getId()
        );
        try (Statement statement = Connect_DB.getConnection().createStatement()) {
            return 1 == statement.executeUpdate(sql);
        }
    }

    public Order read(int id) throws SQLException {
        String sql = String.format(
                "SELECT `ID`, `date`, `users_ID` FROM `orders` WHERE `orders`.`id`='%d'", id);
        try (Statement statement = Connect_DB.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                int orderId = resultSet.getInt("id");
                Timestamp date = resultSet.getTimestamp("date");
                int users_ID = resultSet.getInt("users_ID");
                return new Order();
            } else return null;
        }
    }
}
