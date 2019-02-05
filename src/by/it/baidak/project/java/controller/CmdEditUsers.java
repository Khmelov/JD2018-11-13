package by.it.baidak.project.java.controller;

import by.it.baidak.project.java.DAO.DAO;
import by.it.baidak.project.java.beans.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdEditUsers extends Cmd {
    @Override
    Action execute(HttpServletRequest req) throws Exception {
        List<User> users = DAO.getDAO().user.get("");
        req.setAttribute("users",users);
        return null;
    }
}
