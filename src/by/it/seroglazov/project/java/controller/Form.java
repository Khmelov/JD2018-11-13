package by.it.seroglazov.project.java.controller;

import javax.servlet.http.HttpServletRequest;

class Form {


    static boolean isPost(HttpServletRequest req){
        return req.getMethod().equalsIgnoreCase("POST");
    }

    static String getString(HttpServletRequest req, String name, String pattern) throws SiteException {
        String result = req.getParameter(name);
        if (result.matches(pattern))
            return result;
        throw new SiteException("name="+result+" incorrect");
    }


    static String getString(HttpServletRequest req, String name) throws SiteException {
        return getString(req,name,".*");
    }

    static double getDouble(HttpServletRequest req, String name){
        String str = req.getParameter(name);
        return Double.parseDouble(str);
    }

    static double getInteger(HttpServletRequest req, String name){
        String str = req.getParameter(name);
        return Integer.parseInt(str);
    }



}
