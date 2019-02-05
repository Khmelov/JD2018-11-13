package by.it.berdnik.project.java.controller;

import by.it.berdnik.project.java.beans.Buyer;
import by.it.berdnik.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

class CmdIndex implements Cmd {
    @Override
    public Action execute(HttpServletRequest req)  throws SQLException {
        List<Buyer> buyers = Dao.getDao().buyer.getAll();
        req.setAttribute("buyers",buyers);
        return null;
    }
}
