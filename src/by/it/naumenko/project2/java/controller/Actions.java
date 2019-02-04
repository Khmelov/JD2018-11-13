package by.it.naumenko.project2.java.controller;

public enum Actions {
    SIGNUP(new CommandSignup()),
    LOGIN(new CommandLogin()),
    LOGOUT(new CommandLogOut()),
    INDEX(new CommandIndex()),
    ERROR(new CommandError()),
    RESETDB(new CommandResetDB()),
    DROPDB(new CommandDropDB()),
    PROFILE(new CommandProfil()),
    EDITPROFIL(new CommandEditProfil()),
    CREATE(new CommandCreate()),
    CREATECAKE(new CommandCreateCake()),
    BRAKETS (new CommandBrakets()),
    CREATEROLE(new CommandCreateRole());


    Command command;

    Actions(Command com) {
        command = com;
    }

    String getJsp() {
        return "/" + command.toString() + ".jsp";
    }


}
