package by.it.vchernetski.project.java.controller;

import by.it.vchernetski.project.java.beans.User;
import by.it.vchernetski.project.java.dao.MyDAO;

import javax.servlet.http.HttpServletRequest;

class CmdSignup extends Cmd {
    @Override
    Action execute(HttpServletRequest request) throws Exception {
        if (request.getMethod().equalsIgnoreCase("post")) {
            String login = request.getParameter("login");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            User user = new User();
            user.setEmail(email);
            user.setNickname(login);
            user.setPassword(password);
            user.setFio("asdasdas");
            user.setNumbergarages(2);
            user.setRoles_id(1);
            MyDAO<User> dao = MyDAO.getDao(user);
            if (dao.create())
                return Action.INDEX;
        }
        return Action.SIGNUP;
    }
}
