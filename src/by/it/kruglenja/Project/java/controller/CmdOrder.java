package by.it.kruglenja.Project.java.controller;

import by.it.kruglenja.Project.java.beans.Order;
import by.it.kruglenja.Project.java.beans.Spareparts;
import by.it.kruglenja.Project.java.beans.User;
import by.it.kruglenja.Project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CmdOrder implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws SQLException {
        if (!Util.checkUser(req)) {
            return Action.LOGIN;
        }
        Dao dao = Dao.getDao();
        long userId = (long) req.getSession().getAttribute("sesionUserId");
        String ordersById = String.format(" WHERE users_id='%d'", userId);
        List<Order> order = dao.order.getAll(ordersById);


//        double totalPrice = 0;
//        for (Order order1 : order) {
//            long spId = order1.getSpareParts_id();
//        }
//        for (Spareparts spareparts : partsByOrder) {
//            totalPrice += spareparts.getPrice();
//        }

        req.getSession().setAttribute("order", order);
//        req.getSession().setAttribute("partsByOrder", partsByOrder);
//        req.getSession().setAttribute("totalPrice", totalPrice);
        return Action.ORDER;
    }
}
