package by.it.mnovikov.project.java.controller;

import by.it.mnovikov.project.java.beans.Good;
import by.it.mnovikov.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

class CmdEditGoods implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws SQLException, SiteException {
        if (Util.checkUser(req)) {

            Dao dao = Dao.getDao();

            if (Form.isPost(req)) {
                int id = Form.getInteger(req, "id");
                String title = Form.getString(req, "title");
                String discription = Form.getString(req, "discription");
                String type = Form.getString(req, "type");
                double productivity = Form.getDouble(req, "productivity");
                double price = Form.getDouble(req, "price");
                Good good = new Good(id, title, discription, type, productivity, price);
                if (req.getParameter("Update") != null)
                    dao.good.update(good);
                else if (req.getParameter("Delete") != null)
                    dao.good.delete(good);
            }

            List<Good> goods = dao.good.getAll();
            req.setAttribute("goods", goods);
        }
        return Action.EDITGOODS;
    }
}
