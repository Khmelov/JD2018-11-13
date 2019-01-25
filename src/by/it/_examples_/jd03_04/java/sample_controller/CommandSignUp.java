package by.it._examples_.jd03_04.java.sample_controller;

import javax.servlet.http.HttpServletRequest;

class CommandSignUp implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        return Actions.SIGNUP.jsp;
    }
}