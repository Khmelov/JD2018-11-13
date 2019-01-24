package by.it.zhivov.project.controller;

import javax.servlet.http.HttpServletRequest;

public abstract class Cmd {
    abstract Action execute(HttpServletRequest req);
}
