package by.it.seroglazov.project.java.controller;

import javax.servlet.http.HttpServletRequest;

enum Action {

    INDEX(new CmdIndex()),

    ADDRECIPE(new CmdAddRecipe()),

    SHOWNEWRECIPE(new CmdShowNewRecipe()),

    RECIPESLIST(new CmdRecipesList()),

    LOGIN(new CmdLogin()),

    SIGNUP(new CmdSignUp()),

    ERROR(new CmdError()),

    RESET(new CmdReset()),

    INGLIST (new CmdIngList()),

    PROFILE (new CmdProfile()),

    ADDINGTOBAR (new CmdAddIngToBar()),

    REMINGFROMBAR (new CmdRemIngFromBar()),

    DELETERECIPE (new CmdDeleteRecipe()),

    CHANGERECIPE (new CmdChangeRecipe());

    Cmd cmd;

    Action(Cmd cmd) {
        this.cmd = cmd;
    }

    String getJsp() {
        return "/" + cmd.toString() + ".jsp";
    }

    static Action define(HttpServletRequest req) {
        Action result = Action.ERROR;
        String command = req.getParameter("command");
        if (command != null && !command.isEmpty()) {
            try {
                result = Action.valueOf(command.toUpperCase());
            } catch (IllegalArgumentException e) {
                //
            }
        }
        return result;
    }
}
