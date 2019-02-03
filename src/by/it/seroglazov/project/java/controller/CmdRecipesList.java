package by.it.seroglazov.project.java.controller;

import by.it.seroglazov.project.java.beans.*;
import by.it.seroglazov.project.java.dao.Dao;
import by.it.seroglazov.project.java.dao.MyDao;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

class CmdRecipesList extends Cmd {
    @Override
    Action execute(HttpServletRequest req) throws Exception {
        long id;
        try {
            id = Form.getLong(req, "id");
        } catch (NumberFormatException e) {
            id = 0;
        }
        Dao<Rtype> rtDao = new MyDao<>(new Rtype());
        Dao<Ingredient> ingDao = new MyDao<>(new Ingredient());
        Dao<Unit> unitDao = new MyDao<>(new Unit());
        Dao<Amount> amDao = new MyDao<>(new Amount());
        Dao<Recipe> recDao = new MyDao<>(new Recipe());

        StringBuilder sb = new StringBuilder();

        String sqlSuff;
        List<Recipe> recipes;
        if (id > 0) {
            sqlSuff = "WHERE `recipes`.`id` IN " +
                    "(SELECT `amounts`.`recipe_id` FROM `amounts` WHERE `amounts`.`ingredient_id`='" + id + "')";
        } else {
            sqlSuff = "";
        }
        recipes = recDao.getAll(sqlSuff);
        if (recipes.size() == 0) {
            req.setAttribute("error_message", "No one cocktail matches conditions");
        }

        for (Recipe recipe : recipes) {
            Rtype rtype = rtDao.read(recipe.getRtype_id());
            List<Amount> amounts = amDao.getAll("WHERE recipe_id=" + recipe.getId());
            sb.append("<div class=\"border border-info rounded px-3 my-2\">\n")
                    .append("<div class=\"row\">")
                    .append("<div class=\"col-sm-8\">")
                    .append("<span class=\"text-info\" style=\"font-size: 1.8em\">")
                    .append(recipe.getName())
                    .append("</span>\n")
                    .append("<em class=\"border border-seconday rounded p-1 mx-2\">")
                    .append(rtype.getText())
                    .append("</em>\n")
                    .append("<p>");
            for (Amount amount : amounts) {
                Ingredient ing = ingDao.read(amount.getIngredient_id());
                Unit unit = unitDao.read(amount.getUnit_id());
                sb.append(ing.getName()).append(' ')
                        .append(amount.getText()).append(' ').append(unit.getName())
                        .append("<br>\n");
            }
            sb.append("</p>\n");
            sb.append("<p>").append(recipe.getDescription()).append("</p>\n")
                    .append("</div>")
                    .append("<div class=\"col-sm-4\">")
                    .append("<form action=\"do?command=DeleteRecipe\" method=\"POST\">\n")
                    .append("<input type=\"hidden\" name=\"recipe_id\" value=\"")
                    .append(recipe.getId())
                    .append("\" >\n")
                    .append("<input type=\"submit\" class=\"btn btn-danger float-right m-1\" name=\"recipe\" value=\"Удалить\" />\n")
                    .append("</form>")
                    .append("<form action=\"do?command=ChangeRecipe\" method=\"POST\">\n")
                    .append("<input type=\"hidden\" name=\"recipe_id\" value=\"")
                    .append(recipe.getId())
                    .append("\" >\n")
                    .append("<input type=\"submit\" class=\"btn btn-warning float-right m-1\" name=\"recipe\" value=\"Изменить\" />\n")
                    .append("</form>")
                    .append("</div>")
                    .append("</div>")
                    .append("</div>");
        }

        req.getSession().setAttribute("recipe_list", sb.toString());
        return Action.RECIPESLIST;
    }
}
