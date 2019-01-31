package by.it.naumenko.project.java.controller;

import by.it.naumenko.project.java.beens.Users;
import by.it.naumenko.project.java.dao.MyDAO;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;

class CommandLogin extends Command {
    @Override
    public Actions exequit(HttpServletRequest request, HttpServletResponse response) throws SiteException, SQLException, LoginException, NoSuchAlgorithmException {
        if (Form.isPost(request)) {
            String login = Form.getString(request, "login");
            String password = Form.getString(request, "password");
            String where = String.format(" WHERE hashpas = '%s' and login='%s' LIMIT 0,1", Util.hashMD5(password), login);
            MyDAO<Users> myDAO = new MyDAO<>(new Users(), "users");
            List<Users> users = myDAO.getAll(where);
            System.out.println(where);
            if (users.size() == 1) {
                Util.createCookie(response,login,password);
                Users user = users.get(0);
                request.getSession().setAttribute("user", user);
                return Actions.PROFILE;
            }
        }
        return Actions.LOGIN;
    }
}
