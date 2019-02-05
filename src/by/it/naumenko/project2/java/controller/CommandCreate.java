package by.it.naumenko.project2.java.controller;


import by.it.naumenko.project2.java.beens.Roles;
import by.it.naumenko.project2.java.beens.Users;
import by.it.naumenko.project2.java.dao.MyDAO;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;

class CommandCreate extends Command {
    @Override
    public Actions exequit(HttpServletRequest request, HttpServletResponse response) throws SiteException, LoginException, NoSuchAlgorithmException, SQLException {

        MyDAO<Roles> myDAORole = new MyDAO<>(new Roles(),"roles");
        List<Roles> roles = myDAORole.getAll();
        request.setAttribute("roles", roles);

        if (Form.isPost(request)) {
            String login = Form.getString(request,"login","[a-zA-Z0-9_]{4,}");
            String password = Form.getString(request,"password","[a-zA-Z0-9А-Яа-яЁё_?!#$]{6,}");
            String email = Form.getString(request,"email","[a-zA-Z0-9_]+@[a-zA-Z0-9_]+.[a-zA-Z0-9_]{2,5}");
            long id_role = Form.getLong(request,"id_role");

            Users user = new Users(0,login,password,email,Util.hashMD5(password),id_role);
            MyDAO<Users> usersMyDAO = new MyDAO<>(new Users(),"users");
            usersMyDAO.create(user);
            return Actions.PROFILE;
        }
        return Actions.CREATE;
    }
}
