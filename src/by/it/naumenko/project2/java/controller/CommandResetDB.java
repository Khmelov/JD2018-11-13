package by.it.naumenko.project2.java.controller;

import by.it.naumenko.project2.java.dao.ResetDB;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

class CommandResetDB extends Command {
    @Override
    public Actions exequit(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        ResetDB resetDB = new ResetDB();
        resetDB.createDB();
        return Actions.RESETDB;
    }
}
