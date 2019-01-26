package by.it.mnovikov.project.java.controller;

import javax.servlet.http.HttpServletRequest;

class ActionDefiner {

    static Action define(HttpServletRequest req) {
        String command = req.getParameter("command");
        Action result = Action.ERROR;
        if (command != null && !command.isEmpty()) {
            try {
                result = Action.valueOf(command.toUpperCase());
            } catch (IllegalArgumentException e){
                //create our error
            }
        }
        return result;
    }
}
