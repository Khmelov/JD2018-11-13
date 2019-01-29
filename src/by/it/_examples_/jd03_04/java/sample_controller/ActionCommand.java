package by.it._examples_.jd03_04.java.sample_controller;

import javax.servlet.http.HttpServletRequest;
public interface ActionCommand {
    String execute(HttpServletRequest request);
}