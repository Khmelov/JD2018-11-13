package by.it.kruglenja.Project.java.controller;

import by.it.kruglenja.Project.java.beans.Order;
import by.it.kruglenja.Project.java.beans.Spareparts;
import by.it.kruglenja.Project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;

public class CmdPartToBucket implements Cmd{
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        if (Form.isPost(req)){
            Long userId = Util.findUser(req).getId();
            int quanity = Form.getInteger(req, "quanity");
            Long sparepartsId = Form.getLong(req, "iD");


            Order order = new Order(0, quanity,"", 0.00, sparepartsId, userId );
            Dao dao = Dao.getDao();
            if (dao.order.create(order))
                return Action.INDEX;
        }
        return Action.ERROR;
    }
}
