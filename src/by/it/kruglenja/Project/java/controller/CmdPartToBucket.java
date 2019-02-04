package by.it.kruglenja.Project.java.controller;

import by.it.kruglenja.Project.java.beans.Order;
import by.it.kruglenja.Project.java.beans.Spareparts;
import by.it.kruglenja.Project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;

public class CmdPartToBucket implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        if (Form.isPost(req)) {
            int quanity = Form.getInteger(req, "quanity");
            String name = Form.getString(req, "name");
            String model = Form.getString(req, "model");
            double price = Form.getDouble(req, "price");
            long userId = (long) req.getSession().getAttribute("sesionUserId");
            Long sparepartsId = Form.getLong(req, "iD");
            Order order = new Order(0, quanity, model, name, price, sparepartsId, userId);
            Dao dao = Dao.getDao();
            if (dao.order.create(order))
                return Action.INDEX;
        }
        return Action.ERROR;
    }
}

