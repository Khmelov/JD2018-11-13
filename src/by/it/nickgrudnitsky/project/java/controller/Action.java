package by.it.nickgrudnitsky.project.java.controller;

import javax.servlet.http.HttpServletRequest;

enum Action {

    PROFILE(new CmdProfile()),
    PROFILESTREAMER(new CmdProfileStreamer()),
    BROWSE(new CmdBrowse()),
    BROWSESTREAMER(new CmdBrowseStreamer()),
    RESET(new CmdReset()),
    RESETSTREAMER(new CmdResetStreamer()),
    INDEX(new CmdIndex()),
    LOGIN(new CmdLogin()),
    LOGINSTREAMER(new CmdLoginStreamer()),
    LOGOUT(new CmdLogout()),
    LOGOUTSTREAMER(new CmdLogoutStreamer()),
    SIGNUP(new CmdSignup()),
    ERROR(new CmdError()),
    EDITGAMES(new CmdEditGames()),
    EDITVIEWERS(new CmdEditViewers()),
    EDITSTREAMERS(new CmdEditStreamers());

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
