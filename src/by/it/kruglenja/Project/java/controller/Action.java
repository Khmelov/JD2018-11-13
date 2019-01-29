package by.it.kruglenja.Project.java.controller;

public enum Action {
    INDEX( new CmdIndex()),
    LOGIN( new CmdLogin()),
    SIGNUP( new CmdSignup()),
    LOGOUT( new CmdLogout()),
    ORDER(new CmdOrder()),
    ERROR(new CmdError()),
    PROFILE(new CmdProfile());


    Cmd cmd;
    Action(Cmd cmdIndex) {
        this.cmd = cmdIndex;
    }
    String getJsp(){
        return  "/" + cmd.toString() + ".jsp";
    }
}
