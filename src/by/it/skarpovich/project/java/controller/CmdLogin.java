package by.it.skarpovich.project.java.controller;

import by.it.skarpovich.project.java.beans.User;
import by.it.skarpovich.project.java.dao.Dao;
import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

class CmdLogin implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws SQLException, SiteException {
        if (Form.isPost(req)) {
            String username = Form.getString(req, "username");
            String password = Form.getString(req, "password", "[a-zA-Z0-9_-]{4,}");
            String where = String.format(" WHERE password='%s' and username='%s' LIMIT 0,1", password, username);
            List<User> users = Dao.getDao().user.getAll(where);
            if (users.size() == 1) {
                User user = users.get(0);
                int userRole=user.getRoles_id();
                req.getSession().setAttribute("user", user);
                req.getSession().setAttribute("userRole", userRole);

                //req.getSession().setMaxInactiveInterval(30);
                return Action.PROFILE;
            }
        }
        return Action.LOGIN;

    }
}
