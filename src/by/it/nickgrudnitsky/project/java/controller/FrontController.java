package by.it.nickgrudnitsky.project.java.controller;


import by.it.nickgrudnitsky.project.java.beans.Role;
import by.it.nickgrudnitsky.project.java.dao.MyDao;

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
            next = action.cmd.execute(req, resp);
        } catch (Exception e) {
            StringBuilder message = new StringBuilder(e.toString());
            message.append("<p>");
            for (StackTraceElement element : e.getStackTrace()) {
                if (element.getClass().getName().contains("HttpServlet"))
                    break;
                message.append(element.toString()).append("<br>");
            }
            req.setAttribute("message", message);
            toJsp(req, resp, Action.ERROR.getJsp());
        }

        if (next == null || next == action) {
            toJsp(req, resp, action.getJsp());
        } else {
            resp.setHeader("Cache-Control", "no-store");
            resp.setHeader("Cache-Control", "no-cache");
            resp.sendRedirect("do?command=" + next.toString().toLowerCase());
        }
    }

    private void toJsp(HttpServletRequest req, HttpServletResponse resp, String jsp) throws ServletException, IOException {
        ServletContext servletContext = req.getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(jsp);
        requestDispatcher.forward(req, resp);
    }

    @Override
    public void init() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            List<Role> roles = MyDao.getDao().role.getAll();
            getServletContext().setAttribute("roles" , roles);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

}
