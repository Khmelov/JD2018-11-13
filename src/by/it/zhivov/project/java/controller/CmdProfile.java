package by.it.zhivov.project.java.controller;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

class CmdProfile implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws SQLException, SiteExeption {
        //нужен логаут
        if (Form.isPost(req)) {
            if (Form.getString(req, "logout") != null) {
                req.getSession().invalidate();
                return Action.LOGIN;
            }
        }
        return Action.PROFILE;
    }
}
