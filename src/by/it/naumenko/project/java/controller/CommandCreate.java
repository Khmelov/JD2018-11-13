package by.it.naumenko.project.java.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class CommandCreate extends Command {
    @Override
    public Actions exequit(HttpServletRequest request, HttpServletResponse response)  {

        return Actions.CREATE;
    }
}
