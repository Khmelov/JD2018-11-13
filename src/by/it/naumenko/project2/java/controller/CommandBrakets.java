package by.it.naumenko.project2.java.controller;

import by.it.naumenko.project2.java.beens.Users;
import by.it.naumenko.project2.java.beens.Zakaz;
import by.it.naumenko.project2.java.dao.MyDAO;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;

public class CommandBrakets extends Command {
    @Override
    Actions exequit(HttpServletRequest request, HttpServletResponse response) throws SQLException, SiteException, LoginException, NoSuchAlgorithmException {

        MyDAO<Zakaz> myDAOZakaz = new MyDAO<>(new Zakaz(),"zakaz");
        List<Zakaz> zakaz = myDAOZakaz.getAll();
        request.setAttribute("zakaz", zakaz);

        if (Util.checkUser(request)) {
            Users user = Util.findUser(request);
            System.out.println(user.getId_user());

//            if (Form.isPost(request)) {
//                String kategoriya = Form.getString(request,"kategoriya");
//                //double price = Form.getDouble(request, "price");
//                String biscuit = Form.getString(request, "biscuit");
//                String nachinka = Form.getString(request, "nachinka");
//                String decoration = Form.getString(request, "decoration");
//                String cream = Form.getString(request, "cream");
//                Cake cake = new Cake(0, kategoriya, 40, biscuit, nachinka, decoration, cream);
//                return Actions.BRAKETS;
//            }
        }
        return Actions.BRAKETS;
    }
}
