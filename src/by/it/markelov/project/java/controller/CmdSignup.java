package by.it.markelov.project.java.controller;

import by.it.markelov.project.java.beans.User;
import by.it.markelov.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

class CmdSignup extends Cmd{
    @Override
    Action execute(HttpServletRequest req) throws SQLException {
        if (req.getMethod().equalsIgnoreCase("POST")){
            String login = req.getParameter("Login");
            String password = req.getParameter("Password");
            String email = req.getParameter("E-mail");

            User user=new User(0, login, password, email, 2);
            DAO dao=DAO.getInstance();
            dao.user.create(user);
            return Action.INDEX;
        }

        return Action.SIGNUP;
    }
}
