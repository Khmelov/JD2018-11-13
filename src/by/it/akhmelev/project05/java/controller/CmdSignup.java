package by.it.akhmelev.project05.java.controller;


import by.it.akhmelev.project05.java.beans.User;
import by.it.akhmelev.project05.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

class CmdSignup extends Cmd {
    @Override
    Action execute(HttpServletRequest req) throws SQLException {
        if (req.getMethod().equalsIgnoreCase("POST")) {

            String login = req.getParameter("login");
            String password = req.getParameter("password");
            String email = req.getParameter("email");
            User user = new User(0, login, password, email, 2);
            Dao dao = Dao.getDao();
            if (dao.user.create(user))
                return Action.INDEX;
        }

        return Action.SIGNUP;
    }
}
