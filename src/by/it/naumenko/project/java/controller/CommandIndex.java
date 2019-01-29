package by.it.naumenko.project.java.controller;

import javax.servlet.http.HttpServletRequest;

class CommandIndex extends Command {
    @Override
    Actions exequit(HttpServletRequest request) {

        return Actions.INDEX;
    }
}
