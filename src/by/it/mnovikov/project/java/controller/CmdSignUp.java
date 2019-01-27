package by.it.mnovikov.project.java.controller;

import by.it.mnovikov.project.java.beans.User;
import by.it.mnovikov.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.sql.Timestamp;

class CmdSignUp implements Cmd {

    @Override
    public Action execute(HttpServletRequest req) throws SiteException, SQLException {
        if (Form.isPost(req)) {
            String login = Form.getString(req, "login");
            String password = Form.getString(req, "password", "[a-zA-Z0-9_]{6,}");
            String email = Form.getString(req, "email");
            String firstName = Form.getString(req, "first_name");
            String lastName = Form.getString(req, "last_name");
            String birthday = Form.getString(req, "birthday");
            String adress = Form.getString(req, "adress");
            User user = new User(0, login, password, email,
                    firstName, lastName, Timestamp.valueOf(birthday), adress, 2);
            Dao dao = Dao.getDao();
            if (dao.user.create(user))
                req.getSession().setAttribute("user", user);
            return Action.PROFILE;
        }
        return Action.SIGNUP;
    }
}
