package by.it.markelov.project.java.controller;

import javax.servlet.http.HttpServletRequest;

class CmdProfile extends Cmd{
    @Override
    Action execute(HttpServletRequest req) {

        return Action.PROFILE;
    }
}
