package by.it.nickgrudnitsky.project.java.controller;

import by.it.nickgrudnitsky.project.java.beans.Game;
import by.it.nickgrudnitsky.project.java.dao.MyDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

class CmdIndex extends Cmd {
    @Override
    Action execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        List<Game> games = MyDao.getDao().game.getAll();
        req.setAttribute("games", games);
        return null;
    }
}
