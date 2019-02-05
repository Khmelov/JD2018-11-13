package by.it.naumenko.project2.java.controller;

import by.it.naumenko.project2.java.beens.Basket;
import by.it.naumenko.project2.java.beens.Cake;
import by.it.naumenko.project2.java.beens.Users;
import by.it.naumenko.project2.java.dao.MyDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

class CommandIndex extends Command {
    @Override
    Actions exequit(HttpServletRequest request, HttpServletResponse response) throws SQLException, SiteException {

        Users user = Util.findUser(request);


        MyDAO<Cake> myDAOCake = new MyDAO<>(new Cake(),"cake");
        List<Cake> cakes = myDAOCake.getAll();
        request.setAttribute("cakes", cakes);

        if (Form.isPost(request)) {
            System.out.println(user.getId_user());
            String kategoriya = Form.getString(request,"kategoriya");
            double priceHt = Form.getDouble(request, "priceHt");
            double kolTovar = Form.getDouble(request, "kolTovar");
            String biscuit = Form.getString(request, "biscuit");
            String nachinka = Form.getString(request, "nachinka");
            String decoration = Form.getString(request, "decoration");
            String cream = Form.getString(request, "cream");
            MyDAO<Basket> basketMyDAO = new MyDAO<>(new Basket(),"basket");
            Basket basket = new Basket(0,kategoriya,priceHt,kolTovar,biscuit,nachinka,decoration,cream, priceHt*kolTovar,user.getId_user());
            if(basketMyDAO.create(basket))
                return Actions.BASKET;
            else
                return Actions.ERROR;
        }
        return Actions.INDEX;
    }
}
