package by.it.baidak.project.java.controller;

import by.it.baidak.project.java.DAO.DAO;
import by.it.baidak.project.java.beans.Post;
import by.it.baidak.project.java.beans.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdProfile extends Cmd {
    @Override
    Action execute(HttpServletRequest req) throws Exception {
        User user = Util.findUser(req);
        if (Form.isPost(req)){
            String login = Form.getString(req,"login");
            String password = Form.getString(req,"password","[a-zA-Z0-9_-]{4,}");
            String email = Form.getString(req,"email");
            User tmp = new User(user.getId(), login, password, email, 2);
            DAO dao = DAO.getDAO();
            if (dao.user.update(tmp)) {
                req.getSession().setAttribute("user", tmp);
                return Action.PROFILE;
            } else return Action.ERROR;
        }
        List<Post> posts = DAO.getDAO().post.get(String.format("WHERE users_id = %d", user.getId()));
        req.setAttribute("posts",posts);
        return null;
    }
}
