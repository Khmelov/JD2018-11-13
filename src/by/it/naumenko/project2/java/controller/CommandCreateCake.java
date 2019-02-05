package by.it.naumenko.project2.java.controller;


import by.it.naumenko.project2.java.beens.Cake;
import by.it.naumenko.project2.java.dao.MyDAO;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

class CommandCreateCake extends Command {
    @Override
    public Actions exequit(HttpServletRequest request, HttpServletResponse response) throws SiteException, LoginException, NoSuchAlgorithmException, SQLException {

        if (Form.isPost(request)) {
            String kategoriya = Form.getString(request,"kategoriya");
            double price =  Form.getDouble(request,"price");
            String biscuit = Form.getString(request,"biscuit");
            String nachinka = Form.getString(request,"nachinka");
            String decoration = Form.getString(request,"decoration");
            String cream = Form.getString(request,"cream");
            Cake cake = new Cake(0,kategoriya,price,biscuit,
                            nachinka,decoration,cream);

            MyDAO<Cake> cakeMyDAO = new MyDAO<>(new Cake(),"cake");
            cakeMyDAO.create(cake);
            return Actions.PROFILE;

        }
        return Actions.CREATE;
    }
}
