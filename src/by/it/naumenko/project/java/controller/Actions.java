package by.it.naumenko.project.java.controller;

enum Actions {
    SIGNUP (new CommandSignup()),
    LOGIN (new CommandLogin()),
    LOGOUT (new CommandLogOut()),
    INDEX (new CommandIndex()),
    ERROR (new CommandError());

    Command command;

    Actions(Command com) {
        command=com;
    }
    String getJsp() {
        return "/" + command.toString() + ".jsp";
    }

//    public String getCommand() {
//        return "/" + command.toString() + ".jsp";
//    }
}
