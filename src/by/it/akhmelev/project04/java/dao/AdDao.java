package by.it.akhmelev.project04.java.dao;


import by.it.akhmelev.project04.java.beans.Ad;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class AdDao implements InterfaceDao<Ad> {

    public boolean create(Ad ad) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "INSERT INTO `ads`(" +
                        "`description`, `address`, " +
                        "`floor`, `floors`, `rooms`, " +
                        "`area`, `price`, `users_id`) " +
                        "VALUES (" +
                        "'%s','%s'," +
                        "%d,%d,%d," +
                        "%f,%f,%d)",
                ad.getDescription(),ad.getAddress(),
                ad.getFloor(),ad.getFloors(),ad.getRooms(),
                ad.getArea(),ad.getPrice(),ad.getUsers_id()
        );
        long id = Dao.executeCreateAndGetId(sql);
        ad.setId(id);
        return (id > 0);
    }

    public boolean delete(Ad ad) throws SQLException {
        String sql = String.format(
                "DELETE FROM `ads` WHERE `ads`.`id` = %d",
                ad.getId()
        );
        return Dao.executeUpdate(sql);
    }

    public boolean update(Ad ad) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "UPDATE `ads` SET " +
                        "`description`='%s',`address`='%s'," +
                        "`floor`='%d',`floors`='%d',`rooms`='%d'," +
                        "`area`='%f',`price`='%f',`users_id`='%d' " +
                        "WHERE `id`='%d'",
                ad.getDescription(),ad.getAddress(),
                ad.getFloor(),ad.getFloors(),ad.getRooms(),
                ad.getArea(),ad.getPrice(),ad.getUsers_id(),
                ad.getId()
        );
        System.out.println(sql);
        return Dao.executeUpdate(sql);
    }

    public Ad read(long id) throws SQLException {
        String sqlSuffix = String.format("WHERE id=%d", id);
        List<Ad> all = getAll(sqlSuffix);
        return all.size() > 0 ? all.get(0) : null;
    }

    @Override
    public List<Ad> getAll(String sqlSuffix) throws SQLException {
        List<Ad> result=new ArrayList<>();
        String sql = String.format("SELECT * " +
                "FROM `ads` %s",sqlSuffix);
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                //id ok
                //`id`, `description`, `address`,
                // `floor`, `floors`, `rooms`,
                // `area`, `price`, `users_id`
                long id = resultSet.getLong("id");
                String description = resultSet.getString("description");
                String address = resultSet.getString("address");
                int floor = resultSet.getInt("floor");
                int floors = resultSet.getInt("floors");
                int rooms = resultSet.getInt("rooms");
                double area = resultSet.getDouble("area");
                double price = resultSet.getDouble("price");
                long users_id = resultSet.getLong("users_id");
                Ad ad = new Ad(id,description,address,floor,floors,rooms,area,price,users_id);
                result.add(ad);
            }
            return result;
        }
    }


}
