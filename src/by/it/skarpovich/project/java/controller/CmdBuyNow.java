package by.it.skarpovich.project.java.controller;

import by.it.skarpovich.project.java.beans.Order;
import by.it.skarpovich.project.java.beans.User;
import by.it.skarpovich.project.java.dao.Dao;
import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

public class CmdBuyNow implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws SQLException, SiteException {
        if (Form.isPost(req)) {
            java.util.Date dt = new java.util.Date();
            java.text.SimpleDateFormat sdfDate =
                    new java.text.SimpleDateFormat("yyyy-MM-dd");
            java.text.SimpleDateFormat sdfTime =
                    new java.text.SimpleDateFormat("HH:mm:ss");

            String date = sdfDate.format(dt);
            String time = sdfTime.format(dt);

            User user =(User)req.getSession().getAttribute("user");
            int user_id=user.getId();
            System.out.println("user_id");
            //int item_id = 3;
            int item_id = Form.getInteger(req,"id");

            Order order = new Order(0, date, time, user_id, item_id);
            Dao dao = Dao.getDao();
            if (dao.order.create(order))
                req.getSession().setAttribute("order", order);
            return Action.ORDERS;    // Successful
        }
// If not successful
        return Action.INDEX;
    }
}
