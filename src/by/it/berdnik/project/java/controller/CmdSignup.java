package by.it.berdnik.project.java.controller;

import javax.servlet.http.HttpServletRequest;

class CmdSignup extends Cmd {
    @Override
    Action execute(HttpServletRequest req) {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
//        User user = new User(0, login, password, email, 2);
//        Dao dao = Dao.getDao();

        return null;
    }
}
