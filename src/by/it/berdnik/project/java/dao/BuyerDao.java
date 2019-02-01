package by.it.berdnik.project.java.dao;

import by.it.berdnik.project.java.beans.Buyer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class BuyerDao implements InterfaceDao<Buyer> {

    public boolean create(Buyer buyer) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "INSERT INTO `buyers`(" +
                        "`item`, `specif`, `price`," +
                        "`address`, `users_id`)" +
                        "VALUES ('%s', '%s', '%f'," +
                        "'%s','%d')",
                buyer.getItem(), buyer.getSpecif(), buyer.getPrice(),
                buyer.getAddress(), buyer.getUsers_Id());
        long id = Dao.executeCreateAndGetId(sql);
        buyer.setId(id);
        return (id > 0);
    }

    public Buyer read(long id) throws SQLException {
        String sqlSuffix = String.format("WHERE id=%d", id);
        List<Buyer> all = getAll(sqlSuffix);
        return all.size() > 0 ? all.get(0) : null;
    }

    public boolean update(Buyer buyer) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "UPDATE `buyers` SET" +
                        "`item`='%s',`specif`='%s'," +
                        "`price`='%f',`address`='%s'," +
                        "`users_id`='%d'" +
                        "WHERE `id`='%d'",
                buyer.getItem(), buyer.getSpecif(), buyer.getPrice(),
                buyer.getAddress(), buyer.getUsers_Id(), buyer.getId());
        return Dao.executeUpdate(sql);
    }

    public boolean delete(Buyer buyer) throws SQLException {
        String sql = String.format(
                "DELETE FROM `buyers` WHERE `buyers`.`id` = %d",
                buyer.getId());
        return Dao.executeUpdate(sql);
    }

    @Override
    public List<Buyer> getAll(String sqlSuffix) throws SQLException {
        List<Buyer> result = new ArrayList<>();
        String sql = String.format("SELECT * " +
                "FROM `buyers` %s", sqlSuffix);
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String item = resultSet.getString("item");
                String specif = resultSet.getString("specif");
                double price = resultSet.getDouble("price");
                String address = resultSet.getString("address");
                long users_id = resultSet.getLong("users_id");
                Buyer buyer = new Buyer(id, item, specif, price, address, users_id);
                result.add(buyer);
            }
            return result;
        }
    }
}
