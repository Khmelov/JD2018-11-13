package by.it.vchernetski.project.java.controller;

import by.it.vchernetski.project.java.beans.Car;
import by.it.vchernetski.project.java.beans.Garage;
import by.it.vchernetski.project.java.beans.User;
import by.it.vchernetski.project.java.dao.MyDAO;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

class CmdIndex implements Cmd{
    @Override
    public Action execute(HttpServletRequest request)throws Exception {
        User user = Util.findUser(request);
        if(user==null){
            return Action.LOGIN;
        }
        String filename = request.getServletContext().getRealPath("/image/del.txt");
        File file = new File(filename);
        if(!file.exists()) file.createNewFile();
        MyDAO<Garage> daog = MyDAO.getDao();
        daog.setBean(new Garage());
        List<Garage> garages = daog.getAll(" WHERE users_id = '"+user.getId()+"'");
        MyDAO<Car> dao = MyDAO.getDao();
        Car car = new Car();
        dao.setBean(car);
        List<Car> all = new ArrayList<>();
        for (Garage garage:garages) {
            all.addAll(dao.getAll(" WHERE garages_id = '"+garage.getId()+"'"));
        }
        request.setAttribute("cars",all);
        if(request.getParameter("Deletecar")!=null){
            try(BufferedWriter wr = new BufferedWriter(new FileWriter(filename,true)); BufferedReader rd = new BufferedReader(new FileReader(filename))){
                StringBuilder str = new StringBuilder();
                String[] ids;
                boolean exist=true;
               if (rd.ready()){
                   str.append(rd.readLine());
               }
               if(str!=null) {
                   ids = str.toString().split(" ");
                   for (String id: ids) {
                        if(id.equalsIgnoreCase(request.getParameter("id"))) exist=false;
                   }
               }
               if(exist) wr.write(request.getParameter("id")+" ");
            }
            return Action.DONE;
        }
        return null;
    }
}
