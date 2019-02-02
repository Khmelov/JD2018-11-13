package by.it.kruglenja.Project.java.controller;

import by.it.kruglenja.Project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class CmdDelete  implements Cmd {
    @Override
    public Action execute(HttpServletRequest req)throws SQLException {
        Dao.getDao().delete();
        req.getSession().setAttribute("message", "База данных удалена!");
        return Action.ERROR;

    }
}
