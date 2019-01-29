package by.it.lobkova.project.java.controller;

import javax.servlet.http.HttpServletRequest;

interface Cmd {

    Action execute(HttpServletRequest req) throws Exception;
}
