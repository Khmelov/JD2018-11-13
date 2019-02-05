package by.it.vchernetski.project.java.controller;

import by.it.vchernetski.project.java.beans.Car;
import by.it.vchernetski.project.java.dao.MyDAO;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class CmdDeletecar implements Cmd {
    static long[] ids;
    static String[] idsS;

    @Override
    public Action execute(HttpServletRequest request) throws Exception {
        Car car = new Car();
        String filename = request.getServletContext().getRealPath("/image/del.txt");
        try (BufferedReader rd = new BufferedReader(new FileReader(filename))) {
            if (rd.ready()) {
                idsS = rd.readLine().split(" ");
                int i = 0;
                ids = new long[idsS.length];
                for (String id : idsS) {
                    ids[i++] = Long.parseLong(id);
                }
            }
        }
        List<Car> forDel = new ArrayList<>();
        MyDAO<Car> dao = MyDAO.getDao();
        dao.setBean(car);
        for (long i : ids) {
            List<Car> all = dao.getAll(" WHERE id = '" + i + "'");
            forDel.add(all.get(0));
        }
        request.setAttribute("delcars", forDel);
        if (request.getParameter("Delcar") != null) {
            String idd = request.getParameter("idd");
            car.setId(Long.parseLong(idd));
            dao.setBean(car);
            dao.delete();
            try (BufferedWriter wr = new BufferedWriter(new FileWriter(filename))) {
                for (String str:idsS) {
                    if(!idd.equalsIgnoreCase(str)) wr.write(str+" ");
                }

            }
            return Action.DONE;
        }
        return null;
    }
}
