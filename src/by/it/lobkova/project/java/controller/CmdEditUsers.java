package by.it.lobkova.project.java.controller;

import by.it.lobkova.project.java.beans.User;
import by.it.lobkova.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

class CmdEditUsers implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws SQLException, SiteException {
        if (Util.checkUser(req)) {
            Dao dao = Dao.getDao();
            if (Form.isPost(req)) {
                long id = Form.getLong(req, "id");
                String login = Form.getString(req, "login");
                String password = Form.getString(req, "password");
                String email = Form.getString(req, "email");
                long roles_ID = Form.getLong(req, "roles_ID");
                User user = new User(id, login, password, email, "", roles_ID);
                if (req.getParameter("Update") != null)
                    dao.user.update(user);
                else if (req.getParameter("Delete") != null)
                    dao.user.delete(user);
            }
            List<User> userAll = Dao.getDao().user.getAll();
            req.setAttribute("users", userAll);
        }
        return Action.EDITUSERS;
    }
}
