package by.it.zhivov.project.java.controller;

import javax.servlet.http.HttpServletRequest;

public class CmdLogout extends Cmd{
    @Override
    Action execute(HttpServletRequest req) {
        return Action.ERROR;
    }
}
