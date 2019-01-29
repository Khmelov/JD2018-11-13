package by.it.markelov.project.java.controller;

import by.it.markelov.project.java.beans.Order;
import by.it.markelov.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

class CmdIndex extends Cmd{
    @Override
    Action execute(HttpServletRequest req) throws SQLException {
        List<Order> orders = DAO.getInstance().order.getAll("");
        req.setAttribute("orders", orders);



        return null;
    }
}
