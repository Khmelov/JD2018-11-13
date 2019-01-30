package by.it.seroglazov.project.java.controller;

import by.it.seroglazov.project.java.dao.DatabaseCreator;

import javax.servlet.http.HttpServletRequest;

class CmdReset extends Cmd {
    @Override
    Action execute(HttpServletRequest req) throws SiteException {
        DatabaseCreator creator = DatabaseCreator.getCreator();
        creator.resetDatabase();
        return Action.RESET;
    }
}
