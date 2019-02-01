package by.it.markelov.project.java.controller;

import by.it.markelov.project.java.beans.Order;
import by.it.markelov.project.java.beans.User;
import by.it.markelov.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

class CmdProfile extends Cmd {
    @Override
    Action execute(HttpServletRequest req) throws SiteException, SQLException {
        if (!Util.checkUser(req)){
            return Action.LOGIN;
        }

        if (req.getMethod().equalsIgnoreCase("POST")) {
            if (Form.getString(req, "Logout") != null) {
                req.getSession().invalidate();
                return Action.LOGIN;
            }
        }
        User user=Util.findUser(req);
        String where = String.format(" WHERE `users_ID`='%d'", user.getId());
        List<Order> orders = DAO.getInstance().order.getAll(where);

        req.setAttribute("orders", orders);

        return Action.PROFILE;
    }
}