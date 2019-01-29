package by.it.skarpovich.project.java.controller;

import javax.servlet.http.HttpServletRequest;

interface Cmd {
    Action execute(HttpServletRequest req) throws Exception;
}
