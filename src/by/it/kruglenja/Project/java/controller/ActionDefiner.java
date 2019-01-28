package by.it.kruglenja.Project.java.controller;

import javax.servlet.http.HttpServletRequest;

public class ActionDefiner {
    static Action definer(HttpServletRequest req) {
        String command = req.getParameter("command");
        Action result = Action.ERROR;
        if (command != null && !command.isEmpty()) {
            try {
                result = Action.valueOf(command.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("wrong command");
            }
        }
        return result;
    }
}
