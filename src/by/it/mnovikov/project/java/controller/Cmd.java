package by.it.mnovikov.project.java.controller;

import javax.servlet.http.HttpServletRequest;

interface Cmd {

    Action execute(HttpServletRequest req) throws Exception;

}
