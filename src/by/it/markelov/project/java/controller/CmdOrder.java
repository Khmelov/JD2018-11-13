package by.it.markelov.project.java.controller;

import by.it.markelov.project.java.beans.Order;
import by.it.markelov.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

class CmdOrder extends Cmd {
    @Override
    Action execute(HttpServletRequest req) throws SQLException, SiteException {
        if (req.getMethod().equalsIgnoreCase("POST")) {
            String shoeName = Form.getString(req, "Shoe_name");
            int shoeSize = Form.getInteger(req, "Shoe_size");
            String shoeColour = Form.getString(req, "Shoe_colour");
            double price = Form.getDouble(req, "Price");
            int usersID = Form.getInteger(req, "users_ID");


            Order order = new Order(0, shoeName, shoeSize, shoeColour, price, usersID);
            DAO dao = DAO.getInstance();
            dao.order.create(order);

            req.getSession().setAttribute("order", order);
            return Action.ORDER;
        }
        //return Action.ERROR;
        return null;
    }
}
