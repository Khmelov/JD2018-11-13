package by.it.nickgrudnitsky.project.java.controller;


import by.it.nickgrudnitsky.project.java.beans.Viewer;
import by.it.nickgrudnitsky.project.java.dao.MyDao;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

class CmdLogin extends Cmd {
    @Override
    Action execute(HttpServletRequest req, HttpServletResponse resp) throws SiteException, SQLException {
        if (Util.checkViewer(req)){
            return Action.PROFILE;
        }
        if (Form.isPost(req)){
            String nickname = Form.getString(req, "username", "[A-Za-z0-9А-Яа-я]+");
            String password = Form.getString(req, "password", "[A-Za-z0-9*$%#=]+");
            String hashPassword = Util.enCode(password);
            String where = String.format(" WHERE password='%s' and nickname='%s' LIMIT 0,1", hashPassword, nickname);
            List<Viewer> viewers = MyDao.getDao().viewer.getAll(where);
            if (viewers.size()==1){
                Viewer viewer = viewers.get(0);
                HttpSession session = req.getSession(true);
                session.setAttribute("user", viewer);
                session.setAttribute("password", hashPassword);
                session.setAttribute("nickname", nickname);
                session.setMaxInactiveInterval(5);
                Cookie passwordCookie = new Cookie("password", hashPassword);
                Cookie nicknameCookie = new Cookie("nickname", nickname);
                nicknameCookie.setMaxAge(60);
                passwordCookie.setMaxAge(60);
                resp.addCookie(passwordCookie);
                resp.addCookie(nicknameCookie);
                return Action.PROFILE;
            }
        }
        return Action.LOGIN;
    }
}
