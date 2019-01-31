package by.it.nickgrudnitsky.project.java.controller;



import by.it.nickgrudnitsky.project.java.beans.Viewer;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Util {

    static boolean checkViewer(HttpServletRequest req, HttpServletResponse resp){
        return findViewer(req, resp)!=null;
    }

    private static Viewer findViewer(HttpServletRequest req, HttpServletResponse resp){
        HttpSession session = req.getSession(false);
        if (session!=null){
            Object oUser = session.getAttribute("user");
            if (oUser!=null) {
                Viewer viewer = (Viewer) oUser;
                String password = viewer.getPassword();
                Cookie passwordCookie = new Cookie("password", password);
                passwordCookie.setMaxAge(60);
                resp.addCookie(passwordCookie);
                return viewer;
            }
        }
        return null;
    }

}
