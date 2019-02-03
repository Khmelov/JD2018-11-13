package by.it.markelov.project.java.controller;

import by.it.markelov.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;

class CmdReset extends Cmd{
    @Override
    Action execute(HttpServletRequest req) {
        DAO.getInstance().reset();
        return Action.INDEX;
    }
}
