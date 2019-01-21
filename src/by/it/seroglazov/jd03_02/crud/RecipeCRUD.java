package by.it.seroglazov.jd03_02.crud;

import by.it.seroglazov.jd03_02.MyDatabaseConnector;
import by.it.seroglazov.jd03_02.beans.Amount;
import by.it.seroglazov.jd03_02.beans.Ingredient;
import by.it.seroglazov.jd03_02.beans.Recipe;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RecipeCRUD {

    // Insert in tables recipes and insert all relatives with itags in table ingredients_itags
    // just with 2 sql requests
    public boolean create(Recipe... recipes) throws SQLException {
        try (Connection connection = MyDatabaseConnector.getConnection();
             Statement statement = connection.createStatement()) {
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO `recipes` (`id`, `name`, `description`, `rtype_id`) VALUES ");
            String value = "(DEFAULT, '%s', '%s', %d), ";
            for (Recipe recipe : recipes) {
                sb.append(String.format(value, recipe.getName(), recipe.getDescription(), recipe.getRtype().getId()));
            }
            sb.delete(sb.length() - 2, sb.length());
            sb.append(';');
            String sql = sb.toString();
            if (recipes.length == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                for (Recipe recipe : recipes) {
                    if (generatedKeys.next()) {
                        recipe.setId(generatedKeys.getLong(1));
                    }
                }
                // Insert relatives
                sb.setLength(0);
                sb.append("INSERT INTO `amounts` (`recipe_id`, `ingredient_id`, `amount`, `unit_id`) VALUES ");
                value = "(%d, %d, '%s', %d), ";
                int counter = 0;
                for (Recipe recipe : recipes) {
                    for (Amount amount : recipe.getAmounts()) {
                        sb.append(String.format(value, recipe.getId(), amount.getIngredient().getId(), amount.getText(), amount.getUnit().getId()));
                        counter++;
                    }
                }
                sb.delete(sb.length() - 2, sb.length());
                sb.append(';');
                sql = sb.toString();
                return statement.executeUpdate(sql) == counter;
            } else
                return false;
        }
    }

    public boolean delete(Recipe recipe) throws SQLException {
        String sql = String.format("DELETE FROM `recipes` WHERE `recipes`.`id` = %d", recipe.getId());
        String sqlDelTags = String.format("DELETE FROM `amounts` WHERE recipe_id = %d", recipe.getId());
        try (Connection connection = MyDatabaseConnector.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(sqlDelTags);
            return (1 == statement.executeUpdate(sql));
        }
    }

    public boolean update(Recipe recipe) throws SQLException {
        String sql = String.format("UPDATE `recipes` SET `name`='%s' WHERE `recipes`.`id` = %d",
                recipe.getName(), recipe.getId());
        String sqlDelTags = String.format("DELETE FROM `amounts` WHERE recipe_id = %d", recipe.getId());
        //String sqlInsTags = String.format("INSERT INTO `ingredients_itags` WHERE ingredients_id = %d", recipe.getId());
        try (Connection connection = MyDatabaseConnector.getConnection();
             Statement statement = connection.createStatement()) {
            if (1 == statement.executeUpdate(sql)) {
                statement.executeUpdate(sqlDelTags);
                StringBuilder sb = new StringBuilder();
                sb.setLength(0);
                sb.append("INSERT INTO `amounts` (`recipe_id`, `ingredient_id`, `amount`, `unit_id`) VALUES ");
                String value = "(%d, %d, '%s', %d), ";
                int counter = 0;
                for (Amount amount : recipe.getAmounts()) {
                    sb.append(String.format(value, recipe.getId(), amount.getIngredient().getId(), amount.getText(), amount.getUnit().getId()));
                    counter++;
                }
                sb.delete(sb.length() - 2, sb.length());
                sb.append(';');
                sql = sb.toString();
                return statement.executeUpdate(sql) == counter;
            }
        }
        return false;
    }

    /*public Recipe read(long id) throws SQLException {
        String sql = String.format("SELECT `name`, `description`, `rtype_id` FROM `recipes` WHERE id=%d", id);
        String sqlTags = String.format("SELECT amounts.ingredient_id, .text FROM ingredients_itags " +
                "INNER JOIN itags ON ingredients_itags.itags_id = itags.id " +
                "WHERE ingredients_itags.ingredients_id = %d", id); // I wrote this SQL request by hands, cool!
        try (Connection connection = MyDatabaseConnector.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            Recipe recipe;
            if (resultSet.next()) {
                recipe = new Recipe();
                recipe.setId(id);
                recipe.setName(resultSet.getString(1));
            } else
                return null;
            ResultSet resultSetTags = statement.executeQuery(sqlTags);
            while (resultSetTags.next()) {
                Ingredient ingredient = new Ingredient(resultSetTags.getLong(1), resultSetTags.getString(2));
                recipe.addIngredient(ingredient);
            }
            return recipe;
        }
    }*/


}
