package by.it.nickgrudnitsky.project.java.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Session {

    private static HttpSession session;

    public static HttpSession getSession (HttpServletRequest req){
        if (session == null ) {
            session = req.getSession();
        }
        return session;
    }
}
