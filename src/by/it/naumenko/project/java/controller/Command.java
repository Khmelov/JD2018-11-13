package by.it.naumenko.project.java.controller;

import javax.servlet.http.HttpServletRequest;

abstract class Command {

    abstract Actions exequit(HttpServletRequest req);

    @Override
    public String toString() {
        String simpleName = this.getClass().getSimpleName();
        String cmd = simpleName.replaceFirst("Command", "");
        return cmd.toLowerCase();
    }
}
