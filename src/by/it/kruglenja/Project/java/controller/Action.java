package by.it.kruglenja.Project.java.controller;

import javax.servlet.http.HttpServletRequest;

public enum Action {
    RESET(new CmdReset()),
    DELETE(new CmdDelete()),
    INDEX( new CmdIndex()),
    LOGIN( new CmdLogin()),
    SIGNUP( new CmdSignup()),
    LOGOUT( new CmdLogout()),
    ORDER(new CmdOrder()),
    ERROR(new CmdError()),
    PROFILE(new CmdProfile());


    Cmd cmd;
    Action(Cmd cmdIndex) {
        this.cmd = cmdIndex;
    }
    String getJsp(){
        return  "/" + this.name().toLowerCase() + ".jsp";
    }

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
