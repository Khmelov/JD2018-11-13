package by.it.seroglazov.project.java.controller;

import javax.servlet.http.HttpServletRequest;

class CmdIndex extends Cmd {
    @Override
    Action execute(HttpServletRequest req) {
        return Action.RECIPESLIST;
    }
}
