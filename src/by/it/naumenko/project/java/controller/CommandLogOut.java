package by.it.naumenko.project.java.controller;

import javax.servlet.http.HttpServletRequest;

public class CommandLogOut implements ICommand {
    @Override
    public String exequit(HttpServletRequest request) {
        return "/logout.jsp";
    }
}
