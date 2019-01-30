package by.it.denisova.project.java.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

class CmdProfile implements Cmd {
    @Override
    public Action execute(HttpServletRequest req)  throws SQLException ,SiteException{
//        HttpSession session = req.getSession(false);
//        if(Form.isPost(req)) {
//            Object oUser = session.getAttribute("user");
//            if(Form.getString(req,"logout")!=null) {
//               req.getSession().invalidate();
//               return Action.LOGIN;
//            }
//        }
//        return Action.PROFILE;
        return null;
    }
}
