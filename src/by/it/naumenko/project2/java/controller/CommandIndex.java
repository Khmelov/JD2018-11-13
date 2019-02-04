package by.it.naumenko.project2.java.controller;

import by.it.naumenko.project2.java.beens.Zakaz;
import by.it.naumenko.project2.java.dao.MyDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

class CommandIndex extends Command {
    @Override
    Actions exequit(HttpServletRequest request, HttpServletResponse response) throws SQLException, SiteException {
//        long id_user;
//        if (Util.checkCookie(request) || Util.checkUser(request)){
//            Users user = Util.findUser(request);
//            id_user = user.getId_user();
//
//        }
//        else
//            id_user=0;
//
//        MyDAO<Cake> myDAOCake = new MyDAO<>(new Cake(),"cake");
//        List<Cake> cakes = myDAOCake.getAll();
//        request.setAttribute("cakes", cakes);
//        String where="WHERE `cake`.`kategoriya`='svatba'";
//        List<Cake> text = myDAOCake.getAll(where);
//        request.setAttribute("text",text);
//        double p = myDAOCake.getPrice("svatba");
//        request.setAttribute("p",p);
        if (Form.isPost(request)) {
            //System.out.println(id_user);
            String kategoriya = Form.getString(request,"kategoriya");
            //double price = Form.getDouble(request, "price");
            String biscuit = Form.getString(request, "biscuit");
            String nachinka = Form.getString(request, "nachinka");
            String decoration = Form.getString(request, "decoration");
            String cream = Form.getString(request, "cream");
            MyDAO<Zakaz> zakazMyDAO = new MyDAO<>(new Zakaz(),"zakaz");
            Zakaz zakaz = new Zakaz(0,kategoriya,40,3,biscuit,nachinka,decoration,cream, 40*3,2,1);
            zakazMyDAO.create(zakaz);
            if(zakazMyDAO.create(zakaz))
                return Actions.BRAKETS;
            else
                return Actions.ERROR;
        }
        return Actions.INDEX;
    }
}
