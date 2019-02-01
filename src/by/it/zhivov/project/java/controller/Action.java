package by.it.zhivov.project.java.controller;

import javax.servlet.http.HttpServletRequest;

public enum Action {

    RESET(new CmdReset()),
    INDEX(new CmdIndex()),
    LOGIN(new CmdLogin()),
    PROFILE(new CmdProfile()),
    SIGNUP(new CmdSignUp()),
    ERROR(new CmdError()),
    CREATEAD(new CmdCreateAd());

    Cmd cmd;

    Action(Cmd cmdIndex) {
        cmd = cmdIndex;
    }

    static Action define(HttpServletRequest req) {
        Action result = Action.INDEX;
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

    String getJsp() {
        return "/" + this.name().toLowerCase() + ".jsp";
    }

}

