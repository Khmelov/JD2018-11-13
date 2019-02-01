package by.it.seroglazov.project.java.controller;

import by.it.seroglazov.project.java.MyConstants;
import by.it.seroglazov.project.java.dao.Config;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;

public class FrontController extends HttpServlet {

    @Override
    public void init() throws ServletException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Can't find jdbc.Driver class: " + e.getMessage());
        }
        ServletContext servletContext = getServletContext();
        //InputStream resourceAsStream = servletContext.getResource("recipes.xml");


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
        Action action = Action.define(req);
        Action next = null;
        try {
            next = action.cmd.execute(req);
        } catch (Exception e) {
            req.getSession().setAttribute("message", e.getMessage());
            toJsp(req, resp, Action.ERROR.getJsp());
        }
        if (next == null || next == action) {
            toJsp(req, resp, action.getJsp());
        } else
            resp.sendRedirect("do?command=" + next.toString().toLowerCase());
    }

    private void toJsp(HttpServletRequest req, HttpServletResponse resp, String jsp) throws ServletException, IOException {
        ServletContext servletContext = req.getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(jsp);
        resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        resp.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        resp.setDateHeader("Expires", 0); // Proxies.
        requestDispatcher.forward(req, resp);
        return;
    }


}