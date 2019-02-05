package by.it.nickgrudnitsky.project.java.controller;

import by.it.nickgrudnitsky.project.java.dao.MyDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

class CmdResetStreamer extends Cmd {
    @Override
    Action execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        MyDao.getDao().reset();
        return Action.PROFILESTREAMER;
    }
}
