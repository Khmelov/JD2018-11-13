package by.it.skarpovich.project.java.controller;


import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;


public class CmdLogOut implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws SQLException, SiteException {
        if (!Util.checkUser(req))
            return Action.LOGIN;

        if (Form.isPost(req)) {
            if (Form.getString(req, "logout") != null) {
                req.getSession().invalidate();

            }
        }
        return Action.LOGIN;
    }
}




