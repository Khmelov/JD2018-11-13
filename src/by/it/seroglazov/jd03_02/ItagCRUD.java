package by.it.seroglazov.jd03_02;

import by.it.seroglazov.jd03_02.beans.Ingredient;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ItagCRUD {

    public boolean create(Ingredient... ingredients) throws SQLException {
        try (Connection connection = MyDatabaseConnector.getConnection();
             Statement statement = connection.createStatement()) {
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO `ingredients` (`id`, `text`) VALUES ");
            String value = "(DEFAULT, '%s'), ";
            for (Ingredient ingredient : ingredients) {
                sb.append(String.format(value, ingredient.getName()));
            }
            sb.delete(sb.length()-2, sb.length());
            sb.append(';');
            String sql = sb.toString();
            if (ingredients.length == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                for (Ingredient ingredient : ingredients) {
                    if (generatedKeys.next()) {
                        ingredient.setId(generatedKeys.getLong(1));
                    }
                }
                return true;
            } else
                return false;
        }
    }

    public boolean delete(Ingredient ingredient) throws SQLException {
        String sql = String.format("DELETE FROM `itags` WHERE `itags`.`id` = %s ", ingredient.getId());
        try (Connection connection = MyDatabaseConnector.getConnection();
             Statement statement = connection.createStatement()) {

            return (1 == statement.executeUpdate(sql));

        }
    }

    public boolean update(Ingredient ingredient) throws SQLException {
        String sql = String.format("UPDATE `itags` SET `text` = '%s' WHERE `itags`.`id` = %d;",
                ingredient.getName(), ingredient.getId());
        try (Connection connection = MyDatabaseConnector.getConnection();
             Statement statement = connection.createStatement()) {
            return (1 == statement.executeUpdate(sql));
        }
    }

    public Ingredient read(long id) throws SQLException {
        String sql = String.format("SELECT `text` FROM `itags` WHERE id=%d", id);
        try (Connection connection = MyDatabaseConnector.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()){
                Ingredient ingredient = new Ingredient();
                ingredient.setId(id);
                ingredient.setName(resultSet.getString(1));
                return ingredient;
            } else
                return null;
        }
    }
}
