package by.it.karnilava.project05.java.controller;

import by.it.karnilava.project05.java.beans.Client;
import by.it.karnilava.project05.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

class CmdLogin extends Cmd {
    @Override
    Action execute(HttpServletRequest req) {
        if (req.getMethod().equalsIgnoreCase("POST")) {
            String passport = req.getParameter("passport");
            String password = req.getParameter("password");
            DAO dao = DAO.getDao();
            String sql = "WHERE `passport`=\"" + passport + "\" AND `password`=\"" + password + "\"";
            List<Client> clients = dao.client.getAll(sql);
            if (clients.isEmpty()) {
                return Action.ERROR;
            } else {
                if (passport.equals("9999999A999AA9")) {
                    clients=dao.client.getAll("WHERE `idRoles`=1");
                    req.getSession().setAttribute("client", clients);


                    return Action.ADMINPROFILE;

                }
               else {
                    req.getSession().setAttribute("client", clients);
                    req.getSession().setAttribute("id", clients.get(0).getId());
                    req.getSession().setAttribute("firstName", clients.get(0).getFirstName());
                    req.getSession().setAttribute("lastName", clients.get(0).getLastName());
                    req.getSession().setAttribute("passport", clients.get(0).getPassport());
                    return Action.PROFILE;
                }
            }


        }
        return Action.LOGIN;
    }
}
