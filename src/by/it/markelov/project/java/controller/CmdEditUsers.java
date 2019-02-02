package by.it.markelov.project.java.controller;

import by.it.markelov.project.java.beans.Role;
import by.it.markelov.project.java.beans.User;
import by.it.markelov.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

class CmdEditUsers extends Cmd {
    @Override
    Action execute(HttpServletRequest req) throws SQLException, SiteException {


        if (Util.checkUser(req)) {

            DAO dao = DAO.getInstance();


            if (req.getMethod().equalsIgnoreCase("POST")) {
                int id=Form.getInteger(req,"id");
                String login = Form.getString(req, "login");
                String password = Form.getString(req, "password", "[a-zA-Z0-9_-]{4,}");
                String email = Form.getString(req, "email");
                int roles_ID = Form.getInteger(req, "roles_ID");


                User user = new User(id, login, password, email, roles_ID);
                if (req.getParameter("Update") != null)
                    dao.user.update(user);
                if (req.getParameter("Delete") != null)
                    dao.user.delete(user);
            }


            List<User> users = dao.user.getAll("");
            req.setAttribute("users", users);
/*
            List<Role> roles = dao.role.getAll("");
            req.setAttribute("roles", roles);
*/
        }
        return Action.EDITUSERS;
    }
}
