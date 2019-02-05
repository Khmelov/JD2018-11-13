package by.it.karnilava.project05.java.controller;

import by.it.karnilava.project05.java.beans.Client;
import by.it.karnilava.project05.java.dao.DAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AdminForm extends FrontController{
    public AdminForm() {
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DAO dao=DAO.getDao();
        List<Client> clients= dao.client.getAll("WHERE `idRoles`=1");
        req.getSession().setAttribute("clients", clients);
        req.getRequestDispatcher("adminprofile.jsp").forward(req,resp);




    }
}
