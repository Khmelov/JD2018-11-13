package by.it.vchernetski.project.java.controller;

import by.it.vchernetski.project.java.beans.Car;
import by.it.vchernetski.project.java.dao.MyDAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

class CmdIndex implements Cmd{
    @Override
    public Action execute(HttpServletRequest request)throws Exception {
        MyDAO<Car> dao = MyDAO.getDao();
        Car car = new Car();
        dao.setBean(car);
        List<Car> all = dao.getAll();
        request.setAttribute("cars",all);
        return null;
    }
}
