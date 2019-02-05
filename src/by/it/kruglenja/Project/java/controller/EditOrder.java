package by.it.kruglenja.Project.java.controller;

import by.it.kruglenja.Project.java.beans.Order;
import by.it.kruglenja.Project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class EditOrder implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        if (Util.checkUser(req)) {
            if (Form.isPost(req)) {
                Dao dao = Dao.getDao();
                if (req.getParameter("update") != null) {
                    Long orderId = Form.getLong(req, "update");
                    Order oldOrder = dao.order.read(orderId);
                    oldOrder.setQuanity(Form.getInteger(req, "quanity"));
                    dao.order.update(oldOrder);
                    return Action.ORDER;

                } else if (req.getParameter("delete") != null) {
                    Long orderId = Form.getLong(req, "delete");
                    Order order = dao.order.read(orderId);
                    dao.order.delete(order);
                    return Action.ORDER;
                }
            }
        }
        return Action.LOGIN;
    }
}
