package by.it.zhivov.project.java.controller;

public enum Action {
    INDEX(new CmdIndex()),
    LOGIN(new CmdLogin()),
    LOGOUT(new CmdLogout()),
    SIGNUP(new CmdSignUp()),
    ERROR(new CmdError());

    Cmd cmd;

    Action(Cmd cmdIndex) {
        cmd = cmdIndex;
    }

    String getJsp() {
        return "/" + cmd.toString() + ".jsp";
    }

}

