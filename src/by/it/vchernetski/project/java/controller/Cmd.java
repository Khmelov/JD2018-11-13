package by.it.vchernetski.project.java.controller;

import javax.servlet.http.HttpServletRequest;

interface Cmd {
    Action execute(HttpServletRequest request) throws Exception;
}
