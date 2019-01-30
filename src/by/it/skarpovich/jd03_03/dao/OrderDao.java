package by.it.skarpovich.jd03_03.dao;

import by.it.skarpovich.jd03_03.beans.Order;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class OrderDao implements InterfaceDao<Order> {

    public boolean create(Order order) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "INSERT INTO `orders` (`date`, `time`, `users_id`, `items_id`) " +
                        "VALUES ('%s', '%s', '%d', '%d')",
                order.getDate(), order.getTime(), order.getUsers_id(), order.getItems_id()
        );
        int id = Dao.executeCreateAndGetId(sql);
        order.setId(id);
        return (id > 0);
    }

    public boolean delete(Order order) throws SQLException {
        String sql = String.format(
                "DELETE FROM `orders` WHERE `orders`.`id` = %d",
                order.getId()
        );
        return Dao.executeUpdate(sql);
    }

    public boolean update(Order order) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "UPDATE `orders` SET " +
                        "`date` = '%s', `time` = '%s', " +
                        "`users_id` = '%d', `items_id` = '%d' " +
                        "WHERE `orders`.`id` = %d",
                order.getDate(), order.getTime(), order.getUsers_id(),
                order.getItems_id(), order.getId()
        );
        //System.out.println(sql);
        return Dao.executeUpdate(sql);
    }

    public Order read(int id) throws SQLException {
        String sqlSuffix = String.format("WHERE id=%d", id);
        List<Order> all = getAll(sqlSuffix);
        return all.size() > 0 ? all.get(0) : null;
    }



    @Override
    public List<Order> getAll(String sqlSuffix) throws SQLException {
        List<Order> result=new ArrayList<>();
        String sql = String.format("SELECT * " +
                "FROM `orders` %s",sqlSuffix);
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String date = resultSet.getString("date");
                String time = resultSet.getString("time");
                int users_id = resultSet.getInt("users_id");
                int items_id = resultSet.getInt("items_id");
                Order order = new Order(id, date, time, users_id, items_id);
                result.add(order);
            }
            return result;
        }
    }

}
