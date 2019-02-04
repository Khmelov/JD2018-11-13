package by.it.zhivov.project.java.controller;

import by.it.zhivov.project.java.beans.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Util {
    static boolean checkUser(HttpServletRequest req) {
        return findUser(req) != null;
    }

    static User findUser(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        if (session != null) {
            Object objUser = session.getAttribute("user");
            if (objUser != null) {
                return (User) objUser;
            }
        }
        return null;
    }

    static boolean isAdmin(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        User user = Util.findUser(req);
        if (user != null) {
            return user.getRoles_Id() == 1;
        }
        return false;
    }


}
