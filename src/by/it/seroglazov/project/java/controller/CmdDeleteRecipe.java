package by.it.seroglazov.project.java.controller;

import by.it.seroglazov.project.java.beans.Recipe;
import by.it.seroglazov.project.java.beans.User;
import by.it.seroglazov.project.java.dao.Dao;
import by.it.seroglazov.project.java.dao.MyDao;

import javax.servlet.http.HttpServletRequest;

class CmdDeleteRecipe extends Cmd {
    @Override
    Action execute(HttpServletRequest req) throws Exception {
        if (Form.isPost(req)) {
            User user = Util.findUserInSession(req);
            if (user != null) {
                long recipe_id = Form.getLong(req, "recipe_id");
                Dao<Recipe> recDao = new MyDao<>(new Recipe());
                Recipe recipe = recDao.read(recipe_id);
                recDao.delete(recipe);
            } else {
                req.getSession().setAttribute("error_message", "You must be log-in to delete cocktail");
            }
        }
        return Action.RECIPESLIST;
    }
}
