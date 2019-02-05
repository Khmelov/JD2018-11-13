package by.it.lobkova.project.java.controller;

import javax.servlet.http.HttpServletRequest;

public class CmdLogout implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        req.getSession().invalidate();
        return Action.LOGIN;
    }
}
