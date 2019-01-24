package by.it.zhivov.jd03_03.controller;

import javax.servlet.http.HttpServletRequest;

public abstract class Cmd {
    abstract Action execute(HttpServletRequest req);
}
