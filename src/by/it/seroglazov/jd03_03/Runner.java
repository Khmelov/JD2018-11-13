package by.it.seroglazov.jd03_03;

import by.it.seroglazov.jd03_03.beans.Ingredient;
import by.it.seroglazov.jd03_03.beans.Recipe;
import by.it.seroglazov.jd03_03.beans.Rtype;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        /*DatabaseCreator creator = DatabaseCreator.getCreator();

        System.out.print("Delete database if exists... ");
        if (!creator.deleteDatabase()) {
            System.out.println("fail.");
            return;
        }
        System.out.println("done.");

        System.out.print("Create database... ");
        if (!creator.createDatabase()) {
            System.out.println("fail.");
            return;
        }
        System.out.println("done.");

        System.out.print("Create tables... ");
        if (!creator.createAllTables()) {
            System.out.println("fail.");
            return;
        }
        System.out.println("done.");*/

        /*System.out.print("Fill tables from XML file... ");
        if (!creator.fillDatabaseFromXml()) {
            System.out.println("fail.");
            return;
        }
        System.out.println("done.");*/

        Dao<Ingredient> daoIngredient = new MyDao<>(new Ingredient());
        Dao<Recipe> daoRecipe = new MyDao<>(new Recipe());
        Dao<Rtype> daoRtype = new MyDao<>(new Rtype());
        Ingredient ing1 = new Ingredient("frozen vodka");
        Rtype rtype = new Rtype("all day");
        Recipe r = new Recipe("bloody maria", 1, "just drink vodka with tomato juice");
        Recipe r2 = new Recipe("bloody maria2", 1, "just drink vodka with tomato juice");
        try {
            //daoIngredient.create(ing1);
            //daoRtype.create(rtype);
            //daoRecipe.create(r);
            //daoRecipe.create(r2);
            //System.out.println(ing1);
            //System.out.println(rtype);
            //System.out.println(r);
            //System.out.println(r2);
            //List<Recipe> list = daoRecipe.getAll("WHERE id=1");
            Recipe rrr = daoRecipe.read(2);
            System.out.println(rrr);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

    }
}
