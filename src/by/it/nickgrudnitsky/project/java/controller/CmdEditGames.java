package by.it.nickgrudnitsky.project.java.controller;

import by.it.nickgrudnitsky.project.java.beans.Game;
import by.it.nickgrudnitsky.project.java.beans.Viewer;
import by.it.nickgrudnitsky.project.java.dao.MyDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

class CmdEditGames extends Cmd {
    @Override
    Action execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException, SiteException {

            MyDao dao = MyDao.getDao();
            if (Form.isPost(req)) {
                long id = Form.getLong(req, "id");
                String gameName = Form.getString(req, "game");
                String link = Form.getString(req, "link");
                Game game = new Game(gameName, link);
                game.setId(id);
                if (req.getParameter("Update") != null) {
                    dao.game.update(game);
                }
                if (req.getParameter("Delete") != null) {
                    dao.game.delete(game);
                }
            }

            List<Game> games = dao.game.getAll();
            req.setAttribute("games", games);

        return Action.EDITGAMES;
    }
}
