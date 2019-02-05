package by.it.zakharenko.project.java.controller;

import by.it.zakharenko.project.java.beans.Item;
import by.it.zakharenko.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

class CmdIndex implements Cmd {
    @Override
    public Action execute(HttpServletRequest req)  throws SQLException {
        List<Item> items = Dao.getDao().item.getAll();
        req.setAttribute("items",items);
        return null;
    }
}
