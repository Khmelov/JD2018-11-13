package by.it.lobkova.project.java.controller;

import by.it.lobkova.project.java.beans.Goal;
import by.it.lobkova.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

class CmdIndex implements Cmd{
    @Override
    public Action execute(HttpServletRequest req) throws SQLException {
        List<Goal> goals = Dao.getDao().goal.getAll();
        req.setAttribute("goals", goals );
        return null;
    }
}
