package by.it.markelov.project.java.controller;

import by.it.markelov.project.java.beans.User;
import by.it.markelov.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

class CmdSignup extends Cmd{
    @Override
    Action execute(HttpServletRequest req) throws SQLException, SiteException {
        if (req.getMethod().equalsIgnoreCase("POST")){
            String login = Form.getString(req,"Login");
            String password = Form.getString(req,"Password", "[a-zA-Z0-9_-]{4,}");
            String email = Form.getString(req,"E-mail");

            User user=new User(0, login, password, email, 2);
            DAO dao=DAO.getInstance();
            dao.user.create(user);

            req.getSession().setAttribute("user", user);
            return Action.PROFILE;
        }

        return Action.SIGNUP;
    }
}
