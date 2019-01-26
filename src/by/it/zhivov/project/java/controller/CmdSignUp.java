package by.it.zhivov.project.java.controller;

import by.it.zhivov.project.java.beans.User;
import by.it.zhivov.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class CmdSignUp implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws SQLException {
        if (req.getMethod().equalsIgnoreCase("POST")) {
            String login = req.getParameter("login");
            String password = req.getParameter("password");
            String email = req.getParameter("email");
            User user = new User(0, "name", login, password, "222", email, "2e22e", 2);
            Dao dao = Dao.getDao();
            if (dao.user.create(user))
                req.getSession().setAttribute("user",user);
                return Action.PROFILE;
        }
        return Action.SIGNUP;
    }
}
