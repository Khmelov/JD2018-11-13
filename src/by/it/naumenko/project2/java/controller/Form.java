package by.it.naumenko.project2.java.controller;

import javax.servlet.http.HttpServletRequest;

public class Form {

    static boolean isPost(HttpServletRequest request){
        return request.getMethod().equalsIgnoreCase("POST");
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

    static long getLong(HttpServletRequest req, String name){
        String str = req.getParameter(name);
        return Long.parseLong(str);
    }

    static int getInteger(HttpServletRequest req, String name){
        String str = req.getParameter(name);
        return Integer.parseInt(str);
    }
}
