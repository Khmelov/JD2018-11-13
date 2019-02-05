package by.it.baidak.project.java.controller;

import javax.servlet.http.HttpServletRequest;

class Form {

    static boolean isPost(HttpServletRequest req){
        return req.getMethod().equalsIgnoreCase("POST");
    }

    static String getString(HttpServletRequest req, String name, String pattern) throws SiteException {
        String result = req.getParameter(name);
        if (result.matches(pattern))
            return result;
        else throw new SiteException("name="+result+" incorrect");
    }


    static String getString(HttpServletRequest req, String name) throws SiteException {
        return getString(req,name,".*");
    }

    static double getLong(HttpServletRequest req, String name){
        String str = req.getParameter(name);
        long res = 0;
        try { res = Long.parseLong(str);
              return res;
        }catch (NumberFormatException  e){
            e.printStackTrace();
        }
        return 0;
    }
}
