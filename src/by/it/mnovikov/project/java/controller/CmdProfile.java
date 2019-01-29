package by.it.mnovikov.project.java.controller;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

class CmdProfile implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws SQLException {
        return Action.PROFILE;
    }
}
