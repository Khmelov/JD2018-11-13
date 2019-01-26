package by.it.zhivov.project.java.controller;

import javax.servlet.http.HttpServletRequest;

public enum Action {
    PROFILE(new CmdProfile()),
    RESET(new CmdReset()),
    INDEX(new CmdIndex()),
    LOGIN(new CmdLogin()),
    LOGOUT(new CmdLogout()),// тут зырь
    SIGNUP(new CmdSignUp()),
    ERROR(new CmdError());

    Cmd cmd;

    Action(Cmd cmdIndex) {
        cmd = cmdIndex;
    }

    String getJsp() {
        return "/" + this.name().toLowerCase() + ".jsp";
    }

    static Action define(HttpServletRequest req) {
        Action result = Action.ERROR;
        String command = req.getParameter("command");
        if (command != null && !command.isEmpty()) {
            try {
                result = Action.valueOf(command.toUpperCase());
            } catch (IllegalArgumentException e) {
                //create error
            }
        }
        return result;
    }

}

