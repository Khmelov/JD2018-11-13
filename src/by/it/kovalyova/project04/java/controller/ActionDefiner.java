package by.it.kovalyova.project04.java.controller;

import javax.servlet.http.HttpServletRequest;

public class ActionDefiner {
    static Action define(HttpServletRequest req){
        Action result=Action.ERROR;
        String command = req.getParameter("command");
               if (command!=null && !command.isEmpty()){
                   try {
                       result=Action.valueOf(command.toUpperCase());
                   }
                   catch (IllegalArgumentException e){
                       //create our error
                   }

        }
        return result;
    }
}
