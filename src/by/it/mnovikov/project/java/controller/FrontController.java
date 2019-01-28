//package by.it.mnovikov.project.java.controller;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * Created by user on 24.01.2019.
// */
//class FrontController extends HttpServlet {
//
//    @Override
//    public void init() throws ServletException {
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        process(req, resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        process(req, resp);
//    }
//
//    private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Action action = ActionDefiner.define(req);
//        Action execute = action.cmd.execute(req);
//        //dobavit'
//        //
//        //
//        ServletContext servletContext = req.getServletContext();
//        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(action.getJsp());
//        requestDispatcher.forward(req, resp);
//
//        resp.sendRedirect("do?command" + next.toString().toLowerCase());
//    }
//}
