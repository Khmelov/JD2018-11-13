package by.it.berdnik.project.java.controller;

import by.it.berdnik.project.java.beans.User;
import by.it.berdnik.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

class CmdSignup implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws SQLException, SiteException {
        if (Form.isPost(req)) {
            String login = Form.getString(req,"login", "[a-zA-Zа-яёА-ЯЁ0-9_]{4,}");
            String password = Form.getString(req,"password", "[a-zA-Zа-яёА-ЯЁ0-9_]{4,}");
            String email = Form.getString(req,"email");
            User user = new User(0, login, password, email, 2);
            Dao dao = Dao.getDao();
            if (dao.user.create(user))
                req.getSession().setAttribute("user",user);
            return Action.PROFILE;
        }
        return Action.SIGNUP;
    }
}
