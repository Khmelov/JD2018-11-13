package by.it.zhivov.project.java.controller;

import javax.servlet.http.HttpServletRequest;

public class Form {
    static String getString(HttpServletRequest req, String name, String pattern) {
        String result = req.getParameter("name");
        if (result.matches(pattern))
            return result;
        throw SiteExeption("name=" + result + " incorrect");
    }

    static String getString(HttpServletRequest req, String name) throws SiteExeption {
        return getString(req, name, ".*");
    }

    static double getDouble(HttpServletRequest req, String name) {
        String str = req.getParameter(name);
        return Double.parseDouble(str);
    }

    static double getInteger(HttpServletRequest req, String name) {
        String str = req.getParameter(name);
        return Integer.parseInt(str);
    }

}
