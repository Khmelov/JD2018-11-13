package by.it.markelov.jd03_04.java.controller;

import javax.servlet.http.HttpServletRequest;

class CmdLogout extends Cmd{
    @Override
    Action execute(HttpServletRequest req) {
        return Action.ERROR;
    }
}
