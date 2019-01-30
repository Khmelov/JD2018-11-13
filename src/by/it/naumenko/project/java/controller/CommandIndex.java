package by.it.naumenko.project.java.controller;

import by.it.naumenko.project.java.beens.Cake;
import by.it.naumenko.project.java.dao.MyDAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

class CommandIndex extends Command {
    @Override
    Actions exequit(HttpServletRequest request) throws SQLException {
        MyDAO<Cake> myDAOCake = new MyDAO<>(new Cake(),"cake");
        List<Cake> listCakes = myDAOCake.getAll();
        for (int i = 0; i < listCakes.size(); i++) {

            Cake cake = listCakes.get(0);
            request.getSession().setAttribute("cake", cake);

        }
        return Actions.INDEX;
    }
}
