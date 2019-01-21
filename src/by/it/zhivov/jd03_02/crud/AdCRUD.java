package by.it.zhivov.jd03_02.crud;

import by.it.zhivov.jd03_02.beans.Ad;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdCRUD {
    boolean create(Ad ad) throws SQLException {
        String sqlCmd = String.format("INSERT INTO `ads` " +
                        "(`title`," +
                        "`description`, " +
                        "`brand`," +
                        "`model`," +
                        "`color`," +
                        "`body`," +
                        "`year`," +
                        "`equipment`," +
                        "`mileage`," +
                        "`crashed`," +
                        "`price`," +
                        "`users_id`) " +
                        " VALUES ('%s','%s','%s','%s','%s','%s','%d','%s','%d','%b','%d','%d')",
                ad.getTitle(), ad.getDescription(), ad.getBrnd(), ad.getModel(), ad.getColor(), ad.getBody(), ad.getYear(), ad.getEquipment(),
                ad.getMillage(), ad.isCrashed(), ad.getPrice(), ad.getId_User());
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            if (1 == statement.executeUpdate(sqlCmd, statement.RETURN_GENERATED_KEYS)) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    ad.setId(generatedKeys.getLong(1));
                }
                return true;
            }
        }
        return false;
    }

    Ad read(long id) throws SQLException {
        String sqlCmd = String.format("SELECT `id`, `title`, `description`, `brand`, `model`, `color`, `body`, `year`," +
                " `equipment`, `mileage`, `crashed`, `price`, `users_id` FROM `ads` WHERE id=%d", id);
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sqlCmd);
            if (resultSet.next()) {
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                String brand = resultSet.getString("brand");
                String model = resultSet.getString("model");
                String color = resultSet.getString("color");
                String body = resultSet.getString("body");
                int year = resultSet.getInt("year");
                String equipment = resultSet.getString("equipment");
                int mileage = resultSet.getInt("mileage");
                boolean crashed = resultSet.getBoolean("crashed");
                int price = resultSet.getInt("price");
                long users_id = resultSet.getLong("users_id");
                return new Ad(id, title, description, brand, model, color, body, year, equipment, mileage, crashed, price, users_id);
            } else return null;
        }
    }

    boolean update(Ad ad) throws SQLException {
        String sqlCmd = String.format(
                "UPDATE `ads` SET " +
                        "`title`='%s'," +
                        "`description`='%s'," +
                        "`brand`='%s'," +
                        "`model`='%s'," +
                        "`color`='%s'," +
                        "`body`='%s'," +
                        "`year`='%d'," +
                        "`equipment`='%s'," +
                        "`mileage`='%d'," +
                        "`crashed`='%b'," +
                        "`price`='%d'," +
                        "`users_id`='%d' " +
                        "WHERE `ads`.`id`=%d",
                ad.getTitle(), ad.getDescription(), ad.getBrnd(), ad.getModel(),
                ad.getColor(), ad.getBody(), ad.getYear(), ad.getEquipment(), ad.getMillage(),
                ad.isCrashed(), ad.getPrice(),ad.getId_User(), ad.getId()
        );
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            return ( 1 == statement.executeUpdate(sqlCmd) );
        }
    }

    boolean delete(Ad ad) throws SQLException {
        String sqlCmd = String.format("DELETE FROM `ads` WHERE `ads`.`id`=%d", ad.getId());
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            return ( 1 == statement.executeUpdate(sqlCmd) );
        }
    }
}