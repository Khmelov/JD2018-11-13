package by.it.naumenko.project.java.controller;

import by.it.naumenko.project.java.beens.Users;
import by.it.naumenko.project.java.dao.MyDAO;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

class CommandCreate extends Command {
    @Override
    public Actions exequit(HttpServletRequest request, HttpServletResponse response) throws SiteException, LoginException, NoSuchAlgorithmException, SQLException {

        if (Form.isPost(request)) {
            String login = Form.getString(request, "login");
            String password = Form.getString(request, "password");
            String email = Form.getString(request, "email");
            //long id_role = Form.getLong(request, "id_role");
            Users user = new Users(0,login,password,email,Util.hashMD5(password),2);
            MyDAO<Users> usersMyDAO = new MyDAO<>(new Users(),"users");
            usersMyDAO.create(user);
            return Actions.PROFILE;
        }
        return Actions.CREATE;
    }
}
