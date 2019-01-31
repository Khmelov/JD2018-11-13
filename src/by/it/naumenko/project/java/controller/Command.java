package by.it.naumenko.project.java.controller;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

abstract class Command {

    abstract Actions exequit(HttpServletRequest req, HttpServletResponse response) throws SQLException, SiteException, LoginException, NoSuchAlgorithmException;

    @Override
    public String toString() {
        String simpleName = this.getClass().getSimpleName();
        String cmd = simpleName.replaceFirst("Command", "");
        return cmd.toLowerCase();
    }

}
