package by.it.lobkova.project.java.controller;

import by.it.lobkova.project.java.beans.User;
import by.it.lobkova.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

class CmdSignup implements Cmd{
    @Override
    public Action execute(HttpServletRequest req) throws SQLException, SiteException {
        if (Form.isPost(req)) {
            String login = Form.getString(req,"login");
            String password = Form.getStrint(req,"pasword", "[a-zA-Z0-9_-]{4,}");
            String email = Form.getString(req,"email");
            String name = Form.getString(req,"name");
            User user = new User(0, email, login, password, name, 2);
            Dao dao = Dao.getDao();
            if (dao.user.create(user)) {
                req.getSession().setAttribute("user", user);
                return Action.PROFILE;
            }
            return Action.SIGNUP;
        }
        return null;
    }
}
