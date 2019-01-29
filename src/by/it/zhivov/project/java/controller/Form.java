package by.it.zhivov.project.java.controller;

import javax.servlet.http.HttpServletRequest;

class Form {

    static boolean isPost(HttpServletRequest req) {
        return req.getMethod().equalsIgnoreCase("POST");
    }

    static String getString(HttpServletRequest req, String name, String pattern) throws SiteExeption {
        String result = req.getParameter(name);
        if (result.matches(pattern))
            return result;
        throw new SiteExeption("name=" + result + " incorrect");
    }

    static String getString(HttpServletRequest req, String name) throws SiteExeption {
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
