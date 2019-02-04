package by.it.zhivov.project.java.controller;

import by.it.zhivov.project.java.beans.Ad;
import by.it.zhivov.project.java.beans.User;
import by.it.zhivov.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

class CmdEditAds implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws SQLException, SiteExeption {
        if (Util.checkUser(req)) {
            Dao dao = Dao.getDao();
            if (Util.isAdmin(req))
                if (Form.isPost(req)) {
                    long id = Form.getLong(req, "id");
                    String title = Form.getString(req, "title");
                    String description = Form.getString(req, "description");
                    String brnd = Form.getString(req, "brnd");
                    String model = Form.getString(req, "model");
                    String color = Form.getString(req, "color");
                    String body = Form.getString(req, "body");
                    int year = Form.getInteger(req, "year");
                    double engine = Form.getDouble(req, "engine");
                    String at = Form.getString(req, "at");
                    String driveunit = Form.getString(req, "driveunit");
                    String equipment = Form.getString(req, "equipment");
                    int millage = Form.getInteger(req, "millage");
                    String crashed = Form.getString(req, "crashed");
                    double price = Form.getDouble(req, "price");
                    long id_User = Form.getLong(req, "id_User");
                    Ad ad = new Ad(id, title, description, brnd, model, color, body, year, engine, at, driveunit, equipment, millage, crashed, price, id_User);
                    if (req.getParameter("delete") != null) {
                        dao.ad.delete(ad);
                        Util.deleteFile(req, "ad" + ad.getId());
                    }
                }
            List<User> users = dao.user.getALL();
            req.setAttribute("users", users);
            List<Ad> ads = dao.ad.getALL();
            req.setAttribute("ads", ads);
        }
        return Action.EDITADS;
    }
}
