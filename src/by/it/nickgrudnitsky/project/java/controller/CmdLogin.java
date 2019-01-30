package by.it.nickgrudnitsky.project.java.controller;


import by.it.nickgrudnitsky.project.java.beans.Viewer;
import by.it.nickgrudnitsky.project.java.dao.MyDao;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;

class CmdLogin extends Cmd {
    @Override
    Action execute(HttpServletRequest req, HttpServletResponse resp) throws SiteException, SQLException {
        if (Form.isPost(req)){
            String nickname = Form.getString(req, "username", "[A-Za-z0-9А-Яа-я]+");
            String password = Form.getString(req, "password", "[A-Za-z0-9*$%#=]+");
            Base64.Encoder encoder = Base64.getEncoder();
            byte[] encode = encoder.encode(password.getBytes());
            String hashPassword = new String(encode);
            String where = String.format(" WHERE password='%s' and nickname='%s' LIMIT 0,1", hashPassword, nickname);
            List<Viewer> viewers = MyDao.getDao().viewer.getAll(where);

            if (viewers.size()==1){
                Viewer viewer = viewers.get(0);
                Base64.Decoder decoder = Base64.getDecoder();
                byte[] decode = decoder.decode(viewer.getPassword());
                viewer.setPassword(new String(decode));
                HttpSession session = req.getSession(true);
                session.setAttribute("user", viewer);
                session.setAttribute("password", hashPassword);
                session.setAttribute("nickname", nickname);
                session.setMaxInactiveInterval(30);
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
