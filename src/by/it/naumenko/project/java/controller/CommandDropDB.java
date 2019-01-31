package by.it.naumenko.project.java.controller;

import by.it.naumenko.project.java.dao.DropDB;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

class CommandDropDB extends Command {
    @Override
    public Actions exequit(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        DropDB dropDB = new DropDB();
        dropDB.dropDB();
        return Actions.DROPDB;
    }
}
