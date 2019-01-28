package by.it.lobkova.project.java.controller;

import by.it.lobkova.project.java.beans.User;

import javax.servlet.http.HttpServletRequest;

class CmdSignup extends Cmd{
    @Override
    Action execute(HttpServletRequest req) {
        if (req.getMethod().equalsIgnoreCase("POST")) {
            String login = req.getParameter("login");
            String password = req.getParameter("password");
            String email = req.getParameter("email");
            String name = req.getParameter("name");
            User user = new User(1, email, login, password, name, 2);
        }
        return null;
    }
}
