package by.it.mnovikov.project.java.controller;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by user on 24.01.2019.
 */
class ActionDefiner {

    static Action define(HttpServletRequest req) {
        String command = req.getParameter("command");
        Action res = Action.ERROR;
        if (command != null && !command.isEmpty()) {
            try {
                res = Action.valueOf(command.toUpperCase());
            } catch (IllegalArgumentException e){
                //create our error
            }
        }
        return res;
    }
}
