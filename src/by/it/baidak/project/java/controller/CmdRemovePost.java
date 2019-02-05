package by.it.baidak.project.java.controller;

import by.it.baidak.project.java.DAO.DAO;

import javax.servlet.http.HttpServletRequest;

public class CmdRemovePost extends Cmd {
    @Override
    Action execute(HttpServletRequest req) throws Exception {
        long id = Long.parseLong(req.getParameter("id"));
        DAO dao = DAO.getDAO();
        if(dao.post.deleteByID(id)){
            return Action.INDEX;
        }
        return Action.ERROR;
    }
}
