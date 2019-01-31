package by.it.nickgrudnitsky.project.java.controller;

import by.it.nickgrudnitsky.project.java.beans.Streamer;
import by.it.nickgrudnitsky.project.java.beans.Viewer;
import by.it.nickgrudnitsky.project.java.dao.MyDao;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

class CmdSignup extends Cmd {
    @Override
    Action execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException, SiteException {
        if (Form.isPost(req)) {

            String username = Form.getString(req, "username", "[A-Za-z0-9А-Яа-я]+");
            String password = Form.getString(req, "password", "[A-Za-z0-9*$%#]+");
            String email = Form.getString(req, "email", "[A-Za-z0-9]+@[A-Za-z0-9]+.[A-Za-z0-9]+");
            String roleString = req.getParameter("role");
            long role = Long.parseLong(roleString);
            HttpSession session = req.getSession();
            session.setMaxInactiveInterval(60);
            if (role == 3) {
                Viewer viewer = new Viewer(email, password, username, role);
                MyDao myDao = MyDao.getDao();
                if (myDao.viewer.create(viewer)) {
                    session.setAttribute("user", viewer);
                    Cookie passwordCookie = new Cookie("password", password);
                    passwordCookie.setMaxAge(60);
                    resp.addCookie(passwordCookie);
                    return Action.PROFILE;
                }
            } else {
                Streamer streamer = new Streamer(email, password, username, role);
                MyDao myDao = MyDao.getDao();
                if (myDao.streamer.create(streamer)) {
                    session.setAttribute("user", streamer);
                    Cookie passwordCookie = new Cookie("password", password);
                    passwordCookie.setMaxAge(60);
                    resp.addCookie(passwordCookie);
                    return Action.PROFILE;
                }
            }
        }
        return Action.SIGNUP;
    }
}
