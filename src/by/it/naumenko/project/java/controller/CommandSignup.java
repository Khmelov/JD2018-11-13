package by.it.naumenko.project.java.controller;


import by.it.naumenko.project.java.beens.Users;
import by.it.naumenko.project.java.dao.MyDAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

class CommandSignup extends Command {
    @Override
    public Actions exequit(HttpServletRequest request) throws SQLException {

        if(request.getMethod().equalsIgnoreCase("POST")) {
            String login = request.getParameter("login");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            Users user = new Users(0,login,password,email,2);
//            Dao dao = Dao.getDao();
            MyDAO<Users> dao = new MyDAO<>(new Users(),"users");
            if(dao.create(user)) {
                System.out.println("User create");

                //request.getSession().setAttribute("user",user);
                return Actions.INDEX;
            }
            System.out.println("user no create");
            return Actions.ERROR;
        }
        return Actions.SIGNUP;
    }
}
