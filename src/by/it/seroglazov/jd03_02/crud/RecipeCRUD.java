package by.it.seroglazov.jd03_02.crud;

import by.it.seroglazov.jd03_02.MyDatabaseConnector;
import by.it.seroglazov.jd03_02.Amount;
import by.it.seroglazov.jd03_02.beans.Ingredient;
import by.it.seroglazov.jd03_02.beans.Recipe;
import by.it.seroglazov.jd03_02.beans.Rtype;
import by.it.seroglazov.jd03_02.beans.Unit;

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
                sb.append("INSERT INTO `amounts` (`recipe_id`, `ingredient_id`, `text`, `unit_id`) VALUES ");
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
                sb.append("INSERT INTO `amounts` (`recipe_id`, `ingredient_id`, `text`, `unit_id`) VALUES ");
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

    public Recipe read(long id) throws SQLException {
        String sql = String.format("SELECT recipes.name, recipes.description, recipes.rtype_id, rtypes.text " +
                "FROM `recipes` " +
                "INNER JOIN rtypes ON rtypes.id = recipes.rtype_id " +
                "WHERE recipes.id = %d", id); // Wrote by hand too
        String sql2 = String.format(
                "SELECT amounts.ingredient_id, ingredients.name, " +
                        "amounts.unit_id, units.name, " +
                        "amounts.text FROM amounts\n" +
                        "INNER JOIN ingredients ON amounts.ingredient_id = ingredients.id\n" +
                        "INNER JOIN units ON amounts.unit_id = units.id\n" +
                        "WHERE `amounts`.`recipe_id` = %d", id); // Belive or not I wrote this SQL request by hands, cool!
        try (Connection connection = MyDatabaseConnector.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            Recipe recipe;
            if (resultSet.next()) {
                recipe = new Recipe();
                recipe.setId(id);
                recipe.setName(resultSet.getString(1));
                recipe.setDescription(resultSet.getString(2));
                Rtype rtype = new Rtype(resultSet.getLong(3), resultSet.getString(4));
                recipe.setRtype(rtype);
            } else
                return null;
            ResultSet resultSetTags = statement.executeQuery(sql2);
            while (resultSetTags.next()) {
                Ingredient ingredient = new Ingredient(resultSetTags.getLong(1), resultSetTags.getString(2));
                Unit unit = new Unit(resultSetTags.getLong(3), resultSetTags.getString(4));
                Amount amount = new Amount(ingredient, resultSetTags.getString(5), unit);
                recipe.getAmounts().add(amount);
            }
            return recipe;
        }
    }


}
