package by.it.akhmelev.project05.java.controller;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

class CmdError implements Cmd {
    @Override
    public Action execute(HttpServletRequest req)  throws SQLException {
        return null;
    }
}
