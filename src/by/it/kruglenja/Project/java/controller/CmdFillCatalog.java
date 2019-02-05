package by.it.kruglenja.Project.java.controller;

import by.it.kruglenja.Project.java.beans.Spareparts;
import by.it.kruglenja.Project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;

public class CmdFillCatalog implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
//        if (!Util.checkAdmin(req)){
//            return Action.LOGIN;
//        }
        if (Form.isPost(req)){
             String model = Form.getString(req, "selectModel");
             String category = Form.getString(req, "selectCategory");
             String name = Form.getString(req, "partName");
             String serial_number = Form.getString(req, "serialNumber");
             double weight = Form.getDouble(req, "weigth");
             double price = Form.getDouble(req, "price");
             int storageQuanity = Form.getInteger(req, "storageQuanity");

            Spareparts spareparts = new Spareparts(0, model,category, name, serial_number, weight, price, storageQuanity );
            Dao dao = Dao.getDao();
            if (dao.spareparts.create(spareparts))
                return Action.FILLCATALOG;
        }
        return Action.FILLCATALOG;
    }
}
