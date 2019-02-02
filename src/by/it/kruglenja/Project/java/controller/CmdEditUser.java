package by.it.kruglenja.Project.java.controller;

import by.it.kruglenja.Project.java.beans.Roles;
import by.it.kruglenja.Project.java.beans.User;
import by.it.kruglenja.Project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdEditUser implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        if (Util.checkUser(req)) {
            Dao dao = Dao.getDao();
            if (Form.isPost(req)) {
                long id = Form.getLong(req, "id");
                String login = Form.getString(req, "login");
                String password = Form.getString(req, "password");
                String email = Form.getString(req, "email");
                String phone_number = Form.getString(req, "phone_number");
                long roles_Id = Form.getLong(req, "role");
                User user = new User(id, login, password, email, phone_number, roles_Id);
                if (req.getParameter("update") != null) {
                    dao.user.update(user);
                } else if (req.getParameter("delete") != null)
                    dao.user.delete(user);
            }
            List<User> users = dao.user.getAll();
            List<Roles> roles = dao.role.getAll();
            req.setAttribute("users", users);
            req.setAttribute("roles", roles);
        }
        return Action.EDITUSERS;
    }
}