package by.it.seroglazov.project.java.controller;

import by.it.seroglazov.project.java.beans.User;
import by.it.seroglazov.project.java.dao.Dao;
import by.it.seroglazov.project.java.dao.MyDao;

import javax.servlet.http.HttpServletRequest;

class CmdSignUp extends Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {

        if (Util.checkUserInSession(req)) {
            return Action.PROFILE;

        } if (Form.isPost(req)) {

            String login = null;
            try {
                login = Form.getParameterMatchesPattern(req, "login", Patterns.login);
            } catch (SiteException e) {
                req.setAttribute("wrong_login", new Object());
                return Action.SIGNUP;
            }

            String password = null;
            try {
                password = Form.getParameterMatchesPattern(req, "password", Patterns.password);
            } catch (SiteException e) {
                req.setAttribute("wrong_password", new Object());
                return Action.SIGNUP;
            }

            String email = null;
            try {
                email = Form.getParameterMatchesPattern(req, "email", Patterns.email);
            } catch (SiteException e) {
                req.setAttribute("wrong_email", new Object());
                return Action.SIGNUP;
            }

            User user = new User(login, password, email);
            Dao<User> usDao = new MyDao<>(new User());

            if (usDao.create(user))
                req.getSession().setAttribute("user", user);

            return Action.PROFILE;

        } else {
            return Action.SIGNUP;
        }
    }
}
