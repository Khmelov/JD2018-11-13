package by.it.markelov.project.java.controller;

enum Action {

    INDEX(new CmdIndex()),
    LOGIN(new CmdLogin()),
    PROFILE(new CmdProfile()),
    SIGNUP(new CmdSignup()),
    ERROR(new CmdError());

    Cmd cmd;

    Action(Cmd cmdIndex) {
        cmd = cmdIndex;
    }

    String getJsp() {
        return "/" + cmd.toString() + ".jsp";
    }
}
