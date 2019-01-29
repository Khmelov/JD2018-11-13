package by.it.naumenko.project.java.controller;

import javax.servlet.http.HttpServletRequest;

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

//    public String getCommand() {
//        return "/" + command.toString() + ".jsp";
//    }

    static Actions define(HttpServletRequest req) {
        Actions result = Actions.ERROR;
        String command = req.getParameter("command");
        if (command != null && !command.isEmpty()) {
            try {
                result = Actions.valueOf(command.toUpperCase());
            }
            catch (IllegalArgumentException e){
                //create our error
            }
        }
        return result;
    }
}
