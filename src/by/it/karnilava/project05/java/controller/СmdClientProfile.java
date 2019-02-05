package by.it.karnilava.project05.java.controller;

import by.it.karnilava.project05.java.beans.Client;
import by.it.karnilava.project05.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;

public class СmdClientProfile extends Cmd{
    @Override
    Action execute(HttpServletRequest req) throws SiteException {
        DAO dao = new DAO();

        if (Form.isPost(req)){
            if (Form.getString(req,"logout")!=null){
                req.getSession().invalidate();
                return Action.LOGIN;
            }
        }

      long id = (int) req.getSession().getAttribute("id");
        Client client= dao.client.read(id);
        String fullName=client.getFirstName()+" "+client.getLastName();
        req.getSession().setAttribute("fullName", fullName);


        req.getSession().setAttribute("accounts", dao.account.getAllAcconts(client));
        return Action.CLIENTPROFILE;
    }
}
