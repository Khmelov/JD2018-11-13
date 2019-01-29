package by.it.akhmelev.project06.java.controller;

import by.it.akhmelev.project06.java.beans.User;
import by.it.akhmelev.project06.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

class CmdLogin implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws SQLException, SiteException {
        if (Form.isPost(req)) {
            String login = Form.getString(req, "login");
            String password = Form.getString(req, "password", "[a-zA-Z0-9_-]{4,}");
            String where = String.format(" WHERE password='%s' and login='%s' LIMIT 0,1", password, login);
            System.out.println(where); //
            List<User> users = Dao.getDao().user.getAll(where);
            if (users.size() == 1) {
                User user = users.get(0);
                req.getSession().setAttribute("user", user);
                return Action.PROFILE;
            }

        }
        return Action.LOGIN;

    }
}
