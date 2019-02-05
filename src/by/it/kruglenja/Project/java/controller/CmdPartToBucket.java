package by.it.kruglenja.Project.java.controller;

import by.it.kruglenja.Project.java.beans.Order;
import by.it.kruglenja.Project.java.beans.Spareparts;
import by.it.kruglenja.Project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdPartToBucket implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        if (Form.isPost(req)) {
            Dao dao = Dao.getDao();
            Long sparepartsId = Form.getLong(req, "iD");
            long id = (long) req.getSession().getAttribute("sesionUserId");
            List<Order> orderCheck = dao.order.getAll(String.format(" WHERE users_id='%d'", id) );
            for (Order order : orderCheck) {
                if (order.getSpareParts_id()==sparepartsId) {
                    String message = "Такой товар уже есть в корзине";
                    req.setAttribute("message", message);
                    return Action.INDEX;
                }
            }
            int quanity = Form.getInteger(req, "quanity");
            String name = Form.getString(req, "name");
            String model = Form.getString(req, "model");
            double price = Form.getDouble(req, "price");
            long userId = (long) req.getSession().getAttribute("sesionUserId");
            Order order = new Order(0, quanity, model, name, price, sparepartsId, userId);
            if (dao.order.create(order))
                return Action.INDEX;
        }
        return Action.ERROR;
    }
}

