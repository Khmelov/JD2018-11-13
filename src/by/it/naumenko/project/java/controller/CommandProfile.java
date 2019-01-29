package by.it.naumenko.project.java.controller;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class CommandProfile extends Command {

    @Override
    Actions exequit(HttpServletRequest req) throws SQLException, SiteException {

//        HttpSession session = req.getSession(false);
//        if (session!=null){
//            Object oUser = session.getAttribute("user");
//            if (oUser!=null)
//                Users user = (Users) oUser;
//        }

        if(Form.isPost(req)) {
            if (Form.getString(req, "logout") != null) {
                req.getSession().invalidate();
                return Actions.LOGIN;
            }
        }
        return Actions.PROFILE;
    }
}
