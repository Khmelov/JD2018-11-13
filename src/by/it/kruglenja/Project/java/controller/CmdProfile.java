package by.it.kruglenja.Project.java.controller;

import by.it.kruglenja.Project.java.beans.User;
import by.it.kruglenja.Project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class CmdProfile implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws SQLException {
        if (!Util.checkUser(req)){
            return Action.LOGIN;
        }
        if (Form.isPost(req)) {
           return Action.EDITUSERS;

        }
        return Action.PROFILE; }
}
