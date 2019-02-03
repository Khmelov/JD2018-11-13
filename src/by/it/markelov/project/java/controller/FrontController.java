package by.it.markelov.project.java.controller;

import by.it.markelov.project.java.beans.Role;
import by.it.markelov.project.java.dao.DAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class FrontController extends HttpServlet {


    @Override
    public void init() throws ServletException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            List<Role> roles = DAO.getInstance().role.getAll("");
            getServletContext().setAttribute("roles", roles);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Action action = ActionDefiner.define(req);
        Action next = null;
        try {
            next = action.cmd.execute(req);
        } catch (Exception e) {
            req.setAttribute("message", e.toString());

            ServletContext servletContext = req.getServletContext();
            RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(Action.ERROR.getJsp());
            requestDispatcher.forward(req, resp);

        }
        if (next == null || next == action) {
            ServletContext servletContext = req.getServletContext();
            RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(action.getJsp());
            requestDispatcher.forward(req, resp);
        }
        else
            resp.sendRedirect("do?command="+next.toString().toLowerCase());
    }
}
