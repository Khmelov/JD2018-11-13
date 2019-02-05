package by.it.seroglazov.project.java.controller;

import by.it.seroglazov.project.java.beans.User;
import by.it.seroglazov.project.java.dao.Dao;
import by.it.seroglazov.project.java.dao.MyDao;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

class CmdSignUp extends Cmd {
    @Override
    public Action execute(HttpServletRequest req) {
        if (Util.checkUserInSession(req)) {
            return Action.PROFILE;

        } if (Form.isPost(req)) {

            String login = null;
            try {
                login = Form.getParameterMatchesPattern(req, "login", Patterns.login);
            } catch (SiteException e) {
                req.setAttribute("error_message", "Login contains characters that are not permitted");
                return Action.SIGNUP;
            }

            String password = null;
            try {
                password = Form.getParameterMatchesPattern(req, "password", Patterns.password);
            } catch (SiteException e) {
                req.setAttribute("error_message", "Password contains characters that are not permitted");
                return Action.SIGNUP;
            }

            String email = null;
            try {
                email = Form.getParameterMatchesPattern(req, "email", Patterns.email);
            } catch (SiteException e) {
                req.setAttribute("error_message", "Email contains characters that are not permitted");
                return Action.SIGNUP;
            }

            User user = new User(login, password, email);
            Dao<User> usDao = new MyDao<>(new User());
            try {
                List<User> all = usDao.getAll(String.format("WHERE `name`='%s'", login));
                if (all.size() > 0) {
                    req.setAttribute("error_message", "User whit name '" + login + "' already exists");
                    return Action.SIGNUP;
                }
                all = usDao.getAll(String.format("WHERE `email`='%s'", email));
                if (all.size() > 0) {
                    req.setAttribute("error_message", "User whit email '" + email + "' already exists");
                    return Action.SIGNUP;
                }
            } catch (Exception ignored) {}

            try {
                if (usDao.create(user))
                    req.getSession().setAttribute("user", user);
            } catch (Exception e) {
                req.setAttribute("error_message", "Can&apos;t create user with message: " + e.getMessage());
                return Action.SIGNUP;
            }

            return Action.PROFILE;

        } else {
            return Action.SIGNUP;
        }
    }
}
