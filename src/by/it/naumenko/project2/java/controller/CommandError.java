package by.it.naumenko.project2.java.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class CommandError extends Command {
    @Override
    public Actions exequit(HttpServletRequest request, HttpServletResponse response) {

        return Actions.ERROR;
    }
}
