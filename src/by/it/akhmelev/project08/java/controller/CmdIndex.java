package by.it.akhmelev.project08.java.controller;

import by.it.akhmelev.project08.java.beans.Ad;
import by.it.akhmelev.project08.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

class CmdIndex implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws SQLException {
        List<Ad> ads = Dao.getDao().ad.getAll();
        req.setAttribute("adsSize", ads.size());
        int start = (req.getParameter("start") != null) ? Form.getInteger(req, "start") : 0;
        int step = 10;
        String limit = String.format(" LIMIT %d,%d ", start, step);
        ads = Dao.getDao().ad.getAll(limit);
        req.setAttribute("ads", ads);
        return Action.INDEX;
    }
}
