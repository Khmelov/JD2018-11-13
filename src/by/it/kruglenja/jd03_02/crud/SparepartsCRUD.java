package by.it.kruglenja.jd03_02.crud;

import by.it.kruglenja.jd03_02.beans.Spareparts;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class SparepartsCRUD {
    boolean crate(Spareparts spareparts) throws SQLException {
        String sql = String.format(Locale.US, "INSERT INTO `sparepart` ( `model`, `category`, `name`, `serial_number`, `weight`, `price`)" +
                        " VALUES ('%s', '%s', '%s', '%s', '%f', '%f')",
                spareparts.getModel(), spareparts.getCategory(), spareparts.getName(),
                spareparts.getSerial_number(), spareparts.getWeight() , spareparts.getPrice());
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            if (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    spareparts.setId(generatedKeys.getLong(1));
                }
                return true;
            }
        }
        return false;
    }

    boolean delete(Spareparts spareparts) throws SQLException {
        String sql = String.format("DELETE FROM `sparepart` WHERE `sparepart`.`id` = %d", spareparts.getId());
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            return (1 == statement.executeUpdate(sql));
        }
    }

    boolean update(Spareparts spareparts) throws SQLException {
        String sql = String.format(Locale.US, "UPDATE `sparepart` SET `model` = '%s', `category` = '%s', `name` = '%s', " +
                        "`serial_number` = '%s', `weight` = '%f', `price` = '%f' WHERE `sparepart`.`id` = %d",
                spareparts.getModel(), spareparts.getCategory(), spareparts.getName(), spareparts.getSerial_number(),
                spareparts.getWeight(), spareparts.getPrice(), spareparts.getId());
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            return (1 == statement.executeUpdate(sql));
        }
    }

    Spareparts read(long id) throws SQLException {
        String sql = String.format(Locale.US,"SELECT `id`, `model`, `category`, `name`, `serial_number`, `weight`," +
                " `price` FROM `sparepart` WHERE id = %d", id);
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                String model = resultSet.getString("model");
                String category = resultSet.getString("category");
                String name = resultSet.getString("name");
                String serial_number = resultSet.getString("serial_number");
                Double weight = resultSet.getDouble("weight");
                Double price = resultSet.getDouble("price");
                return new Spareparts(id, model, category, name, serial_number, weight, price);
            } else {
                return null;
            }
        }
    }
}
