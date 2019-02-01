package by.it.seroglazov.project.java.controller;

import by.it.seroglazov.project.java.beans.*;
import by.it.seroglazov.project.java.dao.Dao;
import by.it.seroglazov.project.java.dao.MyDao;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdIngList extends Cmd {
    @Override
    Action execute(HttpServletRequest req) throws Exception {

        Dao<Ingredient> ingDao = new MyDao<>(new Ingredient());
        StringBuilder sb = new StringBuilder();
        List<Ingredient> ings = ingDao.getAll();
        for (Ingredient ing : ings) {
            sb.append("<div class=\"border border-info rounded px-3 my-2\">\n")
                    .append("<p>").append(ing.getName())
                    .append("<br>id=").append(ing.getId()).append("</p>\n")
                    .append("</div>");
        }

        req.getSession().setAttribute("ing_list", sb.toString());
        return Action.INGLIST;
    }
}
