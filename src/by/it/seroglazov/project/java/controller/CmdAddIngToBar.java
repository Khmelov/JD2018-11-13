package by.it.seroglazov.project.java.controller;

import by.it.seroglazov.project.java.beans.User;
import by.it.seroglazov.project.java.beans.Usering;
import by.it.seroglazov.project.java.dao.Dao;
import by.it.seroglazov.project.java.dao.MyDao;

import javax.servlet.http.HttpServletRequest;

class CmdAddIngToBar extends Cmd {
    @Override
    Action execute(HttpServletRequest req) throws Exception {
        if (Form.isPost(req)) {
            User user = Util.findUserInSession(req);
            if (user != null) {
                long ingredient_id = Form.getLong(req, "ingredient_id");
                Dao<Usering> uiDao = new MyDao<>(new Usering());
                Usering usering = new Usering(user.getId(), ingredient_id);
                uiDao.create(usering);
            } else {
                req.getSession().setAttribute("error_message", "You must be log-in to add ingredient to your bar");
            }
        }
        return Action.INGLIST;
    }
}
