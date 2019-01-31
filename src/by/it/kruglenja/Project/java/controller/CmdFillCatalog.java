package by.it.kruglenja.Project.java.controller;

import javax.servlet.http.HttpServletRequest;

public class CmdFillCatalog implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        return Action.FILLCATALOG;
    }
}
