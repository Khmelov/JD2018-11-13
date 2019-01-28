package by.it.naumenko.project.java.controller;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

abstract class Command {

    abstract Actions exequit(HttpServletRequest req) throws SQLException;

    @Override
    public String toString() {
        String simpleName = this.getClass().getSimpleName();
        String cmd = simpleName.replaceFirst("Command", "");
        return cmd.toLowerCase();
    }
}
