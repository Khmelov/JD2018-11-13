package by.it.baidak.project.java.controller;

import by.it.baidak.project.java.DAO.DAO;

import javax.servlet.http.HttpServletRequest;

public class CmdReset extends Cmd {
    @Override
    Action execute(HttpServletRequest req) throws Exception {
        DAO.getDAO().reset();
        return Action.INDEX;
    }
}
