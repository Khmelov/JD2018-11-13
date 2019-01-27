package by.it.mnovikov.project.java.controller;

import by.it.mnovikov.project.java.beans.Good;
import by.it.mnovikov.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

class CmdIndex implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws SQLException {
        List<Good> goods = Dao.getDao().good.getAll();
        req.setAttribute("goods", goods);
        return null;
    }
}
