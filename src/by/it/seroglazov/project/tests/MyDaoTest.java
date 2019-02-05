package by.it.seroglazov.project.tests;

import by.it.seroglazov.project.java.beans.*;
import by.it.seroglazov.project.java.controller.SiteException;
import by.it.seroglazov.project.java.dao.Dao;
import by.it.seroglazov.project.java.dao.DatabaseCreator;
import by.it.seroglazov.project.java.dao.MyDao;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyDaoTest {

    @Test
    public void testIngredients() {
        Ingredient superVodka = new Ingredient("super vodka");
        String s1 = superVodka.getName();
        Dao<Ingredient> dao = new MyDao<>(new Ingredient());
        try {
            // Create
            if (!dao.create(superVodka)) fail();
            // Read
            Ingredient ingr = dao.read(superVodka.getId());
            if (ingr == null) fail();
            String s2 = ingr.getName();
            assertEquals(s1, s2);
            // Update
            ingr.setName("very super vodka");
            String s3 = ingr.toString();
            if (!dao.update(ingr)) fail();
            Ingredient ingr2 = dao.read(ingr.getId());
            if (ingr2 == null) fail();
            String s4 = ingr2.toString();
            assertEquals(s3, s4);
            // Delete
            if (!dao.delete(ingr2)) fail();
            if (dao.read(ingr2.getId()) != null) fail();
        } catch (Exception e) {
            System.out.println("Error while testing with message: " + e.getMessage());
        }
    }

    @Test
    public void testRtype() {
        Rtype everySecond = new Rtype("every second cocktail");
        String s1 = everySecond.getText();
        Dao<Rtype> dao = new MyDao<>(new Rtype());
        try {
            // Create;
            if (!dao.create(everySecond)) fail();
            // Read
            Rtype rt = dao.read(everySecond.getId());
            if (rt == null) fail();
            String s2 = rt.getText();
            assertEquals(s1, s2);
            // Update
            rt.setText("every millis cocktail");
            String s3 = rt.toString();
            if (!dao.update(rt)) fail();
            Rtype rt2 = dao.read(rt.getId());
            if (rt2 == null) fail();
            String s4 = rt2.toString();
            assertEquals(s3, s4);
            // Delete
            if (!dao.delete(rt2)) fail();
            if (dao.read(rt2.getId()) != null) fail();
        } catch (Exception e) {
            System.out.println("Error while testing with message: " + e.getMessage());
        }
    }

    @Test
    public void testUnit() {
        Unit kg = new Unit("kg");
        String s1 = kg.getName();
        Dao<Unit> dao = new MyDao<>(new Unit());
        try {
            // Create;
            if (!dao.create(kg)) fail();
            // Read
            Unit ut = dao.read(kg.getId());
            if (ut == null) fail();
            String s2 = ut.getName();
            assertEquals(s1, s2);
            // Update
            ut.setName("kg/s");
            String s3 = ut.toString();
            if (!dao.update(ut)) fail();
            Unit ut2 = dao.read(ut.getId());
            if (ut2 == null) fail();
            String s4 = ut2.toString();
            assertEquals(s3, s4);
            // Delete
            if (!dao.delete(ut2)) fail();
            if (dao.read(ut2.getId()) != null) fail();
        } catch (Exception e) {
            System.out.println("Error while testing with message: " + e.getMessage());
        }
    }

    @Test
    public void testRecipeAndAmount() {
        Dao<Rtype> rtDao = new MyDao<>(new Rtype());
        Dao<Ingredient> ingDao = new MyDao<>(new Ingredient());
        Dao<Unit> unitDao = new MyDao<>(new Unit());
        Dao<Amount> amDao = new MyDao<>(new Amount());
        Dao<Recipe> recDao = new MyDao<>(new Recipe());
        //DatabaseCreator.getCreator().resetDatabase();
        try {
            // Create
            Unit u = new Unit("test unit");
            Rtype rt = new Rtype("test type");
            Ingredient ing = new Ingredient("test ing");
            if (!unitDao.create(u)) fail();
            if (!rtDao.create(rt)) fail();
            if (!ingDao.create(ing)) fail();
            Recipe recipe = new Recipe("test recipe", rt.getId(), "bla-bla-bla");
            if (!recDao.create(recipe)) fail();
            Amount am = new Amount(recipe.getId(), ing.getId(), "100", u.getId());
            if (!amDao.create(am)) fail();
            System.out.println(u);
            System.out.println(rt);
            System.out.println(ing);
            System.out.println("CREATE: " + recipe);
            // Read
            Recipe recipe2 = recDao.read(recipe.getId());
            if (recipe2 == null) fail();
            recipe.setId(recipe2.getId());
            String s1 = recipe.toString();
            String s2 = recipe2.toString();
            assertEquals(s1, s2);
            System.out.println("READ: " + recipe2);
            // Update
            recipe2.setName("recipe SUPER test");
            String s3 = recipe2.toString();
            if (!recDao.update(recipe2)) fail();
            Recipe recipe3 = recDao.read(recipe2.getId());
            if (recipe3 == null) fail();
            String s4 = recipe3.toString();
            assertEquals(s3, s4);
            System.out.println("UPDATE: " + recipe3);
            System.out.println(am);
            // Delete
            if (!recDao.delete(recipe3)) fail();
            if (!unitDao.delete(u)) fail();
            if (!rtDao.delete(rt)) fail();
            if (!ingDao.delete(ing)) fail();
        } catch (Exception e) {
            System.out.println("Error while testing with message: " + e.getMessage());
        }
    }
}