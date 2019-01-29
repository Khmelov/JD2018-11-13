package by.it.naumenko.project.java.controller;

import by.it.naumenko.project.java.dao.DropDB;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

class CommandDropDB extends Command {
    @Override
    public Actions exequit(HttpServletRequest request) throws SQLException {
        DropDB dropDB = new DropDB();
        dropDB.dropDB();
        return Actions.DROPDB;
    }
}
