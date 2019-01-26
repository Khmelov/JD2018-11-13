package by.it.zhivov.project.java.controller;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

interface Cmd {
    Action execute(HttpServletRequest req) throws Exception;
}
