package by.it.kruglenja.Project.java.controller;

import by.it.kruglenja.Project.java.beans.Order;
import by.it.kruglenja.Project.java.beans.User;
import by.it.kruglenja.Project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

public class CmdOrder  implements Cmd {
    @Override
    public Action execute(HttpServletRequest req)throws SQLException {
        if (Util.findUser(req) != null) {
            String where = String.format(" WHERE users_id='%d'", Util.findUser(req).getId());
            List<Order> order = Dao.getDao().order.getAll(where);
            req.getSession().setAttribute("order", order);
            return Action.ORDER;
        }
        return Action.LOGIN;
    }
}
