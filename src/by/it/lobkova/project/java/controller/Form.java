package by.it.lobkova.project.java.controller;

import javax.servlet.http.HttpServletRequest;

public class Form {

    static String getStrint(HttpServletRequest req, String name, String pattern) throws SiteException {
        String result = req.getParameter(name);
        if (result.matches(pattern)) {
            return result;
        }
        throw new SiteException("Name = " + result + " incorrect");

    }

    static boolean isPost(HttpServletRequest req) {
        return req.getMethod().equalsIgnoreCase("POST");
    }

    static String getString(HttpServletRequest req, String name) throws SiteException {
       return getStrint(req, name, ".*");

    }

    static long getLong(HttpServletRequest req, String name){
        String str = req.getParameter(name);
        return Long.parseLong(str);
    }

    static int getInt(HttpServletRequest req, String name){
        String str = req.getParameter(name);
        return Integer.parseInt(str);
    }
}
