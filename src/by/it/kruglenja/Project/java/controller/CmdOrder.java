package by.it.kruglenja.Project.java.controller;

import by.it.kruglenja.Project.java.beans.Order;
import by.it.kruglenja.Project.java.beans.Spareparts;
import by.it.kruglenja.Project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CmdOrder implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws SQLException {
        if (Util.findUser(req) != null) {
            Dao dao = Dao.getDao();
            String ordersById = String.format(" WHERE users_id='%d'", Util.findUser(req).getId());
            List<Order> order = dao.order.getAll(ordersById);
            List<Spareparts> partsByOrder = new ArrayList<>();

            String deliveryTime;
            String deliv = order.get(0).getDeliveryTime();
            if (deliv != null) {
                deliveryTime = deliv;
            }else deliveryTime = "Не указано";

            double totalPrice = 0;

            for (Order order1 : order) {
                long spId = order1.getSparePart_id();
                partsByOrder.add(dao.spareparts.read(spId));
            }
            for (Spareparts spareparts : partsByOrder) {
                totalPrice += spareparts.getPrice();
            }

            req.getSession().setAttribute("order", order);
            req.getSession().setAttribute("partsByOrder", partsByOrder);
            req.getSession().setAttribute("deliveryTime", deliveryTime);
            req.getSession().setAttribute("totalPrice", totalPrice);
            return Action.ORDER;
        }
        return Action.LOGIN;
    }
}
