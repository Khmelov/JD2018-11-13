package by.it.naumenko.project.java.controller;

enum Actions {
    SIGNUP(new CommandSignup()),
    LOGIN(new CommandLogin()),
    LOGOUT(new CommandLogOut()),
    INDEX(new CommandIndex()),
    ERROR(new CommandError()),
    RESETDB(new CommandResetDB()),
    DROPDB(new CommandDropDB()),
    PROFILE(new CommandProfile()),
    CREATE(new CommandCreate());


    Command command;

    Actions(Command com) {
        command = com;
    }

    String getJsp() {
        return "/" + command.toString() + ".jsp";
    }


}
