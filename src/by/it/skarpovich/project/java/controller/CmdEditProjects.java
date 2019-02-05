package by.it.skarpovich.project.java.controller;

import by.it.skarpovich.project.java.beans.Item;
import by.it.skarpovich.project.java.beans.Order;
import by.it.skarpovich.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

public class CmdEditProjects implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws SQLException, SiteException {
        if (Util.checkUser(req)) {
            Dao dao = Dao.getDao();
            if (Form.isPost(req)) {
                int id = Form.getInteger(req, "id");
                String title = Form.getString(req, "title");
                int floors = Form.getInteger(req, "floors");
                int square = Form.getInteger(req, "square");
                String materials = Form.getString(req, "materials");
                int price = Form.getInteger(req, "price");

                Item item = new Item(id, title, floors, square, materials, price);

                if (req.getParameter("Update") != null)
                    dao.item.update(item);
                else if (req.getParameter("Delete") != null)
                    dao.item.delete(item);
            }
            List<Item> items = dao.item.getAll();

            req.getSession().setAttribute("items", items);
        }
        return Action.EDITPROJECTS;
    }
}