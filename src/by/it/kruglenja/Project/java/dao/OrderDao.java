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
        String sql = String.format(Locale.US, "INSERT INTO `order`(`quanity`,`model`,`name`,`price`,`users_id`, `spareParts_id`)"
                        + " VALUES ('%d', '%s', '%s','%.2f', '%d', '%d')",
                order.getQuanity(), order.getModel(), order.getName(), order.getPrice(),
                order.getUsers_id(), order.getSpareParts_id());
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
        String sql = String.format(Locale.US, "UPDATE `order` SET `quanity`='%d',`model`='%s',`name`='%s',`price`='%.2f'," +
                        "`users_id`='%d',`spareParts_id`='%d' WHERE `order`.`id` = '%d'",

                order.getQuanity(), order.getModel(), order.getName(), order.getPrice(),
                order.getUsers_id(), order.getSpareParts_id(), order.getId());
        System.out.println(sql);

        return Dao.executeUpdate(sql);
    }

    public Order read(long id) throws SQLException {
        List<Order> order = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (order.size() > 0) {
            return order.get(0);
        } else {
            return null;
        }
//        SELECT `spareparts`.`model`, `spareparts`.`name`, `spareparts`.`price` FROM `order` INNER JOIN spareparts ON spareparts.id = order.spareParts_id
//        SELECT `spareparts`.`model`, `spareparts`.`name`, `spareparts`.`price` FROM `order` INNER JOIN spareparts ON spareparts.id = order.spareParts_id AND `order`.`users_id` =1
    }
public void getSparepartsTableCols(long id){
    String sql = String.format("SELECT * FROM  `order` %s");
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
                order.setModel(resultSet.getString("model"));
                order.setName(resultSet.getString("name"));
                order.setPrice(resultSet.getDouble("price"));
                order.setUsers_id(resultSet.getLong("users_id"));
                order.setSpareParts_id(resultSet.getLong("spareParts_id"));
                sp.add(order);
            }
        }
        return sp;
    }
}
