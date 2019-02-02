package by.it.markelov.project.java.controller;

enum Action {

    RESET(new CmdReset()),
    INDEX(new CmdIndex()),
    ORDER(new CmdOrder()),
    LOGIN(new CmdLogin()),
    PROFILE(new CmdProfile()),
    SIGNUP(new CmdSignup()),
    EDITUSERS (new CmdEditUsers()),
    ERROR(new CmdError());




    Cmd cmd;

    Action(Cmd cmdIndex) {
        cmd = cmdIndex;
    }

    String getJsp() {
        return "/" + cmd.toString() + ".jsp";
    }
}
