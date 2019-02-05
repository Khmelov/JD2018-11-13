package by.it.denisova.project.java.controller;

import by.it.denisova.project.java.beans.Test;
import by.it.denisova.project.java.beans.User;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Util {

    static boolean checkUser(HttpServletRequest req) {
        return findUser(req) != null;
    }

    static User findUser(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        if(session != null) {
            Object oUser = session.getAttribute("user");
            if(oUser != null) {
                return (User) oUser;
            }
        }
        return null;
    }

    static Test findTest(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        if(session !=null) {
            Object oTest = session.getAttribute("test");
            if(oTest != null) {
                return (Test) oTest;
            }
        }
        return null;
    }
}
