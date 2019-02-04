package by.it.zhivov.project.java.controller;

import by.it.zhivov.project.java.beans.User;
import by.it.zhivov.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

public class CmdLogin implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws SQLException, SiteExeption {
        if (Form.isPost(req)) {
            String login = Form.getString(req, "login","[a-zA-Z][a-zA-Z0-9_]{3,44}");
            String password = Form.getString(req, "password", "[a-zA-Z][a-zA-Z0-9_^]{4,25}");
            String where = String.format(" WHERE login='%s' and password='%s' LIMIT 0,1", login, password);
            List<User> users = Dao.getDao().user.getAll(where);
            if (users.size() == 1) {
                User user = users.get(0);
                req.getSession().setAttribute("user", user);
                return Action.PROFILE;
            }


        }
        return Action.LOGIN;
    }
}
