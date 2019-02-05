package by.it.zakharenko.jd03_02.crud;

import by.it.zakharenko.jd03_02.beans.Order;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OrderCRUD {


    boolean create(Order order) throws SQLException {
        String sql = String.format(
                "INSERT INTO `orders` (`date`, `time`, `users_id`, `items_id`) " +
                        "VALUES ('%s', '%s', '%d', '%d')",
                order.getDate(), order.getTime(), order.getUsers_id(), order.getItems_id()
        );
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            if (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    order.setId(generatedKeys.getInt(1));
                }
                return true;
            }
        }
        return false;
    }

    boolean delete(Order order) throws SQLException {
        String sql = String.format(
                "DELETE FROM `orders` WHERE `orders`.`id` = %d",
                order.getId()
        );
        try (Connection connection = Connect.getConnection();

             Statement statement = connection.createStatement()) {
            return (1 == statement.executeUpdate(sql));
        }
    }

    boolean update(Order order) throws SQLException {
        String sql = String.format(
                "UPDATE `orders` SET " +
                        "`date` = '%s', `time` = '%s', " +
                        "`users_id` = '%d', `items_id` = '%d' " +
                        "WHERE `orders`.`id` = %d",
                order.getDate(), order.getTime(), order.getUsers_id(),
                order.getItems_id(), order.getId()

        );
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            return (1 == statement.executeUpdate(sql));
        }
    }

    Order read(int id) throws SQLException {
        String sql = String.format("SELECT `date`, `time`, `users_id`, `items_id` " +
                "FROM `orders` WHERE id=%d", id);
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                //id ok
                String date = resultSet.getString("date");
                String time = resultSet.getString("time");

                int users_id = resultSet.getInt("users_id");
                int items_id = resultSet.getInt("items_id");
                return new Order(id, date, time, users_id, items_id);
            } else
                return null;
        }
    }

}
