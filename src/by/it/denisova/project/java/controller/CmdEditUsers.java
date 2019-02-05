package by.it.denisova.project.java.controller;

import by.it.denisova.project.java.beans.User;
import by.it.denisova.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

public class CmdEditUsers implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws SQLException, SiteException {
        if (Util.checkUser(req)) {
            Dao dao = Dao.getDao();

            if (Form.isPost(req)) {
                long id = Form.getLong(req, "id");
                String login = Form.getString(req, "login");
                String password = Form.getString(req, "password", "[a-zA-Z0-9_-]{4,}");
                String email = Form.getString(req, "email");
                long id_role = Form.getLong(req, "id_role");
                User user = new User(id, login, password, email, id_role);
                if (req.getParameter("Update") != null)
                    dao.user.update(user);
                else if (req.getParameter("Delete") != null)
                    dao.user.delete(user);
            }

            List<User> users = dao.user.getAll();
            req.setAttribute("users", users);
        }
        return Action.EDITUSERS;
    }
}
