package by.it.vchernetski.project.java.controller;

import javax.servlet.http.HttpServletRequest;

public class ActionDefiner {
    static Action define(HttpServletRequest request) {
        String command = request.getParameter("command");
        Action result = Action.ERROR;
        if (command != null && !command.isEmpty()){
            try {
                result = Action.valueOf(command.toUpperCase());
            }
            catch (IllegalArgumentException e){

            }
        }
        return result;
    }
}
