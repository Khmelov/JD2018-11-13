package by.it.akhmelev.project08.java.controller;

import by.it.akhmelev.project08.java.beans.Ad;
import by.it.akhmelev.project08.java.beans.User;
import by.it.akhmelev.project08.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

class CmdCreateAd implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws SQLException, SiteException {
        if (!Util.checkUser(req))
            return Action.LOGIN;

        if (Form.isPost(req)) {
            //create ad etc
            String description = Form.getString(req, "description");
            String address = Form.getString(req, "address");
            int floor = Form.getInteger(req, "floor");
            int floors = Form.getInteger(req, "floors");
            int rooms = Form.getInteger(req, "rooms");
            double area = Form.getDouble(req, "area");
            double price = Form.getDouble(req, "price");
            User user = Util.findUser(req);
            Ad ad = new Ad(0, description, address, floor, floors, rooms, area, price, user.getId());
//            for (int i = 0; i < 30; i++) {
//                ad.setDescription(description+i);
                Dao.getDao().ad.create(ad);
                Util.saveFile(req, "ad" + ad.getId());
//            }
            return Action.PROFILE;
        }
        return Action.CREATEAD;
    }
}
