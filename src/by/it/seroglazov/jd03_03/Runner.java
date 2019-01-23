package by.it.seroglazov.jd03_03;

import by.it.seroglazov.jd03_03.beans.*;
import by.it.seroglazov.jd03_03.dao.Dao;
import by.it.seroglazov.jd03_03.dao.MyDao;

import java.util.List;

public class Runner {

    static private Dao<Rtype> rtDao = new MyDao<>(new Rtype());
    static private Dao<Ingredient> ingDao = new MyDao<>(new Ingredient());
    static private Dao<Unit> unitDao = new MyDao<>(new Unit());
    static private Dao<Amount> amDao = new MyDao<>(new Amount());
    static private Dao<Recipe> recDao = new MyDao<>(new Recipe());

    public static void main(String[] args) {

        DatabaseCreator creator = DatabaseCreator.getCreator();
        creator.resetDatabase();

        printAllRecipes();

    }

    private static void printAllRecipes() {
        try {
            System.out.println("\nList of all cocktails:\n");
            List<Recipe> allRecipes = recDao.getAll();
            for (Recipe recipe : allRecipes) {
                Rtype rtype = rtDao.read(recipe.getRtype_id());
                System.out.printf("id=%s name='%s' type='%s'%n",
                        recipe.getId(), recipe.getName(), rtype.getText());
                List<Amount> amounts = amDao.getAll("WHERE recipe_id=" + recipe.getId());
                for (Amount amount : amounts) {
                    Ingredient ingredient = ingDao.read(amount.getIngredient_id());
                    Unit unit = unitDao.read(amount.getUnit_id());
                    System.out.printf("\t%s %s %s%n", amount.getText(), unit.getName(), ingredient.getName());
                }
                System.out.println(recipe.getDescription());
                System.out.println();

            }

        } catch (Exception e) {
            System.err.println("Error while working with database: " + e.getMessage());
        }
    }

}
