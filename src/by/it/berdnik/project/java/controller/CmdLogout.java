package by.it.berdnik.project.java.controller;

import javax.servlet.http.HttpServletRequest;

class CmdLogout extends Cmd{
    @Override
    Action execute(HttpServletRequest req) {
        return Action.ERROR;
    }
}
