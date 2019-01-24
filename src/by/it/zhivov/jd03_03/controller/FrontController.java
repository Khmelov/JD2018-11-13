//package by.it.zhivov.project.controller;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//public class FrontController extends HttpServlet {
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
//    private void process(HttpServletRequest req, HttpServletResponse resp) {
//        Action action = ActionDefiner.define(req);
//        Action next = action.cmd.execute(req);
//        ServletContext servletContext = req.getServletContext();
//        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(action);
//    }
//}
