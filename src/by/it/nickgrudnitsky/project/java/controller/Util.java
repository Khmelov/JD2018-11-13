package by.it.nickgrudnitsky.project.java.controller;


import by.it.nickgrudnitsky.project.java.beans.Streamer;
import by.it.nickgrudnitsky.project.java.beans.Viewer;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class Util {

    static boolean checkViewer(HttpServletRequest req) {
        return findViewer(req) != null;
    }

    private static Viewer findViewer(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        if (session != null) {
            Object oUser = session.getAttribute("user");
            if (oUser != null) {
                return (Viewer) oUser;
            }
        }
        return null;
    }

    static boolean checkStreamer(HttpServletRequest req) {
        return findStreamer(req) != null;
    }

    private static Streamer findStreamer(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        if (session != null) {
            Object oUser = session.getAttribute("user");
            if (oUser != null) {
                return (Streamer) oUser;
            }
        }
        return null;
    }


    static String enCode(String value) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] digest = md5.digest(value.getBytes());
            StringBuilder builder = new StringBuilder();
            for (byte b : digest) {
                builder.append(String.format("%02X", b));
            }
            return builder.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return value;
    }

}
