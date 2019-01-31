package by.it.naumenko.project.java.controller;


import by.it.naumenko.project.java.beens.Users;
import by.it.naumenko.project.java.dao.MyDAO;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

class CommandSignup extends Command {
    @Override
    public Actions exequit(HttpServletRequest request, HttpServletResponse response) throws SQLException, SiteException, LoginException, NoSuchAlgorithmException {
        if (Util.checkUser(request))
            return Actions.ERROR;

        if(request.getMethod().equalsIgnoreCase("POST")) {
            String login = Form.getString(request,"login");
            String password = Form.getString(request,"password");
            String email = Form.getString(request,"email");
            Users user = new Users(0,login,Util.hashMD5(password),email,2);
//            Dao dao = Dao.getDao();
            MyDAO<Users> dao = new MyDAO<>(new Users(),"users");
            if(dao.create(user)) {
               Util.createCookie(response,login,password);
                //request.getSession().setAttribute("user",user);
                return Actions.PROFILE;
            }
            return Actions.ERROR;
        }
        return Actions.SIGNUP;
    }
}
