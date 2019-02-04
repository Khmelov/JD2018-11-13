package by.it.kruglenja.Project.java.controller;

import by.it.kruglenja.Project.java.beans.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Util {
    static boolean checkUser(HttpServletRequest req){
        return findUser(req) != null;
    }

    static User findUser(HttpServletRequest req){
        HttpSession session = req.getSession(false);
        Object sessionUser = session.getAttribute("user");
        if (sessionUser != null){
            return (User) sessionUser;
            }
            return null;
    }

    static boolean checkAdmin(HttpServletRequest req){
        return checkUser(req)&&(findUser(req).getRoles_Id()==1);
    }
}
