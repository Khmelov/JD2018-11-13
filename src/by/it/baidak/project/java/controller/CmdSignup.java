package by.it.baidak.project.java.controller;


import by.it.baidak.project.java.DAO.DAO;
import by.it.baidak.project.java.beans.User;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

class CmdSignup extends Cmd{
    @Override
    Action execute(HttpServletRequest req) throws SQLException, SiteException {
        if (Form.isPost(req)) {
            String login = Form.getString(req,"login");
            String password = Form.getString(req,"password","[a-zA-Z0-9_-]{4,}");
            String email = Form.getString(req,"email");
            User user = new User(0, login, password, email, 2);
            DAO dao = DAO.getDAO();
            if (dao.user.create(user))
                req.getSession().setAttribute("user",user);
                return Action.INDEX;
            }
        else return Action.SIGNUP;
    }
}
