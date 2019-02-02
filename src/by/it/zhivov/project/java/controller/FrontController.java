package by.it.zhivov.project.java.controller;

import by.it.zhivov.project.java.beans.Role;
import by.it.zhivov.project.java.dao.Dao;

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
            List<Role> roles = Dao.getDao().role.getALL();
            getServletContext().setAttribute("roles", roles);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
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
        Action action = Action.define(req);
        Action next = null;
        try {
            next = action.cmd.execute(req);

        } catch (Exception e) {
            StringBuilder message = new StringBuilder(e.toString());
            message.append("<p>");
            for (StackTraceElement element : e.getStackTrace()) {
                message.append(element.toString()).append("<br>");
            }
            req.setAttribute("message", message);
            toJsp(req, resp, Action.ERROR.getJsp());
        }


        if (next == null || next == action) {
            toJsp(req, resp, action.getJsp());
        } else resp.sendRedirect("do?command=" + next.toString().toLowerCase());
    }

    private void toJsp(HttpServletRequest req, HttpServletResponse resp, String jsp) throws ServletException, IOException {
        ServletContext servletContext = req.getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(jsp);
        requestDispatcher.forward(req, resp);
    }
}
