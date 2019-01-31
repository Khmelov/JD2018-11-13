package by.it.naumenko.project.java.controller;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public class CommandProfile extends Command {

    @Override
    Actions exequit(HttpServletRequest req, HttpServletResponse response) throws SQLException, SiteException, LoginException, NoSuchAlgorithmException {
        if(Util.checkCookie(req))
            return Actions.PROFILE;

        if (!Util.checkUser(req))
            return Actions.LOGIN;

        if (Form.isPost(req)) {
            if (Form.getString(req, "logout") != null) {
                req.getSession().invalidate();
                return Actions.LOGIN;
            }
        }
        return Actions.PROFILE;
    }
}
