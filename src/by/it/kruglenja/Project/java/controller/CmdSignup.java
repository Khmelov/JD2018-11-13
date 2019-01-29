package by.it.kruglenja.Project.java.controller;

import by.it.kruglenja.Project.java.beans.User;
import by.it.kruglenja.Project.java.dao.Dao;


import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class CmdSignup extends Cmd {
    @Override
    Action execute(HttpServletRequest req) throws SQLException {
        if (req.getMethod().equalsIgnoreCase("post")) {
            String login = req.getParameter("login");
            String password = req.getParameter("password");
            String email = req.getParameter("email");
            String phone_number = "";

            User user = new User(0, login, password, email, phone_number, 2);
            Dao dao = Dao.getDao();
            if (dao.user.create(user))
                return Action.INDEX;
        }
        return Action.SIGNUP;
    }
}
