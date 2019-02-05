package by.it.karnilava.project05.java.controller;

import by.it.karnilava.project05.java.beans.Account;
import by.it.karnilava.project05.java.beans.Client;
import by.it.karnilava.project05.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

class CmdLogin extends Cmd {
    @Override
    Action execute(HttpServletRequest req) {
        if (req.getMethod().equalsIgnoreCase("POST")) {
            String passport = req.getParameter("passport");
            String password = req.getParameter("password");
            DAO dao = DAO.getDao();
            HttpSession session = req.getSession();
            String sql = "WHERE `passport`=\"" + passport + "\" AND `password`=\"" + password + "\"";
            List<Client> clients = dao.client.getAll(sql);
            if (clients.isEmpty()) {
                return Action.ERROR;
            } else {
                if (passport.equals("9999999A999AA9")) {
//                    clients=dao.client.getAll("WHERE `idRoles`=1");
//                    req.getSession().setAttribute("clients", clients);
//                    req.getRequestDispatcher("adminprofile.jsp").forward(req,resp);
                    AdminForm adminForm=new AdminForm();
                    session.setAttribute("admin",clients.get(0));
                    session.setAttribute("clients", dao.client.getAll("WHERE `idRoles`=1"));



                    return Action.ADMINPROFILE;

                }
               else {

                   Client client=dao.client.read(clients.get(0).getId());
                   String fullName=client.getFirstName()+" "+client.getLastName();
                   req.getSession().setAttribute("fullName", fullName);

                   req.getSession().setAttribute("client", clients.get(0));
                    req.getSession().setAttribute("id", clients.get(0).getId());
                    req.getSession().setAttribute("firstName", clients.get(0).getFirstName());
                    req.getSession().setAttribute("lastName", clients.get(0).getLastName());
                    req.getSession().setAttribute("passport", clients.get(0).getPassport());

                    req.getSession().setAttribute("accounts", dao.account.getAllAcconts(client));



                    return Action.PROFILE;
                }
            }


        }
        return Action.LOGIN;
    }


}
