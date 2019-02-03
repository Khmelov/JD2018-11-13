package by.it.seroglazov.project.java.controller;

import by.it.seroglazov.project.java.beans.Ingredient;
import by.it.seroglazov.project.java.beans.User;
import by.it.seroglazov.project.java.beans.Usering;
import by.it.seroglazov.project.java.dao.Dao;
import by.it.seroglazov.project.java.dao.MyDao;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;
import java.util.List;

class CmdProfile extends Cmd {

    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        if (!Util.checkUserInSession(req))
            return Action.LOGIN;

        if (Form.isPost(req)) {
            if (req.getParameter("logout") != null) {
                req.getSession().invalidate();
                return Action.LOGIN;
            }
        }

        User user = Util.findUserInSession(req);
        //String where=String.format(" WHERE `user_id`='%d'",user.getId());

        //Dao<Ingredient> ingDao = new MyDao<>(new Ingredient());
        //Dao<Usering> uiDao = new MyDao<>(new Usering());

        //List<Usering> userIngrList = uiDao.getAll(where);
        //List<Ingredient> ingredients = new LinkedList<>();

        /*for (Usering userIngr : userIngrList) {
            Ingredient ingredient = ingDao.read(userIngr.getIngredient_id());
            ingredients.add(ingredient);
        }*/
        //req.getSession().setAttribute("ingredients", ingredients);

        return Action.PROFILE;
    }
}
