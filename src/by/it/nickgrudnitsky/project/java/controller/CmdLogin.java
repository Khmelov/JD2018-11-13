package by.it.nickgrudnitsky.project.java.controller;

import by.it.nickgrudnitsky.project.java.beans.Viewer;
import by.it.nickgrudnitsky.project.java.dao.MyDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

class CmdLogin extends Cmd {
    @Override
    Action execute(HttpServletRequest req) throws SiteException, SQLException {
        if (Form.isPost(req)){
            String nickname = Form.getString(req, "username");
            String password = Form.getString(req, "password");
            String where = String.format(" WHERE password='%s' and nickname='%s' LIMIT 0,1", password, nickname);
            List<Viewer> viewers = MyDao.getDao().viewer.getAll(where);
            if (viewers.size()==1){
                Viewer viewer = viewers.get(0);
                HttpSession session = req.getSession(true);
                session.setAttribute("user", viewer);
                return Action.PROFILE;
            }
        }
        return Action.LOGIN;
    }
}
