package by.it.nickgrudnitsky.project.java.controller;

import javax.servlet.http.HttpServletRequest;

public class Form {
    static String getString (HttpServletRequest req, String name, String patter) throws SiteException {
        String result = req.getParameter(name);
        if (result.matches(patter)){
            return result;
        }
        throw new SiteException("name = " + result + "is invalid.");
    }

    static String getString (HttpServletRequest req, String name) throws SiteException {
        return getString(req, name, ".*");
    }

    static boolean isPost(HttpServletRequest req){
        return req.getMethod().equalsIgnoreCase("POST");
    }
}
