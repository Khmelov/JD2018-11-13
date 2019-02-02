package by.it.vchernetski.project.java.controller;

import javax.servlet.http.HttpServletRequest;

public class Form {
    static boolean isPost(HttpServletRequest request){
        return request.getMethod().equalsIgnoreCase("post");
    }

    static boolean checkInputData(String inData, String pattern){
        return inData.matches(pattern);
    }
}
