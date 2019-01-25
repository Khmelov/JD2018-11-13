package by.it.kovalyova.project.java.sample_controller;

import by.it._examples_.jd03_04.java.sample_controller.ActionCommand;
import by.it._examples_.jd03_04.java.sample_controller.Actions;

import javax.servlet.http.HttpServletRequest;

class CommandLogin implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        //DO SOMETHING;
        //USE DAO
        //&ETC
        return by.it._examples_.jd03_04.java.sample_controller.Actions.LOGIN.jsp;
    }
}