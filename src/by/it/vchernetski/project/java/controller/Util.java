package by.it.vchernetski.project.java.controller;

import by.it.vchernetski.project.java.beans.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Util {
    static User findUser(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if (session != null) {
            Object user = session.getAttribute("user");
            if (user != null) {
                return (User) user;
            }
        }
        return null;
    }
    static boolean checkUser(HttpServletRequest request){
        return findUser(request)!=null;
    }
}
