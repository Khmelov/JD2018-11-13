package by.it.skarpovich.project.java.controller;

import by.it.skarpovich.project.java.beans.Order;
import by.it.skarpovich.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

public class CmdEditOrders implements Cmd {

    @Override
    public Action execute(HttpServletRequest req) throws SQLException, SiteException {
        if (Util.checkUser(req)) {
            //return Action.LOGIN;
            Dao dao = Dao.getDao();
            if (Form.isPost(req)) {
                int id = Form.getInteger(req, "id");
                String date = Form.getString(req, "date");
                String time = Form.getString(req, "time");
                int users_id = Form.getInteger(req, "users_id");
                int items_id = Form.getInteger(req, "items_id");

                Order order = new Order(id, date, time, users_id, items_id);

                if (req.getParameter("Update") != null)
                    dao.order.update(order);
                else if (req.getParameter("Delete") != null)
                    dao.order.delete(order);
            }
            List<Order> orders = dao.order.getAll();

            req.setAttribute("orders", orders);
        }
        return Action.EDITORDERS;
    }
}


