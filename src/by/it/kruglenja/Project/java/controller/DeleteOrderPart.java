package by.it.kruglenja.Project.java.controller;

import by.it.kruglenja.Project.java.beans.Spareparts;
import by.it.kruglenja.Project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

public class DeleteOrderPart implements Cmd{
    @Override
    public Action execute(HttpServletRequest req)throws SQLException {
        Dao dao = Dao.getDao();
        List<Spareparts> catalog = dao.spareparts.getAll();
        req.getSession().setAttribute("catalog", catalog);
        return Action.INDEX;
    }

}
