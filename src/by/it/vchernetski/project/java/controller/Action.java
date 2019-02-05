package by.it.vchernetski.project.java.controller;

import javax.servlet.http.HttpServletRequest;

enum Action {
    RESET(new CmdReset()),
    INDEX(new CmdIndex()),
    LOGIN(new CmdLogin()),
    PROFILE(new CmdProfile()),
    SIGNUP(new CmdSignup()),
    ERROR(new CmdError()),
    CREATE(new CmdCreate()),
    EDITUSERS(new CmdEditUsers()),
    GETLIST(new CmdList()),
    LOGOUT(new CmdLogout()),
    DELETECAR(new CmdDeletecar()),
    DONE(new CmdDone());

    Cmd cmd;

    Action(Cmd cmd) {
        this.cmd = cmd;
    }

    String getjsp() {
        return "/" + this.name().toLowerCase() + ".jsp";
    }
    static Action define(HttpServletRequest request) {
        String command = request.getParameter("command");
        Action result = Action.PROFILE;
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
