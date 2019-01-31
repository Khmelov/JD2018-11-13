package by.it.naumenko.project.java.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class CommandLogOut extends Command {
    @Override
    public Actions exequit(HttpServletRequest request, HttpServletResponse response) throws SiteException, SQLException {
        if (!Util.checkUser(request))
            return Actions.LOGIN;

        if (Form.isPost(request)) {
            if (Form.getString(request, "logout") != null) {
                request.getSession().invalidate();
                return Actions.LOGIN;
            }
        }
        return Actions.PROFILE;
    }
}
