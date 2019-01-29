package by.it.naumenko.project.java.controller;

import by.it.naumenko.project.java.dao.ResetDB;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

class CommandResetDB extends Command {
    @Override
    public Actions exequit(HttpServletRequest request) throws SQLException {
        ResetDB resetDB = new ResetDB();
        resetDB.createDB();
        return Actions.RESETDB;
    }
}
