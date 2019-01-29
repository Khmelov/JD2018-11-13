package by.it.markelov.project.java.controller;

import by.it.markelov.project.java.beans.User;
import by.it.markelov.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

class CmdLogin extends Cmd {
    @Override
    Action execute(HttpServletRequest req) throws SiteException, SQLException {
        if (req.getMethod().equalsIgnoreCase("POST")) {
            String login = Form.getString(req, "Login");
            String password = Form.getString(req, "Password", "[a-zA-Z0-9_-]{4,}");

            String where = String.format(" WHERE login='%s' AND password='%s' LIMIT 0,1", login, password);
            List<User> allUsers = DAO.getInstance().user.getAll(where);
            if (allUsers.size() == 1) {
                User user = allUsers.get(0);
                req.getSession().setAttribute("user", user);
                return Action.PROFILE;
            }
        }
        return Action.LOGIN;
    }
}
