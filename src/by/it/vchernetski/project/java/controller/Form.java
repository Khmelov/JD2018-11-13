package by.it.vchernetski.project.java.controller;

import javax.servlet.http.HttpServletRequest;

public class Form {
    static boolean isPost(HttpServletRequest request){
        return request.getMethod().equalsIgnoreCase("post");
    }

    static String getString(HttpServletRequest request, String name, String pattern) throws Exception{
        String parameter = request.getParameter(name);
        if(parameter.matches(parameter))
            return parameter;
        throw new MyException("name="+parameter+" invalid");
    }
}
