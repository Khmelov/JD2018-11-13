package by.it.kruglenja.Project.java.controller;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

interface Cmd {
    Action execute(HttpServletRequest req) throws SQLException;

}
