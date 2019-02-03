package by.it.skarpovich.project.java.controller;

import by.it.skarpovich.project.java.beans.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Util {

    static boolean checkUser(HttpServletRequest req) {
        return findUser(req) != null;
    }

    static User findUser(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        if (session != null) {
            Object objectUser = session.getAttribute("user");
            if (objectUser != null) {
                return (User) objectUser;
            }
        }
        return null;
    }

}
