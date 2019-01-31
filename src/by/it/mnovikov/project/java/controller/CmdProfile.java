package by.it.mnovikov.project.java.controller;

import by.it.mnovikov.project.java.beans.Order;
import by.it.mnovikov.project.java.dao.Dao;
import by.it.mnovikov.project.java.beans.User;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

class CmdProfile implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws SQLException, SiteException {
        if(!Util.checkUser(req))
            return Action.LOGIN;

        if (Form.isPost(req)) {
            if (Form.getString(req, "logout") != null) {
                req.getSession().invalidate();
                return Action.LOGIN;
            }
        }
        User user = Util.findUser(req);
        assert user != null;
        String where = String.format(" WHERE `users_ID`='%d'", user.getId());

        List<Order> orders = Dao.getDao().order.getAll(where);
        req.setAttribute("orders", orders);

        return Action.PROFILE;
    }
}
