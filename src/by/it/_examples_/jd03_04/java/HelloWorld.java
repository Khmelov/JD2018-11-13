package by.it._examples_.jd03_04.java;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloWorld extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter prn=resp.getWriter();
        prn.println("<br><br>Hello world!!");
        prn.println("<br>URI:"+req.getRequestURI());
        prn.flush();
    }

}
