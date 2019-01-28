package by.it.kovalyova.project.java.sample_controller;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

interface ActionCommand {
    String execute(HttpServletRequest request) throws SQLException;
}