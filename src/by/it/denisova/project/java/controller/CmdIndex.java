package by.it.denisova.project.java.controller;

import by.it.denisova.project.java.beans.Lesson;
import by.it.denisova.project.java.beans.Test;
import by.it.denisova.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

class CmdIndex implements Cmd {
    @Override
    public Action execute(HttpServletRequest req)  throws SQLException {
        List<Test> tests = Dao.getDao().test.getAll();
       req.setAttribute("tests",tests);
        return null;
    }
}
