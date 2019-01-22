package by.it.seroglazov.jd03_02;

import by.it.seroglazov.jd03_02.beans.*;
import by.it.seroglazov.jd03_02.crud.RecipeCRUD;
import by.it.seroglazov.jd03_02.crud.IngredientCRUD;
import by.it.seroglazov.jd03_02.crud.RtypeCRUD;
import by.it.seroglazov.jd03_02.crud.UnitCRUD;

import java.sql.SQLException;

public class TaskC {
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
        Ingredient tequila = new Ingredient("tequila");
        Ingredient cointreau = new Ingredient("cointreau");
        Ingredient fresh_lime_juice = new Ingredient("fresh lime juice");
        Ingredient cola = new Ingredient("cola");
        Ingredient mint = new Ingredient("mint");
        Ingredient soda_water = new Ingredient("soda water");

        IngredientCRUD ingredientCRUD = new IngredientCRUD();
        try {
            ingredientCRUD.create(gin, white_rum, vodka, triple_sec, fresh_lemon_juice, bourbon_whiskey, plain_water,
                    angostura_aromatic_bitters, sugar, tequila, cointreau, fresh_lime_juice, cola, mint, soda_water);

        } catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
        }

        // ============== Units =============================================================
        Unit unit_empty = new Unit("unit_empty");
        Unit cl = new Unit("cl");
        Unit ml = new Unit("ml");
        Unit slice = new Unit("slice");
        Unit dash = new Unit("dash");
        Unit cube = new Unit("cube");
        Unit sprig = new Unit("sprig");
        Unit teaspoon = new Unit("teaspoon");

        UnitCRUD unitCRUD = new UnitCRUD();
        try {
            unitCRUD.create(unit_empty, cl, ml, slice, dash, cube, sprig, teaspoon);
        } catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
        }

        // ============== Rtypes ============================================================
        Rtype all_day_cocktail = new Rtype("all day cocktail");
        Rtype before_dinner_cocktail = new Rtype("before dinner cocktail");
        Rtype longdrink = new Rtype("longdrink");

        RtypeCRUD rtypeCRUD = new RtypeCRUD();
        try {
            rtypeCRUD.create(all_day_cocktail, before_dinner_cocktail, longdrink);
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

        Recipe old_fashioned = new Recipe(
                "old fashioned",
                before_dinner_cocktail,
                "Place sugar cube in old-fashioned glass and saturate with bitters, add a dash of plain water. " +
                        "Muddle until dissolve. Fill the glass with ice cubes and add whiskey. " +
                        "Garnish with orange slice and a cocktail cherry.",
                new Amount(bourbon_whiskey, "4.5", cl),
                new Amount(angostura_aromatic_bitters, "2", dash),
                new Amount(sugar, "1", cube),
                new Amount(plain_water, "few", dash));

        Recipe margarita = new Recipe(
                "margarita",
                all_day_cocktail,
                "Pour all ingredients into shaker with ice. " +
                        "Shake well and strain into cocktail glass rimmed with salt " +
                        "(note:Fruit Margarita – blend selected fruit with the above recipe).",
                new Amount(tequila, "3.5", cl),
                new Amount(cointreau, "2", cl),
                new Amount(fresh_lime_juice, "1.5", cl));

        Recipe cuba_libre = new Recipe(
                "cuba libre",
                longdrink,
                "Build all ingredients in a highball glass filled with ice. Garnish with lime wedge.",
                new Amount(white_rum, "5", cl),
                new Amount(cola, "12", cl),
                new Amount(fresh_lime_juice, "1", cl));

        Recipe mojito = new Recipe(
                "mojito",
                longdrink,
                "Muddle mint springs with sugar and lime juice. " +
                        "Add splash of soda water and fill glass with cracked ice. " +
                        "Pour rum and top with soda water. " +
                        "Garnish with spring of mint leaves and lemon slice. Serve with straw.",
                new Amount(white_rum, "4", cl),
                new Amount(fresh_lime_juice, "3", cl),
                new Amount(mint, "6", sprig),
                new Amount(soda_water, "top", unit_empty));


        RecipeCRUD recipeCRUD = new RecipeCRUD();
        try {
            recipeCRUD.create(white_lady, old_fashioned, margarita, cuba_libre, mojito);
        } catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
        }

    }
}
