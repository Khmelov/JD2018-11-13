package by.it.akhmelev.project05.java.controller;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

abstract class Cmd {

    abstract Action execute(HttpServletRequest req) throws SQLException;

    @Override
    public String toString() {
        String simpleName = this.getClass().getSimpleName();
        String cmd = simpleName.replaceFirst("Cmd", "");
        return cmd.toLowerCase();
    }
}
