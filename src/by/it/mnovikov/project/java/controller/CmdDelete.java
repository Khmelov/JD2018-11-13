package by.it.mnovikov.project.java.controller;

import by.it.mnovikov.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

class CmdDelete implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws SQLException {
        Dao.getDao().delete();
        return Action.INDEX;
    }
}
