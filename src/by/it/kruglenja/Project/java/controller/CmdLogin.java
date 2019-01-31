package by.it.kruglenja.Project.java.controller;

import by.it.kruglenja.Project.java.beans.User;
import by.it.kruglenja.Project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

public class CmdLogin implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws SQLException, SiteExpression {
        if (Form.isPost(req)) {
            String login = Form.getString(req,"login");
            String password = Form.getString(req,"password", "[a-zA-Z0-9_-]{4,}");

            String sql = String.format(" WHERE login='%s' AND password='%s' LIMIT 0,1", login, password);
            List<User> userDb = Dao.getDao().user.getAll(sql);
            if (userDb.size() == 1) {
                User user = userDb.get(0);
                req.getSession().setAttribute("user", user);
                return Action.PROFILE;
            }
        }
        return Action.LOGIN;
    }
}
