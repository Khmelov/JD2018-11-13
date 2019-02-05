package by.it.zakharenko.jd03_02.crud;

import by.it.zakharenko.jd03_02.beans.Item;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class ItemCRUD {

    boolean create(Item item) throws SQLException {
        String sql = String.format(
                "INSERT INTO `items` (`title`, `price`) " +
                        "VALUES ('%s', '%d')",
                item.getTitle(),  item.getPrice()
        );
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            if (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    item.setId(generatedKeys.getInt(1));
                }
                return true;
            }
        }
        return false;
    }

    boolean delete(Item item) throws SQLException {
        String sql = String.format(
                "DELETE FROM `items` WHERE `items`.`id` = %d",
                item.getId()
        );
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            return (1 == statement.executeUpdate(sql));
        }
    }

    boolean update(Item item) throws SQLException {
        String sql = String.format(
                "UPDATE `items` SET " +
                        "`title` = '%s'" +
                        "`price` = '%d' " +
                        "WHERE `items`.`id` = %d",
                item.getTitle(), item.getPrice(), item.getId()

        );
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            return (1 == statement.executeUpdate(sql));
        }
    }

    Item read(int id) throws SQLException {
        String sql = String.format("SELECT `title`, `price` " +
                "FROM `items` WHERE id=%d", id);
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                //id ok
                String title = resultSet.getString("title");
                int price = resultSet.getInt("price");
                return new Item(id, title, price);
            } else
                return null;
        }
    }

}
