package by.it.berdnik.project.java.controller;


import by.it.berdnik.project.java.beans.Buyer;
import by.it.berdnik.project.java.beans.User;
import by.it.berdnik.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

class CmdProfile implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws SQLException, SiteException {
        if (!Util.checkUser(req))
            return Action.LOGIN;

        if (Form.isPost(req)) {
            if (Form.getString(req, "logout") != null) {
                req.getSession().invalidate();
                return Action.LOGIN;
            }
        }
        User user = Util.findUser(req);
        String where = String.format(" WHERE `users_id`='%d'", user.getId());

        List<Buyer> buyers = Dao.getDao().buyer.getAll(where);
        req.setAttribute("buyers", buyers);

        return Action.PROFILE;
    }
}
