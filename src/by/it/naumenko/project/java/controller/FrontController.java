package by.it.naumenko.project.java.controller;

import javax.security.auth.login.LoginException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public class FrontController extends HttpServlet {

    public void init() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            process(req, resp);
        } catch (LoginException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            process(req, resp);
        } catch (LoginException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, LoginException, NoSuchAlgorithmException {

        Actions action = ActionDefiner.define(req);
        Actions next = null;
        try {
            next = action.command.exequit(req,resp);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (SiteException e) {
            e.printStackTrace();
        }
        if (next == null || next == action) {
            ServletContext servletContext = req.getServletContext();
            RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(action.getJsp());
            requestDispatcher.forward(req, resp);
        }
        else
            resp.sendRedirect("do?command="+next.toString().toLowerCase());


//        ServletContext servletContext = getServletContext();
//        RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/index.jsp");
//        dispatcher.forward(req,resp);

    }
}
