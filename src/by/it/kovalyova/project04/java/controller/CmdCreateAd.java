package by.it.kovalyova.project04.java.controller;

import by.it.kovalyova.project04.java.beans.Ad;
import by.it.kovalyova.project04.java.beans.Flat;
import by.it.kovalyova.project04.java.beans.User;
import by.it.kovalyova.project04.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;


public class CmdCreateAd implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws SQLException, SiteException {
       if (!Util.checkUser(req))
           return Action.LOGIN;
       
        if (Form.isPost(req)) {
            //create ad etc
            String description=Form.getString(req, "description");
            String address=Form.getString(req, "address");
            int floor = (int) Form.getInteger(req, "floor");
            int floors = (int) Form.getInteger(req, "floors");
            int rooms = (int) Form.getInteger(req, "rooms");
            float area= Form.getFloat(req, "area");
            String price= Form.getString(req, "price");
            User user = Util.findUser(req);

            Flat flat = new Flat(0,description,address,rooms,floor,floors,area);
            Dao.getDao().flat.create(flat);
            Ad ad=new Ad(0,price,flat.getId(),user.getId());
            Dao.getDao().ad.create(ad);
            return Action.PROFILE;

        }
        return Action.CREATEAD;
    }
}
