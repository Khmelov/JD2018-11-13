package by.it.seroglazov.jd03_02.crud;

import by.it.seroglazov.jd03_02.MyDatabaseConnector;
import by.it.seroglazov.jd03_02.beans.Unit;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UnitCRUD {
    public boolean create(Unit... ingredients) throws SQLException {
        try (Connection connection = MyDatabaseConnector.getConnection();
             Statement statement = connection.createStatement()) {
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO `units` (`id`, `name`) VALUES ");
            String value = "(DEFAULT, '%s'), ";
            for (Unit unit : ingredients) {
                sb.append(String.format(value, unit.getName()));
            }
            sb.delete(sb.length()-2, sb.length());
            sb.append(';');
            String sql = sb.toString();
            if (ingredients.length == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                for (Unit unit : ingredients) {
                    if (generatedKeys.next()) {
                        unit.setId(generatedKeys.getLong(1));
                    }
                }
                return true;
            } else
                return false;
        }
    }

    public boolean delete(Unit unit) throws SQLException {
        String sql = String.format("DELETE FROM `units` WHERE `units`.`id` = %d ", unit.getId());
        try (Connection connection = MyDatabaseConnector.getConnection();
             Statement statement = connection.createStatement()) {

            return (1 == statement.executeUpdate(sql));

        }
    }

    public boolean update(Unit unit) throws SQLException {
        String sql = String.format("UPDATE `units` SET `name` = '%s' WHERE `units`.`id` = %d;",
                unit.getName(), unit.getId());
        try (Connection connection = MyDatabaseConnector.getConnection();
             Statement statement = connection.createStatement()) {
            return (1 == statement.executeUpdate(sql));
        }
    }

    public Unit read(long id) throws SQLException {
        String sql = String.format("SELECT `name` FROM `units` WHERE id=%d", id);
        try (Connection connection = MyDatabaseConnector.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()){
                Unit unit = new Unit();
                unit.setId(id);
                unit.setName(resultSet.getString(1));
                return unit;
            } else
                return null;
        }
    }
}
