package by.it.seroglazov.jd03_02.crud;

import by.it.seroglazov.jd03_02.Amount;
import by.it.seroglazov.jd03_02.beans.Ingredient;
import by.it.seroglazov.jd03_02.beans.Recipe;
import by.it.seroglazov.jd03_02.beans.Rtype;
import by.it.seroglazov.jd03_02.beans.Unit;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class CRUDTest {

    @Test
    public void ingredientCrudTest() {
        Ingredient superVodka = new Ingredient("super vodka");
        String s1 = superVodka.getName();
        IngredientCRUD ingredientCRUD = new IngredientCRUD();
        try {
            // Create
            if (!ingredientCRUD.create(superVodka)) fail();
            // Read
            Ingredient ingr = ingredientCRUD.read(superVodka.getId());
            if (ingr == null) fail();
            String s2 = ingr.getName();
            assertEquals(s1, s2);
            // Update
            ingr.setName("very super vodka");
            String s3 = ingr.toString();
            if (!ingredientCRUD.update(ingr)) fail();
            Ingredient ingr2 = ingredientCRUD.read(ingr.getId());
            if (ingr2 == null) fail();
            String s4 = ingr2.toString();
            assertEquals(s3, s4);
            // Delete
            if (!ingredientCRUD.delete(ingr2)) fail();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void rtypeCrudTest() {
        Rtype everySecond = new Rtype("every second cocktail");
        String s1 = everySecond.getText();
        RtypeCRUD rtypeCRUD = new RtypeCRUD();
        try {
            // Create;
            if (!rtypeCRUD.create(everySecond)) fail();
            // Read
            Rtype rt = rtypeCRUD.read(everySecond.getId());
            if (rt == null) fail();
            String s2 = rt.getText();
            assertEquals(s1, s2);
            // Update
            rt.setText("every millis cocktail");
            String s3 = rt.toString();
            if (!rtypeCRUD.update(rt)) fail();
            Rtype rt2 = rtypeCRUD.read(rt.getId());
            if (rt2 == null) fail();
            String s4 = rt2.toString();
            assertEquals(s3, s4);
            // Delete
            if (!rtypeCRUD.delete(rt2)) fail();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void unitCrudTest() {
        Unit kg = new Unit("kg");
        String s1 = kg.getName();
        UnitCRUD unitCRUD = new UnitCRUD();
        try {
            // Create;
            if (!unitCRUD.create(kg)) fail();
            // Read
            Unit ut = unitCRUD.read(kg.getId());
            if (ut == null) fail();
            String s2 = ut.getName();
            assertEquals(s1, s2);
            // Update
            ut.setName("kg/s");
            String s3 = ut.toString();
            if (!unitCRUD.update(ut)) fail();
            Unit ut2 = unitCRUD.read(ut.getId());
            if (ut2 == null) fail();
            String s4 = ut2.toString();
            assertEquals(s3, s4);
            // Delete
            if (!unitCRUD.delete(ut2)) fail();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void recipeCrudTest() {
        UnitCRUD unitCRUD = new UnitCRUD();
        Unit u = new Unit("test unit");
        RtypeCRUD rtypeCRUD = new RtypeCRUD();
        Rtype rt = new Rtype("every year cocktail");
        IngredientCRUD ingredientCRUD = new IngredientCRUD();
        Ingredient ing = new Ingredient("ice vodka");
        RecipeCRUD RecipeCRUD = new RecipeCRUD();
        Recipe fodka = new Recipe("fodka", rt, "bla-bla-bla", new Amount(ing, "all bottle", u));
        try {
            unitCRUD.create(u);
            rtypeCRUD.create(rt);
            ingredientCRUD.create(ing);
            // Create;
            if (!RecipeCRUD.create(fodka)) fail();
            // Read
            Recipe fodka2 = RecipeCRUD.read(fodka.getId());
            if (fodka2 == null) fail();
            fodka.setId(fodka2.getId());
            String s1 = fodka.toString();
            String s2 = fodka2.toString();
            assertEquals(s1, s2);
            //System.out.println(s1);
            // Update
            fodka2.setName("drinking fodka");
            String s3 = fodka2.toString();
            if (!RecipeCRUD.update(fodka2)) fail();
            Recipe fodka3 = RecipeCRUD.read(fodka2.getId());
            if (fodka3 == null) fail();
            String s4 = fodka3.toString();
            assertEquals(s3, s4);
            // Delete
            if (!RecipeCRUD.delete(fodka3)) fail();
            unitCRUD.delete(u);
            rtypeCRUD.delete(rt);
            ingredientCRUD.delete(ing);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}