package by.it.nickgrudnitsky.project.java.controller;

import by.it.nickgrudnitsky.project.java.beans.Streamer;
import by.it.nickgrudnitsky.project.java.beans.Viewer;
import by.it.nickgrudnitsky.project.java.dao.MyDao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

class CmdSignup extends Cmd {
    @Override
    Action execute(HttpServletRequest req) throws SQLException, SiteException {
        if (Form.isPost(req)) {

            String username = Form.getString(req, "username", "[A-Za-z0-9]");
            String password = Form.getString(req, "password");
            String email = Form.getString(req, "email", "[A-Za-z0-9]+@[A-Za-z0-9]+.[A-Za-z0-9]+");
            String roleString = req.getParameter("role");
            long role = Long.parseLong(roleString);
            if (role == 3) {
                Viewer viewer = new Viewer(email, password, username, role);
                MyDao myDao = MyDao.getDao();
                if (myDao.viewer.create(viewer)) {
                    req.getSession().setAttribute("user", viewer);
                    return Action.PROFILE;
                }
            } else {
                Streamer streamer = new Streamer(email, password, username, role);
                MyDao myDao = MyDao.getDao();
                if (myDao.streamer.create(streamer)) {
                    req.getSession().setAttribute("user", streamer);
                    return Action.PROFILE;
                }
            }
        }
        return Action.SIGNUP;
    }
}
