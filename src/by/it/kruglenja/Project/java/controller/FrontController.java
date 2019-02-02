package by.it.kruglenja.Project.java.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class FrontController extends HttpServlet {
    @Override
    public void init() throws ServletException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
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
        Action action = Action.definer(req);
        Action next = null;
        try {
            next = action.cmd.execute(req);
        } catch (Exception e) {
            req.setAttribute("message", e.toString());
            getJsp(req, resp, Action.INDEX);

        }
        if (next == null || next == action) {
            getJsp(req, resp, action);
        }
        resp.sendRedirect("do?command=" + next.toString().toLowerCase());
    }

    private void getJsp(HttpServletRequest req, HttpServletResponse resp, Action error) throws ServletException, IOException {
        ServletContext servletContext = req.getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(error.getJsp());
        requestDispatcher.forward(req, resp);
    }
}