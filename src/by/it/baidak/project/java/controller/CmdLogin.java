package by.it.baidak.project.java.controller;

import by.it.baidak.project.java.DAO.DAO;
import by.it.baidak.project.java.beans.User;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

class CmdLogin extends Cmd{
    @Override
    Action execute(HttpServletRequest req) throws SQLException, SiteException {
        if (Form.isPost(req)) {
            String login = Form.getString(req, "login");
            String password = Form.getString(req, "password", "[a-zA-Z0-9_-]{4,}");
            String where = String.format(" WHERE pass='%s' and nickname='%s' LIMIT 0,1", password, login);
            List<User> users = DAO.getDAO().user.get(where);
            if (users.size() == 1) {
                User user = users.get(0);
                req.getSession().setAttribute("user", user);
                req.getSession().setAttribute("roleID",user.getRoles_Id());
                req.getSession().setMaxInactiveInterval(1*30);
                return Action.INDEX;
            }
        }
        return Action.LOGIN;
    }
}
