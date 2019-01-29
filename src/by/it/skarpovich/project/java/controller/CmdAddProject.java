package by.it.skarpovich.project.java.controller;

import by.it.skarpovich.project.java.beans.Item;
import by.it.skarpovich.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

class CmdAddProject implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws SQLException, SiteException {
        if (Form.isPost(req)) {
            String title = Form.getString(req,"title");
            int floors = Form.getInteger(req,"floors");
            int square = Form.getInteger(req,"square");
            String materials = Form.getString(req,"materials");
            int price = Form.getInteger(req,"price");

            Item item = new Item(0, title, floors, square, materials, price);
            Dao dao = Dao.getDao();
            if (dao.item.create(item))
                req.getSession().setAttribute("item",item);
            return Action.INDEX;    // Successful
        }
// If not successful
        return Action.ADDPROJECT;
    }
}
