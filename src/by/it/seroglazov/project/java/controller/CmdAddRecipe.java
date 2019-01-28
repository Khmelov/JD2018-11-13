package by.it.seroglazov.project.java.controller;

import by.it.seroglazov.project.java.beans.*;
import by.it.seroglazov.project.java.dao.Dao;
import by.it.seroglazov.project.java.dao.MyDao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

class CmdAddRecipe extends Cmd {

    private static final int ingrCount = 4;
    private static final String patt = "[a-zA-Z0-9 -]+";
    private static final String patt2 = "[a-zA-Z0-9 -]*";

    @Override
    Action execute(HttpServletRequest req) throws Exception {
        if (Form.isPost(req)) {

            Dao<Rtype> rtDao = new MyDao<>(new Rtype());
            Dao<Ingredient> ingDao = new MyDao<>(new Ingredient());
            Dao<Unit> unitDao = new MyDao<>(new Unit());
            Dao<Amount> amDao = new MyDao<>(new Amount());
            Dao<Recipe> recDao = new MyDao<>(new Recipe());

            // Take cocktail name from form
            String name = Form.getString(req, "recipe_name", patt);
            // If that cocktail already in DB then show Error page with message
            if (name.length() == 0 || recDao.findFirstByFieldValue("name", name) != null) {
                throw new SiteException("Cocktail with name '" + name + "' already exists");
            }

            // Take cocktail type from form
            String type = Form.getString(req, "recipe_type", patt);
            // If that type is already in DB then take it otherwise create new type in DB
            Rtype rtype = rtDao.findFirstByFieldValue("text", type);
            if (rtype == null) {
                rtype = new Rtype(type);
                rtDao.create(rtype);
            }

            // Now we should create ingredients, units
            boolean bIngs[] = new boolean[ingrCount]; // true - ingredients exists, false - doesn't
            Ingredient ings[] = new Ingredient[ingrCount];
            Unit units[] = new Unit[ingrCount];
            String sIng[] = new String[ingrCount];
            String sUnit[] = new String[ingrCount];
            for (int i = 0; i < ingrCount - 1; i++) {
                // Get Ingredient from BD, if not exist - create
                sIng[i] = Form.getString(req, "ingredient_" + String.valueOf(i + 1), patt2);
                bIngs[i] = (sIng[i].length() > 0);
                if (bIngs[i]) {
                    ings[i] = ingDao.findFirstByFieldValue("name", sIng[i]);
                    if (ings[i] == null) {
                        ings[i] = new Ingredient(sIng[i]);
                        ingDao.create(ings[i]);
                    }
                    // Get Unit from BD, if not exist - create
                    sUnit[i] = Form.getString(req, "unit_" + String.valueOf(i + 1), patt2);
                    units[i] = unitDao.findFirstByFieldValue("name", sUnit[i]);
                    if (units[i] == null) {
                        units[i] = new Unit(sUnit[i]);
                        unitDao.create(units[i]);
                    }
                }
            }

            // Take description from form
            String description = Form.getString(req, "description");

            // Add new recipe to DB
            Recipe recipe = new Recipe(name, rtype.getId(), description);
            if (!recDao.create(recipe)) {
                throw new SiteException("Can't add new cocktail recipe to database");
            }

            //
            for (int i = 0; i < ingrCount - 1; i++) {
                if (bIngs[i]) {
                    String sAmount = Form.getString(req, "amount_" + String.valueOf(i + 1), patt2);
                    amDao.create(new Amount(recipe.getId(), ings[i].getId(), sAmount, units[i].getId()));
                }
            }

               //req.getSession().setAttribute("recipe_id", recipe.getId());

            return Action.RECIPESLIST;
        }
        return Action.ADDRECIPE;
    }
}
