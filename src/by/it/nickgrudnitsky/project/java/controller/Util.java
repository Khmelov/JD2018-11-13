package by.it.nickgrudnitsky.project.java.controller;



import by.it.nickgrudnitsky.project.java.beans.Streamer;
import by.it.nickgrudnitsky.project.java.beans.Viewer;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Base64;

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

    static boolean checkStreamer(HttpServletRequest req, HttpServletResponse resp){
        return findStreamer(req, resp)!=null;
    }

    private static Streamer findStreamer(HttpServletRequest req, HttpServletResponse resp){
        HttpSession session = req.getSession(false);
        if (session!=null){
            Object oUser = session.getAttribute("user");
            if (oUser!=null) {

                Streamer streamer = (Streamer) oUser;
                String password = streamer.getPassword();
                Cookie passwordCookie = new Cookie("password", password);
                passwordCookie.setMaxAge(60);
                resp.addCookie(passwordCookie);
                return streamer;
            }
        }
        return null;
    }


    static String enCode(String value){
        Base64.Encoder encoder = Base64.getEncoder();
        byte[] encode = encoder.encode(value.getBytes());
        return new String(encode);
    }

    static String deCode(String value){
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] decode = decoder.decode(value.getBytes());
        return new String(decode);
    }

}
