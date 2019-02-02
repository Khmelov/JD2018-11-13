package by.it.seroglazov.project.java.controller;

import by.it.seroglazov.project.java.beans.*;
import by.it.seroglazov.project.java.dao.Dao;
import by.it.seroglazov.project.java.dao.MyDao;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CmdIngList extends Cmd {
    @Override
    Action execute(HttpServletRequest req) throws Exception {

        Dao<Ingredient> ingDao = new MyDao<>(new Ingredient());
        Dao<Usering> uiDao = new MyDao<>(new Usering());

        List<Ingredient> allIngs = ingDao.getAll();

        if (!Util.checkUserInSession(req)) {
            req.setAttribute("user_ingredients", new LinkedList<>());
            req.setAttribute("other_ingredients", allIngs);
        } else {
            User user = Util.findUserInSession(req);
            if (user == null)
                return Action.INGLIST;

            List<Usering> userIngsIds = uiDao.getAll("WHERE user_id=" + user.getId());
            List<Ingredient> userIngs = new LinkedList<>();
            for (Usering usering : userIngsIds) {
                Ingredient ing = ingDao.read(usering.getIngredient_id());
                userIngs.add(ing);
            }
            req.setAttribute("user_ingredients", userIngs);


            List<Ingredient> notUserIngs = new LinkedList<>();
            for (Ingredient ing : allIngs) {
                boolean inList = false;
                for (Ingredient userIng : userIngs) {
                    if (ing.getId() == userIng.getId()) {
                        inList = true;
                        break;
                    }
                }
                if (!inList) notUserIngs.add(ing);
            }

            req.setAttribute("other_ingredients", notUserIngs);
        }

        return Action.INGLIST;
    }
}
