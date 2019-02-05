package by.it.baidak.project.java.controller;

import javax.servlet.http.HttpServletRequest;

enum Action {

    RESET(new CmdReset()),
    INDEX(new CmdIndex()),
    LOGIN(new CmdLogin()),
    SIGNUP(new CmdSignup()),
    PROFILE(new CmdProfile()),
    NEWPOST(new CmdNewpost()),
    REMOVEPOST(new CmdRemovePost()),
    EDITUSERS(new CmdEditUsers()),
    REMOVEUSER(new CmdRemoveUser()),
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
            }
            catch (IllegalArgumentException e) {
            }
        }
        return result;
    }
}
