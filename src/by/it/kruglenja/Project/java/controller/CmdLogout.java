package by.it.kruglenja.Project.java.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class CmdLogout implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws SQLException, SiteExpression {
        if (Form.isPost(req)) {
            if (Form.getString(req, "logout") != null) {
                req.getSession().invalidate();
                return Action.LOGIN;
            }
        }
        return Action.PROFILE;
    }
}
