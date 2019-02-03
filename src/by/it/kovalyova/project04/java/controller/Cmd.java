package by.it.kovalyova.project04.java.controller;

import javax.servlet.http.HttpServletRequest;



    interface Cmd {
        Action execute(HttpServletRequest req) throws Exception;
    }

