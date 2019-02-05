package by.it.lobkova.project.java.controller;

import javax.servlet.http.HttpServletRequest;

enum Action {

    RESET(new CmdReset()),
    INDEX(new CmdIndex()),
    CREATEGOAL(new CmdCreateGoal()),
    CREATETASK(new CmdCreateTask()),
    LOGIN(new CmdLogin()),
    PROFILE(new CmdProfile()),
    SIGNUP(new CmdSignup()),
    EDITUSERS(new CmdEditUsers()),
    ERROR(new CmdError()),
    LOGOUT(new CmdLogout());

    Cmd cmd;

    Action(Cmd cmdIndex) {
        cmd = cmdIndex;
    }

    String getJsp() {
        return "/" + this.name().toLowerCase() + ".jsp";
    }

    static Action define(HttpServletRequest req) {
        Action result = Action.INDEX;
        String command = req.getParameter("command");
        if (command != null && !command.isEmpty()) {
            try {
                result = Action.valueOf(command.toUpperCase());
            }
            catch (IllegalArgumentException e){
            }
        }
        return result;
    }
}
