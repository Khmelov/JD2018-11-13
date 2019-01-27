package by.it.vchernetski.project.java.controller;

import javax.servlet.http.HttpServletRequest;

abstract class Cmd {
    abstract Action execute(HttpServletRequest request) throws Exception;

    @Override
    public String toString() {
        String simpleName = this.getClass().getSimpleName();
        return simpleName.replaceFirst("Cmd","").toLowerCase();
    }
}
