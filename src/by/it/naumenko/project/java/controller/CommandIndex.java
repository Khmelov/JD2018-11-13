package by.it.naumenko.project.java.controller;

import by.it.naumenko.project.java.beens.Cake;
import by.it.naumenko.project.java.dao.MyDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

class CommandIndex extends Command {
    @Override
    Actions exequit(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        MyDAO<Cake> myDAOCake = new MyDAO<>(new Cake(),"cake");
        List<Cake> listCakes = myDAOCake.getAll();
        request.setAttribute("cake", listCakes);
        return Actions.INDEX;
    }
}
