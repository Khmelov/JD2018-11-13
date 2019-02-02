package by.it.karnilava.project05.java.controller;

import javax.servlet.http.HttpServletRequest;

class CmdLogout extends Cmd{
    @Override
    Action execute(HttpServletRequest req) {
        return Action.ERROR;
    }
}
