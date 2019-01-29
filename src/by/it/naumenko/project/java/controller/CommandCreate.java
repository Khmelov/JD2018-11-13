package by.it.naumenko.project.java.controller;

import javax.servlet.http.HttpServletRequest;

class CommandCreate extends Command {
    @Override
    public Actions exequit(HttpServletRequest request) {

        return Actions.CREATE;
    }
}
