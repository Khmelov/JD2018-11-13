package by.it.skarpovich.project.java.controller;

import by.it.skarpovich.project.java.beans.Order;
import by.it.skarpovich.project.java.dao.Dao;
import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.Date;

public class CmdBuyNow implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws SQLException, SiteException {
        if (Form.isPost(req)) {
            int id = Form.getInteger(req, "id");
            String date = new Date().toString();
            String time = new Date().toString();
            int user_id = Form.getInteger(req, "user_id");
            int item_id = Form.getInteger(req, "item_id");


            Order order = new Order(id, date, time, user_id, item_id);
            Dao dao = Dao.getDao();
            if (dao.order.create(order))
                req.getSession().setAttribute("order", order);
            return Action.PROFILE;    // Successful
        }
// If not successful
        return Action.INDEX;
    }
}
