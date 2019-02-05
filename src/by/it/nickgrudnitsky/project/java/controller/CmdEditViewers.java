package by.it.nickgrudnitsky.project.java.controller;


import by.it.nickgrudnitsky.project.java.beans.Viewer;
import by.it.nickgrudnitsky.project.java.dao.MyDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

class CmdEditViewers extends Cmd {
    @Override
    Action execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException, SiteException {
        if (Util.checkViewer(req)) {
            MyDao dao = MyDao.getDao();
            if (Form.isPost(req)) {
                long id = Form.getLong(req, "id");
                Viewer read = dao.viewer.read(id);
                String password = read.getPassword();
                String nickname = Form.getString(req, "nickname");
                String email = Form.getString(req, "email");
                long role = Form.getLong(req, "role");
                Viewer viewer = new Viewer(email, password, nickname, role);
                viewer.setId(id);
                if (req.getParameter("Update") != null) {
                    dao.viewer.update(viewer);
                }
                if (req.getParameter("Delete") != null) {
                    MyDao.getDao().viewer.delete(viewer);
                }
            }
            List<Viewer> viewers = dao.viewer.getAll();
            req.setAttribute("viewers", viewers);
        }
        return Action.EDITVIEWERS;
    }
}
