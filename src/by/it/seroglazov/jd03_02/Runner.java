package by.it.seroglazov.jd03_02;

import by.it.seroglazov.jd03_02.beans.*;
import by.it.seroglazov.jd03_02.crud.RecipeCRUD;
import by.it.seroglazov.jd03_02.crud.IngredientCRUD;
import by.it.seroglazov.jd03_02.crud.RtypeCRUD;
import by.it.seroglazov.jd03_02.crud.UnitCRUD;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) {
        /*System.out.print("Delete tables if exists... ");
        if (!DatabaseOperations.deleteAllTable()) {
            System.out.println("Error. Can't delete tables!");
            return;
        }
        System.out.println("done.");*/

        System.out.print("Delete database if exists... ");
        if (!DatabaseOperations.deleteDatabase()) {
            System.out.println("Error. Can't delete database!");
            return;
        }
        System.out.println("done.");

        System.out.print("Create database... ");
        if (!DatabaseOperations.createDatabase()) {
            System.out.println("Error. Can't create database!");
            return;
        }
        System.out.println("done.");

        System.out.print("Create tables... ");
        if (!DatabaseOperations.createAllTables()) {
            System.out.println("Error. Can't create tables!");
            return;
        }
        System.out.println("done.");

        // ============== Ingredients =======================================================
        Ingredient gin = new Ingredient("gin");
        Ingredient white_rum = new Ingredient("white rum");
        Ingredient vodka = new Ingredient("vodka");
        Ingredient triple_sec = new Ingredient("triple sec");
        Ingredient fresh_lemon_juice = new Ingredient("fresh lemon juice");
        Ingredient bourbon_whiskey = new Ingredient("bourbon whiskey");
        Ingredient plain_water = new Ingredient("plain water");
        Ingredient angostura_aromatic_bitters = new Ingredient("angostura aromatic bitters");
        Ingredient sugar = new Ingredient("sugar");

        IngredientCRUD ingredientCRUD = new IngredientCRUD();
        try {
            ingredientCRUD.create(gin, white_rum, vodka, triple_sec, fresh_lemon_juice, bourbon_whiskey, plain_water,
                    angostura_aromatic_bitters, sugar);
        } catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
        }

        // ============== Units =============================================================
        Unit cl = new Unit("cl");
        Unit ml = new Unit("ml");
        Unit slice = new Unit("slice");
        Unit dash = new Unit("dash");
        Unit cube = new Unit("cube");

        UnitCRUD unitCRUD = new UnitCRUD();
        try {
            unitCRUD.create(cl, ml, slice, dash, cube);
        } catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
        }

        // ============== Rtypes ============================================================
        Rtype all_day_cocktail = new Rtype("all day cocktail");
        Rtype before_dinner_cocktail = new Rtype("before dinner cocktail");

        RtypeCRUD rtypeCRUD = new RtypeCRUD();
        try {
            rtypeCRUD.create(all_day_cocktail, before_dinner_cocktail);
        } catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
        }

        // ============== Recipes ============================================================
        Recipe white_lady = new Recipe(
                "white lady",
                all_day_cocktail,
                "Add all ingredients into cocktail shaker filled with ice. Shake well and strain into large " +
                        "cocktail glass.",
                new Amount(gin, "4", cl),
                new Amount(triple_sec, "3", cl),
                new Amount(fresh_lemon_juice, "2", cl));

        RecipeCRUD recipeCRUD = new RecipeCRUD();
        try {
            recipeCRUD.create(white_lady);
        } catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
        }

    }
}
