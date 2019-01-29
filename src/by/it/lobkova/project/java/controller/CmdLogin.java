package by.it.lobkova.project.java.controller;

import by.it.lobkova.project.java.beans.User;
import by.it.lobkova.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

class CmdLogin implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws SQLException, SiteException {
        if (Form.isPost(req)) {
            String login = Form.getString(req, "login");
            String password = Form.getStrint(req, "pasword", "[a-zA-Z0-9_-]{4,}");
            String where = String.format(" WHERE password='%s' and login='%s' LIMIT 0,1", password, login);
            List<User> all = Dao.getDao().user.getAll(where);
            if (all.size() == 1) {
                User user = all.get(0);
                req.getSession().setAttribute("user", user);
                return Action.PROFILE;
            }
        }
        return Action.LOGIN;
    }
}
