package by.it.vchernetski.project.java.controller;

enum Action {
    INDEX(new CmdIndex()),
    LOGIN(new CmdLogin()),
    LOGOUT(new CmdLogout()),
    SIGNUP(new CmdSignup()),
    ERROR(new CmdError());

    Cmd cmd;

    Action(Cmd cmd) {
        this.cmd = cmd;
    }

    String getjsp() {
        return "/" + cmd.toString() + ".jsp";
    }
}
