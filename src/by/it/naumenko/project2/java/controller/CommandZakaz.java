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

public class CommandZakaz extends Command {
    @Override
    Actions exequit(HttpServletRequest request, HttpServletResponse response) throws SQLException, SiteException, LoginException, NoSuchAlgorithmException {

        MyDAO<Zakaz> myDAOZakaz = new MyDAO<>(new Zakaz(),"zakaz");
        List<Zakaz> zakazs = myDAOZakaz.getAll();
        request.setAttribute("zakaz", zakazs);
        Users user = Util.findUser(request);

        if (zakazs.size()==0){
            String pusto = "Заказов нет, ждите";
            request.setAttribute("pusto",pusto);
        }

        if (Form.isPost(request)) {
//            Users user = Util.findUser(request);
            long id_zakaz = Form.getLong(request,"id_zakaz");
            String tovar = Form.getString(request,"tovar");
            double priceHt = Form.getDouble(request, "priceHt");
            double kolTovar = Form.getDouble(request, "kolTovar");
            String biscuit = Form.getString(request, "biscuit");
            String nachinka = Form.getString(request, "nachinka");
            String decoration = Form.getString(request, "decoration");
            String cream = Form.getString(request, "cream");
            double doplatadecor = Form.getDouble(request,"doplatadecor");
            String status = Form.getString(request,"status");
            Zakaz zakaz = new Zakaz(id_zakaz,tovar,priceHt,kolTovar,biscuit,nachinka,decoration,cream,priceHt*kolTovar+doplatadecor,user.getId_user(),1,status);
            MyDAO<Zakaz> zakazMyDAO = new MyDAO<>(new Zakaz(),"zakaz");
            if (request.getParameter("update") != null) {
                if (zakazMyDAO.update(zakaz)) {
                    return Actions.ZAKAZ;
                }
            }
        }
        return Actions.ZAKAZ;
    }
}
