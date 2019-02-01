package by.it.zhivov.project.java.controller;

import by.it.zhivov.project.java.beans.Ad;
import by.it.zhivov.project.java.beans.User;
import by.it.zhivov.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

class CmdProfile implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws SQLException, SiteExeption {
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
        List<Ad> ads = Dao.getDao().ad.getAll(where);
        req.setAttribute("ads", ads);

        return Action.PROFILE;
    }
}
