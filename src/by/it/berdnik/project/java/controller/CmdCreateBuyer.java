package by.it.berdnik.project.java.controller;

import by.it.berdnik.project.java.beans.Buyer;
import by.it.berdnik.project.java.beans.User;
import by.it.berdnik.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

class CmdCreateBuyer implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws SQLException, SiteException {
        if (!Util.checkUser(req))
            return Action.LOGIN;

        if (Form.isPost(req)) {
            String item = Form.getString(req, "item");
            String specif = Form.getString(req, "specif");
            double price = Form.getDouble(req, "price");
            String address = Form.getString(req, "address");
            User user = Util.findUser(req);
            Buyer buyer = new Buyer(0, item, specif, price, address, user.getId());
            Dao.getDao().buyer.create(buyer);
            return Action.PROFILE;
        }
        return Action.CREATEBUYER;
    }
}
