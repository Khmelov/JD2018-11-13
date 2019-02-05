package by.it.baidak.project.java.controller;

import by.it.baidak.project.java.DAO.DAO;
import by.it.baidak.project.java.beans.User;

import javax.servlet.http.HttpServletRequest;

public class CmdRemoveUser extends Cmd {
    @Override
    Action execute(HttpServletRequest req) throws Exception {
        long id = Long.parseLong(req.getParameter("id"));
        User user = new User(id,"","","",0);
        DAO dao = DAO.getDAO();
        if(dao.user.delete(user)){
            return Action.INDEX;
        }
        return Action.ERROR;
    }
}
