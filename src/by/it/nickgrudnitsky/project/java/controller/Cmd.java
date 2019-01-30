package by.it.nickgrudnitsky.project.java.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

abstract class Cmd {

    abstract Action execute(HttpServletRequest req, HttpServletResponse resp) throws Exception;

}
