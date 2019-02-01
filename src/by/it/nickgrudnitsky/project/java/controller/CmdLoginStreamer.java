package by.it.nickgrudnitsky.project.java.controller;


import by.it.nickgrudnitsky.project.java.beans.Streamer;
import by.it.nickgrudnitsky.project.java.dao.MyDao;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

class CmdLoginStreamer extends Cmd {
    @Override
    Action execute(HttpServletRequest req, HttpServletResponse resp) throws SiteException, SQLException {
        if (Util.checkStreamer(req)){
            return Action.PROFILESTREAMER;
        }
        if (Form.isPost(req)){
            String nickname = Form.getString(req, "username", "[A-Za-z0-9А-Яа-я]+");
            String password = Form.getString(req, "password", "[A-Za-z0-9*$%#=]+");
            String hashPassword = Util.enCode(password);
            String where = String.format(" WHERE password='%s' and channelname='%s' LIMIT 0,1", hashPassword, nickname);
            List<Streamer> streamers = MyDao.getDao().streamer.getAll(where);
            if (streamers.size()==1){
                Streamer streamer = streamers.get(0);
                HttpSession session = req.getSession(true);
                session.setAttribute("user", streamer);
                session.setAttribute("password", hashPassword);
                session.setAttribute("nickname", nickname);
                session.setMaxInactiveInterval(5);
                Cookie passwordCookie = new Cookie("password", hashPassword);
                Cookie nicknameCookie = new Cookie("nickname", nickname);
                nicknameCookie.setMaxAge(60);
                passwordCookie.setMaxAge(60);
                resp.addCookie(passwordCookie);
                resp.addCookie(nicknameCookie);
                return Action.PROFILESTREAMER;
            }
        }
        return Action.LOGINSTREAMER;
    }
}
