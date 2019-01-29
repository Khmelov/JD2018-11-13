package by.it.seroglazov.project.java.controller;

enum Action {
    INDEX(new CmdIndex()),
    LOGIN(new CmdLogin()),
    LOGOUT(new CmdLogout()),
    SIGNUP(new CmdSignUp()),
    ERROR(new CmdError());

    Cmd cmd;

    Action(Cmd cmd) {
        this.cmd = cmd;
    }

    String getJsp() {
        return "/" + cmd.toString() + ".jsp";
    }
}
