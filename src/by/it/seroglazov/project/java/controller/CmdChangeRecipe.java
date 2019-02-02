package by.it.seroglazov.project.java.controller;

import by.it.seroglazov.project.java.beans.*;
import by.it.seroglazov.project.java.dao.Dao;
import by.it.seroglazov.project.java.dao.MyDao;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

class CmdChangeRecipe extends Cmd {
    private static final int ingrCount = 4;

    @Override
    Action execute(HttpServletRequest req) throws Exception {
        if (Form.isPost(req)) {
            User user = Util.findUserInSession(req);
            if (user != null) {
                String str = req.getParameter("changed_recipe_id");
                if (str != null) {
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
                    long recipe_id = Form.getLong(req, "changed_recipe_id");
                    Recipe recipe = new Recipe(recipe_id, name, rtype.getId(), description);
                    if (!recDao.update(recipe)) {
                        throw new SiteException("Can't add new cocktail recipe to database");
                    }

                    //
                    for (int i = 0; i < ingrCount; i++) {

                            Ingredient ing = (Ingredient) req.getSession().getAttribute("ingredient" + String.valueOf(i + 1));
                            if (ing != null) {
                                String sqlSuffix = String.format("WHERE recipe_id='%d' and ingredient_id='%d'", recipe_id, ing.getId());
                                amDao.delete(sqlSuffix);
                            }

                    }

                    for (int i = 0; i < ingrCount; i++) {
                        if (bIngs[i]) {
                            String sAmount = Form.getParameterMatchesPattern(req, "amount_" + String.valueOf(i + 1), Patterns.amount);
                            amDao.create(new Amount(recipe.getId(), ings[i].getId(), sAmount, units[i].getId()));
                        }
                    }


                    return Action.RECIPESLIST;
                }
                long recipe_id = Form.getLong(req, "recipe_id");

                Dao<Rtype> rtDao = new MyDao<>(new Rtype());
                Dao<Ingredient> ingDao = new MyDao<>(new Ingredient());
                Dao<Unit> unitDao = new MyDao<>(new Unit());
                Dao<Amount> amDao = new MyDao<>(new Amount());
                Dao<Recipe> recDao = new MyDao<>(new Recipe());

                Recipe recipe = recDao.read(recipe_id);
                req.setAttribute("recipe", recipe);
                Rtype rtype = rtDao.read(recipe.getRtype_id());
                req.setAttribute("rtype", rtype);
                List<Amount> amounts = amDao.getAll("WHERE recipe_id=" + recipe.getId());
                int i = 1;
                for (Amount amount : amounts) {
                    Ingredient ing = ingDao.read(amount.getIngredient_id());
                    Unit unit = unitDao.read(amount.getUnit_id());
                    req.getSession().setAttribute("ingredient" + i, ing);
                    req.getSession().setAttribute("amount" + i, amount);
                    req.getSession().setAttribute("unit" + i, unit);
                    i++;
                }
                return Action.CHANGERECIPE;
            } else {
                req.getSession().setAttribute("error_message", "You must be log-in to change cocktail recipe");
            }
        }
        return Action.RECIPESLIST;
    }
}
