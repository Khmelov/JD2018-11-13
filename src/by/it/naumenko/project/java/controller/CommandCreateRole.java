package by.it.naumenko.project.java.controller;

import by.it.naumenko.project.java.beens.Roles;
import by.it.naumenko.project.java.dao.MyDAO;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

class CommandCreateRole extends Command {
    @Override
    public Actions exequit(HttpServletRequest request, HttpServletResponse response) throws SiteException, LoginException, NoSuchAlgorithmException, SQLException {

        if (Form.isPost(request)) {
            String role = Form.getString(request, "role");
            Roles roles = new Roles(0, role);
            MyDAO<Roles> rolesMyDAO = new MyDAO<>(new Roles(), "roles");
            rolesMyDAO.create(roles);
            return Actions.PROFILE;
        }
        return Actions.CREATE;
    }
}
