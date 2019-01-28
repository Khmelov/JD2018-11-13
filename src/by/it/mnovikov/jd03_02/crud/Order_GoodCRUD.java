package by.it.mnovikov.jd03_02.crud;

import by.it.mnovikov.jd03_02.beans.Order_Good;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Struct;

public class Order_GoodCRUD {

    public boolean create(Order_Good order_good) throws SQLException {
        String sql = String.format("INSERT INTO `orders_goods`" +
                        "(`ID`, `orders_ID`, `goods_ID`) " +
                        "VALUES ('%d','%d','%d')",
                order_good.getId(), order_good.getOrders_id(), order_good.getGoods_id()
        );
        try (Statement statement = Connect_DB.getConnection().createStatement()) {
            if (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet keys = statement.getGeneratedKeys();
                if (keys.next()) {
                    order_good.setId(keys.getInt("1"));
                }
                return true;
            }
        }
        return false;
    }

    public boolean delete(Order_Good order_good) throws SQLException {
        String sql = String.format("DELETE FROM `orders_goods`" +
                "WHERE `orders_goods`.`id` = '%d'", order_good.getId()
        );
        try (Statement statement = Connect_DB.getConnection().createStatement()) {
            return 1 == statement.executeUpdate(sql);
        }
    }

    public boolean update(Order_Good order_good) throws SQLException {
        String sql = String.format("UPDATE `orders_goods` SET" +
                        "`orders_ID`='%d',`goods_ID`='%d' WHERE `orders_goods`.`id` = '%d',",
                order_good.getOrders_id(), order_good.getGoods_id(), order_good.getId()
        );
        try (Statement statement = Connect_DB.getConnection().createStatement()) {
            return 1 == statement.executeUpdate(sql);
        }
    }

    public Order_Good read(int id) throws SQLException {
        String sql = String.format("SELECT `ID`, `orders_ID`, `goods_ID`" +
                "FROM `orders_goods` WHERE `orders_goods`.`id` = '%d'", id);
        try (Statement statement = Connect_DB.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                int orders_id = resultSet.getInt("orders_ID");
                int goods_id = resultSet.getInt("goods_ID");
                return new Order_Good(id, orders_id, goods_id);
            } else return null;
        }
    }
}
