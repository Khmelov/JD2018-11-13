package by.it.zhivov.project.java.controller;

import by.it.zhivov.project.java.beans.Ad;
import by.it.zhivov.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class CmdCreateAd implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws SQLException, SiteExeption {
        if (!Util.checkUser(req))
            return Action.LOGIN;

        if (Form.isPost(req)) {
            String title = Form.getString(req, "title", "[a-zа-яA-Z-А-Я][a-zа-яA-ZА-Я0-9\\-! ]{7,49}");
            String description = Form.getString(req, "description", "[a-zа-яA-Z-А-Я0-9.,!\\- ]{7,2000}");
            String brnd = Form.getString(req, "brnd", "[a-zA-Zа-яА-Я0-9 ]{1,45}");
            String model = Form.getString(req, "model", "[a-zA-Zа-яА-Я0-9 ]{1,45}");
            String color = Form.getString(req, "color", "[a-zA-Zа-яА-Я- ]{1,45}");
            String body = Form.getString(req, "body", "[a-zA-Zа-яА-Я]{1,45}");
            int year = Form.getInteger(req, "year");
            double engine = Form.getDouble(req, "engine");
            int at = Form.getInteger(req, "at");
            String driveunit = Form.getString(req, "driveunit", "[a-zA-Zа-яА-Я0-9]{1,15}");
            String equipment = Form.getString(req, "equipment", "[a-zA-Zа-яА-Я]{1,45}");
            int millage = Form.getInteger(req, "millage");
            int crashed = Form.getInteger(req, "crashed");
            double price = Form.getDouble(req, "price");
            Ad ad = new Ad(0, title, description, brnd, model, color, body, year, engine, at, driveunit, equipment, millage, crashed, price, 1);
            Dao dao = Dao.getDao();
            if (dao.ad.create(ad))
                req.getSession().setAttribute("ad", ad);
            return Action.PROFILE;
        }
        return Action.CREATEAD;
    }
}
