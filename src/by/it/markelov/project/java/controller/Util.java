package by.it.markelov.project.java.controller;

import by.it.markelov.project.java.beans.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Util {
    static User findUser(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        if (session != null) {
            Object objUser = session.getAttribute("user");
            if (objUser != null) {
                User user = (User) objUser;
                return user;
            }
        }
        return null;
    }

    static boolean checkUser (HttpServletRequest req) {
        return findUser(req)!=null;
    }
}
