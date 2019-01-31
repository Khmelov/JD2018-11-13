package by.it.kruglenja.Project.java.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Form {

    static boolean isPost(HttpServletRequest req) {
        return req.getMethod().equalsIgnoreCase("post");
    }

    static String getString(HttpServletRequest req, String name, String pattern) throws SiteExpression {
        String result = req.getParameter(name);
        if (result.matches(pattern))
            return result;
        throw new SiteExpression("name " + result + " incorrect");
    }

    static String getString(HttpServletRequest req, String name) throws SiteExpression {
        return getString(req, name, ".*");
    }

    static double getDouble(HttpServletRequest req, String name) {
        String str = req.getParameter(name);
        return Double.parseDouble(str);
    }

    static int getInteger(HttpServletRequest req, String name) {
        String str = req.getParameter(name);
        return Integer.parseInt(str);
    }

}
