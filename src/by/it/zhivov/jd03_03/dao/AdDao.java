package by.it.zhivov.jd03_03.dao;

import by.it.zhivov.jd03_03.beans.Ad;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AdDao implements InterfaceDao<Ad> {
    public boolean create(Ad ad) throws SQLException {
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
        long id = Dao.executeCreateAndGetId(sqlCmd);
        ad.setId(id);
        return id > 0;
    }

    public Ad read(long id) throws SQLException {
        String sqlSuffix = String.format(" WHERE id=%d", id);
        List<Ad> all = getAll(sqlSuffix);
        return all.size() > 0 ? all.get(0) : null;
    }

    public boolean update(Ad ad) throws SQLException {
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
                ad.isCrashed(), ad.getPrice(), ad.getId_User(), ad.getId()
        );
        return Dao.executeUpdate(sqlCmd);
    }

    public boolean delete(Ad ad) throws SQLException {
        String sqlCmd = String.format("DELETE FROM `ads` WHERE `ads`.`id`=%d", ad.getId());
        return Dao.executeUpdate(sqlCmd);
    }

    public List<Ad> getAll(String sqlSuffix) throws SQLException {
        List<Ad> result = new ArrayList<>();
        String sqlCmd = String.format("SELECT * " +
                "FROM `ads` %s", sqlSuffix);
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sqlCmd);
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
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
                Ad ad = new Ad(id, title, description, brand, model, color, body, year, equipment, mileage, crashed, price, users_id);
                result.add(ad);
            }
            return result;
        }
    }
}
