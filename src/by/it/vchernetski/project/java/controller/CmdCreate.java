package by.it.vchernetski.project.java.controller;

import by.it.vchernetski.project.java.beans.Car;
import by.it.vchernetski.project.java.dao.MyDAO;

import javax.servlet.http.HttpServletRequest;

class CmdCreate implements Cmd{
   @Override
   public Action execute(HttpServletRequest request)throws Exception {
       if (Form.isPost(request)) {
           Car car = new Car();
           String model = request.getParameter("model");
           if(model.matches("[a-zA-Z0-9 -]{3,}")) {
               car.setModel(model);
           }
           else throw new MyException("invalid model");
           String color = request.getParameter("color");
           if(color.matches("[a-zA-Z-]{3,}")) {
               car.setColor(color);
           }
           else throw new MyException("invalid color");
           String year = request.getParameter("year");
           if(year.matches("[0-9]{4}")) {
               car.setYear(Integer.parseInt(year));
           }
           else throw new MyException("invalid year");
           String garage = request.getParameter("garage");
           if(garage.matches("[0-9]{1,2}")) {
               car.setGarages_id(Integer.parseInt(garage));
           }
           else throw new MyException("invalid garage");
           car.setId(0);
           MyDAO<Car> dao = MyDAO.getDao();
           dao.setBean(car);
           if(dao.create()){
               return Action.DONE;
           }
       }
       return Action.CREATE;
   }
}
