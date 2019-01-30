package by.it.kruglenja.Project.java.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class CmdLogout implements Cmd {
    @Override
    public Action execute(HttpServletRequest req)throws SQLException {
        HttpSession session = req.getSession(false);
        if (session != null) {
            session.invalidate();
            return Action.LOGOUT;
        }
        return null;
    }
}
