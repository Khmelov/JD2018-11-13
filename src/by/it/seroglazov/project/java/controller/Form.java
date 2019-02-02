package by.it.seroglazov.project.java.controller;

import javax.servlet.http.HttpServletRequest;

class Form {


    static boolean isPost(HttpServletRequest req){
        return req.getMethod().equalsIgnoreCase("POST");
    }

    static String getParameterMatchesPattern(HttpServletRequest req, String parameter, String pattern) throws SiteException {
        String result = req.getParameter(parameter);
        if (result.matches(pattern))
            return result;
        throw new SiteException("parameter="+result+" incorrect");
    }


    /*static String getParameterMatchesPattern(HttpServletRequest req, String name) throws SiteException {
        return getParameterMatchesPattern(req,name,".*");
    }*/

    static double getDouble(HttpServletRequest req, String name){
        String str = req.getParameter(name);
        return Double.parseDouble(str);
    }

    static long getLong(HttpServletRequest req, String name){
        String str = req.getParameter(name);
        return Long.parseLong(str);
    }



}
