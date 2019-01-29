package by.it.kruglenja.Project.java.controller;

import by.it.kruglenja.Project.java.beans.User;
import by.it.kruglenja.Project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class CmdProfile implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws SQLException {
        if ( req.getMethod().equalsIgnoreCase("post")) {
            String phone_number = req.getParameter("pNumber");
            Dao dao = Dao.getDao();
            User user = new User();
            if (dao.user.update(user)) {
                req.getSession().setAttribute("user", user);
                user.setPhone_number(phone_number);
            }
        }
        return Action.PROFILE; }
}
