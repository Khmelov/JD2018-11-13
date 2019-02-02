package by.it.kovalyova.project.java.sample_controller;

import javax.servlet.http.HttpServletRequest;

class CommandLogout implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        return Actions.LOGOUT.jsp;
    }
}
