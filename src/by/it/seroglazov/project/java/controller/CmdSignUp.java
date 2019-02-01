package by.it.seroglazov.project.java.controller;

import by.it.seroglazov.project.java.beans.User;
import by.it.seroglazov.project.java.dao.Dao;
import by.it.seroglazov.project.java.dao.MyDao;

import javax.servlet.http.HttpServletRequest;

class CmdSignUp extends Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        if (Form.isPost(req)) {
            String login = Form.getParameterMatchesPattern(req, "login");
            String password = Form.getParameterMatchesPattern(req, "password", "[a-zA-Z0-9_-]{4,}");
            String email = Form.getParameterMatchesPattern(req, "email");
            User user = new User(login, password);
            Dao<User> usDao = new MyDao<>(new User());
            if (usDao.create(user))
                req.getSession().setAttribute("user", user);
            return Action.PROFILE;
        }

        return Action.SIGNUP;
    }
