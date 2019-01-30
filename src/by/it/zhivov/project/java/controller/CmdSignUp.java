package by.it.zhivov.project.java.controller;

import by.it.zhivov.project.java.beans.User;
import by.it.zhivov.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class CmdSignUp implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws SQLException, SiteExeption {
        if (Form.isPost(req)) {
            String login = Form.getString(req, "login", "[a-zA-Z][a-zA-Z0-9_]{3,44}");
            String password = Form.getString(req, "password", "[a-zA-Z][a-zA-Z0-9_^]{4,25}");
            String name = Form.getString(req, "name", "[a-zA-zа-яА-я ]{4,100}");
            String dateOfBirth = Form.getString(req, "dateofbirth", "(19|20)\\d\\d[.-](0[1-9]|1[012])[.-](0[1-9]|[12][0-9]|3[01])");
            String email = Form.getString(req, "email", "[a-z][a-z0-9_]+@[a-z]+\\.[a-z]+");
            String tel = Form.getString(req, "tel", "[+](375)(33|29|44)[0-9]{7}");
            User user = new User(0, name, login, password, dateOfBirth, email, tel, 2);
            Dao dao = Dao.getDao();
            if (dao.user.create(user))
                req.getSession().setAttribute("user", user);
            return Action.PROFILE;
        }
        return Action.SIGNUP;
    }
}
