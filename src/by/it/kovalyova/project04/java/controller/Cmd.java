package by.it.kovalyova.project04.java.controller;

import javax.servlet.http.HttpServletRequest;

abstract class Cmd {

    abstract Action execute(HttpServletRequest req);

}
