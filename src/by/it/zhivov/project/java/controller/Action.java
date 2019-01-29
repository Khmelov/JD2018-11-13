package by.it.zhivov.project.java.controller;

public enum Action {
    INDEX(new CmdIndex()),
    LOGIN(new CmdLogin()),
    LOGOUT(new CmdLogout()),
    SIGNUP(new CmdSignUp()),
    ERROR(new CmdError()),
    CREATEAD(new CmdCreateAd()),
    LISTAD(new CmdListAd());


    Cmd cmd;

    Action(Cmd cmdIndex) {
        cmd = cmdIndex;
    }

    String getJsp() {
        return "/" + cmd.toString() + ".jsp";
    }

}

