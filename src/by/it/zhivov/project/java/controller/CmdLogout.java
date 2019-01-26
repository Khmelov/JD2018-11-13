package by.it.zhivov.project.java.controller;

import javax.servlet.http.HttpServletRequest;

public class CmdLogout implements Cmd{
    @Override
    public Action execute(HttpServletRequest req) {
        return Action.ERROR;
    }
}
