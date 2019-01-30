package by.it.markelov.project.java.controller;

import javax.servlet.http.HttpServletRequest;

class ActionDefiner {

    static Action define(HttpServletRequest req) {
        Action result = Action.INDEX;
        String command = req.getParameter("command");
        if (command != null && !command.isEmpty()) {
            try {
            result = Action.valueOf(command.toUpperCase());
            }
            catch (IllegalArgumentException e){
               //create our error
            }
        }
        return result;
    }


}
