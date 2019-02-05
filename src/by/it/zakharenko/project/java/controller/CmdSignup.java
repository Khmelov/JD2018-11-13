package by.it.zakharenko.project.java.controller;

import by.it.zakharenko.project.java.beans.User;
import by.it.zakharenko.project.java.dao.Dao;
import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;


class CmdSignup implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws SQLException, SiteException {
        if (Form.isPost(req)) {
            String username = Form.getString(req,"username", "[a-zA-Zа-яёА-ЯЁ0-9_]{4,}");
            String password = Form.getString(req,"password", "[a-zA-Zа-яёА-ЯЁ0-9_]{4,}");
            String email = Form.getString(req,"email");
            String fullname = Form.getString(req,"fullname");
            String phone = Form.getString(req,"phone");
            String address = Form.getString(req,"address");
            User user = new User(0, username, password, email, fullname, phone, address, 2);
            Dao dao = Dao.getDao();
            if (dao.user.create(user))
                req.getSession().setAttribute("user",user);
                return Action.PROFILE;
        }

        return Action.SIGNUP;
    }
}
// pattern "[a-zA-Z0-9_-]{4,}");
