package by.it.kruglenja.Project.java.controller;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class CmdOrder  implements Cmd {
    @Override
    public Action execute(HttpServletRequest req)throws SQLException {
        return Action.ORDER;
    }
}
