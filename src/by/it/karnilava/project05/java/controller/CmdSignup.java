package by.it.karnilava.project05.java.controller;

import by.it.karnilava.project05.java.beans.Client;
import by.it.karnilava.project05.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

class CmdSignup extends Cmd{
    @Override
    Action execute(HttpServletRequest req) throws SQLException, SiteException {
        if (Form.isPost(req)){
            String passport = Form.getString(req,"passport","[0-9]{7}[A-Z]{1}[0-9]{3}[A-Z]{2}[0-9]{1}");
            String firstName = Form.getString(req,"firstName","[A-ZА-Я][a-zа-я]*");
            String lastName = Form.getString(req,"lastName","[A-ZА-Я][a-zа-я]*");
            String password = Form.getString(req,"password", "[A-Za-z0-9]{4,}");
            Client client = new Client(0,passport,firstName,lastName,password,1);
            DAO dao =DAO.getDao();
          if (dao.client.create(client))
              req.getSession().setAttribute("client",client);
            String fullName=client.getFirstName()+" "+client.getLastName();
            req.getSession().setAttribute("fullName", fullName);
              return Action.PROFILE;

        }
        return Action.SIGNUP;
    }
}
