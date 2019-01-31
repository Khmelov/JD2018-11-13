package by.it.kruglenja.Project.java.controller;

import by.it.kruglenja.Project.java.beans.User;
import by.it.kruglenja.Project.java.dao.Dao;


import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class CmdSignup implements Cmd{
    @Override
 public    Action execute(HttpServletRequest req) throws SQLException, SiteExpression {
        if (Form.isPost(req)) {
            String login = Form.getString(req,"login");
            String password = Form.getString(req,"password", "[a-zA-Z0-9_-]{6,}");
            String email = Form.getString(req,"email");
            String phone_number = Form.getString(req,"phone_number");

            User user = new User(0, login, password, email, phone_number, 2);
            Dao dao = Dao.getDao();
            if (dao.user.create(user))
                req.getSession().setAttribute("user", user);
                return Action.PROFILE;
        }
        return Action.SIGNUP;
    }
}
