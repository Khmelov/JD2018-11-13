package by.it.seroglazov.project.java.controller;

import by.it.seroglazov.project.java.beans.User;
import by.it.seroglazov.project.java.dao.Dao;
import by.it.seroglazov.project.java.dao.MyDao;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

class CmdLogin extends Cmd {
    @Override
    Action execute(HttpServletRequest req) throws Exception {
        if (Util.checkUserInSession(req)) {
            return Action.PROFILE;
        } else if (Form.isPost(req)) {
            String login = null;
            String password = null;
            try {
                login = Form.getParameterMatchesPattern(req, "login", Patterns.login);
                password = Form.getParameterMatchesPattern(req, "password", Patterns.password);
            } catch (SiteException e) {
                req.setAttribute("wrong_name", new Object());
                return Action.LOGIN;
            }

            Dao<User> usDao = new MyDao<>(new User());
            User user = usDao.findFirstByFieldValue("name", login);
            if (user == null) {
                req.setAttribute("wrong_name", new Object());
                return Action.LOGIN;
            }
            if (password.equals(user.getPassword())) {
                req.getSession().setAttribute("user", user);
                return Action.PROFILE;
            }
            else {
                req.setAttribute("wrong_password", new Object());
                return Action.LOGIN;
            }
        } else {
            return Action.LOGIN;
        }
    }
}
