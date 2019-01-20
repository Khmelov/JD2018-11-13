package by.it.seroglazov.jd03_02.crud;

import by.it.seroglazov.jd03_02.MyDatabaseConnector;
import by.it.seroglazov.jd03_02.beans.Ingredient;
import by.it.seroglazov.jd03_02.beans.Itag;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class IngredientCRUD {
    public boolean create(Ingredient ingredient) {
        String sql = String.format(
                "INSERT INTO `ingredients` (`id`, `name`) VALUES (DEFAULT, '%s');", ingredient.getName());
        try (Connection connection = MyDatabaseConnector.getConnection();
             Statement statement = connection.createStatement()) {
            if (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    ingredient.setId(generatedKeys.getLong(1));

                    // Insert all tags
                    for (Itag itag : ingredient.getItags()) {
                        statement.executeUpdate("INSERT INTO `ingredients_itags` (`ingredients_id`, `itags_id`) VALUES ("
                                + ingredient.getId() + ", " + itag.getId() + ");");
                    }
                }
                return true;
            }
        } catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
        }
        return false;
    }
}
