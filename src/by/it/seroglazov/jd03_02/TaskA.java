package by.it.seroglazov.jd03_02;

import by.it.seroglazov.jd03_02.beans.Ingredient;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TaskA {
    public static void main(String[] args) {
        System.out.println("Не забудьте сначала создать БД запустив TaskC !");
        String name = "bourbon whiskey";
        System.out.println("Поиск ингредиента по названию '" + name + "':");
        String sql = String.format("SELECT id, name FROM `ingredients` WHERE name = '%s'", name);
        try (Connection connection = MyDatabaseConnector.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            Ingredient ingredient = new Ingredient();
            if (resultSet.next()) {
                ingredient.setId(resultSet.getInt(1));
                ingredient.setName(resultSet.getString(2));
                System.out.println(ingredient);
            }

        } catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
        }
    }
}
