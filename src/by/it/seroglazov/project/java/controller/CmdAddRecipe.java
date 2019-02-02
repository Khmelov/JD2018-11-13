package by.it.seroglazov.project.java.controller;

import by.it.seroglazov.project.java.beans.*;
import by.it.seroglazov.project.java.dao.Dao;
import by.it.seroglazov.project.java.dao.MyDao;

import javax.servlet.http.HttpServletRequest;

class CmdAddRecipe extends Cmd {

    private static final int ingrCount = 4;


    @Override
    Action execute(HttpServletRequest req) throws Exception {
        if (Form.isPost(req)) {

            Dao<Rtype> rtDao = new MyDao<>(new Rtype());
            Dao<Ingredient> ingDao = new MyDao<>(new Ingredient());
            Dao<Unit> unitDao = new MyDao<>(new Unit());
            Dao<Amount> amDao = new MyDao<>(new Amount());
            Dao<Recipe> recDao = new MyDao<>(new Recipe());

            // Take cocktail name from form
            String name = null;
            try {
                name = Form.getParameterMatchesPattern(req, "recipe_name", Patterns.cocktailName);
            } catch (SiteException e) {
                req.setAttribute("error_message", "Cocktail name is incorrect");
                return Action.ADDRECIPE;
            }

            if (name.length() == 0 || recDao.findFirstByFieldValue("name", name) != null) {
                req.setAttribute("error_message", "Cocktail with name '" + name + "' already exists");
                return Action.ADDRECIPE;
            }

            // Take cocktail type from form
            String type = Form.getParameterMatchesPattern(req, "recipe_type", Patterns.cocktailType);
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
            for (int i = 0; i < ingrCount; i++) {
                // Get Ingredient from BD, if not exist - create
                sIng[i] = Form.getParameterMatchesPattern(req, "ingredient_" + String.valueOf(i + 1), Patterns.ingredientName);
                bIngs[i] = (sIng[i].length() > 0);
                if (bIngs[i]) {
                    ings[i] = ingDao.findFirstByFieldValue("name", sIng[i]);
                    if (ings[i] == null) {
                        ings[i] = new Ingredient(sIng[i]);
                        ingDao.create(ings[i]);
                    }
                    // Get Unit from BD, if not exist - create
                    sUnit[i] = Form.getParameterMatchesPattern(req, "unit_" + String.valueOf(i + 1), Patterns.unit);
                    units[i] = unitDao.findFirstByFieldValue("name", sUnit[i]);
                    if (units[i] == null) {
                        units[i] = new Unit(sUnit[i]);
                        unitDao.create(units[i]);
                    }
                }
            }

            // Take description from form
            String description = Form.getParameterMatchesPattern(req, "description", Patterns.description);

            // Add new recipe to DB
            Recipe recipe = new Recipe(name, rtype.getId(), description);
            if (!recDao.create(recipe)) {
                throw new SiteException("Can't add new cocktail recipe to database");
            }

            //
            for (int i = 0; i < ingrCount; i++) {
                if (bIngs[i]) {
                    String sAmount = Form.getParameterMatchesPattern(req, "amount_" + String.valueOf(i + 1), Patterns.amount);
                    amDao.create(new Amount(recipe.getId(), ings[i].getId(), sAmount, units[i].getId()));
                }
            }

               //req.getSession().setAttribute("recipe_id", recipe.getId());

            return Action.RECIPESLIST;
        }
        return Action.ADDRECIPE;
    }
}
