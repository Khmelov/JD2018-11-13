package by.it.karnilava.project04;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloWorld extends HttpServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        super.service(req, res);
        res.setContentType("text/html");
        //получаем поток вывода
        PrintWriter out = res.getWriter();
        out.println("Hello world! (from it-academy)");
        out.flush();
    }


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter prn=resp.getWriter();
        prn.println("<br><br>Hello world!!");
        prn.println("<br>URI:"+req.getRequestURI());
        prn.flush();
    }}