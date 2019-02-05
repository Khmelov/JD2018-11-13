package by.it.zhivov.project.java.controller;

import javax.servlet.http.HttpServletRequest;

class Form {

    static boolean isPost(HttpServletRequest req) {
        return req.getMethod().equalsIgnoreCase("POST");
    }

    static String getString(HttpServletRequest req, String name, String pattern) throws SiteExeption {
        String result = req.getParameter(name);
        if (result != null) {
            if (result.matches(pattern)) {
                return result;
            } else throw new SiteExeption("name=" + result + " incorrect");
        } else return null;


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

    static long getLong(HttpServletRequest req, String name) {
        String str = req.getParameter(name);
        return Long.parseLong(str);
    }


}
