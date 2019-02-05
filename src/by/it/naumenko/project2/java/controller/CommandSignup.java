package by.it.naumenko.project2.java.controller;


import by.it.naumenko.project2.java.beens.Profil;
import by.it.naumenko.project2.java.beens.Users;
import by.it.naumenko.project2.java.dao.MyDAO;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

class CommandSignup extends Command {
    @Override
    public Actions exequit(HttpServletRequest request, HttpServletResponse response) throws SQLException, SiteException, LoginException, NoSuchAlgorithmException {
        if (Util.checkUser(request)) {
            String errorSign = "Для новой регистрации нужно выйти из аккаунта";
            request.setAttribute("errorSign",errorSign);
            return Actions.ERROR;
        }
        if(request.getMethod().equalsIgnoreCase("POST")) {
            String login = Form.getString(request,"login","[a-zA-Z0-9_]{4,}");
            String password = Form.getString(request,"password","[a-zA-Z0-9А-Яа-яЁё_?!#$]{6,}");
            String email = Form.getString(request,"email","[a-zA-Z0-9_]+@[a-zA-Z0-9_]+.[a-zA-Z0-9_]{2,5}");
            Users user = new Users(0,login,password,email,Util.hashMD5(password),2);
            MyDAO<Users> dao = new MyDAO<>(new Users(),"users");
            if(dao.create(user)) {
                MyDAO<Profil> myDAOProfil = new MyDAO<>(new Profil(),"profil");
                Profil profil = new Profil(user.getId_user(),user.getId_user());
                myDAOProfil.create(profil);
                Util.createCookie(response,login,password);
                return Actions.PROFILE;
            }
            return Actions.ERROR;
        }
        return Actions.SIGNUP;
    }
}
