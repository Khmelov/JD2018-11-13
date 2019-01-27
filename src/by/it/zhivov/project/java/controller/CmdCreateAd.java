package by.it.zhivov.project.java.controller;

import by.it.zhivov.project.java.beans.Ad;
import by.it.zhivov.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class CmdCreateAd implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws SQLException, SiteExeption {
        if (Form.isPost(req)) {
            String title = Form.getString(req, "title");
            String description=Form.getString(req,"description");
            String brnd=Form.getString(req,"brnd");
            String model=Form.getString(req,"model");
            String color=Form.getString(req,"color");
            String body=Form.getString(req,"body");
            int year=Form.getInteger(req,"year");
            double engine=Form.getDouble(req,"engine");
            int at=Form.getInteger(req,"at");
            String driveunit=Form.getString(req,"driveunit");
            String equipment=Form.getString(req,"equipment");
            int millage=Form.getInteger(req,"millage");
            int crashed=Form.getInteger(req,"crashed");
            double price=Form.getDouble(req,"price");
            Ad ad =new Ad(0,title,description,brnd,model,color,body,year,engine,at,driveunit,equipment,millage,crashed,price,3);
            Dao dao = Dao.getDao();
            if (dao.ad.create(ad))
                req.getSession().setAttribute("ad",ad);
            return Action.INDEX;
        }
        return Action.CREATEAD;
    }
}
