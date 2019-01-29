package by.it.kruglenja.Project.java.controller;

import javax.servlet.http.HttpServletRequest;

abstract class Cmd {
    abstract Action execute(HttpServletRequest req);

}
