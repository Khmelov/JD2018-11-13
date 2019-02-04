package by.it.skarpovich.project.java.controller;

import by.it.skarpovich.project.java.beans.Order;
import by.it.skarpovich.project.java.beans.User;
import by.it.skarpovich.project.java.dao.Dao;
import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

public class CmdEditOrders implements Cmd{

    @Override
    public Action execute(HttpServletRequest req) throws SQLException, SiteException {
        if (!Util.checkUser(req))
            return Action.LOGIN;

        if (Form.isPost(req)) {
            if (Form.getString(req, "logout") != null) {
                req.getSession().invalidate();
                return Action.LOGIN;
            }
        }
        User user = Util.findUser(req);
        String where = String.format(" WHERE `users_id`='%d'", user.getId());
        if (user.getRoles_id() == 2) {
            List<Order> orders = Dao.getDao().order.getAll(where);
            req.setAttribute("orders", orders);
        } else if (user.getRoles_id() == 1) {
            List<Order> orders = Dao.getDao().order.getAll();
            req.setAttribute("orders", orders);
        } else {
            return Action.LOGIN;
        }

        return Action.EDITORDERS;
    }
}





