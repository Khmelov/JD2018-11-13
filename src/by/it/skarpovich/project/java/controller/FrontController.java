package by.it.skarpovich.project.java.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

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
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //String generatedPassword=Crypto.encodePassword(password);
        String generatedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        //Base64 decoding
//        byte[] decodedBytes = Base64.getDecoder().decode(password);
//        String decodedString = new String(decodedBytes);

        //MD5 encoding
//
//        // Start password to MD5
//        String generatedPassword = null;
//        try {
//            // Create MessageDigest instance for MD5
//            MessageDigest md = MessageDigest.getInstance("MD5");
//            //Add password bytes to digest
//            md.update(password.getBytes());
//            //Get the hash's bytes
//            byte[] bytes = md.digest();
//            //This bytes[] has bytes in decimal format;
//            //Convert it to hexadecimal format
//            StringBuilder sb = new StringBuilder();
//            for(int i=0; i< bytes.length ;i++)
//            {
//                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
//            }
//            //Get complete hashed password in hex format
//            generatedPassword = sb.toString();
//        }
//        catch (NoSuchAlgorithmException e)
//        {
//            e.printStackTrace();
//        }
//        // System.out.println(generatedPassword);
//// end password to MD5
        //Creating two cookies
        Cookie c1 = new Cookie("username", username);
        Cookie c2 = new Cookie("password", generatedPassword);
        c1.setMaxAge(60);
        c2.setMaxAge(60);
        //Adding the cookies to response header
        resp.addCookie(c1);
        resp.addCookie(c2);

        process(req, resp);

    }

    private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Action action = Action.define(req);
        Action next = null;
        try {
            next = action.cmd.execute(req);
        } catch (Exception e) {
            req.setAttribute("message", e.toString());

            toJsp(req, resp, Action.ERROR.getJsp());
        }

        if (next == null || next == action) {
            resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // for HTTP 1.1.
            toJsp(req, resp, action.getJsp());
        } else
            resp.sendRedirect("do?command=" + next.toString().toLowerCase());
    }

    private void toJsp(HttpServletRequest req, HttpServletResponse resp, String jsp) throws ServletException, IOException {
        ServletContext servletContext = req.getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(jsp);
        requestDispatcher.forward(req, resp);
    }
}
