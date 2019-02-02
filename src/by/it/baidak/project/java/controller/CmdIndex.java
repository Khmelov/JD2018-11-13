package by.it.baidak.project.java.controller;

import by.it.baidak.project.java.DAO.DAO;
import by.it.baidak.project.java.beans.Post;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

class CmdIndex extends Cmd{
    @Override
    Action execute(HttpServletRequest req) throws SQLException {
        List<Post> posts = DAO.getDAO().post.get("");
        req.setAttribute("posts",posts);
        return null;
    }
}
