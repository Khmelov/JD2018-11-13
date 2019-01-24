package by.it.vchernetski.jd03_02.crud;

import by.it.vchernetski.jd03_02.beans.Garage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GarageCRUD {

    public  boolean create(Garage garage) throws SQLException {
        String sql = String.format("INSERT INTO `garages` " +
                "(`adress`, `carplaces`, `users_id`) " +
                "VALUES ('%s', '%d', '%d')", garage.getAdress(), garage.getCarplaces(), garage.getUsers_id());
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            if (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    garage.setId(generatedKeys.getLong(1));
                }
                return true;
            }
        }
        return false;
    }

    public  boolean delete(Garage garage) throws SQLException {
        String sql = String.format("DELETE FROM `garages` " +
                "WHERE `garages`.`id` = %d", garage.getId());
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            return (1==statement.executeUpdate(sql));
        }
    }

    public  boolean update(Garage garage) throws SQLException {
        String sql = String.format("UPDATE `garages` SET " +
                "`adress` = '%s', " +
                "`carplaces` = '%d', " +
                "`users_id` = '%d' " +
                "WHERE `garages`.`id` = %d",
                garage.getAdress(), garage.getCarplaces(),garage.getUsers_id(), garage.getId());
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            return (1==statement.executeUpdate(sql));
        }
    }

    public  Garage read(long id) throws SQLException {
        String sql = String.format("SELECT `id`, " +
                "`adress`, `carplaces`, `users_id` " +
                "FROM `garages` WHERE id=%d",
                id);
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            if(resultSet.next()){
                return new Garage(id,
                        resultSet.getString("adress"),
                        resultSet.getInt("carplaces"),
                        resultSet.getLong("users_id"));
            }
            else return null;
        }
    }
}

