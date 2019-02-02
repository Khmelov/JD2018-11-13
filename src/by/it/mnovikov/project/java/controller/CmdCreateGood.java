package by.it.mnovikov.project.java.controller;


import by.it.mnovikov.project.java.beans.Good;
import by.it.mnovikov.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

class CmdCreateGood implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws SQLException, SiteException {
        if (Form.isPost(req)){
            String title = Form.getString(req,"title");
            String discription = Form.getString(req, "discription");
            String type = Form.getString(req, "type");
            double productivity = Form.getDouble(req, "productivity");
            double price = Form.getDouble(req, "price");
            Good good = new Good(0, title, discription, type, productivity, price);
            Dao.getDao().good.create(good);
            return Action.INDEX;
        }
        return Action.CREATEGOOD;
    }
}
