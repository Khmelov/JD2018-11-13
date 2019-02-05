package by.it.nickgrudnitsky.project.java.controller;


import by.it.nickgrudnitsky.project.java.beans.Streamer;
import by.it.nickgrudnitsky.project.java.beans.Viewer;
import by.it.nickgrudnitsky.project.java.dao.MyDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

class CmdEditStreamers extends Cmd {
    @Override
    Action execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException, SiteException {
        if (Util.checkStreamer(req)) {
            MyDao dao = MyDao.getDao();
            if (Form.isPost(req)) {
                long id = Form.getLong(req, "id");
                Streamer read = dao.streamer.read(id);
                String password = read.getPassword();
                String channelname = Form.getString(req, "channelname");
                String email = Form.getString(req, "email");
                long role = Form.getLong(req, "role");
                Streamer streamer = new Streamer(email, password, channelname, role);
                streamer.setId(id);
                if (req.getParameter("Update") != null) {
                    dao.streamer.update(streamer);
                }
                if (req.getParameter("Delete") != null) {
                    dao.streamer.delete(streamer);
                }
            }
            List<Streamer> streamers = dao.streamer.getAll();
            req.setAttribute("streamers", streamers);
        }
        return Action.EDITSTREAMERS;
    }
}
