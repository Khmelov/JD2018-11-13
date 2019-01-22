package by.it.vchernetski.jd03_02.crud;

import by.it.vchernetski.jd03_02.beans.Car;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CarCRUD {

    public boolean create(Car car) throws SQLException {
        String sql = String.format("INSERT INTO `cars` " +
                        "(`model`, `color`, `year`, `garages_id`)" +
                        " VALUES ('%s', '%s', '%d', '%d')",
                car.getModel(), car.getColor(), car.getYear(), car.getGarages_id());
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            if (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    car.setId(generatedKeys.getLong(1));
                }
                return true;
            }
        }
        return false;
    }

    public  boolean delete(Car car) throws SQLException {
        String sql = String.format("DELETE FROM `cars` WHERE `cars`.`id` = %d",
                car.getId());
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            return (1 == statement.executeUpdate(sql));
        }
    }

    public  boolean update(Car car) throws SQLException {
        String sql = String.format("UPDATE `cars` SET " +
                        "`model` = '%s', " +
                        "`color` = '%s', " +
                        "`year` = '%d', " +
                        "`garages_id` = '%d' " +
                        "WHERE `cars`.`id` = %d",
                car.getModel(), car.getColor(), car.getYear(), car.getGarages_id(), car.getId());
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            return (1 == statement.executeUpdate(sql));
        }
    }

    public  Car read(long id) throws SQLException {
        String sql = String.format("SELECT `id`, " +
                "`model`, `color`, " +
                "`year`, `garages_id` FROM `cars`" +
                " WHERE id=" +
                "%d", id);
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            if(resultSet.next()){
                return new Car(id, resultSet.getString("model"),
                        resultSet.getString("color"),resultSet.getInt("year"),
                        resultSet.getLong("garages_id"));
            }
            else return null;
        }
    }
}
