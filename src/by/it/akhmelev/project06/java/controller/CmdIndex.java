package by.it.akhmelev.project06.java.controller;

import by.it.akhmelev.project06.java.beans.Ad;
import by.it.akhmelev.project06.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

class CmdIndex implements Cmd {
    @Override
    public Action execute(HttpServletRequest req)  throws SQLException {
        List<Ad> ads = Dao.getDao().ad.getAll();
        req.setAttribute("ads",ads);
        return null;
    }
}
