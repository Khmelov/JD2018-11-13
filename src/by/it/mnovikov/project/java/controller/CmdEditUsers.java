package by.it.mnovikov.project.java.controller;

import by.it.mnovikov.project.java.beans.User;
import by.it.mnovikov.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

class CmdEditUsers implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws SQLException, SiteException {
        if (Util.checkUser(req)) {

            Dao dao = Dao.getDao();

            if (Form.isPost(req)) {
                int id = Form.getInteger(req, "id");
                String login = Form.getString(req, "login");
                String password = Form.getString(req, "password", "[a-zA-Z0-9_]{6,}");
                String email = Form.getString(req, "email");
                String firstName = Form.getString(req, "first_name");
                String lastName = Form.getString(req, "last_name");
                String birthday = Form.getString(req, "birthday");
                String adress = Form.getString(req, "adress");
                int roles_id = Form.getInteger(req, "roles_id");
                User user = new User(id, login, password, email, firstName, lastName,
                        Timestamp.valueOf(birthday), adress, roles_id);
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
