package by.it.mnovikov.project.java.controller;

import by.it.mnovikov.project.java.beans.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by user on 29.01.2019.
 */
public class Util {
    static User findUser (HttpServletRequest req){
        HttpSession session = req.getSession(false);
        if (session!=null){
            Object oUser = session.getAttribute("user");
            if (oUser!=null){
                return (User) oUser;
            }
        }
        return null;
    }
//
//    static boolean checkUser (HttpServletRequest req){
//        return findUser(null);
//    }
}
