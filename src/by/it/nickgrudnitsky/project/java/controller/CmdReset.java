package by.it.nickgrudnitsky.project.java.controller;

import by.it.nickgrudnitsky.project.java.dao.MyDao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

class CmdReset extends Cmd {
    @Override
    Action execute(HttpServletRequest req) throws SQLException {
        MyDao.getDao().reset();
        return Action.INDEX;
    }
}
