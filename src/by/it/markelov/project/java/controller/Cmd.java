package by.it.markelov.project.java.controller;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

abstract class Cmd {

    abstract Action execute(HttpServletRequest req) throws SQLException, SiteException;

    @Override
    public String toString() {
        String simpleName = this.getClass().getSimpleName();
        String cmd = simpleName.replaceFirst("Cmd", "");
        return cmd.toLowerCase();
    }
}
