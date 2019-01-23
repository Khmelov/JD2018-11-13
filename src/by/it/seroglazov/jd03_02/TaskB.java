package by.it.seroglazov.jd03_02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TaskB {
    public static void main(String[] args) {
        System.out.println("Не забудьте сначала создать БД запустив TaskC !");
        System.out.println("Список всех коктейлей и их ингридиентов с текстовыми полями из других таблиц, вместо id-значений");
        String sql = "SELECT recipes.id, recipes.name, ingredients.name, " +
                "amounts.text, units.name\n" +
                "FROM recipes\n" +
                "INNER JOIN amounts ON amounts.recipe_id = recipes.id\n" +
                "INNER JOIN ingredients ON ingredients.id = amounts.ingredient_id\n" +
                "INNER JOIN units ON units.id = amounts.unit_id";
        try (Connection connection = MyDatabaseConnector.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()) {
                System.out.printf("id='%s', ", resultSet.getString(1));
                System.out.printf("name='%s', ", resultSet.getString(2));
                System.out.printf("ingredient='%s', ", resultSet.getString(3));
                System.out.printf("amount='%s', ", resultSet.getString(4));
                System.out.printf("unit='%s'\n", resultSet.getString(5));
            }
            ResultSet rs1 = statement.executeQuery("SELECT COUNT(id) FROM recipes");
            if (rs1.next()) {
                System.out.printf("Всего коктейлей: %s%n", rs1.getString(1));
            }
            ResultSet rs2 = statement.executeQuery("SELECT COUNT(id) FROM ingredients");
            if (rs2.next()) {
                System.out.printf("Всего доступно ингредиентов: %s%n", rs2.getString(1));
            }

        } catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
        }
    }
}
