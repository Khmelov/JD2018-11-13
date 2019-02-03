package by.it.nickgrudnitsky.project.java.controller;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


class CmdLogout extends Cmd {
    @Override
    Action execute(HttpServletRequest req, HttpServletResponse resp) {
        req.getSession().invalidate();
        Cookie passwordCookie = new Cookie("password", "");
        Cookie nicknameCookie = new Cookie("nickname", "");
        nicknameCookie.setMaxAge(0);
        passwordCookie.setMaxAge(0);
        resp.addCookie(passwordCookie);
        resp.addCookie(nicknameCookie);
        return Action.LOGIN;
    }
}
