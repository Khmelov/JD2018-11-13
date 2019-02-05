package by.it.baidak.project.java.controller;

import by.it.baidak.project.java.DAO.DAO;
import by.it.baidak.project.java.beans.Post;
import by.it.baidak.project.java.beans.User;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

public class CmdNewpost extends Cmd {
    @Override
    Action execute(HttpServletRequest req) throws Exception {

        if (!Util.checkUser(req)) {
            return Action.LOGIN;
        }
        if (Form.isPost(req)) {
            String head = Form.getString(req, "head");
            String date = new Date().toString();
            User user = Util.findUser(req);
            Post post = new Post(0,user.getId(),head,date);
            DAO dao = DAO.getDAO();
            if (dao.post.create(post)) {
                return Action.INDEX;
            }
        }
        return Action.NEWPOST;
    }
}
