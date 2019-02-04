package by.it.vchernetski.project.java.controller;

import by.it.vchernetski.project.java.beans.Role;
import by.it.vchernetski.project.java.dao.MyDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Base64;
import java.util.List;

public class FrontController extends HttpServlet {
    protected static HttpServletResponse response;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    public void init() throws ServletException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        response=resp;
        Action action = Action.define(req);
        Action next = null;
        try {
            next = action.cmd.execute(req);

        } catch (Exception e) {
            StringBuilder message = new StringBuilder(e.toString());
            message.append("<p>");
            for (StackTraceElement element : e.getStackTrace()) {
                if (element.getClass().getName().contains("HttpServlet"))
                    break;
                message.append(element.toString()).append("<br>");
            }
            req.setAttribute("message", message);
            ServletContext servletContext = req.getServletContext();
            RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(Action.ERROR.getjsp());
            requestDispatcher.forward(req, resp);
        }
        if (next == null || next == action) {
            resp.setHeader("Cache-Control", "no-cache");
            ServletContext servletContext = req.getServletContext();
            RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(action.getjsp());
            requestDispatcher.forward(req, resp);
        } else
            resp.sendRedirect("do?command=" + next.toString().toLowerCase());
    }
}
