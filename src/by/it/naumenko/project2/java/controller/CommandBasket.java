package by.it.naumenko.project2.java.controller;

import by.it.naumenko.project2.java.beens.Basket;
import by.it.naumenko.project2.java.beens.Users;
import by.it.naumenko.project2.java.beens.Zakaz;
import by.it.naumenko.project2.java.dao.MyDAO;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;

public class CommandBasket extends Command {
    @Override
    Actions exequit(HttpServletRequest request, HttpServletResponse response) throws SQLException, SiteException, LoginException, NoSuchAlgorithmException {

        Users user = Util.findUser(request);
        MyDAO<Basket> myDAOBasket = new MyDAO<>(new Basket(),"basket");
        String where = String.format(" where id_user='%s'",user.getId_user());
        List<Basket> basket = myDAOBasket.getAll(where);
        request.setAttribute("basket", basket);

        if (basket.size()==0){
            String pusto = "Корзина пользователя "+user.getLogin()+" пустая ";
            request.setAttribute("pusto",pusto);
        }

        if (Form.isPost(request)) {
            long id_basket = Form.getLong(request,"id_basket");
            String tovar = Form.getString(request,"tovar");
            double priceHt = Form.getDouble(request, "priceHt");
            double kolTovar = Form.getDouble(request, "kolTovar");
            String biscuit = Form.getString(request, "biscuit");
            String nachinka = Form.getString(request, "nachinka");
            String decoration = Form.getString(request, "decoration");
            String cream = Form.getString(request, "cream");
            MyDAO<Zakaz> zakazMyDAO = new MyDAO<>(new Zakaz(),"zakaz");
            Zakaz zakaz = new Zakaz(0,tovar,priceHt,kolTovar,biscuit,nachinka,decoration,cream,priceHt*kolTovar,user.getId_user(),1, "в процессе");

            Basket basket1 = new Basket(id_basket,tovar,priceHt,kolTovar,biscuit,nachinka,decoration,cream,priceHt*kolTovar,user.getId_user());
            if (request.getParameter("go") != null) {
                if(zakazMyDAO.create(zakaz)) {
                    myDAOBasket.delete(basket1);
                    return Actions.INDEX;
                }
            }

            if (request.getParameter("delete") != null) {
                if (myDAOBasket.delete(basket1))
                    return Actions.BASKET;
            }

            if (request.getParameter("update") != null) {
                if (myDAOBasket.update(basket1))
                    return Actions.BASKET;
            }

        }
        return Actions.BASKET;
    }
}
