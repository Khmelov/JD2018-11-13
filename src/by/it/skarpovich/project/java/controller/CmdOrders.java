package by.it.skarpovich.project.java.controller;

import by.it.skarpovich.project.java.beans.Order;
import by.it.skarpovich.project.java.beans.User;
import by.it.skarpovich.project.java.dao.Dao;
import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

public class CmdOrders implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws SQLException {

        User currentUsername = (User) req.getSession().getAttribute("user");
        if (currentUsername != null) {
            List<Order> orders;
            //int currentUsername_Id=currentUsername.getId();
            if (currentUsername.getRoles_id() == 2) {
                String sqlSuffix = "WHERE users_id=" + currentUsername.getId();
                orders = Dao.getDao().order.getAll(sqlSuffix);
                req.setAttribute("orders", orders);
                return null;
            } else if (currentUsername.getRoles_id() == 1) {
                orders = Dao.getDao().order.getAll();
                req.setAttribute("orders", orders);
            }

        } else {
            return null;
        }
        return null;
    }
}


