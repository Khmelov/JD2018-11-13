package by.it.kruglenja.Project.java.controller;
import java.util.List;
import by.it.kruglenja.Project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;

public class CmdCompletedOrder implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        if (Util.checkUser(req)) {
            Dao dao = Dao.getDao();
                List<by.it.kruglenja.Project.java.beans.CompletedOrder> co = dao.completedOrder.getAll();
                req.setAttribute("co", co);
                return Action.COMPLETEDORDER;
        }
        return Action.LOGIN;
    }
}
