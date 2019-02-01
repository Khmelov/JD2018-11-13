package by.it.kruglenja.Project.java.controller;

import by.it.kruglenja.Project.java.beans.User;
import by.it.kruglenja.Project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

public class CmdLogin implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws SQLException {
        if (req.getMethod().equalsIgnoreCase("post")) {
            String login = req.getParameter("login");
            String password = req.getParameter("password");

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
