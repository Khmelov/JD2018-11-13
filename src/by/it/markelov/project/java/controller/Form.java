package by.it.markelov.project.java.controller;

import javax.servlet.http.HttpServletRequest;

public class Form {
    public static String getString(HttpServletRequest req, String name, String pattern) throws SiteException {
        String parameter = req.getParameter(name);
        if (parameter.matches(pattern))
            return parameter;
        else
            throw new SiteException("name = " + parameter + " invalid");
    }

    public static String getString(HttpServletRequest req, String name) throws SiteException {
        return getString(req, name, ".*");
    }

    public static double getDouble(HttpServletRequest req, String name) {
        String parameter = req.getParameter(name);
        return Double.parseDouble(parameter);
    }

    public static int getInteger(HttpServletRequest req, String name) {
        String parameter = req.getParameter(name);
        return Integer.parseInt(parameter);
    }
}
