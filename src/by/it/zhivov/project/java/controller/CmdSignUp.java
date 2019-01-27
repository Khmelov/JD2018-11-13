package by.it.zhivov.project.java.controller;

import by.it.zhivov.project.java.beans.User;
import by.it.zhivov.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class CmdSignUp implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws SQLException, SiteExeption {
        if (Form.isPost(req)) {
            String login = Form.getString(req, "login");
            String password = Form.getString(req, "password");
            String name = Form.getString(req, "name");
            String dateOfBirth = Form.getString(req, "dateofbirth");
            String email = Form.getString(req, "email");
            String tel = Form.getString(req, "tel");
            User user = new User(0, name, login, password, dateOfBirth, email, tel, 2);
            Dao dao = Dao.getDao();
            if (dao.user.create(user))
                req.getSession().setAttribute("user", user);
            return Action.PROFILE;
        }
        return Action.SIGNUP;
    }
}
