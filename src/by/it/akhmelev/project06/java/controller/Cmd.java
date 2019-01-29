package by.it.akhmelev.project06.java.controller;

import javax.servlet.http.HttpServletRequest;

interface Cmd {
    Action execute(HttpServletRequest req) throws Exception;
}
