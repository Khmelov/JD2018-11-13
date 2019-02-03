package by.it.seroglazov.project.java.controller;

import by.it.seroglazov.project.java.beans.User;
import by.it.seroglazov.project.java.beans.Usering;
import by.it.seroglazov.project.java.dao.Dao;
import by.it.seroglazov.project.java.dao.MyDao;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

class CmdRemIngFromBar extends Cmd {
    @Override
    Action execute(HttpServletRequest req) throws Exception {
        if (Form.isPost(req)) {
            User user = Util.findUserInSession(req);
            if (user != null) {
                long ingredient_id = Form.getLong(req, "ingredient_id");
                Dao<Usering> uiDao = new MyDao<>(new Usering());
                String sql = String.format("WHERE user_id='%d' and ingredient_id='%d'", user.getId(), ingredient_id);
                List<Usering> uings = uiDao.getAll(sql);
                for (Usering uing : uings) {
                    uiDao.delete(uing);
                }
            }
        }
        return Action.INGLIST;
    }
}
