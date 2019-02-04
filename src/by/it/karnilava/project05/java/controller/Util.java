package by.it.karnilava.project05.java.controller;

import by.it.karnilava.project05.java.beans.Client;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Util {

    static boolean checkClient(HttpServletRequest req) {
        return findClient(req) != null;
    }

    static Client findClient(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        if (session != null) {
            if (session.getAttribute("admin") != null) {
                Object oAdmin = session.getAttribute("admin");
                return (Client) oAdmin;
            }
            Object oClient = session.getAttribute("client");
            if (oClient != null) {
                return (Client) oClient;
            }
        }
        return null;
    }
}
