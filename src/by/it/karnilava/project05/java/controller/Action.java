package by.it.karnilava.project05.java.controller;

enum Action {

    PROFILE(new CmdProfile()),
    CLIENTPROFILE(new CmdProfile()),
    LOGIN(new CmdLogin()),
    LOGOUT(new CmdLogout()),
    SIGNUP(new CmdSignup()),
    ERROR(new CmdError()),
    ADMINPROFILE(new CmdAdminProfile());

    Cmd cmd;

    Action(Cmd cmdIndex) {
        cmd = cmdIndex;
    }

    String getJsp() {
        return "/" + cmd.toString() + ".jsp";
    }
}
