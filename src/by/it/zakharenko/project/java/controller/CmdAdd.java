package by.it.zakharenko.project.java.controller;

import by.it.zakharenko.project.java.beans.Item;
import by.it.zakharenko.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

class CmdAdd implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws SQLException, SiteException {
        if (Form.isPost(req)) {
            String title = Form.getString(req,"title");
            int price = Form.getInteger(req,"price");

            Item item = new Item(0, title, price);
            Dao dao = Dao.getDao();
            if (dao.item.create(item))
                req.getSession().setAttribute("item",item);
            return Action.INDEX;    // Successful
        }
// If not successful
        return Action.ADDPROJECT;
    }
}
