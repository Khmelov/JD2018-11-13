package by.it.mnovikov.project.java.controller;

import by.it.mnovikov.project.java.beans.User;
import by.it.mnovikov.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

class CmdLogin implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws SQLException, SiteException {
        if (Form.isPost(req)) {
            String login = Form.getString(req, "login");
            String password = Form.getString(req, "password", "[a-zA-Z0-9_]{6,}");
            String where = String.format(" WHERE login='%s' and password='%s' LIMIT 0,1", login, password);
            List<User> users = Dao.getDao().user.getAll(where);
            if (users.size() > 0){
                User user = users.get(0);
                req.getSession().setAttribute("user", user);
                return  Action.PROFILE;
            }
            return Action.ERROR;
        }
        return Action.LOGIN;
    }
}
