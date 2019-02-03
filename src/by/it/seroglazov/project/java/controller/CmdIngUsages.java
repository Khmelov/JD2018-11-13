package by.it.seroglazov.project.java.controller;

import javax.servlet.http.HttpServletRequest;

class CmdIngUsages extends Cmd {
    @Override
    Action execute(HttpServletRequest req) {
        return Action.INGUSAGES;
    }
}
