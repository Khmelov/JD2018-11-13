package by.it.kovalyova.project.java.sample_controller;

import by.it._examples_.jd03_04.java.sample_controller.ActionCommand;
import by.it._examples_.jd03_04.java.sample_controller.Actions;

import javax.servlet.http.HttpServletRequest;

class CommandError implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        return by.it._examples_.jd03_04.java.sample_controller.Actions.ERROR.jsp;
    }
}