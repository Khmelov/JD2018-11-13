package by.it.nickgrudnitsky.project.java.controller;

import by.it.nickgrudnitsky.project.java.beans.Role;
import by.it.nickgrudnitsky.project.java.beans.Streamer;
import by.it.nickgrudnitsky.project.java.beans.Viewer;
import by.it.nickgrudnitsky.project.java.dao.MyDao;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

class CmdEditViewers extends Cmd {
    @Override
    Action execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException, SiteException {
        if (Util.checkViewer(req)){

            if (Form.isPost(req)) {
                String nickname = Form.getString(req, "nickname", "[A-Za-z0-9А-Яа-я]+");
                String password = Form.getString(req, "password", "[A-Za-z0-9*$%#]+");
                String email = Form.getString(req, "email", "[A-Za-z0-9]+@[A-Za-z0-9]+.[A-Za-z0-9]+");
                String roleString = req.getParameter("role");
                long role = Long.parseLong(roleString);
                Viewer viewer = new Viewer(email, password, nickname, role);

                if (req.getParameter("Update")!=null){
                    MyDao.getDao().viewer.update(viewer);
                }

                if (req.getParameter("Delete")!=null){
                    MyDao.getDao().viewer.delete(viewer);
                }
            }

            List<Viewer> viewers = MyDao.getDao().viewer.getAll();
            List<Role> roles = MyDao.getDao().role.getAll();
            req.setAttribute("viewers", viewers);
            req.setAttribute("roles", roles);
        }

        return Action.EDITVIEWERS;
    }
}
