package by.it.naumenko.project.java.controller;

import by.it.naumenko.project.java.beens.Cake;
import by.it.naumenko.project.java.dao.MyDAO;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

class CommandCreateCake extends Command {
    @Override
    public Actions exequit(HttpServletRequest request, HttpServletResponse response) throws SiteException, LoginException, NoSuchAlgorithmException, SQLException {

        if (Form.isPost(request)) {
            String name_cake = Form.getString(request,"name_cake");
            int size_cake = (int) Form.getLong(request,"size_cake");
            double weight_cake = Form.getDouble(request,"weight_cake");
            String bescuit = Form.getString(request,"bescuit");
            String decoration = Form.getString(request,"decoration");
            double price_cake = Form.getDouble(request,"price_cake");
            Cake cake = new Cake(0,name_cake,size_cake,weight_cake,
                            bescuit,decoration,"Крем-чиз",price_cake);

            MyDAO<Cake> cakeMyDAO = new MyDAO<>(new Cake(),"cake");
            cakeMyDAO.create(cake);
            return Actions.PROFILE;

        }
        return Actions.CREATE;
    }
}
